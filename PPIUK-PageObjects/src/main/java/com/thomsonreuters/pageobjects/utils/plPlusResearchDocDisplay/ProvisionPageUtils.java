package com.thomsonreuters.pageobjects.utils.plPlusResearchDocDisplay;

import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.thomsonreuters.driver.exception.PageOperationException;
import com.thomsonreuters.driver.framework.AbstractPage;
import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document.LegislationDocumentPage;
import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document.ProvisionPage;
import com.thomsonreuters.pageobjects.utils.document.DateFormat;

public class ProvisionPageUtils {

	private ProvisionPage provisionPage = new ProvisionPage();
	private LegislationDocumentPage legislationDocumentPage = new LegislationDocumentPage();

	protected DateFormat dateFormat;

	protected static final Logger LOG = LoggerFactory.getLogger(AbstractPage.class);


	public boolean isTheSectionPresent(String section) {
		try {
			return legislationDocumentPage.sectionInTheDocument(section).isDisplayed();
		} catch (PageOperationException poe) {
			LOG.info("context", poe);
			return false;
		}
	}

	public String clickOnLink(WebElement elementForClick) {
		String firstTitle = provisionPage.getPageTitle();
		elementForClick.click();
		return firstTitle;
	}

	public String clickOnJumpLink(String jumpLinkText) {
		provisionPage.jumpLink(jumpLinkText).click();
		return provisionPage.jumpLink(jumpLinkText).getText();
	}

	public boolean isTheUserRedirectToDesiredPartOfDocument(String jumpLinkText) {
		if (provisionPage.isElementDisplayed(provisionPage.jumpLinkText(jumpLinkText)) == true
				&& provisionPage.jumpLinkText(jumpLinkText).getText()
						.equals(provisionPage.jumpLink(jumpLinkText).getText()))
			return true;
		else
			return false;
	}

}
