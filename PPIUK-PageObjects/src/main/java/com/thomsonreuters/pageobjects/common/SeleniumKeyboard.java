package com.thomsonreuters.pageobjects.common;

import com.thomsonreuters.driver.framework.WebDriverDiscovery;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.remote.RemoteExecuteMethod;
import org.openqa.selenium.remote.RemoteKeyboard;

import javax.annotation.PostConstruct;

/**
 * Class for sending key events to browser
 */
public class SeleniumKeyboard {

    private WebDriverDiscovery webDriverDiscovery = new WebDriverDiscovery();

    private Keyboard keyboard;

    @PostConstruct
    public void init() {
        keyboard = new RemoteKeyboard(new RemoteExecuteMethod(webDriverDiscovery.getRemoteWebDriver()));
    }

    public void sendEscape() {
        keyboard.sendKeys(Keys.ESCAPE);
    }

}