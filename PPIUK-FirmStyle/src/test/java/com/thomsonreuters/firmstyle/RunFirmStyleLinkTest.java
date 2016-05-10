package com.thomsonreuters.firmstyle;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-htmlreport/ResearchBrowseLinkReport", "junit:target/junit_cucumber.xml", "json:target/json-files/RunFirmStyleLinkTest.json"},
        features = "src/test/resources/com/thomsonreuters/firmstyle/features/link",
        tags = {"~@wip", "~@manual","~@robot"},
        monochrome = true,
        snippets = SnippetType.CAMELCASE)
public class RunFirmStyleLinkTest {

    @BeforeClass
    public static void reporting() {
        if (System.getProperty("username").equals("None")) {
            System.setProperty("username", "Ali.Syed"); //FSTestUser2  - User is blocked. Temporarily using my username/password
            System.setProperty("password", "London@789");//Password123!
        }
        else {
            System.out.println("Username is pre-defined in the Run Command as: " + System.getProperty("username"));
        }
    }

}
