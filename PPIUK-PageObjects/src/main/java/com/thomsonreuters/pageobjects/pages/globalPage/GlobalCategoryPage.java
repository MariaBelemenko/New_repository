package com.thomsonreuters.pageobjects.pages.globalPage;

import com.thomsonreuters.driver.framework.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GlobalCategoryPage extends AbstractPage {

    public List<WebElement> header() {
        return findElements(By.id("header"));
    }

    public List<WebElement> globalPageHeader() {
        return findElements(By.id("co_pageHeader"));
    }

    public List<WebElement> globalPageBody() {
        return findElements(By.id("co_body"));
    }

    public List<WebElement> globalPageFooter() {
        return findElements(By.id("co_footerContainer"));
    }

    public WebElement countryInCoutriesTab(String country) {
        return retryingFindElement(By.xpath(".//div[@id='coid_categoryBoxTabPanel2']//a[contains(text(), '" + country
                + "')]"));
    }

    public List<WebElement> jurisdictionsInTheLeftHandSide() {
        return findElements(By.xpath(".//h4[contains(text(), 'Jurisdiction')]/following-sibling::ul//label"));
    }

    public List<WebElement> jurisdictionsInTheReturnedSearchResults() {
        return findElements(By.xpath(".//strong[contains(text(), 'Jurisdiction')]/.."));
    }

    public List<WebElement> resourceTypes() {
        return findElements(By.xpath(".//strong[contains(text(), 'Document Type')]/.."));
    }

    public List<WebElement> returnedSearchResults() {
        return findElements(By.xpath(".//ol[@class='co_searchResult_list']//div[@class='co_searchContent']"));
    }

    public WebElement checkBox(String facetGroup, String facetName) {
        return retryingFindElement(By.xpath(".//h4[contains(text(), '" + facetGroup
                + "')]/following-sibling::ul//label[contains(text(), '" + facetName + "')]"));
    }

    public WebElement linkInSection(String linkText, String section) {
        return retryingFindElement(By.xpath("//h3[contains(., '" + section
                + "')]/following-sibling::div//a[contains(.,'" + linkText + "')]"));
    }

    public WebElement linkInInterSubscriptionsSectionInBrowseMenu(String linkText, String sectionName) {
        return retryingFindElement(By.xpath(".//div[contains(@class, 'column') and .//*[contains(., '" + sectionName
                + "')]]//a[contains(., '" + linkText + "')]"));
    }

    public List<WebElement> theFollowingItemsForTheFirstSixInTheSSDD() {
        return findElements(By.xpath(".//li[@class='co_separator'][2]/following-sibling::li//a"));
    }

    public List<WebElement> fullListOfContriesInTheSSDD() {
        return findElements(By.xpath(".//a[contains(text(), 'All Global Content')]/../following-sibling::li//a"));
    }

    public WebElement moreJurisdiction() {
        return retryingFindElement(By.linkText("More Jurisdictions"));
    }

    public WebElement continueButton() {
        return retryingFindElement(By.xpath(".//*[contains(@id, 'JurisdictionSummary_continueButton')]"));
    }

    public WebElement linksHeader(String header) {
        return retryingFindElement(By.xpath(".//*[contains(text(), '" + header + "')]"));
    }

    public List<WebElement> countriesTabLinks() {
        return findElements(By.xpath("//div[contains(@id, 'coid_categoryBoxTab2SubPanel')]//a"));
    }

    public List<WebElement> globalGuides() {
        return findElements(By.xpath("//div[contains(@id, 'coid_categoryBoxTab3SubPanel')]//a"));
    }

    public WebElement linkOnLegalUpdateWidget(int linkNumber, String widget) {
        return retryingFindElement(By.xpath(".//h3[contains(text(), '" + widget
                + "')]/following-sibling::div[@class='co_genericBoxContent']//li[" + linkNumber + "]//a"));
    }

}
