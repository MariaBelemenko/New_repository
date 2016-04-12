package com.thomsonreuters.searchknowhow.step_definitions.knowHowSearchResults;

import com.thomsonreuters.pageobjects.common.CommonMethods;
import com.thomsonreuters.pageobjects.pages.search.KnowHowDocumentPage;
import com.thomsonreuters.pageobjects.pages.search.KnowHowSearchResultsPage;
import com.thomsonreuters.pageobjects.pages.search.SearchResultsPage;
import com.thomsonreuters.searchknowhow.step_definitions.BaseStepDef;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class SearchRelatedFunctionalitiesTest extends BaseStepDef {

    private KnowHowSearchResultsPage knowHowSearchResultsPage = new KnowHowSearchResultsPage();
    private SearchResultsPage searchResultsPage = new SearchResultsPage();
    private KnowHowDocumentPage knowHowDocumentPage = new KnowHowDocumentPage();
    private CommonMethods commonMethods = new CommonMethods();

    @When("^the user is able to verify that sample results contain a date in the \"([^\"]*)\" format$")
    public void theUserIsAbleToVerifyThatSampleResultsContainADateInTheDDMMMYYYYFormat(String dateformat) throws Throwable {
        String dateString[] = knowHowSearchResultsPage.date().getText().split("Published on ");
        String dateToValidate = dateString[1];
        SimpleDateFormat sdf = new SimpleDateFormat(dateformat);
        sdf.setLenient(false);
        /** If not valid, it will throw ParseException */
        Date date = sdf.parse(dateToValidate);
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
        for (String number : numbers) {
            searchResultsPage.pagination(number).isDisplayed();
        }
    }

    @Given("^the user is able to select the link to page \"(.*?)\"$")
    public void theUserIsAbleToSelectTheLinkToPage(String arg1) throws Throwable {
        searchResultsPage.pagination(arg1).click();
    }

    @Then("^the user is able to verify that for result \"([^\"]*)\" the search term \"([^\"]*)\" is highlighted within the snippet text$")
    public void theUserIsAbleToVerifyThatForResultTheSearchContractIsHighlightedWithinTheSnippetText(String rank, String highlightedTerm) throws Throwable {
        searchResultsPage.highlightedSearchTerm(rank, highlightedTerm).isDisplayed();
    }

    @Then("^the user is able to verify that the search term \"([^\"]*)\" is highlighted in opened document$")
    public void theUserIsAbleToVerifyThatTheSearchTermIsHighlighted(String highlightedTerm) throws Throwable {
    	knowHowDocumentPage.waitForPageToLoadAndJQueryProcessing();
    	assertTrue("There are no highliighted search terms in document",knowHowDocumentPage.isSearchTermHighlighted(highlightedTerm));
    }
    
    @Then("^the user is able to verify that the search term \"([^\"]*)\" is not highlighted in opened document$")
    public void theUserIsAbleToVerifyThatTheSearchTermIsNotHighlightedInOpenedDocument(String highlightedTerm) throws Throwable {
    	knowHowDocumentPage.waitForPageToLoadAndJQueryProcessing();
    	Assert.assertFalse("Search terms are highlighted in document",knowHowDocumentPage.isSearchTermHighlighted(highlightedTerm));
    }
    
    @When("^the user can verify the presence of the text No Documents Found$")
    public void theUserCanVerifyThePresenceOfTheTextNoDocumentsFound() throws Throwable {
        searchResultsPage.noDocumentsFoundText().isDisplayed();
    }

    @Then("^the user is able to verify the display of the text Did You Mean$")
    public void theUserIsAbleToVerifyTheDisplayOfTheTextDidYouMean() throws Throwable {
        assertTrue(searchResultsPage.isDidYouMeanTextDisplayed());
    }

    @Then("^the user is able to verify the display of the corrected query \"(.*?)\"$")
    public void theUserIsAbleToVerifyTheDisplayOfTheCorrectedQuery(String arg1) throws Throwable {
        WebElement result = searchResultsPage.correctedResultsLink();
        assertTrue(result.isDisplayed());
        assertTrue(result.getText().contains(arg1));
    }

    @Then("^the user is able to select the link to the corrected search results$")
    public void theUserIsAbleToSelectTheLinkToTheCorrectedSearchResults() throws Throwable {
        searchResultsPage.correctedResultsLink().click();
    }

    @Then("^the user is able to verify that the free text field now contains the term \"(.*?)\"$")
    public void theUserIsAbleToVerifyThatTheFreeTextFieldNowContainsTheTerm(String arg1) throws Throwable {
        assertTrue(searchResultsPage.freeTextSearchField().getAttribute("value").equals(arg1));
    }
    
    @When("^the user clicks on \"(.*?)\" link$")
    public void theUserClicksOnLink(String linkText) {
        commonMethods.clickLink(linkText);
        commonMethods.waitForPageToLoadAndJQueryProcessing();
    }

    @Then("^the highlight checkbox is selected$")
    public void highlightCheckboxIsSelected() throws Throwable {
        assertTrue("Highlight checkbox is not selected",knowHowDocumentPage.isHighlightedOptionCheckboxSelected());
    }
    
    @Then("^the highlight checkbox is deselected$")
    public void highlightCheckboxIsDeselected() throws Throwable {
    	Assert.assertFalse("Highlight checkbox is selected",knowHowDocumentPage.isHighlightedOptionCheckboxSelected());
    }

    @When("^the user deselect highlight checkbox$")
    public void userSelectHighlightCheckbox() throws Throwable {
    	knowHowDocumentPage.highlightedOptionCheckbox().click();
    }



    @When("^the user navigates back$")
    public void theUserNavigatesBack() throws Throwable {
    	searchResultsPage.browserGoBack();
    }


}
