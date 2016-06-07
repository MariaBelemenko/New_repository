package com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document;

import com.thomsonreuters.pageobjects.common.PageActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class JournalDocumentPage extends DocumentDisplayAbstractPage {

	PageActions pageActions;

	private static final By FOOTNOTE_SECTION = By.id("co_footnoteSection");
	private static final By LIGHT_BOX = By.id("co_footnoteHoverDiv");
	private static final By LINK_IN_LIGHTBOX = By.xpath(".//div[2]/div/div/a");

	public WebElement footnoteSection() {
		return waitFluentForElement(FOOTNOTE_SECTION);
	}

	public WebElement lightBox() {
		return waitFluentForElement(LIGHT_BOX);
	}

	public WebElement linkInLightBox() {
		return findChildElement(lightBox(), LINK_IN_LIGHTBOX);
	}

	public String clickOnLinkInLightBox() {
		String firstTitle = getPageTitle();
		linkInLightBox().click();
		return firstTitle;
	}

	public WebElement footnoteNumberInFootnotesSection(String number) {
		return findChildElement(footnoteSection(), By.xpath(".//span[@id='targetfn" + number + "']/a"));
	}

	public WebElement fullFootnoteInFootnotesSection(String number) {
		return findChildElement(footnoteSection(), By.xpath(".//span[@id='targetfn" + number + "']/../.."));
	}

	public WebElement linkInFootnoteBodyInFootnotesSection(String number) {
		return findChildElement(fullFootnoteInFootnotesSection(number),
				By.xpath(".//div[@class='co_footnoteBody']/div/a"));
	}

	public WebElement footnoteNumberInDocument(String number) {
		return waitFluentForElement(By.xpath(".//sup[@id='sourcefn" + number + "']/a"));
	}

	public WebElement documentSubsection(String subsection) {
		return retryingFindElement(By.xpath(".//*[@id='co_docContentBody']//*[contains(text(), \"" + subsection
				+ "\")]"));
	}

	public WebElement valueOfSubsection(String subsection) {
		return retryingFindElement(By.xpath(".//*[@id='co_docContentBody']//*[contains(text(), \"" + subsection
				+ "\")]/.."));
	}

	public WebElement providedByWlukIcon() {
		return retryingFindElement(By.xpath(".//*[@id='co_docContentHeader']//img"));
	}

	public WebElement linkInSubsection(String linkText, String subsection) {
		return retryingFindElement(By.xpath(".//*[contains(text(), '" + subsection
				+ "')]/following-sibling::*//a[contains(text(), '" + linkText + "')]"));
	}

	public WebElement journalDocumentType() {
		return findChildElement(metaContent(), By.xpath(".//*[@class='co_docContentMetaInfoArticleType']/span"));
	}

	public WebElement fieldInMetadata(String field) {
		return findChildElement(metaContent(), By.xpath("//*[contains(text(), '" + field + "')]"));
	}

	public WebElement valueOfFieldInMetadata(String field) {
		return findChildElement(metaContent(),
				By.xpath("//*[contains(text(), '" + field + "')]/following-sibling::span"));
	}

	public WebElement publicationLinkInMetadata() {
		return findChildElement(metaContent(), By.xpath("//*[@class='co_docContentMetaInfoJournalIndexed']//a"));
	}

	public WebElement citationLinkInMetadata() {
		return findChildElement(metaContent(), By.xpath("//*[@class='co_docContentMetaInfoJournalArticle']//a"));
	}

	public WebElement citationTextInMetadata() {
		return findChildElement(metaContent(), By.xpath("//*[@class='co_docContentMetaInfoCitation']/span"));
	}
}
