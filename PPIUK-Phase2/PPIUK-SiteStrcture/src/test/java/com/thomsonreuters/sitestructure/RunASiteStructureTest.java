package com.thomsonreuters.sitestructure;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-htmlreport/CalendarReport", "junit:target/junit_cucumber.xml", "json:target/json-files/RunCalendarTest.json"},
        features = "src/test/resources/com/thomsonreuters/sitestructure",
        tags = {"@ssToggle","~@wip", "~@manual"},
        monochrome = true,
        snippets = SnippetType.CAMELCASE)
public class RunASiteStructureTest {

    @BeforeClass
    public static void reporting() {
        System.setProperty("username", "Ali.Syed");
        System.setProperty("password", "London@789");
    }

}
