package com.thomsonreuters.pageobjects.utils.plPlusResearchDocDisplay;

import com.thomsonreuters.driver.exception.PageOperationException;
import com.thomsonreuters.driver.framework.AbstractPage;
import com.thomsonreuters.pageobjects.common.FileActions;
import com.thomsonreuters.pageobjects.common.PageActions;
import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document.CaseDocumentPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.slf4j.Logger;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

public class CaseDocumentPageUtils extends AbstractPage {

    private static final String DOWNLOADED_FILE_PATH = System.getProperty("user.home") + "/Downloads";
    private static final String SEPARATOR = " ";

    private CaseDocumentPage caseDocumentPage = new CaseDocumentPage();
    private PageActions pageActions = new PageActions();

    private FileActions fileActions;
    private File downloadedFile = null;

    protected static final Logger LOG = org.slf4j.LoggerFactory.getLogger(CaseDocumentPageUtils.class);


    public void selectOnShowAndHideLink() {
        JavascriptExecutor js = (JavascriptExecutor) caseDocumentPage.getDriver;
        js.executeScript("document.getElementById('co_ExpandCollapseLegislationAnnotationSection').scrollIntoView(true); window.scrollBy(0,-300);");
        pageActions.mouseOver(caseDocumentPage.showAndHideLink());
        caseDocumentPage.showAndHideLink().click();
    }

    public boolean isAnnotationSectionIsDisplayed() {
        caseDocumentPage.waitForPageToLoad();
        try {
            return caseDocumentPage.annotationsSection().isDisplayed();
        } catch (PageOperationException poe) {
            LOG.info("context", poe);
            return false;
        }
    }

    public boolean isTheUserSeeTheContentColumn() {
        return caseDocumentPage.contentColumn().isDisplayed();
    }

    public boolean isTheUserSeeStatusIcon() {
        return caseDocumentPage.statusIcon().isDisplayed();
    }

    public boolean isTheUserSeeStatusDescription() {
        if (caseDocumentPage.statusDescription().getText().length() != 0)
            return true;
        else
            return false;
    }

    public boolean isTheJudgementNavigationMenuIsDisabled(String judgmentText) {
        try {
            findElement(By.linkText(caseDocumentPage.judgmentText(judgmentText).getText()));
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public void userSelectsTheJudgementPDF() throws InterruptedException, AWTException {
        caseDocumentPage.documentInPdf().click();
        Thread.sleep(20000L);
        Robot object = new Robot();
        Thread.sleep(1000L);
        object.keyPress(KeyEvent.VK_ENTER);
        object.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(10000L);
    }

    public boolean isThePdfCopyOfTheJudgementIsDownloaded() throws IOException {
        String[] words = caseDocumentPage.documentInPdf().getText().split(SEPARATOR);
        String resultName = words[3] + "_" + words[4] + "_" + words[5];
        downloadedFile = fileActions.findFile(resultName, DOWNLOADED_FILE_PATH);
        if (downloadedFile != null && downloadedFile.exists()) {
            fileActions.deleteFile(downloadedFile);
            return true;
        } else
            return false;
    }

    public boolean isTheUserSeeFootnotes(String footnotesText) {
        if (caseDocumentPage.isElementDisplayed(caseDocumentPage.footnoteSection()) == true && caseDocumentPage.footnoteSection().getText().equals(footnotesText))
            return true;
        else
            return false;
    }

}
