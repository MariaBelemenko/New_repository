package com.thomsonreuters.searchwhatsmarket;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-htmlreport/SearchWhatsMarketSearchReport", "junit:target/junit_cucumber.xml", "json:target/json-files/RunSearchWhatsMarketSearchTest.json"},
        features = "src/test/resources/com/thomsonreuters/searchwhatsmarket/features/whatsMarketSearch",
        tags = {"~@wip", "~@manual"},
        monochrome = true,
        snippets = SnippetType.CAMELCASE)
public class RunSearchWhatsMarketSearchTest {

    @BeforeClass
    public static void reporting() {
        System.setProperty("username", "SearchWhatsMarketUser8");
        System.setProperty("password", "Password1");
    }

}
