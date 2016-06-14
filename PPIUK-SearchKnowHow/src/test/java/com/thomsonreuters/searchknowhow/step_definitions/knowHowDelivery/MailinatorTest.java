package com.thomsonreuters.searchknowhow.step_definitions.knowHowDelivery;

import com.thomsonreuters.pageobjects.pages.common.CommonMailinatorPage;
import com.thomsonreuters.searchknowhow.step_definitions.BaseStepDef;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class MailinatorTest extends BaseStepDef {

    private CommonMailinatorPage mailinatorpage = new CommonMailinatorPage();

    public static String mailinatorURL = "https://mailinator.com/";

    String emailAccountSetup = "";

    List<WebElement> emailList;

    @And("^the user sets up a Mailinator e-mail with the name \"([^\"]*)\"$")
    public void theUserSetsUpAMailinatorEmailWithTheName(String emailAccount) throws Throwable {
        emailAccountSetup = emailAccount;
    }

    @Then("^the user navigates to the Mailinator e-mail \"([^\"]*)\"$")
    public void theUserNavigatesToTheMailinatorEmail(String emailURL) throws Throwable {
        mailinatorpage.navigate(mailinatorURL + "/inbox2.jsp?public_to=" + emailURL);
    }

    @And("^the user refreshes the Mailinator e-mail page$")
    public void theUserRefreshesTheMailinatorEmailPage() throws Throwable {
        mailinatorpage.navigate(mailinatorURL + "/inbox2.jsp?public_to=" + emailAccountSetup);
    }

    @Then("^the user validates that there's at least \"([^\"]*)\" e-mail on Mailinator$")
    public void theUserValidatesThatTheresAtLeastOneEmailOnMailinator(String emailResultsExpected) throws Throwable {
        for(int i=0;i<20;i++){
            try{
                if(mailinatorpage.displayedEmailCount()>0){
                    break;
                }else{
                    mailinatorpage.refreshPage();
                }
            }catch (Exception e){}
        }
        assertTrue( mailinatorpage.displayedEmailCount().intValue() >= Integer.parseInt(emailResultsExpected));
    }

    @And("^the user validates that the most recent Mailinator e-mail contains the subject \"([^\"]*)\"$")
    public void theUserValidatesThatTheMostRecentMailinatorEmailHasTheSubject(String emailSubject) throws Throwable {
        //String onclickId = mailinatorpage.firstEmailOnclickId();
        assertTrue(((WebElement)(mailinatorpage.displayedEmailList().get(0))).getText().contains(emailSubject));
    }

    @When("^the user clicks the most recent e-mail on Mailinator$")
    public void theUserClicksTheMostRecentEmailOnMailinator() throws Throwable {
       mailinatorpage.selectFirstEmail();
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

    @And("^the user validates that the Mailinator e-mail is displayed with a subject of \"([^\"]*)\"$")
    public void theUserValidatesThatTheMailinatorEmailIsDisplayedWithASubjectOf(String subject) throws Throwable {
        assertTrue(mailinatorpage.emailDisplaySubject().getText().contains(subject));
    }

    @And("^the user validates that the Mailinator e-mail contains the text \"([^\"]*)\"$")
    public void theUserValidatesThatTheMailinatorEmailContainsTheText(String emailText) throws Throwable {
        assertTrue(mailinatorpage.getEmailText().contains(emailText));
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
