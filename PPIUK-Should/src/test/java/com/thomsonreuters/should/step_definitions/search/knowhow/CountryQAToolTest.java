package com.thomsonreuters.should.step_definitions.search.knowhow;

import com.thomsonreuters.pageobjects.pages.landingPage.CountryQAToolPage;
import com.thomsonreuters.pageobjects.pages.landingPage.GlobalGuidesLandingPage;
import com.thomsonreuters.pageobjects.pages.landingPage.InternationalLandingPage;
import com.thomsonreuters.pageobjects.pages.landingPage.PracticalLawHomepage;
import com.thomsonreuters.should.step_definitions.BaseStepDef;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertTrue;

public class CountryQAToolTest extends BaseStepDef {

    private PracticalLawHomepage practicalLawHomepage = new PracticalLawHomepage();
    private InternationalLandingPage internationalLandingPage = new InternationalLandingPage();
    private GlobalGuidesLandingPage globalGuidesLandingPage = new GlobalGuidesLandingPage();
    private CountryQAToolPage countryQAToolPage = new CountryQAToolPage();

    @When("^the user views a document in Country QA$")
    public void theUserViewsADocumentInCountryQA() throws Throwable {
        practicalLawHomepage.internationalLink().click();
        internationalLandingPage.globalGuidesLink().click();
        globalGuidesLandingPage.startComparingLink().click();
        countryQAToolPage.topicLinks("Arbitration").click();
        countryQAToolPage.selectAllCheckbox().click();
        countryQAToolPage.selectJurisdictionsButton().click();
        countryQAToolPage.selectAllCheckbox().click();
        countryQAToolPage.compareButton().click();
    }

    @Then("^the author name is displayed as a link$")
    public void theAuthorNameIsDisplayedAsAlink() throws Throwable {
        countryQAToolPage.authorNameLink().isDisplayed();
    }

    @When("^the user selects the author link$")
    public void theUserSelectsTheAuthorLink() throws Throwable {
        countryQAToolPage.authorNameLink().click();
    }

    @Then("^the user is able to view a photograph and biography of the author$")
    public void theUserIsAbleToViewAPhotographAndBiographyOfTheAuthor() throws Throwable {
        countryQAToolPage.authorPhoto().isDisplayed();
        countryQAToolPage.authorBio().isDisplayed();
    }

    @When("^the user clicks link for \"(.*?)\"$")
    public void theUserClicksLinkForCountry(String country) throws Throwable {
        countryQAToolPage.countryNameLink(country).click();
        assertTrue("Element is not selected",countryQAToolPage.countryNameLink(country).getAttribute("class").equals("selectedButton"));
    }

}