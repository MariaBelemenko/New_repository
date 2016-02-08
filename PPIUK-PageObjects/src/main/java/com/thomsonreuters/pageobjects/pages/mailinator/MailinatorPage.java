package com.thomsonreuters.pageobjects.pages.mailinator;

import com.thomsonreuters.driver.framework.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MailinatorPage extends AbstractPage {

    public MailinatorPage() {
    }

    public WebElement userMailBoxHeading() {
        return waitForExpectedElement(By.id("InboxNameCtrl"));
    }

    public WebElement checkMailTextBox() {
        return waitForExpectedElement(By.id("inboxfield"));
    }

    public List<WebElement> emailFrom() {
        return waitForExpectedElements(By.xpath("//div[@id='InboxCtrl']//li//div[@class='from ng-binding']"), 90);
    }

    public List<WebElement> emailSubject() {
        return waitForExpectedElements(By.xpath("//div[@id='InboxCtrl']//li//div[@class='subject ng-binding']"), 90);
    }

    public List<WebElement> emailTimeDesc() {
        return waitForElementsVisible(By.xpath("//div[@id='InboxCtrl']//li//div[@class='time ng-binding']"));
    }

    public WebElement checkItButton() {
        return waitForElementVisible(By.xpath("//button[contains(text(),'Go!')]"));
    }

    public WebElement deleteEmailButton() {
        return waitForElementVisible(By.xpath("//button[@class='btn' and contains(@onclick,'del')]"));
    }

}
