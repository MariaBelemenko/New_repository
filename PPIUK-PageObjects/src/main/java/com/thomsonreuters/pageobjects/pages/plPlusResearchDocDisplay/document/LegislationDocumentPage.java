package com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LegislationDocumentPage extends DocumentDisplayAbstractPage {

	public List<WebElement> amendmentsNumbers() {
		return retryingFindElements(By.xpath(".//*[@id='co_footnoteSection']//*[@class='co_footnoteNumber']//a"));
	}

	public List<WebElement> amendmentsDescription() {
		return retryingFindElements(By.xpath(".//*[@id='co_footnoteSection']//*[@class='co_footnoteBody']"));
	}

	public WebElement footnoteReference(String number) {
		return retryingFindElement(By.xpath(".//*[@id='co_footnoteReference_" + number + "']/a"));
	}

	public WebElement footnoteText(String text) {
		return retryingFindElement(By.xpath(".//*[@class='co_footnoteHoverTitle']/*[text()='" + text + "']"));
	}

	public WebElement textInSection(String section, String text) {
		return retryingFindElement(By.xpath(".//*[contains(text(), '" + section
				+ "')]/following-sibling::*//*[contains(text(), '" + text + "')]"));
	}

	public List<WebElement> paragraphsInSection(String section) {
		return retryingFindElements(By.xpath(".//*[contains(text(), '" + section
				+ "')]/following-sibling::*//*[@class='co_paragraph']"));
	}

	public WebElement sectionInTheDocument(String section) {
		return retryingFindElement(By.xpath(".//*[@id='co_docContentBody']//*[contains(text(), '" + section + ")]"));
	}

	public List<WebElement> linksInSection(String section) {
		return retryingFindElements(By.xpath(String.format(".//*[contains(text(), '%s')]/../following-sibling::a",
				section)));
	}
}
