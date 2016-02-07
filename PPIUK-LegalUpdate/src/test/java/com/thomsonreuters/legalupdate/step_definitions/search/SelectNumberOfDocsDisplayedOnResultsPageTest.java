package com.thomsonreuters.legalupdate.step_definitions.search;

import com.thomsonreuters.legalupdate.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.pages.landingPage.PracticalLawUKCategoryPage;
import com.thomsonreuters.pageobjects.pages.legalUpdates.LegalUpdatesResultsPage;
import com.thomsonreuters.pageobjects.pages.search.KnowHowSearchResultsPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertTrue;

public class SelectNumberOfDocsDisplayedOnResultsPageTest extends BaseStepDef {

    private LegalUpdatesResultsPage legalUpdatesResultsPage = new LegalUpdatesResultsPage();
    private PracticalLawUKCategoryPage practicalLawUKCategoryPage = new PracticalLawUKCategoryPage();
    private KnowHowSearchResultsPage knowHowSearchResultsPage = new KnowHowSearchResultsPage();

    private int fiftyPerPage;
    private int oneHundredPerPage;

    private final int FIFTY_PER_PAGE = 50;
    private final int ONE_HUNDRED_PER_PAGE = 100;

    @Given("^the default number of results on that page is (\\d+)$")
    public void theDefaultNumberOfResultsOnThatPageIs(int pageCount) throws Throwable {
        /** Need this if-else condition because selected value in pagination drop down
         * is associated with client ID and stored for particular client ID */
        if (!legalUpdatesResultsPage.resultsPerPageLink().getText().contains(Integer.toString(20))) {
            practicalLawUKCategoryPage.resultsPerPageDropdown(LegalUpdatesResultsPage.TWENTY_PER_PAGE_SELECT_OPTION);
            legalUpdatesResultsPage.waitForPageToLoad();
            knowHowSearchResultsPage.waitForSearchResults();
        }
        assertTrue("Default page count is not " + pageCount + "actual value is " + legalUpdatesResultsPage.getUpdatesResultCount(),
                legalUpdatesResultsPage.resultsPerPageLink().getText().contains(Integer.toString(pageCount)) && legalUpdatesResultsPage.getUpdatesResultCount() == pageCount);
    }

    @When("^the user selects another number from the select box$")
    public void theUserSelectsAnotherNumberFromTheSelectBox() throws Throwable {
        practicalLawUKCategoryPage.resultsPerPageDropdown(LegalUpdatesResultsPage.FIFTY_PER_PAGE_SELECT_OPTION);
        legalUpdatesResultsPage.waitForPageToLoad();
        knowHowSearchResultsPage.waitForSearchResults();
        Thread.sleep(30000);
        fiftyPerPage = legalUpdatesResultsPage.getUpdatesResultCount();
        practicalLawUKCategoryPage.resultsPerPageDropdown(LegalUpdatesResultsPage.ONE_HUNDRED_PER_PAGE_SELECT_OPTION);
        legalUpdatesResultsPage.waitForPageToLoad();
        knowHowSearchResultsPage.waitForSearchResults();
        Thread.sleep(30000);
        oneHundredPerPage = legalUpdatesResultsPage.getUpdatesResultCount();
    }

    @Then("^the number of legal updates that are displayed should change to reflect the selection of the user$")
    public void theNumberOfLegalUpdatesThatAreDisplayedShouldChangeToReflectTheSelectionOfTheUser() throws Throwable {
        assertTrue("Page count is not correct. actual values are " + fiftyPerPage + " and " + oneHundredPerPage + " but should be 50 and 100",
                fiftyPerPage == FIFTY_PER_PAGE && oneHundredPerPage == ONE_HUNDRED_PER_PAGE);
    }

}
