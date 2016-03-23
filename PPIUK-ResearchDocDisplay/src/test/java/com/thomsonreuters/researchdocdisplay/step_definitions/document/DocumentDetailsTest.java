package com.thomsonreuters.researchdocdisplay.step_definitions.document;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;

import com.thomsonreuters.pageobjects.common.CommonMethods;
import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document.AssetDocumentPage;
import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document.CaseDocumentPage;
import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document.ProvisionPage;
import com.thomsonreuters.pageobjects.rest.service.impl.RestServiceDeliveryImpl;
import com.thomsonreuters.pageobjects.utils.pdf.PDFBoxUtil;
import com.thomsonreuters.pageobjects.utils.plPlusResearchDocDisplay.AssetPageUtils;
import com.thomsonreuters.pageobjects.utils.plPlusResearchDocDisplay.CaseDocumentPageUtils;
import com.thomsonreuters.pageobjects.utils.plPlusResearchDocDisplay.ProvisionPageUtils;
import com.thomsonreuters.researchdocdisplay.step_definitions.BaseStepDef;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DocumentDetailsTest extends BaseStepDef {

    private ProvisionPageUtils provisionPageUtils = new ProvisionPageUtils();
    private ProvisionPage provisionPage = new ProvisionPage();
    private CaseDocumentPage caseDocumentPage = new CaseDocumentPage();
    private CaseDocumentPageUtils caseDocumentPageUtils = new CaseDocumentPageUtils();
    private AssetPageUtils assetPageUtils = new AssetPageUtils();
    private AssetDocumentPage assetDocumentPage = new AssetDocumentPage();
    private RestServiceDeliveryImpl restServiceDeliveryImpl = new RestServiceDeliveryImpl();
    private CommonMethods commonMethods = new CommonMethods();
    private PDFBoxUtil pdfBoxUtil = new PDFBoxUtil();

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

    @Then("^the pdf image is displayed$")
    public void thePdfImageIsDisplayed() throws Throwable {
    	assertTrue("User doesn't see pdf image on document",
				caseDocumentPage.pdfImage().isDisplayed());
    }

    @Then("^the table of contents is displayed$")
    public void theTableOfContentsIsDisplayed() throws Throwable {
    	assertTrue("Teble of content is not displayed",
				assetDocumentPage.tableOfContentSection().isDisplayed());
    }

    @Then("^delivery options are displayed$")
    public void deliveryOptionsAreDisplayed() throws Throwable {
    	assertTrue("The delivery options are not displayed",
				caseDocumentPage.deliveryOptions().isDisplayed());
    }

    @Then("^the document contains the link for downloading$")
    public void theDocumentContainsTheLinkForDownloading() throws Throwable {
    	assertTrue("The document doesn't contain the link for downloading",
				caseDocumentPage.documentInPdf().isDisplayed());
    }

    @Then("^the user downloads the \"([^\"]*)\" with \"([^\"]*)\"$")
    public void theUserDownloadsTheWith(String document, String nameOfDownloadedDocument) throws Throwable {
    	File downloadedFile = restServiceDeliveryImpl.getFileViaHttp(commonMethods.getElementByLinkText(document).getAttribute("href"), nameOfDownloadedDocument);
	    assertFalse("downloaded document is empty", pdfBoxUtil.extractText(downloadedFile.getAbsolutePath()).isEmpty());
    }

    
}
