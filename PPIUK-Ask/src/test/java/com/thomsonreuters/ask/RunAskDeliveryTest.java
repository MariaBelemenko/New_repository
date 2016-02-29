package com.thomsonreuters.ask;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-htmlreport/AskDeliveryReport", "junit:target/junit_cucumber.xml", "json:target/json-files/RunAskDeliveryTest.json"},
        features = "src/test/resources/com/thomsonreuters/ask/features/delivery",
        tags = {"~@wip", "~@manual"},
        monochrome = true,
        snippets = SnippetType.CAMELCASE)
public class RunAskDeliveryTest {

    @BeforeClass
    public static void reporting() {
        System.setProperty("username", "AskUser3");
        System.setProperty("password", "Password1");
    }

}
