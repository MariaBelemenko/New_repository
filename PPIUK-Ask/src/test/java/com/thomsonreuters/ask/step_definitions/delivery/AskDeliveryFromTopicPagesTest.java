package com.thomsonreuters.ask.step_definitions.delivery;

import com.google.common.collect.Lists;
import com.thomsonreuters.ask.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.common.PageActions;
import com.thomsonreuters.pageobjects.pages.ask.AskCategoryPage;
import com.thomsonreuters.pageobjects.pages.ask.AskResourcePage;
import com.thomsonreuters.pageobjects.pages.ask.AskSearchResultsPage;
import com.thomsonreuters.pageobjects.pages.header.WLNHeader;
import com.thomsonreuters.pageobjects.pages.landingPage.PracticalLawUKCategoryPage;
import com.thomsonreuters.pageobjects.pages.plPlusKnowHowResources.DocumentRightPanelPage;
import com.thomsonreuters.pageobjects.pages.plPlusKnowHowResources.KHResourcePage;
import com.thomsonreuters.pageobjects.pages.search.SearchResultsPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.TransformerUtils;
import org.hamcrest.Matchers;
import org.hamcrest.core.Is;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertTrue;

public class AskDeliveryFromTopicPagesTest extends BaseStepDef {

    private WLNHeader wlnHeader = new WLNHeader();
    private AskCategoryPage askCategoryPage = new AskCategoryPage();
    private AskSearchResultsPage askSearchResultsPage = new AskSearchResultsPage();
    private AskResourcePage askResourcePage = new AskResourcePage();
    private SearchResultsPage searchResultsPage = new SearchResultsPage();
    private PracticalLawUKCategoryPage practicalLawUKCategoryPage = new PracticalLawUKCategoryPage();
    private PageActions pageActions = new PageActions();
    private KHResourcePage resourcePage = new KHResourcePage();
    private DocumentRightPanelPage rightPanelPage = new DocumentRightPanelPage();

    private static final String ASK_DISCLAIMER_TEXT = "Practical Law may have moderated questions and answers before publication. No answer to a question is legal advice and no lawyer-client relationship is created between the person asking the question and the person answering it. Where appropriate, you should consult your own lawyer for legal advice. Practical Law's employees are not practising solicitors or barristers. The Ask scope and rules apply.";

    @Then("^the user verifies that the current PageTitle contains '(.*)'$")
    public void theUserVerifiesThatTheCurrentPageTitleContainsPageTitle(String pageTitle) throws Throwable {
        assertTrue("The Expected Page Title " + pageTitle + " is  NOT displayed", wlnHeader.pageHeaderLabel().getText().contains(pageTitle));
    }

    @And("^the user verifies that all ask queries on the Ask topic Page have date in format '(.*)'$")
    public void theUserVerifiesThatAllAskQueriesOnTheAskTopicPageHaveDateInFormat(String dateFormat) throws Throwable {
        List<WebElement> dateElements = askCategoryPage.askQueriesInTopicPageDatesOnly();
        assertThat("All the ask queries in Ask topic page dont have poste date in correct format: " + dateFormat, isAllDateElementsInCorrectFormat(dateElements, dateFormat, ""), is(true));
    }

    @And("^the user verifies that all ask queries on the topic Page  date sorted by descending order$")
    public void theUserVerifiesThatAllAskQueriesOnTheTopicPageDateSortedByDescendingOrder() throws Throwable {
        verifySortingonDateElements(askCategoryPage.askQueriesInTopicPageDatesOnly());
    }

    @And("^the user verifies that all ask queries on the topic Page have at least (\\d+) reply/replies'$")
    public void theUserVerifiesThatAllAskQueriesOnTheTopicPageHaveAtLeastReplyReplies(int noOfReplies) throws Throwable {
        List<WebElement> repies = askCategoryPage.askQueriesInTopicPageReplyOnly();
        for (WebElement reply : repies) {
            assertThat("The no of replies in the queries are NOT expected", Integer.parseInt(reply.getText().replaceAll("[\\D]", "")), greaterThanOrEqualTo(noOfReplies));
            assertThat("The reply text in the queries are NOT expected", reply.getText(), Matchers.containsString("repl"));
        }
    }

    @And("^the user selects ask question No (\\d+) on the Ask Topic page$")
    public void theUserSelectsAskQuestionNoOnTheAskTopicPage(int queryNo) throws Throwable {
        askSearchResultsPage.waitForPageToLoad();
        askSearchResultsPage.waitForPageToLoadAndJQueryProcessingWithCustomTimeOut(120);
        askSearchResultsPage.askQuestionCheckBox(queryNo).click();
    }

    @When("^the user clicks '(download|print|email)' widget on the Ask Category/Topic page$")
    public void theUserClicksWidgetOnTheDocumentPage(String widgetType) throws Throwable {
        switch (widgetType) {
            case "download":
                askSearchResultsPage.downloadWidget().click();
                break;
            case "print":
                askSearchResultsPage.printWidget().click();
                break;
            case "email":
                askSearchResultsPage.emailWidget().click();
                break;
            default:
                break;
        }
    }

    @Then("^the user verifies that '(Download|Email|Print)' Window is displayed$")
    public void theUserVerifiesThatDownloadWindowIsDisplayed(String window) throws Throwable {
        assertThat("The " + window + " This Document window NOT displayed", askResourcePage.overlayHeader().getText(), containsString(window + " This Document"));
    }

    @When("^the user clicks '(Download|Email|Print)' on '(download|email|print)' overlay$")
    public void theUserClicksDownloadOnDownloadOverlay(String button, String overlay) throws Throwable {
        assertThat("The " + button + " Button  is NOT displayed", askResourcePage.overlayClickButton().getAttribute("value"), containsString(button));
        askResourcePage.overlayClickButton().click();
    }

    @Then("^the user verifies that '(Ready For Email|Ready For Download|Preparing For Print|Preparing For Email|Preparing For Download)' is displayed on the overlay$")
    public void theUserVerifiesThatReadyForEmailIsDisplayOnOverlay(String header) throws Throwable {
        if (header.contains("Ready")) {
            Thread.sleep(1000);
            assertThat("The " + header + " is NOT displayed", askResourcePage.readyMessageOverlayHeader().getText(), containsString(header));
        } else {
            assertThat("The " + header + " is NOT displayed", askResourcePage.prepareMessageOverlayHeader().getText(), containsString(header));
        }
    }

    @When("^the user clicks download on ready to download overlay$")
    public void theUserClicksDownloadOnReadyToDownloadOverlay() throws Throwable {
        askResourcePage.downloadInReadyForDownloadOverlayButton().click();
    }

    @Then("^user clicks (.*) button in dialog box$")
    public void userClicksButtonInDialogBox(String buttonType) throws Throwable {
        Thread.sleep(5000);
        if (buttonType.equalsIgnoreCase("Ok")) {
            askResourcePage.acceptDialogIfAppears();
        } else if (buttonType.equalsIgnoreCase("Cancel")) {
            askResourcePage.dismissDialogIfAppears();
        }
    }

    @When("^the user runs a free text search for the query \"(.*)\"$")
    public void theUserRunsAFreeTextSearchForTheQuery(String query) throws Throwable {
        StringSelection stringSelection = new StringSelection(query);
        Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
        practicalLawUKCategoryPage.searchButton().isDisplayed();
        practicalLawUKCategoryPage.freeTextField().clear();
        if (query.contains("(") || query.contains(")") || query.contains("&")) {
            clpbrd.setContents(stringSelection, null);
            practicalLawUKCategoryPage.freeTextField().sendKeys(Keys.CONTROL + "v");
        } else {
            practicalLawUKCategoryPage.freeTextField().sendKeys(query);
        }
        if (practicalLawUKCategoryPage.getClass().equals(ChromeDriver.class)) {
            pageActions.keyPress(Keys.ENTER);
        } else {
            practicalLawUKCategoryPage.searchButton().click();
        }
        theUserVerifiesThatTheResultsListPageIsDisplayed();
    }

    @Given("^ask disclaimer is displayed on the document$")
    public void askDisclaimerIsDisplayed() throws Throwable {
        assertThat(askResourcePage.askDisclaimerText().getText().trim(), Is.is(ASK_DISCLAIMER_TEXT));
    }

    @Then("^document title is displayed as \"(.*?)\"$")
    public void titleIsDisplayedAs(String title) throws Throwable {
        assertThat(resourcePage.title().getText().trim().replaceAll("\\n", " "), Is.is(title.replaceAll("\\\\n", " ")));
    }

    @Then("^resource type is displayed as \"(.*?)\" on right hand panel$")
    public void documentTypeIsDisplayedAsArticles(String documentType) throws Throwable {
        rightPanelPage.waitForPageToLoad();
        assertThat(rightPanelPage.resourceTypeText().getText().trim(), Is.is(documentType));
    }

    private boolean isAllDateElementsInCorrectFormat(List<WebElement> dateElements, String dateFormat, String removeText) {
        boolean correctFormat = true;
        Collection<String> postedDates = CollectionUtils.collect(dateElements, TransformerUtils.invokerTransformer("getText"));
        SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
        for (String date : postedDates) {
            date = date.replaceAll(removeText, "");
            try {
                formatter.parse(date);
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
        List<Date> retrievedDateList = getDatesAfterRemovingText(postedDatesList, "", "dd MMMM yyyy");
        List<Date> retrievedDateBeforeSort = new ArrayList<>();
        retrievedDateBeforeSort.addAll(retrievedDateList);
        Collections.sort(retrievedDateList, Collections.reverseOrder());
        assertThat("The queries are NOT sorted by posted date", retrievedDateBeforeSort, is(retrievedDateList));
    }

    private List<Date> getDatesAfterRemovingText(List<String> postedDatesLis, String removeText, String dateFormat) {
        List<Date> dateList = new ArrayList<Date>();
        SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
        formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
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

    private void theUserVerifiesThatTheResultsListPageIsDisplayed() throws Throwable {
        // A robot to allow a pause for the page to refresh
        Robot robot = new Robot();
        // Wait 5 seconds
        robot.delay(5000);
        try {
            searchResultsPage.resultsListHeader().isDisplayed();
            searchResultsPage.filterHeader().isDisplayed();
        } catch (Exception e) {
        }
    }

}
