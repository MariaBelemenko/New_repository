package com.thomsonreuters.pagecreation;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-htmlreport/CPETHomePageReport", "junit:target/junit_cucumber.xml", "json:target/json-files/RunPageCreationHomePageTest.json"},
        features = "src/test/resources/com/thomsonreuters/pagecreation/features/homePage",
		tags = {"~@wip", "~@manual"},
        monochrome = true,
        snippets = SnippetType.CAMELCASE)
public class RunPageCreationHomePageTest {

    @BeforeClass
    public static void reporting() {
        System.setProperty("username", "CpetUser2");
        System.setProperty("password", "Password1");
    }

}

