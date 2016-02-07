package com.thomsonreuters.legalupdate.step_definitions.widget;

import com.thomsonreuters.legalupdate.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.otherPages.NavigationCobalt;
import com.thomsonreuters.pageobjects.pages.legalUpdates.CalendarWidget;
import com.thomsonreuters.pageobjects.pages.legalUpdates.LegalUpdatesPracticeAreaPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class ChangeEventPopUpIntoCalendarWidgetTest extends BaseStepDef {

    private NavigationCobalt navigationCobalt = new NavigationCobalt();
    private LegalUpdatesPracticeAreaPage legalUpdatesPracticeAreaPage = new LegalUpdatesPracticeAreaPage();
    private CalendarWidget calendarWidget = new CalendarWidget();

    private String eventDay;

    @Given("^a user is on the media & telecoms practice area page$")
    public void aUserIsOnTheMediaTelecomsPracticeAreaPage() throws Throwable {
        String MEDIA_AND_TELECOMS_PAGE = "/Browse/Home/Practice/MediaTelecoms";
        navigationCobalt.navigateToPLCUKPlusSpecificURL(MEDIA_AND_TELECOMS_PAGE);
        legalUpdatesPracticeAreaPage.waitForPageToLoadAndJQueryProcessing();
    }

    @Given("^a user has clicked on the event indicator$")
    public void aUserHasClickedOnTheEventIndicator() throws Throwable {
        calendarWidget.eventMarker().click();
        calendarWidget.waitForPageToLoadAndJQueryProcessing();
    }

    @Given("^the calendar widget has extended to display event information$")
    public void theCalendarWidgetHasExtendedToDisplayEventInformation() throws Throwable {
        assertTrue("Event LightBox is not displayed", calendarWidget.eventLightBox().isDisplayed());
    }

    @When("^the user clicks on a different event indicator on the calendar$")
    public void theUserClicksOnADifferentEventIndicatorOnTheCalendar() throws Throwable {
        List<WebElement> events = calendarWidget.getAlEeventMarkers();
        if (events.size() > 2) {
            WebElement nextEvent = events.get(1);
            eventDay = (nextEvent.getAttribute("value").length() == 2) ? nextEvent.getAttribute("value") : "0" + nextEvent.getAttribute("value");
            nextEvent.click();
        } else throw new RuntimeException("There is only one event in current month");
    }

    @Then("^the contents of the extended portion of the widget should change to reflect the events on the selected day$")
    public void theContentsOfTheExtendedPortionOfTheWidgetShouldChangeToReflectTheEventsOnTheSelectedDay() throws Throwable {
        String eventLightBoxTitle = calendarWidget.eventLightBoxTitle().getText();
        String currentMonthAndYearOnWidget = calendarWidget.currentMonthLabel().getText();
        String eventPopUpExpectedTitle = eventDay + " " + currentMonthAndYearOnWidget;
        assertTrue("Event LightBox title has not been changed", eventLightBoxTitle.contains(eventPopUpExpectedTitle));
    }

}
