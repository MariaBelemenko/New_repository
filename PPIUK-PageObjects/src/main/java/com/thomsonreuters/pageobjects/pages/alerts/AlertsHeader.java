package com.thomsonreuters.pageobjects.pages.alerts;

import com.thomsonreuters.driver.framework.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;



public class AlertsHeader extends AbstractPage {
    public WebElement sessionAnchor() {
        return waitAndFindElement(By.className("co_clientID_recent"));
    }
}
