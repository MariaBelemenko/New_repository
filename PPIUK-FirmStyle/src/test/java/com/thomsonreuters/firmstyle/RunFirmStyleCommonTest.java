package com.thomsonreuters.firmstyle;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-htmlreport/FirmStyleCommonReport", "junit:target/junit_cucumber.xml", "json:target/json-files/RunFirmStyleCommonTest.json"},
        features = "src/test/resources/com/thomsonreuters/firmstyle/features/common",
        tags = {"~@wip", "~@manual", "~@robot", "~@should"},
        monochrome = true,
        snippets = SnippetType.CAMELCASE)
public class RunFirmStyleCommonTest {
}
