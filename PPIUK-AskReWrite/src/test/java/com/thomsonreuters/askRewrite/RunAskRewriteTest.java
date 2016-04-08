package com.thomsonreuters.askRewrite;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-htmlreport/AskRewriteReport", "junit:target/junit_cucumber.xml", "json:target/json-files/RunAskRewriteTest.json"},
        features = "src/test/resources/com/thomsonreuters/askRewrite/features",
        tags = {"~@wip", "~@manual"},
        monochrome = true,
        snippets = SnippetType.CAMELCASE)
public class RunAskRewriteTest {
}
