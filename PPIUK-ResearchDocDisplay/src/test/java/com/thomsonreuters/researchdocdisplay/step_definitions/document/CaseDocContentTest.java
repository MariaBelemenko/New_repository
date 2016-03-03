package com.thomsonreuters.researchdocdisplay.step_definitions.document;

import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document.CaseDocumentPage;
import com.thomsonreuters.pageobjects.utils.plPlusResearchDocDisplay.CaseDocumentPageUtils;
import com.thomsonreuters.pageobjects.utils.plPlusResearchDocDisplay.ProvisionPageUtils;
import com.thomsonreuters.researchdocdisplay.step_definitions.BaseStepDef;
import cucumber.api.java.en.Then;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CaseDocContentTest extends BaseStepDef {

    private CaseDocumentPage caseDocumentPage = new CaseDocumentPage();
    private CaseDocumentPageUtils caseDocumentPageUtils = new CaseDocumentPageUtils();

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
