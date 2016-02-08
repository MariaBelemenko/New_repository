package com.thomsonreuters.pageobjects.pages.landingPage;

import com.thomsonreuters.driver.framework.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ResourcesPage extends AbstractPage {

    public ResourcesPage() {
    }

    public WebElement plcMagazineLink() {
        return waitForExpectedElement(By.linkText("PLC Magazine"));
    }

    public WebElement glossaryLink() {
        return waitForExpectedElement(By.linkText("Glossary"));
    }

    public WebElement whatsMarketLink(String title) {
        String text = "'" + title + "'";
        if (title.contains("'")) {
            title = "\"" + title + "\"";
            text = title;
        }
        return waitForExpectedElement(By.xpath("//div[@id='coid_website_browseMainColumn']//div[@class='co_scrollWrapper co_categoryBoxTabContents']//a[contains(text()," + title + ")]"));
    }

    public WebElement emailArchiveLink() {
        return waitForExpectedElement(By.linkText("Email archive"));
    }

}
