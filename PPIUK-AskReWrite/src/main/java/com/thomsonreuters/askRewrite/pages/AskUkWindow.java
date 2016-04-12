package com.thomsonreuters.askRewrite.pages;

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
