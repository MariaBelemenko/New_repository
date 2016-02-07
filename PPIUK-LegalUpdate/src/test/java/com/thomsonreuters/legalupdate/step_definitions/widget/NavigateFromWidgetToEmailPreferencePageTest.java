package com.thomsonreuters.legalupdate.step_definitions.widget;

import com.thomsonreuters.legalupdate.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.otherPages.NavigationCobalt;
import com.thomsonreuters.pageobjects.pages.legalUpdates.LegalUpdatesPracticeAreaPage;
import com.thomsonreuters.pageobjects.pages.legalUpdates.LegalUpdatesWidget;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import static org.junit.Assert.assertTrue;

public class NavigateFromWidgetToEmailPreferencePageTest extends BaseStepDef {

    private NavigationCobalt navigationCobalt = new NavigationCobalt();
    private LegalUpdatesPracticeAreaPage legalUpdatesPracticeAreaPage = new LegalUpdatesPracticeAreaPage();
    private LegalUpdatesWidget legalUpdatesWidget = new LegalUpdatesWidget();

    private final String MEDIA_AND_TELECOMS_PAGE = "/Browse/Home/Practice/MediaTelecoms";

    @Given("^a user is on the media and telecoms practice area page$")
    public void aUserIsOnTheMediaAndTelecomsPracticeAreaPage() throws Throwable {
        navigationCobalt.navigateToPLCUKPlusSpecificURL(MEDIA_AND_TELECOMS_PAGE);
        legalUpdatesPracticeAreaPage.waitForPageToLoadAndJQueryProcessing();
    }

    @Given("^the user has been presented with the legal updates widget$")
    public void theUserHasBeenPresentedWithTheLegalUpdatesWidget() throws Throwable {
        assertTrue("There is no legal updates widget", legalUpdatesPracticeAreaPage.legalUpdatesWidget().isDisplayed());
    }

    @Then("^the legal update widget should display a link labelled 'email preferences'$")
    public void theLegalUpdateWidgetShouldDisplayALinkLabelledEmailPreferences() throws Throwable {
        assertTrue("There is no email preferences link on widget", legalUpdatesWidget.emailPreferencesLink().isDisplayed());
    }

}
