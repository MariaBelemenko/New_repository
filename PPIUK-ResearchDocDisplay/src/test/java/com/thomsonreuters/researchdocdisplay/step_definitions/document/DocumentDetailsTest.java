package com.thomsonreuters.researchdocdisplay.step_definitions.document;

import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document.CaseDocumentPage;
import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document.ProvisionPage;
import com.thomsonreuters.pageobjects.utils.plPlusResearchDocDisplay.AssetPageUtils;
import com.thomsonreuters.pageobjects.utils.plPlusResearchDocDisplay.CaseDocumentPageUtils;
import com.thomsonreuters.pageobjects.utils.plPlusResearchDocDisplay.ProvisionPageUtils;
import com.thomsonreuters.researchdocdisplay.step_definitions.BaseStepDef;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DocumentDetailsTest extends BaseStepDef {

    private ProvisionPageUtils provisionPageUtils = new ProvisionPageUtils();
    private ProvisionPage provisionPage = new ProvisionPage();
    private CaseDocumentPage caseDocumentPage = new CaseDocumentPage();
    private CaseDocumentPageUtils caseDocumentPageUtils = new CaseDocumentPageUtils();
    private AssetPageUtils assetPageUtils = new AssetPageUtils();

    @Then("^title displayed on opened document$")
    public void titleDisplayedOnOpenedDocument() throws Throwable {
        assertTrue("The title is not displayed on document", provisionPageUtils.isTitleDisplayedOnOpenedDocument());
    }

    @Then("^the user see status$")
    public void theUserSeeStatus() throws Throwable {
        assertTrue("The status is not displayed on document", provisionPage.isElementDisplayed(provisionPage.documentStatus()));
    }

    @Then("^the user see effective date$")
    public void theUserSeeEffectiveDate() throws Throwable {
        assertTrue("The date is not displayed on document", provisionPage.isElementDisplayed(provisionPage.effectiveDate()));
    }

    @Then("^the user see version$")
    public void theUserSeeVersion() throws Throwable {
        assertTrue("The version is not displayed on document", provisionPage.isElementDisplayed(provisionPage.documentVersion()));
    }

    @Then("^the \"(.*?)\" menu link is present$")
    public void theMenuLinkIsPresent(String annotatedStatusLink) throws Throwable {
        assertTrue("The annotated status link is not displayed on document",
                provisionPageUtils.isTheAnnotatedStatutesMenuLinkIsPresent(annotatedStatusLink));
    }

    @When("^the user click on \"(.*?)\" menu link$")
    public void theUserClickOnMenuLink(String linkName) throws Throwable {
        provisionPage.clickOnAnnotatedStatutesMenuLink(linkName);
    }

    @Then("^the usee see the \"(.*?)\" text$")
    public void theUseeSeeTheText(String annotatedStatusText) throws Throwable {
        assertTrue("The user doesn't see the annotated statutes text",
                provisionPageUtils.isTheUserSeeTheAnnotatedStatutesText(annotatedStatusText));
    }

    @Then("^the user see the \"(.*?)\" and paragraphs$")
    public void theUserSeeTheAndParagraphs(String section) throws Throwable {
        assertTrue("The user doesn't see the section and paragraphs",
                provisionPageUtils.isTheUserSeeTheSectionAndParagraphs(section));
    }

    @Then("^the \"(.*?)\" menu link is not present$")
    public void theMenuLinkIsNotPresent(String annotatedStatusLink) throws Throwable {
        assertFalse("The annotated status link is displayed on document",
                provisionPageUtils.isTheAnnotatedStatutesMenuLinkIsPresent(annotatedStatusLink));
    }

    @Then("^the \"(.*?)\" section is not displayed$")
    public void theSectionIsNotDisplayed(String annotatedStatusLink) throws Throwable {
        assertFalse("The annotated status section is displayed on document",
                provisionPageUtils.isTheUserSeeTheAnnotatedStatutesText(annotatedStatusLink));
    }

    @Then("^the user see a column for the left hand navigation$")
    public void theUserSeeAColumnForTheLeftHandNavigation() throws Throwable {
        assertTrue("User doesn't see left navigation column",
                caseDocumentPage.isElementDisplayed(caseDocumentPage.columnForTheLeftHandNavigation()));
    }

    @Then("^the user see the content column$")
    public void theUserSeeTheContentColumn() throws Throwable {
        assertTrue("The user doesn't see the content column", caseDocumentPageUtils.isTheUserSeeTheContentColumn());
    }

    @Then("^the user see the delivery options$")
    public void theUserSeeTheDeliveryOptions() throws Throwable {
        assertTrue("User doesn't see delivery options on document",
                caseDocumentPage.isElementDisplayed(caseDocumentPage.deliveryOptions()));
    }

    @Then("^the user see the meta content on the document$")
    public void theUserSeeTheMetaContentOnTheDocument() throws Throwable {
        assertTrue("User doesn't see the meta content on document",
                caseDocumentPage.isElementDisplayed(caseDocumentPage.metaContent()));
    }

    @Then("^the user see Status Icon$")
    public void theUserSeeStatusIcon() throws Throwable {
        assertTrue("The user doesn't see status icon", caseDocumentPageUtils.isTheUserSeeStatusIcon());
    }

    @Then("^the user see Status Description$")
    public void theUserSeeStatusDescription() throws Throwable {
        assertTrue("The user doesn't see status description", caseDocumentPageUtils.isTheUserSeeStatusDescription());
    }

    @Then("^the user see \"(.*?)\" Court$")
    public void theUserSeeCourt(String courtText) throws Throwable {
        assertTrue("The user doesn't see court", assetPageUtils.isTheFieldInMetadataDisplayed(courtText));
    }

    @Then("^the user see \"(.*?)\" Date$")
    public void theUserSeeDate(String dateText) throws Throwable {
        assertTrue("The user doesn't see date", assetPageUtils.isTheFieldInMetadataDisplayed(dateText));
    }

    @Then("^the user see \"(.*?)\" Where Reported$")
    public void theUserSeeWhereReported(String whereReportedText) throws Throwable {
        assertTrue("The user doesn't see Where Reported", assetPageUtils.isTheFieldInMetadataDisplayed(whereReportedText));
    }

    @When("^the user see \"(.*?)\" hearing dates$")
    public void theUserSeeHearingDates(String hearingDates) throws Throwable {
        assertTrue("The user doesn't see hearing dates", assetPageUtils.isTheFieldInMetadataDisplayed(hearingDates));
    }

    @Then("^the user see \"(.*?)\" Appellate committee$")
    public void theUserSeeAppellateCommittee(String appellateCommitteeText) throws Throwable {
        assertTrue("The user doesn't see appellate committee", assetPageUtils.isTheFieldInMetadataDisplayed(appellateCommitteeText));
    }

}
