package com.thomsonreuters.globalpages;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-htmlreport/GlobalPagesCommonReport", "junit:target/junit_cucumber.xml", "json:target/json-files/RunGlobalPagesCommonTest.json"},
        features = "src/test/resources/com/thomsonreuters/globalpages/features/common",
        tags = {"~@wip", "~@manual"},
        monochrome = true,
        snippets = SnippetType.CAMELCASE)
public class RunGlobalPagesCommonTest {

    @BeforeClass
    public static void reporting() {
        System.setProperty("username", "GlobalPagesUser1");
        System.setProperty("password", "Password1");
    }

}
