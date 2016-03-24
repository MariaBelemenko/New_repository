package com.thomsonreuters.pageobjects.utils.plPlusResearchDocDisplay;

import java.text.ParseException;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.slf4j.Logger;

import com.thomsonreuters.driver.exception.PageOperationException;
import com.thomsonreuters.driver.framework.AbstractPage;
import com.thomsonreuters.pageobjects.common.PageActions;
import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document.CaseDocumentPage;
import com.thomsonreuters.pageobjects.utils.legalUpdates.CalendarAndDate;

public class CaseDocumentPageUtils extends AbstractPage {

    private CaseDocumentPage caseDocumentPage = new CaseDocumentPage();
    private PageActions pageActions = new PageActions();

    protected static final Logger LOG = org.slf4j.LoggerFactory.getLogger(CaseDocumentPageUtils.class);


    public void selectOnShowAndHideLink() {
        caseDocumentPage.executeScript("document.getElementById('co_ExpandCollapseLegislationAnnotationSection').scrollIntoView(true); window.scrollBy(0,-300);");
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


    public boolean isTheLinkPresent(String text) {
        try {
            findElement(By.linkText(text));
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public boolean isTheDateHasCorrectFormat(String date, String format) throws ParseException {
		Date resultDate = CalendarAndDate.convertStringToDate(date, format);
		return CalendarAndDate.convertDateToString(resultDate, format).equals(date);
	}
}
