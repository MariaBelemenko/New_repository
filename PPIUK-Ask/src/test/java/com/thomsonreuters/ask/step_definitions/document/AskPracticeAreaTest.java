package com.thomsonreuters.ask.step_definitions.document;

import com.google.common.collect.Lists;
import com.thomsonreuters.ask.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.pages.ask.AskCategoryPage;
import com.thomsonreuters.pageobjects.pages.pageCreation.CommonPracticeAreaPage;
import com.thomsonreuters.pageobjects.pages.pageCreation.HomePage;
import cucumber.api.java.en.Then;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.TransformerUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertTrue;

public class AskPracticeAreaTest extends BaseStepDef {

    private AskCategoryPage askCategoryPage = new AskCategoryPage();
    private HomePage homePage = new HomePage();
    private CommonPracticeAreaPage commonPracticeAreaPage = new CommonPracticeAreaPage();

    @Then("^the user verifies that only '(.*)' ask resource  is displayed$")
    public void theUserVerifiesThatOnlySpecifiedAskResourceIsDisplayed(int noOfresources) throws Throwable {
        askCategoryPage.waitForPageToLoad();
        assertThat("The no of ask resource is NOT expected", askCategoryPage.featuredQueries().size(), comparesEqualTo(noOfresources));
    }

    @Then("^the user verifies that link '(.*)' is  displayed on '(.*)'$")
    public void theUserVerifiesThatLinkIsDisplayedOnThePage(String link, String page) throws Throwable {
        assertTrue("The link " + link + " is NOT displayed on " + page, homePage.waitForExpectedElement(By.linkText(link)).isDisplayed());
    }

    @Then("^the Ask Tab is displayed on the page$")
    public void theAskTabIsDisplayedOnThePage() throws Throwable {
        assertThat("Ask Tab is Not displayed", commonPracticeAreaPage.askTab().isDisplayed(), is(true));
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

    @Then("^the user verifies that (.*) are sorted by 'Posted date' by descending order$")
    public void the_user_verifies_that_queries_are_sorted_by_Posted_date_by_descending_order(String queryType) throws Throwable {
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

    @Then("^the ask disclaimer text '(.*)' is displayed on (.*) page$")
    public void the_ask_disclaimer_text_displayed_on_ask_Practice_area_page(String text, String pageName) throws Throwable {
        if (pageName.equalsIgnoreCase("ask Practice area")) {
            assertThat("Disclaimer is Not displayed", askCategoryPage.askDisclaimerTextOnPracticeArea().getText(), containsString(text));
        } else if (pageName.equalsIgnoreCase("ask tab")) {
            assertThat("Disclaimer is Not displayed", askCategoryPage.askDisclaimerTextOnAskTab().getText(), containsString(text));
        } else if (pageName.equalsIgnoreCase("ask landing")) {
            assertTrue("Disclaimer is Not displayed", askCategoryPage.askDisclaimerTextOnAskLandingPage(text).isDisplayed());
        } else if (pageName.equalsIgnoreCase("ask Category")) {
            assertThat("Disclaimer is Not displayed", askCategoryPage.askDisclaimerText().getText(), containsString(text));
        }
    }

    public void verifySortingonDateElements(List<WebElement> dateElements) {
        Collection<String> postedDates = CollectionUtils.collect(dateElements, TransformerUtils.invokerTransformer("getText"));
        List<String> postedDatesList = Lists.newArrayList(postedDates);
        List<Date> retrievedDateList = getDatesAfterRemovingText(postedDatesList, "Posted on: ", "DD MMMM YYYY");
        List<Date> retrievedDateBeforeSort = new ArrayList<>();
        retrievedDateBeforeSort.addAll(retrievedDateList);
        Collections.sort(retrievedDateList, Collections.reverseOrder());
        assertThat("The queries are NOT sorted by posted date", retrievedDateBeforeSort, is(retrievedDateList));
    }

    public List<Date> getDatesAfterRemovingText(List<String> postedDatesLis, String removeText, String dateFormat) {
        List<Date> dateList = new ArrayList<Date>();
        SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
        for (String date : postedDatesLis) {
            date = date.replaceAll(removeText, "");
            try {
                dateList.add(formatter.parse(date));
            } catch (ParseException e) {
                LOG.info("Parse error.", e);
            }
        }
        return dateList;
    }

}
