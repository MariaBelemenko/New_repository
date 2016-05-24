package com.thomsonreuters.firmstyle;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-htmlreport/FirmStyleShouldReport", "junit:target/junit_cucumber.xml", "json:target/json-files/RunFirmStyleShouldTest.json"},
        features = "src/test/resources/com/thomsonreuters/firmstyle/features/common",
        tags = {"~@wip", "~@manual", "~@robot", "~@should"},
        monochrome = true,
        snippets = SnippetType.CAMELCASE)
public class RunFirmStyleShouldTest {

    @BeforeClass
    public static void reporting() {
        if (System.getProperty("username").equals("None")) {
            System.setProperty("username", "FSTestUser2");
            System.setProperty("password", "Password123456!");
        }
        else {
            System.out.println("Username is pre-defined in the Run Command as: " + System.getProperty("username"));
        }
    }

}
