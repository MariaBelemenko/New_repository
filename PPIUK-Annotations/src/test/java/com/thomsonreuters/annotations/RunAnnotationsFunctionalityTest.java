package com.thomsonreuters.annotations;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-htmlreport/AnnotationsFunctionalityReport", "junit:target/junit_cucumber.xml", "json:target/cucumber.json"},
        features = "src/test/resources/com/thomsonreuters/annotations/features/common",
        monochrome = true,
        snippets = SnippetType.CAMELCASE)
public class RunAnnotationsFunctionalityTest {

    @BeforeClass
    public static void reporting() {
        System.setProperty("username", "annotationsUser1");
    }

}

