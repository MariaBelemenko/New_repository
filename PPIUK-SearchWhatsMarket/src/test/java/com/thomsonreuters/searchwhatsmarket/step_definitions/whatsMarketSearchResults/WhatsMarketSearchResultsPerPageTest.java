package com.thomsonreuters.searchwhatsmarket.step_definitions.whatsMarketSearchResults;

import com.thomsonreuters.pageobjects.pages.landingPage.PracticalLawUKCategoryPage;
import com.thomsonreuters.pageobjects.pages.search.KnowHowSearchResultsPage;
import com.thomsonreuters.pageobjects.pages.search.SearchResultsPage;
import com.thomsonreuters.searchwhatsmarket.step_definitions.BaseStepDef;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.awt.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class WhatsMarketSearchResultsPerPageTest extends BaseStepDef {

    private PracticalLawUKCategoryPage practicalLawUKCategoryPage = new PracticalLawUKCategoryPage();
    private KnowHowSearchResultsPage knowHowSearchResultsPage = new KnowHowSearchResultsPage();
    private SearchResultsPage searchResultsPage = new SearchResultsPage();

    @When("^the user selects the option to display \"([^\"]*)\" of results per page$")
    public void theUserSelectsTheOptionToDisplayOfResultsPerPage(String number) throws Throwable {
        practicalLawUKCategoryPage.resultsPerPageDropdown(number);
        knowHowSearchResultsPage.waitForSearchResults();
    }

    @Then("^the user is able to verify the presence of text confirming that results \"([^\"]*)\" are displayed on the page$")
    public void theUserIsAbleToVerifyThePresenceOfTextConfirmingThatResultsAreDisplayedOnThePage(String results) throws Throwable {
        WebElement heading = searchResultsPage.resultsPerPageText();
        assertTrue(heading.getText().contains(results));
    }

    @Then("^the user is able to verify the presence of whats market search result \"(.*?)\"$")
    public void theUserIsAbleToVerifyThePresenceOfWhatsMarketSearchResult(String rank) throws Throwable {
        searchResultsPage.resultNumberWM(rank).isDisplayed();
    }

    @Then("^the user can verify that the search result total contains text confirming that the specified number \"(.*?)\" of results are displayed$")
    public void theUserCanVerifyThatTheSearchResultTotalContainsTextConfirmingThatTheSpecifiedNumberOfResultsAreDisplayed(String number) throws Throwable {
        WebElement text = searchResultsPage.searchResultsTotal(number);
        assertTrue(text.getText().contains(number));
    }

    @And("^the user verifies the presence of page number \"(.*?)\"$")
    public void theUserVerifiesThePresenceOfPageNumber(String arg1) throws Throwable {
        searchResultsPage.currentSelectedPage(arg1).isDisplayed();
    }

    @And("^the user verifies that page \"(.*?)\" is selected$")
    public void theUserVerifiesThatPageIsSelected(String arg1) throws Throwable {
        searchResultsPage.currentSelectedPage(arg1).isDisplayed();
    }

    @And("^the user verifies the presence of a next page navigation arrow$")
    public void theUserVerifiesThePresenceOfANextPageNavigationArrow() throws Throwable {
        searchResultsPage.nextPageNavigationArrow().isDisplayed();
    }

    @And("^the user verifies the presence of a last page navigation arrow$")
    public void theUserVerifiesThePresenceOfALastPageNavigationArrow() throws Throwable {
        searchResultsPage.lastPageNavigationArrow().isDisplayed();
    }

    @And("^the user selects page number \"(.*?)\"$")
    public void theUserSelectsPageNumber(String pageToClick) throws Throwable {
        String resultCheck = "";
        Integer timeout = 0;
        Boolean waitForNewPage = true;
        /** A robot to allow a pause for the page to refresh */
        Robot robot = new Robot();
        robot.delay(5000);
        while (waitForNewPage) {
            try {
                searchResultsPage.nonSelectedPage(pageToClick).click();
            } catch (NoSuchElementException e) {
                LOG.info("Non-selected page is absent", e);
            }
            try {
                searchResultsPage.currentSelectedPage(pageToClick).isDisplayed();
                waitForNewPage = false;
            } catch (NoSuchElementException e) {
                LOG.info("Currently selected page is absent", e);
                waitForNewPage = true;
            }
            if (waitForNewPage) {
                robot.delay(3000);
                timeout = timeout + 1;
                if (timeout > 2) {
                    /** Quit out if the page simply isn't appearing */
                    waitForNewPage = false;
                }
            }
        }
    }

    @And("^the user verifies the presence of a previous page navigation arrow$")
    public void theUserVerifiesThePresenceOfAPreviousPageNavigationArrow() throws Throwable {
        searchResultsPage.previousPageNavigationArrow().isDisplayed();
    }

    @And("^the user verifies the presence of a first page navigation arrow$")
    public void theUserVerifiesThePresenceOfAFirstPageNavigationArrow() throws Throwable {
        searchResultsPage.firstPageNavigationArrow().isDisplayed();
    }

    @And("^the user selects the next page navigation arrow$")
    public void theUserSelectsTheNextPageNavigationArrow() throws Throwable {
        Integer timeout = 0;
        Boolean waitForNewPage = true;
        Robot robot = new Robot();
        robot.delay(5000);
        String pageToClick = Integer.toString(searchResultsPage.currentSelectedPageNumber() + 1);
        searchResultsPage.nextPageNavigationArrow().click();
        while (waitForNewPage){
            try {
                searchResultsPage.currentSelectedPage(pageToClick).isDisplayed();
                waitForNewPage = false;
            } catch (NoSuchElementException e) {
                LOG.info("Currently selected page is absent", e);
                waitForNewPage = true;
            }
            if (waitForNewPage) {
                robot.delay(3000);
                timeout = timeout + 1;
                if (timeout > 2) {
                    waitForNewPage = false;
                }
            }
        }
    }

    @And("^the user selects the first page navigation arrow$")
    public void theUserSelectsTheFirstPageNavigationArrow() throws Throwable {
        String numberOfFirstResult = "";
        String resultCheck = "";
        Integer timeout = 0;
        Boolean waitForNewPage = true;
        Robot robot = new Robot();
        numberOfFirstResult = searchResultsPage.theFirstSearchResult().getText();
        while (waitForNewPage){
            try {
                searchResultsPage.firstPageNavigationArrow().click();
            }
            catch (NoSuchElementException e) {
                LOG.info("'First page' navigation arrow is absent", e);
            }
            try {
                resultCheck = searchResultsPage.theFirstSearchResult().getText();
            }
            catch (NoSuchElementException e) {
                LOG.info("There are no search results", e);
                resultCheck = numberOfFirstResult;
            }
            if (!resultCheck.equals(numberOfFirstResult)) {
                waitForNewPage = false;
            } else {
                robot.delay(3000);
                timeout = timeout + 1;
                if (timeout > 3) {
                    waitForNewPage = false;
                }
            }
        }
    }

    @And("^the user selects the last page navigation arrow$")
    public void theUserSelectsTheLastPageNavigationArrow() throws Throwable {
        String numberOfFirstResult = "";
        String resultCheck = "";
        Integer timeout = 0;
        Boolean waitForNewPage = true;
        Robot robot = new Robot();
        numberOfFirstResult = searchResultsPage.theFirstSearchResult().getText();
        while (waitForNewPage){
            try {
                searchResultsPage.lastPageNavigationArrow().click();
            }
            catch (NoSuchElementException e) {
                LOG.info("'Last page' navigation arrow is absent", e);
            }
            try {
                resultCheck = searchResultsPage.theFirstSearchResult().getText();
            }
            catch (NoSuchElementException e) {
                LOG.info("There are no search results", e);
                resultCheck = numberOfFirstResult;
            }
            if (!resultCheck.equals(numberOfFirstResult)) {
                waitForNewPage = false;
            } else {
                robot.delay(3000);
                timeout = timeout + 1;
                if (timeout > 3) {
                    waitForNewPage = false;
                }
            }
        }
    }

    @And("^the user selects the previous page navigation arrow$")
    public void theUserSelectsThePreviousPageNavigationArrow() throws Throwable {
        Integer timeout = 0;
        Boolean waitForNewPage = true;
        Robot robot = new Robot();
        robot.delay(5000);
        String pageToClick = Integer.toString(searchResultsPage.currentSelectedPageNumber() - 1);
        searchResultsPage.previousPageNavigationArrow().click();
        while (waitForNewPage){
            try {
                searchResultsPage.currentSelectedPage(pageToClick).isDisplayed();
                waitForNewPage = false;
            }
            catch (NoSuchElementException e) {
                LOG.info("Current selected page is absent", e);
                waitForNewPage = true;
            }
            if (waitForNewPage) {
                robot.delay(3000);
                timeout = timeout + 1;
                if (timeout > 2) {
                    waitForNewPage = false;
                }
            }
        }
    }

    @And("^the user verifies that the next page navigation arrow is no longer displayed$")
    public void theUserVerifiesThatTheNextPageNavigationArrowIsNoLongerDisplayed() throws Throwable {
        Boolean isPresent = false;
        try {
            searchResultsPage.nextPageNavigationArrow().isDisplayed();
            isPresent = true;
        }
        catch (Exception e) {
            LOG.info("'Next page' navigation arrow is absent", e);
        }
        assertFalse(isPresent);
    }

    @And("^the user verifies that the last page navigation arrow is no longer displayed$")
    public void theUserVerifiesThatTheLastPageNavigationArrowIsNoLongerDisplayed() throws Throwable {
        Boolean isPresent = false;
        try {
            searchResultsPage.lastPageNavigationArrow().isDisplayed();
            isPresent = true;
        }
        catch (Exception e) {
            LOG.info("'Last page' navigation arrow is absent", e);
        }
        assertFalse(isPresent);
    }

    @And("^the user verifies that the previous page navigation arrow is no longer displayed$")
    public void theUserVerifiesThatThePreviousPageNavigationArrowIsNoLongerDisplayed() throws Throwable {
        Boolean isPresent = false;
        try {
            searchResultsPage.previousPageNavigationArrow().isDisplayed();
            isPresent = true;
        }
        catch (Exception e) {
            LOG.info("'Previous page' navigation arrow is absent", e);
        }
        assertFalse(isPresent);
    }

    @And("^the user verifies that the first page navigation arrow is no longer displayed$")
    public void theUserVerifiesThatTheFirstPageNavigationArrowIsNoLongerDisplayed() throws Throwable {
        Boolean isPresent = false;
        try {
            searchResultsPage.firstPageNavigationArrow().isDisplayed();
            isPresent = true;
        }
        catch (Exception e) {
            LOG.info("'First page' navigation arrow is absent", e);
        }
        assertFalse(isPresent);
    }

}