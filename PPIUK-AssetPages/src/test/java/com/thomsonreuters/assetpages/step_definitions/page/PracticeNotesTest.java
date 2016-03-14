package com.thomsonreuters.assetpages.step_definitions.page;

import com.thomsonreuters.assetpages.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document.AssetDocumentPage;
import cucumber.api.java.en.Then;

import static org.junit.Assert.assertTrue;

public class PracticeNotesTest extends BaseStepDef {

    private AssetDocumentPage assetDocumentPage = new AssetDocumentPage();

    @Then("^the user sees \"(.*?)\" UK Practice Notes section$")
    public void theUserSeesUKPracticeNotesSection(String practiceNotesText) throws Throwable {
        assetDocumentPage.waitForPageToLoad();
        assertTrue("The user doesn't see UK Practice Notes section",
                assetDocumentPage.practiceNotes(practiceNotesText).isDisplayed());
    }

}
