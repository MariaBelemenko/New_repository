package com.thomsonreuters.annotations;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-htmlreport/AnnotationsFACReport", "junit:target/junit_cucumber.xml", "json:target/json-files/RunAnnotationsFACTest.json"},
        features = "src/test/resources/com/thomsonreuters/annotations/features/sharing",
        monochrome = true,
        tags = {"~@wip", "~@manual"},
        snippets = SnippetType.CAMELCASE)
public class RunAnnotationsFACTest {

    @BeforeClass
    public static void reporting(){
        if (System.getProperty("username").equals("None")) {
            System.setProperty("username","librarian1");
            System.setProperty("password", "Password1");
        }
        else {
            System.out.println("Username is pre-defined in the Run Command as: " + System.getProperty("username"));
        }
    }

}

