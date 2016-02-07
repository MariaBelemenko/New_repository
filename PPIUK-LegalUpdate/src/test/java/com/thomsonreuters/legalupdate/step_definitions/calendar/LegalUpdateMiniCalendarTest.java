package com.thomsonreuters.legalupdate.step_definitions.calendar;

import com.thomsonreuters.legalupdate.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.otherPages.NavigationCobalt;
import com.thomsonreuters.pageobjects.pages.legalUpdates.CalendarWidget;
import com.thomsonreuters.pageobjects.pages.legalUpdates.LegalUpdatesPracticeAreaPage;
import com.thomsonreuters.pageobjects.utils.legalUpdates.CalendarAndDate;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class LegalUpdateMiniCalendarTest extends BaseStepDef {

    private NavigationCobalt navigationCobalt = new NavigationCobalt();
    private LegalUpdatesPracticeAreaPage legalUpdatesPracticeAreaPage = new LegalUpdatesPracticeAreaPage();
    private CalendarWidget calendarWidget = new CalendarWidget();

    private String monthInFuture;
    private String monthBeforeScroll;

    @Given("^a user is viewing the month selector on the mini calendar$")
    public void aUserIsViewingTheMonthSelectorOnTheMiniCalendar() throws Throwable {
        navigationCobalt.navigateToPLCUKPlusSpecificURL("/browse/home/legalupdateslightbox");
        legalUpdatesPracticeAreaPage.waitForPageToLoadAndJQueryProcessing();
        calendarWidget.miniCalendarSelectedOptionInDropDown().click();
    }

    @When("^the user clicks on the option$")
    public void theUserClicksOnTheOption() throws Throwable {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, 1);
        int month = calendar.get(Calendar.MONTH);
        monthInFuture = CalendarAndDate.convertMonthFromIntToStringRepresentation(month);
        calendarWidget.selectMonthInMiniCalendarMonthDropDown(monthInFuture).click();
    }

    @Then("^the user should be presented with a mini calendar for the selcted month$")
    public void theUserShouldBePresentedWithAMiniCalendarForTheSelctedMonth() throws Throwable {
        int firstDayResult = CalendarAndDate.getWeekDayOfFirstDayInMonth(true);
        int lastDayResult = CalendarAndDate.getWeekDayOfLastDayInMonth(true);
        boolean firstDay = calendarWidget.isCorrectBeginOfMonthOnMiniCalendar(firstDayResult);
        boolean lastDay = calendarWidget.isCorrectEndOfMonthOnMiniCalendar(lastDayResult, CalendarAndDate.getLastDayOfMonth(true));
        assertTrue("First day and last day of choosen month are not correct", firstDay && lastDay);
    }

    @Then("^the selected month should be maintained as the selected month in the drop down list$")
    public void theSelectedMonthShouldBeMaintainedAsTheSelectedMonthInTheDropDownList() throws Throwable {
        calendarWidget.miniCalendarSelectedOptionInDropDown().click();
        assertTrue("Choosen month is not displayed in bold", calendarWidget.currentMonthInMiniCalendarDropDown().getText().contains(monthInFuture));
    }

    @Given("^the user is presented with an Up arrow on the month selector$")
    public void theUserIsPresentedWithAnUpArrowOnTheMonthSelector() throws Throwable {
        assertTrue("Up arrow is absent", calendarWidget.upArrowInMonthSelectMiniCalendar().isDisplayed());
    }

    @Given("^the user is presented with an Down arrow on the month selector$")
    public void theUserIsPresentedWithAnDownArrowOnTheMonthSelector() throws Throwable {
        assertTrue("Down arrow is absent", calendarWidget.downArrowInMonthSelectMiniCalendar().isDisplayed());
    }

    @When("^the User clicks on the Up arrow$")
    public void theUserClicksOnTheUpArrow() throws Throwable {
        monthBeforeScroll = calendarWidget.fifthMonthInPastFromMiniCalendarSelectOption().getText().split(" ")[0];
        calendarWidget.upArrowInMonthSelectMiniCalendar().click();
    }

    @Then("^the month selector should scroll to months in the past$")
    public void theMonthSelectorShouldScrollToMonthsInThePast() throws Throwable {
        String resultMonth = getLastMonthAfterScroll(monthBeforeScroll, false);
        String monthAfterScroll = calendarWidget.fifthMonthInPastFromMiniCalendarSelectOption().getText().split(" ")[0];
        assertTrue("Month is not correct", monthAfterScroll.equalsIgnoreCase(resultMonth));
    }

    @When("^the User clicks on the Down arrow$")
    public void theUserClicksOnTheDownArrow() throws Throwable {
        monthBeforeScroll = calendarWidget.fifthMonthInFutureFromMiniCalendarSelectOption().getText().split(" ")[0];
        calendarWidget.downArrowInMonthSelectMiniCalendar().click();
    }

    @Then("^the month selector should scroll to months in the future$")
    public void theMonthSelectorShouldScrollToMonthsInTheFuture() throws Throwable {
        String resultMonth = getLastMonthAfterScroll(monthBeforeScroll, true);
        String monthAfterScroll = calendarWidget.fifthMonthInPastFromMiniCalendarSelectOption().getText().split(" ")[0];
        assertTrue("Month is not correct", monthAfterScroll.equalsIgnoreCase(resultMonth));
    }

    @Given("^a user is vewing the drop down list on the mini-calendar$")
    public void aUserIsVewingTheDropDownListOnTheMiniCalendar() throws Throwable {
        navigationCobalt.navigateToPLCUKPlusSpecificURL("/browse/home/legalupdateslightbox");
        legalUpdatesPracticeAreaPage.waitForPageToLoadAndJQueryProcessing();
        assertTrue("There is no mini calendar widget", legalUpdatesPracticeAreaPage.calendarWidget().isDisplayed());
    }

    @Then("^the user should be presented with a list of months followed by the associated year$")
    public void theUserShouldBePresentedWithAListOfMonthsFollowedByTheAssociatedYear() throws Throwable {
        calendarWidget.miniCalendarSelectedOptionInDropDown().click();
        int result = 0;
        for (String date : calendarWidget.dateOptionsList()) {
            try {
                Integer.valueOf(date.split(" ")[1]);
            } catch (NumberFormatException nfe) {
                result++;
            }
        }
        assertTrue("One of options in drop down is incorrect", result == 0);
    }

    @Given("^a user is on full calendar view for the current month$")
    public void aUserIsOnFullCalendarViewForTheCurrentMonth() throws Throwable {
        navigationCobalt.navigateToPLCUKPlusSpecificURL("/browse/home/legalupdateslightbox");
        legalUpdatesPracticeAreaPage.waitForPageToLoadAndJQueryProcessing();
    }

    @Given("^the user is presented with a mini calendar for the current month$")
    public void theUserIsPresentedWithAMiniCalendarForTheCurrentMonth() throws Throwable {
        assertTrue("There is no mini calendar widget", legalUpdatesPracticeAreaPage.calendarWidget().isDisplayed());
    }

    @Given("^the mini calendar displays the name and year of the current month$")
    public void theMiniCalendarDisplaysTheNameAndYearOfTheCurrentMonth() throws Throwable {
        String currentDateMonthAndYear = calendarWidget.miniCalendarSelectedOptionInDropDown().getText();
        String currentYear = CalendarAndDate.getCurrentYear();
        String currentMonth = CalendarAndDate.getCurrentMonth();
        assertTrue("Current month and year are incorrect on mini calendar", currentDateMonthAndYear.contains(currentYear) && currentDateMonthAndYear.contains(currentMonth));
    }

    @When("^the user clicks on the name for the current month$")
    public void theUserClicksOnTheNameForTheCurrentMonth() throws Throwable {
        calendarWidget.miniCalendarSelectedOptionInDropDown().click();
    }

    @Then("^the user should be presented with a drop down list displaying the previous '5' months, the current month and the next '5' months$")
    public void theUserShouldBePresentedWithADropDownListDisplayingThePreviousMonthsTheCurrentMonthAndTheNextMonths() throws Throwable {
        List<String> dateList = new ArrayList<String>();
        dateList.addAll(getFiveMonthsInPast());
        dateList.add(CalendarAndDate.getCurrentMonth());
        dateList.addAll(getFiveMonthsInFuture());
        Collections.sort(dateList);
        List<String> dateListFromMiniCalendar = new ArrayList<String>();
        for (String date : calendarWidget.dateOptionsList()) {
            dateListFromMiniCalendar.add(date.substring(0, date.indexOf(" ")));
        }
        Collections.sort(dateListFromMiniCalendar);
        assertTrue("Current month and year are incorrect on mini calendar", dateList.equals(dateListFromMiniCalendar));
    }

    @Then("^the current month should be displayed in bold$")
    public void theCurrentMonthShouldBeDisplayedInBold() throws Throwable {
        assertTrue("Current month is not displayed in bold", calendarWidget.currentMonthInMiniCalendarDropDown().getText().contains(CalendarAndDate.getCurrentMonth()));
    }

    @Then("^the drop down list and the lightbox should have the ability to select a month$")
    public void theDropDownListAndTheLightboxShouldHaveTheAbilityToSelectAMonth() throws Throwable {
        calendarWidget.selectMonthInMiniCalendarMonthDropDown("January").click();
        assertTrue("Current month and year are incorrect on mini calendar", calendarWidget.miniCalendarSelectedOptionInDropDown().getText().contains("January"));
    }

    public List<String> rollFiveMonths(boolean isAdd) throws ParseException {
        List<String> fiveMonths = new ArrayList<String>();
        Calendar currentCalendar = Calendar.getInstance();
        for (int i = 0; i < 5; i++) {
            currentCalendar.roll(Calendar.MONTH, isAdd);
            int month = currentCalendar.get(Calendar.MONTH);
            fiveMonths.add(CalendarAndDate.convertMonthFromIntToStringRepresentation(month));
        }
        return fiveMonths;
    }

    public List<String> getFiveMonthsInFuture() throws ParseException {
        return rollFiveMonths(true);
    }

    public List<String> getFiveMonthsInPast() throws ParseException {
        return rollFiveMonths(false);
    }

    public String getLastMonthAfterScroll(String month, boolean scrollInFuture) throws NumberFormatException, ParseException {
        SimpleDateFormat monthParse = new SimpleDateFormat("MMMM");
        SimpleDateFormat monthDisplay = new SimpleDateFormat("M");
        int monthValue = Integer.parseInt(monthDisplay.format(monthParse.parse(month))) - 1;
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.MONTH, monthValue);
        cal.roll(Calendar.MONTH, scrollInFuture);
        return CalendarAndDate.convertMonthFromIntToStringRepresentation(cal.get(Calendar.MONTH));
    }

}
