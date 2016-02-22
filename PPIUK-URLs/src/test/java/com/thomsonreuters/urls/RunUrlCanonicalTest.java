package com.thomsonreuters.urls;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-htmlreport/UrlCanonicalReport", "junit:target/junit_cucumber.xml", "json:target/cucumber.json"},
        features = "src/test/resources/com/thomsonreuters/urls/features/canonical",
        tags = {"~@wip", "~@manual"},
        monochrome = true,
        snippets = SnippetType.CAMELCASE)

public class RunUrlCanonicalTest {

    @BeforeClass
    public static void reporting() {
        System.setProperty("username", "UrlUser1");
		System.setProperty("password", "Password1");
    }

}
