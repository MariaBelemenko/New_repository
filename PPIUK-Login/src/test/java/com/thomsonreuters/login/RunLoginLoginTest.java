package com.thomsonreuters.login;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-htmlreport/LoginLoginReport", "junit:target/junit_cucumber.xml", "json:target/json-files/RunLoginLoginTest.json"},
        features = "src/test/resources/com/thomsonreuters/login/features/login",
        tags = {"~@wip", "~@manual"},
        monochrome = true,
        snippets = SnippetType.CAMELCASE)
public class RunLoginLoginTest {

    @BeforeClass
    public static void reporting() {
        System.setProperty("username", "LoginUser3");
        System.setProperty("password", "Password1");
    }

}
