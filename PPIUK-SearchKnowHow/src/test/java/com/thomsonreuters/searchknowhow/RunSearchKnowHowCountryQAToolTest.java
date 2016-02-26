package com.thomsonreuters.searchknowhow;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-htmlreport/SearchKnowHowCountryQAToolReport", "junit:target/junit_cucumber.xml", "json:target/cucumber.json"},
        features = "src/test/resources/com/thomsonreuters/searchknowhow/features/knowHowCountryQATool",
        tags = {"~@wip", "~@manual"},
        monochrome = true,
        snippets = SnippetType.CAMELCASE)
public class RunSearchKnowHowCountryQAToolTest {

    @BeforeClass
    public static void reporting() {
        System.setProperty("username", "SearchKnowHowUser1");
        System.setProperty("password", "Password1");
    }

}
