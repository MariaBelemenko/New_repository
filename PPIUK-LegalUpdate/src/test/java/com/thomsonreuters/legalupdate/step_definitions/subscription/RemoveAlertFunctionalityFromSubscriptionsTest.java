package com.thomsonreuters.legalupdate.step_definitions.subscription;

import com.thomsonreuters.legalupdate.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.pages.legalUpdates.SubscriptionPreferencesWidget;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import static org.junit.Assert.assertFalse;

public class RemoveAlertFunctionalityFromSubscriptionsTest extends BaseStepDef {

    private SubscriptionPreferencesWidget subscriptionPreferencesWidget = new SubscriptionPreferencesWidget();

    @Then("^the user should not be presented with the 'Add to existing Update' Checkbox$")
    public void theUserShouldNotBePresentedWithTheAddToExistingUpdateCheckbox() throws Throwable {
        boolean isDisplayed = true;
        try {
            subscriptionPreferencesWidget.findElement(By.xpath("//div[@id='nameBox']//descendant::input[@id='addToExisting']"));
        } catch (NoSuchElementException nse) {
            isDisplayed = false;
        }
        assertFalse("Add to existing checkbox is displayed", isDisplayed);
    }

    @Then("^the user should not be presented with the 'Select update' Select box$")
    public void theUserShouldNotBePresentedWithTheSelectUpdateSelectBox() throws Throwable {
        boolean isDisplayed = true;
        try {
            subscriptionPreferencesWidget.findElement(By.xpath("//div[@id='nameBox']//descendant::select[@id='existingUpdates']"));
        } catch (NoSuchElementException nse) {
            isDisplayed = false;
        }
        assertFalse("Select existing update dropdown is displayed", isDisplayed);
    }

}
