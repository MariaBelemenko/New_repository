package com.thomsonreuters.legalupdate.step_definitions.subscription;

import com.thomsonreuters.legalupdate.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.pages.landingPage.PracticalLawHomepage;
import com.thomsonreuters.pageobjects.pages.legalUpdates.LegalUpdatesPracticeAreaPage;
import com.thomsonreuters.pageobjects.pages.legalUpdates.LegalUpdatesWidget;
import com.thomsonreuters.pageobjects.pages.legalUpdates.SubscriptionPreferencesWidget;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.NoSuchElementException;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class SubscribeToContentDirectlyFromBrowsepageTest extends BaseStepDef {

    private PracticalLawHomepage practicalLawHomepage = new PracticalLawHomepage();
    private LegalUpdatesPracticeAreaPage legalUpdatesPracticeAreaPage = new LegalUpdatesPracticeAreaPage();
    private LegalUpdatesWidget legalUpdatesWidget = new LegalUpdatesWidget();
    private SubscriptionPreferencesWidget subscriptionPreferencesWidget = new SubscriptionPreferencesWidget();

    @Given("^a user is on a browse page$")
    public void aUserIsOnABrowsePage() throws Throwable {
        practicalLawHomepage.legalUpdatesContentLink().click();
        legalUpdatesPracticeAreaPage.waitForPageToLoadAndJQueryProcessing();
        legalUpdatesPracticeAreaPage.legalUpdatesAllWidgetsLink().click();
        legalUpdatesPracticeAreaPage.waitForPageToLoadAndJQueryProcessing();
    }

    @When("^the user enters their subscription preferences menu$")
    public void theUserEntersTheirSubscriptionPreferencesMenu() throws Throwable {
        legalUpdatesWidget.subscribeButton().click();
    }

    @Then("^the user should be presented with the default subscription name$")
    public void theUserShouldBePresentedWithTheDefaultSubscriptionName() throws Throwable {
        assertTrue(subscriptionPreferencesWidget.subscriptionNameInput().getAttribute("value").equals("Default Subscription Name"));
    }

    @Then("^should have the ability to type over the default name to enter a custom name \"([^\"]*)\"$")
    public void shouldHaveTheAbilityToTypeOverTheDefaultNameToEnterACustomName(String customSubscriptionName) throws Throwable {
        subscriptionPreferencesWidget.subscriptionNameInput().clear();
        subscriptionPreferencesWidget.subscriptionNameInput().sendKeys(customSubscriptionName);
        assertTrue("Subscription Name could not be edited", subscriptionPreferencesWidget.subscriptionNameInput().getAttribute("value").equals(customSubscriptionName));
    }

    @Then("^the user should be presented with an option to select 'Email' delivery of content$")
    public void theUserShouldBePresentedWithAnOptionToSelectEmailDeliveryOfContent() throws Throwable {
        assertTrue("Checkbox is not available for user", subscriptionPreferencesWidget.deliveryEmailCheckBox().isDisplayed());
    }

    @Then("^the user should be presented with an option to select 'MyUpdates' delivery of content$")
    public void theUserShouldBePresentedWithAnOptionToSelectMyUpdatesDeliveryOfContent() throws Throwable {
        assertTrue("Checkbox is not available for user", subscriptionPreferencesWidget.deliveryMyUpdatesCheckBox().isDisplayed());
    }

    @When("^the user selects the email delivery method$")
    public void theUserSelectsTheEmailDeliveryMethod() throws Throwable {
        if (!subscriptionPreferencesWidget.deliveryEmailCheckBox().isSelected()) {
            subscriptionPreferencesWidget.deliveryEmailCheckBox().click();
        }
        assertTrue(subscriptionPreferencesWidget.deliveryEmailCheckBox().isSelected());
    }

    @Then("^the user should have the ability to select the frequency that they would like to receive their email alerts$")
    public void theUserShouldHaveTheAbilityToSelectTheFrequencyThatTheyWouldLikeToReceiveTheirEmailAlerts(List<String> deliveryFrequency) throws Throwable {
        int result = 0;
        for (String frequency : deliveryFrequency) {
            subscriptionPreferencesWidget.deliveryFrequencySelectBox().selectByVisibleText(frequency);
            if (!subscriptionPreferencesWidget.deliveryFrequencySelectBox().getFirstSelectedOption().getText().equals(frequency)) {
                result++;
            }
        }
        assertTrue("One of frequency delivery options has not been selected", result == 0);
    }

    @Then("^the user should have the ability to enter an optional text message \"(.*?)\" to be included in their email$")
    public void theUserShouldHaveTheAbilityToEnterAnOptionalTextMessageToBeIncludedInTheirEmail(String textMesage) throws Throwable {
        if (subscriptionPreferencesWidget.notificationMessageInput() != null && subscriptionPreferencesWidget.notificationMessageInput().isEnabled()) {
            subscriptionPreferencesWidget.notificationMessageInput().clear();
            subscriptionPreferencesWidget.notificationMessageInput().sendKeys(textMesage);
        } else throw new RuntimeException("Message input is not available");
        assertTrue("Message input has incorrect text value",
                subscriptionPreferencesWidget.notificationMessageInput().getAttribute("value").equals(textMesage));
    }

    @Then("^the user should have the ability to enter the email address \"(.*?)\" that they wish their email alerts to be sent to$")
    public void theUserShouldHaveTheAbilityToEnterTheEmailAddressThatTheyWishTheirEmailAlertsToBeSentTo(String emailAddress) throws Throwable {
        if (subscriptionPreferencesWidget.emailAddressForNotificationInput() != null && subscriptionPreferencesWidget.emailAddressForNotificationInput().isEnabled()) {
            subscriptionPreferencesWidget.emailAddressForNotificationInput().clear();
            subscriptionPreferencesWidget.emailAddressForNotificationInput().sendKeys(emailAddress);
        } else throw new RuntimeException("Email address input is not available");
        assertTrue("Email address input has incorrect text value",
                subscriptionPreferencesWidget.emailAddressForNotificationInput().getAttribute("value").equals(emailAddress));
    }

    @Then("^the user should have the ability to receive an email that notifies the user of no new legal updates$")
    public void theUserShouldHaveTheAbilityToReceiveAnEmailThatNotifiesTheUserOfNoNewLegalUpdates() throws Throwable {
        subscriptionPreferencesWidget.notifyMeCheckBox().click();
        assertTrue("Notify me if there are no updates checkbox has not been checked",
                subscriptionPreferencesWidget.notifyMeCheckBox().isSelected());
    }

    @Then("^the user should be presented with an option to save their subscription preferences$")
    public void theUserShouldBePresentedWithAnOptionToSaveTheirSubscriptionPreferences() throws Throwable {
        assertTrue("Save button is not available", subscriptionPreferencesWidget.saveButton().isDisplayed());
    }

    @Then("^the user should be presented with an option to cancel their subscription preferences$")
    public void theUserShouldBePresentedWithAnOptionToCancelTheirSubscriptionPreferences() throws Throwable {
        assertTrue("Cancel button is not available", subscriptionPreferencesWidget.cancelButton().isDisplayed());
    }

    @Then("^the subscription preferences menu should close$")
    public void theSubscriptionPreferencesMenuShouldClose() throws Throwable {
        boolean isPreferencesWidgetClosed = false;
        subscriptionPreferencesWidget.cancelButton().click();
        try {
            legalUpdatesPracticeAreaPage.subscriptionPreferencesWidget();
        } catch (Exception e) {
            if (e instanceof NoSuchElementException) {
                isPreferencesWidgetClosed = true;
            } else {
                LOG.info("context", e);
            }
        }
        assertTrue("Preferences widget has not been closed", isPreferencesWidgetClosed);
    }

}
