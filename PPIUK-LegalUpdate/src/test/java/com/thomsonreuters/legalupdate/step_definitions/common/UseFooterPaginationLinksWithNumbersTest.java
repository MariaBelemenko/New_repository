package com.thomsonreuters.legalupdate.step_definitions.common;

import com.thomsonreuters.legalupdate.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.pages.legalUpdates.LegalUpdatesResultsPage;
import com.thomsonreuters.pageobjects.pages.legalUpdates.LegalUpdatesWidget;
import com.thomsonreuters.pageobjects.pages.search.KnowHowSearchResultsPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertTrue;

public class UseFooterPaginationLinksWithNumbersTest extends BaseStepDef {

    private LegalUpdatesResultsPage legalUpdatesResultsPage = new LegalUpdatesResultsPage();
    private KnowHowSearchResultsPage knowHowSearchResultsPage = new KnowHowSearchResultsPage();
    private LegalUpdatesWidget luWidget = new LegalUpdatesWidget();

    @Given("^the pagination links display the number of results pages$")
    public void thePaginationLinksDisplayTheNumberOfResultsPages() throws Throwable {
        assertTrue("Pagination links numbers are not displayed", legalUpdatesResultsPage.pageNumberLinksContainer().isDisplayed());
    }

    @When("^the user clicks on page number \"(.*?)\"$")
    public void theUserClicksOnPageNumber(String destinationPageNumber) throws Throwable {
        legalUpdatesResultsPage.specifiedPageNumberLink(destinationPageNumber).click();
        legalUpdatesResultsPage.waitForPageToLoad();
        knowHowSearchResultsPage.waitForSearchResults();
    }

    @Then("^the user should navigate to page \"(.*?)\" of results$")
    public void theUserShouldNavigateToPageOfResults(String destinationPageNumber) throws Throwable {
        assertTrue("Destination page is incorrect, actual page number is: " + legalUpdatesResultsPage.currentPageNumberLabel().getText(),
                legalUpdatesResultsPage.currentPageNumberLabel().getText().equals(destinationPageNumber));
    }

    @When("^the user clicks on the 'View all' link of the LU widget$")
    public void theUserClicksOnTheViewAllLinkOfTheLUWidget() throws Throwable {
        luWidget.veiwAllUpdatesLink("Legal").click();
        legalUpdatesResultsPage.waitForPageToLoad();
    }

}
