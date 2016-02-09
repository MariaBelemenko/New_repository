package com.thomsonreuters.ipusers.step_definitions.common;

import com.thomsonreuters.ipusers.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.pages.adestra.SubscriptionPreferencePage;
import com.thomsonreuters.pageobjects.utils.adestra.AdestraSubscriptionXMLParser;
import com.thomsonreuters.pageobjects.utils.adestra.AdestraUtils;
import com.thomsonreuters.pageobjects.utils.adestra.SubscriptionParameters;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class abilityToLoginInAsIPauthentificatedUser extends BaseStepDef {

    private AdestraUtils adestraUtils;

    private SubscriptionPreferencePage subscriptionPreferencePage;

    private AdestraSubscriptionXMLParser adestraSubscriptionXMLParser;

    private List<String> subscriptionIDS;

    public abilityToLoginInAsIPauthentificatedUser(){
        adestraUtils = new AdestraUtils();
        subscriptionPreferencePage = new SubscriptionPreferencePage();
        adestraSubscriptionXMLParser = new AdestraSubscriptionXMLParser();
    }

    @Then("^the user should be presented with the login page$")
    public void theUserShouldBePresentedWithTheLoginPage() throws Throwable {
        subscriptionPreferencePage.isTextPresent(By.xpath("//div[@class='email-preferences-widget email-preference-entry-panel ng-scope']/h3"), "Manage preferences for");
    }

    @When("^user enters his email address \"(.*?)\"$")
    public void userEntersHisEmailAddress(String emailAddress) throws Throwable {
        subscriptionPreferencePage.loginViaIpAuth(emailAddress);
    }

    @Then("^the user \"(.*?)\" should be presented with his subscriptions$")
    public void theUserShouldBePresentedWithHisSubscriptions(String emailAddress) throws Throwable {
        int result = 0;
        subscriptionIDS = adestraUtils.getAdestraSubscriptionNameListForPLCUK(emailAddress);
        List<SubscriptionParameters> existingSubscriptions = getServicesByIDs(subscriptionIDS);
        for (SubscriptionParameters service : existingSubscriptions) {
            subscriptionPreferencePage.openSpecifiedServiceTab(service.getCategoryName());
            if (!subscriptionPreferencePage.getSpecifiedCheckBox(service.getCommonName(), service.getProductFrequency(), service.getCategoryName()).isSelected()) {
                result++;
            }
        }
        assertTrue("One of services for  is unavailbale", result == 0);
    }

    public List<SubscriptionParameters> getServicesByIDs(List<String> subscriptionIDS) {
        List<SubscriptionParameters> listOfServices = new ArrayList<SubscriptionParameters>();
        List<SubscriptionParameters> allAvailableServices = adestraSubscriptionXMLParser.getResult();
        for (int i = 0; i < allAvailableServices.size(); i++) {
            for (int j = 0; j < subscriptionIDS.size(); j++) {
                if (allAvailableServices.get(i).getName().equals(subscriptionIDS.get(j))) {
                    listOfServices.add(allAvailableServices.get(i));
                }
            }
        }
        return listOfServices;
    }

}