package com.thomsonreuters.adestra.step_definitions;

import com.thomsonreuters.pageobjects.pages.adestra.SubscriptionPreferencePage;
import com.thomsonreuters.pageobjects.pages.header.WLNHeader;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

import java.util.List;

public class AdestraCommonSteps extends BaseStepDef {

    private WLNHeader wlnHeader = new WLNHeader();
    private SubscriptionPreferencePage subscriptionPreferencePage = new SubscriptionPreferencePage();

    @Given("^a user is viewing the email preference page$")
    public void aUserIsViewingTheEmailPreferencePage() throws Throwable {
        wlnHeader.openEmailPreferences();
        subscriptionPreferencePage.waitForPageToLoadAndJQueryProcessingWithCustomTimeOut(90);
    }

    @When("^the user navigates to the email preference page$")
    public void theUserNavigatesToTheEmailPreferencePage() throws Throwable {
        wlnHeader.openEmailPreferences();
        subscriptionPreferencePage.waitForPageToLoadAndJQueryProcessingWithCustomTimeOut(90);
    }

    @Given("^a user creates subscription to the \"(.*?)\" \"(.*?)\" email service with \"(.*?)\"$")
    public void aUserCreatesSubscriptionToTheEmailServiceWith(String region, String service, List<String> frequencies) throws Throwable {
        subscriptionPreferencePage.openSpecifiedServiceTab(region);
        subscriptionPreferencePage.createSubscriptions(region, service, frequencies);
    }

}