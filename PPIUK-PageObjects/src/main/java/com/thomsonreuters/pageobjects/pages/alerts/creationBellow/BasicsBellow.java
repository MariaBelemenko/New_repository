package com.thomsonreuters.pageobjects.pages.alerts.creationBellow;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.thomsonreuters.driver.framework.AbstractPage;

public class BasicsBellow extends AbstractPage {
    public WebElement alertNameInput() {
		return waitForExpectedElement(By.id("optionsAlertName"), 5);
    }

    public WebElement alertDescriptionTextarea() {
        return waitAndFindElement(By.id("optionsAlertDescription"));
    }

    public WebElement clientIDSpan() {
        return waitAndFindElement(By.className("co_clientIDInline_recent"));
    }

    public WebElement continueBasicsButton() {
        return waitAndFindElement(By.id("co_button_continue_Basics"));
    }
}
