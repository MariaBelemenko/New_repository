package com.thomsonreuters.pageobjects.pages.alerts.creationBellow;

import com.thomsonreuters.driver.framework.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ScheduleAlertBellow extends AbstractPage {
    public Select frequencyOfDeliverySelect() {
        return new Select(findElement(By.id("frequencySelect")));
    }

    public WebElement selectNoResultCheckbox() {
        return waitAndFindElement(By.id("co_noResultsAlert"));
    }

    public WebElement saveAlertButton() {
        return waitAndFindElement(By.id("co_button_saveAlert"));
    }
}
