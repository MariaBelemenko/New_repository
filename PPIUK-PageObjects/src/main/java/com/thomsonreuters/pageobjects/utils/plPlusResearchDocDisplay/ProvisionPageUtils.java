package com.thomsonreuters.pageobjects.utils.plPlusResearchDocDisplay;

import com.thomsonreuters.driver.exception.PageOperationException;
import com.thomsonreuters.driver.framework.AbstractPage;
import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document.ProvisionPage;
import com.thomsonreuters.pageobjects.utils.document.DateFormat;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProvisionPageUtils {

    private ProvisionPage provisionPage = new ProvisionPage();

    protected DateFormat dateFormat;

    private static final String TITLE_END = " - Practical Law";
    protected static final Logger LOG = LoggerFactory.getLogger(AbstractPage.class);

    public boolean isTheAnnotatedStatutesMenuLinkIsPresent(String linkName) {
        try {
            return provisionPage.annotatedStatutesLink(linkName).isDisplayed();
        } catch (PageOperationException poe) {
            LOG.info("context", poe);
            return false;
        }
    }

    public boolean isTheUserSeeTheAnnotatedStatutesText(String annotatedStatusText) {
        try {
            return provisionPage.annotatedStatuesText(annotatedStatusText).isDisplayed();
        } catch (PageOperationException poe) {
            LOG.info("context", poe);
            return false;
        }
    }

    public boolean isTheUserSeeTheSectionAndParagraphs(String section) {
        try {
            String[] words = provisionPage.sectionText().getText().split(" ");
            if (words[0].equals(section) && provisionPage.paragraphsText().isDisplayed() == true)
                return true;
            else
                return false;
        } catch (PageOperationException poe) {
            LOG.info("context", poe);
            return false;
        }
    }

    public boolean isTitleDisplayedOnOpenedDocument() {
        String[] title = provisionPage.titleText().getText().split("\n");
        String resultTitle = title[1] + TITLE_END;
        if (resultTitle.equals(provisionPage.getPageTitle()))
            return true;
        else
            return false;
    }

    public String clickOnLink(WebElement elementForClick) {
        String firstTitle = provisionPage.getPageTitle();
        elementForClick.click();
        return firstTitle;
    }

    public String clickOnJumpLink(String jumpLinkText) {
        provisionPage.jumpLink(jumpLinkText).click();
        return provisionPage.jumpLink(jumpLinkText).getText();
    }

    public boolean isTheUserRedirectToDesiredPartOfDocument(String jumpLinkText) {
        if (provisionPage.isElementDisplayed(provisionPage.jumpLinkText(jumpLinkText)) == true
                && provisionPage.jumpLinkText(jumpLinkText).getText().equals(provisionPage.jumpLink(jumpLinkText).getText()))
            return true;
        else
            return false;
    }

}
