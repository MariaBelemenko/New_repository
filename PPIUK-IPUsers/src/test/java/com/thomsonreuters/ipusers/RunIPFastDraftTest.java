package com.thomsonreuters.ipusers;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-htmlreport/IPFastDraftReport", "junit:target/junit_cucumber.xml", "json:target/cucumber.json"},
        features = "src/test/resources/com/thomsonreuters/ipusers/features/fastDraft",
        //tags = {"~@wip", "~@manual", "@Chiran"},
        monochrome = true,
        snippets = SnippetType.CAMELCASE)
public class RunIPFastDraftTest {

}
