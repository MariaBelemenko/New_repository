package com.thomsonreuters.ask.step_definitions.form;

import com.thomsonreuters.ask.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.otherPages.NavigationCobalt;
import com.thomsonreuters.pageobjects.pages.ask.AskFormPage;
import com.thomsonreuters.pageobjects.utils.ask.AskFormField;
import com.thomsonreuters.pageobjects.utils.form.FormUtils;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.hamcrest.core.Is;
import org.openqa.selenium.By;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;

public class AskFormOWUserTest extends BaseStepDef {

    private NavigationCobalt navigationCobalt = new NavigationCobalt();
    private FormUtils formUtils = new FormUtils();
    private AskFormPage askFormPage = new AskFormPage();

    @When("^the user navigates to the main PLCUK page$")
    public void theUserNavigatesToTheMainPLCUKPage() throws Throwable {
        navigationCobalt.navigateToPLUKPlus();
        navigationCobalt.waitForPageToLoad();
    }

    @Then("^the following fields are displayed on the form$")
    public void theFollowingFieldsAreDisplayedOnTheForm(List<String> fieldList) throws Throwable {
        for (String field : fieldList) {
            assertThat("Field " + field + " is displayed",
                    formUtils.findElement(AskFormField.getByFieldDisplayName(field)).isDisplayed(), Is.is(true));
        }
    }

    @Then("^Contact Details are indicated as required$")
    public void contactDetailsAreIndicatedAsRequired() throws Throwable {
        assertTrue("Contact Details label is not displayed", askFormPage.getContactDetailsLabel().isDisplayed());
    }

}
