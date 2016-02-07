package com.thomsonreuters.urls;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-htmlreport/UrlCanonicalReport", "junit:target/junit_cucumber.xml", "json:target/cucumber.json"},
        features = "src/test/resources/com/thomsonreuters/urls/features/canonical",
        monochrome = true,
        snippets = SnippetType.CAMELCASE)

public class RunUrlCanonicalTest {
}
