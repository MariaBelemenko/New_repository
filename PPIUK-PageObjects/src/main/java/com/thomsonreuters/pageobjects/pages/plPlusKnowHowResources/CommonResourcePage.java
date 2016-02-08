package com.thomsonreuters.pageobjects.pages.plPlusKnowHowResources;

import com.thomsonreuters.driver.framework.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import java.util.List;

/**
 * This class will contain the pageobjects objects for KH and ASK resources
 */

public class CommonResourcePage extends AbstractPage {

    public WebElement title() {
        return waitForExpectedElement(By.cssSelector("#co_docHeaderContainer .co_title"));
    }

    public WebElement author() {
        return findElement(By.cssSelector("#co_docHeaderContainer .co_productname"));
    }

    public WebElement contentBody() {
        return waitForElementPresent(By.id("co_docContentBody"));
    }

    public List<WebElement> allHeadings() {
        return contentBody().findElements(By.className("co_headtext"));
    }


    // Sticky Bar
    public WebElement titleOnStickyBar() {
        return waitForExpectedElement(By.cssSelector("#co_docContentHeader.is-sticky #co_docHeaderContainer .co_title"));
    }

    public WebElement subSectionHeadingOnStickyBar() {
        return waitForExpectedElement(By.cssSelector("#co_docContentHeader.is-sticky #co_docHeaderContainer .co_title .subSectionTitle"));
    }

    public WebElement relatedContentLinkOnStickyBar() {
        return waitForExpectedElement(By.className("co_relatedContentStickyLink")).findElement(By.linkText("Related Content"));
    }

    public WebElement relatedContentHeading() {
        return waitForExpectedElement(By.xpath("//div[@id='co_relatedContent']//h2[text()='Related Content']"));
    }

    public WebElement plcRef() {
        return waitForExpectedElement(By.cssSelector("#co_endOfDocument span.co_documentId>span"));
    }

    public WebElement askAQuestion() {
        return waitForExpectedElement(By.linkText("Ask a question"));
    }
}
