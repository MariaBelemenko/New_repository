package com.epam.TestNG.multithread;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

/**
 * Created by Mariya_Belemenko on 6/27/2016.
 */
public class TestNGMultiThread {
    private WebDriver driver = new FirefoxDriver();

    @Test(threadPoolSize = 2, invocationCount = 2, invocationTimeOut = 10000)
    public void startBrowser() {
       driver.get("http://google.com");
    }

    @Test(threadPoolSize = 2, invocationCount = 2, invocationTimeOut = 10000)
    public void tearDown() {
        driver.quit();
    }
}
