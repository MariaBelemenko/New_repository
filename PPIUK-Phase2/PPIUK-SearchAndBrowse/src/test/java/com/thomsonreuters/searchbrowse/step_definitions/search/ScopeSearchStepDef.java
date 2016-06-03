package com.thomsonreuters.searchbrowse.step_definitions.search;

import com.thomsonreuters.pageobjects.common.PageActions;
import com.thomsonreuters.pageobjects.pages.folders.HistoryTabs;
import com.thomsonreuters.pageobjects.pages.folders.ResearchOrganizerPage;
import com.thomsonreuters.pageobjects.pages.generic.PPIGenericDocDisplay;
import com.thomsonreuters.pageobjects.pages.header.WLNHeader;
import com.thomsonreuters.pageobjects.pages.landingPage.PracticalLawUKCategoryPage;
import com.thomsonreuters.pageobjects.pages.landingPage.SearchScopeControl;
import com.thomsonreuters.pageobjects.pages.landingPage.WhatsMarketHomePage;
import com.thomsonreuters.pageobjects.pages.pageCreation.HomePage;
import com.thomsonreuters.pageobjects.pages.plPlusKnowHowResources.KHResourcePage;
import com.thomsonreuters.pageobjects.pages.plPlusKnowHowResources.TopicPage;
import com.thomsonreuters.pageobjects.pages.search.KnowHowSearchResultsPage;
import com.thomsonreuters.pageobjects.pages.search.SearchResultsPage;
import com.thomsonreuters.searchbrowse.step_definitions.BaseStepDef;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;

import static org.junit.Assert.assertTrue;

/**
 * Created by uc186961 on 19/05/2016.
 */
public class ScopeSearchStepDef extends BaseStepDef {
String s;
    private PracticalLawUKCategoryPage practicalLawUKCategoryPage;
    private SearchScopeControl searchScopeControl;
    private PageActions pageActions;
    private SearchResultsPage searchResultsPage;
    private WLNHeader wlnHeader;
    private ResearchOrganizerPage researchOrganizerPage;
    private HomePage homePage;
    private TopicPage topicPage;
    private KHResourcePage khResourcePage;
    private SoftAssertions softAssertions;
    private PPIGenericDocDisplay ppiGenericDocDisplay;
    private WhatsMarketHomePage whatsMarketHomePage;
    private KnowHowSearchResultsPage knowHowSearchResultsPage;

    static int actualResultsCount;

    public ScopeSearchStepDef() {
        practicalLawUKCategoryPage = new PracticalLawUKCategoryPage();
        searchScopeControl = new SearchScopeControl();
        pageActions = new PageActions();
        searchResultsPage = new SearchResultsPage();
        wlnHeader = new WLNHeader();
        researchOrganizerPage = new ResearchOrganizerPage();
        homePage = new HomePage();
        topicPage = new TopicPage();
        khResourcePage = new KHResourcePage();
        ppiGenericDocDisplay = new PPIGenericDocDisplay();
        whatsMarketHomePage = new WhatsMarketHomePage();
        knowHowSearchResultsPage = new KnowHowSearchResultsPage();
    }

    @Given("^user navigated to WestLaw UK  home page through compartment$")
    public void userNavigatedToWestLawUKHomePageThroughCompartment() throws Throwable {
        //TODO need to add the code to move to wluk compartment page
    }

//    @When("^the user navigates to WLUK practice area \"([^\"]*)\"$")
//    public void theUserNavigatesToPracticeAreaFilteredByTopicPage(String arg1, String arg2) throws Throwable {
//        userNavigatedToWestLawUKHomePageThroughCompartment();
//        practicalLawUKCategoryPage.practiceAreaLink(arg1).click();
//    }

    @Then("^the user can verify that the scoped search dropdown states \"([^\"]*)\"$")
    public void theUserCanVerifyThatTheScopedSearchDropdownStates(String expectedText) throws Throwable {
        /** Strip spaces from the string */
        expectedText = expectedText.replaceAll("\\s+", "");
        /** Strip spaces from the string */
        String returnedText = searchScopeControl.scopedSearchDropdownTitle().getText().replaceAll("\\s+", "");
        assertTrue("The selected practice area name and scope search dropdown populated value is not matching."
                , expectedText.equals(returnedText));
    }

    @When("^the user runs a free text search for the query \"([^\"]*)\"$")
    public void theUserRunsAFreeTextSearchForTheQuery(String value) throws Throwable {
        /** Ensure the search button has rendered */
        practicalLawUKCategoryPage.searchButton().isDisplayed();
        practicalLawUKCategoryPage.freeTextField().clear();
        /** Use Javascript executor instead of sendkeys for characters that won't type due to a Selenium bug */
        if (value.contains("(") || value.contains(")") || value.contains("&")) {
            practicalLawUKCategoryPage.freeTextFieldJavaScript(value);
            practicalLawUKCategoryPage.freeTextField().sendKeys(" ");
        } else {
            practicalLawUKCategoryPage.freeTextField().sendKeys(value);
        }

        if (practicalLawUKCategoryPage.getClass().equals(ChromeDriver.class)) {
            pageActions.keyPress(Keys.ENTER);
        } else {
            practicalLawUKCategoryPage.searchButton().click();
        }

        /** Wait for the results list to display */
        theUserVerifiesThatTheResultsListPageIsDisplayed();

        //Storing the results count value in local variable for future varification.
        actualResultsCount = knowHowSearchResultsPage.getSearchResultsCount();
    }

    @When("^the user verifies that the results list page is displayed$")
    public void theUserVerifiesThatTheResultsListPageIsDisplayed() throws Throwable {
        Robot robot = new Robot();
        robot.delay(5000);
        try {
            searchResultsPage.resultsListHeader().isDisplayed();
            searchResultsPage.filterHeader().isDisplayed();
        } catch (Exception e) {
        }
    }

    @Then("^the user can verify that the title listed above the search results is \"([^\"]*)\"$")
    public void theUserCanVerifyThatTheTitleListedAboveTheSearchResultsIs(String arg1) throws Throwable {
        arg1 = "\"" + arg1 + "\"";
        searchResultsPage.resultPageTitle(arg1).isDisplayed();
    }

    @When("^the user selects the link to history$")
    public void theUserSelectsTheLinkToHistory() throws Throwable {
        wlnHeader.historyLink().click();
    }

    @When("^the user selects the link \"([^\"]*)\" to re-run the scoped search$")
    public void theUserSelectsTheLinkToReRunTheScopedSearch(String searchLinkName) throws Throwable {
        HistoryTabs tab = HistoryTabs.valueOf("Searches");
        researchOrganizerPage.findElement(tab.getId());
        researchOrganizerPage.clickOnSearchTermInHistory(searchLinkName);
    }

    @Then("^the user is able to confirm that the scoped search dropdown is set to the scoped value \"([^\"]*)\"$")
    public void theUserIsAbleToConfirmThatTheScopedSearchDropdownIsSetToTheScopedValue(String expectedText) throws Throwable {
        theUserCanVerifyThatTheScopedSearchDropdownStates(expectedText);
    }

    @Then("^the user is able to verify that the pre-scoped \"([^\"]*)\" value is correctly highlighted as a facet$")
    public void theUserIsAbleToVerifyThatThePreScopedSearchValueIsCorrectlyHighlightedAsAFacet(String facetName) throws Throwable {
        facetName = "\"" + facetName + "\"";
        assertTrue(searchResultsPage.resultPageTitle(facetName).isDisplayed());
    }

    @Then("^the user is able to verify that the number of search results matches with previous results$")
    public void theUserIsAbleToVerifyThatTheNumberOfSearchResultsMatchesWithPreviousResults() throws Throwable {
        assertTrue(actualResultsCount == knowHowSearchResultsPage.getSearchResultsCount());
    }

    @Then("^the user is able to verify that the facet count for (practice area|deal type) with previous results facet count$")
    public void theUserIsAbleToVerifyThatTheFacetCountForPracticeAreaWithPreviousResultsFacetCount() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^the user navigates to practice area \"(.*?)\"$")
    public void theUserNavigatesToPracticeAreaFilteredByTopicPage(String practiceArea) throws Throwable {
        homePage.selectLinkPresentOnTab(practiceArea);
    }

    @Then("^user logs out$")
    public void userLogsOut() throws Throwable {
        wlnHeader.signOff();
    }

    @Given("^has selected the link to the What's Market homepage$")
    public void hasSelectedTheLinkToTheWhatSMarketHomepage() throws Throwable {
        softAssertions= new SoftAssertions();

        homePage.selectResourceTab();
        /** Ensure the page components have rendered */
        softAssertions.assertThat(ppiGenericDocDisplay.categoryTab().isDisplayed());
        softAssertions.assertThat(ppiGenericDocDisplay.rightColumn().isDisplayed());
        homePage.selectLinkPresentOnTab("What's Market");
        softAssertions.assertThat(ppiGenericDocDisplay.searchPageLabel().getText().equals("What's Market"));
        /** Ensure the page components have rendered */
        softAssertions.assertThat(ppiGenericDocDisplay.categoryTab().isDisplayed());
        softAssertions.assertThat(ppiGenericDocDisplay.rightColumn().isDisplayed());
        softAssertions.assertAll();
    }

    @When("^the user selects the deal type \"([^\"]*)\"$")
    public void hasSelectedTheLinkToTheDealType(String linkText) throws Throwable {
        whatsMarketHomePage.dealTypeLink(linkText).click();
    }
}
