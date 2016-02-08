package com.thomsonreuters.pageobjects.pages.fastDraft;

import com.thomsonreuters.driver.framework.AbstractPage;
import com.thomsonreuters.pageobjects.common.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DraftViewPage extends AbstractPage {

    private CommonMethods comMethods = new CommonMethods();

    public void checkFieldHasValue(String field, String value) {
        comMethods.waitForElementToBeVisible(By.xpath("//a[contains(.,(" + field + ")) and text()='" + value + "']"), 10000);
    }

    public WebElement wordDocument() {
        return comMethods.waitForElementToBeVisible(By.xpath("//a[text()=' Word document']"), 10000);
    }

    public WebElement export() {
        return comMethods.waitForElementToBeVisible(By.xpath("//*[text()=' Export ']"), 10000);
    }

    public WebElement exportEditablePDF() {
        return waitForExpectedElement(By.xpath("//a[text()='Export as editable form (PDF)']"));
    }

    public WebElement exportPrintablePDF() {
        return waitForExpectedElement(By.xpath("//a[text()='Export as printable form (PDF)']"));
    }

}
