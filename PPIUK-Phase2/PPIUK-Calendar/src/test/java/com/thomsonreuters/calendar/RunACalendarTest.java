package com.thomsonreuters.calendar;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-htmlreport/CalendarReport", "junit:target/junit_cucumber.xml", "json:target/json-files/RunCalendarTest.json"},
        features = "src/test/resources/com/thomsonreuters/calendar",
        tags = {"@widgetToggle","~@wip", "~@manual"},
        monochrome = true,
        snippets = SnippetType.CAMELCASE)
public class RunACalendarTest {

    @BeforeClass
    public static void reporting() {
        System.setProperty("username", "FrontEndUser1");
        System.setProperty("password", "Password1");
    }

}
