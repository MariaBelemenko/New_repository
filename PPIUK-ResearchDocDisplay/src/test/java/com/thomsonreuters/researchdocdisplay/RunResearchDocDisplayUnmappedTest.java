package com.thomsonreuters.researchdocdisplay;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/*
 * This package contains features that are not mapped to any tfs item
 * To be investigated later
*/

@RunWith(Cucumber.class)
@CucumberOptions(
plugin = { "pretty", "html:target/cucumber-htmlreport/ResearchDocDisplayUnmappedReport",
		"junit:target/junit_cucumber.xml", "json:target/json-files/RunResearchDocDisplayUnmappedTest.json" }, 
		features = "src/test/resources/com/thomsonreuters/researchdocdisplay/features/unmapped",
        tags = {"~@wip", "~@manual"},
        monochrome = true,
        snippets = SnippetType.CAMELCASE)
public class RunResearchDocDisplayUnmappedTest {
}
