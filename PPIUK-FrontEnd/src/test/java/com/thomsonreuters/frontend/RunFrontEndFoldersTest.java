package com.thomsonreuters.frontend;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-htmlreport/FrontEndFoldersReport", "junit:target/junit_cucumber.xml", "json:target/json-files/RunFrontEndFoldersTest.json"},
        features = "src/test/resources/com/thomsonreuters/frontend/features/folders",
        tags = {"~@wip", "~@manual"},
        monochrome = true,
        snippets = SnippetType.CAMELCASE)
public class RunFrontEndFoldersTest {

    @BeforeClass
    public static void reporting() {
        System.setProperty("username", "FrontEndUser3");
        System.setProperty("password", "Password1");
    }
}
