package com.thomsonreuters.searchbrowse;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-htmlreport/ResearchBrowseCommonReport", "junit:target/junit_cucumber.xml", "json:target/json-files/RunResearchBrowseCommonTest.json"},
        features = "src/test/resources/com/thomsonreuters/researchbrowse/features/common",
        tags = {"~@wip", "~@manual"},
        monochrome = true,
        snippets = SnippetType.CAMELCASE)
public class RunResearchBrowseCommonTest {
}
