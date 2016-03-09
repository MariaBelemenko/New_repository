package com.thomsonreuters.smoke;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-htmlreport/SmokeTestReport", "junit:target/junit_cucumber.xml", "json:target/json-files/RunSmokeTest.json"},
        features = "src/test/resources/com/thomsonreuters/smoke/features",
        tags = {"~@wip", "~@manual"},
        monochrome = true,
        snippets = SnippetType.CAMELCASE)
public class RunSmokeTest {
}
