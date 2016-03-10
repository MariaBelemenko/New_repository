package com.thomsonreuters.fastdraft;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-htmlreport/FastDraftCreateReport", "junit:target/junit_cucumber.xml", "json:target/json-files/RunFastDraftCreateTest.json"},
        features = "src/test/resources/com/thomsonreuters/fastdraft/features/create",
        tags = {"~@wip", "~@manual", "~@robot"},
        monochrome = true,
        snippets = SnippetType.CAMELCASE)
public class RunFastDraftCreateTest {

    @BeforeClass
    public static void reporting() {
        System.setProperty("username", "FastDraftUser2");
        System.setProperty("password", "Password1");
    }

}
