package com.thomsonreuters.pageobjects.utils.plPlusResearchDocDisplay;

import com.thomsonreuters.driver.exception.PageOperationException;
import com.thomsonreuters.driver.framework.WebDriverDiscovery;
import com.thomsonreuters.pageobjects.common.CommonMethods;
import com.thomsonreuters.pageobjects.common.FileActions;
import com.thomsonreuters.pageobjects.pages.folders.ResearchOrganizerPage;
import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document.AssetDocumentPage;
import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document.PrimarySourceDocumentPage;
import com.thomsonreuters.pageobjects.utils.pdf.PDFBoxUtil;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.LoggerFactory;

import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.rtf.RTFEditorKit;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.List;


public class AssetPageUtils {

    private ResearchOrganizerPage researchOrganizerPage;

    private static final String DOWNLOADED_FILE_PATH = System.getProperty("user.home") + "/Downloads";
    private static final String SEPARATOR = " ";
    protected static final org.slf4j.Logger LOG = LoggerFactory.getLogger(CommonMethods.class);
    private static final By SIGN_ON_BUTTON = By.id("signonInputs");
    private static final By USERNAME_FIELD = By.id("uid");
    private static final By PASSWORD_FIELD = By.id("pwd");
    private static final String USERNAME = "mkemp";
    private static final String PASSWORD = "rainbow";

    private static final By SUBMIT_BUTTON = By.id("submitButton");
    private static final By DOCUMENT_BODY = By.id("docBody");
    private static final By SIGNOF_LINK = By.id("signoffLink");
    private static final By EU_DOCUMENT_TITLE = By.xpath("//h1[contains(text(),'European Union')]");
    private static final int MAXIMUM_COLOR_INTENSITY = 255;
    private static final int MINIMUM_C0LOR_INTENSITY = 0;

    private File downloadedFile = null;
    private String nameOfFileForDownload;
    private String resultNameOfPDFFile;

    private String firstUrl;
    private String valueHrefAtribute;
    private String winHandleFirst;
    private WebElement linkInLinkToThisCaseSection;
    private int numberOfLinksInContentSection;

    AssetDocumentPage assetDocumentPage = new AssetDocumentPage();
    PrimarySourceDocumentPage primarySourceDocumentPage = new PrimarySourceDocumentPage();
    WebDriverDiscovery driver = new WebDriverDiscovery();
    PDFBoxUtil pdfBoxUtil = new PDFBoxUtil();
    private FileActions fileActions = new FileActions();

    public WebElement outPutLink() {
        return assetDocumentPage.waitFluentForElement(SIGNOF_LINK);
    }

    private WebElement documentBody() {
        return assetDocumentPage.waitFluentForElement(DOCUMENT_BODY);
    }

    public WebElement euDocumentTitle() {
        return assetDocumentPage.findChildElement(documentBody(), EU_DOCUMENT_TITLE);
    }

    public boolean isTheUserSeeLinksToBailii(String bailiiLink) {
        try {
            assetDocumentPage.bailiiLink(bailiiLink);
            return true;
        } catch (PageOperationException poe) {
            LOG.info("context", poe);
            return false;
        }
    }

    public boolean isTheUserSeeJumpLinks(String jumpLinkText) {
        try {
            assetDocumentPage.jumpLink(jumpLinkText);
            return true;
        } catch (PageOperationException poe) {
            LOG.info("context", poe);
            return false;
        }
    }

    public boolean isTheUserSeeJumpLinksSection(String jumpLinkText) {
        try {
            assetDocumentPage.junpLinkSection(jumpLinkText);
            return true;
        } catch (PageOperationException poe) {
            LOG.info("context", poe);
            return false;
        }
    }

    public void getBaseParameters() {
        firstUrl = assetDocumentPage.getCurrentUrl();
        winHandleFirst = assetDocumentPage.getCurrentWindowHandle();
        LOG.info("winHandleFirst: " + winHandleFirst);
    }

    public void clickOnBailiiLink(String bailiiLink) {
        getBaseParameters();
        valueHrefAtribute = assetDocumentPage.bailiiLink(bailiiLink).getAttribute("href");
        assetDocumentPage.bailiiLink(bailiiLink).click();
    }

    public boolean isTheUserSeeLinksToLegalUpdates() {
        assetDocumentPage.waitForPageToLoad();
        return assetDocumentPage.linkToLegalUpdates().isDisplayed();
    }

    public void clickOnLinkToLegalUpdates() {
        getBaseParameters();
        valueHrefAtribute = assetDocumentPage.linkToLegalUpdates().getAttribute("href");
        assetDocumentPage.linkToLegalUpdates().click();
    }

    public boolean isTheUserSeeHardcodedLinks(String linkText) {
        assetDocumentPage.waitForPageToLoad();
        return assetDocumentPage.hardcodedLink(linkText).isDisplayed();
    }

    public void clickOnHardcodedLink(String linkText) {
        getBaseParameters();
        valueHrefAtribute = assetDocumentPage.hardcodedLink(linkText).getAttribute("href");
        assetDocumentPage.hardcodedLink(linkText).click();
    }

    public boolean isTheUserTakenToTheSelectedResource(String linkText) {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String secondWinHandle = new String();
        for (String winHandle : driver.getRemoteWebDriver().getWindowHandles()) {
            driver.getRemoteWebDriver().switchTo().window(winHandle);
            secondWinHandle = winHandle;
        }
        String secondUrl = assetDocumentPage.getCurrentUrl();
        LOG.info("secondUrl: " + secondUrl);
        if (!firstUrl.equals(secondUrl) && secondUrl.contains(linkText)) {
            driver.getRemoteWebDriver().switchTo().window(secondWinHandle).close();
            driver.getRemoteWebDriver().switchTo().window(winHandleFirst);
            return true;
        } else
            return false;
    }

    public boolean isTheUserTakenToTheLegalUpdates() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String secondUrl = assetDocumentPage.getCurrentUrl();
        if (!firstUrl.equals(secondUrl) && secondUrl.equals(valueHrefAtribute)) {
            return true;
        } else
            return false;
    }

    public boolean isTheUserSeeCelexLinks(String celexLinkText) {
        assetDocumentPage.waitForPageToLoad();
        return assetDocumentPage.celexLink(celexLinkText).isDisplayed();
    }

    public void clickOnCelexLink(String celexLinkText) {
        getBaseParameters();
        valueHrefAtribute = assetDocumentPage.celexLink(celexLinkText).getAttribute("href");
        assetDocumentPage.celexLink(celexLinkText).click();
    }

    public boolean isTheUserSeeLinkToWestlawUK(String westlawUkLinkText) {
        assetDocumentPage.waitForPageToLoad();
        return assetDocumentPage.westlawUkLink(westlawUkLinkText).isDisplayed();
    }

    public void clickOnLinkToWestlawUK(String westlawUkLinkText) {
        getBaseParameters();
        assetDocumentPage.westlawUkLink(westlawUkLinkText).click();
    }

    public void goBackToThePreviousWindow() {
    	System.out.println("1111111");
        assetDocumentPage.switchToWindow(winHandleFirst);
    }

    public boolean isTheUserTakenToTheLoginPageInWestlawUkDocument() {
        for (String winHandle : assetDocumentPage.getDriver.getWindowHandles()) {
            assetDocumentPage.switchToWindow(winHandle);
        }
        assetDocumentPage.waitForPageToLoad();
        WebElement userCredentionals = assetDocumentPage.waitForElementVisible(SIGN_ON_BUTTON);
        return userCredentionals.isDisplayed();
    }

    public boolean isTheUserTakenToTheWestlawUkDocument() {
        for (String winHandle : assetDocumentPage.getDriver.getWindowHandles()) {
            assetDocumentPage.switchToWindow(winHandle);
        }
        String secondUrl = assetDocumentPage.getCurrentUrl();
        return !firstUrl.equals(secondUrl);

    }

    public void loginWestlawUk() {
        assetDocumentPage.waitForPageToLoad();
        WebElement id = assetDocumentPage.findElement(USERNAME_FIELD);
        id.clear();
        id.sendKeys(USERNAME);
        WebElement pass = assetDocumentPage.findElement(PASSWORD_FIELD);
        pass.clear();
        pass.sendKeys(PASSWORD);
        assetDocumentPage.findElement(SUBMIT_BUTTON).click();
    }

    public boolean openDocumentInWestlawUK() {

        String secondHandle = new String();
        for (String winHandle : assetDocumentPage.getDriver.getWindowHandles()) {
            assetDocumentPage.switchToWindow(winHandle);
            secondHandle = winHandle;
        }
		assetDocumentPage.waitForPageToLoad();
        if (documentBody().isDisplayed()) {
            outPutLink().click();
            assetDocumentPage.waitForPageToLoad();
            assetDocumentPage.switchToWindow(secondHandle);
            assetDocumentPage.getDriver.close();
            assetDocumentPage.switchToWindow(winHandleFirst);
            return true;
        } else
            return false;
    }

    public boolean isTheCasePageIsDisplayedInAssertPage(String casePageText) {
        assetDocumentPage.waitForPageToLoad();
        if (assetDocumentPage.casePageText().isDisplayed()
                && assetDocumentPage.casePageText().getText().equals(casePageText))
            return true;
        else
            return false;
    }

    public boolean isTheUserTakenToSelectedPartOfTheDocument(String linkText) {
        assetDocumentPage.waitForPageToLoad();
        boolean result = (Boolean) assetDocumentPage.executeScript("function isScrolledIntoView(elem,off) {"
                + " var $elem = $(elem); var $window = $(window); " + "var docViewTop = $window.scrollTop()+off; "
                + "var docViewBottom = docViewTop + $window.height();" + "var elemTop = $elem.offset().top;"
                + "var elemBottom = elemTop + $elem.height();"
                + "return ((elemBottom <= docViewBottom) && (elemTop >= docViewTop));}"
                + "return isScrolledIntoView($(\"h2:contains('" + linkText + "')\"),200)");
        return result;
    }

    public boolean isTheUserSeeJumpLinksInTheLeftHandSideNavigationPanel(String jumpLinkText) {
        assetDocumentPage.waitForPageToLoadAndJQueryProcessingWithCustomTimeOut(30);
        LOG.info("context", assetDocumentPage.jumpLink(jumpLinkText).getLocation());
        return assetDocumentPage.jumpLink(jumpLinkText).isDisplayed();
    }

    public String clickOnJumpLink(String jumpLinkText) {
        assetDocumentPage.waitForPageToLoadAndJQueryProcessing();
        LOG.info("context", assetDocumentPage.jumpLink(jumpLinkText).getLocation());
        assetDocumentPage.jumpLink(jumpLinkText).click();
        return assetDocumentPage.jumpLink(jumpLinkText).getText();
    }

    public boolean isTheFieldInMetadataDisplayed(String text) {
        assetDocumentPage.waitForPageToLoad();
        try {
            assetDocumentPage.metaDataField(text).isDisplayed();
            return true;
        } catch (PageOperationException poe) {
            LOG.info("context", poe);
            return false;
        }
    }

    public void clickOkOnDownloadBrowserWindow() throws InterruptedException, AWTException {
        Thread.sleep(20000L);
        Robot object = new Robot();
        Thread.sleep(1000L);
        object.keyPress(KeyEvent.VK_ENTER);
        object.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(10000L);
    }

    public boolean isTheUserSeeNameOfFileForDownload() {
        if (assetDocumentPage.nameOfFileForDownload().isDisplayed()) {
            nameOfFileForDownload = assetDocumentPage.nameOfFileForDownload().getText();
            return true;
        } else
            return false;
    }

    public boolean isThePDFDocumentDownloaded() throws IOException {
        LOG.info("nameOfFileForDownload: " + nameOfFileForDownload);
        String result = removeChar(removeChar(nameOfFileForDownload, '['), ']');
        resultNameOfPDFFile = result + ".pdf";
        LOG.info("nameOfFileForDownload: " + nameOfFileForDownload);
        downloadedFile = fileActions.findFile(resultNameOfPDFFile, DOWNLOADED_FILE_PATH);
        if (downloadedFile != null && downloadedFile.exists()) {
            return true;
        } else
            return false;

    }

    public String removeChar(String text, char symbol) {
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) != symbol)
                result += text.charAt(i);
        }
        return result;
    }

    public boolean isTheDocumentDownloadedInFormat(String formatName) throws IOException {

        LOG.info("nameOfFileForDownload: " + nameOfFileForDownload);
        String result = removeChar(removeChar(nameOfFileForDownload, '['), ']');
        resultNameOfPDFFile = result + formatName;
        LOG.info("nameOfFileForDownload: " + nameOfFileForDownload);

        // resultNameOfPDFFile = nameOfFileForDownload + formatName;
        downloadedFile = fileActions.findFile(resultNameOfPDFFile, DOWNLOADED_FILE_PATH);
        if (downloadedFile != null && downloadedFile.exists()) {
            return true;
        } else
            return false;
    }

    public boolean isTheDownloadedPDFDocumentContainHyperlinkToExternalWebSite(String linkHref, String linkText, File docFile) {
        try {
            String bailiiUrlFtomPDF = pdfBoxUtil.extractURLs(docFile.getAbsolutePath()).get(linkText);
            // String bailiiUrlFtomPDF =
            // pdfBoxUtil.extractURLs(DOWNLOADED_FILE_PATH + "/" +
            // resultNameOfPDFFile).get(
            // linkText);
            LOG.info("bailiiUrlFtomPDF: " + bailiiUrlFtomPDF);
            LOG.info("linkHref: " + linkHref);
            return linkHref.contains(bailiiUrlFtomPDF);

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void deleteFile() {
        fileActions.deleteFile(downloadedFile);
    }

    public boolean isTheEndOfDocumentContainText() {
        return assetDocumentPage.endOfDocument().getText().isEmpty();
    }

    public void scrollToTheBottomOfTheDocument() {
        JavascriptExecutor e = (JavascriptExecutor) assetDocumentPage.getDriver;
        e.executeScript("window.scrollTo(0,document.body.scrollHeight);");
    }

    public boolean isTheContentBodyContainEndOfDocument() {
        try {
            assetDocumentPage.endOfDocument();
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public boolean isTheUserScrolledToTheTopOfTheDocument() {
        assetDocumentPage.waitForPageToLoad();
        boolean result = (Boolean) assetDocumentPage.executeScript("function isScrolledIntoView(elem,off) {"
                + " var $elem = $(elem); var $window = $(window); " + "var docViewTop = $window.scrollTop()+off; "
                + "var docViewBottom = docViewTop + $window.height();" + "var elemTop = $elem.offset().top;"
                + "var elemBottom = elemTop + $elem.height();"
                + "return ((elemBottom <= docViewBottom) && (elemTop >= docViewTop));}"
                + "return isScrolledIntoView($(\"h1\"),200)");
        return result;
    }

    public void addTextToTheDocumentPage() {
        assetDocumentPage.executeScript("for (var i = 0; i < 150; i++){$('#co_docContentBody').html('TESTtestTest ' + $('#co_docContentBody').html() )}");
    }

    public boolean isTableOfContentDisplayed() {
        assetDocumentPage.waitForPageToLoad();
        try {
            return assetDocumentPage.tableOfContentSection().isDisplayed();
        } catch (PageOperationException poe) {
            LOG.info("context", poe);
            return false;
        }
    }

    public boolean isDocumentContainClassWithCaseAssetDoc() {
        assetDocumentPage.waitForPageToLoad();
        boolean result = false;
        try {
            String[] words = assetDocumentPage.caseAssetDocClass().getAttribute("class").split(SEPARATOR);
            for (int i = 0; i < words.length; i++) {
                if (words[i].equals("case-asset-doc")) {
                    result = true;
                    break;
                }
            }
            return result;

        } catch (NoSuchElementException ex) {
            LOG.info("context", ex);
            return false;
        }
    }

    public boolean isTheUserSeeTheValueOfSpecialistCourt() {
        if (assetDocumentPage.valueOfSpecialistCourt().getText().isEmpty() == false) {
            return true;
        } else
            return false;
    }

    public boolean isTheUserTakenToTheInternalDocument(String hrefAtribute) {
    	String secondUrl = assetDocumentPage.getCurrentUrl();
		LOG.info("secondUrl" + secondUrl);
		LOG.info("hrefAtribute" + hrefAtribute);
		return !firstUrl.equals(secondUrl) && secondUrl.contains("https://a.uk.practicallaw");
    }

    public boolean isTheDocumentContainLink(String linkText) {
        try {

            linkInLinkToThisCaseSection = primarySourceDocumentPage.linkInLinksToThisCaseSection(linkText);

            return true;
        } catch (NoSuchElementException ex) {
            LOG.info("context", ex);
            return false;
        }
    }

    public boolean isTheLinkDisplayedAccodingWithClassNameAndHrefAtribute(String linkText) {
        boolean result = false;
        try {
            WebElement parentLink = primarySourceDocumentPage.parentOflinkInLinksToThisCaseSection(linkText);
            String className = parentLink.getAttribute("class");
            String hrefOfTheLink = linkInLinkToThisCaseSection.getAttribute("href");
            LOG.info("className: " + className);
            LOG.info("hrefOfTheLink: " + hrefOfTheLink);
            if (linkInLinkToThisCaseSection.isDisplayed() == true) {
                if (className.isEmpty() || className.equals("") && hrefOfTheLink.contains("http")) {
                    result = true;
                } else {
                    result = false;
                }
            }
            if (linkInLinkToThisCaseSection.isDisplayed() == false) {
                if (className.equals("co_hideState") && hrefOfTheLink.contains("uk.practicallaw")) {
                    result = true;
                } else {
                    result = false;
                }
            }
            return result;
        } catch (NoSuchElementException ex) {
            LOG.info("context", ex);
            return false;
        }
    }

    public boolean isThedownloadedDocumentContainContentRefferingSection(String contentReferringText, File docFile) {
        try {
            // String textFromPdf = pdfBoxUtil.extractText((DOWNLOADED_FILE_PATH
            // + "/" + resultNameOfPDFFile));
            String textFromPdf = pdfBoxUtil.extractText(docFile.getAbsolutePath());
            return textFromPdf.contains(contentReferringText);

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public String getTestFromPDFDocument() {
        try {
            return pdfBoxUtil.extractText((DOWNLOADED_FILE_PATH + "/" + resultNameOfPDFFile));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public WebElement documentInHistory(int position) {
        return researchOrganizerPage.getLinkToDocumentAtRowPosition(String.valueOf(position));
    }

    public boolean isTheLinkContainsTheDocumentTitleAndHref(int position, String documentTitle) {
        WebElement actualDocument = researchOrganizerPage.getLinkToDocumentAtRowPosition(String.valueOf(position));
        return documentTitle.contains(actualDocument.getText());
    }

    public boolean isTheLinksOfTypeOfDocumentAreSortedAlphabetically(String documentTypeText) {
        List<WebElement> links = primarySourceDocumentPage.listOfLinksByDocumentType(documentTypeText);
        List<String> actualLinkList = new ArrayList<String>();
        List<String> expectedLinkList = new ArrayList<String>();
        for (WebElement link : links) {
            String linkText = link.getText().trim();
            if (!linkText.isEmpty()) {
                actualLinkList.add(linkText);
            }
        }
        expectedLinkList.addAll(actualLinkList);
        Collections.sort(actualLinkList);
        return expectedLinkList.equals(actualLinkList);
    }

    public boolean isTheNumberOfLinksMoreThan(String numberOfLinks) {
        String result = primarySourceDocumentPage.numberOfLinksFoundResult().getText();
        String[] words = result.split(" ");
        numberOfLinksInContentSection = Integer.parseInt(words[0]);
        return Integer.parseInt(words[0]) > Integer.parseInt(numberOfLinks);
    }

    public boolean isTheNumberOfLinksEqualsToTheNumberOfResultsFound() {
        boolean result = true;
        List<WebElement> links = primarySourceDocumentPage.listOfLinksInContentRefferingSection();
        List<String> ar = new ArrayList<String>();
        for (int i = 0; i < links.size(); i++) {
            WebElement link = links.get(i);
            if (link.getText().isEmpty() == false || !link.getText().equals("")) {
                ar.add(link.getText());
            }
        }
        if (ar.size() != numberOfLinksInContentSection) {
            result = false;
        }
        return result;
    }


    public boolean isTheJurisdictionsContainLessThanOneJurisdiction(String jurisdictionsText) {
        String[] words = primarySourceDocumentPage.contentOfMetaDataFields(jurisdictionsText).getText().split(",");
        return words.length >= 2;

    }

    public boolean isTheNumberOfOpenedTubsEqueals(int numberOfOpenedTubs) {
        int i = 0;
        for (String winHandle : assetDocumentPage.getWindowHandles()) {
            assetDocumentPage.switchToWindow(winHandle);
            i++;
        }
        return i == numberOfOpenedTubs;
    }

    public boolean isTheHyperlinkOfDownloadedDocumentContainSpecificParameters(String linkText, String text, File docFile) {
        try {
            // String hyperlinkFtomPDF =
            // pdfBoxUtil.extractURLs(DOWNLOADED_FILE_PATH + "/" +
            // resultNameOfPDFFile).get(
            // linkText);
            String hyperlinkFtomPDF = pdfBoxUtil.extractURLs(docFile.getAbsolutePath()).get(linkText);
            LOG.info("hyperlinkFtomPDF: " + hyperlinkFtomPDF);
            return hyperlinkFtomPDF.contains(text);
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isLinkExistsInThePdfDocument(String linkText, File docFile) {
        try {
            Map<String, String> docLinkNames = pdfBoxUtil.extractURLs(docFile.getAbsolutePath());
            // Can't use List.contains(Object) because pdfBoxUtil.extractURLs can truncate some extracted links
            // due to wrong ling ara width calculating (maybe bug in PDFBox library)
            for (String docLinkName : docLinkNames.keySet()) {
                if (docLinkName.contains(linkText) || linkText.contains(docLinkName)) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isTheOtherProvisionSectionHasStyle(String sectionNameText, String styleText) {
        if (primarySourceDocumentPage.otherProvisionStyle(sectionNameText).getAttribute("class").equals(styleText))
            return false;
        else
            return true;
    }

    public void chooseDropdownBox(String text, WebElement element) {
        Select dropDown = new Select(element);
        String selected = dropDown.getFirstSelectedOption().getText();
        if (!selected.equals(text)) {
            List<WebElement> Options = dropDown.getOptions();
            for (WebElement option : Options) {
                if (option.getText().equals(text)) {
                    option.click();
                }
            }
        }
    }

    public boolean isTheBulletsHaveStyle(String styleName) {
        assetDocumentPage.waitForPageToLoad();
        JavascriptExecutor e = (JavascriptExecutor) assetDocumentPage.getDriver;
        String bulletsStyle = (String) e.executeScript("return getComputedStyle($('.co_assetList')[0]).listStyleType");
        LOG.info("BulletsStyle: ", bulletsStyle);
        return bulletsStyle.equals(styleName);
    }

    public boolean isTheDoubleLinesHaveStyle(String styleName) {
        assetDocumentPage.waitForPageToLoad();
        JavascriptExecutor e = (JavascriptExecutor) assetDocumentPage.getDriver;
        String lineStyle = (String) e.executeScript("return getComputedStyle($('.co_assetList')[0]).borderBottomStyle");
        LOG.info("LineStyle: ", lineStyle);
        return lineStyle.equals(styleName);
    }

    public boolean isTheSpacingBetweenDoubleLinesAndLinksHaveSize(String size) {
        assetDocumentPage.waitForPageToLoad();
        JavascriptExecutor e = (JavascriptExecutor) assetDocumentPage.getDriver;
        String marginBottom = (String) e.executeScript("return getComputedStyle($('.co_assetList')[0]).marginBottom");
        String paddingBottom = (String) e.executeScript("return getComputedStyle($('.co_assetList')[0]).paddingBottom");
        if (marginBottom.equals(size) && paddingBottom.equals(size))
            return true;
        else
            return false;
    }

    public String getFontSizeOfLink(String linkText) {
        assetDocumentPage.waitForPageToLoad();
        JavascriptExecutor e = (JavascriptExecutor) assetDocumentPage.getDriver;
        String fontSize = (String) e.executeScript("return getComputedStyle($(\".co_assetList a:contains(" + "'"
                + linkText + "'" + ")\")[0]).fontSize");
        return fontSize;
    }

    public String getFontSizeOfHeader(String headerHame) {
        assetDocumentPage.waitForPageToLoad();
        JavascriptExecutor e = (JavascriptExecutor) assetDocumentPage.getDriver;
        String fontSize = (String) e.executeScript("return getComputedStyle($(\"h2:contains(" + "'" + headerHame + "'"
                + ")\")[0]).fontSize");
        return fontSize;
    }

    public boolean isTheLinkLocatedOnTheSide(String sideName) {
        assetDocumentPage.waitForPageToLoad();
        JavascriptExecutor e = (JavascriptExecutor) assetDocumentPage.getDriver;
        String side = (String) e
                .executeScript("return getComputedStyle($('#co_RelatedContentPaginationControls')[0]).float");
        return side.equals(sideName);
    }

    public void selectCheckbox(WebElement element) {
        if (element.getAttribute("checked") == null) // if Checked
            element.click();
    }

    public boolean isTheDownloadedDocumentContainTableOfContent(String linkText, File docFile) {
        try {
            // String textFromPdf = pdfBoxUtil.extractText(DOWNLOADED_FILE_PATH
            // + "/" + resultNameOfPDFFile);
            String textFromPdf = pdfBoxUtil.extractText(docFile.getAbsolutePath());
            textFromPdf = textFromPdf.replaceAll("\\n", "").replaceAll("\r", "");
            LOG.info("textFromPdf: ", textFromPdf);
            return textFromPdf.contains(assetDocumentPage.partyNames().getText() + " " + linkText);

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public String getFontSizeOfBullet(String linkText) {
        assetDocumentPage.waitForPageToLoad();
        JavascriptExecutor e = (JavascriptExecutor) assetDocumentPage.getDriver;
        String fontSize = (String) e.executeScript("return getComputedStyle($(\"a:contains(" + "'" + linkText + "'"
                + ")\").parent()[0]).fontSize");
        return fontSize;
    }

    public boolean isTheDownloadedDocumentContainRightNumberOfBullets(File docFile)
            throws IOException, BadLocationException {
        assetDocumentPage.waitForPageToLoad();
        List<WebElement> linksInLegalUpdatesSection = assetDocumentPage.listOfLinksInLegalUpdatesSection();
        List<WebElement> linksInLinksToThisPageSection = assetDocumentPage.listOfLinksInLinksToThisPageSection();
        int numberOfLinks = linksInLegalUpdatesSection.size() + linksInLinksToThisPageSection.size();
        // String textFromRTF = getTextFromRTF(DOWNLOADED_FILE_PATH + "/" +
        // resultNameOfPDFFile);
        String textFromRTF = getTextFromFileWithRTForDOCextension(docFile.getAbsolutePath());

        int court = 0;
        Character[] characterArray = toCharacterArray(textFromRTF);
        for (int i = 0; i < characterArray.length; i++) {
            if (characterArray[i].toString().equals("\u2022")) {
                court++;
            }
        }
        return court == numberOfLinks;
    }

    public static Character[] toCharacterArray(String sourceString) {
        char[] charArrays = new char[sourceString.length()];
        charArrays = sourceString.toCharArray();
        Character[] characterArray = new Character[charArrays.length];
        for (int i = 0; i < charArrays.length; i++) {
            characterArray[i] = charArrays[i];
        }
        return characterArray;
    }

    public String getTextFromFileWithRTForDOCextension(String path) throws IOException, BadLocationException {
        DefaultStyledDocument styledDoc = new DefaultStyledDocument();
        FileInputStream inStream;
        try {
            inStream = new FileInputStream(path);
            new RTFEditorKit().read(inStream, styledDoc, 0);
        } catch (FileNotFoundException e) {
            LOG.info("FileNotFoundException: ");
            e.printStackTrace();
        }
        return styledDoc.getText(0, styledDoc.getLength());
    }

    public boolean isTheSourceDocumentRemainsOpen(String guid) {
        String winHandleFirst = assetDocumentPage.getDriver.getWindowHandle();
        Boolean isOpen = false;
        for (String handle : assetDocumentPage.getDriver.getWindowHandles()) {
            assetDocumentPage.switchToWindow(handle);
            String currentUrl = assetDocumentPage.getDriver.getPageSource();
            if (currentUrl.contains(guid)) {
                try {
                    if (assetDocumentPage.contentBody().isEnabled()) {
                        isOpen = true;
                        break;
                    }
                } catch (PageOperationException e) {
                    LOG.info("There is no document body on the page");
                    break;
                }
            }
        }
        assetDocumentPage.switchToWindow(winHandleFirst);
        return isOpen;
    }

    public String getColorFromPDFLinks(File docFile, String textToFingFromPdf) throws IOException {
        assetDocumentPage.waitForPageToLoad();
        Color color = pdfBoxUtil.getFontColorFromPdf(docFile.getAbsolutePath(), textToFingFromPdf, 0);
        if (color.getRed() == MINIMUM_C0LOR_INTENSITY && color.getGreen() == MINIMUM_C0LOR_INTENSITY
                && color.getBlue() == MAXIMUM_COLOR_INTENSITY) {
            return "blue";
        } else if (color.getRed() == MAXIMUM_COLOR_INTENSITY && color.getGreen() == MINIMUM_C0LOR_INTENSITY
                && color.getBlue() == MINIMUM_C0LOR_INTENSITY) {
            return "red";
        } else if (color.getRed() == MINIMUM_C0LOR_INTENSITY && color.getGreen() == MINIMUM_C0LOR_INTENSITY
                && color.getBlue() == MINIMUM_C0LOR_INTENSITY)
            return "black";
        else {
            LOG.info("fontColorFromPdf: ", color.toString());
            return color.toString();
        }
    }

}
