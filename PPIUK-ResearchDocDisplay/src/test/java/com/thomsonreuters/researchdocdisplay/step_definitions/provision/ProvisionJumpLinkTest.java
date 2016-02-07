package com.thomsonreuters.researchdocdisplay.step_definitions.provision;

import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document.ProvisionPage;
import com.thomsonreuters.pageobjects.utils.plPlusResearchDocDisplay.ProvisionPageUtils;
import com.thomsonreuters.researchdocdisplay.step_definitions.BaseStepDef;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertTrue;

public class ProvisionJumpLinkTest extends BaseStepDef {

    private ProvisionPage provisionPage = new ProvisionPage();
    private ProvisionPageUtils provisionPageUtils = new ProvisionPageUtils();

    private String linkText;

    @Then("^the user see \"(.*?)\" jump link$")
    public void theUserSeeJumpLink(String jumpLinkText) throws Throwable {
        assertTrue("The user doesn't see jump links", provisionPage.isElementDisplayed(provisionPage.jumpLink(jumpLinkText)));
    }

    @When("^the user clicks on \"(.*?)\" jump links$")
    public void theUserClicksOnJumpLinks(String jumpLinkText) throws Throwable {
        linkText = provisionPageUtils.clickOnJumpLink(jumpLinkText);
    }

    @Then("^the user redirected to that part of the document\\.$")
    public void theUserRedirectedToThatPartOfTheDocument() throws Throwable {
        assertTrue("The user doesn't taken to the selected part of the document",
                provisionPageUtils.isTheUserRedirectToDesiredPartOfDocument(linkText));
    }

}
