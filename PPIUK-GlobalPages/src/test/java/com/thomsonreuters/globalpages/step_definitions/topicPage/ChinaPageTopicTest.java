package com.thomsonreuters.globalpages.step_definitions.topicPage;

import com.thomsonreuters.globalpages.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.common.CommonMethods;
import com.thomsonreuters.pageobjects.common.PageActions;
import com.thomsonreuters.pageobjects.pages.folders.ResearchOrganizerPage;
import com.thomsonreuters.pageobjects.pages.globalPage.ChinaCategoryPage;
import com.thomsonreuters.pageobjects.pages.landingPage.PracticalLawUKCategoryPage;
import com.thomsonreuters.pageobjects.pages.plPlusKnowHowResources.ListOfItemsDeliveryOptionsPage;
import com.thomsonreuters.pageobjects.pages.search.KnowHowSearchResultsPage;
import com.thomsonreuters.pageobjects.pages.search.SearchResultsPage;
import com.thomsonreuters.pageobjects.utils.globalPage.GlobalPageUtils;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.SoftAssertions;
import org.hamcrest.core.Is;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;

public class ChinaPageTopicTest extends BaseStepDef {

	private ChinaCategoryPage chinaCategoryPage = new ChinaCategoryPage();
	private GlobalPageUtils globalPageUtils = new GlobalPageUtils();
    private PracticalLawUKCategoryPage practicalLawUKCategoryPage = new PracticalLawUKCategoryPage();
    private PageActions pageActions = new PageActions();
    private SearchResultsPage searchResultsPage = new SearchResultsPage();
    private CommonMethods commonMethods = new CommonMethods();
    private ResearchOrganizerPage researchOrganizerPage = new ResearchOrganizerPage();
    private KnowHowSearchResultsPage knowHowSearchResultsPage = new KnowHowSearchResultsPage();
    private ListOfItemsDeliveryOptionsPage listOfItemsDeliveryOptionsPage = new ListOfItemsDeliveryOptionsPage();

    private static final String XML_TAG = "plc.facet.practice.area";

	@Then("^the list of resource types is displayed$")
	public void theListOfResourceTypesIsDisplayed() throws Throwable {
		SoftAssertions softly = new SoftAssertions();
//		softly.assertThat(chinaCategoryPage.resourceTypesInTopicPage().size() != 0)
//				.overridingErrorMessage("List of resource types is empty").isTrue();
//		for (int i = 0; i < chinaCategoryPage.resourceTypesInTopicPage().size(); i++) {
//			softly.assertThat(chinaCategoryPage.resourceTypesInTopicPage().get(i).isDisplayed())
//					.overridingErrorMessage(chinaCategoryPage.resourceTypesInTopicPage().get(i) + " is not displayed")
//					.isTrue();
//		}
//		softly.assertAll();
	}

	@Then("^the list of jurisdictions is not displayed$")
	public void theListOfJurisdictionsIsNotDisplayed() throws Throwable {
//		SoftAssertions softly = new SoftAssertions();
//		for (int i = 0; i < chinaCategoryPage.jurisdictionsTopicPage().size(); i++) {
//			softly.assertThat(chinaCategoryPage.jurisdictionsTopicPage().get(i).isDisplayed())
//					.overridingErrorMessage(chinaCategoryPage.jurisdictionsTopicPage().get(i) + " is displayed")
//					.isFalse();
//		}
//		softly.assertAll();
	}

	@Then("^the resources sections are displayed on the topic page$")
	public void theResourcesSectionsAreDisplayedOnTheTopicPage() throws Throwable {
		chinaCategoryPage.waitForPageToLoad();
		for (WebElement header : chinaCategoryPage.resourceHeadings()) {
			assertTrue("The " + header + "is not displayed", header.isDisplayed());
		}
	}

	@Then("^the \"(.*?)\" section includes only \"(.*?)\" topics$")
	public void theSectionIncludesOnlyTopics(String section, String country, List<String> topics) throws Throwable {
		chinaCategoryPage.waitForPageToLoad();
//		SoftAssertions softly = new SoftAssertions();
//		for (WebElement topic : chinaCategoryPage.chinaTopicsInThePracticeArea(section, country)) {
//			softly.assertThat(topics.contains(topic.getText()))
//					.overridingErrorMessage("China topics don't contain %s topic", topic.getText()).isTrue();
//		}
//		softly.assertAll();
	}

	@Then("^the document belongs to \"(.*?)\" topic$")
	public void theDocumentBelongsToTopic(String facet) throws Throwable {
		assertTrue("The document doesn't belong to " + facet + " topic",
                globalPageUtils.getValuesOfTagFromXMLOfTheDocument(XML_TAG).contains(facet));
	}

    @When("^the user runs a free text search for the query \"(.*)\"$")
    public void theUserRunsAFreeTextSearchForTheQuery(String query) throws Throwable {
        StringSelection stringSelection = new StringSelection(query);
        Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
        practicalLawUKCategoryPage.searchButton().isDisplayed();
        practicalLawUKCategoryPage.freeTextField().clear();
        if (query.contains("(") || query.contains(")") || query.contains("&")) {
            clpbrd.setContents(stringSelection, null);
            practicalLawUKCategoryPage.freeTextField().sendKeys(Keys.CONTROL + "v");
        } else {
            practicalLawUKCategoryPage.freeTextField().sendKeys(query);
        }
        if (practicalLawUKCategoryPage.getClass().equals(ChromeDriver.class)) {
            pageActions.keyPress(Keys.ENTER);
        } else {
            practicalLawUKCategoryPage.searchButton().click();
        }
        theUserVerifiesThatTheResultsListPageIsDisplayed();
    }

    @When("^the user selects the know how following parent facets with single selection$")
    public void theUserSelectsTheKnowHowFollowingParentFacetWithSingleSelection(List<String> facets) throws Throwable {
        WebElement cancelFilterButton=commonMethods.waitForElement(researchOrganizerPage.cancelByFilters(), 1000);
        if(cancelFilterButton!=null){
            cancelFilterButton.click();
        }
        for (String facet : facets) {
            knowHowSearchResultsPage.knowHowFacetCheckbox(facet).click();
            assertTrue("Check box not selected..!", isCheckboxSeleted(facet));
        }
    }

    @When("^the user verifies that the know how following facet is selected and their count is equal to total count$")
    public void theUserVerifiesThatTheKnowHowFollowingFacetIsSelected(List<String> facets) throws Throwable {
        int facetCount=0;
        String totalSearchCount = knowHowSearchResultsPage.knowHowSearchResultCount().getText();
        totalSearchCount = totalSearchCount.replaceAll("[^0-9]", "");
        int totalCount=Integer.parseInt(totalSearchCount);

        for (String facet : facets) {
            totalSearchCount=knowHowSearchResultsPage.facetCount(facet).getText().replaceAll("[^0-9]", "");;
            facetCount= facetCount+Integer.parseInt(totalSearchCount);
            assertTrue(knowHowSearchResultsPage.knowHowFacetCheckbox(facet).isSelected());
        }
        assertTrue("Facet Count "+facetCount+" not displayed..!",facetCount==totalCount);
    }

    @Then("^the user can open the first know how search result \"(.*)\"$")
    public void theUserCanOpenTheFirstKnowHowSearchResult(String arg1) throws Throwable {
        knowHowSearchResultsPage.knowHowSearchResultTitle(arg1).click();
    }

    @Then("^the following icons are disabled")
    public void theFollowingIconsAreDisabled(List<String> deliveryOptions) throws Throwable {
        for (String option : deliveryOptions) {
            assertThat(option + " is enabled", listOfItemsDeliveryOptionsPage.DisabledDeliveryOption(option), Is.is(true));
        }
    }

    private void theUserVerifiesThatTheResultsListPageIsDisplayed() throws Throwable {
        Robot robot = new Robot();
        robot.delay(5000);
        try {
            searchResultsPage.resultsListHeader().isDisplayed();
            searchResultsPage.filterHeader().isDisplayed();
        } catch (Exception e) {
        }
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
