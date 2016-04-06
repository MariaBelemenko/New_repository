package com.thomsonreuters.pageobjects.pages.researchBrowse;

import com.thomsonreuters.pageobjects.utils.researchBrowse.ResearchContentTypeEnum;
import com.thomsonreuters.driver.framework.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;



public class RBCommonPage extends AbstractPage {

    // Search
    public WebElement activeSearchTab() {
        return findElement(By.cssSelector("#coid_website_searchWidget li.co_tabActive a"));
    }

    public WebElement pageHeading() {
        return waitAndFindElement(By.id("co_browsePageLabel"));
    }

    public WebElement contentTypeLink(ResearchContentTypeEnum contentType) {
        return waitAndFindElement(By.linkText(contentType.getLinkText()));
    }

    public WebElement practiceAreaLink(String practiceArea) {
        return waitForExpectedElement(By.linkText(practiceArea),10);
    }

    public WebElement searchResultHeading() {
        return waitAndFindElement(By.cssSelector("div.co_search_result_heading_content h1"));
    }

    // Static Text and Marketing Pages
    public WebElement description() {
        return waitAndFindElement(By.cssSelector("div.co_searchResults_summary"));
    }

    public WebElement findOutMoreLink() {
        return waitAndFindElement(By.linkText("Find out more"));
    }

    public WebElement waitForPageHeadingText(String text) {
        return waitAndFindElement(By.xpath("//h1[@id='co_browsePageLabel'][text()=\"" + text + "\"]"));
    }


    public WebElement waitForMarketingPageHeadingText() {
        return waitAndFindElement(By.xpath("//h3[text()=\"This is a marketing page\"]"));
    }

}
