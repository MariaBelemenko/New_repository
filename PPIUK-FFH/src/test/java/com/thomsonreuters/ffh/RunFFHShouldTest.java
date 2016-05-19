package com.thomsonreuters.ffh;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-htmlreport/FFHShouldReport", "junit:target/junit_cucumber.xml", "json:target/json-files/RunFFHShouldTest.json"},
        features = "src/test/resources/com/thomsonreuters/ffh/features/should",
        tags = {"~@wip", "~@manual", "~@should"},
        monochrome = true,
        snippets = SnippetType.CAMELCASE)
public class RunFFHShouldTest {

    @BeforeClass
    public static void reporting() {
        if (System.getProperty("username").equals("None")) {
            System.setProperty("username", "FFHUser1");
            System.setProperty("password", "Password1");
        }
        else {
            System.out.println("Username is pre-defined in the Run Command as: " + System.getProperty("username"));
        }
    }

}
