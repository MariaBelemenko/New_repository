package com.thomsonreuters.assetpages.step_definitions.link;

import com.thomsonreuters.assetpages.step_definitions.BaseStepDef;
import com.thomsonreuters.driver.exception.PageOperationException;
import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document.AssetDocumentPage;
import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document.PrimarySourceDocumentPage;
import com.thomsonreuters.pageobjects.utils.plPlusResearchDocDisplay.AssetPageUtils;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ContentJumpLinksTest extends BaseStepDef {

    private PrimarySourceDocumentPage primarySourceDocumentPage = new PrimarySourceDocumentPage();
    private AssetPageUtils assetPageUtils = new AssetPageUtils();
    private AssetDocumentPage assetDocumentPage = new AssetDocumentPage();

    private String linkText;

    @Then("^text added to the document$")
    public void textAddedToTheDocument() throws Throwable {
        primarySourceDocumentPage.waitForPageToLoadAndJQueryProcessing();
        assetPageUtils.addTextToTheDocumentPage();
    }

    @Then("^the user is taken to selected part of the document$")
    public void theUserIsTakenToSelectedPartOfTheDocument() throws Throwable {
        assertTrue("The user doesn't taken to the selected part of the document",
                assetPageUtils.isTheUserTakenToSelectedPartOfTheDocument(linkText));
    }

    @Then("^the user does not see \"(.*?)\" jump link$")
    public void theUserDoesNotSeeJumpLink(String jumpLinkText) throws Throwable {
        try {
            assertFalse("The user see jump links in the left hand navigation panel",
                    assetDocumentPage.isElementDisplayed(assetDocumentPage.jumpLink(jumpLinkText)));
        } catch (PageOperationException poe) {
            LOG.info("context", poe);
        }
    }

    @When("^the user does not see \"(.*?)\" section$")
    public void theUserDoesNotSeeSection(String jumpLinkText) throws Throwable {
        try {
            assertFalse("The user see jump link section",
                    assetDocumentPage.isElementDisplayed(assetDocumentPage.junpLinkSection(jumpLinkText)));
        } catch (PageOperationException poe) {
            LOG.info("context", poe);
        }
    }

}