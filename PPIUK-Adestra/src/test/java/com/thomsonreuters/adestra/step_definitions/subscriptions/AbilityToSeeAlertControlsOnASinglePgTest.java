package com.thomsonreuters.adestra.step_definitions.subscriptions;

import com.thomsonreuters.adestra.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.pages.adestra.SubscriptionPreferencePage;
import com.thomsonreuters.pageobjects.utils.adestra.AdestraUtils;
import com.thomsonreuters.pageobjects.utils.adestra.SubscriptionParameters;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class AbilityToSeeAlertControlsOnASinglePgTest extends BaseStepDef {

    private AdestraUtils adestraUtils = new AdestraUtils();
    private SubscriptionPreferencePage subscriptionPreferencePage = new SubscriptionPreferencePage();

    private List<SubscriptionParameters> servicesForSpecifiedRegion;

    @Given("^the user has opened the \"(.*?)\" Services tab$")
    public void theUserHasOpenedTheServicesTab(String region) throws Throwable {
        servicesForSpecifiedRegion = adestraUtils.getServiceForSpecifiedRegion(region);
        subscriptionPreferencePage.openSpecifiedServiceTab(region);
    }

    @Then("^the user should be presented with each \"(.*?)\" service$")
    public void theUserShouldBePresentedWithEachService(String region) throws Throwable {
        int result = 0;
        for (SubscriptionParameters service : servicesForSpecifiedRegion) {
            if (!subscriptionPreferencePage.getSpecifiedServiceField(service.getCommonName(), region).isDisplayed()) {
                result++;
            }
        }
        assertTrue("One of services for " + region + " is unavailbale", result == 0);
    }

    @Then("^each \"(.*?)\" service should have the relevant check box options$")
    public void eachServiceShouldHaveTheRelevantCheckBoxOptions(String region) throws Throwable {
        int result = 0;
        for (SubscriptionParameters service : servicesForSpecifiedRegion) {
            if (!subscriptionPreferencePage.getSpecifiedCheckBox(service.getCommonName(), service.getProductFrequency(), region).isDisplayed()) {
                LOG.error("Unable to find frequency checkbox: " + service.getProductFrequency() + " for service: " + service.getCommonName() + " on region tab: " + region);
                result++;
            }
        }
        assertTrue("One of checkboxes for " + region + " is unavailbale", result == 0);
    }

    @Then("^the user should be presented with two radio buttons as email options$")
    public void theUserShouldBePresentedWithTwoRadioButtonsAsEmailOptions() throws Throwable {
        assertTrue("one of radiobuttons is absent", subscriptionPreferencePage.htmlRadioButton().isDisplayed() && subscriptionPreferencePage.textOnlyRadioButton().isDisplayed());
    }

    @Then("^the options should include HTML and Text Only$")
    public void theOptionsShouldIncludeHTMLAndTextOnly() throws Throwable {
        String htmlRB = subscriptionPreferencePage.htmlRadioButtonLabel().getText();
        String textRB = subscriptionPreferencePage.textOnlyRadioButtonLabel().getText();
        String HTML_RADIOBUTTON_LABEL = "HTML (images and text)";
        String TEXT_RADIOBUTTON_LABEL = "Text only";
        assertTrue("Label for radio button is incorrect", htmlRB.contains(HTML_RADIOBUTTON_LABEL) && textRB.contains(TEXT_RADIOBUTTON_LABEL));
    }

    @Then("^the user should be presented with a checkbox for 'Receive an email even if there are no new items'$")
    public void theUserShouldBePresentedWithACheckboxForReceiveAnEmailEvenIfThereAreNoNewItems() throws Throwable {
        assertTrue("Checkbox 'I would like to receive 'No new items to report' emails' is absent", subscriptionPreferencePage.recieveNoNewItemsCheckBox().isDisplayed());
    }

    @Then("^the user should be presented with two buttons to save their preferences or cancel their changes$")
    public void theUserShouldBePresentedWithTwoButtonsToSaveTheirPreferencesOrCancelTheirChanges() throws Throwable {
        assertTrue("one of save/cancel buttons is absent", subscriptionPreferencePage.saveButton().isDisplayed() && subscriptionPreferencePage.cancelButton().isDisplayed());
    }

    @Then("^one button should be labelled 'Save preferences'$")
    public void oneButtonShouldBeLabelledSavePreferences() throws Throwable {
        String SAVE_BUTTON_LABEL = "Save";
        assertTrue("Save button label is incorrect", subscriptionPreferencePage.saveButton().getText().equals(SAVE_BUTTON_LABEL));
    }

    @Then("^one button should be labelled 'cancel changes'$")
    public void oneButtonShouldBeLabelledCancelChanges() throws Throwable {
        String CANCEL_BUTTON_LABEL = "Cancel";
        assertTrue("Cancel button label is incorrect", subscriptionPreferencePage.cancelButton().getText().equals(CANCEL_BUTTON_LABEL));
    }

    @When("^the user selects checkboxes for each  \"(.*?)\" service$")
    public void theUserSelectsCheckboxesForEachService(String region) throws Throwable {
        for (SubscriptionParameters service : servicesForSpecifiedRegion) {
            subscriptionPreferencePage.getSpecifiedCheckBoxAndClickOnIt(service.getCommonName(), service.getProductFrequency(), region);
        }
    }

    @When("^the user saves his preferences$")
    public void theUserSavesHisPreferences() throws Throwable {
        subscriptionPreferencePage.saveButton().click();
        subscriptionPreferencePage.waitForPageToLoadAndJQueryProcessingWithCustomTimeOut(90);
    }

    @Then("^user \"(.*?)\" preferences should be saved in adestra$")
    public void userPreferencesShouldBeSavedInAdestra(String userEmail) throws Throwable {
        List<String> adestraSubscriptionIDS = adestraUtils.getAdestraSubscriptionNameListForPLCUK(userEmail);
        assertTrue("User has no subscriptions or subscriptions number is not correct" + "subscriptions: " + adestraSubscriptionIDS.toString() + "ssize: " + adestraSubscriptionIDS.size(), adestraUtils.isUserHasCorrectSubscriptions(servicesForSpecifiedRegion, adestraSubscriptionIDS));
    }

}
