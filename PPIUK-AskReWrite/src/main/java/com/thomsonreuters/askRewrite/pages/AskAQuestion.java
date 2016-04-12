package com.thomsonreuters.askRewrite.pages;

import com.thomsonreuters.driver.framework.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AskAQuestion extends AbstractPage {

    public WebElement resourceIdTextBox() {
        return waitForExpectedElement(By.id("resourceId"));
    }

    public WebElement nameTextBox() {
        return waitForExpectedElement(By.id("fromName"));
    }

    public WebElement firstNameTextBox() {
        return waitForExpectedElement(By.id("firstName"));
    }

    public WebElement lastNameTextBox() {
        return waitForExpectedElement(By.id("lastName"));
    }

    public WebElement askFormEmailTextBox() {
        return waitForExpectedElement(By.id("askFormUserEmail"));
    }

    public WebElement emailTextBox() {
        return waitForExpectedElement(By.id("userEmail"));
    }

    public WebElement commentsTextBox() {
        return waitForExpectedElement(By.id("comments"));
    }

    public WebElement submitButton() {
        return waitForExpectedElement(By.cssSelector("div[id='ffbuttons'] button:nth-of-type(1)"));
    }

    public WebElement cancelButton() {
        return waitForExpectedElement(By.cssSelector("div[id='ffbuttons'] button:nth-of-type(2)"));
    }

    public WebElement closeButton() {
        return waitForExpectedElement(By.cssSelector("button"));
    }

    public List<WebElement> errorFields() {
        return waitForExpectedElements(By.cssSelector("fieldset[class='plc-form'] span[class='msg-error']"));
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

}
