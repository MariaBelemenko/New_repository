package com.thomsonreuters.searchwhatsmarket.step_definitions.whatsMarketDelivery;

import com.thomsonreuters.pageobjects.common.MailinatorMethods;
import com.thomsonreuters.pageobjects.pages.common.CommonMailinatorPage;
import com.thomsonreuters.searchwhatsmarket.step_definitions.BaseStepDef;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class MailinatorTest extends BaseStepDef {

    private MailinatorMethods mailinatorMethods = new MailinatorMethods();
    String emailAccountSetup = "";

    @Then("^the user sets up a Mailinator e-mail with the name \"([^\"]*)\"$")
    public void theUserSetsUpAMailinatorEmailWithTheName(String emailAccount) throws Throwable {
        emailAccountSetup = emailAccount;
    }

    @Then("^the user navigates to the Mailinator e-mail \"([^\"]*)\"$")
    public void theUserNavigatesToTheMailinatorEmail(String emailURL) throws Throwable {
        mailinatorMethods.navigatesToMailinatorEmail(emailURL);
    }

    @Then("^the user refreshes the Mailinator e-mail page$")
    public void theUserRefreshesTheMailinatorEmailPage() throws Throwable {
        mailinatorMethods.navigatesToMailinatorEmail(emailAccountSetup);
    }

    @Then("^the user validates that there's at least \"([^\"]*)\" e-mail on Mailinator$")
    public void theUserValidatesThatTheresAtLeastOneEmailOnMailinator(Integer emailResultsExpected) throws Throwable {
        mailinatorMethods.validateMoreThanEmails(emailResultsExpected);
    }

    @Then("^the user validates that the most recent Mailinator e-mail contains the subject \"([^\"]*)\"$")
    public void theUserValidatesThatTheMostRecentMailinatorEmailHasTheSubject(String emailSubject) throws Throwable {
        mailinatorMethods.validateMostRecentEmailSubject(emailSubject);
    }

    @Then("^the user clicks the most recent e-mail on Mailinator$")
    public void theUserClicksTheMostRecentEmailOnMailinator() throws Throwable {
        mailinatorMethods.clickMostRecentEmail();
    }

    @Then("^the user validates that the Mailinator e-mail is displayed as being to \"([^\"]*)\"$")
    public void theUserValidatesThatTheMailinatorEmailIsDisplayedAsBeingTo(String emailTo) throws Throwable {
        mailinatorMethods.validateEmailIsTo(emailTo);
    }

    @Then("^the user validates that the Mailinator e-mail is displayed as being from \"([^\"]*)\"$")
    public void theUserValidatesThatTheMailinatorEmailIsDisplayedAsBeingFrom(String fromEmail) throws Throwable {
        mailinatorMethods.validateEmailIsFrom(fromEmail);
    }

    @Then("^the user validates that the Mailinator e-mail is displayed with a subject of \"([^\"]*)\"$")
    public void theUserValidatesThatTheMailinatorEmailIsDisplayedWithASubjectOf(String subject) throws Throwable {
        mailinatorMethods.validateEmailSubjectIs(subject);
    }

    @Then("^the user validates that the Mailinator e-mail contains the text \"([^\"]*)\"$")
    public void theUserValidatesThatTheMailinatorEmailContainsTheText(String emailText) throws Throwable {
        mailinatorMethods.validateEmailContainsText(emailText);
    }

    @Then("^the user validates that the Mailinator e-mail contains a link with \"([^\"]*)\"$")
    public void theUserValidatesThatTheMailinatorEmailContainsALinkWith(String emailLink) throws Throwable {
        mailinatorMethods.validateEmailContainsLink(emailLink);
    }

    @Then("^the user validates that the Mailinator e-mail contains a link titled \"([^\"]*)\" with the URL \"([^\"]*)\"$")
    public void theUserValidatesThatTheMailinatorEmailContainsALinkTitledWithTheUrl(String linkTitle, String emailLink) throws Throwable {
        mailinatorMethods.validateEmailContainsLinkWithTitle(linkTitle,emailLink);
    }

}