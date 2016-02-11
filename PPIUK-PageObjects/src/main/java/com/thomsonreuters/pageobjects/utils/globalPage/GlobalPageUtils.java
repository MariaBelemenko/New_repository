package com.thomsonreuters.pageobjects.utils.globalPage;

import com.thomsonreuters.driver.exception.PageOperationException;
import com.thomsonreuters.pageobjects.common.CommonMethods;
import com.thomsonreuters.pageobjects.pages.globalPage.ChinaCategoryPage;
import com.thomsonreuters.pageobjects.pages.globalPage.GlobalCategoryPage;
import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document.CaseDocumentPage;
import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document.StandardDocumentPage;
import com.thomsonreuters.pageobjects.utils.legalUpdates.CalendarAndDate;
import org.openqa.selenium.*;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class GlobalPageUtils {

    protected static final org.slf4j.Logger LOG = LoggerFactory.getLogger(CommonMethods.class);

    private GlobalCategoryPage globalCategoryPage = new GlobalCategoryPage();
    private ChinaCategoryPage chinaCategoryPage = new ChinaCategoryPage();
    private CaseDocumentPage caseDocumentPage = new CaseDocumentPage();
    private CommonMethods commonMethods = new CommonMethods();
    private StandardDocumentPage standardDocumentPage = new StandardDocumentPage();

    private static final String SPLIT = " ";
    private static final String DOCUMENT_XML = "http://legaltechtools.int.thomsonreuters.com/Velma/Novus/Document?guid=";

    private List<String> updatesDates;

    public boolean isTheListSortedInAlphabeticalOrder(List<String> checkedList) {
        List<String> originalList = new ArrayList<String>();
        originalList.addAll(checkedList);
        Collections.sort(checkedList);
        return originalList.equals(checkedList);
    }

    public boolean isTheDatesSortedInReverseChronologicalOrder(List<String> updatesDates, String dateFormat)
            throws ParseException {
        boolean result = false;
        List<Date> dates = CalendarAndDate.convertStringToDate(updatesDates, dateFormat);
        Collections.sort(dates, Collections.reverseOrder());
        List<String> resultDates = CalendarAndDate.convertDateToString(dates, dateFormat);
        for (int i = 0; i < updatesDates.size(); i++) {
            if (updatesDates.get(i).equals(resultDates.get(i)))
                result = true;
            else {
                result = false;
                break;
            }
        }
        return result;
    }

    public List<String> getAllDatesFromResultListOfLegalUpdates() {
        updatesDates = new ArrayList<String>();
        for (WebElement el : chinaCategoryPage.getAllDatesFromResultListOfLegalUpdates()) {
            LOG.info("Adding LU date from widget: " + el.getText());
            if (!el.getText().isEmpty()) {
                String[] words = el.getText().split(SPLIT);
                updatesDates.add(words[2] + " " + words[3] + " " + words[4]);
            }
        }
        return updatesDates;
    }

    public String getLineStyle(int number) {
        globalCategoryPage.waitForPageToLoad();
        String linesStyle = (String) globalCategoryPage
                .executeScript("return getComputedStyle($('#coid_website_browseMainColumn .co_column .co_featureBox, #coid_website_browseMainColumn .co_genericBox')["
                        + number + "]).borderBottomStyle;");
        LOG.info("Line style: ", linesStyle);
        return linesStyle;
    }

    public String getTextFontSize(String header, String tag) {
        globalCategoryPage.waitForPageToLoad();
        String fontSize = (String) globalCategoryPage.executeScript("return getComputedStyle($(\"" + tag + ":contains(" + "'" + header
                + "'" + ")\")[0]).fontSize;");
        LOG.info("Font size: ", fontSize);
        return fontSize;
    }

    public String getLineHeightStyle() {
		globalCategoryPage.waitForPageToLoad();
		globalCategoryPage.waitForPageToLoadAndJQueryProcessing();
		String lineHeight = (String) globalCategoryPage
				.executeScript("return getComputedStyle($('#coid_website_browseMainColumn .co_scrollWrapper .co_dataFeedWidget .co_artifactContent h3')[0]).lineHeight;");
		return lineHeight;
	}

    public void clickMoreOptionOnKnowHowGlobalJurisdiction() {
        try {
            globalCategoryPage.moreJurisdiction().click();
            globalCategoryPage.waitForElementVisible(By.xpath(".//div[contains(@id, 'JurisdictionSummary_popup')]"));
        } catch (TimeoutException se) {
            LOG.info("context", se);
            throw new PageOperationException("Exceeded time to find the More popup.");
        }
    }

    public List<String> getLinkNamesFromWebElementList(List<WebElement> elementList) {
        List<String> links = new ArrayList<String>();
        for (WebElement webElementLink : elementList) {
            links.add(webElementLink.getText());
        }
        return links;
    }

    public boolean isTheDeliveryWidgetIsDisplayed() {
        try {
            caseDocumentPage.deliveryOptions().isDisplayed();
            return true;
        } catch (PageOperationException te) {
            return false;
        }
    }

    public WebElement toggleProfileSettingsIcon(String icon) {
        return globalCategoryPage.findElement(By.xpath(".//*[@title='" + icon + "']"));
    }

    public List<WebElement> getWebElementsOfDocumentFromXMLByTag(String tag, String guid) {
        chinaCategoryPage.navigate(DOCUMENT_XML + guid);
        return chinaCategoryPage.findElements(By.tagName(tag));
    }

    public List<String> getValuesOfTagFromXMLOfTheDocument(String tag, String guid) {
    	globalCategoryPage.waitForPageToLoad();
		List<WebElement> topics = getWebElementsOfDocumentFromXMLByTag(tag, guid);
		return getLinkNamesFromWebElementList(topics);
    }

    public void clickOnContinueButton() {
        try {
            globalCategoryPage.findElement(By.id("co_clientIDContinueButton")).click();
        } catch (NoSuchElementException ex) {
            LOG.info("context", ex);
        }
    }

}
