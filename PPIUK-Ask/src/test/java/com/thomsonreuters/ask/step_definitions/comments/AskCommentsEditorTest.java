package com.thomsonreuters.ask.step_definitions.comments;

import com.thomsonreuters.ask.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.pages.ask.AskResourcePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.hamcrest.core.Is;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.StringContains.containsString;

public class AskCommentsEditorTest extends BaseStepDef {

    private AskResourcePage askResourcePage = new AskResourcePage();

    private static final String ASK_DATE_FORMAT = "dd MMM YYYY";
    private static final String ASK_TIME_FORMAT = "HH:mm";
    private static final String ASK_DATE_TIME_FORMAT = ASK_DATE_FORMAT + " " + ASK_TIME_FORMAT;
    private static final String ASK_EDIT_TEXT = "This is edited from Auto Testing by editor ";

    private int noOfComments;
    private String timeStamp = "";
    private String comment = "";

    @When("^user clicks on 'Edit' link on last comment$")
    public void userClicksOnEditLinkOnLastComment() throws Throwable {
        assertThat("Answer and Comment are not displayed", askResourcePage.numberOfComments() >= 2, Is.is(true));
        noOfComments = askResourcePage.numberOfComments();
        askResourcePage.editForNthComment(noOfComments).click();
    }

    @And("^user enters some new comments in the reply window$")
    public void userEntersSomeNewTestCommentsInTheReplyWindow() throws Throwable {
        timeStamp = new SimpleDateFormat(ASK_DATE_TIME_FORMAT).format(new Date());
        String existingComment = askResourcePage.addReplyTextArea().getAttribute("value");
        askResourcePage.addReplyTextArea().sendKeys(existingComment + " " + ASK_EDIT_TEXT + timeStamp);
    }

    @Then("^newly edited reply is displayed as comment on the ask resource$")
    public void newlyEditedReplyIsDisplayedAsCommentOnTheAskResource() throws Throwable {
        askResourcePage.waitForPageToLoadAndJQueryProcessing();
        askResourcePage.waitForPageToLoad();
        assertThat("The last added comment do NOT contain expected comment", askResourcePage.bodyForNthComment(askResourcePage.numberOfComments()).getText(), containsString(ASK_EDIT_TEXT));
    }

    @When("^user clicks on 'Delete' link on last comment$")
    public void userClicksOnDeleteLinkOnLastComment() throws Throwable {
        assertThat("Answer and Comment are not displayed", askResourcePage.numberOfComments() >= 2, Is.is(true));
        noOfComments = askResourcePage.numberOfComments();
        comment = askResourcePage.bodyForNthComment(noOfComments).getText();
        askResourcePage.deleteForNthComment(noOfComments).click();
    }

    @And("^the comment is deleted on the ask resource$")
    public void the_comment_is_deleted_on_the_ask_resource() throws Throwable {
        askResourcePage.acceptDialogIfAppears();
        askResourcePage.waitForPageToLoadAndJQueryProcessing();
        askResourcePage.waitForPageToLoad();
        assertThat("Comment is NOT deleted", askResourcePage.numberOfComments() == noOfComments - 1, Is.is(true));
        assertThat("The last comment has deleted content", askResourcePage.bodyForNthComment(askResourcePage.numberOfComments()).getText(), not(containsString(comment)));
    }

}
