package com.thomsonreuters.khpadd;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-htmlreport/KhpaddDeliveryReport", "junit:target/junit_cucumber.xml", "json:target/cucumber.json"},
        features = "src/test/resources/com/thomsonreuters/khpadd/features/delivery",
        tags = {"~@wip", "~@manual"},
        monochrome = true,
        snippets = SnippetType.CAMELCASE)
public class RunKhpaddDeliveryTest {
}
