package com.thomsonreuters.searchknowhow.step_definitions.knowHowSearch;

import com.thomsonreuters.pageobjects.otherPages.NavigationCobalt;
import com.thomsonreuters.pageobjects.pages.header.WLNHeader;
import com.thomsonreuters.pageobjects.pages.landingPage.*;
import com.thomsonreuters.pageobjects.pages.pageCreation.HomePage;
import com.thomsonreuters.pageobjects.pages.plPlusKnowHowResources.GlossaryPage;
import com.thomsonreuters.pageobjects.pages.plPlusKnowHowResources.KHResourcePage;
import com.thomsonreuters.pageobjects.pages.plPlusKnowHowResources.TopicPage;
import com.thomsonreuters.pageobjects.pages.search.KnowHowDocumentPage;
import com.thomsonreuters.pageobjects.pages.search.SearchResultsPage;
import com.thomsonreuters.searchknowhow.step_definitions.BaseStepDef;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.hamcrest.core.Is;
import org.openqa.selenium.By;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;

public class ScopedSearchDropdownTest extends BaseStepDef {

    private PracticalLawHomepage practicalLawHomepage = new PracticalLawHomepage();
    private InternationalLandingPage internationalLandingPage = new InternationalLandingPage();
    private SearchScopeControl searchScopeControl = new SearchScopeControl();
    private SearchResultsPage searchResultsPage = new SearchResultsPage();
    private ResourcesPage resourcesPage = new ResourcesPage();
    private KnowHowDocumentPage knowHowDocumentPage = new KnowHowDocumentPage();
    private HomePage homePage = new HomePage();
    private PracticalLawUKCategoryPage practicalLawUKCategoryPage = new PracticalLawUKCategoryPage();
    private TopicPage topicPage = new TopicPage();
    private KHResourcePage khResourcePage = new KHResourcePage();
    private NavigationCobalt navigationCobalt = new NavigationCobalt();
    private WLNHeader wlnHeader = new WLNHeader();
    private GlossaryPage glossaryPage = new GlossaryPage();

    private int CUSTOM_DRIVER_WAIT_TIME = 120;

    @And("^has selected the link entitled International$")
    public void hasSelectedTheLinkEntitled() throws Throwable {
        practicalLawHomepage.internationalLink().click();
    }

    @And("^has selected the link to the country page \"([^\"]*)\"$")
    public void hasSelectedTheLinkToTheCountryPage(String arg1) throws Throwable {
        internationalLandingPage.countryNameLink(arg1).click();
    }

    @Then("^the user can verify that the scoped search dropdown states \"([^\"]*)\"$")
    public void theUserCanVerifyThatTheScopedSearchDropdownStates(String expectedText) throws Throwable {
        String returnedText;
        /** Strip spaces from the string */
        expectedText = expectedText.replaceAll("\\s+", "");
        /** Strip spaces from the string */
        returnedText = searchScopeControl.scopedSearchDropdownTitle().getText().replaceAll("\\s+", "");
        assertTrue(returnedText.equals(expectedText));
    }

    @When("^the user can (display|close) the scoped search dropdown menu options$")
    public void theUserCanDisplayTheScopedSearchDropdownMenuOptions(String arg1) throws Throwable {
        searchScopeControl.scopedSearchDropdownMenuButton().click();
    }

    @Then("^the user can verify that the dropdown options include \"([^\"]*)\"$")
    public void theUserCanVerifyThatTheDropdownOptionsInclude(String arg1) throws Throwable {
        searchScopeControl.scopedSearchDropdownOptions(arg1).isDisplayed();
    }

    @And("^the user can verify that the title listed above the search results is the country name \"([^\"]*)\"$")
    public void theUserCanVerifyThatTheTitleListedAboveTheSearchResultsIsTheCountryName(String arg1) throws Throwable {
        searchResultsPage.resultPageTitle(arg1).isDisplayed();
    }

    @And("^the user can verify that the search result in position \"([^\"]*)\" contains the jurisdiction \"([^\"]*)\"$")
    public void theUserCanVerifyThatTheSearchResultInPositionContainsTheJurisdiction(String arg1, String arg2) throws Throwable {
        searchResultsPage.jurisdiction(arg1, arg2).isDisplayed();
    }

    @And("^has selected the link to Resources$")
    public void hasSelectedTheLinkToResources() throws Throwable {
        practicalLawHomepage.resourcesLink().click();
    }

    @And("^has selected the link to PLC Magazine$")
    public void hasSelectedTheLinkToPLCMagazine() throws Throwable {
        resourcesPage.plcMagazineLink().click();
    }

    @And("^the user can verify that the title listed above the search results is \"([^\"]*)\"$")
    public void theUserCanVerifyThatTheTitleListedAboveTheSearchResultsIs(String arg1) throws Throwable {
        arg1="\"" + arg1 +"\"";
        searchResultsPage.resultPageTitle(arg1).isDisplayed();
    }

    @Then("^the user verifies that the product detail contains PLC Magazine \"([^\"]*)\"$")
    public void theUserVerifiesThatTheProductDetailContainsPLCMagazine(String arg1) throws Throwable {
        assertTrue(knowHowDocumentPage.knowHowProductCodes(arg1).isDisplayed());
    }

    @Then("^the search drop down options provided on \"(.*?)\" are as below$")
    public void theSearchDropDownOptionsProvidedOnAreAsBelow(String currentPage, List<String> expectedOptions) throws Throwable {
        for (String option : searchScopeControl.scopedSearchDropdownOptionsList()) {
            int count = 0;
            for (String expectedOption : expectedOptions) {
                if (option.equals(expectedOption)) {
                    count++;
                    break;
                }
            }
            assertTrue(option + "is not present", count > 0);
        }
    }

    @And("^user selects the dropdown option \"(.*?)\"$")
    public void userSelectsTheDropdownOption(String option) throws Throwable {
        searchScopeControl.scopedSearchDropdownOptions(option).click();
    }

    @And("^has selected the homepage practice area link to \"(.*?)\"$")
    public void hasSelectedTheHomepagePracticeAreaLinkTo(String arg1) throws Throwable {
        practicalLawUKCategoryPage.practiceAreaLink(arg1).click();
    }

    @And("^the user navigates to practice area \"(.*?)\" filtered by \"(.*?)\" topic page$")
    public void theUserNavigatesToPracticeAreaFilteredByTopicPage(String practiceArea, String topicName) throws Throwable {
        homePage.selectLinkPresentOnTab(practiceArea);
        topicPage.clickTopicLinkOnPAPage(topicName).click();
        Thread.sleep(2000);
        khResourcePage.waitForPageToLoad();
    }

    @When("^the user is in page '(.*)' with page Title '(.*)'$")
    public void theUserIsInPageResourcecsBooksOnlineWithPageTitle(String pages, String expectedTitle) throws Throwable {
        List<String> links = Arrays.asList(pages.split(">"));
        for (String link : links) {
            if (link.contains("/")) {
                navigationCobalt.navigateToRelativeURL(link);
            } else {
                if (link.equalsIgnoreCase("Browse Menu")) {
                    wlnHeader.browseMenuButton().click();
                } else {
                    navigationCobalt.waitForElementPresent(By.linkText(link)).click();
                }
                navigationCobalt.waitForPageToLoad();
            }
        }
        assertTrue(wlnHeader.pageHeaderLabel().getText().equals(expectedTitle));
    }

    @And("^the user clicks link '(.*)' on '(.*)' page$")
    public void theUserClicksLinkOnPage(String link, String page) throws Throwable {
        if (!link.equals("")) {
            if (page.contains("Browse")) {
                homePage.findChildElement(homePage.getPracticeAreasBrowseMenuContainer(), By.linkText((link))).click();
            } else {
                try {
                    homePage.waitForExpectedElement(By.linkText(link), 2).click();
                } catch (Exception e) {
                    homePage.waitForExpectedElement(By.partialLinkText(link), 5).click();
                }
            }
            Thread.sleep(2000);
            homePage.waitForPageToLoad();
        }
    }

    @Then("^the user verifies that the current PageTitle contains '(.*)'$")
    public void theUserVerifiesThatTheCurrentPageTitleContainsPageTitle(String pageTitle) throws Throwable {
        assertTrue("The Expected Page Title " + pageTitle + " is  NOT displayed", wlnHeader.pageHeaderLabel().getText().contains(pageTitle));
    }

    @Then("^user navigates to a glossary page and checks it$")
    public void userNavigatesToAGlossaryPage() throws Throwable {
        homePage.selectResourceTab();
        homePage.selectLinkPresentOnTab("Glossary");
        assertThat("Glossary heading is not displayed", glossaryPage.glossaryHeading().isDisplayed(), Is.is(true));
    }

    @And("^user navigates directly to document with guid \"(.*?)\"$")
    public void userNavigatesDirectlyToDocumentWithGuid(String guid) throws Throwable {
        navigationCobalt.navigateToWLNSpecificResourcePage("/Document/" + guid + "/View/FullText.html");
        khResourcePage.waitForPageToLoadAndJQueryProcessingWithCustomTimeOut(CUSTOM_DRIVER_WAIT_TIME);
    }

}
