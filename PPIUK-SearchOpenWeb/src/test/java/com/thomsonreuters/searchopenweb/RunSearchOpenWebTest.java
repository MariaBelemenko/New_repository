package com.thomsonreuters.searchopenweb;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-htmlreport/SearchOpenWebReport", "junit:target/junit_cucumber.xml", "json:target/json-files/RunSearchOpenWebTest.json"},
        features = "src/test/resources/com/thomsonreuters/searchopenweb/features",
		tags = {"~@wip", "~@manual"},
        monochrome = true,
        snippets = SnippetType.CAMELCASE)
public class RunSearchOpenWebTest {

    @BeforeClass
    public static void reporting(){
        System.setProperty("username","SearchOpenWebUser1");
        System.setProperty("password", "Password1");
    }

}
