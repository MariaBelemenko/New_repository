package com.epam.TestNG.factory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

import java.io.File;
import java.io.IOException;

/**
 * Created by Mariya_Belemenko on 6/22/2016.
 */
public class ChromeDriverCreator extends WebDriverCreator {
    private static final Logger LOG = LogManager.getLogger(ChromeDriverCreator.class.getName());
    public static final String PATH_TO_CHROMEDRIVER = "C:/Users/Mariya_Belemenko/drivers/chromedriver.exe";

    @Override
    public synchronized WebDriver createWebDriver() {
        ChromeDriverService service = new ChromeDriverService.Builder().usingDriverExecutable(
                new File(PATH_TO_CHROMEDRIVER)).build();
        try {
            service.start();
        } catch (IOException e) {
            LOG.info("Input/output exception is thrown", e);
        }
        driver = new ChromeDriver(service);
        LOG.info("The browser has started");
       /* System.setProperty("Path to ChromeDriver", PATH_TO_CHROMEDRIVER);
        WebDriver driver = new ChromeDriver();*/
        return driver;
    }
}
