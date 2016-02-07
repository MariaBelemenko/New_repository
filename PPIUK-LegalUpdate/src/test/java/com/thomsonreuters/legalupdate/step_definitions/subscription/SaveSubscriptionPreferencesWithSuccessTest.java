package com.thomsonreuters.legalupdate.step_definitions.subscription;

import com.thomsonreuters.legalupdate.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.pages.legalUpdates.LegalUpdatesPracticeAreaPage;
import com.thomsonreuters.pageobjects.pages.legalUpdates.SubscriptionPreferencesWidget;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertTrue;

public class SaveSubscriptionPreferencesWithSuccessTest extends BaseStepDef {

    private LegalUpdatesPracticeAreaPage legalUpdatesPracticeAreaPage = new LegalUpdatesPracticeAreaPage();
    private SubscriptionPreferencesWidget subscriptionPreferencesWidget = new SubscriptionPreferencesWidget();

    @When("^the user actions to save their subscription preferences$")
    public void theUserActionsToSaveTheirSubscriptionPreferences() throws Throwable {
        subscriptionPreferencesWidget.saveButton().click();
        legalUpdatesPracticeAreaPage.waitForPageToLoadAndJQueryProcessing();
    }

    @Then("^the user should be presented a notification that their subscription has been successful$")
    public void theUserShouldBePresentedANotificationThatTheirSubscriptionHasBeenSuccessful() throws Throwable {
        assertTrue("Successful notification is not displayed",
                legalUpdatesPracticeAreaPage.successfulSaveSubscriptionNotificationMessage().isDisplayed());
    }

}
