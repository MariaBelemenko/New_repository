package com.thomsonreuters.legalupdate;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-htmlreport/LURSSReport", "junit:target/junit_cucumber.xml", "json:target/json-files/RunLegalUpdateRssTest.json"},
        features = "src/test/resources/com/thomsonreuters/legalupdate/features/rss",
        tags = {"~@wip", "~@manual"},
        monochrome = true,
        snippets = SnippetType.CAMELCASE)
public class RunLegalUpdateRssTest {

    @BeforeClass
    public static void reporting() {
        System.setProperty("username", "LegalUpdateUser5");
        System.setProperty("password", "Password1");
    }

}
