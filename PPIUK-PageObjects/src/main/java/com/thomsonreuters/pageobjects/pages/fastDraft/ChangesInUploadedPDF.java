package com.thomsonreuters.pageobjects.pages.fastDraft;

import com.thomsonreuters.pageobjects.common.CommonMethods;
import com.thomsonreuters.driver.framework.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ChangesInUploadedPDF extends AbstractPage {

	private static final String ERROR = "PDF Upload error : The form you selected does not belong to the project you tried to load it into. Please select the correct form and try again";
	private static final String TYPE_ERROR = "PDF Upload error : The selected file is not the correct type (PDF). Please try again ensuring you select a PDF file";

    private CommonMethods comMethods = new CommonMethods();;

	public void checkChangesInUploadedPDFDisplayed() {
		WebElement changesInUploadedPDF = null;
		try {
			changesInUploadedPDF = comMethods.waitForElementToBeVisible(
					By.xpath("//*[text()='Changes in the uploaded PDF']"), 10000);
			changesInUploadedPDF.isDisplayed();
		} catch (NullPointerException e) {
			throw new RuntimeException("Changes in the uploaded PDF absents", e.getCause());
		}
	}

	public void checkSectionHasOriginalAndRevicedValues(String sectionName, String originalValue, String revisedValue) {
		WebElement sectionWithValues = null;
		try {
			sectionWithValues = comMethods.waitForElementToBeVisible(
					By.xpath("//tr[contains(.,'" + sectionName + "') and contains(.,'" + originalValue
							+ "') and contains(.,'" + revisedValue + "')]"), 10000);
			sectionWithValues.isDisplayed();
		} catch (NullPointerException e) {
			throw new RuntimeException("Section with values absents", e.getCause());
		}
	}

	public WebElement section(String sectionName) {
		return comMethods.waitForElementToBeVisible(By.xpath("//tr[contains(.,'" + sectionName + "')]//td/input[@id and @type='checkbox']"), 10000);
	}

	public WebElement acceptChanges() {
		return waitForExpectedElement(By.xpath("//input[@value='Accept Changes']"));
	}

	public boolean isDocumentPageWithErrorPresents() {
		return comMethods.waitForElementToBeVisible(By.xpath("//*[text()='" + ERROR + "']"), 10000).isDisplayed() && getCurrentUrl().contains("uploadPDF");
	}

	public boolean isDocumentPageWithUploadNotCorrectTypeErrorPresents() {
		return comMethods.waitForElementToBeVisible(By.xpath("//*[text()='" + TYPE_ERROR + "']"), 10000).isDisplayed() && getCurrentUrl().contains("uploadPDF");
	}
}