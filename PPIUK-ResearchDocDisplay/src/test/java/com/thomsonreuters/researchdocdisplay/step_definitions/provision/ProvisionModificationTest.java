package com.thomsonreuters.researchdocdisplay.step_definitions.provision;

import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document.ProvisionPage;
import com.thomsonreuters.researchdocdisplay.step_definitions.BaseStepDef;
import cucumber.api.java.en.Then;

import static org.junit.Assert.assertTrue;

public class ProvisionModificationTest extends BaseStepDef {

    private ProvisionPage provisionPage = new ProvisionPage();


    @Then("^the user see modifications on document$")
    public void theUserSeeModificationsOnDocument() throws Throwable {
        assertTrue("The modifications is not displayed",
                provisionPage.isModificationsOnDocumentDispleyed());
    }

    @Then("^modifications contain internal links to other documents$")
    public void modificationsContainInternalLinksToOtherDocuments() throws Throwable {
        assertTrue("Link under modifications do't displayed",
                provisionPage.isMdificationsContainLinksToOtherDocuments());
    }

}
