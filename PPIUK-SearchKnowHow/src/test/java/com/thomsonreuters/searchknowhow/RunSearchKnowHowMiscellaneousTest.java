package com.thomsonreuters.searchknowhow;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-htmlreport/SearchKnowHowMiscellaneousReport", "junit:target/junit_cucumber.xml", "json:target/cucumber.json"},
        features = "src/test/resources/com/thomsonreuters/searchknowhow/features/knowHowMiscellaneous",
        tags = {"~@wip", "~@manual"},
        monochrome = true,
        snippets = SnippetType.CAMELCASE)
public class RunSearchKnowHowMiscellaneousTest {

    @BeforeClass
    public static void reporting() {
        System.setProperty("username", "SearchKnowHowUser5");
        System.setProperty("password", "Password1");
    }

}
