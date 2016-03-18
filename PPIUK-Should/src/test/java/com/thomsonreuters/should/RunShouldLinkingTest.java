package com.thomsonreuters.should;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-htmlreport/ShouldLinkingReport", "junit:target/junit_cucumber.xml", "json:target/json-files/RunShouldLinkingTest.json"},
        features = "src/test/resources/com/thomsonreuters/should/features/linking",
        tags = {"~@wip", "~@manual"},
        monochrome = true,
        snippets = SnippetType.CAMELCASE)
public class RunShouldLinkingTest {

    @BeforeClass
    public static void reporting() {
        System.setProperty("username", "LinkingUser1");
        System.setProperty("password", "Password1");
    }

}
