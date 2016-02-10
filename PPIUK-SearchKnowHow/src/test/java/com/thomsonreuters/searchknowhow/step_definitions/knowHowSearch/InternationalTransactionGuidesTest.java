package com.thomsonreuters.searchknowhow.step_definitions.knowHowSearch;

import com.thomsonreuters.pageobjects.pages.landingPage.*;
import com.thomsonreuters.searchknowhow.step_definitions.BaseStepDef;
import cucumber.api.java.en.When;

public class InternationalTransactionGuidesTest extends BaseStepDef {

    private PracticalLawHomepage practicalLawHomepage = new PracticalLawHomepage();
    private InternationalLandingPage internationalLandingPage = new InternationalLandingPage();
    private GlobalGuidesLandingPage globalGuidesLandingPage = new GlobalGuidesLandingPage();
    private CountryQAToolPage countryQAToolPage = new CountryQAToolPage();
    private InternationalTransactionGuidesComparisonToolPage internationalTransactionGuidesComparisonToolPage = new InternationalTransactionGuidesComparisonToolPage();

    @When("^a user is on the ITG tool$")
    public void aUserIsOnTheITGTool() throws Throwable {
        practicalLawHomepage.internationalLink().click();
        internationalLandingPage.globalGuidesLink().click();
        globalGuidesLandingPage.startComparingLink().click();
        countryQAToolPage.internationalTransactionGuidesLink().click();
    }

    @When("^the user is presented with the Select a Topic section$")
    public void theUserIsPresentedWithTheSelectATopicSection() throws Throwable {
        internationalTransactionGuidesComparisonToolPage.selectTopicHeader().isDisplayed();
    }

    @When("^the user selects a topic \"([^\"]*)\"$")
    public void theUserSelectsATopic(String arg1) throws Throwable {
        internationalTransactionGuidesComparisonToolPage.topicLink(arg1).click();
    }

    @When("^the user should be presented with a list of questions including \"([^\"]*)\"$")
    public void theUserShouldBePresentedWithAListOfQuestionsIncluding(String arg1) throws Throwable {
        internationalTransactionGuidesComparisonToolPage.questionText(arg1).isDisplayed();
    }

    @When("^a user is presented with the Select a Question section including \"([^\"]*)\"$")
    public void aUserIsPresentedWithTheSelectAQuestionSection(String arg1) throws Throwable {
        practicalLawHomepage.internationalLink().click();
        internationalLandingPage.globalGuidesLink().click();
        /**
         * This is the country Q&A tool link
         */
        globalGuidesLandingPage.startComparingLink().click();
        countryQAToolPage.internationalTransactionGuidesLink().click();
        internationalTransactionGuidesComparisonToolPage.topicLink("Sponsorship").click();
        internationalTransactionGuidesComparisonToolPage.questionText(arg1).isDisplayed();
    }

    @When("^the user selects checkboxes for the questions \"([^\"]*)\" and \"([^\"]*)\"$")
    public void theUserSelectsCheckboxesForTheQuestionsAnd(String arg1, String arg2) throws Throwable {
        internationalTransactionGuidesComparisonToolPage.questionCheckbox(arg1).click();
        internationalTransactionGuidesComparisonToolPage.questionCheckbox(arg2).click();
    }

    @When("^the user clicks the Select Jurisdiction button$")
    public void theUserClicksTheSelectJurisdictionButton() throws Throwable {
        internationalTransactionGuidesComparisonToolPage.selectJurisdictionsLink().click();
    }

    @When("^the user should be presented with a list of jurisdictions including \"([^\"]*)\"$")
    public void theUserShouldBePresentedWithAListOfJurisdictionsIncluding(String arg1) throws Throwable {
        internationalTransactionGuidesComparisonToolPage.jurisdictionLabel(arg1).isDisplayed();
    }

    @When("^a user is on the select Jurisdiction section having selected \"([^\"]*)\" as the topic and \"([^\"]*)\" and \"([^\"]*)\" as the questions$")
    public void aUserIsOnTheSelectJurisdictionSectionHavingSelectedAsTheTopicAndAndAsTheQuestions(String arg1, String arg2, String arg3) throws Throwable {
        practicalLawHomepage.internationalLink().click();
        internationalLandingPage.globalGuidesLink().click();
        globalGuidesLandingPage.startComparingLink().click();
        countryQAToolPage.internationalTransactionGuidesLink().click();
        internationalTransactionGuidesComparisonToolPage.topicLink(arg1).click();
        internationalTransactionGuidesComparisonToolPage.questionCheckbox(arg2).click();
        internationalTransactionGuidesComparisonToolPage.questionCheckbox(arg3).click();
        internationalTransactionGuidesComparisonToolPage.selectJurisdictionsLink().click();
    }

    @When("^the user selects the jurisdictions \"([^\"]*)\" and \"([^\"]*)\"$")
    public void theUserSelectsTheJurisdictions(String arg1, String arg2) throws Throwable {
        internationalTransactionGuidesComparisonToolPage.jurisdictionCheckbox(arg1).click();
        internationalTransactionGuidesComparisonToolPage.jurisdictionCheckbox(arg2).click();
    }

    @When("^the user clicks the Compare button$")
    public void theUserClicksTheCompareButton() throws Throwable {
        internationalTransactionGuidesComparisonToolPage.compareLink().click();
    }

    @When("^the user should be presented with a comparison report which includes information based on the users selected topic the questions \"([^\"]*)\" and \"([^\"]*)\" and the jurisdictions \"([^\"]*)\" and \"([^\"]*)\"$")
    public void theUserShouldBePresentedWithAComparisonReportWhichIncludesInformationBasedOnTheUsersSelectedTopicTheQuestionsAndAndTheJurisdictionsAnd(String arg1, String arg2, String arg3, String arg4) throws Throwable {
        internationalTransactionGuidesComparisonToolPage.selectedCountry(arg3).isDisplayed();
        internationalTransactionGuidesComparisonToolPage.nonSelectedCountry(arg4).isDisplayed();
        internationalTransactionGuidesComparisonToolPage.question(arg1).isDisplayed();
        internationalTransactionGuidesComparisonToolPage.nextQuestionArrow().click();
        internationalTransactionGuidesComparisonToolPage.question(arg2).isDisplayed();
        internationalTransactionGuidesComparisonToolPage.allLink().isDisplayed();
    }

    @When("^a user is on the comparison report page which includes information based on the user having selected \"([^\"]*)\" as the topic along with the questions \"([^\"]*)\" and \"([^\"]*)\" and the jurisdictions \"([^\"]*)\" and \"([^\"]*)\"$")
    public void aUserIsOnTheComparisonReportPageWhichIncludesInformationBasedOnTheUserHavingSelectedAsTheTopicAlongWithTheQuestionsAndAndTheJurisdictionsAnd(String arg1, String arg2, String arg3, String arg4, String arg5) throws Throwable {
        practicalLawHomepage.internationalLink().click();
        internationalLandingPage.globalGuidesLink().click();
        globalGuidesLandingPage.startComparingLink().click();
        countryQAToolPage.internationalTransactionGuidesLink().click();
        internationalTransactionGuidesComparisonToolPage.topicLink(arg1).click();
        internationalTransactionGuidesComparisonToolPage.questionCheckbox(arg2).click();
        internationalTransactionGuidesComparisonToolPage.questionCheckbox(arg3).click();
        internationalTransactionGuidesComparisonToolPage.selectJurisdictionsLink().click();
        internationalTransactionGuidesComparisonToolPage.jurisdictionCheckbox(arg4).click();
        internationalTransactionGuidesComparisonToolPage.jurisdictionCheckbox(arg5).click();
        internationalTransactionGuidesComparisonToolPage.compareLink().click();
        internationalTransactionGuidesComparisonToolPage.selectedCountry(arg4).isDisplayed();
        internationalTransactionGuidesComparisonToolPage.nonSelectedCountry(arg5).isDisplayed();
        internationalTransactionGuidesComparisonToolPage.question(arg2).isDisplayed();
        internationalTransactionGuidesComparisonToolPage.nextQuestionArrow().click();
        internationalTransactionGuidesComparisonToolPage.question(arg3).isDisplayed();
        internationalTransactionGuidesComparisonToolPage.allLink().isDisplayed();
    }

    @When("^the user should be able to select the jurisdiction \"([^\"]*)\" to view$")
    public void theUserShouldBeAbleToSelectTheJurisdictionToView(String arg1) throws Throwable {
        internationalTransactionGuidesComparisonToolPage.nonSelectedCountry(arg1).click();
    }

    @When("^the user should be able to scroll through the selected questions \"([^\"]*)\" and \"([^\"]*)\"$")
    public void theUserShouldBeAbleToScrollThroughTheSelectedQuestions(String arg1, String arg2) throws Throwable {
        internationalTransactionGuidesComparisonToolPage.question(arg2).isDisplayed();
        internationalTransactionGuidesComparisonToolPage.nextQuestionArrow().click();
        internationalTransactionGuidesComparisonToolPage.question(arg1).isDisplayed();
        internationalTransactionGuidesComparisonToolPage.previousQuestionArrow().click();
        internationalTransactionGuidesComparisonToolPage.question(arg2).isDisplayed();
    }

}
