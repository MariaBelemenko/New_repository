package com.thomsonreuters.pageobjects.pages.header;

import com.thomsonreuters.driver.exception.PageOperationException;
import com.thomsonreuters.driver.framework.AbstractPage;
import com.thomsonreuters.pageobjects.common.PageActions;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;

import java.util.List;

public class WLNHeader extends AbstractPage {

    private PageActions pageActions;

    private final String USER_ICON_DROPDOWN = "//*[@id='preferences-dropdown']";

    public WLNHeader() {
        pageActions = new PageActions();
    }

    public WebElement signInLink() {
        return waitForExpectedElement(By.id("coid_website_signOffRegion"), 30);
    }

    public WebElement signOutLink() {
        return waitForExpectedElement(By.linkText("Sign out"));
    }

    public WebElement signInWithDifferentAccountLink() {
        return waitForExpectedElement(By.linkText("Sign in with a Different Account"), 30);
    }

    public WebElement pageHeaderLabel() {
        return waitForExpectedElement(By.id("co_browsePageLabel"));
    }

    public boolean isBrowseHeaderWithinPageHeader() {
        return isElementPresent(By.xpath("//div[@id='co_pageHeader']/div[contains(@class,'co_browseHeader')]"));
    }

    public WebElement header() {
        return waitForExpectedElement(By.id("header"));
    }

    public WebElement headerWidget() {
        return waitForExpectedElement(By.id("co_headerWrapper"));
    }

    public WebElement companyLogo() {
        return waitForExpectedElement(By.linkText("Practical Law"));
    }

    public WebElement folderViewAllLink() {
        return waitForExpectedElement(By.id("co_recentFoldersLink"));
    }

    public By menuByLink() {
        return By.id("menuLink");
    }

    public WebElement historyLink() {
        return waitForExpectedElement(By.linkText("History"), 10);
    }

    public WebElement favouritesLink() {
        return waitForExpectedElement(By.linkText("Favourites"), 10);
    }

    public WebElement historyArrowLink() {
        return waitForExpectedElement(By.linkText("Recent History"));
    }

    public WebElement historyRecentDocSubTitle() {
        return waitForElementVisible(By.xpath("//h3[@class='co_recentDocumentsHeader' and contains(text(),'Recent Documents')]"));
    }

    public WebElement historyRecentSearchesSubTitle() {
        return waitForElementVisible(By.xpath("//h3[@class='co_recentSearchesHeader' and contains(text(),'Recent Searches')]"));
    }

    public WebElement historySearchViewAllLink() {
        return waitForElementVisible(By.id("co_recentSearchesLink"));
    }

    public By historySearchViewAllByLink() {
        return By.id("co_recentSearchesLink");
    }

    public WebElement historyDocViewAllLink() {
        return waitForElementVisible(By.id("co_recentDocumentsLink"));
    }

    public WebElement foldersLink() {
        return waitForElementVisible(By.linkText("Folders"));
    }

    public WebElement foldersArrowLink() {
        return waitForElementVisible(By.xpath("//li[@id='co_recentFoldersContainer']//a[contains(@title,'Recent Folders')]"));
    }

    public WebElement foldersRecentFoldersSubTitle() {
        return waitForElementVisible(By.xpath("//div[@id='co_recentFolders']//h3[text()='Recent Folders']"));
    }

    public List<WebElement> foldersRecentFoldersLinks() {
        return waitForElementsVisible(By.xpath("//ul[@id='co_recentFoldersList']//li//a"));
    }

    public By foldersRecentFoldersByLink() {
        return By.xpath("//ul[@id='co_recentFoldersList']//li//a");
    }

    public WebElement alertsLink() {
        return waitForExpectedElement(By.xpath("//div[@id='alerts-dropdown']//a[text()=' Alerts']"));
    }

    public WebElement alertsCenterSubLink() {
        return waitForExpectedElement(By.xpath("//li[@id='user_alerts']//a[text()='Alerts Center']"));
    }

    public WebElement usernameLink() {
        return waitForExpectedElement(By.xpath("//li[@id='user_preferences']//span[contains(@class,'icon_user')]"));
    }

    public By usernameByLink() {
        return By.xpath("//div[@id='preferences-dropdown']//a[contains(@title,'preferences')]");
    }

    public WebElement editProfileSubLink() {
        return waitForElementVisible(By.xpath("//ul[@class='pluk-dropdownOpen']//a[text()='Edit Profile']"));
    }

    public WebElement signOutSubLink() {
        return waitForExpectedElement(By.xpath("//div[@class='co_dropDownMenuContent']//a[text()='Sign out']"));
    }

    public WebElement userNamePopup() {
        return waitForExpectedElement(By.xpath("//li[@id='user_preferences']//ul[@class='co_dropDownMenuList']"));
    }

    public List<WebElement> topRightCornerLinks() {
        return waitForExpectedElements(By.xpath("//ul[@id='co_globalNav']//li//a"));
    }

    public WebElement historyHeadingTitle() {
        return waitForElementVisible(By.xpath("//h1[@class='co_historyTitle']"));
    }

    public By historyHeadingByTitle() {
        return By.xpath("//h1[@class='co_historyTitle']");
    }

    public WebElement folderHeadingTitle() {
        return waitForElementVisible(By.xpath("//h1[@class='co_folderTitle']"));
    }

    public WebElement alertsHeadingTitle() {
        return waitForExpectedElement(By.xpath("//div[@id='co_alertCenter']//h2[text()='Alerts']"));
    }

    public WebElement alertsPopup() {
        return waitForExpectedElement(By.xpath("//li[@id='user_alerts']//ul[@class='co_dropDownMenuList']"));
    }

    public WebElement usernameIcon() {
        return waitForExpectedElement(By.xpath("//li[@id='user_preferences']//span[contains(@class,'th_flat_icon icon_user')]"));
    }

    public WebElement browseMenuButton() {
        return waitForExpectedElement(By.id("browseMenu"));
    }

    public WebElement browseMenuPopup() {
        return waitForExpectedElement(By.id("content-areas"));
    }

    public List<WebElement> browseMenuSubMenuList() {
        return waitForExpectedElements(By.xpath("//div[@id='main-menu']/ul/li"));
    }

    public List<WebElement> practiceAreaFirstColumnLinks() {
        return waitForExpectedElements(By.xpath("//div[@id='Practice areas0']//ul//li"));
    }

    public List<WebElement> resourcesFirstColumnLinks() {
        return waitForExpectedElements(By.xpath("//div[@id='Resources0']//ul//li"));
    }

    public List<WebElement> internationalFirstColumnLinks() {
        return waitForExpectedElements(By.xpath("//div[@id='International0']//ul//li"));
    }

    public WebElement searchGuideIcon() {
        return waitForExpectedElement(By.xpath("//div[@class='co_textarea']//a[contains(@class,'co_scopeIcon')]"));
    }

    public WebElement searchGuideCloseButton() {
        return waitForExpectedElement(By.xpath("//div[contains(@class,'co_infoBox')]//a[text()='Close']"));
    }

    public WebElement clientIdLink(String defaultClientID) {
        expandUserAvatarDropDown();
        return retryingFindElement(By.linkText(defaultClientID));
    }

    public WebElement clientIdLink() {
        expandUserAvatarDropDown();
        return retryingFindElement(By.id("co_clientID_recent_0"));
    }

    public WebElement clientIdLinkInPopUp(String clientID) {
        return retryingFindElement(By.linkText(clientID));
    }

    public List<WebElement> recentClientIdLinks() {
        return retryingFindElements(By.xpath("//ul[@id='co_clientID_recents']/li/a"));
    }

    public WebElement recentClientIdList() {
        return retryingFindElement(By.id("co_clientID_recents"));
    }

    public WebElement clientIdInput() {
        return waitForExpectedElement(By.id("co_clientIDTextbox"));
    }

    public WebElement clientIdChangeButton() {
        return waitForExpectedElement(By.id("co_clientIDContinueButton"));
    }

    public WebElement clientIdCloseButton() {
        return waitForExpectedElement(By.id("co_clientID_close_0"));
    }

    public void changeClientID(String clientID) {
        clientIdInput().clear();
        clientIdInput().sendKeys(clientID);
        clientIdChangeButton().click();
        waitForPageToLoadAndJQueryProcessing();
    }

    public boolean isFavoritesLinkPresent() {
        try {
            return favouritesLink().isDisplayed();
        } catch (PageOperationException poe) {
            LOG.info("context", poe);
            return false;
        }
    }

    public boolean isHistoryLinkPresent() {
        try {
            return historyLink().isDisplayed();
        } catch (PageOperationException poe) {
            LOG.info("context", poe);
            return false;
        }
    }

    public boolean isFoldersLinkPresent() {
        try {
            return foldersLink().isDisplayed();
        } catch (NoSuchElementException | NullPointerException poe) {
            LOG.info("context", poe);
            return false;
        }
    }

    public boolean isDefaultClientIdLinkPresent(String defaultClientID) {
        try {
            return clientIdLink(defaultClientID).isDisplayed();
        } catch (PageOperationException | NoSuchElementException poe) {
            LOG.info("context", poe);
            return false;
        }
    }

    public boolean isSignInLinkPresent() {
        try {
            return signInLink().isDisplayed();
        } catch (TimeoutException | NoSuchElementException nse) {
            LOG.info("context", nse);
            return false;
        }

    }

    public WebElement expandedUserPreferencesDropDownMenu() {
        return retryingFindElement(By.xpath("//li[@id='user_preferences']//div[@class='co_dropDownMenu th_flat js_dropDownMenu expanded']"));
    }

    public boolean isExpandedUserPreferencesDropDownMenu() {
        try {
            return expandedUserPreferencesDropDownMenu().isDisplayed();
        } catch (PageOperationException poe) {
            return false;
        }
    }

    public void signInWithDifferentAccount() {
        if (!isExpandedUserPreferencesDropDownMenu()) {
            expandUserAvatarDropDown();
        }
        signInWithDifferentAccountLink().click();
    }

    public void openEmailPreferences() {
        if (!isExpandedUserPreferencesDropDownMenu()) {
            expandUserAvatarDropDown();
        }
        waitForExpectedElement(By.linkText("Email preferences")).click();
    }

    public void signOff() {
        if (!isExpandedUserPreferencesDropDownMenu()) {
            expandUserAvatarDropDown();
        }
        signOutLink().click();
    }

    public void goToUpdateExistingProfilePage() {
        if (!isExpandedUserPreferencesDropDownMenu()) {
            expandUserAvatarDropDown();
        }
        editProfileLink().click();
    }

    public WebElement editProfileLink() {
        return findElement(By.linkText("Edit profile"));
    }

    public boolean isEditProtfileLinkPresent() {
        try {
            return editProfileLink().isDisplayed();
        } catch (TimeoutException | NoSuchElementException nse) {
            LOG.info("context", nse);
            return false;
        }

    }

    public void myFastDraft() {
        waitForPageToLoad();
        waitForExpectedElement(By.xpath(USER_ICON_DROPDOWN));
        expandUserAvatarDropDown();
        waitForExpectedElement(By.xpath("//a[text()='My FastDraft']")).click();
        waitForPageToLoad();
    }

    public void checkMyFastDraftAbsents() {
        WebElement button = null;
        try {
            pageActions.mouseOver(getDriver.findElement(By.xpath(USER_ICON_DROPDOWN)));
            button = findElement(By.xpath("//a[text()='My FastDraft']"));
            button.isDisplayed();
        } catch (NoSuchElementException e) {
            LOG.info("context", e);
            LOG.info("My FastDraft link absent");
            return;
        }
        throw new RuntimeException("My FastDraft link presents in the header");
    }

    public void expandUserAvatarDropDown() {
        pageActions.mouseOver(waitForExpectedElement(By.xpath(USER_ICON_DROPDOWN), 5));
    }

    public WebElement userAvatarIcon() {
        return waitForExpectedElement(By.xpath(USER_ICON_DROPDOWN), 2);
    }

    public WebElement userPreferencesDropdown(String selectLink) {
        return waitForExpectedElement(By.xpath("//div[@class='co_dropDownMenuContent']//a[text()='" + selectLink + "']"));
    }

    /**
     * For the L.H.S characters list in the Connectors
     */
    public List<WebElement> connectorsCharactersList() {
        return retryingFindElements(By.xpath("//dl[@id='co_search_advancedSearch_tncLegendList']//dt"));
    }

    /**
     * For the R.H.S explanation list in the Connectors
     */
    public List<WebElement> connectorsExplanationList() {
        return retryingFindElements(By.xpath("//dl[@id='co_search_advancedSearch_tncLegendList']//dd"));
    }

    /**
     * Heading for the email preferences page
     */
    public WebElement emailPreferencesHeading() {
        return waitForExpectedElement(By.xpath("//div[@id='co_pageHeader']//h1"));
    }

    /**
     * Heading for the by email preferences page
     */
    public By emailPreferencesByHeading() {
        return By.xpath("//div[@id='co_pageHeader']//h1");
    }

    /**
     * Country Toggle Dropdown Link
     */
    public WebElement countryToggleDropdownLink() {
        return waitForExpectedElement(By.xpath("//div[@id='regions-dropdown']//a"));
    }

    /**
     * Country Toggle Dropdown Link
     */
    public List<WebElement> countryDropdownMenuLinks() {
        return waitForExpectedElements(By.xpath("//li[@id='regions']//ul[contains(@class,'co_dropDownMenuList')]//li/a"));
    }

    public WebElement countryLink(String countryName) {
        return waitForExpectedElement(By.linkText(countryName));
    }

    /**
     * Get element list with all links of selected section in browse menu
     *
     * @return List with elements
     */
    public List<WebElement> getActiveSectionLinks() {
        return waitAndFindElements(By.xpath("//div[contains(@class, 'children') and not(contains(@class, 'hide'))]//a"));
    }

    /**
     * Browse drop-down menu by element
     */
    public By browseMenuByPopup() {
        return By.id("content-areas");
    }

    /**
     * Get the drop-down element on Time-Zone popup
     *
     * @return WebElement
     */
    public WebElement timeZoneSelectDropdown() {
        return waitForExpectedElement(By.id("coid_userSettingsTimeZoneOption"));
    }

    /**
     * Get the Save button element on Time-Zone popup
     *
     * @return WebElement
     */
    public WebElement timeZoneSaveButton() {
        return waitForExpectedElement(By.id("coid_userSettingsSave"));
    }

    /**
     * Get the Close button element on Time-Zone popup
     *
     * @return WebElement
     */
    public WebElement timeZoneCloseButton() {
        return waitForExpectedElement(By.id("coid_userSettingsSave"));
    }

    /**
     * Get the time-zone by popup
     *
     * @return WebElement
     */
    public By timeZoneByPopup() {
        return By.id("co_userSettingsTabPanels");
    }

}