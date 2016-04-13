package com.thomsonreuters.pageobjects.pages.landingPage;

import com.thomsonreuters.pageobjects.common.CommonMethods;
import com.thomsonreuters.driver.exception.PageOperationException;
import com.thomsonreuters.driver.framework.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;

public class PracticalLawHomepage extends AbstractPage {

    private CommonMethods comMethods;

    public PracticalLawHomepage() {

        comMethods = new CommonMethods();
    }

    public WebElement signOnButton() {
        return waitForExpectedElement(By.id("coid_website_signOffRegion"));
    }

    public WebElement signOffButton() {
        return waitForExpectedElement(By.id("coid_website_signOffRegion"));
    }

    public WebElement unitedKingdomContentLink() {
        return waitForExpectedElement(By.linkText("United Kingdom"));
    }

    public WebElement practiceAreaLink(String practiceArea) {
        return waitForExpectedElement(By.xpath("//div[@id='coid_website_browseMainColumn']/div[2]//a[contains(text(),'" + practiceArea + "')]"));
    }

    public WebElement legalUpdatesContentLink() {
        return waitForExpectedElement(By.id("coid_legal_updates"));
    }

    public WebElement plcHeadingLabel() {
        return waitForExpectedElement(By.id("co_browsePageLabel"));
    }

    public WebElement browseWidget() {
        return waitForExpectedElement(By.id("co_browseWidget"));
    }

    public WebElement browseHeadingTitle() {
        return waitForExpectedElement(By.id("categoryPageScope"));
    }

    public WebElement researchBrowseHomeLink() {
        return waitForExpectedElement(By.linkText("RBHome"));
    }

    public WebElement practiceLink() {
        return waitForExpectedElement(By.linkText("Practice"));
    }

    public WebElement researchFoldersWidgetLink() {
        return waitForExpectedElement(By.xpath("//span[@id='co_dockTitle' and contains(text(), 'Research')]"));
    }

    public WebElement welcomeBox() {
        return comMethods.waitForElementToBeVisible(By.id("coid_lightboxOverlay"), 1000);
    }

    public WebElement timeoutPopUp(int waitForPopUptimeOutInSeconds) {
        return waitForExpectedElement(By.xpath("//div[@id='coid_lightboxOverlay']/div[@id='co_websiteTimeoutWarning']"), waitForPopUptimeOutInSeconds);
    }

    public WebElement continueSessionButton() {
        return waitForExpectedElement(By.xpath("//input[@type='button' and @value='Continue']"));
    }

    public boolean isTimeoutPopUpPresent(int waitForPopUptimeOutInSeconds) {
        try {
            return timeoutPopUp(waitForPopUptimeOutInSeconds).isDisplayed();
        } catch (TimeoutException | NoSuchElementException nse) {
            return false;
        }
    }

    public WebElement resourcesLink() {
        return waitForExpectedElement(By.partialLinkText("Resources"));
    }

    public WebElement internationalLink() {

        return waitForExpectedElement(By.partialLinkText("International"));
    }

    public void closeCookieConsentMessage(){
        try{
            retryingFindElement(By.xpath("//div[@id='CookieConsentMessage']//a[text()='Close']")).click();
        }catch(PageOperationException poe){
            LOG.info("context", poe.getMessage());
        }
    }

    public WebElement cookieConsentMessage(){
        return waitForExpectedElement(By.id("CookieConsentMessage"));
    }

    public WebElement cookieConsentLink(String link){
        return waitForExpectedElement(By.xpath("//div[@id='CookieConsentMessage']//a[text()='" + link + "']"));
    }

    public WebElement practicalLawTRLogo() {
        return waitForExpectedElement(By.xpath("//a[@id='logo'][@title='Practical Law Home']"),5);
    }



}
