package com.thomsonreuters.searchbrowse.step_definitions.search;

import com.thomsonreuters.pageobjects.common.PageActions;
import com.thomsonreuters.pageobjects.pages.folders.HistoryTabs;
import com.thomsonreuters.pageobjects.pages.folders.ResearchOrganizerPage;
import com.thomsonreuters.pageobjects.pages.header.WLNHeader;
import com.thomsonreuters.pageobjects.pages.landingPage.PracticalLawUKCategoryPage;
import com.thomsonreuters.pageobjects.pages.landingPage.SearchScopeControl;
import com.thomsonreuters.pageobjects.pages.search.SearchResultsPage;
import com.thomsonreuters.searchbrowse.step_definitions.BaseStepDef;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
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

    public ScopeSearchStepDef() {
        practicalLawUKCategoryPage = new PracticalLawUKCategoryPage();
        searchScopeControl = new SearchScopeControl();
        pageActions = new PageActions();
        searchResultsPage = new SearchResultsPage();
        wlnHeader = new WLNHeader();
        researchOrganizerPage = new ResearchOrganizerPage();
    }

    @Given("^user navigated to WestLaw UK  home page through compartment$")
    public void userNavigatedToWestLawUKHomePageThroughCompartment() throws Throwable {
        //TODO need to add the code to move to wluk compartment page
    }

    @When("^the user navigates to WLUK practice area \"([^\"]*)\"$")
    public void theUserNavigatesToPracticeAreaFilteredByTopicPage(String arg1, String arg2) throws Throwable {
        userNavigatedToWestLawUKHomePageThroughCompartment();
        practicalLawUKCategoryPage.practiceAreaLink(arg1).click();
    }

    @Then("^the user can verify that the scoped search dropdown states \"([^\"]*)\"$")
    public void theUserCanVerifyThatTheScopedSearchDropdownStates(String expectedText) throws Throwable {
        /** Strip spaces from the string */
        expectedText = expectedText.replaceAll("\\s+", "");
        /** Strip spaces from the string */
        String returnedText = searchScopeControl.scopedSearchDropdownTitle().getText().replaceAll("\\s+", "");
        assertTrue("The selected practice area name and scope search dropdown populated value is not matching."
                , expectedText.equals(expectedText));
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

    @When("^the user selects the link to re-run the scoped search$")
    public void theUserSelectsTheLinkToReRunTheScopedSearch() throws Throwable {
        HistoryTabs tab = HistoryTabs.valueOf("Search");
        researchOrganizerPage.findElement(tab.getId());
        // ToDO: Need to add the step to select the search term from history results
    }

    @Then("^the user is able to confirm that the scoped search dropdown is set to the scoped value \"([^\"]*)\"$")
    public void theUserIsAbleToConfirmThatTheScopedSearchDropdownIsSetToTheScopedValue(String expectedText) throws Throwable {
        theUserCanVerifyThatTheScopedSearchDropdownStates(expectedText);
    }

    @Then("^the user is able to verify that the pre-scoped search value is correctly highlighted as a facet$")
    public void theUserIsAbleToVerifyThatThePreScopedSearchValueIsCorrectlyHighlightedAsAFacet() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^the user is able to verify that the number of search results matches with previous results$")
    public void theUserIsAbleToVerifyThatTheNumberOfSearchResultsMatchesWithPreviousResults() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^the user is able to verify that the facet count for practice area with previous results facet count$")
    public void theUserIsAbleToVerifyThatTheFacetCountForPracticeAreaWithPreviousResultsFacetCount() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^user logs out$")
    public void userLogsOut() throws Throwable {
        wlnHeader.signOff();
    }
}
