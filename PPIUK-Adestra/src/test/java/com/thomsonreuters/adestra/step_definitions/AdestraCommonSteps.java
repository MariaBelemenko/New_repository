package com.thomsonreuters.adestra.step_definitions;

import com.thomsonreuters.pageobjects.pages.adestra.SubscriptionPreferencePage;
import com.thomsonreuters.pageobjects.pages.header.WLNHeader;
import com.thomsonreuters.pageobjects.utils.adestra.AdestraUtils;
import com.thomsonreuters.pageobjects.utils.screen_shot_hook.BaseStepDef;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

import java.util.List;

public class AdestraCommonSteps extends BaseStepDef {

	private AdestraUtils adestraUtils = new AdestraUtils();
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
    
    @After(order = 100000, value = "@UsubscribeUserFromAllSubscriptionsAndRemoveUnsubscribeOption")
    public void unsubscribeUserFromAllSubscriptionsAndRemoveUnsubscribeOption() throws Exception {
    	adestraUtils.removeSubscriptionViaAPI(currentUser.getEmail());
        subscriptionPreferencePage.removeUnsubscribeAllOption();
    }

}
