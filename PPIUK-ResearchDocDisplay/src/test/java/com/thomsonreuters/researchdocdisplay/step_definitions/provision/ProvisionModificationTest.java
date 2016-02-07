package com.thomsonreuters.researchdocdisplay.step_definitions.provision;

import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document.ProvisionPage;
import com.thomsonreuters.pageobjects.utils.plPlusResearchDocDisplay.ProvisionPageUtils;
import com.thomsonreuters.researchdocdisplay.step_definitions.BaseStepDef;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertTrue;

public class ProvisionModificationTest extends BaseStepDef {

    private ProvisionPage provisionPage = new ProvisionPage();
    private ProvisionPageUtils provisionPageUtils = new ProvisionPageUtils();

    private String title;

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

    @When("^the user clicks on one of those links$")
    public void theUserClicksOnOneOfThoseLinks() throws Throwable {
        title = provisionPage.clickOnLink();
    }

    @Then("^the user will be taken to the selected document$")
    public void theUserWillBeTakenToTheSelectedDocument() throws Throwable {
        assertTrue("The user did'n take the selected document",
                provisionPageUtils.isTheUserTakenToTheSelectedDocument(title));
    }

}
