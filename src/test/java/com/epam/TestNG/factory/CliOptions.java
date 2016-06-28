package com.epam.TestNG.factory;

import org.apache.commons.cli.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Mariya_Belemenko on 6/23/2016.
 */
public class CliOptions {
    private static final Logger LOG = LogManager.getLogger(CliOptions.class.getName());
    private static final String PATH_TO_CHROMEDRIVER = "C:/Users/Mariya_Belemenko/drivers/chromedriver.exe";

    public static void main(String[] args) throws ParseException {
        WebDriver driver = null;
        String browserType = "";
        Options options = new Options();
        options.addOption("b", "Browser", true, "Type of browser");

        CommandLineParser parser = new PosixParser();
        CommandLine cmd = parser.parse(options, args);

        if (cmd.hasOption("b")) {
            browserType = cmd.getOptionValue("b");
        }
        if (browserType.equals("FirefoxDriver")) {
            driver = new FirefoxDriver();
            LOG.info("FF driver is selected");
        }
        if (browserType.equals("ChromeDriver")) {
            System.setProperty("Path to ChromeDriver", PATH_TO_CHROMEDRIVER);
            driver = new ChromeDriver();
            LOG.info("Chrome driver is selected");
        }

        driver.quit();
    }
}
