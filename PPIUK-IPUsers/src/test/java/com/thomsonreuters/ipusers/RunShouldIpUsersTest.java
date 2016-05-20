package com.thomsonreuters.ipusers;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-htmlreport/ShouldIpUsersReport", "junit:target/junit_cucumber.xml", "json:target/json-files/RunShouldIpUsersTest.json"},
        features = "src/test/resources/com/thomsonreuters/ipusers/features/should",
        tags = {"~@wip", "~@manual", "~@should"},
        monochrome = true,
        snippets = SnippetType.CAMELCASE)
public class RunShouldIpUsersTest {
}
