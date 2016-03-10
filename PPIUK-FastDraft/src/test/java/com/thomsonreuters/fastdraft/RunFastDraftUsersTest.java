package com.thomsonreuters.fastdraft;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-htmlreport/FastDraftUsersReport", "junit:target/junit_cucumber.xml", "json:target/json-files/RunFastDraftUsersTest.json"},
        features = "src/test/resources/com/thomsonreuters/fastdraft/features/users",
        tags = {"~@wip", "~@manual", "~@robot"},
        monochrome = true,
        snippets = SnippetType.CAMELCASE)
public class RunFastDraftUsersTest {

    @BeforeClass
    public static void reporting() {
        System.setProperty("username", "FastDraftUser4");
        System.setProperty("password", "Password1");
    }

}
