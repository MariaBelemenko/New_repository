package com.thomsonreuters.login;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "pretty", "html:target/cucumber-htmlreport/LoginSrmReport", "junit:target/junit_cucumber.xml",
		"json:target/json-files/RunLoginSrmTest.json" }, features = "src/test/resources/com/thomsonreuters/login/features/srm", tags = {
		"~@wip", "~@manual" }, monochrome = true, snippets = SnippetType.CAMELCASE)
public class RunLoginSrmTest {

	@BeforeClass
	public static void reporting() {
        try {
            Thread.sleep(21000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
		System.setProperty("username", "srm_user");
		System.setProperty("password", "srmUSER2015");
	}

}
