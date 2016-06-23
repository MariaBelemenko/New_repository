package com.epam.TestNG.factory;

import org.apache.commons.cli.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Mariya_Belemenko on 6/23/2016.
 */
public class CliOptions {
    public static void main(String[] args) throws ParseException {
        WebDriver driver;
        Options options = new Options();
        options.addOption("b", "Browser", true, "display current time");
        CommandLineParser parser = new PosixParser();
        CommandLine cmd = parser.parse(options, args);
        String browserType = cmd.getOptionValue("c");
        if (browserType == "FirefoxDriver") {
            driver = new FirefoxDriver();
        }
        if (browserType == "ChromeDriver") {
            driver = new ChromeDriver();
        }
    }
}
