package com.thomsonreuters.calendar.step_definitions.calendarWidget;

import com.thomsonreuters.calendar.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.common.ListFunctions;
import com.thomsonreuters.pageobjects.otherPages.NavigationCobalt;
import com.thomsonreuters.pageobjects.pages.calendar.CalendarWidgetPage;
import com.thomsonreuters.pageobjects.pages.plPlusKnowHowResources.KHResourcePage;
import com.thomsonreuters.pageobjects.utils.legalUpdates.CalendarAndDate;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CalendarWidgetTest extends BaseStepDef {

    private NavigationCobalt navigationCobalt = new NavigationCobalt();
    private KHResourcePage resourcePage = new KHResourcePage();
    private CalendarWidgetPage calendarWidgetPage= new CalendarWidgetPage();
    private ListFunctions listFunctions= new ListFunctions();
    //private CalendarAndDate calendarAndDate =new CalendarAndDate();

    @When("^user navigates directly to document with plcref \"(.*?)\"$")
    public void userNavigatesDirectlyToDocumentWithPlcref(String plcRef) throws Throwable {
        navigationCobalt.navigateToWLNSpecificResourcePage("/" + plcRef);
        resourcePage.waitForPageToLoadAndJQueryProcessing();
    }

    @Then("^a calendar widget is presented to the user$")
    public void aCalendarWidgetIsPresentedToTheUser() throws Throwable {
        Assert.assertTrue("Calendar widget not present..!", calendarWidgetPage.calendarWidget().isDisplayed());
    }

    @Then("^the user should be presented with a drop down$")
    public void theUserShouldBePresentedWithADropDown() throws Throwable {

    }

    @Then("^the current month should be selected by default$")
    public void theCurrentMonthShouldBeSelectedByDefault() throws Throwable {
        String selectedValue=listFunctions.getSelectedValueList(calendarWidgetPage.calendarWidgetMonthDropDown()).trim();
        String selectedValueArr[]=selectedValue.split(" ");
        System.out.println("SelectedValueArr : "+selectedValueArr[0]+", "+selectedValueArr[1]);
        System.out.println("Current Month : "+CalendarAndDate.getCurrentMonth());
        Assert.assertTrue("Month is not current..!", selectedValueArr[0].equalsIgnoreCase(CalendarAndDate.getCurrentMonth()));
        Assert.assertTrue("Year is not current..!", selectedValueArr[1].equalsIgnoreCase(CalendarAndDate.getCurrentYear()));
    }

    @When("^the user clicks on the drop down$")
    public void theUserClicksOnTheDropDown() throws Throwable {
       calendarWidgetPage.calendarWidgetMonthDropDown().click();
    }

    @Then("^the user should be presented with the \"([^\"]*)\" month option selected in the drop down$")
    public void theUserShouldBePresentedWithTheMonthOptionSelectedInTheDropDown(String month) throws Throwable {
       if(month.equalsIgnoreCase("Current")){
           theCurrentMonthShouldBeSelectedByDefault();
       }else{
           Thread.sleep(2000);
           String selectedValue=listFunctions.getSelectedValueList(calendarWidgetPage.calendarWidgetMonthDropDown()).trim();
           String selectedValueArr[]=selectedValue.split(" ");
           Assert.assertTrue(month+ " is not selected..!", selectedValueArr[0].equalsIgnoreCase(month));
       }
    }

    @Then("^the user should be seeing the next (\\d+) months and the past (\\d+) months to \"([^\"]*)\" month$")
    public void theUserShouldBeSeeingTheNextMonthsAndThePastMonthsToMonth(int nextNoOfMonth, int preNoofMonth, String selectedMonth) throws Throwable {
        List<WebElement> monthDropDownList=listFunctions.getAllOptionElements(calendarWidgetPage.calendarWidgetMonthDropDown());
//        int selectedMonIndex= listFunctions.getFirstSelectedOptionIndex(calendarWidgetPage.calendarWidgetMonthDropDown());
        String selectedValue=listFunctions.getSelectedValueList(calendarWidgetPage.calendarWidgetMonthDropDown()).trim();
        String selectedValueArr[]=selectedValue.split(" ");

        if(selectedMonth.equalsIgnoreCase("Current")) {
            selectedMonth = selectedValueArr[0].trim();
        }

        for(int index=0; index<monthDropDownList.size();index++){
            String indexdPreMonth = CalendarAndDate.getAddSubToChosenMonth(selectedMonth, index - preNoofMonth);
            if(index<5) {

                 System.out.println("With index "+index+" Previous Month:"+ indexdPreMonth);
                 System.out.println("With index "+index+" Dropdown Month:"+ monthDropDownList.get(index).getText().trim());
                 Assert.assertTrue(indexdPreMonth + "Month is not found..!",
                         monthDropDownList.get(index).getText().trim().contains(indexdPreMonth));
             }else if(index>5) {
                System.out.println("With index "+index+" Next Month :"+ indexdPreMonth);
                Assert.assertTrue(indexdPreMonth + "Month is not found..!",
                        monthDropDownList.get(index).getText().trim().contains(indexdPreMonth));
            }
        }
    }

    @When("^the user has selected \"([^\"]*)\" month in the drop down$")
    public void theUserHasSelectedMonthInTheDropDown(String option) throws Throwable {
             listFunctions.selectByVisibleText(calendarWidgetPage.calendarWidgetMonthDropDown(),option);
    }
    @Given("^a user has selected \"([^\"]*)\" month using the navigation arrows$")
    public void aUserHasSelectedMonthUsingTheNavigationArrows(String arg1) throws Throwable {

    }

}
