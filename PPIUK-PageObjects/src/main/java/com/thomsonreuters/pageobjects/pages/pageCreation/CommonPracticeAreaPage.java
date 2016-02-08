package com.thomsonreuters.pageobjects.pages.pageCreation;

import com.thomsonreuters.driver.framework.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CommonPracticeAreaPage extends AbstractPage {

    public WebElement addTpFavoritesButton() {
        return waitForExpectedElement(By.id("coid_website_browsePageAddToFavorites"));
    }

    public WebElement backToHomepageButton() {
        return findElement(By.id("coid_website_browsePageSelectAsHomepage"));
    }

    public WebElement askTab() {
        return waitForExpectedElement(By.linkText("Ask"));
    }

}