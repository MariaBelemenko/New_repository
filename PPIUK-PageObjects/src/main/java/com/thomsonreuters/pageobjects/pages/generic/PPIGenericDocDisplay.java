package com.thomsonreuters.pageobjects.pages.generic;

import com.thomsonreuters.driver.framework.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import java.util.List;

/**
 * Created by uc087619 on 24/11/2015.
 */

public class PPIGenericDocDisplay extends AbstractPage {

    public List<WebElement> ppiTermNavigationHitMarkupCheckTermsAsList() {
        return waitForExpectedElements((By.xpath("//span[contains(@class,'searchTerm')]")));
    }

    public WebElement categoryTab() {
        return waitForExpectedElement((By.xpath("//ul[@class='co_tabs co_categoryTabs']")),30);
    }

    public WebElement searchPageLabel() {
        return waitForExpectedElement((By.xpath("//h1[@id='co_browsePageLabel']")),30);
    }

    public WebElement rightColumn() {
        return waitForExpectedElement((By.xpath("//div[@id='co_rightColumn']")),20);
    }


    public WebElement titleNoToc()  {
        return waitForExpectedElement( (By.xpath("//h1[@class='co_title noTOC']")),30);
    }

    public WebElement glossaryHeader() {
        return waitForExpectedElement((By.xpath("//div[@id='co_docHeaderContainer']")),30);
    }

    public WebElement plGlobalHeader () {
        return waitForExpectedElement((By.xpath("//h1")),30);
    }
}
