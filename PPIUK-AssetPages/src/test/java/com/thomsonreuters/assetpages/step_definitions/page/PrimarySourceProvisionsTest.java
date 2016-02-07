package com.thomsonreuters.assetpages.step_definitions.page;

import com.thomsonreuters.assetpages.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document.PrimarySourceDocumentPage;
import com.thomsonreuters.pageobjects.utils.plPlusResearchDocDisplay.AssetPageUtils;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertTrue;

public class PrimarySourceProvisionsTest extends BaseStepDef {

    private PrimarySourceDocumentPage primarySourceDocumentPage = new PrimarySourceDocumentPage();
    private AssetPageUtils assetPageUtils = new AssetPageUtils();

    private String hrefAtribute;

    @Then("^the user sees \"(.*?)\" Specific provision coverage$")
    public void theUserSeesSpecificProvisionCoverage(String provisionSectionText) throws Throwable {
        assertTrue("The user doesn't see specific Provision coverage",
                primarySourceDocumentPage.isElementDisplayed(primarySourceDocumentPage
                        .specificProvisionCoverageText(provisionSectionText))
        );
    }

    @Then("^the user sees the \"(.*?)\" link in Specific provision coverage section$")
    public void theUserSeesTheLinkInSpecificProvisionCoverageSection(String linkText) throws Throwable {
        assertTrue("The user doesn't see link in provision coverage section",
                primarySourceDocumentPage.isElementDisplayed(primarySourceDocumentPage
                        .linkInSpecificProvisionCoverageSection(linkText))
        );
    }

    @When("^the user clicks on this \"(.*?)\" link in Specific provision coverage section$")
    public void theUserClicksOnThisLinkInSpecificProvisionCoverageSection(String linkText) throws Throwable {
        assetPageUtils.getBaseParameters();
        hrefAtribute = primarySourceDocumentPage.linkInSpecificProvisionCoverageSection(linkText).getAttribute("href");
        primarySourceDocumentPage.linkInSpecificProvisionCoverageSection(linkText).click();
    }

    @Then("^the user is taken to the primary source document$")
    public void theUserIsTakenToThePrimarySourceDocument() throws Throwable {
        assertTrue("The user doesn't taken to the primary source document",
                assetPageUtils.isTheUserTakenToTheInternalDocument(hrefAtribute));
    }

    @Then("^the \"(.*?)\" section displayed below \"(.*?)\" section$")
    public void theSectionDisplayedBelowSection(String specificProvisionText, String otherProvisionsText) throws Throwable {
        assertTrue("The Specific provision doesn't displayed below other provision section",
                primarySourceDocumentPage.isElementDisplayed(primarySourceDocumentPage
                        .specificProvisionSectionUnderOtherProvisions(specificProvisionText, otherProvisionsText))
        );
    }

    @Then("^the \"(.*?)\" section does not has \"(.*?)\" style$")
    public void theSectionDoesNotHasStyle(String sectionNameText, String styleText) throws Throwable {
        assertTrue("The Other provision section has " + styleText + " style",
                assetPageUtils.isTheOtherProvisionSectionHasStyle(sectionNameText, styleText));
    }

}
