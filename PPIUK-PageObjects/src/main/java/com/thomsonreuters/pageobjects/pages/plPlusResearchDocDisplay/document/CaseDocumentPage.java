package com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document;

import com.thomsonreuters.driver.exception.PageOperationException;
import com.thomsonreuters.pageobjects.common.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.slf4j.LoggerFactory;

import java.util.Collections;

/**
 * This page object is to identify the Case Document elements and depicts the
 * page functionality.
 * <p/>
 */
public class CaseDocumentPage extends DocumentDisplayAbstractPage {

    private static final By DOCUMENT_CONTENT = By.className("co_DocContentAll");
    private static final By PDF_IMAGE = By.className("co_pdfIcon");
    private static final By LEFT_NAVIGATION_COLUMN = By.className("kh_toc-content");
    private static final By META_CONTENT = By.id("co_docContentMetaInfo");
    private static final By DELIVERY_OPTIONS = By.id("co_docToolbarVerticalMenuRight");
    private static final By DOCUMENT_IN_PDF = By.xpath(".//div[@id='co_docContentBody']//a[@type = 'application/pdf']");
    private static final By FOOTNOTE_SECTION = By.xpath(".//div[@id='co_footnoteSection']/h2");
    private static final By SHOW_AND_HIDE_LINK = By.id("co_ExpandCollapseLegislationAnnotationSection");
    private static final By ANNOTATIONS_SECTION = By.id("co_AnnotationDocumentSource");
    private static final By CONTENT_COLUMN = By.id("co_docContentBody");
    private static final By STATUS_ICON = By.xpath(".//div[@id='co_docContentMetaInfo']//img");
    private static final By STATUS_DESCRIPTION = By.xpath(".//div[@id='co_docContentMetaInfo']/div[@class='co_greenStatus']");
    private static final By PARTY_NAMES = By.xpath(".//div[@id='co_docHeaderContainer']/div[@class='co_paragraph']/h1");
    private static final By PARTY_NAMES_IN_CASELAW = By.className("co_title");
    private static final By ALIAS_PARTY_NAMES = By.xpath(".//*[@id='co_docHeaderContainer']//div/div[last()]");

    private CommonMethods commonMethods = new CommonMethods();

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(CaseDocumentPage.class);
    private By pdfDownloadLinkLocator = By.cssSelector("");

    public WebElement contentOfTheDocument() {
        return retryingFindElement(DOCUMENT_CONTENT);
    }

    public WebElement pdfImage() {
        return retryingFindElement(PDF_IMAGE);
    }

    public WebElement columnForTheLeftHandNavigation() {
        return retryingFindElement(LEFT_NAVIGATION_COLUMN);
    }

    public WebElement metaContent() {
        return retryingFindElement(META_CONTENT);
    }

    public WebElement deliveryOptions() {
        return retryingFindElement(DELIVERY_OPTIONS);
    }

    public WebElement documentInPdf() {
        return retryingFindElement(DOCUMENT_IN_PDF);
    }

    public WebElement footnoteSection() {
        return retryingFindElement(FOOTNOTE_SECTION);
    }

    public WebElement annotationsLink(String annotationsLinkText) {
        return retryingFindElement(By.linkText(annotationsLinkText));
    }

    public WebElement annotationsText(String annotationsText) {
        return retryingFindElement(By.xpath(".//h2[contains(text(),'" + annotationsText + "')]"));
    }

    public WebElement showAndHideLink() {
        return retryingFindElement(SHOW_AND_HIDE_LINK);
    }

    public WebElement annotationsSection() {
        return retryingFindElement(ANNOTATIONS_SECTION);
    }

    public WebElement contentColumn() {
        return retryingFindElement(CONTENT_COLUMN);
    }

    public WebElement statusIcon() {
        return retryingFindElement(STATUS_ICON);
    }

    public WebElement statusDescription() {
        return retryingFindElement(STATUS_DESCRIPTION);
    }

    public WebElement partyNamesText() {
        return retryingFindElement(PARTY_NAMES);
    }

    public WebElement partyNamesInCaseLaw() {
        return retryingFindElement(PARTY_NAMES_IN_CASELAW);
    }

    public WebElement aliasPartyNames() {
        return retryingFindElement(ALIAS_PARTY_NAMES);
    }

    public WebElement judgmentText(String judgmentText) {
        return retryingFindElement(By.xpath(".//ol[@class='kh_toc-list']/li[contains(text(),'" + judgmentText + "')]"));
    }

    public CaseDocumentPage() {
    }

    /**
     * This method verify the given star paging word is present or not in the
     * case law report and returns boolean vlaue accordingly.
     *
     * @param starPagingWord
     * @return boolean
     */
    public boolean isStarPagingWordPresent(String starPagingWord) {
        try {
            waitForElementPresent(By.xpath(".//span[@class='co_starPage'] [contains(text(),'" + starPagingWord + "')]"));
            return true;
        } catch (TimeoutException te) {
            LOG.info("context", te);
        }
        return false;
    }

    /**
     * This method is to verify the Download as PDF link is present or not and
     * returns the boolean value accordingly.
     *
     * @return boolean
     */
    public boolean isDownloadAsPDFLinkDisplayed() {
        try {
            return getDownloadAsPDFLink().isDisplayed();
        } catch (PageOperationException te) {
            LOG.info("context", te);
            return false;
        }
    }

    /**
     * This method does the Clicking on Download As PDF link.
     */
    public void clickOnDownloadAsPDFLink() {
        getDownloadAsPDFLink().click();
    }

    /**
     * This method gets the Download As PDF link webelement.
     *
     * @return WebElement
     */
    private WebElement getDownloadAsPDFLink() {
        try {
            return waitForElementPresent(pdfDownloadLinkLocator);
        } catch (TimeoutException te) {
            LOG.info("context", te);
            throw new PageOperationException("Exceeded time to find the PDF link on case document." + te.getMessage());
        }
    }

    /**
     * This method finds the given judgement section details on Case Judgment
     * document and returns the size of the section elements.
     *
     * @param judgmentSectionDetailsLocator
     * @return int
     */
    public int getJudgmentSectionDetailsList(By judgmentSectionDetailsLocator) {
        try {
            return waitForExpectedElements(judgmentSectionDetailsLocator).size();
        } catch (TimeoutException te) {
            LOG.info("context", te);
            logger.warn("Exceeded time to find the judgmentSectionDetailsLocator." + te.getMessage());
            return Collections.EMPTY_LIST.size();
        }
    }

    /**
     * This method verifies the party names are displayed on the Case judgment
     * document and returns the boolean value accordingly.
     *
     * @param partyNames
     * @return boolean
     */
    public boolean isJudgmentPartyNamesDisplayed(String partyNames) {
        try {
            return waitFluentForElement(By.cssSelector("")).isDisplayed(); // Need
            // to
            // amend
            // the
            // css.
        } catch (TimeoutException te) {
            LOG.info("context", te);
            return false;
        }
    }

    /**
     * This method verifies the party names are displayed on the left hand side
     * of Case judgment document and returns the boolean value accordingly.
     *
     * @param pageAttribute
     * @return boolean
     */
    public boolean isDisplayedOnLeftHandSide(String pageAttribute) {
        try {
            return waitFluentForElement(By.cssSelector("")).isDisplayed(); // Need
            // to
            // amend
            // the
            // css.
        } catch (TimeoutException te) {
            LOG.info("context", te);
            return false;
        }
    }

    public boolean isDateInValidFormat(String s, String dateFormat) {
        return commonMethods.isDateInValidFormat(s, dateFormat);
    }

    public boolean isJudgmentPresentUnderPartyNames() {
        return false;
    }

    public boolean isJudgmentDateInValidFormat() {
        return false;
    }

    public boolean isJudgmentStatusDisplayedOnLeftHandSide() {
        return false;
    }

    public boolean isJudgmentStatusIconDisplayedOnLeftHandSide() {
        return false;
    }

}