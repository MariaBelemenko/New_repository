package com.thomsonreuters.pageobjects.pages.alerts;

import com.thomsonreuters.driver.framework.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;



public class AlertsCenterPage extends AbstractPage {

    public WebElement createAlertDropdownLink() {
        return waitForExpectedElement(By.xpath("//a[@title='Create Alert']"));
    }

    public WebElement createSpecificAlertLink(String alertType) {
        return waitForExpectedElement(By.xpath("//a[@class='co_navDropDownHeader']/strong[text()='" + alertType + "']"));
    }

}
