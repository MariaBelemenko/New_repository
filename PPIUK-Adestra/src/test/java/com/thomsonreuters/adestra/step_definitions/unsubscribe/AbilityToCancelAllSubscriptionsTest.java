package com.thomsonreuters.adestra.step_definitions.unsubscribe;


import com.thomsonreuters.adestra.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.pages.adestra.SubscriptionPreferencePage;
import com.thomsonreuters.pageobjects.utils.adestra.AdestraUtils;
import com.thomsonreuters.pageobjects.utils.adestra.SubscriptionParameters;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class AbilityToCancelAllSubscriptionsTest extends BaseStepDef {

    private AdestraUtils adestraUtils = new AdestraUtils();
    private SubscriptionPreferencePage subscriptionPreferencePage = new SubscriptionPreferencePage();

    private List<SubscriptionParameters> specifiedServices;
    private List<String> existingSubscriptionIDS;
    private List<SubscriptionParameters> editedSpecifiedServices;
    private List<String> editedSubscriptionIDS;


    @Given("^a user \"(.*?)\" has already subscribed to the \"(.*?)\" \"(.*?)\" email service \"(.*?)\"$")
    public void aUserHasAlreadySubscribedToTheEmailService(String userEmail, String service, List<String> frequencies, String region) throws Throwable {
        specifiedServices = adestraUtils.getSpecifiedServices(region, service, frequencies);
        existingSubscriptionIDS = adestraUtils.getAdestraSubscriptionNameListForPLCUK(userEmail);
        assertTrue("User has no subscriptions or subscriptions number is not correct: " + "subscriptions: " + existingSubscriptionIDS.toString() + "ssize: " + existingSubscriptionIDS.size(), adestraUtils.isUserHasCorrectSubscriptions(specifiedServices, existingSubscriptionIDS));
    }

    @When("^the user checks the 'Yes' box in the Unsubscribe All section$")
    public void theUserChecksTheYesBoxInTheUnsubscribeAllSection() throws Throwable {
        subscriptionPreferencePage.unsubscribeAll();
    }

    @When("^the user clicks the 'Save preference' button$")
    public void theUserClicksTheSavePreferenceButton() throws Throwable {
        subscriptionPreferencePage.saveButton().click();
        subscriptionPreferencePage.waitForPageToLoadAndJQueryProcessingWithCustomTimeOut(90);
    }

    @Then("^the user \"(.*?)\" should be unsubscribed from all email services$")
    public void theUserShouldBeUnsubscribedFromAllEmailServices(String userEmail) throws Throwable {
        assertTrue("Subscriptions were not deleted from Adestra", adestraUtils.getAdestraSubscriptionNameListForPLCUK(userEmail).isEmpty());
    }

    @Then("^all email service check boxes on the preference page should be unchecked$")
    public void allEmailServiceCheckBoxesOnThePreferencePageShouldBeUnchecked() throws Throwable {
        int result = 0;
        for (SubscriptionParameters parameter : specifiedServices) {
            if (subscriptionPreferencePage.getSpecifiedCheckBox(parameter.getCommonName(), parameter.getProductFrequency(), parameter.getCategoryName()).isSelected()) {
                LOG.error("Frequency checkbox is selected after unsubscribe: " + parameter.getProductFrequency() + " for service: " + parameter.getCommonName() + " on region tab: " + parameter.getCategoryName());
                result++;
            }
        }
        assertTrue("One of checkboxes is unavailbale", result == 0);
    }
    
    @When("^the user unchecks \"(.*?)\" the \"(.*?)\" \"(.*?)\" email check box$")
    public void theUserUnchecksTheEmailCheckBox(String region, List<String> frequencies, String service) throws Throwable {
        editedSpecifiedServices = removeSubscriptionFromSpecifiedServices(specifiedServices, region, service, frequencies);
        for (String frequency : frequencies) {
            subscriptionPreferencePage.getSpecifiedCheckBoxAndClickOnIt(service, frequency, region);
        }
    }

    @Then("^the users \"(.*?)\" saved subscription preferences should be saved in Adestra$")
    public void theUsersSavedSubscriptionPreferencesShouldBeSavedInAdestra(String userEmail) throws Throwable {
        editedSubscriptionIDS = adestraUtils.getAdestraSubscriptionNameListForPLCUK(userEmail);
        assertTrue("User has no subscriptions or subscriptions number is not correct" + "subscriptions: " + editedSubscriptionIDS.toString() + "ssize: " + editedSubscriptionIDS.size(), adestraUtils.isUserHasCorrectSubscriptions(editedSpecifiedServices, editedSubscriptionIDS));
    }

    @Then("^the user should be unsubscribed from the \"(.*?)\" email service \"(.*?)\" \"(.*?)\"$")
    public void theUserShouldBeUnsubscribedFromTheEmailService(String region, String service, List<String> frequencies) throws Throwable {
        int result = 0;
        for (String frequency : frequencies) {
            if (subscriptionPreferencePage.getSpecifiedCheckBox(service, frequency, region).isSelected()) {
                result++;
            }
        }
        assertTrue("One of checkboxes is unavailbale", result == 0);
    }

    private List<SubscriptionParameters> removeSubscriptionFromSpecifiedServices(List<SubscriptionParameters> specifiedRegionServices, String region, String service, List<String> frequencies) {
        for (Iterator<SubscriptionParameters> it = specifiedRegionServices.iterator(); it.hasNext(); ) {
            SubscriptionParameters subscriptionParameter = it.next();
            for (String frequency : frequencies) {
                if (subscriptionParameter.getCategoryName().equals(region) && subscriptionParameter.getCommonName().equals(service) && subscriptionParameter.getProductFrequency().equals(frequency)) {
                    it.remove();
                }
            }
        }
        return specifiedRegionServices;
    }

}