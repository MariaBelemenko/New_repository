package com.thomsonreuters.adestra;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-htmlreport/AdestraCancelSubscriptionsReport", "junit:target/junit_cucumber.xml", "json:target/json-files/RunAdestraCancelSubscriptionsTest.json"},
        features = "src/test/resources/com/thomsonreuters/adestra/features/cancelSubscriptions",
        tags = {"~@wip", "~@manual"},
        monochrome = true,
        snippets = SnippetType.CAMELCASE)
public class RunAdestraCancelSubscriptionsTest {
}
