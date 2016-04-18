package com.thomsonreuters.searchwhatsmarket;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.slf4j.Logger;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-htmlreport/SearchWhatsMarketSearchResultsSortingReport", "junit:target/junit_cucumber.xml", "json:target/json-files/RunSearchWhatsMarketSearchResultsSortingTest.json"},
        features = "src/test/resources/com/thomsonreuters/searchwhatsmarket/features/whatsMarketSearchResultsSorting",
        tags = {"~@wip", "~@manual"},
        monochrome = true,
        snippets = SnippetType.CAMELCASE)
public class RunSearchWhatsMarketSearchResultsSortingTest {

    private static final Logger LOG = org.slf4j.LoggerFactory.getLogger(RunSearchWhatsMarketSearchResultsSortingTest.class);

    @BeforeClass
    public static void reporting() {
        if (System.getProperty("username").equals("None")) {
            System.setProperty("username", "SearchWhatsMarketUser6");
            System.setProperty("password", "Password1");
        }
        else {
            LOG.info("Username is pre-defined in the Run Command as: " + System.getProperty("username"));
        }
    }

}
