package com.thomsonreuters.ask.step_definitions.comments;

import com.thomsonreuters.ask.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.otherPages.NavigationCobalt;
import com.thomsonreuters.pageobjects.pages.ask.AskResourcePage;
import com.thomsonreuters.pageobjects.pages.plPlusKnowHowResources.KHResourcePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.hamcrest.core.Is;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.StringContains.containsString;
import static org.hamcrest.text.IsEmptyString.isEmptyString;

public class AskCommentsTest extends BaseStepDef {

    private NavigationCobalt navigationCobalt = new NavigationCobalt();
    private KHResourcePage resourcePage = new KHResourcePage();
    private AskResourcePage askResourcePage = new AskResourcePage();

    private static final String ASK_DATE_FORMAT = "dd MMM YYYY";
    private static final String ASK_TIME_FORMAT = "HH:mm";
    private static final String ASK_DATE_TIME_FORMAT = ASK_DATE_FORMAT + " " + ASK_TIME_FORMAT;
    private static final String ASK_REPLY_TEXT = "This from Auto Testing ";
    private static final String ASK_REPLIER_NAME = "Usman Hussain Test 67";
    private static final String ASK_ANONYMOUS = "Anonymous";

    private int noOfComments;
    private String timeStamp = "";

    @Given("^user navigates directly to document with guid \"(.*?)\"$")
    public void userNavigatesDirectlyToDocumentWithGuid(String guid) throws Throwable {
        navigationCobalt.navigateToWLNSpecificResourcePage("/Document/" + guid + "/View/FullText.html");
        int CUSTOM_DRIVER_WAIT_TIME = 120;
        resourcePage.waitForPageToLoadAndJQueryProcessingWithCustomTimeOut(CUSTOM_DRIVER_WAIT_TIME);
    }

    @Given("^answer and comment are displayed with correct details$")
    public void askAsnwerAndCommentAreDisplayed() throws Throwable {
        assertThat("Answer and Comment are not displayed", askResourcePage.numberOfComments() >= 2, Is.is(true));
        assertThat(askResourcePage.displayNameForNthComment(1).getText(), not(isEmptyString()));
        assertThat(askResourcePage.postedDateForNthComment(1).getText(), not(isEmptyString()));
        assertThat(askResourcePage.bodyForNthComment(1).getText(), not(isEmptyString()));
        assertThat(askResourcePage.reportThisPostForNthComment(1).getText(), not(isEmptyString()));
        assertThat(askResourcePage.replyForNthComment(1).getText(), not(isEmptyString()));
    }

    @Given("^user submits reply without agreeing to Ask PLC scope and rules$")
    public void submitReplyWithoutAgreeingToTerms() throws Throwable {
        askResourcePage.submitComment().click();
    }

    @Given("^error message is displayed for user to agree to Ask PLC scope and rules$")
    public void errorMessageIsDisplayed() throws Throwable {
        assertThat(askResourcePage.errorMessage().getText().trim(), Is.is("Required field cannot left blank, please indicate that you have read and agreed to Ask PLC scope and rules"));
    }

    @When("^user clicks on 'Add Reply' link on last comment$")
    public void user_clicks_on_Add_Reply_link_on_last_comment() throws Throwable {
        assertThat("Answer and Comment are not displayed", askResourcePage.numberOfComments() >= 2, Is.is(true));
        noOfComments = askResourcePage.numberOfComments();
        askResourcePage.replyForNthComment(noOfComments).click();
    }

    @And("^user enters some test comment in the reply window$")
    public void user_enters_some_test_comment_in_the_reply_window() throws Throwable {
        timeStamp = new SimpleDateFormat(ASK_DATE_TIME_FORMAT).format(new Date());
        askResourcePage.addReplyTextArea().sendKeys(ASK_REPLY_TEXT + timeStamp);
    }

    @And("^user selects to display the name and organisation$")
    public void user_selects_to_display_the_name_and_organisation() throws Throwable {
        askResourcePage.displayNameAndOrgCheckbox().click();
    }

    @And("^user agrees to Ask PLC scope and rules$")
    public void user_agrees_to_Ask_PLC_scope_and_rules() throws Throwable {
        askResourcePage.agreeToRulesCheckbox().click();
    }

    @And("^user submits the reply$")
    public void user_submits_the_reply() throws Throwable {
        askResourcePage.submitComment().click();
    }

    @Then("^newly added reply is displayed as comment on the ask resource$")
    public void newly_added_reply_is_displayed_as_comment_on_the_ask_resource() throws Throwable {
        askResourcePage.waitForPageToLoadAndJQueryProcessing();
        askResourcePage.waitForPageToLoad();
        assertThat("Newly added  Comment Is not displayed", askResourcePage.numberOfComments(), greaterThanOrEqualTo(noOfComments + 1));
        assertThat("The last added comment do NOT contain expected comment", askResourcePage.bodyForNthComment(askResourcePage.numberOfComments()).getText(), containsString(ASK_REPLY_TEXT));
    }

    @And("^users name, organisation and posted date are displayed along with the comment$")
    public void users_name_organisation_and_posted_date_are_displayed_along_with_the_comment() throws Throwable {
        assertThat("The last added comment do NOT contain expected Name", askResourcePage.displayNameForNthComment(noOfComments + 1).getText(), containsString(ASK_REPLIER_NAME));
        String pattern = "(.*) (\\d+):(\\d+)";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(timeStamp);
        String hh, date;
        m.find();
        hh = m.group(2);
        date = m.group(1);
        String datetime = askResourcePage.postedDateForNthComment(noOfComments + 1).getText();
        String retHour = datetime.substring(datetime.length() - 5, datetime.length() - 3);
        assertThat("The last added comment do NOT contain expected Time Stamp hour within range +- 1", (double) Integer.parseInt(retHour), is(closeTo((double) Integer.parseInt(hh), 2d)));
        assertThat("The last added comment do NOT contain expected PostedDate", datetime, containsString(date));
    }

    @And("^anonymous is displayed along with the comment$")
    public void anonymous_is_displayed_along_with_the_comment() throws Throwable {
        assertThat("The last added comment do contain Name", askResourcePage.displayNameForNthComment(noOfComments + 1).getText(), containsString(ASK_ANONYMOUS));
    }

}
