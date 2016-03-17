package com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.documentNavigation;

import com.thomsonreuters.pageobjects.common.CommonMethods;
import com.thomsonreuters.driver.exception.PageOperationException;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.slf4j.LoggerFactory;


import org.springframework.util.StringUtils;

import java.util.List;

/**
 * This page object is to identify the Document Delivery elements and depicts the document delivery functionality.
 * <p/>
 */

public class DocumentDeliveryPage extends DocumentNavigationPage {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(DocumentDeliveryPage.class);

    public static final By ADD_TO_FOLDER_LOCATOR = By.cssSelector("a[title='Add To Folder']");

    private static final By EMAIL_ICON = By.id("co_docToolbarDeliveryWidgetEmail");
    private static final By PRINT_ICON = By.id("co_docToolbarDeliveryWidgetPrint");
    private static final By ADD_TO_FOLDER_ICON = By.id("co_docToolbarSaveToWidget");
    private static final By DONWLOAD_ICON = By.id("co_docToolbarDeliveryWidgetDownload");

    private static final By DOCUMENT_DELIVERY_ICONS = By.xpath("//ul[@id='co_docToolbarVerticalMenuRight']/li");

    private CommonMethods commonMethods;

    public DocumentDeliveryPage(){
        commonMethods = new CommonMethods();
    }

    public enum Links {
        NEW_ANNOTATION(By.cssSelector(".kh_icon.icon-add-note"),"New Annotation..."),
        SHOW_HIDE_ANNOTATIONS(By.cssSelector(".kh_icon.icon-notes"),"Show Annotation/Hide Annotation");
        private By locator;
        private String toolTipText;

        private Links(By locator, String toolTipText) {
            this.locator = locator;
            this.toolTipText = toolTipText;
        }

        public By getLocator() {
            return this.locator;
        }

        public String getToolTipText() {
            return this.toolTipText;
        }
    }

    /**
     * This method is used to verify the AddToFolder link is present in Document Delivery and retursn the boolean value accordingly.
     *
     * @return boolean
     */
    public boolean isAddToFolderLinkPresent() {
        try {
            return getAddToFolderLink().isDisplayed();
        } catch (PageOperationException pe) {
            LOG.info("context", pe);
        }
        return false;
    }

    /**
     * This method does the selecting the Add To Folder link
     */
    public void clickOnAddToFolderLink() {
        // Check the folder icon is displayed then click it
        String XPath = "//*[@id='co_docToolbarVerticalMenuRight']//*[@class='co_saveTo']//a";
        // Scroll right
        getDriver.executeScript("window.scrollBy(100, 0)","");
        waitForExpectedElement(By.xpath(XPath)).click();
    }

    /**
     * This does the finding of Add to folder link element and returns the same element.
     *
     * @return WebElement
     */
    private WebElement getAddToFolderLink() {
        try {
            return waitForExpectedElement(ADD_TO_FOLDER_LOCATOR,10);
        } catch (TimeoutException pe) {
            LOG.info("context", pe);
            throw new PageOperationException("Exceeded Time to find the Add To Folder link.");
        }
    }

    /**
     * This is to find out the links presence on delivery toolbar.
     *
     * @param links
     * @return boolean
     */
    public boolean isLinkPresent(Links links){
        try {
            waitForPageToLoad();
            waitForPageToLoadAndJQueryProcessing();
            return retryingFindElement(links.getLocator()).isDisplayed();
        } catch (PageOperationException pe) {
        }
        return false;
    }

    /**
     * This is to find out the links clickable or not on delivery toolbar.
     *
     * @param links
     * @return boolean
     */
    public boolean isLinkClickable(Links links){
        try {
            waitForElementsClickable(links.getLocator());
            return true;
        } catch (TimeoutException pe) {
        }
        return false;
    }

    public void mouseOverOnLink(Links link) {
        commonMethods.mouseOver(waitForExpectedElement(link.getLocator()));
    }

    public boolean isToolTipDisplayed(Links link){
        try{
            String[] toolTips = link.getToolTipText().split("/");
            String tooltip1 = toolTips[0];
            String tooltip2 = null;
            if(toolTips.length>1){
                tooltip2 = toolTips[1];
            }
            String actualTip = getTootlTipText();
            return (actualTip.equals(tooltip1) || ((!StringUtils.isEmpty(tooltip2)) && actualTip.equals(tooltip2))) ;
        }catch(Exception te){
            return false;
        }
    }

    public String getTootlTipText() {
        return waitAndFindElement(By.className("tooltip-content")).getText();
    }

    public void clickOnLink(Links link) {
        try{
            retryingFindElement(link.getLocator()).click();
        }catch(PageOperationException te){
            throw new PageOperationException("Exceeded time to click on the link : "+link);
        }
    }

    public List<WebElement> deliveryIcons() {
        return waitForExpectedElements(DOCUMENT_DELIVERY_ICONS);
    }

    public WebElement printIcon() {
        return waitForExpectedElement(PRINT_ICON);
    }

    public WebElement emailIcon() {
        return waitForExpectedElement(EMAIL_ICON);
    }

    public WebElement addToFolderIcon() {
        return waitForExpectedElement(ADD_TO_FOLDER_ICON);
    }

    public WebElement downloadIcon() {
        return waitForExpectedElement(DONWLOAD_ICON);
    }

    /**
     * Get website request id for file download request
     * IMPORTANT: Use only when download options window is present
     * @return Request id or empty string if any errors occurred
     */
    public String getWebsiteRequestId() {
        try {
            return waitForElementExists(By.id("websiteRequestId")).getAttribute("value");
        } catch (NoSuchElementException | TimeoutException e) {
            LOG.warn("Unable to get website request id", e);
            return "";
        }
    }
}