package com.thomsonreuters.legalupdate.step_definitions.widget;

import com.thomsonreuters.legalupdate.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.otherPages.NavigationCobalt;
import com.thomsonreuters.pageobjects.pages.legalUpdates.LegalUpdatesResultsPage;
import com.thomsonreuters.pageobjects.pages.legalUpdates.SubscriptionPreferencesWidget;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static org.junit.Assert.assertTrue;

public class ContentToBeIncludedInMyAlertFromWidgetTest extends BaseStepDef {

    private NavigationCobalt navigationCobalt = new NavigationCobalt();
    private LegalUpdatesResultsPage legalUpdatesResultsPage = new LegalUpdatesResultsPage();
    private SubscriptionPreferencesWidget subscriptionPreferencesWidget = new SubscriptionPreferencesWidget();


    @Given("^a user is on the 'media and telecoms' practice area page$")
    public void aUserIsOnTheMediaAndTelecomsPracticeAreaPage() throws Throwable {
        navigationCobalt.navigateToPLCUKPlusSpecificURL("/Browse/Home/UnitedKingdomLegalUpdates/MediaTelecomsLegalUpdates");
        legalUpdatesResultsPage.waitForPageToLoadAndJQueryProcessing();
        legalUpdatesResultsPage.findElement(By.xpath("//div[@id='facet_div_multiplePracticeAreasUk']//label[contains(text(),'Media & Telecoms')]//ancestor::li//input[@type='checkbox']")).click();
        legalUpdatesResultsPage.waitForPageToLoadAndJQueryProcessing();
    }

    @When("^the user clicks the 'Subscribe' link on the Legal Updates Widget$")
    public void theUserClicksTheSubscribeLinkOnTheLegalUpdatesWidget() throws Throwable {
        legalUpdatesResultsPage.subscribeLink().click();
        legalUpdatesResultsPage.waitForPageToLoadAndJQueryProcessing();
    }

    @Then("^the user should be presented the subscription panel with a Subscription Details box$")
    public void theUserShouldBePresentedTheSubscriptionPanelWithASubscriptionDetailsBox() throws Throwable {
        assertTrue("Subscription Preferences widget is absent", subscriptionPreferencesWidget.detailsBox().isDisplayed());
    }

    @Then("^the subscription details box should display 'media & telecoms' under a Practice area heading$")
    public void theSubscriptionDetailsBoxShouldDisplayMediaTelecomsUnderAPracticeAreaHeading() throws Throwable {
        boolean result = false;
        if (subscriptionPreferencesWidget.detailsBoxPracticeAreas().size() == 1) {
            result = subscriptionPreferencesWidget.detailsBoxPracticeAreas().get(0).getText().equals("Media & Telecoms");
        } else {
            LOG.info("There is more then one Practice Area");
        }
        assertTrue("Practice Areas are displayed incorrectly", result);
    }

    @Then("^the subscription details box should display 'All' under a Topic heading$")
    public void theSubscriptionDetailsBoxShouldDisplayAllUnderATopicHeading() throws Throwable {
        boolean result = false;
        if (subscriptionPreferencesWidget.detailsBoxTopics().size() == 1) {
            result = subscriptionPreferencesWidget.detailsBoxTopics().get(0).getText().equals("All");
        } else {
            LOG.info("There is more then one Topic");
        }
        assertTrue("Topics are displayed incorrectly", result);
    }

    @Then("^the subscription details box should display 'All' under a Jurisdiction heading$")
    public void theSubscriptionDetailsBoxShouldDisplayAllUnderAJurisdictionHeading() throws Throwable {
        boolean result = false;
        if (subscriptionPreferencesWidget.detailsBoxJurisdictions().size() == 1) {
            result = subscriptionPreferencesWidget.detailsBoxJurisdictions().get(0).getText().equals("All");
        } else {
            LOG.info("There is more then one Jurisdiction");
        }
        assertTrue("Jurisdictions are displayed incorrectly", result);
    }

}
