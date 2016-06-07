package com.thomsonreuters.khpadd;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-htmlreport/KhpaddKnowHowDocumentsReport", "junit:target/junit_cucumber.xml", "json:target/json-files/RunKhpaddKnowHowDocumentsTest.json"},
        features = "src/test/resources/com/thomsonreuters/khpadd/features/knowHowDocuments",
        tags = {"~@wip", "~@manual", "~@should"},
        monochrome = true,
        snippets = SnippetType.CAMELCASE)
public class RunKhpaddKnowHowDocumentsTest {

    private static final Logger LOG = LoggerFactory.getLogger(RunKhpaddKnowHowDocumentsTest.class);
    @BeforeClass
    public static void reporting() {
        if (System.getProperty("username").equals("None")) {
            System.setProperty("username", "KHPaddUser4");
            System.setProperty("password", "Password1");
        }
        else {
            System.out.println("Username is pre-defined in the Run Command as: " + System.getProperty("username"));
        }
    }

}
