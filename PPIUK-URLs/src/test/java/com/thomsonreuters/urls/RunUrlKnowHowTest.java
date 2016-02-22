package com.thomsonreuters.urls;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-htmlreport/UrlKnowHowReport", "junit:target/junit_cucumber.xml", "json:target/cucumber.json"},
        features = "src/test/resources/com/thomsonreuters/urls/features/knowHow",
        tags = {"~@wip", "~@manual"},
        monochrome = true,
        snippets = SnippetType.CAMELCASE)

public class RunUrlKnowHowTest {

    @BeforeClass
    public static void reporting() {
        System.setProperty("username", "UrlUser2");
        System.setProperty("password", "Password1");
    }

}
