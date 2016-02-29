package com.thomsonreuters.assetpages;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-htmlreport/AssetPagesDocumentReport", "junit:target/junit_cucumber.xml", "json:target/json-files/RunAssetPagesDocumentTest.json"},
        features = "src/test/resources/com/thomsonreuters/assetpages/features/document",
        tags = {"~@wip", "~@manual"},
        monochrome = true,
        snippets = SnippetType.CAMELCASE)
public class RunAssetPagesDocumentTest {

    @BeforeClass
    public static void reporting() {
        System.setProperty("username", "AssetPageUser2");
        System.setProperty("password", "Password1");
    }

}
