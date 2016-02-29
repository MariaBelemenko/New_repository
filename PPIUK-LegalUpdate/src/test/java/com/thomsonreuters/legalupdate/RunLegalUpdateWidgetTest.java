package com.thomsonreuters.legalupdate;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-htmlreport/LUWidgetReport", "junit:target/junit_cucumber.xml", "json:target/json-files/RunLegalUpdateWidgetTest.json"},
        features = "src/test/resources/com/thomsonreuters/legalupdate/features/widget",
        tags = {"~@wip", "~@manual"},
        monochrome = true,
        snippets = SnippetType.CAMELCASE)
public class RunLegalUpdateWidgetTest {

    @BeforeClass
    public static void reporting() {
        System.setProperty("username", "LegalUpdateUser8");
        System.setProperty("password", "Password1");
    }

}
