package com.thomsonreuters.searchknowhow.step_definitions.knowHowDelivery;

import com.thomsonreuters.pageobjects.pages.common.CommonMailinatorPage;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class MailinatorTest {

    private CommonMailinatorPage mailinatorpage = new CommonMailinatorPage();

    public static String mailinatorURL = "https://mailinator.com/";

    String emailAccountSetup = "";

    List<WebElement> emailList;

    @Then("^the user sets up a Mailinator e-mail with the name \"([^\"]*)\"$")
    public void theUserSetsUpAMailinatorEmailWithTheName(String emailAccount) throws Throwable {
        emailAccountSetup = emailAccount;
    }

    @Then("^the user navigates to the Mailinator e-mail \"([^\"]*)\"$")
    public void theUserNavigatesToTheMailinatorEmail(String emailURL) throws Throwable {
        mailinatorpage.navigate(mailinatorURL + "/inbox.jsp?to=" + emailURL);
    }

    @Then("^the user refreshes the Mailinator e-mail page$")
    public void theUserRefreshesTheMailinatorEmailPage() throws Throwable {
        mailinatorpage.navigate(mailinatorURL + "/inbox.jsp?to=" + emailAccountSetup);
    }

    @Then("^the user validates that there's at least \"([^\"]*)\" e-mail on Mailinator$")
    public void theUserValidatesThatTheresAtLeastOneEmailOnMailinator(Integer emailResultsExpected) throws Throwable {
        Integer emailCount = mailinatorpage.displayedEmailCount();
        String emailCountString = emailCount.toString();
        assertTrue(emailCount >= emailResultsExpected);
    }

    @Then("^the user validates that the most recent Mailinator e-mail contains the subject \"([^\"]*)\"$")
    public void theUserValidatesThatTheMostRecentMailinatorEmailHasTheSubject(String emailSubject) throws Throwable {
        String onclickId = mailinatorpage.firstEmailOnclickId();
        assertTrue(mailinatorpage.emailSubjectOnclick(onclickId).getText().contains(emailSubject));
    }

    @Then("^the user clicks the most recent e-mail on Mailinator$")
    public void theUserClicksTheMostRecentEmailOnMailinator() throws Throwable {
        String onclickId = mailinatorpage.firstEmailOnclickId();
        mailinatorpage.emailSubjectOnclick(onclickId).click();
    }

    @Then("^the user validates that the Mailinator e-mail is displayed as being to \"([^\"]*)\"$")
    public void theUserValidatesThatTheMailinatorEmailIsDisplayedAsBeingTo(String emailTo) throws Throwable {
        assertTrue(mailinatorpage.emailDisplayTo().getText().contains(emailTo));
    }

    @Then("^the user validates that the Mailinator e-mail is displayed as being from \"([^\"]*)\"$")
    public void theUserValidatesThatTheMailinatorEmailIsDisplayedAsBeingFrom(String fromEmail) throws Throwable {
        /** Get e-mail and strip the whitespace */
        String fromEmailDisplayed = mailinatorpage.emailDisplayFrom().getText().replaceAll("/[^A-Za-z0-9 ]/", "");
        assertTrue(fromEmailDisplayed.equals(fromEmail));
    }

    @Then("^the user validates that the Mailinator e-mail is displayed with a subject of \"([^\"]*)\"$")
    public void theUserValidatesThatTheMailinatorEmailIsDisplayedWithASubjectOf(String subject) throws Throwable {
        assertTrue(mailinatorpage.emailDisplaySubject().getText().contains(subject));
    }

    @Then("^the user validates that the Mailinator e-mail contains the text \"([^\"]*)\"$")
    public void theUserValidatesThatTheMailinatorEmailContainsTheText(String emailText) throws Throwable {
        /** Switch to the e-mail frame to be able to read the e-mail */
        mailinatorpage.switchToIframe(mailinatorpage.emailMainTextFrame());
        assertTrue(mailinatorpage.emailMainText().getText().contains(emailText));
        /** Switch back to the full webpage */
        mailinatorpage.switchToMainWindow();
    }

    @Then("^the user validates that the Mailinator e-mail contains a link with \"([^\"]*)\"$")
    public void theUserValidatesThatTheMailinatorEmailContainsALinkWith(String emailLink) throws Throwable {
        /** Switch to the e-mail frame to be able to read the e-mail */
        mailinatorpage.switchToIframe(mailinatorpage.emailMainTextFrame());
        mailinatorpage.emailMainTextLink(emailLink).isDisplayed();
        /** Switch back to the full webpage */
        mailinatorpage.switchToMainWindow();
    }

    @Then("^the user validates that the Mailinator e-mail contains a link titled \"([^\"]*)\" with the URL \"([^\"]*)\"$")
    public void theUserValidatesThatTheMailinatorEmailContainsALinkTitledWithTheUrl(String linkTitle, String emailLink) throws Throwable {
        /** Switch to the e-mail frame to be able to read the e-mail */
        mailinatorpage.switchToIframe(mailinatorpage.emailMainTextFrame());
        WebElement elementLink = mailinatorpage.emailMainTextLink(emailLink);
        elementLink.isDisplayed();
        assertTrue(elementLink.getText().equals(linkTitle));
        /** Switch back to the full webpage */
        mailinatorpage.switchToMainWindow();
    }

}
