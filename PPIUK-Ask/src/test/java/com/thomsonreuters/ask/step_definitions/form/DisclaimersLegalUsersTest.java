package com.thomsonreuters.ask.step_definitions.form;

import com.thomsonreuters.ask.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.pages.ask.AskFormPage;
import cucumber.api.java.en.Then;
import org.hamcrest.core.Is;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;

public class DisclaimersLegalUsersTest extends BaseStepDef {

    private AskFormPage askFormPage = new AskFormPage();

    @Then("^the legal disclaimer is displayed on the ASK form$")
    public void theLegalDisclaimerIsDisplayedOnTheASKForm() throws Throwable {
        assertTrue(askFormPage.disclaimerText().isDisplayed());
        assertTrue(askFormPage.disclaimerTermsCheckbox().isDisplayed());
    }

    @Then("^the user cannot view/submit the ASK form without agreeing to the disclaimer terms$")
    public void theUserCannotViewSubmitTheASKFormWithoutAgreeingToTheDisclaimerTerms() throws Throwable {
        assertThat(askFormPage.isAskFormDisplayed(), Is.is(false));
    }

}
