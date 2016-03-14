package com.thomsonreuters.login;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import java.util.Date;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-htmlreport/LoginOpenWebReport", "junit:target/junit_cucumber.xml", "json:target/json-files/RunLoginOpenWebTest.json"},
        features = "src/test/resources/com/thomsonreuters/login/features/openWeb",
        tags = {"~@wip", "~@manual"},
        monochrome = true,
        snippets = SnippetType.CAMELCASE)
public class RunLoginOpenWebTest {

    @BeforeClass
    public static void reporting() {
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.setProperty("username", "LoginUser5");
        System.setProperty("password", "Password1");
    }

}
