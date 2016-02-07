package com.thomsonreuters.adestra.step_definitions.unsubscribe;

import com.thomsonreuters.adestra.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.pages.adestra.SubscriptionPreferencePage;
import com.thomsonreuters.pageobjects.utils.adestra.AdestraUtils;
import com.thomsonreuters.pageobjects.utils.adestra.SubscriptionParameters;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AbilityToSeeRequestTrialLinkForUnsubscribedUserTest extends BaseStepDef {

    private AdestraUtils adestraUtils = new AdestraUtils();
    private SubscriptionPreferencePage subscriptionPreferencePage = new SubscriptionPreferencePage();

    private List<SubscriptionParameters> servicesForSpecifiedRegion;

    @Given("^^a user \"(.*?)\" does not have subscription to the \"(.*?)\" practice area \"(.*?)\" content$")
    public void aUserDoesNotHaveSubscriptionToThePracticeAreaContent(String userEmail, List<String> services, String region) throws Throwable {
        servicesForSpecifiedRegion = adestraUtils.getServiceForSpecifiedRegion(region);
        boolean isHasSubscriptions = adestraUtils.getAdestraSubscriptionNameListForPLCUK(userEmail).isEmpty() ? false : getPLCUKSubscriptionNameList(servicesForSpecifiedRegion, services).containsAll(adestraUtils.getAdestraSubscriptionNameListForPLCUK(userEmail));
        assertFalse("User has subscription for one of services", isHasSubscriptions);
    }

    @Then("^the user should be presented with their \"(.*?)\" email \"(.*?)\" service$")
    public void theUserShouldBePresentedWithTheirEmailService(List<String> services, String region) throws Throwable {
        subscriptionPreferencePage.openSpecifiedServiceTab(region);
        int result = 0;
        for (int i = 0; i < services.size(); i++) {
            if (!subscriptionPreferencePage.getSpecifiedServiceField(services.get(i), region).isDisplayed()) {
                result++;
            }
        }
        assertTrue("One of services for " + region + " is unavailbale", result == 0);
    }

    @Then("^the \"(.*?)\" \"(.*?)\" services row will display the appropriate frequency check boxes$")
    public void theServicesRowWillDisplayTheAppropriateFrequencyCheckBoxes(List<String> services, String region) throws Throwable {
        List<SubscriptionParameters> listOfSpecifiedServices = getSpecifiedServices(servicesForSpecifiedRegion, services);
        int result = 0;
        for (SubscriptionParameters service : listOfSpecifiedServices) {
            if (!subscriptionPreferencePage.isSpecifiedCheckBoxDisplayed(service.getCommonName(), service.getProductFrequency(), region)) {
                result++;
            }
        }
        assertTrue("One of checkboxes for " + region + " is not visible", result == 0);
    }

    @Then("^the \"(.*?)\" \"(.*?)\" check boxes will be uncheckable$")
    public void theCheckBoxesWillBeUncheckable(List<String> services, String region) throws Throwable {
        List<SubscriptionParameters> listOfSpecifiedServices = getSpecifiedServices(servicesForSpecifiedRegion, services);
        int result = 0;
        for (SubscriptionParameters service : listOfSpecifiedServices) {
            WebElement frequencyCheckBox = subscriptionPreferencePage.getSpecifiedCheckBox(service.getCommonName(), service.getProductFrequency(), region);
            if (subscriptionPreferencePage.isCheckBoxSelectable(frequencyCheckBox)) {
                result++;
            }
        }
        assertTrue("One of checkboxes for " + region + " is editable", result == 0);
    }

    @Then("^the user should be presented with a 'Request a trial' link on the \"(.*?)\" row \"(.*?)\"$")
    public void theUserShouldBePresentedWithARequestATrialLinkOnTheRow(List<String> services, String region) throws Throwable {
        int result = 0;
        for (int i = 0; i < services.size(); i++) {
            if (!subscriptionPreferencePage.getSpecifiedServiceRequestTrialLink(services.get(i), region).isDisplayed()) {
                result++;
            }
        }
        assertTrue("One of services for " + region + " has incorrect background", result == 0);
    }

    public List<String> getPLCUKSubscriptionNameList(List<SubscriptionParameters> subscriptionParameters, List<String> services) {
        List<String> ids = new ArrayList<String>();
        for (int i = 0; i < subscriptionParameters.size(); i++) {
            for (int j = 0; j < services.size(); j++) {
                if (subscriptionParameters.get(i).getCommonName().equalsIgnoreCase(services.get(j))) {
                    ids.add(subscriptionParameters.get(i).getName());
                }
            }
        }
        return ids;
    }

    public List<SubscriptionParameters> getSpecifiedServices(List<SubscriptionParameters> servicesForSpecifiedRegion, List<String> specifiedServices) {
        List<SubscriptionParameters> listOfSpecifiedServices = new LinkedList<SubscriptionParameters>();
        for (int i = 0; i < servicesForSpecifiedRegion.size(); i++) {
            for (int j = 0; j < specifiedServices.size(); j++) {
                if (servicesForSpecifiedRegion.get(i).getCommonName().equalsIgnoreCase(specifiedServices.get(j))) {
                    listOfSpecifiedServices.add(servicesForSpecifiedRegion.get(i));
                }
            }
        }
        return listOfSpecifiedServices;
    }

}
