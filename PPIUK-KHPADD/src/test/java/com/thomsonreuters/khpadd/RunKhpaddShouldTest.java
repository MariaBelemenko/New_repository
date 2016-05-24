package com.thomsonreuters.khpadd;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-htmlreport/KhpaddShouldReport", "junit:target/junit_cucumber.xml", "json:target/json-files/RunKhpaddShouldTest.json"},
        features = "src/test/resources/com/thomsonreuters/khpadd/features/should",
        tags = {"~@wip", "~@manual", "~@should"},
        monochrome = true,
        snippets = SnippetType.CAMELCASE)
public class RunKhpaddShouldTest {

}
