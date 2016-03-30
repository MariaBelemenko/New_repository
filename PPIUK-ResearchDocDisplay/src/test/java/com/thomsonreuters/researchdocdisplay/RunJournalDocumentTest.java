package com.thomsonreuters.researchdocdisplay;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-htmlreport/JournalDocumentReport", "junit:target/junit_cucumber.xml", "json:target/json-files/RunJournalDocumentTest.json"},
        features = "src/test/resources/com/thomsonreuters/researchdocdisplay/features/journal",
        tags = {"~@wip", "~@manual"},
        monochrome = true,
        snippets = SnippetType.CAMELCASE)
public class RunJournalDocumentTest {
}
