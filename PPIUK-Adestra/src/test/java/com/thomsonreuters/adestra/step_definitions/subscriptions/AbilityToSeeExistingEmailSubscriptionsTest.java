package com.thomsonreuters.adestra.step_definitions.subscriptions;

import com.thomsonreuters.adestra.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.pages.adestra.SubscriptionPreferencePage;
import com.thomsonreuters.pageobjects.utils.adestra.AdestraUtils;
import com.thomsonreuters.pageobjects.utils.adestra.SubscriptionParameters;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AbilityToSeeExistingEmailSubscriptionsTest extends BaseStepDef {

    private AdestraUtils adestraUtils = new AdestraUtils();
    private SubscriptionPreferencePage subscriptionPreferencePage = new SubscriptionPreferencePage();

    private List<String> subscriptionIDS;
    private List<SubscriptionParameters> servicesForSpecifiedRegion;
    private List<SubscriptionParameters> existingSubscriptions;

    @Given("^a user \"(.*?)\" has a subscription to the '(\\d+)' Corporate practice areas \"(.*?)\" content$")
    public void aUserHasASubscriptionToTheCorporatePracticeAreasContent(String userEmail, int subscriptionsNumber, String region) throws Throwable {
        servicesForSpecifiedRegion = adestraUtils.getServiceForSpecifiedRegion(region);
        subscriptionIDS = adestraUtils.getAdestraSubscriptionNameListForPLCUK(userEmail);
        assertFalse("User has no subscriptions or subscriptions number is not correct", subscriptionIDS.isEmpty() && subscriptionIDS.size() != subscriptionsNumber);
    }

    @Then("^the user should be presented with their \"(.*?)\" corporate email service$")
    public void theUserShouldBePresentedWithTheirCorporateEmailService(String region) throws Throwable {
        int result = 0;
        subscriptionPreferencePage.openSpecifiedServiceTab(region);
        existingSubscriptions = adestraUtils.getServicesByIDs(servicesForSpecifiedRegion, subscriptionIDS, region);
        for (int i = 0; i < existingSubscriptions.size(); i++) {
            if (!subscriptionPreferencePage.getSpecifiedServiceField(existingSubscriptions.get(i).getCommonName(), region).isDisplayed()) {
                result++;
            }
        }
        assertTrue("One of services for " + region + " is unavailbale", result == 0);
    }

    @Then("^the check boxes should reflect their existing email subscriptions$")
    public void theCheckBoxesShouldReflectTheirExistingEmailSubscriptions() throws Throwable {
        int result = 0;
        for (SubscriptionParameters service : existingSubscriptions) {
            if (!subscriptionPreferencePage.getSpecifiedCheckBox(service.getCommonName(), service.getProductFrequency(), service.getCategoryName()).isSelected()) {
                LOG.info(service.getCategoryName() + "/" + service.getCommonName() + "/" + service.getProductFrequency() + " checkbox is unavailable");
                result++;
            }
        }
        assertTrue("One of checkboxes is unavailbale", result == 0);
    }

    @Then("^the check boxes should be selectable$")
    public void theCheckBoxesShouldBeSelectable() throws Throwable {
        int result = 0;
        for (SubscriptionParameters service : existingSubscriptions) {
            WebElement frequencyCheckBox = subscriptionPreferencePage.getSpecifiedCheckBox(service.getCommonName(), service.getProductFrequency(), service.getCategoryName());
            if (!subscriptionPreferencePage.isCheckBoxSelectable(frequencyCheckBox)) {
                result++;
            }
        }
        assertTrue("One of checkboxes for is not editable", result == 0);
    }

}
