package com.thomsonreuters.fastdraft;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-htmlreport/FastDraftCommonReport", "junit:target/junit_cucumber.xml", "json:target/json-files/RunFastDraftCommonTest.json"},
        features = "src/test/resources/com/thomsonreuters/fastdraft/features/common",
        tags = {"~@wip", "~@manual", "~@robot"},
        monochrome = true,
        snippets = SnippetType.CAMELCASE)
public class RunFastDraftCommonTest {

    @BeforeClass
    public static void reporting() {
        System.setProperty("username", "FastDraftUser1");
        System.setProperty("password", "Password1");
    }

}
