package com.thomsonreuters.frontend;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-htmlreport/FrontEndKHSearchReport", "junit:target/junit_cucumber.xml", "json:target/json-files/RunFrontEndKHSearchTest.json"},
        features = "src/test/resources/com/thomsonreuters/frontend/features/khSearch",
        tags = {"~@wip", "~@manual"},
        monochrome = true,
        snippets = SnippetType.CAMELCASE)
public class RunFrontEndKHSearchTest {

    @BeforeClass
    public static void reporting() {
        System.setProperty("username", "FrontEndUser7");
        System.setProperty("password", "Password1");
    }

}
