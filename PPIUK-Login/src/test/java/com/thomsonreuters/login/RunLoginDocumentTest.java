package com.thomsonreuters.login;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-htmlreport/LoginDocumentReport", "junit:target/junit_cucumber.xml", "json:target/json-files/RunLoginDocumentTest.json"},
        features = "src/test/resources/com/thomsonreuters/login/features/document",
        tags = {"~@wip", "~@manual"},
        monochrome = true,
        snippets = SnippetType.CAMELCASE)
public class RunLoginDocumentTest {

    @BeforeClass
    public static void reporting() {
        System.setProperty("username", "LoginUser1");
        System.setProperty("password", "Password1");
    }

}
