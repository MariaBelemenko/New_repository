package com.thomsonreuters.legalupdate.step_definitions.calendar;

import com.thomsonreuters.legalupdate.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.otherPages.NavigationCobalt;
import com.thomsonreuters.pageobjects.pages.legalUpdates.CalendarWidget;
import com.thomsonreuters.pageobjects.pages.legalUpdates.KeyDatesPage;
import com.thomsonreuters.pageobjects.pages.legalUpdates.LegalUpdatesPracticeAreaPage;
import com.thomsonreuters.pageobjects.utils.legalUpdates.CalendarAndDate;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class LegalUpdateCalendarTest extends BaseStepDef {

    private NavigationCobalt navigationCobalt = new NavigationCobalt();
    private LegalUpdatesPracticeAreaPage legalUpdatesPracticeAreaPage = new LegalUpdatesPracticeAreaPage();
    private CalendarWidget calendarWidget = new CalendarWidget();
    private KeyDatesPage keyDatesPage = new KeyDatesPage();

    private int firstDayResult;
    private int lastDayResult;
    private boolean firstDay;
    private boolean lastDay;

    @Given("^a User is viewing the full calender view for a the current month$")
    public void aUserIsViewingTheFullCalenderViewForATheCurrentMonth() throws Throwable {
        String MEDIA_AND_TELECOMS_PAGE = "/browse/home/legalupdateslightbox";
        navigationCobalt.navigateToPLCUKPlusSpecificURL(MEDIA_AND_TELECOMS_PAGE);
        legalUpdatesPracticeAreaPage.waitForPageToLoadAndJQueryProcessing();
        assertTrue("There is no mini calendar widget", legalUpdatesPracticeAreaPage.calendarWidget().isDisplayed());
    }

    @Then("^the user should be presented with a mini calendar for the current month$")
    public void theUserShouldBePresentedWithAMiniCalendarForTheCurrentMonth() throws Throwable {
        String currentDateMonthAndYear = calendarWidget.miniCalendarCurrentMonth().getText();
        String currentYear = CalendarAndDate.getCurrentYear();
        String currentMonth = CalendarAndDate.getCurrentMonth();
        assertTrue("Current month and year are incorrect on mini calendar",
                currentDateMonthAndYear.contains(currentYear) && currentDateMonthAndYear.contains(currentMonth));
    }

    @Then("^the mini calendar should have display left and right navigation arrows$")
    public void theMiniCalendarShouldHaveDisplayLeftAndRightNavigationArrows() throws Throwable {
        assertTrue("There are no left and right navigation arrows",
                calendarWidget.rightArrowButton().isDisplayed() && calendarWidget.leftArrowButton().isDisplayed());
    }

    @When("^the user click the left facing arrow$")
    public void theUserClickTheLeftFacingArrow() throws Throwable {
        calendarWidget.leftArrowButton().click();
        calendarWidget.waitForPageToLoadAndJQueryProcessing();
    }

    @Then("^the user should be presented with the mini calendar for the previous month$")
    public void theUserShouldBePresentedWithTheMiniCalendarForThePreviousMonth() throws Throwable {
        firstDayResult = CalendarAndDate.getWeekDayOfFirstDayInMonth(false);
        lastDayResult = CalendarAndDate.getWeekDayOfLastDayInMonth(false);
        firstDay = calendarWidget.isCorrectBeginOfMonthOnMiniCalendar(firstDayResult);
        lastDay = calendarWidget.isCorrectEndOfMonthOnMiniCalendar(lastDayResult, CalendarAndDate.getLastDayOfMonth(false));
        assertTrue("First day and last day are not correct", firstDay && lastDay);
    }

    @When("^the user click the right facing arrow$")
    public void theUserClickTheRightFacingArrow() throws Throwable {
        calendarWidget.rightArrowButton().click();
        calendarWidget.waitForPageToLoadAndJQueryProcessing();
    }

    @Then("^the user should be presented with the mini calendar for the next month$")
    public void theUserShouldBePresentedWithTheMiniCalendarForTheNextMonth() throws Throwable {
        firstDayResult = CalendarAndDate.getWeekDayOfFirstDayInMonth(true);
        lastDayResult = CalendarAndDate.getWeekDayOfLastDayInMonth(true);
        firstDay = calendarWidget.isCorrectBeginOfMonthOnMiniCalendar(firstDayResult);
        lastDay = calendarWidget.isCorrectEndOfMonthOnMiniCalendar(lastDayResult, CalendarAndDate.getLastDayOfMonth(true));
        assertTrue("First day and last day are not correct", firstDay && lastDay);
    }

    @Given("^the user is presented with the date range drop down list$")
    public void theUserIsPresentedWithTheDateRangeDropDownList(List<String> selectOptions) throws Throwable {
        assertTrue("Date Range select box is not displayed correctly",
                selectOptions.containsAll(keyDatesPage.getOptionsInDateRangeDropDown()));
    }

    @Given("^the user is presented with date range arrows$")
    public void theUserIsPresentedWithDateRangeArrows() throws Throwable {
        assertTrue("date rabge arrows are not displayed",
                keyDatesPage.dateRangeLeftArrow().isDisplayed() && keyDatesPage.dateRangeRightArrow().isDisplayed());
    }

    @Then("^user should be presented with a Events without Dates widget$")
    public void userShouldBePresentedWithAEventsWithoutDatesWidget() throws Throwable {
        assertTrue("Event Without Dates widget is not displayed", keyDatesPage.eventsWithoutDatesWidget().isDisplayed());
    }

    @Then("^Events without Dates widget should contain sections mentioned in description$")
    public void eventsWithoutDatesWidgetShouldContainSectionsMentionedInDescription(List<String> sectionList) throws Throwable {
        assertTrue("Event Without Dates widget contains not all sections", sectionList.containsAll(keyDatesPage.getAllSections()));
    }

    @Given("^the user is presented with the info details button$")
    public void theUserIsPresentedWithTheInfoDetailsButton(List<String> options) throws Throwable {
        assertTrue("Details button or one of the option is absent",
                options.containsAll(keyDatesPage.getOptionsInInfoDetailsButton()) && keyDatesPage.infoDetailButton().isDisplayed());
    }

}
