package com.thomsonreuters.researchdocdisplay.step_definitions.casedoc;

import static org.junit.Assert.assertTrue;

import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document.AssetDocumentPage;
import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document.CaseDocumentPage;
import com.thomsonreuters.researchdocdisplay.step_definitions.BaseStepDef;

import cucumber.api.java.en.Then;

public class CaseDocPartyNamesTest extends BaseStepDef {

	private CaseDocumentPage caseDocumentPage = new CaseDocumentPage();
	private AssetDocumentPage assetDocumentPage = new AssetDocumentPage();

	@Then("^the party names are displayed$")
	public void thePartyNamesAreDisplayed() throws Throwable {
		assertTrue("The party names are not displayed", assetDocumentPage.partyNames().isDisplayed());
	}

	@Then("^the alias party names are displayed$")
	public void theAliasPartyNamesAreDisplayed() throws Throwable {
		assertTrue("The user doesn't see alias party names", caseDocumentPage.aliasPartyNames().isDisplayed());
	}

}
