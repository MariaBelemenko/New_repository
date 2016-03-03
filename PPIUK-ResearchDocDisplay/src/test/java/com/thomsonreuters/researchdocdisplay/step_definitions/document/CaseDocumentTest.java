package com.thomsonreuters.researchdocdisplay.step_definitions.document;

import static org.junit.Assert.assertTrue;

import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document.CaseDocumentPage;
import com.thomsonreuters.pageobjects.utils.plPlusResearchDocDisplay.CaseDocumentPageUtils;
import com.thomsonreuters.researchdocdisplay.step_definitions.BaseStepDef;

import cucumber.api.java.en.Then;

public class CaseDocumentTest extends BaseStepDef {

    private CaseDocumentPage caseDocumentPage = new CaseDocumentPage();
    private CaseDocumentPageUtils caseDocumentPageUtils = new CaseDocumentPageUtils();

    @Then("^the party names is displayed on document$")
    public void thePartyNamesIsDisplayedOnDocument() throws Throwable {
        assertTrue("The party names is not displayed", caseDocumentPage.isElementDisplayed(caseDocumentPage.partyNamesText()));
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
