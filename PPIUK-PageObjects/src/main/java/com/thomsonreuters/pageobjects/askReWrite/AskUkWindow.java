package com.thomsonreuters.pageobjects.askReWrite;

import com.thomsonreuters.driver.framework.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AskUkWindow extends AbstractPage {

    public AskUkWindow() {
    }

    public WebElement submitButton() {
        return waitForExpectedElement(By.id("submitButton"));
    }

}
