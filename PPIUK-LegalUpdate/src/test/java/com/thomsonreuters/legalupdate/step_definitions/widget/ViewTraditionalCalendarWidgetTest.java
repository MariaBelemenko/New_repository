package com.thomsonreuters.legalupdate.step_definitions.widget;

import com.thomsonreuters.legalupdate.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.pages.landingPage.PracticalLawHomepage;
import com.thomsonreuters.pageobjects.pages.legalUpdates.CalendarWidget;
import com.thomsonreuters.pageobjects.pages.legalUpdates.LegalUpdatesPracticeAreaPage;
import com.thomsonreuters.pageobjects.pages.pageCreation.HomePage;
import com.thomsonreuters.pageobjects.utils.legalUpdates.CalendarAndDate;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertTrue;

public class ViewTraditionalCalendarWidgetTest extends BaseStepDef {

    private PracticalLawHomepage practicalLawHomepage = new PracticalLawHomepage();
    private LegalUpdatesPracticeAreaPage legalUpdatesPracticeAreaPage = new LegalUpdatesPracticeAreaPage();
    private CalendarWidget calendarWidget = new CalendarWidget();
    private HomePage homePage = new HomePage();

    @Given("^a user is on the website home page$")
    public void aUserIsOnTheWebsiteHomePage() throws Throwable {
        practicalLawHomepage.practiceLink().click();
        legalUpdatesPracticeAreaPage.waitForPageToLoadAndJQueryProcessing();
    }

    @When("^the user navigates to the 'Media & Telecoms' practice area browse page$")
    public void theUserNavigatesToTheMediaTelecomsPracticeAreaBrowsePage() throws Throwable {
        homePage.selectLinkPresentOnTab("Media & Telecoms");
        legalUpdatesPracticeAreaPage.waitForPageToLoadAndJQueryProcessing();
    }

    @Then("^the user should be presented with a calendar widget for the current month$")
    public void theUserShouldBePresentedWithACalendarWidgetForTheCurrentMonth() throws Throwable {
        if (legalUpdatesPracticeAreaPage.calendarWidget().isDisplayed()) {
            String currentMonth = CalendarAndDate.getCurrentMonth();
            assertTrue("Current Month is not correct on calendar widget", calendarWidget.currentMonthLabel().getText().contains(currentMonth));
        } else throw new RuntimeException("Calendar Widget is not Displayed");
    }

    @Then("^the user should be presented with an indicator on days on which events occur$")
    public void theUserShouldBePresentedWithAnIndicatorOnDaysOnWhichEventsOccur() throws Throwable {
        assertTrue("There are no event markers on calendar widget", calendarWidget.eventMarker().isDisplayed());
    }

    @When("^the user clicks on an event indicator$")
    public void theUserClicksOnAnEventIndicator() throws Throwable {
        calendarWidget.eventMarker().click();
        calendarWidget.waitForPageToLoadAndJQueryProcessing();
    }

    @Then("^the user should be presented with a lightbox$")
    public void theUserShouldBePresentedWithALightbox() throws Throwable {
        assertTrue("Event LightBox is not displayed", calendarWidget.eventLightBox().isDisplayed());
    }

    @Then("^the lightbox should contain the title and snippet of that event$")
    public void theLightboxShouldContainTheTitleAndSnippetOfThatEvent() throws Throwable {
        String titleText = calendarWidget.eventTitleInLightBox().getText();
        String snippetText = calendarWidget.eventSnippetInLightBox().getText();
        assertTrue("Title or Snippet in Event Lightbox are empty", !titleText.isEmpty() && !snippetText.isEmpty());
    }

}
