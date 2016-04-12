package com.thomsonreuters.research;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-htmlreport/report1", "junit:target/junit_cucumber.xml", "json:target/json-files/report1.json"},
        features = "",
        monochrome = true,
        tags = {"~@wip", "~@manual"},
        snippets = SnippetType.CAMELCASE)
public class RunResearchTest {

    @BeforeClass
    public static void reporting(){

    }

}

