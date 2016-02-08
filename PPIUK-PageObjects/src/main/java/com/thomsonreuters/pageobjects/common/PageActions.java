package com.thomsonreuters.pageobjects.common;

import com.thomsonreuters.driver.framework.WebDriverDiscovery;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class PageActions {

    private WebDriverDiscovery webDriverDiscovery;

    public PageActions() {
        webDriverDiscovery = new WebDriverDiscovery();
    }

    public void dragAndDrop(WebElement dragElement, WebElement dropElement) {
        new Actions(webDriverDiscovery.getRemoteWebDriver()).dragAndDrop(dragElement, dropElement).build().perform();
    }

    public void rightClick(WebElement element) {
        new Actions(webDriverDiscovery.getRemoteWebDriver()).contextClick(element).build().perform();
    }

    public void keyPress(Keys key) {
        new Actions(webDriverDiscovery.getRemoteWebDriver()).sendKeys(key).build().perform();
    }

    public void doubleClick(WebElement element) {
        new Actions(webDriverDiscovery.getRemoteWebDriver()).doubleClick(element).build().perform();
    }

    public void mouseOver(WebElement element) {
        new Actions(webDriverDiscovery.getRemoteWebDriver()).moveToElement(element).build().perform();
    }

}
