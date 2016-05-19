package com.thomsonreuters.annotations;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-htmlreport/AnnotationsFACReport", "junit:target/junit_cucumber.xml", "json:target/json-files/RunAnnotationsFACTest.json"},
        features = "src/test/resources/com/thomsonreuters/annotations/features/sharing",
        monochrome = true,
        tags = {"~@wip", "~@manual"},
        snippets = SnippetType.CAMELCASE)
public class RunAnnotationsFACTest {
    private static final Logger LOG = LoggerFactory.getLogger(RunAnnotationsFACTest.class);

    @BeforeClass
    public static void reporting() {
        if (System.getProperty("username").equals("None")) {
            System.setProperty("username", "librarian1");
            System.setProperty("password", "Password1");
            LOG.info("The credentials have been set");
        } else {
            LOG.info("Username is pre-defined in the Run Command as: " + System.getProperty("username"));
        }
    }
}

