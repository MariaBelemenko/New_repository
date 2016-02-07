package com.thomsonreuters.ask.step_definitions.common;

import com.thomsonreuters.ask.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.common.ExcelFileReader;
import com.thomsonreuters.pageobjects.otherPages.NavigationCobalt;
import com.thomsonreuters.pageobjects.pages.ask.AskFormPage;
import com.thomsonreuters.pageobjects.pages.plPlusKnowHowResources.KHResourcePage;
import com.thomsonreuters.pageobjects.utils.ask.AskFormField;
import com.thomsonreuters.pageobjects.utils.email.MailinatorMethods;
import com.thomsonreuters.pageobjects.utils.form.FormUtils;
import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.Map;

import static org.junit.Assert.assertTrue;

public class ThankYouEmailTest extends BaseStepDef {

    private KHResourcePage resourcePage = new KHResourcePage();
    private AskFormPage askFormPage = new AskFormPage();
    private FormUtils formUtils = new FormUtils();
    private NavigationCobalt navigationCobalt = new NavigationCobalt();
    private MailinatorMethods mailinatorMethods = new MailinatorMethods();

    private String mainWindowHandle;
    private String askWindowHandle;

    @When("^the user clicks on 'Ask a question' link to ask a question$")
    public void theUserClicksASKILinkToAskAQuestion() throws Throwable {
        mainWindowHandle = resourcePage.getWindowHandle();
        resourcePage.askAQuestion().click();
        resourcePage.waitForPageToLoad();
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
        if(!askFormPage.getPageSource().contains("Thank you for submitting a question or comment to Ask.")) {
            throw new RuntimeException("Thank you page is absent!");
        }
    }

    @Then("^user closes the ASK window$")
    public void userClosesASKWindow() throws Throwable {
        closesASKWindow();
    }

    @After(order = 100000, value = "@CloseAskWindow")
    public void closesASKWindow() throws Throwable {
        if (null != askWindowHandle) {
            askFormPage.switchToWindow(askWindowHandle);
            askFormPage.close();
            askFormPage.switchToWindow(mainWindowHandle);
            askWindowHandle = null;
        }
        navigationCobalt.navigateToPLUKPlus();
    }

    @Then("^'(.+)' should receive Thanks You email from '(.+)' in specified email inbox$")
    public void checkFolderSharingInvitation(String userName, String sender) throws Throwable {
        mailinatorMethods.navigateToMailinatorSite();
        String recipient = ExcelFileReader.getCobaltEmail(userName);
        String emailSubject = "Practical Law - Thank you for your query";
        assertTrue("Email has not been recieved ",
                mailinatorMethods.openEmailBoxAndcheckUserMail(recipient, sender, emailSubject));
    }

}
