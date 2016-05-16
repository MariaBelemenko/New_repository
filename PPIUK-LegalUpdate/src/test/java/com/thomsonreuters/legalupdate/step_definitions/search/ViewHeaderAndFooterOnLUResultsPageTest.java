package com.thomsonreuters.legalupdate.step_definitions.search;

import com.thomsonreuters.driver.exception.PageOperationException;
import com.thomsonreuters.legalupdate.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.pages.legalUpdates.LegalUpdatesResultsPage;
import cucumber.api.java.en.Then;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class ViewHeaderAndFooterOnLUResultsPageTest extends BaseStepDef {

    private LegalUpdatesResultsPage legalUpdatesResultsPage = new LegalUpdatesResultsPage();

    @Then("^the user should be able to see a header on the page$")
    public void theUserShouldBeAbleToSeeAHeaderOnThePage() throws Throwable {
        assertTrue("Header is not displayed", legalUpdatesResultsPage.resultsPageHeader().isDisplayed());
    }

    @Then("^the header should contain the '3' UI features listed in the description$")
    public void theHeaderShouldContainThe3UiFeaturesListedInTheDescription(List<String> elementsLocators) throws Throwable {
        int result = 0;
        for (String elementLocator : elementsLocators) {
            try {
                if (!legalUpdatesResultsPage.findElementOnResultsPageHeader(elementLocator).isDisplayed()) {
                    result++;
                }
            } catch (PageOperationException e) {
                LOG.info("Unable to find the element with the selector '" + elementLocator + "' in the search header toolbar", e);
                result++;
            }
        }
        assertTrue("One of header links is not displayed", result == 0);
    }

    @Then("^the user should be able to see a footer on the page$")
    public void theUserShouldBeAbleToSeeAFooterOnThePage() throws Throwable {
        assertTrue("Footer is not displayed", legalUpdatesResultsPage.resultsPageFooter().isDisplayed());
    }

    @Then("^the footer should contain the '2' UI features listed in the description$")
    public void theFooterShouldContainThe2UiFeaturesListedInTheDescription(List<String> elementsLocators) throws Throwable {
        int result = 0;
        for (String elementLocator : elementsLocators) {
            try {
                if (!legalUpdatesResultsPage.findElementOnResultsPageFooter(elementLocator).isDisplayed()) {
                    result++;
                }
            } catch (PageOperationException e) {
                LOG.info("Unable to find the element with the selector '" + elementLocator + "' in the search header toolbar", e);
                result++;
            }
        }
        assertTrue("One of footer links is not displayed", result == 0);
    }

}
