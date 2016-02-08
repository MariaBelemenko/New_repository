package com.thomsonreuters.pageobjects.pages.landingPage;

import com.thomsonreuters.driver.framework.AbstractPage;
import com.thomsonreuters.pageobjects.common.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * This is the page that the user arrives at after
 * clicking on the link to Practical Law - UK. It is a category page for the uk search project and is
 * equivalent to the main practical law search page in the uk
 * a link from demo site to existing UK site in order to enable checking of product information in resource details - not something
 * that is currently possible on the demo site - hence the link to the UK site for equivalent search results
 * This page will also represent the US and global category pages - ie the pages displayed after the user has clicked US Know How or Global Know How instead
 * of Practical Law - UK - will also represent the pages encountered for subject areas after a user has selected a particular practice area link
 */
public class PracticalLawUKCategoryPage extends AbstractPage {

    private CommonMethods commonMethods = new CommonMethods();

    public PracticalLawUKCategoryPage() {
    }

    public WebElement freeTextField() {
        return retryingFindElement(By.id("searchInputId"));
    }

    public WebElement searchButton() {
        return waitForExpectedElement(By.id("searchButton"), 10);
    }

    /**
     * looks like this one has disappeared as at 16/12/14
     */
    public void resultsPerPageDropdown(String resultPerPage) {
        waitFluentForElement(By.id("selectedDisplayItemCount")).click();
        waitForElementsVisible(By.cssSelector("#displayItemCount .co_dropDownMenuList"));
        waitFluentForElement(By.linkText(resultPerPage)).click();
    }

    /**
     * this is the replacement option to select the number of results per page
     */
    public WebElement select50ResultsPerPage() {
        return waitForExpectedElement(By.xpath("//div[@id='co_search_footerToolbar']/div/div[2]/p/span[2][text()='50']"));
    }

    public WebElement select20ResultsPerPage() {
        return waitForExpectedElement(By.xpath("//div[@id='co_search_footerToolbar']/div/div[2]/p/span[text()='20']"));
    }

    public WebElement select100ResultsPerPage() {
        return waitForExpectedElement(By.xpath("//div[@id='co_search_footerToolbar']/div/div[2]/p/span[3][text()='100']"));
    }

    /**
     * method for selecting a suggested term listed below the free text search field
     */
    public WebElement suggestedTerm(String text) {
        return waitForExpectedElement(By.xpath("//ul[@id='co_searchSuggestion']/li[text()='" + text + "']"));
    }

    /**
     * method for selecting a suggested term listed below the free text search field
     */
    public void mouseOverOnSuggestedSearchResult(String text) {
        commonMethods.mouseOver(waitFluentForElement(By.xpath("//*[@id='co_searchSuggestion']/li[text()='" + text + "']")));
    }

    /**
     * method for selecting a practice area link from the homepage
     */
    public WebElement practiceAreaLink(String name) {
        return waitForExpectedElement(By.partialLinkText(name));
    }

    /**
     * method for selecting a topic (subject) link from the practice area page
     */
    public WebElement topicAreaLink(String name) {
        return waitForExpectedElement(By.partialLinkText(name));
    }

    /**
     * method for selecting a resource link from the resources page
     */
    public WebElement resourceLink(String name) {
        return waitForExpectedElement(By.partialLinkText(name));
    }

    /**
     * Returning By element for selecting a suggested term listed below the free text search field
     */
    public By suggestedByTerm(String text) {
        return By.xpath("//ul[@id='co_searchSuggestion']/li[text()='" + text + "']");
    }

}