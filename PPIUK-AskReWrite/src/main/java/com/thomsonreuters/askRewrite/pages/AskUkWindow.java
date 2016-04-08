package com.thomsonreuters.askRewrite.pages;


import com.thomsonreuters.driver.framework.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;


public class AskUkWindow extends AbstractPage {

    public AskUkWindow() {
    	
    }

    public WebElement firstNameTextBox() {
        return waitForExpectedElement(By.id("firstName"));
    }

    public WebElement lastNameTextBox() {
        return waitForExpectedElement(By.id("lastName"));
    }

    public WebElement emailTextBox() {
        return waitForExpectedElement(By.id("askFormUserEmail"));
    }

    public WebElement jurisdictionListBox() {
        return waitForExpectedElement(By.id("jurisdiction"));
    }

    public WebElement organisationListBox() {
        return waitForExpectedElement(By.id("organisationType"));
    }

    public WebElement positionListBox() {
        return waitForExpectedElement(By.id("position"));
    }

    public WebElement answeringServiceListBox() {
        return waitForExpectedElement(By.id("answeringService"));
    }

    public WebElement submitButton() {
        return waitForExpectedElement(By.id("submitButton"));
    }

    public WebElement askDisclaimerCheckbox() {
        return waitForExpectedElement(By.id("disclaimerRead1"));
    }

    public WebElement askCommentsTextbox() {
        return waitForExpectedElement(By.id("comments"));
    }

    public WebElement askSubmitText() {
        return waitForExpectedElement(By.xpath("//div/div/p"));
    }

    public WebElement askCloseButton() {
        return waitForExpectedElement(By.xpath("//button"));
    }

    public WebElement resourceIdTextBox() {
        return waitForExpectedElement(By.id("resourceId"));
    }
}
