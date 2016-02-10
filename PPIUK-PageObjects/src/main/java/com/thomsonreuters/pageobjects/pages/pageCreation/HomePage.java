package com.thomsonreuters.pageobjects.pages.pageCreation;

import com.thomsonreuters.driver.framework.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends AbstractPage {

    public WebElement practiceAreasTab() {
        return findElement(By.id("coid_categoryTab1_main_0"));
    }

    public WebElement resourcesTab() {
        return waitForExpectedElement(By.id("coid_categoryTab2_main_0"));
    }

    public WebElement internationalTab() {
        return waitForExpectedElement(By.id("coid_categoryTab3_main_0"));
    }

    public WebElement practiceAreasLink() {
        return waitForExpectedElement(By.linkText("Practice areas"));
    }

    public WebElement resourcesLink() {
        return waitForExpectedElement(By.linkText("Resources"));
    }

    public WebElement internationalLink() {
        return waitForExpectedElement(By.linkText("International"));
    }

    public WebElement askAQuestionLink() {
        return waitForExpectedElement(By.linkText("Ask a question"));
    }

    public WebElement whatsMarketLink() {
        return waitForExpectedElement(By.id("coid_what_s_market"));
    }

    public WebElement activeTab() {
        return waitForExpectedElement(By.cssSelector("ul[class='co_tabs co_categoryTabs'] li[class*='co_tabLeft co_tabActive']"));
    }

    public WebElement activeLink() {
        return waitForExpectedElement(By.cssSelector("a[class='browseMenu_parent menuSelected']"));
    }

    public WebElement getPracticeAreasBrowseMenuContainer() {
        return waitForExpectedElement(By.cssSelector("div[id='main-menu'] ul li[id='Practice areas'] div[id='menu-item-children']"));
    }

    private List<WebElement> getPracticeAreasWebElementLinks() {
        return mergeTwoWebElementList(By.cssSelector("div#coid_categoryBoxTab1SubPanel1-0-main div div ul li a"), By.cssSelector("div#coid_categoryBoxTab1SubPanel2-0-main div div ul li a"));
    }

    private List<WebElement> getTopicWebElementLinks() {
//        return waitAndFindElements(By.cssSelector("div[class='co_scrollWrapper co_categoryBoxTabContents'] #coid_categoryBoxTabPanel1 a"));
        return waitAndFindElements(By.cssSelector("div[class='co_scrollWrapper co_categoryBoxTabContents'] div[class*='co_tabHide co_tabShow'] a"));

//        return mergeTwoWebElementList(By.cssSelector("div#coid_categoryBoxTab1SubPanel1-0-main div div ul li a"), By.cssSelector("div#coid_categoryBoxTab1SubPanel2-0-main div div ul li a"));
    }

    private List<WebElement> mergeTwoWebElementList(By element1, By element2) {
        List<WebElement> paWebLinks = new ArrayList<WebElement>();
        List<WebElement> paWebLinksTab1 = waitForExpectedElements(element1);
        List<WebElement> paWebLinksTab2 = waitForExpectedElements(element2);
        paWebLinks.addAll(paWebLinksTab1);
        paWebLinks.addAll(paWebLinksTab2);

        return paWebLinks;
    }

    private List<WebElement> getPracticeAreasWebElementLinksInBrowseMenu() {
        return mergeTwoWebElementList(By.cssSelector("div[id='Practice areas0'] ul li a"), By.cssSelector("div[id='Practice areas1'] ul li a"));
    }

    public List<String> getPracticeAreasLinks() {
        return getOnlyLinkNamesFromWebElementList(getPracticeAreasWebElementLinks());
    }

    public List<String> getTopicsLinks() {
        return getOnlyLinkNamesFromWebElementList(getTopicWebElementLinks());
    }

    public List<String> getPracticeAreasLinksInBrowseMenu() {
        return getOnlyLinkNamesFromWebElementList(getPracticeAreasWebElementLinksInBrowseMenu());
    }

    private List<String> getOnlyLinkNamesFromWebElementList(List<WebElement> elementList) {
        List<String> links = new ArrayList<String>();
        for (WebElement webElementLink : elementList) {
            links.add(webElementLink.getText());
        }
        return links;
    }

    public WebElement legalUpdatesContentLink() {
        return waitForExpectedElement(By.id("coid_legal_updates"));
    }

    /**
     * Selects the Resource tab present on Home page.
     */
    public void selectResourceTab() {
        waitFluentForElement(By.linkText("Resources")).click();
    }

    /**
     * Selects the International tab present on Home page.
     */
    public void selectInternationalTab() {
        waitFluentForElement(By.linkText("International")).click();
    }

    /**
     * This method selects the link by given linkname.
     *
     * @param linkName
     */
    public void selectLinkPresentOnTab(String linkName) {
        waitFluentForElement(By.linkText(linkName)).click();
    }

    public WebElement selectAccessNowButtonForOpenWebBrowsing() {
        return waitForExpectedElement(By.linkText("Access now"));
    }

    public WebElement specificTab(String tabName) {
        return waitForElementPresent(By.xpath("//a[@class='co_tabLink' and text()='" + tabName + "']"));
    }

    public WebElement homePageStartComparingButton() {
        return waitForElementPresent(By.id("coid_start_comparing"));
    }

    public List<WebElement> selectQuestionsPageCheckboxList() {
        return waitForExpectedElements(By.xpath("//div[contains(@class,'co_comparisonTool')]//li//input[@type='checkbox']"));
    }

    public WebElement selectQPageSelectJurisdictionButton() {
        return waitForElementPresent(By.xpath("//div[@class='co_actionBtns']//a[normalize-space(.)='Select Jurisdictions']"));
    }

    public WebElement selectJurisdictionCheckbox(String countryName) {
        return waitForExpectedElement(By.xpath("//label[normalize-space(.)='" + countryName + "']//input"));
    }

    public WebElement jurisdictionPageCompareButton() {
        return waitForElementPresent(By.xpath("//div[@class='co_actionBtns']//a[normalize-space(.)='Compare']"));
    }

    public List<WebElement> comparePagCountryHeadingsList() {
        return waitForExpectedElements(By.xpath("//div[@id='co_docContentBody']//div[@class='co_headtext ng-binding']"));
    }

    public WebElement comparePageCountryEditButton() {
        return waitForElementPresent(By.id("jurisdictionEditButtonLink"));
    }

    public WebElement editPopupSaveChangesButton() {
        return waitForElementPresent(By.xpath("//div[@id='jurisdictionsPopup']//button[text()='Save Changes']"));
    }

    public WebElement comparePageLeftColumnCountryNameLink(String countryName) {
        return waitForExpectedElement(By.xpath("//ul[@class='kh_list']//input[@value='" + countryName + "']"));
    }

    public WebElement selectTopicPageTopicLink(String topicNameName) {
        return waitForExpectedElement(By.xpath("//div[@class='co_2Column']//li//a[normalize-space(.)='" + topicNameName + "']"));
    }

    public WebElement tabSubFeatureHeadings(String heading) {
        return waitForElementPresent(By.xpath("//h3[contains(.,'" + heading + "')]"));
    }

    public List<WebElement> getSelectedSectionLinks() {
        return waitAndFindElements(By.cssSelector(".co_featureBoxInner a"));
    }

    /**
     * Get element list with all links of currently selected tab
     *
     * @return List with tab links
     */
    public List<WebElement> getActiveTabLinks() {
        return waitAndFindElements(By.cssSelector(".co_categoryBoxTabContents > .co_tabShow a"));
    }

    /**
     * Get element for BrowseMenu International Link
     *
     * @return WebElement with tab links
     */
    public WebElement countryBrowseMenuLink(String country) {
        return waitAndFindElement(By.xpath("//a[@class='menu-item-link' and contains(text(),'" + country + "')]"));
    }

    /**
     * Get element for country on HomePage International tab
     *
     * @return WebElement with tab links
     */
    public WebElement countryLink(String country) {
        return waitAndFindElement(By.xpath("//a[contains(@id,'coid_" + country + "')]"));
    }

    /**
     * Get country label element for Global PL Country site
     *
     * @return WebElement with tab links
     */
    public WebElement globalPLCountrySiteLabel(String country) {
        return waitAndFindElement(By.xpath("//div[@id='top-level']//span[text()='" + country + "']"));
    }


    /**
     * Get country link on Browse Menu International sub-menu for International subscription
     *
     * @return WebElement with tab links
     */
    public WebElement internationalSubCountryLink(String country) {
        return waitAndFindElement(By.xpath("//div[@id='International1']//a[contains(text(),'" + country + "')]"));
    }

    /**
     * Get country header element for PL legacy China (etc.) site
     *
     * @return WebElement with tab links
     */

    public WebElement legacyPLCountryTitle(String country) {
        return waitAndFindElement(By.xpath("//div[@class='page-heading']//h1[normalize-space(text())='" + country + "']"));
    }
}