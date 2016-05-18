package com.thomsonreuters.research;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-htmlreport/JournalsDocDisplayReport", "junit:target/junit_cucumber.xml", "json:target/json-files/RunJournalsDocDisplayTest.json"},
        features = "src/test/resources/com/thomsonreuters/research/features/JournalsDocDisplay",
        tags = {"~@wip", "~@manual"},
        monochrome = true,
        snippets = SnippetType.CAMELCASE)
public class RunJournalsDocDisplayTest {

}
