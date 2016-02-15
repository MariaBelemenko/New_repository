package com.thomsonreuters.should.step_definitions.assetPages;

import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document.AssetDocumentPage;
import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document.PrimarySourceDocumentPage;
import com.thomsonreuters.pageobjects.utils.plPlusResearchDocDisplay.AssetPageUtils;
import com.thomsonreuters.should.step_definitions.BaseStepDef;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertTrue;

public class PrimarySourceJumpLinksTest extends BaseStepDef {

    private PrimarySourceDocumentPage primarySourceDocumentPage = new PrimarySourceDocumentPage();
    private AssetPageUtils assetPageUtils = new AssetPageUtils();
    private AssetDocumentPage assetDocumentPage = new AssetDocumentPage();

    private String linkText;

    @Then("^text added to the document$")
    public void textAddedToTheDocument() throws Throwable {
        primarySourceDocumentPage.waitForPageToLoadAndJQueryProcessing();
        assetPageUtils.addTextToTheDocumentPage();
    }

    @Then("^the user see \"(.*?)\" jump link in the left hand side navigation panel$")
    public void theUserSeeJumpLinkInTheLeftHandSideNavigationPanel(String jumpLinkText) throws Throwable {
        assetDocumentPage.waitForPageToLoad();
        assetDocumentPage.waitForPageToLoadAndJQueryProcessing();
        assertTrue("The user doesn't see jump links in the left hand navigation panel",
                assetPageUtils.isTheUserSeeJumpLinksInTheLeftHandSideNavigationPanel(jumpLinkText));
    }

    @When("^the user clicks on \"(.*?)\" jump link$")
    public void theUserClicksOnJumpLink(String jumpLinkText) throws Throwable {
        linkText = assetPageUtils.clickOnJumpLink(jumpLinkText);
    }

    @Then("^the user is taken to selected part of the document$")
    public void theUserIsTakenToSelectedPartOfTheDocument() throws Throwable {
        assertTrue("The user doesn't taken to the selected part of the document",
                assetPageUtils.isTheUserTakenToSelectedPartOfTheDocument(linkText));
    }

}
