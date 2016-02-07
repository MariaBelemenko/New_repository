package com.thomsonreuters.fastdraft.step_definitions.users;

import com.thomsonreuters.fastdraft.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.pages.fastDraft.FormEPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FastDraftForOpenWebUsersTest extends BaseStepDef {

    private FormEPage formEpage = new FormEPage();

    @Then("^the user sees Sign On button with Sign On message$")
    public void checkSignOnButton() throws Throwable {
        formEpage.waitForPageToLoad();
        formEpage.waitForPageToLoadAndJQueryProcessing();
        formEpage.checkSignOnButtonWithMessagePresents();
    }

    @When("^the user clicks on Sign On button on Form E page$")
    public void clickSignOnButton() throws Throwable {
        formEpage.signOnButton().click();
        formEpage.waitForPageToLoad();
        resetCurrentUser();
    }

}
