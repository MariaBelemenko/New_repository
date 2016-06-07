package com.thomsonreuters.pageobjects.utils.plResearch;

import com.thomsonreuters.driver.exception.PageOperationException;
import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document.AssetDocumentPage;
import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document.StandardDocumentPage;

public class DocumentPageUtils {

	private StandardDocumentPage standardDocumentPage = new StandardDocumentPage();
	private AssetDocumentPage assetDocumentPage = new AssetDocumentPage();
	private static final int  WORD_NUMBER = 3;

	public String getDocumentGUID() {
		return standardDocumentPage.documentMetaInfo().getAttribute("id").split("_")[WORD_NUMBER];
	}

	public boolean isMetadataPresent() {
		try {
			return assetDocumentPage.caseMetadata().isDisplayed();
		} catch (PageOperationException e) {
			return false;
		}
	}

}
