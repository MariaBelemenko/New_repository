package com.thomsonreuters.khpadd.step_definitions.knowHowDocuments;

import com.thomsonreuters.khpadd.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.common.CommonMethods;
import com.thomsonreuters.pageobjects.pages.footer.FeedbackForm;
import com.thomsonreuters.pageobjects.pages.footer.FeedbackFormField;
import com.thomsonreuters.pageobjects.pages.footer.WLNFooter;
import com.thomsonreuters.pageobjects.pages.legalUpdates.LegalUpdatesTopicPage;
import com.thomsonreuters.pageobjects.pages.pageCreation.HomePage;
import com.thomsonreuters.pageobjects.utils.form.FormUtils;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.SoftAssertions;

import java.util.Map;

import static org.junit.Assert.assertTrue;

public class FeedbackTest extends BaseStepDef {

    private WLNFooter footer = new WLNFooter();
    private FormUtils formUtils = new FormUtils();
    private FeedbackForm feedbackForm = new FeedbackForm();
    private CommonMethods commonMethods = new CommonMethods();
    private HomePage homepage = new HomePage();
    private LegalUpdatesTopicPage legalUpdatesTopicPage = new LegalUpdatesTopicPage();

    @When("^user clicks on the Feedback link on the footer$")
    public void userClicksOnTheGivenLinkOnFooter() throws Throwable {
        footer.clickOnFeedBackLink();
    }

    @Then("^the user should see the following fields on Feedback form$")
    public void theUserShouldSeeFieldsOnFeedbackForm(DataTable dataTable) throws Throwable {
        SoftAssertions softly = new SoftAssertions();
        for (Map.Entry<String, String> entry : dataTable.asMap(String.class, String.class).entrySet()) {
            String value = null;
            try {
                value = formUtils.getValue(FeedbackFormField.getByFieldDisplayName(entry.getKey())).trim();
                softly.assertThat(value).contains(entry.getValue().trim())
                        .overridingErrorMessage("Value of field %s is not %s but %s", entry.getKey(), entry.getValue(), value);
            } catch (Exception e) {
                throw new Exception("Could not find or modify field '" + entry.getKey() + "'", e);
            }
        }
        softly.assertAll();
    }

    @When("^the user updates the following fields on Feedback form$")
    public void theUserUpdatesFieldsOnFeedbackForm(DataTable dataTable) throws Throwable {
        for (Map.Entry<String, String> entry : dataTable.asMap(String.class, String.class).entrySet()) {
            try {
                formUtils.editValue(FeedbackFormField.getByFieldDisplayName(entry.getKey()), entry.getValue());
            } catch (Exception e) {
                throw new Exception("Could not find or modify field '" + entry.getKey() + "'", e);
            }
        }
    }

    @When("^the user clicks on Submit button$")
    public void theUserClicksOnSubmitButton() throws Throwable {
        feedbackForm.submitButton().click();
    }

    @Then("^the feedback is submitted successfully$")
    public void theFeedbackIsSubmittedSuccessfully() throws Throwable {
        assertTrue("The feedback was successfully submitted".equalsIgnoreCase(commonMethods.getAlertDialogMsg()));
        commonMethods.acceptAlertDialogMsg();
    }

    @Given("^a user navigate to a \"(.*?)\" Topic page from a \"(.*?)\" Practice Area page$")
    public void aUserNavigateToATopicPageFromAPracticeAreaPage(String topicName, String paName) throws Throwable {
        homepage.selectLinkPresentOnTab(paName);
        homepage.waitForPageToLoad();
        legalUpdatesTopicPage.topicsLink(topicName).click();
        legalUpdatesTopicPage.waitForPageToLoad();
    }

    @When("^the user clicks on the Close icon on the feedback form$")
    public void theUserClicksOnTheCloseIconOnTheFeedbackForm() throws Throwable {
        feedbackForm.closeFeedBackForm();
    }

    @Then("^the user should be presented with a confirmation box$")
    public void theUserShouldBePresentedWithAConfirmationBox() throws Throwable {
        assertTrue("All changes will be lost. Do you really want to cancel feedback?".equalsIgnoreCase(commonMethods.getAlertDialogMsg()));
    }

    @Then("^feedback form should close when the user clicks the ok button$")
    public void feedbackFormShouldCloseWhenTheUserClicksTheOkButton() throws Throwable {
        commonMethods.acceptAlertDialogMsg();
    }

}
