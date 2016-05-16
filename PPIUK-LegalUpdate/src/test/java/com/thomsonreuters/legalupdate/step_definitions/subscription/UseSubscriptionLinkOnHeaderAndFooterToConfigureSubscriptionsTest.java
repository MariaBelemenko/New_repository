package com.thomsonreuters.legalupdate.step_definitions.subscription;

import com.thomsonreuters.legalupdate.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.pages.legalUpdates.LegalUpdatesResultsPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertTrue;

public class UseSubscriptionLinkOnHeaderAndFooterToConfigureSubscriptionsTest extends BaseStepDef {

    private LegalUpdatesResultsPage legalUpdatesResultsPage = new LegalUpdatesResultsPage();

    @When("^the user selects 'Subscribe' on the \"(.*?)\"$")
    public void theUserSelectsSubscribeOnThe(String headerOrFooterSubscribeLink) throws Throwable {
        legalUpdatesResultsPage.waitForExpectedElement(By.xpath(headerOrFooterSubscribeLink)).click();
    }

    @Then("^the user should be presented with a subscription popup$")
    public void theUserShouldBePresentedWithASubscriptionPopup() throws Throwable {
        assertTrue("Subscription Preferences widget is absent", legalUpdatesResultsPage.subscriptionPreferencesWidget().isDisplayed());
    }

    @Then("^the popup should contain features listed in the description$")
    public void thePopupShouldContainFeaturesListedInTheDescription(List<String> elementsLocators) throws Throwable {
        int result = 0;
        for (String elementLocator : elementsLocators) {
            try {
                if (!legalUpdatesResultsPage.subscriptionPreferencesWidget().findElement(By.xpath(elementLocator)).isDisplayed()) {
                    result++;
                }
            } catch (NoSuchElementException e) {
                LOG.info("Can't find element on legal updates results page: ", e);
                result++;
            }
        }
        assertTrue("One of features is not displayed", result == 0);
    }

}
