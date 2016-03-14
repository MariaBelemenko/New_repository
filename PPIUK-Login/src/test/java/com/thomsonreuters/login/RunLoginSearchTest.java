package com.thomsonreuters.login;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import java.util.Date;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-htmlreport/LoginSearchReport", "junit:target/junit_cucumber.xml", "json:target/json-files/RunLoginSearchTest.json"},
        features = "src/test/resources/com/thomsonreuters/login/features/search",
        tags = {"~@wip", "~@manual"},
        monochrome = true,
        snippets = SnippetType.CAMELCASE)
public class RunLoginSearchTest {

    @BeforeClass
    public static void reporting() {
        try {
            Thread.sleep(18000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.setProperty("username", "LoginUser6");
        System.setProperty("password", "Password1");
    }

}
