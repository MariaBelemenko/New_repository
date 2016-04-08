package com.thomsonreuters.askRewrite.pages;


import com.thomsonreuters.driver.framework.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

import static org.junit.Assert.assertTrue;


public class PLCHomePageCommon extends AbstractPage {

    public WebElement cookiePolicy() {
        return waitForExpectedElement(By.id("dismissCookiePolicy"), 30);
    }

    public WebElement aboutSearchResultsNumber() {
        return waitForExpectedElement(By.xpath("//span[contains(@class,'ResultsCount')]/strong"));
    }

	public WebElement topButton() {
		return waitForExpectedElement(By.id("btnTop"));
	}

	public WebElement contentsButton() {
		return waitForExpectedElement(By.id("btnContent"));
	}

	public WebElement actionsWordExport() {
        return waitForExpectedElement(By.xpath("//a[contains(@id,'export_word')]"));
    }

    public WebElement actionsExcelExport() {
        return waitForExpectedElement(By.xpath("//a[contains(@id,'export_excel')]"));
    }

    public WebElement actionsAskAQuestion() {
        return waitForExpectedElement(By.xpath("//span[text()='Ask a question']/parent::a"));
    }

    public WebElement practiceAreaLink(String linkText) {
		// the / slash follows practice so a practice-note isn't selected in
		// error
		return waitForExpectedElement(By.xpath("//div[@id='main']//a[contains(@href,'practice/')]//self::a[text()='" + linkText + "']"));
	}

	public WebElement practiceNotesLink(String linkText) {
		return waitForExpectedElement(By.xpath("//div[@id='main']//a[contains(@href,'practice-notes')]/self::a[text()='" + linkText + "']"));
	}

	public WebElement noResultsErrorMessage(String errorMessage) {
		return waitForExpectedElement(By.xpath("//div[@id='no-results']//*[contains(text(),'" + errorMessage + "')]"));
	}

	public WebElement mainMenuPracticeAreaLink(String linkText) {
		if ("What's Market".equals(linkText)) {
			// You can't have an apostrophe in an XPath
			linkText = "s Market";
		}
		return waitForExpectedElement(By.xpath("//div[contains(@id,'globalmegamenu')]//a[contains(@href,'practice')]/self::a[text()='" + linkText + "']"));
	}

	public WebElement resourceLink(String linkText) {
		return waitForExpectedElement(By.xpath("//div[@id='main']//a[contains(@href,'resources')]/self::a[text()='" + linkText + "']"));
	}

	public WebElement whatsMarketSummaryLink(String linkText) {
		return waitForExpectedElement(By.xpath("//div[@id='main']//a[contains(@href,'Search')]/self::a[text()='" + linkText + "']"));
	}

	public WebElement mainMenuresourceLink(String linkText) {
		String xpathToCheck;
		xpathToCheck = "//div[contains(@id,'globalmegamenu')]//a[contains(@href,'resources')]/self::a[contains(text(),'" + linkText + "')]";
		if ("What's Market".equals(linkText)) {
			// You can't have an apostrophe in an XPath
			linkText = "s Market";
		}
        if ("Glossary".equals(linkText)) {
            // For links without the word resources in the URL
            xpathToCheck = "//div[contains(@id,'globalmegamenu')]//a[contains(text(),'" + linkText + "')]";
        }
        return waitForExpectedElement(By.xpath(xpathToCheck));
    }

	public WebElement mainMenuPracticalLawLink(String linkText) {
		return waitForExpectedElement(By.xpath("//div[contains(@id,'globalmegamenu')]//a[contains(@href,'my-practical-law')]/self::a[contains(text(),'" + linkText + "')]"));
	}

    public WebElement getResourcesMenu() {
        return waitForExpectedElement(By.cssSelector("div[id='globalmegamenu'] ul li:nth-of-type(2) a"));
    }

    public WebElement getGlobalMenuContainer() {
        return waitForExpectedElement(By.cssSelector("div[id='globalmegamenu']"));
    }

	public WebElement documentDisplayPlainText(String plainText) {
		return waitForExpectedElement(By.xpath("//div[contains(@id,'main')]//*[contains(text(),'" + plainText + "')]"));
	}

	public WebElement documentDisplayMessageFollowingSubHeading(String headingText) {
		return waitForExpectedElement(By.xpath("//h2[contains(text(),'" + headingText + "')]/../p"));
	}

	public WebElement registerButton() {
		return waitForExpectedElement(By.className("register_button"));
	}

	public WebElement documentDisplayLinkText(String linkText) {
		return waitForExpectedElement(By.xpath("//div[contains(@id,'main')]//a[contains(text(),'" + linkText + "')]"));
	}

	public WebElement primarySourceLinkText(String linkText) {
		return waitForExpectedElement(By.xpath("//ul[@id='ps_links']//a[contains(text(),'" + linkText + "')]"));
	}

	public WebElement documentDisplayPracticeNoteLinkText(String linkText) {
		return waitForExpectedElement(By.xpath("//div[contains(@class,'show-resource')]//a[contains(text(),'" + linkText + "')]"));
	}

	public WebElement documentDisplayResourceType() {
		return waitForExpectedElement(By.xpath("//*[contains(text(),'Resource type:')]/span"));
	}

	public WebElement actionsTextLinksTo(String actionText, String partialLinkText) {
		return waitForExpectedElement(By.xpath("//div[text()='Actions']/following-sibling::*//a[text()='" + actionText + "']//self::a[contains(@href,'" + partialLinkText
				+ "')]"));
	}

	public WebElement resourceLinkToDocument(String linkText, String documentURL) {
		return waitForExpectedElement(By.xpath("//div[@id='main']//a[contains(@href,'" + documentURL + "')]/self::a[text()='" + linkText + "']"));
	}

	public WebElement pageTitle() {
		return waitForExpectedElement(By.xpath("//div[@id='main']//h1"));
	}

	public WebElement googleViewPageTitle() {
		return waitForExpectedElement(By.xpath("//h1"));
	}

	public WebElement resultsActiveUITab() {
		return waitForExpectedElement(By.xpath("//div[@id='PLC_ui_tabs']//span"));
	}

	public WebElement resultsInactiveUITab(String tabTitle) {
		if ("What's Market".equals(tabTitle)) {
			tabTitle = "s Market";
		}
		return waitForExpectedElement(By.xpath("//div[@id='PLC_ui_tabs']//a[contains(text(),'" + tabTitle + "')]"));
	}

	public WebElement resultsInactiveSortLink() {
		return waitForExpectedElement(By.xpath("//div[@id='PLC_sort_by']//a"));
	}

    public WebElement resultsActiveSortLink() {
        return waitForExpectedElement(By.xpath("//a[@ctype='sort']/.."));
    }

	public WebElement searchDropDown() {
		return waitForExpectedElement(By.id("searchDropDown"));
	}

	public WebElement mainMenuTab(String tabText) {
		return waitForExpectedElement(By.xpath("//ul[@class='smoothmenu']//span[text()='" + tabText + "']"));
	}

	public WebElement pageTabSelected(String tabText) {
		return waitForExpectedElement(By.xpath("//div[contains(@class,'tab')]/self::div[text()='" + tabText + "']"));
	}

	public WebElement pageTabNotSelected(String tabText) {
		return waitForExpectedElement(By.xpath("//div[contains(@class,'tab')]/a[text()='" + tabText + "']"));
	}

	public WebElement tabLink(String tabLinkText) {
		return waitForExpectedElement(By.xpath("//a[contains(@class,'tab')]/self::a[text()='" + tabLinkText + "']"));
	}

	public WebElement resultLink(String rankNumber, String resultLinkURL) {
		return waitForExpectedElement(By.xpath("//div[@class='main-results']//a[@rank='" + rankNumber + "']/self::a[contains(@href,'" + resultLinkURL + "')]"));
	}

	public WebElement resultTitle(String rankNumber, String resultTitle) {
		WebElement resultElement;
		String resultText;
		resultElement = waitForExpectedElement(By.xpath("//div[@class='main-results']//a[@rank='" + rankNumber + "']"));
		resultText = resultElement.getText();
		// LOG.info("The link title returned was " + resultText);
		assertTrue(resultText.equals(resultTitle));
		return resultElement;
	}

	public WebElement resultCheckboxByDeal(String dealID) {
		return waitForExpectedElement(By.xpath("//input[contains(@id,'" + dealID + "')]/self::*[@type='checkbox']"));
	}

	public WebElement resultLinkByDealAndTitle(String dealID, String linkTitle) {
		return waitForElementPresent(By.xpath("//a[text()='" + linkTitle + "']/self::*[contains(@href,'" + dealID + "')]"));
	}

	public WebElement result(String rankNumber) {
		return waitForExpectedElement(By.xpath("//div[@class='main-results']//a[@rank='" + rankNumber + "']"));
	}

	public WebElement topicTabTitleInactive(String tabTitle) {
		return waitForExpectedElement(By.xpath("//a[contains(@id,'tab')]/self::a[text()='" + tabTitle + "']"));
	}

	public WebElement topicTabTitleActive(String tabTitle) {
		return waitForExpectedElement(By.xpath("//div[contains(@class,'tab-selected')]//div[text()='" + tabTitle + "']"));
	}

	public WebElement relatedContentHeading(String headingText) {
		return waitForExpectedElement(By.xpath("//div[text()='Related content']/following-sibling::*/div[contains(@class,'heading')]/self::*[text()='" + headingText
				+ "']"));
	}

	public WebElement relatedContentTopic(String topicText) {
		return waitForExpectedElement(By.xpath("//div[text()='Related content']/following-sibling::*//a[contains(@href,'topic')]/self::*[text()='" + topicText + "']"));
	}

	public WebElement relatedContentLink(String linkText) {
		return waitForExpectedElement(By.xpath("//div[text()='Related content']/following-sibling::*//a[contains(@href,'relatedcontent')]/self::*[text()='" + linkText + "']"));
	}


	public WebElement browseBooksLink(String linkText) {
		return waitForExpectedElement(By.xpath("//h2[text()='Browse books']/..//a[contains(@href,'books')]/self::*[contains(text(),'" + linkText + "')]"));
	}

	public WebElement browseLeftHandLink(String linkText) {
		return waitForExpectedElement(By.xpath("//h2[text()='Browse']/..//a[contains(@class,'toggle')]/self::*[contains(text(),'" + linkText + "')]"));
	}

	public WebElement booksLink(String linkText) {
		return waitForExpectedElement(By.xpath("//a[contains(@href,'books')]/self::*[contains(text(),'" + linkText + "')]"));
	}

	public WebElement numberTopicsResources() {
		return waitForExpectedElement(By.xpath("//div[@id='search_results_info']/strong"));
	}

	public WebElement breadCrumbLink(String breadCrumbLinkToCheck) {
		if ("What's Market".equals(breadCrumbLinkToCheck)) {
			breadCrumbLinkToCheck = "s Market";
		}
		return waitForExpectedElement(By.xpath("//div[@id='PLC_Headers']/h2/a[contains(text(),'" + breadCrumbLinkToCheck + "')]"));
	}

	public WebElement pageFilter() {
		return waitForExpectedElement(By.xpath("//div[@id='main']//h2[contains(text(),'Filtered by:')]"));
	}

	public WebElement breadCrumbText() {
		return waitForExpectedElement(By.xpath("//div[@id='PLC_Headers']/h2"));
	}

	public WebElement topResultsTabs() {
		return waitForExpectedElement(By.id("tabs"));
	}

	public WebElement resultsListCompareButton() {
		return waitForExpectedElement(By.xpath("//input[contains(@id,'compare')]/self::*[@type='button']"));
	}

	public WebElement comparisonWhatsMarketCompareButton(
            String domain) {
        if (domain.toUpperCase().equals("US")){
            return waitForExpectedElement(By.xpath("//div[@class='x-panel-bbar']//table[contains(@class,'btn-wrap')]/self::table[not(contains(@class,'disabled'))]"));
        } else {
            // UK
            return waitForExpectedElement(By.xpath("//button[contains(@class,'btn-text')]/self::*[text()='Compare']"));
        }

	}

	public WebElement getPdfObject() {
		return waitForExpectedElement(By.id("outerContainer"));
	}
}

