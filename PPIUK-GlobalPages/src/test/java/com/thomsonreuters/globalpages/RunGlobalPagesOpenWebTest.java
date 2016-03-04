package com.thomsonreuters.globalpages;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-htmlreport/GlobalPagesOpenWebReport", "junit:target/junit_cucumber.xml", "json:target/json-files/RunGlobalPagesOpenWebTest.json"},
        features = "src/test/resources/com/thomsonreuters/globalpages/features/openWeb",
        tags = {"~@wip", "~@manual"},
        monochrome = true,
        snippets = SnippetType.CAMELCASE)
public class RunGlobalPagesOpenWebTest {

    @BeforeClass
    public static void reporting() {
        System.setProperty("username", "GlobalPagesUser4");
        System.setProperty("password", "Password1");
    }

}
