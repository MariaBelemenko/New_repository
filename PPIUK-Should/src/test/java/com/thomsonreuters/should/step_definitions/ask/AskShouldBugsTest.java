package com.thomsonreuters.should.step_definitions.ask;

import com.thomsonreuters.pageobjects.otherPages.NavigationCobalt;
import com.thomsonreuters.pageobjects.pages.ask.AskFormPage;
import com.thomsonreuters.pageobjects.utils.ask.AskFormField;
import com.thomsonreuters.pageobjects.utils.form.FormUtils;
import com.thomsonreuters.should.step_definitions.BaseStepDef;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.hamcrest.core.Is;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;

public class AskShouldBugsTest extends BaseStepDef {

    private NavigationCobalt navigationCobalt = new NavigationCobalt();
    private AskFormPage askFormPage = new AskFormPage();
    private FormUtils formUtils = new FormUtils();

    @When("^the user access the ASK form directly via url$")
    public void accessASKFormViaUrl() throws Throwable {
        navigationCobalt.navigateToPLCUKPlusSpecificURL("/askform");
    }

    @When("^user submits the ASK form$")
    public void userSubmitsTheASKForm() throws Throwable {
        askFormPage.submitButton().click();
        askFormPage.waitForPageToLoad();
    }

    @Then("^error message is displayed for user to complete the following fields$")
    public void errorMessageDisplayedToCompleteEmptyFields(List<String> requiredFields) throws Throwable {
        List<String> tempRequiredFields;
        if (requiredFields.size() == 1 && requiredFields.get(0).contains(",")) {
            tempRequiredFields = Arrays.asList(requiredFields.get(0).split(","));
        } else {
            tempRequiredFields = requiredFields;
        }
        for (String requiredField : tempRequiredFields) {
            AskFormField askFormField = AskFormField.getByFieldDisplayName(requiredField);
            assertThat("Required field '" + requiredField + "' is not marked with error message", askFormPage.findElement(askFormField.getErrorBy()).getText().trim(), Is.is(askFormField.getErrorMessage()));
        }
    }

    @When("^user completes the following ASK form fields$")
    public void userCompletesTheFollowingASKFormFields(DataTable dataTable) throws Throwable {
        for (Map.Entry<String, String> entry : dataTable.asMap(String.class, String.class).entrySet()) {
            formUtils.editValue(AskFormField.getByFieldDisplayName(entry.getKey()), entry.getValue());
        }
    }

}
