package com.thomsonreuters.legalupdate.step_definitions.common;

import com.thomsonreuters.legalupdate.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.pages.legalUpdates.LegalUpdatesResultsPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertTrue;

public class DeliverLinksOnHeaderAndFooterTest extends BaseStepDef {

    private LegalUpdatesResultsPage legalUpdatesResultsPage = new LegalUpdatesResultsPage();

    @When("^the user selects a legal update document$")
    public void theUserSelectsALegalUpdateDocument() throws Throwable {
        legalUpdatesResultsPage.specificLegalUpdateCheckBox(1).click();
    }

    @Then("^the'Email' should be a selectable option$")
    public void theEmailShouldBeASelectableOption() throws Throwable {
        assertTrue("Header Deliver Widget Email link is not displayed", legalUpdatesResultsPage.emailIcon().isDisplayed());
    }

    @Then("^the'Print' should be a selectable option$")
    public void thePrintShouldBeASelectableOption() throws Throwable {
        assertTrue("Header Deliver Widget Print link is not displayed", legalUpdatesResultsPage.printIcon().isDisplayed());
    }

    @Then("^the 'Download' should be a selectable option$")
    public void theDownloadShouldBeASelectableOption() throws Throwable {
        assertTrue("Header Deliver Widget Donwload link is not displayed", legalUpdatesResultsPage.downloadIcon().isDisplayed());
    }

}
