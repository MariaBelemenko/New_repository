package com.thomsonreuters.researchdocdisplay.step_definitions.casedoc;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;

import com.thomsonreuters.pageobjects.common.CommonMethods;
import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document.CaseDocumentPage;
import com.thomsonreuters.pageobjects.rest.service.impl.RestServiceDeliveryImpl;
import com.thomsonreuters.pageobjects.utils.pdf.PDFBoxUtil;
import com.thomsonreuters.pageobjects.utils.plPlusResearchDocDisplay.CaseDocumentPageUtils;
import com.thomsonreuters.researchdocdisplay.step_definitions.BaseStepDef;

import cucumber.api.java.en.Then;

public class CaseDocContentTest extends BaseStepDef {

    private CaseDocumentPage caseDocumentPage = new CaseDocumentPage();
    private CaseDocumentPageUtils caseDocumentPageUtils = new CaseDocumentPageUtils();
	private RestServiceDeliveryImpl restServiceDeliveryImpl = new RestServiceDeliveryImpl();
	private CommonMethods commonMethods = new CommonMethods();
	private PDFBoxUtil pdfBoxUtil = new PDFBoxUtil();

    @Then("^the \"([^\"]*)\" navigation menu is disabled$")
    public void theNavigationMenuIsDisabled(String text) throws Throwable {
    	 assertFalse("The " + text + " menu is enabled",
                 caseDocumentPageUtils.isTheLinkPresent(text));
    	 assertTrue(text + " is not dispalyed ",
    			 caseDocumentPage.menuItem(text).isDisplayed());
    }
    

    @Then("^the \"([^\"]*)\" section contains footnotes body with numbers$")
    public void theSectionContainsFootnotesBodyWithNumbers(String section) throws Throwable {
    	assertTrue("The footnotes header is not displayed", caseDocumentPage.footnotesSection(section).isDisplayed());
		assertTrue("The footnotes boby is displayed", caseDocumentPage.footnotesBody(section).isDisplayed());
		assertTrue("The footnotes numbers are displayed", caseDocumentPage.footnotesNumber(section).isDisplayed());
    }
    
    @Then("^the document contains date in \"(.*?)\" format$")
	public void theDocumentContainsDateInFormat(String format) throws Throwable {
		caseDocumentPage.waitForPageToLoad();
		String[] metaInfo = caseDocumentPage.dateText().getText().split("\n");
		assertTrue("The date is not displayed", caseDocumentPage.dateText().isDisplayed());
		assertTrue("The format of the date is not correct!",
				caseDocumentPageUtils.isTheDateHasCorrectFormat(metaInfo[4], format));
	}
    
	@Then("^the pdf image is displayed$")
	public void thePdfImageIsDisplayed() throws Throwable {
		assertTrue("User doesn't see pdf image on document", caseDocumentPage.pdfImage().isDisplayed());
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
}
