package com.thomsonreuters.ask.step_definitions.queries;

import com.thomsonreuters.ask.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.pages.ask.AskCategoryPage;
import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.documentNavigation.DocumentNavigationPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.TransformerUtils;
import org.hamcrest.Matchers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertTrue;

public class AskQueriesTest extends BaseStepDef {

    private AskCategoryPage askCategoryPage = new AskCategoryPage();
    private DocumentNavigationPage documentNavigationPage = new DocumentNavigationPage();

    @And("^the ask featured queries section have question '(.*)'$")
    public void theAskFeaturedQueriesSectionHaveQuestion(String text) throws Throwable {
        assertThat("Featured question is Not displayed", askCategoryPage.askFeaturedQueriesQuestText().getText().replaceAll("\\n", ""), containsString(text.replaceAll("\\\\n", "")));
    }

    @Then("^features queries is selected by default$")
    public void featuresQueriesIsSelectedByDefault() throws Throwable {
        assertThat("Active Tab is Not Featured queries", askCategoryPage.activeTab().getText(), containsString("Featured queries"));
    }

    @Then("^Sign In button is shown to user$")
    public void signInButtonIsShownToUser() throws Throwable {
        assertTrue("Sign In button is NOY visible", documentNavigationPage.isSignInButtonPresent());
    }

    @And("^the user clicks '(.*)' tab$")
    public void theUserClicksRecentQueriesTab(String tab) throws Throwable {
        if (tab.toLowerCase().contains("recent")) {
            askCategoryPage.recentQueriesTab().click();
        } else if (tab.toLowerCase().contains("featured")) {
            askCategoryPage.featuredQueriesTab().click();
        }
        askCategoryPage.waitForPageToLoad();
    }

    @When("^the user clicks recent query no (\\d+)$")
    public void theUserClicksRecentQueryNo(int index) throws Throwable {
        askCategoryPage.waitForPageToLoad();
        String link = askCategoryPage.recentQueries().get(index - 1).getText().trim();
        Pattern pattern = Pattern.compile("(.*)\\?(.*)");
        Matcher m = pattern.matcher(link);
        if (m.find()) {
            link = m.group(0);
            askCategoryPage.waitForExpectedElement(By.linkText(link)).click();
        } else {
            throw new Exception("Unable to extract ask query from the Recent queries section on the page");
        }
    }

    @And("^the user verifies that all queries have date in format '(.*)'$")
    public void theUserVerifiesThatAllQueriesHaveDateInFormat(String dateFormat) throws Throwable {
        List<WebElement> dateElements = askCategoryPage.recentQueriesDatesOnly();
        assertThat("All the queries dont have poste date in correct format: " + dateFormat, isAllDateElementsInCorrectFormat(dateElements, dateFormat, "Posted on:"), is(true));
    }

    @And("^the user verifies that all queries have at least (\\d+) reply/replies'$")
    public void theUserVerifiesThatAllQueriesHaveAtLeastReplyReplies(int noOfReplies) throws Throwable {
        List<WebElement> queries = askCategoryPage.recentQueries();
        for (WebElement query : queries) {
            WebElement replyText = query.findElement(By.className("co_comments_count"));
            assertThat("The no of replies in the queries are NOT expected", replyText.getText(), Matchers.containsString(Integer.toString(noOfReplies)));
            assertThat("The reply text in the queries are NOT expected", replyText.getText(), Matchers.containsString("repl"));
        }
    }

    private boolean isAllDateElementsInCorrectFormat(List<WebElement> dateElements, String dateFormat, String removeText) {
        boolean correctFormat = true;
        Collection<String> postedDates = CollectionUtils.collect(dateElements, TransformerUtils.invokerTransformer("getText"));
        SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
        for (String date : postedDates) {
            date = date.replaceAll(removeText, "");
            try {
                formatter.parse(date.trim());
            } catch (ParseException e) {
                correctFormat = false;
                break;
            }
        }
        return correctFormat;
    }

}
