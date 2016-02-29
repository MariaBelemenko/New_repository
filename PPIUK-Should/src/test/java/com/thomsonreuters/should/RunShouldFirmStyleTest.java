package com.thomsonreuters.should;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-htmlreport/ShouldFirmStyleReport", "junit:target/junit_cucumber.xml", "json:target/json-files/RunShouldFirmStyleTest.json"},
        features = "src/test/resources/com/thomsonreuters/should/features/firmStyle",
        tags = {"~@wip", "~@manual"},
        monochrome = true,
        snippets = SnippetType.CAMELCASE)
public class RunShouldFirmStyleTest {
}
