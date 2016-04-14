package com.thomsonreuters.ask.step_definitions.form;

import com.thomsonreuters.ask.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.pages.ask.AskFormPage;
import cucumber.api.java.en.Then;
import org.assertj.core.api.SoftAssertions;
import org.hamcrest.core.Is;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;

public class DisclaimersLegalUsersTest extends BaseStepDef {

    private AskFormPage askFormPage = new AskFormPage();

    @Then("^the legal disclaimer is displayed on the ASK form$")
    public void theLegalDisclaimerIsDisplayedOnTheASKForm() throws Throwable {
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions
                .assertThat(askFormPage.disclaimerText().isDisplayed())
                .withFailMessage("Disclaimer text is not displayed").isTrue();
        softAssertions
                .assertThat(askFormPage.disclaimerTermsCheckbox().isDisplayed())
                .withFailMessage("Accept terns checkbox is not displayed").isTrue();
        softAssertions.assertAll();
    }

    @Then("^the user cannot view/submit the ASK form without agreeing to the disclaimer terms$")
    public void theUserCannotViewSubmitTheASKFormWithoutAgreeingToTheDisclaimerTerms() throws Throwable {
        assertThat(askFormPage.isAskFormDisplayed(), Is.is(false));
    }

}
