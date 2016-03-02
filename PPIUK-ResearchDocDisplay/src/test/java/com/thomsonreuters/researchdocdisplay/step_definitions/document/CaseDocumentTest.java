package com.thomsonreuters.researchdocdisplay.step_definitions.document;

import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document.CaseDocumentPage;
import com.thomsonreuters.researchdocdisplay.step_definitions.BaseStepDef;
import cucumber.api.java.en.Then;

import static org.junit.Assert.assertTrue;

public class CaseDocumentTest extends BaseStepDef {

    private CaseDocumentPage caseDocumentPage = new CaseDocumentPage();

    @Then("^the party names is displayed on document$")
    public void thePartyNamesIsDisplayedOnDocument() throws Throwable {
        assertTrue("The party names is not displayed", caseDocumentPage.isElementDisplayed(caseDocumentPage.partyNamesText()));
    }

    @Then("^the alias party names are displayed$")
	public void theAliasPartyNamesAreDisplayed() throws Throwable {
		assertTrue("The user doesn't see alias party names", caseDocumentPage.aliasPartyNames().isDisplayed());
	}

}
