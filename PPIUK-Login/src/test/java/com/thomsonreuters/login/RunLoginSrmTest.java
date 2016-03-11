package com.thomsonreuters.login;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "pretty", "html:target/cucumber-htmlreport/LoginSrmReport", "junit:target/junit_cucumber.xml",
		"json:target/json-files/RunLoginSrmTest.json" }, features = "src/test/resources/com/thomsonreuters/login/features/srm", tags = {
		"~@wip", "~@manual" }, monochrome = true, snippets = SnippetType.CAMELCASE)
public class RunLoginSrmTest {

	@BeforeClass
	public static void reporting() {
		System.setProperty("username", "srm_user");
		System.setProperty("password", "srmUSER2015");
	}

}
