package com.thomsonreuters.pageobjects.common;

import com.thomsonreuters.driver.framework.AbstractPage;

/**
 * Generic Mailinator code
 * For an example of this code in use see the feature file westlaw/onePass[WLUK]
 */
@Deprecated
public class Mailinator extends AbstractPage {

//    private CommonMailinatorPage mailinatorpage = new CommonMailinatorPage();
//
//    public static String mailinatorURL = "https://mailinator.com/";
//
//    String emailAccountSetup = "";
//
//    List<WebElement> emailList;
//
//    @Then("^the user sets up a Mailinator e-mail with the name \"([^\"]*)\"$")
//    public void the_user_sets_up_a_mailinator_email_with_the_name(
//            String emailAccount) throws Throwable {
//        emailAccountSetup = emailAccount;
//
//    }
//
//    @Then("^the user navigates to the Mailinator e-mail \"([^\"]*)\"$")
//    public void the_user_navigates_to_the_mailinator_email(
//            String emailURL) throws Throwable {
//        mailinatorpage.navigate(mailinatorURL + "/inbox.jsp?to=" + emailURL);
//    }
//
//    @Then("^the user refreshes the Mailinator e-mail page$")
//    public void the_user_refreshes_the_mailinator_email_page() throws Throwable {
//        mailinatorpage.navigate(mailinatorURL + "/inbox.jsp?to=" + emailAccountSetup);
//    }
//
//    @Then("^the user validates that there's at least \"([^\"]*)\" e-mail on Mailinator$")
//    public void the_user_validates_that_theres_at_least_one_email_on_mailinator(
//            Integer emailResultsExpected) throws Throwable {
//        Integer emailCount = mailinatorpage.displayedEmailCount();
//        String emailCountString = emailCount.toString();
//        assertTrue(emailCount >= emailResultsExpected);
//    }
//
//    @Then("^the user validates that the most recent Mailinator e-mail contains the subject \"([^\"]*)\"$")
//    public void the_user_validates_that_the_most_recent_mailinator_email_has_the_subject(
//            String emailSubject) throws Throwable {
//        String onclickId = mailinatorpage.firstEmailOnclickId();
//        assertTrue(mailinatorpage.emailSubjectOnclick(onclickId).getText().contains(emailSubject));
//    }
//
//    @Then("^the user clicks the most recent e-mail on Mailinator$")
//    public void the_user_clicks_the_most_recent_email_on_mailinator() throws Throwable {
//        String onclickId = mailinatorpage.firstEmailOnclickId();
//        mailinatorpage.emailSubjectOnclick(onclickId).click();
//    }
//
//    @Then("^the user validates that the Mailinator e-mail is displayed as being to \"([^\"]*)\"$")
//    public void the_user_validates_that_the_mailinator_email_is_displayed_as_being_to(
//            String emailTo) throws Throwable {
//        assertTrue(mailinatorpage.emailDisplayTo().getText().contains(emailTo));
//    }
//
//    @Then("^the user validates that the Mailinator e-mail is displayed as being from \"([^\"]*)\"$")
//    public void the_user_validates_that_the_mailinator_email_is_displayed_as_being_from(
//            String fromEmail) throws Throwable {
//        // Get e-mail and strip the whitespace
//        String fromEmailDisplayed = mailinatorpage.emailDisplayFrom().getText().replaceAll("/[^A-Za-z0-9 ]/", "");
//        assertTrue(fromEmailDisplayed.equals(fromEmail));
//    }
//
//    @Then("^the user validates that the Mailinator e-mail is displayed with a subject of \"([^\"]*)\"$")
//    public void the_user_validates_that_the_mailinator_email_is_displayed_with_a_subject_of(
//            String subject) throws Throwable {
//        assertTrue(mailinatorpage.emailDisplaySubject().getText().contains(subject));
//    }
//
//    @Then("^the user validates that the Mailinator e-mail contains the text \"([^\"]*)\"$")
//    public void the_user_validates_that_the_mailinator_email_contains_the_text(
//            String emailText) throws Throwable {
//        // Switch to the e-mail frame to be able to read the e-mail
//        mailinatorpage.switchToIframe(mailinatorpage.emailMainTextFrame());
//        assertTrue(mailinatorpage.emailMainText().getText().contains(emailText));
//        // Switch back to the full webpage
//        mailinatorpage.switchToMainWindow();
//    }
//
//    @Then("^the user validates that the Mailinator e-mail contains a link with \"([^\"]*)\"$")
//    public void the_user_validates_that_the_mailinator_email_contains_a_link_with(
//            String emailLink) throws Throwable {
//        // Switch to the e-mail frame to be able to read the e-mail
//        mailinatorpage.switchToIframe(mailinatorpage.emailMainTextFrame());
//        mailinatorpage.emailMainTextLink(emailLink).isDisplayed();
//        // Switch back to the full webpage
//        mailinatorpage.switchToMainWindow();
//    }
//
//    @Then("^the user validates that the Mailinator e-mail contains a link titled \"([^\"]*)\" with the URL \"([^\"]*)\"$")
//    public void the_user_validates_that_the_mailinator_email_contains_a_link_titled_with_the_url(
//            String linkTitle,
//            String emailLink) throws Throwable {
//        // Switch to the e-mail frame to be able to read the e-mail
//        mailinatorpage.switchToIframe(mailinatorpage.emailMainTextFrame());
//        WebElement elementLink = mailinatorpage.emailMainTextLink(emailLink);
//        elementLink.isDisplayed();
//        assertTrue(elementLink.getText().equals(linkTitle));
//        // Switch back to the full webpage
//        mailinatorpage.switchToMainWindow();
//    }

}

