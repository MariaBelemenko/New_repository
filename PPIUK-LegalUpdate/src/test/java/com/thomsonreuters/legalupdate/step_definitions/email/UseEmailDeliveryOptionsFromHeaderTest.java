package com.thomsonreuters.legalupdate.step_definitions.email;

import com.thomsonreuters.legalupdate.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.pages.legalUpdates.LegalUpdatesResultsPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertTrue;

public class UseEmailDeliveryOptionsFromHeaderTest extends BaseStepDef {

    private LegalUpdatesResultsPage legalUpdatesResultsPage = new LegalUpdatesResultsPage();

    @Then("^they should be presented with an 'email' option$")
    public void theyShouldBePresentedWithAnEmailOption() throws Throwable {
        assertTrue("Email option is not visible", legalUpdatesResultsPage.emailIcon().isDisplayed());
    }

    @When("^the User selects the 'email' option$")
    public void theUserSelectsTheEmailOption() throws Throwable {
        legalUpdatesResultsPage.specificLegalUpdateCheckBox(1).click();
        legalUpdatesResultsPage.emailIcon().click();
        legalUpdatesResultsPage.waitForPageToLoad();
    }

    @Then("^they should be presented with an email delivery light box$")
    public void theyShouldBePresentedWithAnEmailDeliveryLightBox() throws Throwable {
        assertTrue("Email delivery widget is not visible", legalUpdatesResultsPage.emailDeliveryWidget().isDisplayed());
    }

}
