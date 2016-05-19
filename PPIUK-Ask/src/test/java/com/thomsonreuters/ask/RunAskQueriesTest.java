package com.thomsonreuters.ask;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-htmlreport/AskQueriesReport", "junit:target/junit_cucumber.xml", "json:target/json-files/RunAskQueriesTest.json"},
        features = "src/test/resources/com/thomsonreuters/ask/features/queries",
        tags = {"~@wip", "~@manual", "~@should"},
        monochrome = true,
        snippets = SnippetType.CAMELCASE)
public class RunAskQueriesTest {

    @BeforeClass
    public static void reporting() {
        if (System.getProperty("username").equals("None")) {
            System.setProperty("username", "AskUser6");
            System.setProperty("password", "Password1");
        }
        else {
            System.out.println("Username is pre-defined in the Run Command as: " + System.getProperty("username"));
        }
    }

}
