package com.thomsonreuters.researchdocdisplay.step_definitions.document;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebElement;

import com.thomsonreuters.pageobjects.common.CommonMethods;
import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document.AssetDocumentPage;
import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document.CaseDocumentPage;
import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document.LegislationDocumentPage;
import com.thomsonreuters.pageobjects.rest.service.impl.RestServiceDeliveryImpl;
import com.thomsonreuters.pageobjects.utils.pdf.PDFBoxUtil;
import com.thomsonreuters.pageobjects.utils.plPlusResearchDocDisplay.CaseDocumentPageUtils;
import com.thomsonreuters.pageobjects.utils.plPlusResearchDocDisplay.ProvisionPageUtils;
import com.thomsonreuters.researchdocdisplay.step_definitions.BaseStepDef;

import cucumber.api.java.en.Then;

public class DocumentDetailsTest extends BaseStepDef {

	private ProvisionPageUtils provisionPageUtils = new ProvisionPageUtils();
	private CaseDocumentPage caseDocumentPage = new CaseDocumentPage();
	private AssetDocumentPage assetDocumentPage = new AssetDocumentPage();
	private RestServiceDeliveryImpl restServiceDeliveryImpl = new RestServiceDeliveryImpl();
	private CommonMethods commonMethods = new CommonMethods();
	private PDFBoxUtil pdfBoxUtil = new PDFBoxUtil();
	private LegislationDocumentPage legislationDocumentPage = new LegislationDocumentPage();
	private CaseDocumentPageUtils caseDocumentPageUtils = new CaseDocumentPageUtils();


	@Then("^the \"([^\"]*)\" link is not displayed$")
	public void theLinkIsNotDisplayed(String link) throws Throwable {
		assertFalse("The " + link + " is displayed on the document", caseDocumentPageUtils.isTheLinkPresent(link));
	}

	@Then("^the \"(.*?)\" section is not displayed$")
	public void theSectionIsNotDisplayed(String section) throws Throwable {
		assertFalse("The annotated status section is displayed on the document",
				provisionPageUtils.isTheSectionPresent(section));
	}

	@Then("^the pdf image is displayed$")
	public void thePdfImageIsDisplayed() throws Throwable {
		assertTrue("User doesn't see pdf image on document", caseDocumentPage.pdfImage().isDisplayed());
	}

	@Then("^the table of contents is displayed$")
	public void theTableOfContentsIsDisplayed() throws Throwable {
		assertTrue("Teble of content is not displayed", assetDocumentPage.tableOfContentSection().isDisplayed());
	}

	@Then("^delivery options are displayed$")
	public void deliveryOptionsAreDisplayed() throws Throwable {
		assertTrue("The delivery options are not displayed", caseDocumentPage.deliveryOptions().isDisplayed());
	}

	@Then("^the document contains the link for downloading$")
	public void theDocumentContainsTheLinkForDownloading() throws Throwable {
		assertTrue("The document doesn't contain the link for downloading", caseDocumentPage.documentInPdf()
				.isDisplayed());
	}

	@Then("^the user downloads the \"([^\"]*)\" with \"([^\"]*)\"$")
	public void theUserDownloadsTheWith(String document, String nameOfDownloadedDocument) throws Throwable {
		File downloadedFile = restServiceDeliveryImpl.getFileViaHttp(commonMethods.getElementByLinkText(document)
				.getAttribute("href"), nameOfDownloadedDocument);
		assertFalse("downloaded document is empty", pdfBoxUtil.extractText(downloadedFile.getAbsolutePath()).isEmpty());
	}

	@Then("^the left hand navigation menu is displayed$")
	public void theLeftHandNavigationMenuIsDisplayed() throws Throwable {
		assertTrue("The left hand navigation menu is not displayed", caseDocumentPage.columnForTheLeftHandNavigation()
				.isDisplayed());
	}

	@Then("^the content column is displayed$")
	public void theContentColumnIsDisplayed() throws Throwable {
		assertTrue("The content column is not displayed", caseDocumentPage.contentColumn().isDisplayed());
	}

	@Then("^the status icon is displayed$")
	public void theStatusIconIsDisplayed() throws Throwable {
		assertTrue("The status icon is not displayed", caseDocumentPage.statusIcon().isDisplayed());
	}

	@Then("^the status description is displayed$")
	public void theStatusDescriptionIsDisplayed() throws Throwable {
		assertTrue("The status description is not displayed", caseDocumentPage.statusDescription().isDisplayed());
	}

	@Then("^the \"([^\"]*)\" section contains \"([^\"]*)\"$")
	public void theSectionContains(String section, String text) throws Throwable {
		assertTrue("The " + section + " section doesn't contain " + text,
				legislationDocumentPage.textInSection(section, text).isDisplayed());
	}

	@Then("^the \"([^\"]*)\" section contains paragraphs$")
	public void theSectionContainsParagraphs(String section) throws Throwable {
		SoftAssertions softly = new SoftAssertions();
		softly.assertThat(legislationDocumentPage.paragraphsInSection(section).isEmpty())
				.overridingErrorMessage("There is no paragraph in the " + section + " section").isFalse();
		for (WebElement element : legislationDocumentPage.paragraphsInSection(section)) {
			softly.assertThat(element.isDisplayed()).overridingErrorMessage("The paragraph is not displayed").isTrue();

		}
		softly.assertAll();

	}
}
