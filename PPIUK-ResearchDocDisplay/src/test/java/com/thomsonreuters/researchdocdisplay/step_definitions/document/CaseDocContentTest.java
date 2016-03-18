package com.thomsonreuters.researchdocdisplay.step_definitions.document;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document.AssetDocumentPage;
import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document.CaseDocumentPage;
import com.thomsonreuters.pageobjects.utils.plPlusResearchDocDisplay.CaseDocumentPageUtils;
import com.thomsonreuters.researchdocdisplay.step_definitions.BaseStepDef;

import cucumber.api.java.en.Then;

public class CaseDocContentTest extends BaseStepDef {

    private CaseDocumentPage caseDocumentPage = new CaseDocumentPage();
    private CaseDocumentPageUtils caseDocumentPageUtils = new CaseDocumentPageUtils();
    private AssetDocumentPage assetDocumentPage = new AssetDocumentPage();

    @Then("^the user see the \"(.*?)\" judgment menu$")
    public void theUserSeeTheJudgmentMenu(String judgmentText) throws Throwable {
        assertTrue("The user doesn't see judgment menu",
                caseDocumentPage.isElementDisplayed(caseDocumentPage.judgmentText(judgmentText)));
    }

    @Then("^the \"(.*?)\" judgement navigation menu is disabled$")
    public void theJudgementNavigationMenuIsDisabled(String judgmentText) throws Throwable {
        assertFalse("The user doesn't see judgment menu",
                caseDocumentPageUtils.isTheJudgementNavigationMenuIsDisabled(judgmentText));
    }
    
    @Then("^the metadata is displayed in the right hand side of the central column$")
	public void theMetadataIsDisplayedInTheRightHandSideOfTheCentralColumn() throws Throwable {
		assertTrue("The metadata is not displayed in the right hand side of the central column",
				assetDocumentPage.caseMetadata().isDisplayed());
	}
    
    @Then("^the metadata contains \"(.*?)\"$")
	public void theMetadataContains(String field) throws Throwable {
		assertTrue("The metadata doesn't contain " + field + "field",
				assetDocumentPage.metaDataField(field).isDisplayed());
	}

    @Then("^the \"([^\"]*)\" section contains footnotes body with numbers$")
    public void theSectionContainsFootnotesBodyWithNumbers(String section) throws Throwable {
    	assertTrue("The footnotes header is not displayed", caseDocumentPage.footnotesSection(section).isDisplayed());
		assertTrue("The footnotes boby is displayed", caseDocumentPage.footnotesBody(section).isDisplayed());
		assertTrue("The footnotes numbers are displayed", caseDocumentPage.footnotesNumber(section).isDisplayed());
    }
}
