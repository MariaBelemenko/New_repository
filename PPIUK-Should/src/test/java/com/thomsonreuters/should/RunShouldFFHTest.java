package com.thomsonreuters.should;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-htmlreport/ShouldFFHReport", "junit:target/junit_cucumber.xml", "json:target/json-files/RunShouldFFHTest.json"},
        features = "src/test/resources/com/thomsonreuters/should/features/ffh",
        tags = {"~@wip", "~@manual"},
        monochrome = true,
        snippets = SnippetType.CAMELCASE)
public class RunShouldFFHTest {
}
