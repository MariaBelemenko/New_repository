package com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document;

import com.thomsonreuters.pageobjects.common.PageActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;




public class JournalDocumentPage extends DocumentDisplayAbstractPage {


	PageActions pageActions;

	private static final By FOOTNOTE_SECTION = By.id("co_footnoteSection");
	private static final By LINK_IN_FOOTNOTE_SECTION = By
			.xpath("//div/div[@class='co_footnoteBody']/div/a");
	private static final By FOOTNOTE_NUMBER_IN_FOOTNOTES_SECTION = By
			.xpath("//div[@class='co_footnoteNumber']/span[@id='targetfn53']/a");
	private static final By FOOTNOTE_NOMBER_WITHIN_THE_DOCUMENT = By
			.xpath("//div[@class='co_paragraph']/sup[@id='sourcefn53']/a");
	private static final By LIGHT_BOX = By.id("co_footnoteHoverDiv");
	private static final By TEXT_IN_LIGHT_BOX = By
			.xpath("//div[@class='co_footnoteHoverTitle']/span");
	private static final By FOOTNOTE_NOMBER_NEAR_THE_DOCUMENT = By
			.xpath("//div[@class='co_paragraph']/sup[@id='sourcefn55']/a");
	private static final By LINK_IN_LIGHTBOX = By.xpath(".//div[2]/div/div/a");

	public WebElement footnoteSection() {
		return waitFluentForElement(FOOTNOTE_SECTION);
	}

	public WebElement linkInFootnoteSection() {
		return findChildElement(footnoteSection(), LINK_IN_FOOTNOTE_SECTION);
	}

	public WebElement footnoteNumberInFootnotesSection() {
		return waitFluentForElement(FOOTNOTE_NUMBER_IN_FOOTNOTES_SECTION);
	}

	public WebElement footnoteNumberWithinTheDocument() {
		return waitFluentForElement(FOOTNOTE_NOMBER_WITHIN_THE_DOCUMENT);
	}

	public WebElement footnoteNumberNearTheDocument() {
		return waitFluentForElement(FOOTNOTE_NOMBER_NEAR_THE_DOCUMENT);
	}

	public WebElement lightBox() {
		return waitFluentForElement(LIGHT_BOX);
	}

	public WebElement textInLightBox() {
		return findChildElement(lightBox(), TEXT_IN_LIGHT_BOX);
	}

	public WebElement linkInLightBox() {
		return findChildElement(lightBox(), LINK_IN_LIGHTBOX);
	}

	public boolean isTheFootnoteContainsLinksToOtherInternalDocuments() {
		waitForPageToLoad();
		return isElementDisplayed(linkInFootnoteSection());
	}

	public String clickOnLinkInTheFootnoteSection() {
		String firstTitle = getPageTitle();
		linkInFootnoteSection().click();
		return firstTitle;
	}

	public boolean isTheUserSeeFootnoteNumberInFootnotesSection() {
		waitForPageToLoad();
		return isElementDisplayed(footnoteNumberInFootnotesSection());
	}

	public void clicksOnAFootnoteNumberInFootnotesSection() {
		footnoteNumberInFootnotesSection().click();
	}

	public boolean isTheUserTakenToThatPartOfDocument() {
		if (isElementDisplayed(footnoteNumberWithinTheDocument()) == true
				&& footnoteNumberWithinTheDocument().getText().equals(
						footnoteNumberInFootnotesSection().getText())) {
			return true;
		} else
			return false;
	}

	public void moveOnAFootnoteWithinTheDocument() {
		pageActions.mouseOver(footnoteNumberNearTheDocument());
	}

	public boolean isTheLightBoxAppears() {
		waitForPageToLoad();
		return isElementDisplayed(lightBox());
	}

	public boolean isTheNoteTextAppears(String noteText) {
		if (textInLightBox().getText().equals(noteText))
			return true;
		else
			return false;
	}

	public boolean isTheUserSeeFootnoteWithinTheDocument() {
		waitForPageToLoad();
		return isElementDisplayed(footnoteNumberNearTheDocument());
	}

	public boolean isTheLightBoxNoteContainsInternalLinksToOtherDocuments() {
		waitForPageToLoad();
		return isElementDisplayed(linkInLightBox());
	}

	public String clickOnLinkInLightBox() {
		String firstTitle = getPageTitle();
		linkInLightBox().click();
		return firstTitle;
	}

}
