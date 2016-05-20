package com.thomsonreuters.searchknowhow;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-htmlreport/SearchKnowHowSearchResultsReport", "junit:target/junit_cucumber.xml", "json:target/json-files/RunSearchKnowHowSearchResultsTest.json"},
        features = "src/test/resources/com/thomsonreuters/searchknowhow/features/knowHowSearchResults",
        tags = {"~@wip", "~@manual", "~@should"},
        monochrome = true,
        snippets = SnippetType.CAMELCASE)
public class RunSearchKnowHowSearchResultsTest {

    @BeforeClass
    public static void reporting() {
        if (System.getProperty("username").equals("None")) {
            System.setProperty("username", "SearchKnowHowUser7");
            System.setProperty("password", "Password1");
        }
        else {
            System.out.println("Username is pre-defined in the Run Command as: " + System.getProperty("username"));
        }
    }

}
