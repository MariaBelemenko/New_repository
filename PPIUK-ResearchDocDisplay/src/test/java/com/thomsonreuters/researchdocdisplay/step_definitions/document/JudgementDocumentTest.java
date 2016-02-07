package com.thomsonreuters.researchdocdisplay.step_definitions.document;

import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document.CaseDocumentPage;
import com.thomsonreuters.pageobjects.utils.plPlusResearchDocDisplay.CaseDocumentPageUtils;
import com.thomsonreuters.pageobjects.utils.plPlusResearchDocDisplay.ProvisionPageUtils;
import com.thomsonreuters.researchdocdisplay.step_definitions.BaseStepDef;
import cucumber.api.java.en.Then;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class JudgementDocumentTest extends BaseStepDef {

    private ProvisionPageUtils provisionPageUtils = new ProvisionPageUtils();
    private CaseDocumentPage caseDocumentPage = new CaseDocumentPage();
    private CaseDocumentPageUtils caseDocumentPageUtils = new CaseDocumentPageUtils();

    @Then("^the user see date on the document$")
    public void theUserSeeDateOnTheDocument() throws Throwable {
        assertTrue("The date is not Displayed", provisionPageUtils.isDateOnDocumentDisplayed());
    }

    @Then("^the date corresponds to the required format$")
    public void theDateCorrespondsToTheRequiredFormat() throws Throwable {
        assertTrue("The date do't corresponds to required format",
                provisionPageUtils.isTheDateCorrespondsToTheRequiredFormat());
    }

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

}
