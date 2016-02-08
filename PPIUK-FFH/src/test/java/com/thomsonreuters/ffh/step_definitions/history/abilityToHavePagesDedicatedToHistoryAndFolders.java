package com.thomsonreuters.ffh.step_definitions.history;

import com.thomsonreuters.ffh.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.pages.folders.HistoryTabs;
import com.thomsonreuters.pageobjects.pages.folders.ResearchOrganizerPage;
import cucumber.api.java.en.And;
import org.openqa.selenium.WebElement;

public class abilityToHavePagesDedicatedToHistoryAndFolders extends BaseStepDef {

    private ResearchOrganizerPage researchOrganizerPage = new ResearchOrganizerPage();

    @And("^All tabs present on History page$")
    public void historyTabsPresent() throws Throwable {
        for (HistoryTabs tabs : HistoryTabs.values()) {
            openHistoryTab(tabs);
        }
    }

    protected void openHistoryTab(HistoryTabs tab) {
        researchOrganizerPage.waitForPageToLoad();
        researchOrganizerPage.waitForPageToLoadAndJQueryProcessing();
        WebElement historyTabNonClicked = researchOrganizerPage.findElement(tab.getId());
        WebElement historyTabClicked = researchOrganizerPage.findElement(tab.getIdClickable());
        if (historyTabNonClicked.isDisplayed()) {
            historyTabNonClicked.click();
            researchOrganizerPage.waitForPageToLoadAndJQueryProcessing();
        }
        if (historyTabClicked.isDisplayed()) {
            researchOrganizerPage.waitForElementPresent(tab.getPageHeader());
        } else {
            throw new RuntimeException("History tab '" + tab.getName() + "' absent!");
        }
    }

}