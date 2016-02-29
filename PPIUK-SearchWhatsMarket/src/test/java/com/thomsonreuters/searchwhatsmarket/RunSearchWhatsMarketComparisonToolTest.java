package com.thomsonreuters.searchwhatsmarket;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-htmlreport/SearchWhatsMarketComparisonToolReport", "junit:target/junit_cucumber.xml", "json:target/json-files/RunSearchWhatsMarketComparisonToolTest.json"},
        features = "src/test/resources/com/thomsonreuters/searchwhatsmarket/features/whatsMarketComparisonTool",
        tags = {"~@wip", "~@manual"},
        monochrome = true,
        snippets = SnippetType.CAMELCASE)
public class RunSearchWhatsMarketComparisonToolTest {

    @BeforeClass
    public static void reporting() {
        System.setProperty("username", "SearchWhatsMarketUser1");
        System.setProperty("password", "Password1");
    }

}
