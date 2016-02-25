package com.thomsonreuters.annotations;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-htmlreport/AnnotationsFACReport", "junit:target/junit_cucumber.xml", "json:target/cucumber.json"},
        features = "src/test/resources/com/thomsonreuters/annotations/features/sharing",
        monochrome = true,
        tags = {"~@wip", "~@manual", "@chiran"},
        snippets = SnippetType.CAMELCASE)
public class RunAnnotationsFACTest {

    @BeforeClass
    public static void reporting(){
        System.setProperty("username","librarian1");
        System.setProperty("password", "Password1");
    }

}

