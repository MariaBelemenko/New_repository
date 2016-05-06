package com.thomsonreuters.pagecreation.step_definitions;

import com.thomsonreuters.pageobjects.common.CommonMethods;
import com.thomsonreuters.pageobjects.pages.ask.AskCategoryPage;
import com.thomsonreuters.pageobjects.pages.pageCreation.AskPracticeAreaPage;
import com.thomsonreuters.pageobjects.pages.pageCreation.PLRssWidget;
import com.thomsonreuters.pageobjects.pages.plPlusKnowHowResources.KHResourcePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.hamcrest.Matchers;
import org.hamcrest.core.Is;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.comparesEqualTo;
import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertTrue;


public class PracticeAreaAskPages extends BaseStepDef {

    AskPracticeAreaPage AskPracticeArea = new AskPracticeAreaPage();
    private CommonMethods commonMethods = new CommonMethods();
    PLRssWidget PApage  = new PLRssWidget();
    private AskCategoryPage askCategoryPage = new AskCategoryPage();
    private KHResourcePage resourcePage = new KHResourcePage();

    @Given("^clicks on \"(.*?)\" link$")
    public void clicksonlink() throws Throwable {
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
        assertThat("The no of ask resource is NOT expected", askCategoryPage.featuredQueries().size(), comparesEqualTo(noOfresources));
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


}

