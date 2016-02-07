package com.thomsonreuters.linking;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-htmlreport/LinkingReport", "junit:target/junit_cucumber.xml", "json:target/cucumber.json"},
        features = "src/test/resources/com/thomsonreuters/linking/features",
        tags = {"~@wip", "~@manual"},
        monochrome = true,
        snippets = SnippetType.CAMELCASE)
public class RunLinkingTest {
}
