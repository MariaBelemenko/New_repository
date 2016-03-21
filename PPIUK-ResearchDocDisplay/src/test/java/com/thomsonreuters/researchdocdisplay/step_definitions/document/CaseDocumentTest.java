package com.thomsonreuters.researchdocdisplay.step_definitions.document;

import static org.junit.Assert.assertTrue;

import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document.AssetDocumentPage;
import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document.CaseDocumentPage;
import com.thomsonreuters.pageobjects.utils.plPlusResearchDocDisplay.CaseDocumentPageUtils;
import com.thomsonreuters.researchdocdisplay.step_definitions.BaseStepDef;

import cucumber.api.java.en.Then;

public class CaseDocumentTest extends BaseStepDef {

    private CaseDocumentPage caseDocumentPage = new CaseDocumentPage();
    private CaseDocumentPageUtils caseDocumentPageUtils = new CaseDocumentPageUtils();
    private AssetDocumentPage assetDocumentPage = new AssetDocumentPage();

    @Then("^the party names are displayed$")
    public void thePartyNamesAreDisplayed() throws Throwable {
    	assertTrue("The party names is not displayed", assetDocumentPage.partyNames().isDisplayed());
    }
    
    @Then("^the alias party names are displayed$")
	public void theAliasPartyNamesAreDisplayed() throws Throwable {
		assertTrue("The user doesn't see alias party names", caseDocumentPage.aliasPartyNames().isDisplayed());
	}
    
    @Then("^the document contains date in \"(.*?)\" format$")
	public void theDocumentContainsDateInFormat(String format) throws Throwable {
		caseDocumentPage.waitForPageToLoad();
		String[] metaInfo = caseDocumentPage.dateText().getText().split("\n");
		assertTrue("The date is not displayed", caseDocumentPage.dateText().isDisplayed());
		assertTrue("The format of the date is not correct!",
				caseDocumentPageUtils.isTheDateHasCorrectFormat(metaInfo[4], format));
	}

}
