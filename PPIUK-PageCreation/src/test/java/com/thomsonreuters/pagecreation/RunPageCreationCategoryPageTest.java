package com.thomsonreuters.pagecreation;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-htmlreport/CPETCategoryPageReport", "junit:target/junit_cucumber.xml", "json:target/cucumber.json"},
        features = "src/test/resources/com/thomsonreuters/pagecreation/features/categoryPage",
        monochrome = true,
        snippets = SnippetType.CAMELCASE)
public class RunPageCreationCategoryPageTest {

}

