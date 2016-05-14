package com.thomsonreuters.pageobjects.pages.calendar;

import com.thomsonreuters.driver.framework.AbstractPage;
import com.thomsonreuters.pageobjects.utils.ask.AskFormField;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;


public class CalendarWidgetPage extends AbstractPage {

    public WebElement calendarWidget() {
        return waitForExpectedElement(By.xpath("//div[@class='co_calendar_gridContainer']"));
    }
    public WebElement calendarWidgetMonthDropDown() {
        return waitForExpectedElement(By.xpath("//select[@class='co_calender_monthSelector']"));
    }
}
