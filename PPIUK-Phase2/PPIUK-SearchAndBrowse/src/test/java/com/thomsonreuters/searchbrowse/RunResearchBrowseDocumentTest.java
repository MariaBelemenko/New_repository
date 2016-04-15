package com.thomsonreuters.searchbrowse;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-htmlreport/ResearchBrowseDocumentReport", "junit:target/junit_cucumber.xml", "json:target/json-files/RunResearchBrowseDocumentTest.json"},
        features = "src/test/resources/com/thomsonreuters/researchbrowse/features/document",
        tags = {"~@wip", "~@manual"},
        monochrome = true,
        snippets = SnippetType.CAMELCASE)
public class RunResearchBrowseDocumentTest {
}
