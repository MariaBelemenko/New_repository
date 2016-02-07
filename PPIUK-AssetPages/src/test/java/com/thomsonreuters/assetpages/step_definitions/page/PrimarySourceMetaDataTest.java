package com.thomsonreuters.assetpages.step_definitions.page;

import com.thomsonreuters.assetpages.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document.PrimarySourceDocumentPage;
import com.thomsonreuters.pageobjects.utils.plPlusResearchDocDisplay.AssetPageUtils;
import cucumber.api.java.en.Then;

import static org.junit.Assert.assertTrue;

public class PrimarySourceMetaDataTest extends BaseStepDef {

    private PrimarySourceDocumentPage primarySourceDocumentPage = new PrimarySourceDocumentPage();
    private AssetPageUtils assetPageUtils = new AssetPageUtils();

    @Then("^the user see the Legislation metadata in the right hand side of the central column$")
    public void theUserSeeTheLegislationMetadataInTheRightHandSideOfTheCentralColumn() throws Throwable {
        assertTrue("The user doesn't see the Legislation metadata in the right hand side of the central column",
                primarySourceDocumentPage.isElementDisplayed(primarySourceDocumentPage.metaData()));
    }

    @Then("^the user see \"(.*?)\" resource type$")
    public void theUserSeeResourceType(String resourceType) throws Throwable {
        assertTrue("The user doesn't see the resource type",
                primarySourceDocumentPage.isElementDisplayed(primarySourceDocumentPage.metaDataText(resourceType)));
    }

    @Then("^The user sees \"(.*?)\" status$")
    public void theUserSeesStatus(String statusName) throws Throwable {
        assertTrue("The user doesn't see status",
                primarySourceDocumentPage.isElementDisplayed(primarySourceDocumentPage.documentStatus(statusName)));
    }

    @Then("^the user see \"(.*?)\" jurisdiction$")
    public void theUserSeeJurisdiction(String jurisdictionText) throws Throwable {
        assertTrue("The user doesn't see the jurisdiction",
                assetPageUtils.isTheUserSeesTheJurisdiction(jurisdictionText));
    }

    @Then("^the user sees the content of \"(.*?)\" jurisdiction$")
    public void theUserSeesTheContentOfJurisdiction(String metaDataText) throws Throwable {
        assertTrue("The user doesn't see the content of jurisdiction",
                assetPageUtils.isTheUserSeesContentOfMetaDataFields(metaDataText));
    }

    @Then("^the user see \"(.*?)\" jurisdictions$")
    public void theUserSeeJurisdictions(String jurisdictionsText) throws Throwable {
        assertTrue("The user doesn't see the jurisdictions",
                primarySourceDocumentPage.isElementDisplayed(primarySourceDocumentPage.metaDataText(jurisdictionsText)));
    }

    @Then("^the user sees the content of \"(.*?)\" jurisdictions$")
    public void theUserSeesTheContentOfJurisdictions(String jurisdictionsText) throws Throwable {
        assertTrue("The user doesn't see the content of jurisdictions",
                assetPageUtils.isTheUserSeesContentOfMetaDataFields(jurisdictionsText));
    }

    @Then("^the \"(.*?)\" Jurisdictions contain more than one jurisdiction$")
    public void theJurisdictionsContainMoreThanOneJurisdiction(String jurisdictionsText) throws Throwable {
        assertTrue("The jurisdictions contain less than one jurisdiction",
                assetPageUtils.isTheJurisdictionsContainLessThanOneJurisdiction(jurisdictionsText));
    }

}
