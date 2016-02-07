package com.thomsonreuters.adestra.step_definitions.unsubscribe;

import com.thomsonreuters.adestra.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.pages.adestra.SubscriptionPreferencePage;
import com.thomsonreuters.pageobjects.utils.adestra.AdestraUtils;
import com.thomsonreuters.pageobjects.utils.adestra.SubscriptionParameters;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class AbilityToCancelSubscriptionTest extends BaseStepDef {

    private SubscriptionPreferencePage subscriptionPreferencePage = new SubscriptionPreferencePage();
    private AdestraUtils adestraUtils = new AdestraUtils();

    private List<SubscriptionParameters> editedSpecifiedServices;
    private List<SubscriptionParameters> specifiedServices;
    private List<String> editedSubscriptionIDS;

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
