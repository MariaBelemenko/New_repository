package com.thomsonreuters.fastdraft.step_definitions.users;

import com.thomsonreuters.fastdraft.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.pages.fastDraft.FormEPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FastDraftForPAUsersTest extends BaseStepDef {

    private FormEPage formEpage = new FormEPage();

    @Then("^the user sees Start here button with Start here message$")
    public void checkStartHereButton() throws Throwable {
        formEpage.waitForPageToLoad();
        formEpage.checkStartHereButtonWithMessagePresents();
    }

    @Then("^the user sees Upload button with Upload message$")
    public void checkUploadButton() throws Throwable {
        formEpage.waitForPageToLoad();
        formEpage.checkUploadButtonWithMessagePresents();
    }

    @When("^the user clicks link Form E user guide \"([^\"]*)\"$")
    public void clickFormEUserGuideOnFormEPage(String userGuideLink) {
        formEpage.waitForPageToLoad();
        formEpage.formEUserGuide(userGuideLink).click();
        formEpage.waitForPageToLoad();
    }

}
