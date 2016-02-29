package com.thomsonreuters.ipusers;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-htmlreport/IPFirmStyleReport", "junit:target/junit_cucumber.xml", "json:target/json-files/RunIPFirmStyleTest.json"},
        features = "src/test/resources/com/thomsonreuters/ipusers/features/firmStyle",
        //tags = {"~@wip", "~@manual", "@Chiran1"},
        monochrome = true,
        snippets = SnippetType.CAMELCASE)
public class RunIPFirmStyleTest {

}

