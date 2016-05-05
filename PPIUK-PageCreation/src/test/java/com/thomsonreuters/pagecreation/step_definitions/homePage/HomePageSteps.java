package com.thomsonreuters.pagecreation.step_definitions.homePage;

import com.thomsonreuters.pagecreation.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.common.CommonMethods;
import com.thomsonreuters.pageobjects.common.PageActions;
import com.thomsonreuters.pageobjects.otherPages.NavigationCobalt;
import com.thomsonreuters.pageobjects.pages.generic.PPIGenericDocDisplay;
import com.thomsonreuters.pageobjects.pages.header.WLNHeader;
import com.thomsonreuters.pageobjects.pages.landingPage.PracticalLawHomepage;
import com.thomsonreuters.pageobjects.pages.pageCreation.HomePage;
import com.thomsonreuters.pageobjects.pages.search.SearchResultsPage;
import com.thomsonreuters.pageobjects.utils.document.StandardDocumentUtils;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.SoftAssertions;
import org.hamcrest.core.Is;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class HomePageSteps extends BaseStepDef{

    private NavigationCobalt navigationCobalt = new NavigationCobalt();
    private PracticalLawHomepage plcHomePage = new PracticalLawHomepage();
    private HomePage homePage = new HomePage();
    private WLNHeader wlnHeader = new WLNHeader();
    private StandardDocumentUtils standardDocumentUtils = new StandardDocumentUtils();
    private PageActions pageActions = new PageActions();
    private CommonMethods commonMethods = new CommonMethods();
    private PPIGenericDocDisplay ppiGenericDocDisplay = new PPIGenericDocDisplay();
    private SearchResultsPage searchResultsPage = new SearchResultsPage();
    //private RemoteWebDriver getDriver;

    public HomePageSteps() {
        wlnHeader = new WLNHeader();
        homePage = new HomePage();
    }

    @Then("^user can view three tabs: Practice Areas, Resources and International$")
    public void userCanViewThreeTabsPracticeAreasResourcesAndInternational() throws Throwable {
        assertTrue("The 'Practice Area' tab is NOT displayed ", homePage.practiceAreasTab().isDisplayed());
        assertTrue("The 'Resources' tab is NOT displayed ", homePage.resourcesTab().isDisplayed());
        assertTrue("The 'International' tab is NOT displayed ", homePage.internationalTab().isDisplayed());
    }

    @And("^the user verifies that default Tab is '(.*)'$")
    public void theUserVerifiesThatDefaultTabIsTab(String tabName) throws Throwable {
        assertTrue("The 'default' tab is NOT " + tabName, homePage.activeTab().getText().contains(tabName));
    }

    @And("^the user selects Tab '(.*)' if not alrdeay selected$")
    public void theUserselectsTab(String tabName) throws Throwable {
        if (!homePage.activeTab().getText().contains(tabName)) {
            homePage.waitForElementPresent(By.linkText("Topics")).click();
            homePage.waitForPageToLoad();
        }
    }

    @Given("^the user is on the home page$")
    public void aUserIsOnTheHomePage() throws Throwable {
        navigationCobalt.navigateToHomePage();
    }

    @When("^the user is in Page '(.*)'$")
    public void theUserIsInPage(String pages) throws Throwable {
        List<String> links = Arrays.asList(pages.split(">"));
        for (String link : links) {
            if (link.contains("/")) {
                navigationCobalt.navigateToRelativeURL(link);
                navigationCobalt.waitForPageToLoad();
            }
        }
    }

    @And("^the user is in page '(.*)' with page Title '(.*)'$")
    public void theUserIsInPageResourcecsBooksOnlineWithPageTitle(String pages, String expectedTitle) throws Throwable {
        List<String> links = Arrays.asList(pages.split(">"));
        for (String link : links) {
            if (link.contains("/")) {
                navigationCobalt.navigateToRelativeURL(link);
            } else {
                if (link.equalsIgnoreCase("Browse Menu")) {
                    wlnHeader.browseMenuButton().click();
                } else {
                    navigationCobalt.waitForElementPresent(By.linkText(link)).click();
                }
                navigationCobalt.waitForPageToLoad();
            }
        }
        assertTrue(wlnHeader.pageHeaderLabel().getText().equals(expectedTitle));
    }

    @Then("^the user verifies that following '(.*)' links are displayed$")
    public void theUserVerifiesThatFollowingLinksAreDisplayed(String tab, List<String> links) throws Throwable {
        if (tab.equalsIgnoreCase("Practice areas")) {
            List<String> linksRetrieved = homePage.getPracticeAreasLinks();
            for (String link : links) {
                assertTrue("The 'Practice areas' link " + link + " is NOT displayed", linksRetrieved.contains(link));
            }
        }
    }

    @Then("^the user verifies that corresponding '(.*)' links are displayed$")
    public void the_user_verifies_that_corresponding_Topics_links_are_displayed(List<String> topicLinks) throws Throwable {
        List<String> linksRetrieved = homePage.getTopicsLinks();
        for (String link : topicLinks) {
            link = link.replaceAll("@@", ",");
            assertTrue("The 'Topic' link " + link + " is NOT displayed", linksRetrieved.contains(link));
        }
    }

    @When("^the user clicks link '(.*)' on '(.*)' page$")
    public void theUserClicksLinkOnPage(String link, String page) throws Throwable {
        if (!link.equals("")) {
            if (page.contains("Browse")) {
                homePage.findChildElement(homePage.getPracticeAreasBrowseMenuContainer(), By.linkText((link))).click();
            } else {
                try {
                    homePage.waitForExpectedElement(By.linkText(link), 2).click();
                } catch (Exception e) {
                    homePage.waitForExpectedElement(By.partialLinkText(link), 5).click();
                }
            }
            Thread.sleep(2000);
            homePage.waitForPageToLoad();
        }
    }

    @Then("^the user verifies that link '(.*)' is  displayed on '(.*)'$")
    public void the_user_verifies_that_link_is_displayed_on_the_page(String link, String page) throws Throwable {
        assertTrue("The link " + link + " is NOT displayed on " + page, homePage.waitForExpectedElement(By.linkText(link)).isDisplayed());
    }

    @When("^the user selects practice area page '(.*)'$")
    public void theUserSelectsTopicPage(String link) throws Throwable {
        if(link.equalsIgnoreCase("Any")){
            List<WebElement> linkList = homePage.getTopicLinksList();
            assertFalse(linkList.isEmpty());
            linkList.get(ThreadLocalRandom.current().nextInt(0, linkList.size())).click(); //click random link
        }
        else {
            homePage.selectLinkPresentOnTab(link);
        }
        homePage.waitForPageToLoad();
    }

    @When("^the user click on the topic link '(.*)'$")
    public void theUserClickOnTheTopicLink(String link) throws Throwable {
        theUserSelectsTopicPage(link);
        if(searchResultsPage.getSearchFacets().isEmpty()){
            theUserClickOnTheTopicLink("Any");
        }
    }

    @Then("^the user verifies that the current PageTitle contains '(.*)'$")
    public void theUserVerifiesThatTheCurrentPageTitleContainsPageTitle(String pageTitle) throws Throwable {
        assertTrue("The Expected Page Title " + pageTitle + " is  NOT displayed", wlnHeader.pageHeaderLabel().getText().contains(pageTitle));
    }

    @Then("^user can view three links: Practice Areas, Resources and International$")
    public void userCanViewThreeLinksPracticeAreasResourcesAndInternational() throws Throwable {
        assertTrue("The 'Practice Area' link is NOT displayed ", homePage.practiceAreasLink().isDisplayed());
        assertTrue("The 'Resources' link is NOT displayed ", homePage.resourcesLink().isDisplayed());
        assertTrue("The 'International' link is NOT displayed ", homePage.internationalLink().isDisplayed());
    }

    @And("^the user verifies that default Link is '(.*)'$")
    public void theUserVerifiesThatDefaultLinkIs(String link) throws Throwable {
        assertTrue("The 'default' link is NOT " + link, homePage.activeLink().getText().contains(link));
    }

    @When("^the user clicks button 'Browse Menu' on the Home Page$")
    public void theUserClicksButtonBrowseMenuOnTheHomePage() throws Throwable {
        wlnHeader.browseMenuButton().click();
    }

    @Then("^the user verifies that following 'Practice areas' links are displayed in in menu 'Browse Menu' on the Home Page$")
    public void theUserVerifiesThatFollowingPracticeAreasLinksAreDisplayedInInMenuBrowseMenuOnTheHomePage(List<String> links) throws Throwable {
        List<String> linksRetrieved = homePage.getPracticeAreasLinksInBrowseMenu();
        for (String link : links) {
            assertTrue("The 'Practice areas' link " + link + " is NOT displayed in Browse Menu", linksRetrieved.contains(link));
        }
    }
     //Steps added by Ian and Sandy - The steps below are for checking the links in all of the tabs under the Browse Menu
    @Then("^the user clicks through the \"(.*?)\" links that are displayed in the 'Browse Menu' on the Home Page$")
    public void theUserClicksThroughTheTabLinksThatAreDisplayedInTheBrowseMenuOnTheHomePage(String subMenuLink, List<String> links) throws Throwable {
        Boolean isMenuDisplayed = false;
        String pageTitle = "";
        String linkToClick = "";
        String headerToFind = "";
        String stringToSplit[] ;


        homePage.browseMenuLink(subMenuLink).click();
        List<String> linksRetrieved = homePage.getLinksInBrowseMenu(subMenuLink);

        try{
            homePage.browseMenuPopUp().isDisplayed();
            isMenuDisplayed = true;
        }catch (Exception e){}

        if (!isMenuDisplayed) {
            wlnHeader.browseMenuButton().click();
        }

        //System.out.println("...Found " + Integer.toString(homePage.getLinksInBrowseMenu(subMenuLink).size()) + " links");

        for (String link : links) {

            //System.out.println("The current link being checked is: " + link);

            if (!link.contains(" ~ ")) {
                homePage.menuColumnLink(link).click();
            } else {
                stringToSplit=link.split(" ~ ");
                headerToFind=stringToSplit[0];
                linkToClick=stringToSplit[1] ;
                link=linkToClick;
                homePage.browseTabLinkAfterHeader(headerToFind,linkToClick).click();
            }
            assertTrue("The '" + subMenuLink + "' link " + link + " is NOT displayed in Browse Menu", linksRetrieved.contains(link));
            //homePage.browseMenuLink(subMenuLink).click();
            //homePage.menuColumnLink(link).click();
            pageTitle = ppiGenericDocDisplay.searchPageLabel().getText();
            Boolean testPass = false;
            if (link.toLowerCase().contains(pageTitle.toLowerCase())) {
                testPass = true;
            }
            if (pageTitle.toLowerCase().contains(link.toLowerCase())) {
                testPass = true;
            }
            //System.out.println("The link text is "+link+" and the page title is "+pageTitle);
            assertTrue(testPass);
            commonMethods.browserGoBack();
            wlnHeader.browseMenuButton().click();
            homePage.browseMenuLink(subMenuLink).click();
        }
    }

    @Then ("The user clicks the Browse button tab link \"(.*?)\"$")
    public void theUserClicksTheBrowseButtonTabLink (String subMenuLink) throws Throwable {
        Boolean isMenuDisplayed = false;

        try{
            homePage.browseMenuPopUp().isDisplayed();
            isMenuDisplayed = true;
        }catch (Exception e){}

        if (!isMenuDisplayed) {
            wlnHeader.browseMenuButton().click();
        }

        homePage.browseMenuLink(subMenuLink).click();
    }

    @Then ("The user clicks the Browse link \"(.*?)\"$")
    public void theUserClicksTheBrowseLink (String link) throws Throwable {
        String linkToClick = "";
        String headerToFind = "";
        String stringToSplit[] ;

        //System.out.println("The current link being checked is: " + link);

        if (!link.contains(" ~ ")) {
            homePage.menuColumnLink(link).click();
        } else {
            stringToSplit=link.split(" ~ ");
            headerToFind=stringToSplit[0];
            linkToClick=stringToSplit[1] ;

            //System.out.println("The link text is "+linkToClick);

            homePage.browseTabLinkAfterHeader(headerToFind,linkToClick).click();
        }
    }


    //Steps added by Ian and Sandy - The steps below are for checking the links in all of the tabs on the PL+ Home Page
    @Then("^the user clicks through the \"(.*?)\" links that are displayed on the Home Page$")
    public void theUserClicksThroughTheTabLinksThatAreDisplayedOnTheHomePage(String subMenuLink, List<String> links) throws Throwable {
        String pageTitle = "";
        String linkToClick = "";
        String headerToFind = "";
        String stringToSplit[] ;

        homePage.homepageTabHeadingLink(subMenuLink).click();

        List<String> linksRetrieved = homePage.getLinksInHomepageMainMenu();
        //System.out.println("...Found " + Integer.toString(homePage.getLinksInHomepageMainMenu().size()) + " links");
        for (String link : links) {
            //System.out.println("The current link being checked is: " + link);

            if (!link.contains(" ~ ")) {
                homePage.homepageTabLink(link).click();
            } else {
                stringToSplit=link.split(" ~ ");
                headerToFind=stringToSplit[0];
                linkToClick=stringToSplit[1] ;
                link=linkToClick;
                homePage.tabLinkAfterHeader(headerToFind,linkToClick).click();
            }
            assertTrue("The '" + subMenuLink + "' link " + link + " is NOT displayed in Browse Menu", linksRetrieved.contains(link));
            pageTitle = ppiGenericDocDisplay.searchPageLabel().getText();
            Boolean testPass = false;
            if (link.toLowerCase().contains(pageTitle.toLowerCase())) {
                testPass = true;
            }
            if (pageTitle.toLowerCase().contains(link.toLowerCase())) {
                testPass = true;
            }
            //System.out.println("The link text is "+link+" and the page title is "+pageTitle);
            assertTrue(testPass);
            commonMethods.browserGoBack();
            homePage.homepageTabHeadingLink(subMenuLink).isDisplayed();
            homePage.homepageTabHeadingLink(subMenuLink).click();
        }
    }

    //Steps added by Ian and Sandy
    @Then("^The user clicks the Home page tab link \"(.*?)\"$")
    public void theUserClicksTheHomePageTabLink (String tabLink) throws Throwable {
        homePage.homepageTabHeadingLink(tabLink).click();
    }


    //Steps added by Ian and Sandy
    @Then("^The user clicks link to \"(.*?)\"$")
    public void theUserClicksLinkTo(String link) throws Throwable {
        String linkToClick = "";
        String headerToFind = "";
        String stringToSplit[] ;

        //System.out.println("The current link being checked is: " + link);

        if (!link.contains(" ~ ")) {
            homePage.homepageTabLink(link).click();
        } else {
            stringToSplit=link.split(" ~ ");
            headerToFind=stringToSplit[0];
            linkToClick=stringToSplit[1] ;

            //System.out.println("The link text is "+linkToClick);

            homePage.tabLinkAfterHeader(headerToFind,linkToClick).click();
        }
    }

    //Steps added by Ian and Sandy
   @And("^The user verifies the resource page title is \"(.*?)\"$")
    public void theUserVerifiesTheResourcePageIsCorrect (String pageTitle) throws Throwable {
        String displayedTitle = ppiGenericDocDisplay.titleNoToc().getText();
        assertTrue(displayedTitle.equals(pageTitle));
       //System.out.println("The page title is "+pageTitle);
        commonMethods.browserGoBack();
       wlnHeader.browseMenuButton().click();
    }

    //Steps added by Ian and Sandy
    @And("^The user verifies the glossary page title is \"(.*?)\"$")
    public void theUserVerifiesTheGlossaryPageIsCorrect (String pageTitle) throws Throwable {
        String displayedTitle = ppiGenericDocDisplay.glossaryHeader().getText();
        assertTrue(displayedTitle.contains(pageTitle));
        //System.out.println("The page title is "+pageTitle);
        commonMethods.browserGoBack();
        wlnHeader.browseMenuButton().click();
    }

    //Steps added by Ian and Sandy
    @And("^The user verifies the PL page title is \"(.*?)\"$")
    public void theUserVerifiesThePLPageIsCorrect (String pageTitle) throws Throwable {
        String displayedTitle = ppiGenericDocDisplay.plGlobalHeader().getText();
        assertTrue(displayedTitle.contains(pageTitle));
        //System.out.println("The page title is "+pageTitle);
        commonMethods.browserGoBack();
        wlnHeader.browseMenuButton().click();
    }

    //Steps added by Ian and Sandy
    @And("^The user verifies the search page title is \"(.*?)\"$")
    public void theUserVerifiesTheSearchPageIsCorrect (String pageTitle) throws Throwable {
        String displayedTitle = ppiGenericDocDisplay.searchPageLabel().getText();
        assertTrue(displayedTitle.contains(pageTitle));
        //System.out.println("The page title is "+pageTitle);
        commonMethods.browserGoBack();
        wlnHeader.browseMenuButton().click();
    }

    @When("^the user '(is|is not)' presented with the cookie consent message$")
    public void theUserIsPresentedWithTheCookieConsentMessage(String arg1) throws Throwable {
        if (arg1.equalsIgnoreCase("is")) {
            assertTrue(plcHomePage.cookieConsentMessage().isDisplayed());
        } else if (arg1.equalsIgnoreCase("is not")) {
            List<WebElement> cookieMessage = getDriver().findElements(By.id("CookieConsentMessage"));
            assertTrue(cookieMessage.isEmpty());
        }
    }

    @When("^the user clicks on close button on the cookie consent message$")
    public void theUserClicksOnCloseButtonOnTheCookieConsentMessage() throws Throwable {
        plcHomePage.closeCookieConsentMessage();
    }

    @When("^the user clicks on the \"(.*?)\" link on the cookie consent message$")
    public void theUserClicksOnTheLinkOnTheCookieConsentMessage(String arg1) throws Throwable {
        plcHomePage.cookieConsentLink(arg1).click();
    }
    @When("^user navigates to the \"(.*?)\" tool by clicking \"(.*?)\" button using \"(.*?)\" tab on the homepage$")
    public void userNavigatesToTheToolByClickingButtonUsingTabOnTheHomepage(String arg1, String arg2, String tabName) throws Throwable {
        homePage.specificTab(tabName).click();
        homePage.homePageStartComparingButton().click();
    }

    @When("^user selects the topic \"(.*?)\"$")
    public void userSelectsTheTopicAndClicksOnLink(String topicName) throws Throwable {
        homePage.selectTopicPageTopicLink(topicName).click();
     }

    @When("^user selects first questions and clicks on \"(.*?)\" button$")
    public void userSelectsFirstTwoQuestionsAndClicksOnButton(String arg1) throws Throwable {
        homePage.selectQuestionsPageCheckboxList().get(0).click();
        homePage.selectQPageSelectJurisdictionButton().click();
    }

    @When("^user selects two following countries and clicks on \"(.*?)\" button$")
    public void userSelectsTwoFollowingCountriesAndClicksOnButton(String arg1, List<String> countryList) throws Throwable {
       for(String country : countryList){
           homePage.selectJurisdictionCheckbox(country).click();
       }
       homePage.jurisdictionPageCompareButton().click();
    }

    @When("^user sees the comparison page and clicks on the \"(.*?)\" button on L\\.H\\.S$")
    public void userSeesTheComparisonPageAndClicksOnTheButtonOnLHS(String edit) throws Throwable {
       homePage.comparePageCountryEditButton().click();
     }

    @Then("^user should see \"(.*?)\" popup with the list of countries$")
    public void userShouldSeePopupWithTheListOfCountries(String arg1) throws Throwable {
       Is.is(homePage.editPopupSaveChangesButton().isDisplayed());
    }

    @Then("^user selects the \"(.*?)\" country and save it\\.$")
    public void userSelectsTheCountryAndSaveIt(String country) throws Throwable {
        homePage.selectJurisdictionCheckbox(country).click();
        homePage.editPopupSaveChangesButton().click();
    }

    @Then("^user should see the \"(.*?)\" appearing on L\\.H\\.S column in the comparison tool and on the page$")
    public void userShouldSeeTheAppearingOnLHSColumnInTheComparisonToolAndOnThePage(String country) throws Throwable {
        Is.is(homePage.comparePageLeftColumnCountryNameLink(country).isDisplayed());

    }

    @Then("^the Practice Area section links are present and the first '(.*)' related links are valid for every PA section$")
    public void thePracticeAreaSectionLinksArePresentAndAllRelatedLinksAreValidForEveryPASection(int linksCountToCheck) {
        SoftAssertions softAssertions = new SoftAssertions();
        List<WebElement> sectionsLinks = homePage.getSelectedSectionLinks();
        for (WebElement sectionLink : sectionsLinks) {
            softAssertions.assertThat(standardDocumentUtils.isLinksAreValidInSection(sectionLink, linksCountToCheck))
                    .withFailMessage(standardDocumentUtils.getPracticeAreaLinksErrMsg())
                    .isTrue();
        }
        softAssertions.assertAll();
    }

}