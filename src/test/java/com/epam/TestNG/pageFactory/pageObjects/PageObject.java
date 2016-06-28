package com.epam.TestNG.pageFactory.pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Mariya_Belemenko on 6/23/2016.
 */
public class PageObject {

    @FindBy(id = "lst-ib")
    private WebElement searchField;

    @FindBy(xpath = "//input[@type = 'submit']")
    private WebElement submitButton;

    private static final Logger LOG = LogManager.getLogger(PageObject.class.getName());

    private WebDriver driver;

    public PageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Edit search
    public void editSearch(String query) {
        searchField.sendKeys(query);
        LOG.info("The query has been input");
    }

    //Submit search
    public void submitSearch() {
        submitButton.click();
        LOG.info("The submit button has been clicked");
    }
}
