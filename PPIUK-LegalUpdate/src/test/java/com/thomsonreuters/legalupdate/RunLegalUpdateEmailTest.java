package com.thomsonreuters.legalupdate;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-htmlreport/LUEmailReport", "junit:target/junit_cucumber.xml", "json:target/json-files/RunLegalUpdateEmailTest.json"},
        features = "src/test/resources/com/thomsonreuters/legalupdate/features/email",
        tags = {"~@wip", "~@manual"},
        monochrome = true,
        snippets = SnippetType.CAMELCASE)
public class RunLegalUpdateEmailTest {

    @BeforeClass
    public static void reporting() {
        System.setProperty("username", "LegalUpdateUser4");
        System.setProperty("password", "Password1");
    }

}
