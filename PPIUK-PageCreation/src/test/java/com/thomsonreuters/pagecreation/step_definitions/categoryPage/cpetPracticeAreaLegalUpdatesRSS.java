package com.thomsonreuters.pagecreation.step_definitions.categoryPage;

import com.thomsonreuters.pagecreation.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.common.CommonMethods;
import com.thomsonreuters.pageobjects.pages.landingPage.PracticeAreaLandingPage;
import com.thomsonreuters.pageobjects.pages.pageCreation.PLRssWidget;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import static org.junit.Assert.assertTrue;


/**Phil Harper, SD file for tests for CPET Commercial Practice Area RSS/ Legal Updates "widget"
        * Created by U0162413 on 19/04/2016.
 */

public class cpetPracticeAreaLegalUpdatesRSS extends BaseStepDef {
    PLRssWidget PLRSS = new PLRssWidget();
    PracticeAreaLandingPage PLPracticeAreas = new PracticeAreaLandingPage();
    private CommonMethods commonMethods = new CommonMethods();

    @Then("^confirms the Legal Update Header is displayed$")
    public void confirmsTheLegalUpdateHeaderIsDisplayed() throws Throwable {
        PLRSS.RSSLegalUpdateHeader().isDisplayed();
    }

    @Then("^confirms the RSS icon is displayed$")
    public void confirmsTheRSSIconIsDisplayed() throws Throwable {
        PLRSS.RSSLegalUpdateRSSIcon().isDisplayed();
    }

    @Then("^clicks the RSS icon$")
    public void clickstheRSSicon() throws Throwable {
        PLRSS.RSSLegalUpdateRSSIcon().click();
    }

    @And("^the user verifies the resulting 'Subscribe to Practical Law updates via RSS' page$")
    public void theuserverifiestheresultingSubscribetoPracticalLawupdatesviaRSSpage() throws Throwable {
        PLRSS.RSSPLSubscribePLUpdatesRSS().isDisplayed();
    }

    @And("^the user clicks on the browser back button$")
    public void theUserClicksOnTheBrowserBackButtone() throws Throwable {
        commonMethods.browserGoBack();
    }

    @Then("^Content Block 0 is confirmed as being displayed$")
    public void ContentBlock0isconfirmedasbeingdisplayed() throws Throwable {
        PLRSS.RSSItemCB0().isDisplayed();
    }

    @Then("^All RSS/ Legal Updates are displayed for \"(.*?)\"$")
    public void AllRSSLegalUpdatesaredisplayedfor(String LegalUpdateHeading) throws Throwable {
        if (LegalUpdateHeading.length() == 0) {
            PLRSS.RSSItem("0").isDisplayed();
            PLRSS.RSSItem("1").isDisplayed();
            PLRSS.RSSItem("2").isDisplayed();
            PLRSS.RSSItem("3").isDisplayed();
            PLRSS.RSSItem("4").isDisplayed();
        } else PLRSS.RSSItemUsingHeading(LegalUpdateHeading, "0").isDisplayed();


    }

    @And("^verifies Each Legal Update below the heading \"(.*?)\" has a Date$")
    public void verifiesEachLegalUpdatehasaDate(String LegalUpdateHeading) throws Throwable {
        if (LegalUpdateHeading.length() == 0) {
            PLRSS.RSSItemUsingHeadingAndAssocDate(LegalUpdateHeading, "0").isDisplayed();
            PLRSS.RSSItemUsingHeadingAndAssocDate(LegalUpdateHeading, "1").isDisplayed();
            PLRSS.RSSItemUsingHeadingAndAssocDate(LegalUpdateHeading, "2").isDisplayed();
            PLRSS.RSSItemUsingHeadingAndAssocDate(LegalUpdateHeading, "3").isDisplayed();
            PLRSS.RSSItemUsingHeadingAndAssocDate(LegalUpdateHeading, "4").isDisplayed();
            assertTrue(PLRSS.RSSItemUsingHeadingAndAssocDate(LegalUpdateHeading, "0").getText().length() > 4);
            assertTrue(PLRSS.RSSItemUsingHeadingAndAssocDate(LegalUpdateHeading, "1").getText().length() > 4);
            assertTrue(PLRSS.RSSItemUsingHeadingAndAssocDate(LegalUpdateHeading, "2").getText().length() > 4);
            assertTrue(PLRSS.RSSItemUsingHeadingAndAssocDate(LegalUpdateHeading, "3").getText().length() > 4);
            assertTrue(PLRSS.RSSItemUsingHeadingAndAssocDate(LegalUpdateHeading, "4").getText().length() > 4);
        } else {
            PLRSS.RSSItemAndAssocDate("0").isDisplayed();
            PLRSS.RSSItemAndAssocDate("1").isDisplayed();
            PLRSS.RSSItemAndAssocDate("2").isDisplayed();
            PLRSS.RSSItemAndAssocDate("3").isDisplayed();
            PLRSS.RSSItemAndAssocDate("4").isDisplayed();
            assertTrue(PLRSS.RSSItemAndAssocDate("0").getText().length() > 4);
            assertTrue(PLRSS.RSSItemAndAssocDate("1").getText().length() > 4);
            assertTrue(PLRSS.RSSItemAndAssocDate("2").getText().length() > 4);
            assertTrue(PLRSS.RSSItemAndAssocDate("3").getText().length() > 4);
            assertTrue(PLRSS.RSSItemAndAssocDate("4").getText().length() > 4);
        }

    }

    @Then("^confirms the View All link at the foot of the RSS feed \"(.*?)\" is displayed$")
    public void confirmstheViewAlllinkatthefootoftheRSSfeedisdisplayed(String LegalUpdateHeading) throws Throwable {
        if (LegalUpdateHeading.length() == 0) {
            PLRSS.RSSLegalUpdateViewAllCompEU().isDisplayed();
            PLRSS.RSSLegalUpdateViewAllCompUK().isDisplayed();
        } else {
            PLRSS.RSSLegalUpdateViewAll().isDisplayed();
        }
    }

    @And("^clicks the View All link at the foot of the RSS feed \"(.*?)\"$")
    public void clickstheViewAlllink(String LegalUpdateHeading) throws Throwable {
        if (LegalUpdateHeading.length() == 0) {
            PLRSS.RSSLegalUpdateViewAllCompEU().click();
            PLRSS.RSSLegalUpdateViewAllCompUK().click();
        } else {
            PLRSS.RSSLegalUpdateViewAll().click();
        }
    }

    @And("^the resulting Practice Area page contains the associated Page Label \"(.*?)\"$")
    public void theresultingPracticeAreapagecontainstheassociatedPageLabel(String linkText) throws Throwable {
        PLRSS.RSSLegalUpdatePageLabel(linkText).isDisplayed();
    }

}