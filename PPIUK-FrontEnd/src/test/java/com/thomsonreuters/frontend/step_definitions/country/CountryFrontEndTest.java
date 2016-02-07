package com.thomsonreuters.frontend.step_definitions.country;

import com.thomsonreuters.frontend.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.pages.pageCreation.HomePage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.hamcrest.core.Is;

import java.util.List;

public class CountryFrontEndTest extends BaseStepDef {

    private HomePage homePage = new HomePage();

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
        for (String country : countryList) {
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

}
