package com.thomsonreuters.adestra.step_definitions.unsubscribe;

import com.thomsonreuters.adestra.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.pages.adestra.SubscriptionPreferencePage;
import com.thomsonreuters.pageobjects.utils.adestra.AdestraUtils;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AbilityToCancelUpdatesForOutOfPlanSubscriptionsTest extends BaseStepDef {

    private AdestraUtils adestraUtils = new AdestraUtils();
    private SubscriptionPreferencePage subscriptionPreferencePage = new SubscriptionPreferencePage();

    @Given("^a user \"(.*?)\" has subscription for corporate daily \"(.*)\" out of plan email service$")
    public void aUserHasSubscriptionForOutOfPlanEmailService(String userEmail, List<String> subscriptionsID) throws Throwable {
        adestraUtils.createSubscriptionViaAPI(userEmail, subscriptionsID);
    }

    @When("^the user has opened the UK Services tab$")
    public void theUserHasOpenedTheUKServicesTab() throws Throwable {
        subscriptionPreferencePage.ukServiceTabLink().click();
    }

    @Then("^the user should be presented with their Corporate email service row$")
    public void theUserShouldBePresentedWithTheirCorporateEmailServiceRow() throws Throwable {
        assertTrue("Corporate row is absent", subscriptionPreferencePage.getSpecifiedServiceField("Corporate", "UK").isDisplayed());
    }

    @Then("^the user should be presented with a 'Request a trial' link on the row$")
    public void theUserShouldBePresentedWithARequestATrialLinkOnTheRow() throws Throwable {
        assertTrue("'Request a trial' link is absent", subscriptionPreferencePage.getSpecifiedServiceRequestTrialLink("Corporate", "UK").isDisplayed());
    }

    @Then("^the daily check box should be ticked$")
    public void theDailyCheckBoxShouldBeTicked() throws Throwable {
        assertTrue("Checkbox is not selected", subscriptionPreferencePage.getSpecifiedCheckBox("Corporate", "D", "UK").isSelected());
    }

    @When("^the user unchecks the Daily check box$")
    public void theUserUnchecksTheDailyCheckBox() throws Throwable {
        subscriptionPreferencePage.getSpecifiedCheckBoxAndClickOnIt("Corporate", "D", "UK");
    }

    @Then("^the daily check box becomes uncheckable$")
    public void theDailyCheckBoxBecomesUncheckable() throws Throwable {
        assertFalse("Checkbox is selectable", subscriptionPreferencePage.isCheckBoxSelectable(subscriptionPreferencePage.getSpecifiedCheckBox("Corporate", "D", "UK")));
    }

}
