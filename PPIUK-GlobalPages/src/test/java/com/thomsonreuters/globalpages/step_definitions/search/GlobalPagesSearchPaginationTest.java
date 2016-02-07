package com.thomsonreuters.globalpages.step_definitions.search;

import com.thomsonreuters.globalpages.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.common.CommonMethods;
import com.thomsonreuters.pageobjects.pages.legalUpdates.LegalUpdatesResultsPage;
import com.thomsonreuters.pageobjects.pages.search.KnowHowSearchResultsPage;
import com.thomsonreuters.pageobjects.pages.search.SearchResultsPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class GlobalPagesSearchPaginationTest extends BaseStepDef {

    private LegalUpdatesResultsPage legalUpdatesResultsPage = new LegalUpdatesResultsPage();
    private KnowHowSearchResultsPage knowHowSearchResultsPage = new KnowHowSearchResultsPage();
    private CommonMethods commonMethods = new CommonMethods();
    private SearchResultsPage searchResultsPage = new SearchResultsPage();

    @Then("^the user selects the \"(.*?)\" from per page dropdown$")
    public void theUserSelectsThePerPagefromPerPageDropdown(String perPageNo) throws Throwable {
        if (!legalUpdatesResultsPage.resultsPerPageLink().getText().contains(perPageNo)) {
            knowHowSearchResultsPage.searchPerPageDrodownLink().click();
            for (WebElement link : knowHowSearchResultsPage.searchPerPageDrodownListItemLinks()) {
                if (link.getText().trim().contains(perPageNo)) {
                    link.click();
                    break;
                }
            }
            assertTrue("Count is not right..!", commonMethods.isTextPresent(knowHowSearchResultsPage.searchResultByCountLabel(), perPageNo, 5000));
        }
    }

    @And("^the user verifies that page \"(.*?)\" is selected$")
    public void theUserVerifiesThatPageIsSelected(String arg1) {
        searchResultsPage.currentSelectedPage(arg1).isDisplayed();
    }

    @Given("^the user is able to verify the presence of page number \"(.*?)\"$")
    public void theUserIsAbleToVerifyThePresenceOfPageNumber(String number) throws Throwable {
        searchResultsPage.pagination(number).isDisplayed();
    }

    @Given("^the user is able to select the link to the next page$")
    public void theUserIsAbleToSelectTheLinkToTheNextPage() throws Throwable {
        searchResultsPage.selectNextPage().click();
    }

    @Given("^the user is able to select the link to page \"(.*?)\"$")
    public void theUserIsAbleToSelectTheLinkToPage(String arg1) throws Throwable {
        searchResultsPage.pagination(arg1).click();
    }

    @When("^the user verifies the search results count \"(.*)\"$")
    public void theUserVerifiesTheSearchResultCount(String count) throws Throwable {
        String expectedCount = count.replaceAll("[^0-9]", "");
        String actualCount = knowHowSearchResultsPage.knowHowSearchResultCount().getText();
        actualCount = actualCount.replaceAll("[^0-9]", "");
        assertTrue(expectedCount + " not matching..!", actualCount.equalsIgnoreCase(expectedCount));
    }

    @Then("^the user is able to verify the presence of below page numbers$")
    public void theUserIsAbleToVerifyThePresenceOfPageNumbers(List<String> numbers) throws Throwable {
        for (String number : numbers) {
            searchResultsPage.pagination(number).isDisplayed();
        }
    }

    @Then("^user verifies the \"(.*?)\" present$")
    public void userVerifiesThePresent(String linkText) throws Throwable {
        boolean present = false;
        for (WebElement link : knowHowSearchResultsPage.searchPaginationItemLinks()) {
            if (link.getText().trim().equalsIgnoreCase(linkText)) {
                present = true;
                break;
            }
        }
        assertTrue(linkText + " not present..!", present);
    }

    @Then("^user verifies the navigation to \"(.*?)\" not present$")
    public void userVerifiesTheNotPresent(String linkText) throws Throwable {
        boolean notPresent = true;
        for (WebElement link : knowHowSearchResultsPage.searchPaginationItemLinks()) {
            if (link.getText().trim().equalsIgnoreCase(linkText)) {
                notPresent = false;
                break;
            }
        }
        assertTrue(linkText + " not present..!", notPresent);
    }

    @Then("^user clicks on \"(.*)\" link$")
    public void userClicksOnLink(String linkText) throws Throwable {
        commonMethods.waitElementByLinkText(linkText).click();
    }

    @Then("^clicks on the \"(.*?)\" pagination link$")
    public void clicksOnThePaginationLink(String pageNoOrText) throws Throwable {
        for (WebElement link : knowHowSearchResultsPage.searchPaginationItemLinks()) {
            if (link.getText().trim().equalsIgnoreCase(pageNoOrText)) {
                link.click();
                break;
            }
        }
    }

    @Then("^the user should be seeing \"(.*?)\" per page$")
    public void userShouldbeSeeingPerPage(String perPageNo) throws Throwable {
        int expectedNoOfResults = Integer.parseInt(perPageNo);
        commonMethods.waitForElement(knowHowSearchResultsPage.searchResultsItemsList().get(0), 5000);
        commonMethods.scrollUpOrDown(70000);
        int actualNoOfResults = knowHowSearchResultsPage.searchResultsItemsList().size();
        if (actualNoOfResults > expectedNoOfResults) {
            assertTrue("Number of results not matching: expected " + expectedNoOfResults + " , actual " + actualNoOfResults,
                    expectedNoOfResults == actualNoOfResults);
        }
    }

}
