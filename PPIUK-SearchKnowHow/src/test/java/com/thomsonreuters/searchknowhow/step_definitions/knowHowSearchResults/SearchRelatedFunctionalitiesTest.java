package com.thomsonreuters.searchknowhow.step_definitions.knowHowSearchResults;

import com.thomsonreuters.pageobjects.common.CommonMethods;
import com.thomsonreuters.pageobjects.pages.search.KnowHowDocumentPage;
import com.thomsonreuters.pageobjects.pages.search.KnowHowSearchResultsPage;
import com.thomsonreuters.pageobjects.pages.search.SearchResultsPage;
import com.thomsonreuters.searchknowhow.step_definitions.BaseStepDef;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


import static org.junit.Assert.assertTrue;

public class SearchRelatedFunctionalitiesTest extends BaseStepDef {

    private KnowHowSearchResultsPage knowHowSearchResultsPage = new KnowHowSearchResultsPage();
    private SearchResultsPage searchResultsPage = new SearchResultsPage();
    private KnowHowDocumentPage knowHowDocumentPage = new KnowHowDocumentPage();
    private CommonMethods commonMethods = new CommonMethods();
    private final String PUBLISHED_ON = "Published on ";
    private final String LAW_STATED = "Law stated as at ";

    @When("^the user is able to verify that sample results contain a date in the \"([^\"]*)\" format$")
    public void theUserIsAbleToVerifyThatSampleResultsContainADateInTheDDMMMYYYYFormat(String dateformat) throws Throwable {
        List<WebElement> queriesList = knowHowSearchResultsPage.listOfDate();
        List<String> postedDatesList = new ArrayList<String>();
        for (WebElement webElement : queriesList) {
            postedDatesList.add(webElement.getText());
        }
        Assert.assertTrue("Results contain the dates in not corresponding format " + dateformat, getDatesAfterRemovingText(postedDatesList, dateformat));
    }

    public boolean getDatesAfterRemovingText(List<String> postedDatesList, String dateFormat) {
        List<Date> dateList = new ArrayList<Date>();
        Boolean result = true;
        DateFormat formatter = new SimpleDateFormat(dateFormat);
        for (String date : postedDatesList) {
            if (date.contains(PUBLISHED_ON)) {
                date = date.replaceAll(PUBLISHED_ON, "");
            } else if (date.contains(LAW_STATED)) {
                date = date.replaceAll(LAW_STATED, "");
            }
            try {
                dateList.add(formatter.parse(date));
            } catch (ParseException e) {
                result = false;
                LOG.info("Date in incorrect format.", e);
                break;
            }
        }
        return result;
    }

    @When("^the user can select the option to show more detail$")
    public void theUserCanSelectTheOptionToShowMoreDetail() throws Throwable {
        searchResultsPage.moreOrLessDetailAnchor().click();
        searchResultsPage.moreDetailOption().click();
    }

    @When("^the user is able to verify that terms in context are displayed$")
    public void theUserIsAbleToVerifyThatTermsInContextAreDisplayed() throws Throwable {
        assertTrue(searchResultsPage.firstSnippetPara().isDisplayed());
    }

    @Given("^the user is able to verify the presence of page number \"(.*?)\"$")
    public void theUserIsAbleToVerifyThePresenceOfPageNumber(String number) throws Throwable {
        searchResultsPage.pagination(number).isDisplayed();
    }

    @Given("^the user is able to select the link to the next page$")
    public void theUserIsAbleToSelectTheLinkToTheNextPage() throws Throwable {
        searchResultsPage.selectNextPage().click();
    }

    @Then("^the user is able to verify the presence of below page numbers$")
    public void theUserIsAbleToVerifyThePresenceOfPageNumbers(List<String> numbers) throws Throwable {
        SoftAssertions softly = new SoftAssertions();
        for (String number : numbers) {
            softly.assertThat(searchResultsPage.pagination(number).isDisplayed()).withFailMessage("The below page numbers are not present");
        }
        softly.assertAll();
    }

    @Given("^the user is able to select the link to page \"(.*?)\"$")
    public void theUserIsAbleToSelectTheLinkToPage(String arg1) throws Throwable {
        searchResultsPage.pagination(arg1).click();
    }

    @Then("^the user is able to verify that for result \"([^\"]*)\" the search term \"([^\"]*)\" is highlighted within the snippet text$")
    public void theUserIsAbleToVerifyThatForResultTheSearchContractIsHighlightedWithinTheSnippetText(String rank, String highlightedTerm) throws Throwable {
        Assert.assertTrue("for result " + rank + " the search term " + highlightedTerm + " is highlighted within the snippet text",
                searchResultsPage.highlightedSearchTerm(rank, highlightedTerm).isDisplayed());
    }

    @Then("^the user is able to verify that the search term \"([^\"]*)\" is highlighted in opened document$")
    public void theUserIsAbleToVerifyThatTheSearchTermIsHighlighted(String highlightedTerm) throws Throwable {
        knowHowDocumentPage.waitForPageToLoadAndJQueryProcessing();
        assertTrue("There are no highliighted search terms in document", knowHowDocumentPage.isSearchTermHighlighted(highlightedTerm));
    }

    @And("^the user is able to verify that the search term \"([^\"]*)\" is not highlighted in opened document$")
    public void theUserIsAbleToVerifyThatTheSearchTermIsNotHighlightedInOpenedDocument(String highlightedTerm) throws Throwable {
        knowHowDocumentPage.waitForPageToLoadAndJQueryProcessing();
        Assert.assertFalse("Search terms are highlighted in document", knowHowDocumentPage.isSearchTermHighlighted(highlightedTerm));
    }

    @Then("^the user can verify the presence of the text No Documents Found$")
    public void theUserCanVerifyThePresenceOfTheTextNoDocumentsFound() throws Throwable {
        assertTrue("The user can't verify the presence of the text No Documents Found",
                searchResultsPage.noDocumentsFoundText().isDisplayed());
    }

    @Then("^the user is able to verify the display of the text Did You Mean$")
    public void theUserIsAbleToVerifyTheDisplayOfTheTextDidYouMean() throws Throwable {
        assertTrue(searchResultsPage.isDidYouMeanTextDisplayed());
    }

    @And("^the user is able to verify the display of the corrected query \"(.*?)\"$")
    public void theUserIsAbleToVerifyTheDisplayOfTheCorrectedQuery(String arg1) throws Throwable {
        WebElement result = searchResultsPage.correctedResultsLink();
        SoftAssert softly = new SoftAssert();
        softly.assertTrue(result.isDisplayed(), "The corrected results link is not present");
        softly.assertTrue(result.getText().contains(arg1), "Link '" + result.getText() + "' does not contain text '" + arg1 + "'");
        softly.assertAll();
    }

    @And("^the user is able to select the link to the corrected search results$")
    public void theUserIsAbleToSelectTheLinkToTheCorrectedSearchResults() throws Throwable {
        searchResultsPage.correctedResultsLink().click();
    }

    @And("^the user is able to verify that the free text field now contains the term \"(.*?)\"$")
    public void theUserIsAbleToVerifyThatTheFreeTextFieldNowContainsTheTerm(String arg1) throws Throwable {
        assertTrue(searchResultsPage.freeTextSearchField().getAttribute("value").equals(arg1));
    }

    @When("^the user clicks on \"(.*?)\" link$")
    public void theUserClicksOnLink(String linkText) {
        commonMethods.clickLink(linkText);
        commonMethods.waitForPageToLoadAndJQueryProcessing();
    }

    @When("^the highlight checkbox is selected$")
    public void highlightCheckboxIsSelected() throws Throwable {
        assertTrue("Highlight checkbox is not selected", knowHowDocumentPage.isHighlightedOptionCheckboxSelected());
    }

    @Then("^the highlight checkbox is deselected$")
    public void highlightCheckboxIsDeselected() throws Throwable {
        Assert.assertFalse("Highlight checkbox is selected", knowHowDocumentPage.isHighlightedOptionCheckboxSelected());
    }

    @And("^the user deselect highlight checkbox$")
    public void userSelectHighlightCheckbox() throws Throwable {
        knowHowDocumentPage.highlightedOptionCheckbox().click();
    }


    @And("^the user navigates back$")
    public void theUserNavigatesBack() throws Throwable {
        searchResultsPage.browserGoBack();
    }


}
