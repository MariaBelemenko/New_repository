package com.thomsonreuters.legalupdate.step_definitions.email;

import com.thomsonreuters.legalupdate.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.pages.legalUpdates.EmailDeliverWidget;
import com.thomsonreuters.pageobjects.pages.legalUpdates.LegalUpdatesResultsPage;
import com.thomsonreuters.pageobjects.utils.email.MailinatorMethods;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertTrue;

public class DeliverToSelectedLUDocumentTest extends BaseStepDef {

    private LegalUpdatesResultsPage legalUpdatesResultsPage = new LegalUpdatesResultsPage();
    private EmailDeliverWidget emailDeliverWidget = new EmailDeliverWidget();
    private MailinatorMethods mailinatorMethods = new MailinatorMethods();

    private String emailSubject;

    private final String MAILINATOR_USER = "yuri123";
    private final String MAILINATOR_MAIL_ACCOUNT = "yuri123@mailinator.com";
    private final String SENDER_EMAIL = "noreply.practicallaw@thomsonreuters.com";

    @Given("^a user has selected the email delivery option$")
    public void aUserHasSelectedTheEmailDeliveryOption() throws Throwable {
        legalUpdatesResultsPage.specificLegalUpdateCheckBox(1).click();
        legalUpdatesResultsPage.emailIcon().click();
        legalUpdatesResultsPage.waitForPageToLoad();
    }

    @Given("^the user has configured their options on the email delivery lightbox$")
    public void theUserHasConfiguredTheirOptionsOnTheEmailDeliveryLightbox() throws Throwable {
        emailDeliverWidget.fillAddressInput(MAILINATOR_MAIL_ACCOUNT);
    }

    @When("^the user selects the 'Email' button$")
    public void theUserSelectsTheEmailButton() throws Throwable {
        emailSubject = emailDeliverWidget.subjectInput().getAttribute("value");
        emailDeliverWidget.emailButton().click();
        assertTrue("Email has not been sent ", emailDeliverWidget.isDeliveryInfoMessageTextDisplayed());
    }

    @Then("^the user should receive the selected documents in their specified email inbox$")
    public void theUserShouldReceiveTheSelectedDocumentsInTheirSpecifiedEmailInbox() throws Throwable {
        mailinatorMethods.navigateToMailinatorSite();
        assertTrue("Email has not been recieved ", mailinatorMethods.openEmailBoxAndcheckUserMail(MAILINATOR_USER, SENDER_EMAIL, emailSubject));
    }

    @Before("@EmailLegalUpdatesTest")
    public void cleanLegalUpdatesEmailBox() throws Throwable {
        mailinatorMethods.navigateToMailinatorSite();
        mailinatorMethods.openEmailBoxAndDeleteAllEmails(MAILINATOR_USER);
    }

}
