package com.thomsonreuters.ask.step_definitions.common;

import com.thomsonreuters.ask.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.common.CommonMethods;
import com.thomsonreuters.pageobjects.otherPages.NavigationCobalt;
import com.thomsonreuters.pageobjects.pages.ask.AskResourcePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.SoftAssertions;
import org.hamcrest.Matchers;
import org.hamcrest.core.Is;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;

public class AskResourcePlusYrOldTest extends BaseStepDef {

    private NavigationCobalt navigationCobalt = new NavigationCobalt();
    private AskResourcePage askResourcePage = new AskResourcePage();
    private CommonMethods commonMethods = new CommonMethods();

    private int docNumber;
    private String mailTo="";
    private String subject="";

    @When("^the user is in Page '(.*)'$")
    public void theUserIsInPage(String pages) throws Throwable {
        List<String> links = Arrays.asList(pages.split(">"));
        for (String link : links) {
            if (link.contains("/")) {
                navigationCobalt.navigateToRelativeURL(link);
                navigationCobalt.waitForPageToLoad();
            }
        }
    }

    @Then("^the user verifies that ask error message displayed (.*)contains '(.*)'$")
    public void theUserVerifiesThatAskErrorMessageDisplayedContains(String should, String text) throws Throwable {
        if (!should.contains("NOT")) {
            assertThat(askResourcePage.askErrorText().getText().replaceAll("\\n", ""), containsString(text.replaceAll("\\\\n", "")));
        } else {
            assertThat(askResourcePage.askErrorText().getText().replaceAll("\\n", ""), Matchers.not(containsString(text.replaceAll("\\\\n", ""))));
        }
    }

    @And("^get mailto and subject from 'Report this Post' link$")
    public void get_mailto_and_subject_from_report_this_post_link() throws Throwable{
        assertThat("Answer and Comment are not displayed", askResourcePage.numberOfComments() >= 2, Is.is(true));
        docNumber = 1;
        String href = askResourcePage.reportThisPostForNthComment(docNumber).getAttribute("href");
        String pattern = "mailto:(.*).*(?=\\?).subject=(.*).*(?=&)";
        List<String> values = commonMethods.getRegExpGroupValue(pattern, href);
        if (!values.isEmpty()) {
            mailTo = values.get(0);
            subject = values.get(1);
        }
    }

    @Then("^verify that mailto and subject fields are not empty$")
    public void verify_that_mailto_and_subject_fields_are_not_empty() throws Throwable {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(mailTo.isEmpty()).overridingErrorMessage("'Mail To' is empty").isFalse();
        softly.assertThat(subject.isEmpty()).overridingErrorMessage("'Subject' is empty").isFalse();
        softly.assertAll();
    }

    @And("^verify that the view scrolled to reply text area")
    public void verify_that_the_view_scrolled_to_reply_text_area() throws Throwable {
        askResourcePage.replyForNthComment(docNumber).click();
        assertThat("View does not scroll to reply text area", askResourcePage.isViewScrolledToElement(askResourcePage.addReplyTextArea()));
    }
}
