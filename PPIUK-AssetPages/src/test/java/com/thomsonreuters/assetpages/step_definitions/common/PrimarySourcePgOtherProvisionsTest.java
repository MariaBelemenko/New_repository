package com.thomsonreuters.assetpages.step_definitions.common;

import com.thomsonreuters.assetpages.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document.PrimarySourceDocumentPage;
import com.thomsonreuters.pageobjects.utils.plPlusResearchDocDisplay.AssetPageUtils;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertTrue;

public class PrimarySourcePgOtherProvisionsTest extends BaseStepDef {

    private PrimarySourceDocumentPage primarySourceDocumentPage = new PrimarySourceDocumentPage();
    private AssetPageUtils assetPageUtils = new AssetPageUtils();

    private String hrefAtribute;

    @Then("^the user sees \"(.*?)\" section$")
    public void theUserSeesSection(String sectionNameText) throws Throwable {
        assertTrue("The user doesn't see the other provisions section",
                primarySourceDocumentPage.isElementDisplayed(primarySourceDocumentPage
                        .otherProvisionsSection(sectionNameText))
        );
    }

    @Then("^the user sees \"(.*?)\" in \"(.*?)\" other provisions section$")
    public void theUserSeesInOtherProvisionsSection(String linkText, String otherProvisionsText) throws Throwable {
        assertTrue("The user doesn't see this link in other provision section",
                primarySourceDocumentPage.isElementDisplayed(primarySourceDocumentPage.linkInOtherProvisionsSection(
                        linkText, otherProvisionsText))
        );
    }

    @When("^the user clicks on this \"(.*?)\" link$")
    public void theUserClicksOnThisLink(String linkText) throws Throwable {
        assetPageUtils.getBaseParameters();
        hrefAtribute = primarySourceDocumentPage.linkInPrimarySource(linkText).getAttribute("href");
        primarySourceDocumentPage.linkInPrimarySource(linkText).click();
    }

    @Then("^the user is taken from primary source page to internal document$")
    public void theUserIsTakenFromPrimarySourcePageToInternalDocument() throws Throwable {
        assertTrue("The user doesn't taken to the internal document",
                assetPageUtils.isTheUserTakenToTheInternalDocument(hrefAtribute));
    }

}
