package com.epam.TestNG.pageFactory.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Mariya_Belemenko on 6/23/2016.
 */
public class PageObject {
    private WebDriver driver;

    @FindBy(id = "lst-ib")
    private WebElement searchField;

    @FindBy(xpath = "//input[@type = 'submit']")
    private WebElement submitButton;

    public PageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Edit search
    public void editSearch(String query) {
        searchField.sendKeys(query);
    }

    //Submit search
    public void submitSearch() {
        submitButton.click();
    }
}
