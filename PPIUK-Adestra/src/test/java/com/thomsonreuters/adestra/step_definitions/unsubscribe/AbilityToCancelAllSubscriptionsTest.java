package com.thomsonreuters.adestra.step_definitions.unsubscribe;


import com.thomsonreuters.adestra.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.pages.adestra.SubscriptionPreferencePage;
import com.thomsonreuters.pageobjects.utils.adestra.AdestraUtils;
import com.thomsonreuters.pageobjects.utils.adestra.SubscriptionParameters;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class AbilityToCancelAllSubscriptionsTest extends BaseStepDef {

    private AdestraUtils adestraUtils = new AdestraUtils();
    private SubscriptionPreferencePage subscriptionPreferencePage = new SubscriptionPreferencePage();

    private List<SubscriptionParameters> specifiedServices;
    private List<String> existingSubscriptionIDS;

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

}
