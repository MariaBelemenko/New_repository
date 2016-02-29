package com.thomsonreuters.frontend;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-htmlreport/FrontEndCountryReport", "junit:target/junit_cucumber.xml", "json:target/json-files/RunCountryFrontEndTest.json"},
        features = "src/test/resources/com/thomsonreuters/frontend/features/country",
        tags = {"~@wip", "~@manual"},
        monochrome = true,
        snippets = SnippetType.CAMELCASE)
public class RunCountryFrontEndTest {

    @BeforeClass
    public static void reporting() {
        System.setProperty("username", "FrontEndUser1");
        System.setProperty("password", "Password1");
    }

}
