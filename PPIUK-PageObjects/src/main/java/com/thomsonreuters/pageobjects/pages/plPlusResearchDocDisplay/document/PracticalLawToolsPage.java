package com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document;

import com.thomsonreuters.driver.exception.PageOperationException;
import com.thomsonreuters.driver.framework.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PracticalLawToolsPage extends AbstractPage {

    public boolean isFastDraftTabActive() {
        WebElement tab = null;
        try {
            tab = retryingFindElement(By.xpath("//li[contains(@class,'co_tabActive')]//a[text()='Fastdraft']"));
            tab.isDisplayed();
        } catch (PageOperationException e) {
            LOG.error("Fast Draft tab is not active");
            return false;
        }
        return true;
    }

    public boolean isFirmStyleTabActive() {
        WebElement tab = null;
        try {
            tab = retryingFindElement(By.xpath("//li[contains(@class,'co_tabActive')]//a[text()='Firmstyle']"));
            tab.isDisplayed();
        } catch (PageOperationException e) {
            LOG.error("Firm Style tab is not active");
            return false;
        }
        return true;
    }

}