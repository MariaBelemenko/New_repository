package com.thomsonreuters.askRewrite.pages;


import com.thomsonreuters.driver.framework.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

public class PLCHomePageUK extends AbstractPage {

    public PLCHomePageUK() {
    }

    public WebElement loginLink() {
        return waitForExpectedElement(loginSelector());
    }

    public By loginSelector(){
        return By.linkText("Log in");
    }

    public WebElement loginLinkGlobal() {
        return waitFluentForElement(By.linkText("Login"));
    }

    public WebElement logoutLink() {
        return waitForExpectedElement(By.linkText("Log out"));
    }

    public WebElement differentUserLink() {
        return waitForExpectedElement(By.partialLinkText("in as a different user"));
    }

    public WebElement countriesLink() {
        return waitForExpectedElement(By.className("current"));
    }

    public WebElement generalPreferencesLink() {
        return findElement(By.linkText("View and edit general preferences"));
    }

    public WebElement keywordHighlightingOption() {
        return waitForExpectedElement(By.id("keywordHiglight"));
    }

    public WebElement keywordFinderWindow() {
        return findElement(By.id("keyword_finder_caption"));
    }

    public boolean isKeywordFinderPanelOpened() {
        if (isElementPresent(By.cssSelector("div[id='keyword_finder'][class='keyword_finder_results'] "))) {
            return true;
        } else {
            return false;
        }
    }

    public WebElement keywordFinderField() {
        return findElement(By.id("keywordFinderField"));
    }

    public WebElement keywordFinderSearchButton() {
        return findElement(By.id("search_button"));
    }

    public int noOfHighlightedKeywordsInKeywordFinderResults(String keyword) {
        return waitForExpectedElements(By.xpath("//div[@id='keyword_finder_results']//div//span[contains(text(),'" + keyword + "')]")).size();
    }

    public WebElement keywordFinderResults() {
        return waitForElementPresent(By.id("noOfResults"));
    }

    public WebElement generalPreferencesSaveBtn() {
        return findElement(By.xpath("//button[@class='submit']"));
    }

    public WebElement viewPreferencesPageLink(String viewPageLink) {
        return findElement(By.xpath("//div[@id='main']//a[contains(text(),'" + viewPageLink + "')]"));
    }

    public WebElement preferencesPageTitle() {
        return waitForExpectedElement(By.xpath("//div[@id='main']//h1"));
    }

    public WebElement emailPreferencesLink() {
        return findElement(By.linkText("View and edit e-mail preferences"));
    }

    public WebElement myUpdatesPreferencesLink() {
        return findElement(By.linkText("View and edit My Updates preferences"));
    }

    public WebElement accountSubscriptionsLink() {
        return findElement(By.linkText("View account subscriptions"));
    }

    public WebElement userDetailsLink() {
        return findElement(By.linkText("View and edit personal details"));
    }

    public WebElement needHelpLink() {
        return findElement(By.linkText("View help and training"));
    }

    public WebElement myUpdatesLink() {
        return findElement(By.linkText("My Updates"));
    }

    public WebElement fastDraftLink() {
        return findElement(By.linkText("Fastdraft"));
    }

    public WebElement annotationsLink() {
        return findElement(By.linkText("Annotations"));
    }

    public WebElement pageLogo() {
        // Firefox has trouble clicking the logo so beware!
        return waitForExpectedElement(By.id("global_logo"));
    }

    public WebElement CountiresMegamenuLink() {
        return waitForExpectedElement(By.linkText("Countries"));
    }

    public WebElement allCountriesMegamenu() {
        return waitForExpectedElement(By.xpath("//div[@id='globalmegamenu_menusContainer']/div[@class='menu']"));
    }

    public WebElement myPracticalLaw() {
        return findElement(By.linkText("My Practical Law"));
    }

    public WebElement askAQuestionButton() {
        return waitForExpectedElement(By.xpath("//span[text()='Ask a question']"));
    }

    public WebElement resourcesTab() {
        return waitForExpectedElement(By.xpath("//span[text()='Resources']"));
    }

    public WebElement askLink() {
        return waitForExpectedElement(By.linkText("Ask"));
    }

}