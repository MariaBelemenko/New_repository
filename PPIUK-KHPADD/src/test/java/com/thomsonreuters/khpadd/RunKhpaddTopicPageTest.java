package com.thomsonreuters.khpadd;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-htmlreport/KhpaddTopicPageReport", "junit:target/junit_cucumber.xml", "json:target/json-files/RunKhpaddTopicPageTest.json"},
        features = "src/test/resources/com/thomsonreuters/khpadd/features/topicPage",
        tags = {"~@wip", "~@manual"},
        monochrome = true,
        snippets = SnippetType.CAMELCASE)
public class RunKhpaddTopicPageTest {

    @BeforeClass
    public static void reporting() {
        System.setProperty("username", "KHPaddUser6");
        System.setProperty("password", "Password1");
    }

}
