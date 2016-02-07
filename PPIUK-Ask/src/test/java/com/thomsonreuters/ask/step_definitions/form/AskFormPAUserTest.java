package com.thomsonreuters.ask.step_definitions.form;

import com.thomsonreuters.ask.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.otherPages.NavigationCobalt;
import com.thomsonreuters.pageobjects.pages.ask.AskFormPage;
import com.thomsonreuters.pageobjects.pages.plPlusKnowHowResources.KHResourcePage;
import com.thomsonreuters.pageobjects.utils.ask.AskFormField;
import com.thomsonreuters.pageobjects.utils.form.FormUtils;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.hamcrest.core.Is;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.text.IsEmptyString.isEmptyString;

public class AskFormPAUserTest extends BaseStepDef {

    private NavigationCobalt navigationCobalt = new NavigationCobalt();
    private AskFormPage askFormPage = new AskFormPage();
    private FormUtils formUtils = new FormUtils();
    private KHResourcePage resourcePage = new KHResourcePage();

    private String mainWindowHandle;
    private String askWindowHandle;

    @When("^the user access the ASK form directly via url$")
    public void accessASKFormViaUrl() throws Throwable {
        navigationCobalt.navigateToPLCUKPlusSpecificURL("/askform");
    }

    @Then("^the following ASK form fields are pre-populated$")
    public void fieldsArePrePopulatedOnTheAskForm(List<String> populatedFields) throws Throwable {
        askFormPage.waitForPageToLoad();
        for (String field : populatedFields) {
            AskFormField askFormField = AskFormField.getByFieldDisplayName(field);
            assertThat("The field '" + field + "' is not pre-populated", formUtils.getValue(askFormField),
                    not(isEmptyString()));
        }
    }

    @Then("^ASK form is displayed in new window$")
    public void askFormIsDisplayedInNewWindow() throws Throwable {
        resourcePage.waitForPageToLoad();
        int windowsCount;
        int counter = 10;
        do {
            windowsCount = resourcePage.getWindowHandles().size();
            counter--;
            Thread.sleep(1000);
        }
        while (windowsCount < 2 && counter > 0);
        assertThat("The no of popupWindows opened is less than 2", navigationCobalt.getWindowHandles().size(), greaterThanOrEqualTo(2));
        for (String windowHandle : navigationCobalt.getWindowHandles()) {
            if (!windowHandle.equalsIgnoreCase(mainWindowHandle)) {
                askWindowHandle = windowHandle;
                navigationCobalt.switchToWindow(askWindowHandle);
                assertThat("Ask form is not displayed", askFormPage.askFormPageTitle().isDisplayed(), Is.is(true));
            }
        }
    }

    @When("^the user clicks on ASK icon to ask a question$")
    public void theUserClicksASKIconToAskAQuestion() throws Throwable {
        mainWindowHandle = navigationCobalt.getWindowHandle();
        resourcePage.askAQuestion().click();
    }

    @Then("^the pre-populated email address cannot be edited$")
    public void thePrePopulatedEmailAddressCannotBeEdited() throws Throwable {
        assertThat(formUtils.findElement(AskFormField.EMAIL).getAttribute("readonly"), Is.is("true"));
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

}
