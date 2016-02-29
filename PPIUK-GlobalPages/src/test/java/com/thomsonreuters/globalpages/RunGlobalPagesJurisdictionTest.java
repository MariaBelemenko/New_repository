package com.thomsonreuters.globalpages;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-htmlreport/GlobalPagesJurisdictionReport", "junit:target/junit_cucumber.xml", "json:target/json-files/RunGlobalPagesJurisdictionTest.json"},
        features = "src/test/resources/com/thomsonreuters/globalpages/features/jurisdiction",
        tags = {"~@wip", "~@manual"},
        monochrome = true,
        snippets = SnippetType.CAMELCASE)
public class RunGlobalPagesJurisdictionTest {
}
