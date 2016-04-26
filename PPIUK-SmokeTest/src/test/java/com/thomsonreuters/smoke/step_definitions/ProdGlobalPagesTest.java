package com.thomsonreuters.smoke.step_definitions;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.ArrayList;

import com.thomsonreuters.pageobjects.pages.onePass.OnePassSignInPage;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import org.slf4j.LoggerFactory;
import com.thomsonreuters.pageobjects.common.CommonMethods;
import com.thomsonreuters.pageobjects.common.ExcelFileReader;
import com.thomsonreuters.pageobjects.otherPages.NavigationCobalt;
import com.thomsonreuters.pageobjects.pages.globalPage.GlobalCategoryPage;
import com.thomsonreuters.pageobjects.pages.header.WLNHeader;
import com.thomsonreuters.pageobjects.pages.pageCreation.HomePage;
import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document.AssetDocumentPage;
import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document.CaseDocumentPage;
import com.thomsonreuters.pageobjects.pages.urls.plcuk.KHDocumentPage;
import com.thomsonreuters.pageobjects.utils.CobaltUser;
import com.thomsonreuters.pageobjects.utils.OnepassLoginUtils;
import com.thomsonreuters.pageobjects.utils.globalPage.GlobalPageUtils;
import com.thomsonreuters.pageobjects.pages.globalPage.ChinaCategoryPage;
import com.thomsonreuters.pageobjects.pages.search.KnowHowSearchResultsPage;
import com.thomsonreuters.pageobjects.pages.legalUpdates.LegalUpdatesResultsPage;
import cucumber.api.Transpose;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import com.thomsonreuters.pageobjects.pages.landingPage.SearchScopeControl;
import org.openqa.selenium.WebElement;
import com.thomsonreuters.pageobjects.pages.folders.ResearchOrganizerPage;
import com.thomsonreuters.pageobjects.pages.search.SearchResultsPage;


public class ProdGlobalPagesTest extends BaseStepDef {

    protected static final org.slf4j.Logger LOG = LoggerFactory.getLogger(CommonMethods.class);

    private GlobalCategoryPage globalCategoryPage = new GlobalCategoryPage();
    private GlobalPageUtils globalPageUtils = new GlobalPageUtils();
    private WLNHeader wlnHeader = new WLNHeader();
    private CaseDocumentPage caseDocumentPage = new CaseDocumentPage();
    private AssetDocumentPage assetDocumentPage = new AssetDocumentPage();
    private HomePage homePage = new HomePage();
    private OnepassLoginUtils onepassLoginUtils = new OnepassLoginUtils();
    private NavigationCobalt navigationCobalt = new NavigationCobalt();
    private KHDocumentPage documentPagePLCUK = new KHDocumentPage();
	private ChinaCategoryPage chinaCategoryPage = new ChinaCategoryPage();
    private KnowHowSearchResultsPage knowHowSearchResultsPage = new KnowHowSearchResultsPage();
    private LegalUpdatesResultsPage legalUpdatesResultsPage = new LegalUpdatesResultsPage();
    private SearchScopeControl searchScopeControl = new SearchScopeControl();
    private CommonMethods commonMethods = new CommonMethods();
    private ResearchOrganizerPage researchOrganizerPage = new ResearchOrganizerPage();
    private SearchResultsPage searchResultsPage = new SearchResultsPage();
    private OnePassSignInPage onePassSignInPage = new OnePassSignInPage();
    
    private static final String XML_TAG = "plc.facet.practice.area";    
	private static String guid;
    private List<String> initialListOfCountries;	

    @Then("^the one pass login button is displayed$")
    public void theOnePassLoginButtonIsDisplayed() throws Throwable {
        onePassSignInPage.continueButton().isDisplayed();
    }



    @Then("^the document opens correctly$")
    public void theDocumentOpensCorrectly() throws Throwable {
        assertTrue("Document not present", documentPagePLCUK.isDocumentBlockPresent());
    }
  
	@Then("^the document belongs to \"(.*?)\" topic$")
	public void theDocumentBelongsToTopic(String facet) throws Throwable {
		assertTrue("The document doesn't belong to " + facet + " topic",
                globalPageUtils.getValuesOfTagFromXMLOfTheDocument(XML_TAG, guid).contains(facet));
	}
   
    @Then("^the user can open the first know how search result \"(.*)\"$")
    public void theUserCanOpenTheFirstKnowHowSearchResult(String arg1) throws Throwable {
    	chinaCategoryPage.waitForPageToLoad();
        knowHowSearchResultsPage.knowHowSearchResultTitle(arg1).click();
    }
  
    @When("^the user selects \"(.*?)\" tab and clicks on \"(.*?)\" link in \"(.*?)\" section$")
    public void theUserSelectsTabAndClicksOnLinkInSection(String tab, String linkText, String sectionName)
            throws Throwable {
        globalCategoryPage.waitForPageToLoad();
        homePage.specificTab(tab).click();
        globalCategoryPage.linkInSection(linkText, sectionName).click();
    }
   
    @Then("^the Category Page opens correctly$")
    public void theCategoryPageOpensCorrectly() throws Throwable {
        globalCategoryPage.waitForPageToLoad();
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(!globalCategoryPage.header().isEmpty()).overridingErrorMessage("Header is empty").isTrue();
        softly.assertThat(!globalCategoryPage.globalPageHeader().isEmpty())
                .overridingErrorMessage("Page header is empty").isTrue();
        softly.assertThat(!globalCategoryPage.globalPageBody().isEmpty()).overridingErrorMessage("Page body is empty")
                .isTrue();
        softly.assertThat(!globalCategoryPage.globalPageFooter().isEmpty()).overridingErrorMessage("Footer is empty")
                .isTrue();
        softly.assertAll();
    }
 
	@Then("^the \"(.*?)\" section includes only \"(.*?)\" topics$")
	public void theSectionIncludesOnlyTopics(String section, String country, List<String> topics) throws Throwable {
		chinaCategoryPage.waitForPageToLoad();
		SoftAssertions softly = new SoftAssertions();
		for (WebElement topic : chinaCategoryPage.chinaTopicsInThePracticeArea(section, country)) {
			softly.assertThat(topics.contains(topic.getText()))
					.overridingErrorMessage("China topics don't contain %s topic", topic.getText()).isTrue();
		}
		softly.assertAll();
	}

    @When("^the user selects the know how following parent facets with single selection$")
    public void theUserSelectsTheKnowHowFollowingParentFacetWithSingleSelection(List<String> facets) throws Throwable {
        WebElement cancelFilterButton = commonMethods.waitForElement(researchOrganizerPage.cancelByFilters(), 1000);
        if(cancelFilterButton != null){
            cancelFilterButton.click();
        }
        for (String facet : facets) {
            knowHowSearchResultsPage.knowHowFacetCheckbox(facet).click();
            assertTrue("Check box not selected..!", isCheckboxSeleted(facet));
        }
    }
 
    @When("^the user verifies that the know how following facet is selected and their count is equal to total count$")
    public void theUserVerifiesThatTheKnowHowFollowingFacetIsSelected(List<String> facets) throws Throwable {
        int facetCount = 0;
        String totalSearchCount = knowHowSearchResultsPage.knowHowSearchResultCount().getText();
        totalSearchCount = totalSearchCount.replaceAll("[^0-9]", "");
        int totalCount = Integer.parseInt(totalSearchCount);

        for (String facet : facets) {
            totalSearchCount = knowHowSearchResultsPage.facetCount(facet).getText().replaceAll("[^0-9]", "");;
            facetCount = facetCount + Integer.parseInt(totalSearchCount);
            assertTrue(knowHowSearchResultsPage.knowHowFacetCheckbox(facet).isSelected());
        }
        assertTrue("Facet Count " + facetCount + " not displayed..!", facetCount == totalCount);
    }
  
	@Then("^the user can open the first know how search result \"(.*?)\" and get document guid$")
	public void theUserCanOpenTheFirstKnowHowSearchResultAndGetDocumentGuid(String number) throws Throwable {
		WebElement document = searchResultsPage.searchResultPosition(number);
		guid = document.getAttribute("docguid");
		theUserCanOpenTheFirstKnowHowSearchResult(number);
	}    

    @Then("^the user is taken to the \"(.*?)\" web site in the same window and tab$")
    public void theUserIsTakenToTheWebSiteInTheSameWindowAndTab(String webSite) throws Throwable {
        globalCategoryPage.waitForPageToLoad();
        SoftAssertions softly = new SoftAssertions();
        theOnePassLoginButtonIsDisplayed();
        String url = globalCategoryPage.getCurrentUrl();
        LOG.info("Current Url" + globalCategoryPage.getCurrentUrl());
        softly.assertThat(globalCategoryPage.getCurrentUrl().contains(webSite))
                .overridingErrorMessage("The user is taken to the %s web site", globalCategoryPage.getCurrentUrl())
                .isTrue();
        softly.assertAll();
    }

    @Then("^user hovers over the country toggle dropdown$")
    public void userHoversOverTheCountryTogglePage() throws Throwable {
    	commonMethods.mouseOver(wlnHeader.countryToggleDropdownLink());
    }
 
    @Then("^the user selects \"(.*?)\"$")
    public void theUserSelects(String countryName) throws Throwable {
    	wlnHeader.countryLink(countryName).click();
        navigationCobalt.waitForPageToLoad();
    }
  
    @When("^the user clicks on Continue button$")
    public void theUserClicksOnContinueButton() throws Throwable {
        globalCategoryPage.waitForPageToLoad();
        globalPageUtils.clickOnContinueButton();
    }
 
    private boolean isCheckboxSeleted(String facet) {
        for (int i = 0; i < 3; i++) {
            if (!knowHowSearchResultsPage.knowHowFacetCheckbox(facet).isSelected()) {
                knowHowSearchResultsPage.practiceAreaFacetLabel().click();
                knowHowSearchResultsPage.knowHowFacetCheckbox(facet).click();
            } else {
                return true;
            }
        }
        return false;
    }

}
