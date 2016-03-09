package com.thomsonreuters.smoke.step_definitions;

import com.google.common.collect.Lists;
import com.thomsonreuters.pageobjects.common.CommonMethods;
import com.thomsonreuters.pageobjects.otherPages.NavigationCobalt;
import com.thomsonreuters.pageobjects.pages.ask.AskCategoryPage;
import com.thomsonreuters.pageobjects.pages.ask.AskFormPage;
import com.thomsonreuters.pageobjects.pages.ask.AskResourcePage;
import com.thomsonreuters.pageobjects.pages.landingPage.WhatsMarketHomePage;
import com.thomsonreuters.pageobjects.pages.pageCreation.HomePage;
import com.thomsonreuters.pageobjects.pages.plPlusKnowHowResources.GlossaryPage;
import com.thomsonreuters.pageobjects.pages.plPlusKnowHowResources.KHResourcePage;
import com.thomsonreuters.pageobjects.pages.search.SearchResultsPage;
import com.thomsonreuters.pageobjects.pages.search.WhatsMarketComparisonReportPage;
import com.thomsonreuters.pageobjects.pages.search.WhatsMarketSearchResultsPage;
import com.thomsonreuters.pageobjects.utils.ask.AskFormField;
import com.thomsonreuters.pageobjects.utils.form.FormUtils;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.TransformerUtils;
import org.hamcrest.core.Is;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebElement;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertTrue;

public class ProdResourcesTest extends BaseStepDef {

    private HomePage homePage = new HomePage();
    private GlossaryPage glossaryPage = new GlossaryPage();
    private WhatsMarketHomePage whatsMarketHomePage = new WhatsMarketHomePage();
    private SearchResultsPage searchResultsPage = new SearchResultsPage();
    private WhatsMarketSearchResultsPage whatsMarketSearchResultsPage = new WhatsMarketSearchResultsPage();
    private WhatsMarketComparisonReportPage whatsMarketComparisonReportPage = new WhatsMarketComparisonReportPage();
    private AskCategoryPage askCategoryPage = new AskCategoryPage();
    private AskResourcePage askResourcePage = new AskResourcePage();
    private NavigationCobalt navigationCobalt = new NavigationCobalt();
    private KHResourcePage resourcePage = new KHResourcePage();
    private CommonMethods commonMethods = new CommonMethods();
    private AskFormPage askFormPage = new AskFormPage();
    private FormUtils formUtils = new FormUtils();

    private String askWindowHandle;

    private static final String ASK_DISCLAIMER_TEXT = "Practical Law may have moderated questions and answers before publication. No answer to a question is legal advice and no lawyer-client relationship is created between the person asking the question and the person answering it. Where appropriate, you should consult your own lawyer for legal advice. Practical Law's employees are not practising solicitors or barristers. The Ask scope and rules apply.";

    @When("^user navigates to a glossary page$")
    public void userNavigatesToAGlossaryPage() throws Throwable {
        homePage.selectResourceTab();
        homePage.selectLinkPresentOnTab("Glossary");
        assertThat("Glossary heading is not displayed", glossaryPage.glossaryHeading().isDisplayed(), Is.is(true));
    }

    @When("^searches for the term \"(.*?)\" using the glossary search$")
    public void searchesForTheTermUsingTheGlossarySearch(String term) throws Throwable {
        glossaryPage.glossarySearchField().sendKeys(term);
    }

    @Then("^the user should be able to see a list of resulting glossary terms containing this search term \"(.*?)\"$")
    public void theUserShouldBeAbleToSeeAListOfResultingGlossaryTermsContainingThisSearch(String term) throws Throwable {
        for (String glossarySearchResult : glossaryPage.getGlossarySearchResultsList()) {
            assertTrue(glossarySearchResult.toLowerCase().contains(term.toLowerCase()));
        }
    }

    @Then("^the first result item's definition should be displayed in the right hand pane$")
    public void theFirstResultItemSDefinitionShouldBeDisplayedInTheRightHandPane() throws Throwable {
        assertTrue(glossaryPage.glossaryHeading().getText().trim().contains(glossaryPage.glossaryTermsWithSearchTermList().get(0).getText().trim()));
    }

    @When("^the user selects the link entitled Whats Market UK Home$")
    public void theUserSelectsTheLinkEntitledWhatsMarketUkHome() throws Throwable {
        homePage.selectResourceTab();
        homePage.selectLinkPresentOnTab("What's Market");
    }

    @When("^has selected the link to the deal type \"([^\"]*)\"$")
    public void hasSelectedTheLinkToTheDealType(String arg1) throws Throwable {
        if (arg1.equals("Administrations")) {
            whatsMarketHomePage.Administrations().click();
        } else if (arg1.equals("Public M & A"))
            whatsMarketHomePage.PublicMandALink().click();
    }

    @When("^the user selects the checkbox associated with whats market result \"([^\"]*)\"$")
    public void theUserSelectsTheCheckboxAssociatedWithWhatsMarketResult(String arg1) throws Throwable {
        searchResultsPage.resultCheckboxWhatsMarket(arg1).click();
    }

    @When("^the user selects the compare button$")
    public void theUserSelectsTheCompareButton() throws Throwable {
        whatsMarketSearchResultsPage.compareButton().click();
    }

    @When("^the user verifies the presence of the heading Deal Comparison Report$")
    public void theUserVerifiesThePresenceOfTheHeadingDealComparisonReport() throws Throwable {
        whatsMarketComparisonReportPage.dealComparisonReportHeader().isDisplayed();
    }

    @When("^the user verifies the presence of a column entitled \"([^\"]*)\"$")
    public void theUserVerifiesThePresenceOfAColumnEntitled(String arg1) throws Throwable {
        whatsMarketComparisonReportPage.columnHeader(arg1).isDisplayed();
    }

    @And("^the user clicks '(.*)' tab$")
    public void the_user_clicks_Recent_queries_tab(String tab) throws Throwable {
        if (tab.toLowerCase().contains("recent")) {
            askCategoryPage.recentQueriesTab().click();
        } else if (tab.toLowerCase().contains("featured")) {
            askCategoryPage.featuredQueriesTab().click();
        }
        askCategoryPage.waitForPageToLoad();
    }

    @Then("^the user verifies that (.*) '(\\d+)' (.*) questions are displayed$")
    public void the_user_verifies_that_exactly_questions_are_displayed(String matchType, int noOfresources, String queryType) throws Throwable {
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

    @When("^the user clicks featured query no (\\d+)$")
    public void the_user_clicks_featured_query_no(int index) throws Throwable {
        String link = askCategoryPage.featuredQueries().get(index - 1).getText().trim();
        Pattern pattern = Pattern.compile("(.*)\\?(.*)");
        Matcher m = pattern.matcher(link);
        if (m.find()) {
            link = m.group(0);
            askCategoryPage.waitForExpectedElement(By.linkText(link)).click();
        } else {
            throw new Exception("Unable to extract ask query from the Featured queries section on the page");
        }
    }

    @Given("^ask disclaimer is displayed on the document$")
    public void askDisclaimerIsDisplayed() throws Throwable {
        assertThat(askResourcePage.askDisclaimerText().getText().trim(), Is.is(ASK_DISCLAIMER_TEXT));
    }

    @When("^the user navigates to the main PLCUK page$")
    public void theUserNavigatesToTheMainPLCUKPage() throws Throwable {
        navigationCobalt.navigateToPLUKPlus();
        navigationCobalt.waitForPageToLoad();
    }

    @When("^the user clicks on 'Ask a question' link to ask a question$")
    public void theUserClicksASKILinkToAskAQuestion() throws Throwable {
        String mainWindowHandle = getDriver().getWindowHandle();
        resourcePage.askAQuestion().click();
        resourcePage.waitForPageToLoad();
    }

    @Then("^ASK form is displayed in new window$")
    public void askFormIsDisplayedInNewWindow() throws Throwable {
        commonMethods.switchToOpenedWindow();
        assertThat("Ask form is not displayed", askFormPage.askFormPageTitle().isDisplayed(), Is.is(true));
        askWindowHandle = commonMethods.getDriver().getWindowHandle();
    }

    @When("^the user accepts ASK disclaimer terms$")
    public void acceptsDisclaimerTerms() throws Throwable {
        askFormPage.disclaimerTermsCheckbox().click();
    }

    @Then("^the following fields are displayed on the form$")
    public void theFollowingFieldsAreDisplayedOnTheForm(List<String> fieldList) throws Throwable {
        for (String field : fieldList) {
            assertThat("Field " + field + " is displayed",
                    formUtils.findElement(AskFormField.getByFieldDisplayName(field)).isDisplayed(), Is.is(true));
        }
    }

    @Then("^user closes the ASK window$")
    public void userClosesASKWindow() throws Throwable {
        closesASKWindow();
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

    @After(order = 100000, value = "@CloseAskWindow")
    public void closesASKWindow() throws Throwable {
        try {
            if (askWindowHandle != null) {
                askFormPage.close();
                commonMethods.switchToMainWindow();
                askWindowHandle = null;
            }
        } catch (NoSuchWindowException e) {
            LOG.info("Error occurred at switch window process", e);
        }
        navigationCobalt.navigateToPLUKPlus();
    }

}
