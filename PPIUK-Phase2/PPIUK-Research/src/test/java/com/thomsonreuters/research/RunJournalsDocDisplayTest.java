package com.thomsonreuters.research;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-htmlreport/JournalsDocDisplayReport", "junit:target/junit_cucumber.xml", "json:target/json-files/RunJournalsDocDisplayTest.json"},
        features = "src/test/resources/com/thomsonreuters/research/features/JournalsDocDisplay",
        tags = {"~@wip", "~@manual"},
        monochrome = true,
        snippets = SnippetType.CAMELCASE)
public class RunJournalsDocDisplayTest {
	 @BeforeClass
	    public static void reporting() {
	        if (System.getProperty("username").equals("None")) {
	            System.setProperty("username", "PLResearchUser5");
			System.setProperty("password", "Password1");
			System.out.println("Username is now set as: " + System.getProperty("username"));
	        }
	        else {
	            System.out.println("Username is pre-defined in the Run Command as: " + System.getProperty("username"));
	        }
	    }

}
