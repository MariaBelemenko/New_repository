package com.thomsonreuters.legalupdate.step_definitions.common;

import com.thomsonreuters.legalupdate.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.pages.legalUpdates.LegalUpdatesResultsPage;
import com.thomsonreuters.pageobjects.pages.search.KnowHowSearchResultsPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class NextAndPreviousPaginationLinksInFooterTest extends BaseStepDef {

    private LegalUpdatesResultsPage legalUpdatesResultsPage = new LegalUpdatesResultsPage();
    private KnowHowSearchResultsPage knowHowSearchResultsPage = new KnowHowSearchResultsPage();

    @Given("^the page navigation links are displayed either side of the page numbers$")
    public void thePageNavigationLinksAreDisplayedEitherSideOfThePageNumbers() throws Throwable {
        assertTrue("Pagination links are not displayed", legalUpdatesResultsPage.pageNumberLinksContainer().isDisplayed());
    }

    @When("^the user clicks on \"(.*?)\"$")
    public void theUserClicksOn(String destinationPageArrow) throws Throwable {
        legalUpdatesResultsPage.getPaginationArrowLocatorByArrow(destinationPageArrow).click();
        legalUpdatesResultsPage.waitForPageToLoad();
        knowHowSearchResultsPage.waitForSearchResults();
        Thread.sleep(30000);
    }

    @Then("^the user should navigate to the page \"(.*?)\" of results$")
    public void theUserShouldNavigateToThePageOfResults(String page) throws Throwable {
        boolean navigationIsCorrect = false;
        if (page.contains("<") || page.contains(">")) {
            navigationIsCorrect = legalUpdatesResultsPage.isPaginationArrowDisplayed(page);
            assertFalse("Navigation is incorrect ", navigationIsCorrect);
        } else {
            navigationIsCorrect = legalUpdatesResultsPage.currentPageNumberLabel().getText().equals(page);
            assertTrue("Navigation is incorrect ", navigationIsCorrect);
        }
    }

}
