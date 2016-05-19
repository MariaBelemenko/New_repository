package com.thomsonreuters.ffh;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-htmlreport/FFHHistoryReport", "junit:target/junit_cucumber.xml", "json:target/json-files/RunFFHHistoryTest.json"},
        features = "src/test/resources/com/thomsonreuters/ffh/features/history",
        tags = {"~@wip", "~@manual", "~@should"},
        monochrome = true,
        snippets = SnippetType.CAMELCASE)
public class RunFFHHistoryTest {

    @BeforeClass
    public static void reporting() {
        if (System.getProperty("username").equals("None")) {
            System.setProperty("username", "FFHUser3");
            System.setProperty("password", "Password1");
        }
        else {
            System.out.println("Username is pre-defined in the Run Command as: " + System.getProperty("username"));
        }
    }

}
