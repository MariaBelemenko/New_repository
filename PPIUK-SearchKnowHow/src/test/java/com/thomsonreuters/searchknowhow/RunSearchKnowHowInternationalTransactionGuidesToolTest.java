package com.thomsonreuters.searchknowhow;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-htmlreport/SearchKnowHowInternationalTransactionGuidesToolReport", "junit:target/junit_cucumber.xml", "json:target/json-files/RunSearchKnowHowInternationalTransactionGuidesToolTest.json"},
        features = "src/test/resources/com/thomsonreuters/searchknowhow/features/knowHowInternationalTransactionGuidesTool",
        tags = {"~@wip", "~@manual"},
        monochrome = true,
        snippets = SnippetType.CAMELCASE)
public class RunSearchKnowHowInternationalTransactionGuidesToolTest {

    @BeforeClass
    public static void reporting() {
        System.setProperty("username", "SearchKnowHowUser4");
        System.setProperty("password", "Password1");
    }

}
