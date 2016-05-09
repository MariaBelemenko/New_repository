package com.thomsonreuters.pagecreation.step_definitions;

import com.google.common.collect.Lists;
import com.thomsonreuters.pageobjects.common.CommonMethods;
import com.thomsonreuters.pageobjects.otherPages.NavigationCobalt;
import com.thomsonreuters.pageobjects.pages.ask.AskCategoryPage;
import com.thomsonreuters.pageobjects.pages.ask.AskFormPage;
import com.thomsonreuters.pageobjects.pages.pageCreation.AskPracticeAreaPage;
import com.thomsonreuters.pageobjects.pages.pageCreation.PLRssWidget;
import com.thomsonreuters.pageobjects.pages.plPlusKnowHowResources.KHResourcePage;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.TransformerUtils;
import org.hamcrest.Matchers;
import org.hamcrest.core.Is;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebElement;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.comparesEqualTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertTrue;


public class PracticeAreaAskPages extends BaseStepDef {

    AskPracticeAreaPage AskPracticeArea = new AskPracticeAreaPage();
    private CommonMethods commonMethods = new CommonMethods();
    PLRssWidget PApage  = new PLRssWidget();
    private AskCategoryPage askCategoryPage = new AskCategoryPage();
    private KHResourcePage resourcePage = new KHResourcePage();
    private AskFormPage askFormPage = new AskFormPage();
    private NavigationCobalt navigationCobalt = new NavigationCobalt();

    private String mainWindowHandle;
    private String askWindowHandle;

    @Given("^clicks on Ask link$")
    public void clicksonAsklink() throws Throwable {
        AskPracticeArea.askResourcesLink().click();
        PApage.RSSLegalUpdatePageLabel("Ask").isDisplayed();
    }

    @Then("^the ask disclaimer text '(.*)' is displayed on (.*) page$")
    public void the_ask_disclaimer_text_displayed_on_ask_Practice_area_page(String text, String pageName) throws Throwable {

            assertTrue("Disclaimer is Not displayed", askCategoryPage.askDisclaimerTextOnAskLandingPage(text).isDisplayed());

    }

    @Then("^Featured queries has \"(.*?)\" items showing post date and nos replies showning$")
    public void theUserVerifiesThatOnlySpecifiedAskResourceIsDisplayed(int noOfresources) throws Throwable {
        askCategoryPage.waitForPageToLoad();

        if(noOfresources != 0 && askCategoryPage.featuredQueries().size()<=10) {
            assertThat("The no of ask resource is NOT as expected. Actual : " + askCategoryPage.featuredQueries().size() + " Expected : " +noOfresources, askCategoryPage.featuredQueries().size(), comparesEqualTo(noOfresources));
            String ActualDate=null;

            for(int i=0;i<askCategoryPage.FQdatelist().size();i++) {
                assertThat("The Posted on : Text is not visible", askCategoryPage.FQdatelist().get(i).getText().contains("Posted on:"));
                ActualDate=askCategoryPage.FQdatelist().get(i).getText().substring(11);
                assertThat("Date format is not as Expected. Actual Date : "+ ActualDate,commonMethods.isDateInValidFormat(ActualDate, "dd MMMM YYYY"));
                if(askCategoryPage.FQCommentslist().get(i).getText().contains("reply") || askCategoryPage.FQCommentslist().get(i).getText().contains("replies")) {
                    assertTrue("The * reply message is not visible. Actual message :" + askCategoryPage.FQCommentslist().get(i).getText(), true);
                }
            }
        }
    }


    @Then("^Recent queries has 5 RecentItems items showing, post date and nos replies showning$")
    public void Recentquerieshas5RecentItemsitemsshowingpostdateandnosrepliesshowning() throws Throwable {
        askCategoryPage.waitForPageToLoad();
        askCategoryPage.recentQueriesTab().click();
        assertThat("The no of ask resource is NOT as expected. Actual : " + askCategoryPage.recentQueriesPanel().size() + " Expected : 5", askCategoryPage.recentQueriesPanel().size(), comparesEqualTo(5));
        String ActualDate=null;
        for(int i=0;i<askCategoryPage.RQdatelist().size();i++) {
            assertThat("The Posted on : Text is not visible", askCategoryPage.RQdatelist().get(i).getText().contains("Posted on:"));
            ActualDate=askCategoryPage.RQdatelist().get(i).getText().substring(11);
            assertThat("Date format is not as expected. Actual Date : " + ActualDate, commonMethods.isDateInValidFormat(ActualDate, "dd MMMM YYYY"));
            if(askCategoryPage.RQCommentslist().get(i).getText().contains("reply") || askCategoryPage.RQCommentslist().get(i).getText().contains("replies")) {
                assertThat("The * reply message is not visible"+ askCategoryPage.RQCommentslist().get(i).getText().contains("reply"),true);
            }
        }

    }

    @Then("^the user verifies that Our people widget is correctly displayed$")
    public void theUserVerifiesThatOurPeopleWidgetIsCorrectlyDisplayed() throws Throwable {
        askCategoryPage.waitForPageToLoadAndJQueryProcessing();
        assertThat("The Our People Widget is NOT displayed", askCategoryPage.askOurPeopleWidget().isDisplayed(), Is.is(true));
        String ourPeopleWidgetText = askCategoryPage.askOurPeopleWidget().getText().replaceAll("\\n", "");
        assertThat("The Our People Widget-Header does not contain Our people", ourPeopleWidgetText, Matchers.containsString("Our people"));
        assertThat("The Our People Widget-Content does not contain expected text", ourPeopleWidgetText, Matchers.containsString("Our quality starts with our people. Their job is to help you do yours"));
    }
    @And("^the user verifies that Head of PracticeArea Team for '(.*)' in Our people widget is '(.*)' and has a '(.*)' title$")
    public void the_user_verifies_that_Head_of_PracticeArea_Team_for_PA_in_Our_people_widget_contains_HeadOfPracticeArea_(String practiceArea, String headOfPaName, String jobTitle) throws Throwable {
        String ourPeopleWidgetText = askCategoryPage.askOurPeopleWidget().getText().replaceAll("\\n", "");
        assertThat("The Our People Widget-Head of Practice Area does nt contain correct name", ourPeopleWidgetText, Matchers.containsString(headOfPaName));
        assertThat("The Our People Widget-Head of Practice Area does nt contain correct text: Head of Practical Law " + practiceArea, ourPeopleWidgetText, Matchers.containsString(jobTitle));
    }

    @When("^Ask a question button is displayed$")
    public void Askaquestionbuttonisdisplayed() throws Throwable {
        resourcePage.askAQuestion().isDisplayed();
    }
    @When("^the user clicks on 'Ask a question' link to ask a question$")
    public void theUserClicksASKILinkToAskAQuestion() throws Throwable {
        mainWindowHandle = resourcePage.getWindowHandle();
        resourcePage.askAQuestion().click();
        resourcePage.waitForPageToLoad();
    }
    @Then("^ASK form is displayed in new window$")
    public void askFormIsDisplayedInNewWindow() throws Throwable {
        commonMethods.switchToOpenedWindow();
        askWindowHandle = askFormPage.getWindowHandle();
        assertThat("Ask form is not displayed", askFormPage.askFormPageTitle().isDisplayed(), Is.is(true));
    }
    @Then("^user closes the ASK window$")
    public void userClosesASKWindow() throws Throwable {
        closesASKWindow();
    }
    @After(order = 1, value = "@CloseAskWindow")
    public void closesASKWindow() throws Throwable {
        try {
            if (askWindowHandle != null && !askWindowHandle.equals(mainWindowHandle)) {
                askFormPage.close();
                commonMethods.switchToMainWindow();
                askWindowHandle = null;
            }
        } catch (NoSuchWindowException e) {
            LOG.info("Error occurred at switch window process", e);
        }
        navigationCobalt.navigateToPLUKPlus();
    }
}

