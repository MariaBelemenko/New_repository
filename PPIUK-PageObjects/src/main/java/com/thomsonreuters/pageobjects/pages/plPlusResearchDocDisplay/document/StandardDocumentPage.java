package com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document;

import com.thomsonreuters.pageobjects.common.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;

public class StandardDocumentPage extends DocumentDisplayAbstractPage {

    private static final String DRAFT_MESSAGE_FOR_OPEN_WEB = "Answer a series of questions upfront and create a first draft in half the time with our free drafting tool.";
    private static final String DRAFT_MESSAGE_FOR_PA = "Answer a series of questions and create a first draft in half the time with our free drafting tool.";
    private static final String DRAFT_MESSAGE_FOR_IP = "Answer a series of questions upfront and create a first draft in half the time with our free drafting tool. You will need an individual username and password to access this tool.";
    private static final String LEARN_MORE_BUTTON_LOCATOR = "//button[@id='co_fastdraft_learnmore' and text()='Learn more']";

    private CommonMethods comMethods = new CommonMethods();

    public enum ResourceType {
        PRACTICE_NOTES("Practice notes");

        private String name;

        ResourceType(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public void checkDocumentHasFastDratLogo(String documentName) {
        WebElement logo = null;
        try {
            logo = findElement(By.xpath("(//a[text()='" + documentName
                    + "']/ancestor::li)[last()]//img[contains(@src,'Id36da025850e11e38578f7ccc38dcbee')]"));
            logo.isDisplayed();
        } catch (NoSuchElementException e) {
            LOG.info("context", e);
            throw new RuntimeException("The document '" + documentName + "' has no Fast Draft logo");
        }
    }

    public void checkStartDraftingButtonPresents() {
        WebElement button = null;
        try {
            button = comMethods.waitForElementToBeVisible(
                    By.xpath("//*[text()='Start drafting' or @id='fastdraft_message_go']"), 10000);
            button.isDisplayed();
        } catch (NullPointerException e) {
            LOG.info("context", e);
            throw new RuntimeException("Start Drafting button absents");
        }
    }

    public WebElement startDraftingButton() {
        return waitForExpectedElement(By.xpath("//*[@id='co_fastdraft_startdrafting' and text()='Start drafting']"));
    }

    public boolean isFirmStyleButtonPresent() {
        WebElement button = null;
        try {
            button = findElement(By.id("co_docToolbarDownloadInFirmStyle"));
            button.isDisplayed();
        } catch (NoSuchElementException e) {
            LOG.info("context", e);
            return false;
        }
        return true;
    }

    public WebElement firmStyle() {
        return waitForExpectedElement(By.id("co_docToolbarDownloadInFirmStyle"));
    }

    public void checkDownloadboxAppiars() {
        WebElement popup = null;
        try {
            popup = findElement(By.xpath("//*[text()='Preparing For Download']"));
            popup.isDisplayed();
        } catch (NoSuchElementException e) {
            LOG.info("context", e);
            throw new RuntimeException("Preparing For Download absents");
        }
    }

    public void checkLearnMoreButtonPresents() {
        WebElement button = null;
        try {
            button = findElement(By.xpath(LEARN_MORE_BUTTON_LOCATOR));
            button.isDisplayed();
        } catch (NoSuchElementException e) {
            LOG.info("context", e);
            throw new RuntimeException("Learn more button absents");
        }
    }

    public WebElement learnMoreButton() {
        return waitForExpectedElement(By.xpath(LEARN_MORE_BUTTON_LOCATOR));
    }

    public void checkDraftMessagePresents() {
        WebElement draftMessage = null;
        try {
            draftMessage = findElement(By.xpath("//div[@class='pluk-document-fastdraft-body' and contains(.,'" + DRAFT_MESSAGE_FOR_OPEN_WEB + "') "
                    + "and contains(.,'Draft document')]" + LEARN_MORE_BUTTON_LOCATOR));
            draftMessage.isDisplayed();
        } catch (NoSuchElementException e) {
            LOG.info("context", e);
            throw new RuntimeException("Draft message absents");
        }
    }

    public void checkDraftMessageForIPUsersPresents() {
        WebElement draftMessage = null;
        try {
            draftMessage = findElement(By.xpath("//div[@class='pluk-document-fastdraft-body' and " + "contains(.,'" + DRAFT_MESSAGE_FOR_IP
                    + "') and contains(.,'Draft document')]"));
            draftMessage.isDisplayed();
        } catch (NoSuchElementException e) {
            LOG.info("context", e);
            throw new RuntimeException("Draft message absents");
        }
    }

    public void checkLoginAsSingleUserButtonPresents() {
        WebElement button = null;
        try {
            button = comMethods.waitForElementToBeVisible(By.xpath("//button[@id='co_fastdraft_login' and text()='Log in as single user']"), 10000);
            button.isDisplayed();
        } catch (NullPointerException e) {
            LOG.info("context", e);
            throw new RuntimeException("Login as single user button absents");
        }
    }

    public WebElement loginAsSingleUserButton() {
        return waitForExpectedElement(By.xpath("//button[@id='co_fastdraft_login' and text()='Log in as single user']"));
    }

    public void checkDraftMessageForPAPresents() {
        WebElement draftMessage = null;
        try {
            draftMessage = findElement(By.xpath("//div[@class='pluk-document-fastdraft-body' and contains(.,'" + DRAFT_MESSAGE_FOR_PA
                    + "') and contains(.,'Draft document')]"));
            draftMessage.isDisplayed();
        } catch (NoSuchElementException e) {
            LOG.info("context", e);
            throw new RuntimeException("Draft message absents");
        }
        String learnMoreLink = "/About/PracticalLawTools";
        waitForExpectedElement(By.xpath("//a[@id='co_fastdraft_learnmore' and contains(@href,'" + learnMoreLink + "')]"));
    }

    public void clickOnViewDocumentButton() {
        try {
            WebElement viewDocumentButton = findElement(By.id("co_WarnViewOkButton"));
            viewDocumentButton.click();
        } catch (NoSuchElementException ex) {
            LOG.info("context", ex);
        }
    }

    public void checkRedirectingToFastDraftPopupPresents() throws AWTException {
        //Cancel request button will appear after 10 secs
        try {
            Thread.sleep(12000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        stopBrowserExecution();
        WebElement popup = null;
        try {
            popup = findElement(By
                    .xpath("//div[@aria-label='Redirecting to FastDraft...']//a[@id='co_fastdraftCloseLink']"));
            popup.isDisplayed();
        } catch (NoSuchElementException e) {
            throw new RuntimeException("Redirecting to FastDraft popup absents");
        }
        LOG.info("Redirecting to FastDraft popup presents");
    }

    private void stopBrowserExecution() throws AWTException {
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ESCAPE);
        robot.keyRelease(KeyEvent.VK_ESCAPE);
    }

    public void checkCancelRequestButtonPresents() {
        WebElement cancelRequestButton = null;
        try {
            cancelRequestButton = findElement(By
                    .xpath("//div[@aria-label='Redirecting to FastDraft...']//input[@id='co_fastdraftCancelButton']"));
            cancelRequestButton.isDisplayed();
        } catch (NoSuchElementException e) {
            LOG.info("context", e);
            throw new RuntimeException("Cancel Request button absents");
        }
    }

    public WebElement cancelRequestButton() {
        return waitForExpectedElement(
                By.xpath("//div[@aria-label='Redirecting to FastDraft...']//input[@id='co_fastdraftCancelButton']"));
    }

    public void checkRedirectingToFastDraftPopupAbsents() {
        WebElement popup = null;
        try {
            popup = findElement(By
                    .xpath("//div[@aria-label='Redirecting to FastDraft...']//a[@id='co_fastdraftCloseLink']"));
            popup.isDisplayed();
        } catch (NoSuchElementException e) {
            LOG.info("Redirecting to FastDraft popup absents");
            return;
        }
        throw new RuntimeException("Redirecting to FastDraft popup presents");
    }

    public WebElement closeRedirectingToFastDraftPopup() {
        return waitForExpectedElement(
                By.xpath("//div[@aria-label='Redirecting to FastDraft...']//a[@id='co_fastdraftCloseLink']"));
    }

    public WebElement downloadFSFile(String linkName) {
        return waitForExpectedElement(By.xpath("//a[@href='" + linkName + "']"));
    }

    public WebElement homePage() {
        return waitForExpectedElement(By.xpath("//a[@href='/Search/Home.html']"));
    }

    public WebElement getDocumentSummary() {
        return waitForExpectedElement(By.className("kh_abstract"));
    }

    public WebElement getFullDocumentBody() {
        return waitForExpectedElement(By.id("co_docContentBody"));
    }

    public WebElement getResourceId() {
        return waitForExpectedElement(By.className("co_documentId"));
    }

    public WebElement getCopyright() {
        return waitForExpectedElement(By.className("co_endOfDocCopyright"));
    }

    public WebElement getLinkInRelatedContent(String title) {
        return waitForExpectedElement(By.xpath(".//div[@id='co_relatedContent']//li[not(contains(@class,'ng-hide'))]/a[contains(text(), '"
                + title + "')]"));
    }

    public WebElement getStatusForLinkInRelatedContent(String title) {
        WebElement link = getLinkInRelatedContent(title);
        return link.findElement(By.xpath("../span[@class='ng-binding']"));
    }

    public WebElement headerOnTheDocument(String header) {
		return waitForExpectedElement(By.xpath("//*[@id='co_document']//*[contains(text(), '" + header + "')]"));
	}
    
    /**
     * Check if resource type of current opened document is equals to expected
     *
     * @param resourceType Resource type of opened document
     * @return True - if check passed, otherwise - false.
     * @see ResourceType
     */
    public boolean isResourceTypeEquals(ResourceType resourceType) {
        return waitForElementVisible(By.cssSelector(".co_documentType>span")).getText().equals(resourceType.getName());
    }

    /**
     * Check if title of current opened document is equals to expected
     *
     * @param expectedTitle Expected document title
     * @return True - if check passed, otherwise - false.
     */
    public boolean isDocumentTitleEquals(String expectedTitle) {
        return waitForElementVisible(By.cssSelector(".co_title")).getText().equals(expectedTitle);
    }

    /**
     * Is user see resource history (is he was scrolled to it after click to "View Resource History" link for example)
     *
     * @return True, if user see resource history, otherwise - false.
     */
    public boolean isResourceHistoryDisplayed() {
        return waitForViewScrollingToElement(By.id("co_EodHistory"));
    }

    /**
     * Check if appropriate section displayed now for user
     *
     * @param sectionName Section name (headline)
     * @return True - if check passed, otherwise - false.
     */
    public boolean isDocumentSectionDisplayed(String sectionName) {
        return waitForViewScrollingToElement(By.xpath("//*[@class='co_headtext' and contains(., '" + sectionName + "')]"));
    }

    /**
     * Click on right-hand-side block link
     *
     * @param linkText Link text
     */
    public void clickOnRhsLink(String linkText) {
        waitForExpectedElement(By.xpath("//div[@id='co_docContentMetaInfo']//a[contains(., '" + linkText + "')]")).click();
    }

    /**
     * Click "View All" link in Resource History section at bottom of the page
     */
    public void clickViewAllResourceHistory() {
        waitForExpectedElement(By.id("co_docContentResourceHistoryAllButton")).click();
    }

    /**
     * Click on the link in Resource History section at bottom of the page
     *
     * @param linkText Link text
     */
    public void clickResourceHistoryLink(String linkText) {
        waitForExpectedElement(By.xpath("//div[@id='co_endOfDocument']//a[contains(., '" + linkText + "')]")).click();
    }

    /**
     * Click jn link in table of contents
     *
     * @param linkName Link name
     * @return Element with link from table of contents
     */
    public WebElement getLinkInTableOfContents(String linkName) {
        return waitForExpectedElement(By.xpath("//div[@class='kh_toc-content']//a[contains(., '" + linkName + "')]"));
    }

    /**
     * Get link from section of document
     *
     * @param sectionName Name of section which contains necessary link. Can be empty if there is not important where
     *                    link should be (in what section of document)
     * @param linkName    Link name in section
     * @return Element with link in section
     */
    public WebElement getLinkFromSection(String sectionName, String linkName) {
        return waitForExpectedElement(
                By.xpath("//div[@id='co_document']//div[.//*[@class='co_headtext' and contains(., '" +
                        sectionName + "')]]//a[contains(., '" + linkName + "')]")
        );
    }

    /**
     * Get elements with products inside metadata block
     *
     * @return Elements with product names
     */
    public List<WebElement> getProductsFromMetadata() {
        return waitForExpectedElements(By.cssSelector(".co_practiceAreaName li"));
    }

    /**
     * Check if document contains any section
     *
     * @return True -  if at least one section exists. Otherwise - false
     */
    public boolean isContainsSection() {
        return isExists(By.cssSelector("#co_docContentBody .co_headtext"));
    }

}