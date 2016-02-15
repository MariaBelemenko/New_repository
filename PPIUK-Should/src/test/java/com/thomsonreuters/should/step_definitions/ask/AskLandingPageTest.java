package com.thomsonreuters.should.step_definitions.ask;

import com.google.common.collect.Lists;
import com.thomsonreuters.pageobjects.pages.ask.AskCategoryPage;
import com.thomsonreuters.pageobjects.pages.header.WLNHeader;
import com.thomsonreuters.should.step_definitions.BaseStepDef;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.TransformerUtils;
import org.hamcrest.Matchers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertTrue;

public class AskLandingPageTest extends BaseStepDef {

    private AskCategoryPage askCategoryPage = new AskCategoryPage();
    private WLNHeader wlnHeader = new WLNHeader();

    @Then("^the ask disclaimer text '(.*)' is displayed on (.*) page$")
    public void theAskDisclaimerTextDisplayedOnAskPracticeAreaPage(String text, String pageName) throws Throwable {
        if (pageName.equalsIgnoreCase("ask Practice area")) {
            assertThat("Disclaimer is Not displayed", askCategoryPage.askDisclaimerTextOnPracticeArea().getText(), containsString(text));
        } else if (pageName.equalsIgnoreCase("ask tab")) {
            assertThat("Disclaimer is Not displayed", askCategoryPage.askDisclaimerTextOnAskTab().getText(), containsString(text));
        } else if (pageName.equalsIgnoreCase("ask landing")) {
            assertThat("Disclaimer is Not displayed", askCategoryPage.askDisclaimerTextOnAskLandingPage().getText(), containsString(text));
        } else if (pageName.equalsIgnoreCase("ask Category")) {
            assertThat("Disclaimer is Not displayed", askCategoryPage.askDisclaimerText().getText(), containsString(text));
        }
    }

    @Then("^the user verifies that the current PageTitle contains '(.*)'$")
    public void theUserVerifiesThatTheCurrentPageTitleContainsPageTitle(String pageTitle) throws Throwable {
        assertTrue("The Expected Page Title " + pageTitle + " is  NOT displayed", wlnHeader.pageHeaderLabel().getText().contains(pageTitle));
    }

    @Then("^the user verifies that (.*) '(\\d+)' (.*) questions are displayed$")
    public void theUserVerifiesThatExactlyQuestionsAreDisplayed(String matchType, int noOfresources, String queryType) throws Throwable {
        if (matchType.equalsIgnoreCase("exactly")) {
            if (queryType.equalsIgnoreCase("recent")) {
                assertThat("The no of " + queryType + " queries are NOT expected", askCategoryPage.recentQueries().size(), comparesEqualTo(noOfresources));
            } else if (queryType.equalsIgnoreCase("featured")) {
                assertThat("The no of " + queryType + " queries are NOT expected", askCategoryPage.featuredQueries().size(), comparesEqualTo(noOfresources));
            } else if (queryType.equalsIgnoreCase("recent paginated")) {
                assertThat("The no of " + queryType + " queries are NOT expected", askCategoryPage.recentPaginatedQueries().size(), comparesEqualTo(noOfresources));
            } else if (queryType.equalsIgnoreCase("ask tab recent")) {
                assertThat("The no of " + queryType + " queries are NOT expected", askCategoryPage.recentQueriesOnAskTab().size(), comparesEqualTo(noOfresources));
            }
        } else if (matchType.equalsIgnoreCase("at least")) {
            if (queryType.equalsIgnoreCase("recent")) {
                assertThat("The no of " + queryType + " queries are NOT expected", askCategoryPage.recentQueries().size(), greaterThanOrEqualTo(noOfresources));
            } else if (queryType.equalsIgnoreCase("featured")) {
                assertThat("The no of " + queryType + " queries are NOT expected", askCategoryPage.featuredQueries().size(), greaterThanOrEqualTo(noOfresources));
            } else if (queryType.equalsIgnoreCase("recent paginated")) {
                assertThat("The no of " + queryType + " queries are NOT expected", askCategoryPage.recentPaginatedQueries().size(), greaterThanOrEqualTo(noOfresources));
            } else if (queryType.equalsIgnoreCase("ask tab recent")) {
                assertThat("The no of " + queryType + " queries are NOT expected", askCategoryPage.recentQueriesOnAskTab().size(), greaterThanOrEqualTo(noOfresources));
            }
        }
    }

    @And("^the user verifies that all queries have date in format '(.*)'$")
    public void theUserVerifiesThatAllQueriesHaveDateInFormat(String dateFormat) throws Throwable {
        List<WebElement> dateElements = askCategoryPage.recentQueriesDatesOnly();
        assertThat("All the queries dont have poste date in correct format: " + dateFormat, isAllDateElementsInCorrectFormat(dateElements, dateFormat, "Posted on:"), is(true));
    }

    @Then("^the user verifies that (.*) are sorted by 'Posted date' by descending order$")
    public void theUserVerifiesThatQueriesAreSortedByPostedDateByDescendingOrder(String queryType) throws Throwable {
        List<WebElement> queriesList = null;
        if (queryType.equalsIgnoreCase("queries")) {
            queriesList = askCategoryPage.recentPaginatedQueriesDatesOnly();
        } else if (queryType.equalsIgnoreCase("Ask Tab queries")) {
            queriesList = askCategoryPage.recentQueriesOnAskTabDatesOnly();
        } else if (queryType.equalsIgnoreCase("ask landing queries")) {
            queriesList = askCategoryPage.recentQueriesDatesOnly();
        }
        verifySortingonDateElements(queriesList);
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

    public boolean isAllDateElementsInCorrectFormat(List<WebElement> dateElements, String dateFormat, String removeText) {
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

    private void verifySortingonDateElements(List<WebElement> dateElements) {
        Collection<String> postedDates = CollectionUtils.collect(dateElements, TransformerUtils.invokerTransformer("getText"));
        List<String> postedDatesList = Lists.newArrayList(postedDates);
        List<Date> retrievedDateList = getDatesAfterRemovingText(postedDatesList, "Posted on: ", "DD MMMM YYYY");
        List<Date> retrievedDateBeforeSort = new ArrayList<>();
        retrievedDateBeforeSort.addAll(retrievedDateList);
        Collections.sort(retrievedDateList, Collections.reverseOrder());
        assertThat("The queries are NOT sorted by posted date", retrievedDateBeforeSort, is(retrievedDateList));
    }

    private List<Date> getDatesAfterRemovingText(List<String> postedDatesLis, String removeText, String dateFormat) {
        List<Date> dateList = new ArrayList<Date>();
        SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
        for (String date : postedDatesLis) {
            date = date.replaceAll(removeText, "");
            try {
                dateList.add(formatter.parse(date));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return dateList;
    }

}
