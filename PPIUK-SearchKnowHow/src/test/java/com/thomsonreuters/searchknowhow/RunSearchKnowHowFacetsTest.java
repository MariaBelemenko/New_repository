package com.thomsonreuters.searchknowhow;

import com.thomsonreuters.searchknowhow.step_definitions.BaseStepDef;
import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-htmlreport/SearchKnowHowFacetsReport", "junit:target/junit_cucumber.xml", "json:target/json-files/RunSearchKnowHowFacetsTest.json"},
        features = "src/test/resources/com/thomsonreuters/searchknowhow/features/knowHowFacets",
        tags = {"~@wip", "~@manual"},
        monochrome = true,
        snippets = SnippetType.CAMELCASE)
public class RunSearchKnowHowFacetsTest {

    @BeforeClass
    public static void reporting() {
        System.setProperty("username", "SearchKnowHowUser3");
        System.setProperty("password", "Password1");
    }

}
