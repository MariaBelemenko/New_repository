package com.thomsonreuters.askRewrite.step_definitions;

import com.thomsonreuters.pageobjects.common.CommonMethods;
import com.thomsonreuters.pageobjects.otherPages.NavigationCobalt;
import com.thomsonreuters.pageobjects.pages.ask.AskFormPage;
import com.thomsonreuters.pageobjects.pages.plPlusKnowHowResources.KHResourcePage;
import com.thomsonreuters.pageobjects.utils.ask.AskFormField;
import com.thomsonreuters.pageobjects.utils.form.FormUtils;
import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.SoftAssertions;
import org.hamcrest.core.Is;
import org.openqa.selenium.NoSuchWindowException;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.text.IsEmptyString.isEmptyString;
import static org.junit.Assert.assertTrue;

public class TB2_Ask21_SubmitQuestionsViaAskFormOnPLplus extends BaseStepDef {

    private NavigationCobalt navigationCobalt = new NavigationCobalt();
    private AskFormPage askFormPage = new AskFormPage();
    private FormUtils formUtils = new FormUtils();
    private KHResourcePage resourcePage = new KHResourcePage();
    private CommonMethods commonMethods = new CommonMethods();

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
    @When("^the user accepts ASK disclaimer terms$")
    public void acceptsDisclaimerTerms() throws Throwable {

        askFormPage.disclaimerTermsCheckbox().click();
    }
    @When("^user completes the following ASK form fields$")
    public void userCompletesTheFollowingASKFormFields(DataTable dataTable) throws Throwable {
        for (Map.Entry<String, String> entry : dataTable.asMap(String.class, String.class).entrySet()) {
            formUtils.editValue(AskFormField.getByFieldDisplayName(entry.getKey()), entry.getValue());
        }
    }

    @When("^user submits the ASK form$")
    public void userSubmitsTheASKForm() throws Throwable {
        askFormPage.submitButton().click();
        askFormPage.waitForPageToLoad();
    }
    @When("^A thank you page should appear with option to close the window$")
    public void thankYouPage() throws Throwable {
        askFormPage.waitForPageToLoad();
        assertTrue("Thank you page is absent!", askFormPage.getPageSource().contains("Thank you for submitting a question or comment to Ask."));
    }

    @Then("^ASK form is displayed in new window$")
    public void askFormIsDisplayedInNewWindow() throws Throwable {
        commonMethods.switchToOpenedWindow();
        askWindowHandle = askFormPage.getWindowHandle();
        assertThat("Ask form is not displayed", askFormPage.askFormPageTitle().isDisplayed(), Is.is(true));
    }


    @Then("^user closes the ASK window$")
    public void userClosesASKWindow() throws Throwable {
        closesASKWindow();
    }

    @After(order = 1, value = "@CloseAskWindow")
    public void closesASKWindow() throws Throwable {
        try {
            if (askWindowHandle != null && !askWindowHandle.equals(mainWindowHandle)) {
                askFormPage.close();
                commonMethods.switchToMainWindow();
                askWindowHandle = null;
            }
        } catch (NoSuchWindowException e) {
            LOG.info("Error occurred at switch window process", e);
        }
        navigationCobalt.navigateToPLUKPlus();
    }

    @When("^the user clicks on 'Ask a question' link to ask a question$")
    public void theUserClicksASKILinkToAskAQuestion() throws Throwable {
        mainWindowHandle = resourcePage.getWindowHandle();
        resourcePage.askAQuestion().click();
        resourcePage.waitForPageToLoad();
    }

    @When("^the user clicks on ASK icon to ask a question$")
    public void theUserClicksASKIconToAskAQuestion() throws Throwable {
        mainWindowHandle = navigationCobalt.getWindowHandle();
        resourcePage.askAQuestion().click();
    }


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
