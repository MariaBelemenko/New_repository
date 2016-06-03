package com.thomsonreuters.pageobjects.pages.calendar;

import com.thomsonreuters.driver.exception.PageOperationException;
import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document.DocumentDisplayAbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;


public class KeyDateDocumentPage extends DocumentDisplayAbstractPage {



    public WebElement keyDateDocMetaData() {
        return findElement(By.id("co_docContentMetaInfo"));
    }

    public WebElement viewResourceHistoryLink() {
        return findElement(By.id("co_docContentMetaInfo")).findElement(By.linkText("View Resource History"));
    }

    //TODO: Change methodname
    private List<WebElement> jurisdictions() {
        return findElements(By.cssSelector("#co_docContentMetaInfoJurisdictions ul li"));
    }


    public WebElement jurisdictionViewAllLink() {
        return findElement(By.id("co_docContentMetaInfoJurisdictionsAllButton"));
    }

    public WebElement relatedContentLink() {
        return waitForExpectedElement(By.id("co_docContentMetaInfo")).findElement(By.linkText("Related Content"));
    }

    public boolean isViewAllLinkDisplayed() {
        return findElements(By.id("co_docContentMetaInfoJurisdictionsAllButton")).size() > 0;
    }

    public WebElement docEventDate() {
        return waitForElementVisible(By.id("co_eventDate"));
    }

    public WebElement metaDataDateIcon() {
        return waitForElementVisible(By.id("co_eventDateIconDay"));
    }

    public WebElement metaDataEventTypeHeading() {
        return waitForElementVisible(By.xpath("//div[@class='co_documentType']//b[normalize-space(.)='Event Type']"));
    }
    public WebElement metaDataEventTypeValue(String eventType) {
        return waitForElementVisible(By.xpath("//div[@class='co_documentType']//span[normalize-space(.)='"+eventType+"']"));
    }
    public WebElement metaDataResourceTypeHeading() {
        return waitForElementVisible(By.xpath("//div[@class='co_documentType']//b[normalize-space(.)='Resource Type']"));
    }

    public WebElement metaDataResourceTypeValue(String resourceType) {
        return waitForElementVisible(By.xpath("//div[@class='co_documentType']//span[normalize-space(.)='"+resourceType+"']"));
    }

    public WebElement metaDataJurisdictionHeading() {
        return waitForElementVisible(By.xpath("//div[@id='co_docContentMetaInfoJurisdictions']//b[normalize-space(.)='Jurisdiction']"));
    }
    public List<WebElement> metaDataJurisdictionValueList() {
        return waitForElementsVisible(By.xpath("//div[@id='co_docContentMetaInfoJurisdictions']//ul//li"));
    }

    public WebElement keyDateDocumentBody() {
        return waitForElementVisible(By.xpath("//div[@id='co_docContentBody']//div[@class='co_paragraph']"));
    }
    public List<WebElement> resourceLinkList() {
        return waitForElementsVisible(By.xpath("//div[@class='co_resourceLinks']//li/a[not(contains(@target,'_blank'))]"));
    }

}
