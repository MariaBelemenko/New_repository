package com.thomsonreuters.pagecreation.step_definitions.categoryPage;

import com.thomsonreuters.pagecreation.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.pages.pageCreation.CommonPracticeAreaPage;
import com.thomsonreuters.pageobjects.pages.search.SearchResultsPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class PracticeAreaPageSteps extends BaseStepDef {

    private CommonPracticeAreaPage commonPracticeAreaPage;
    private SearchResultsPage searchResultsPage;
    private int NUMBER_OF_PAGES = 9;    //minimum pages number required to display navigation arrow

    public PracticeAreaPageSteps() {
        commonPracticeAreaPage = new CommonPracticeAreaPage();
        searchResultsPage = new SearchResultsPage();
    }

    @Then("^'add to favorites' and 'back to home' button are present$")
    public void addToFavoritesAndBackToHomeButtonArePresent() throws Throwable {
        commonPracticeAreaPage.addTpFavoritesButton().isDisplayed();
    }

    @Then("^the category tabs are present$")
    public void theCategoryTabsArePresent() throws Throwable {
        commonPracticeAreaPage.backToHomepageButton().isDisplayed();
    }

    @And("^the user verifies that page \"(.*?)\" is selected$")
    public void theUserVerifiesThatPageIsSelected(String pageNumber) {
        assertTrue("Selected page is not " + pageNumber, searchResultsPage.currentSelectedPage(pageNumber).isDisplayed());
    }

    @And("^the user verifies the presence of a next page navigation arrow$")
    public void theUserVerifiesThePresenceOfANextPageNavigationArrow() {
        if (searchResultsPage.getLinksToPages().size() > NUMBER_OF_PAGES){
            assertTrue("Navigation arrow is not present on the page", searchResultsPage.nextPageNavigationArrow().isDisplayed());
        }
    }

    @And("^the user selects document type '(.*)'$")
    public void theUserSelectsDocumentType(String docType) {
        List<WebElement> facetList = searchResultsPage.getTopicPageFacetsAsList();
        assertFalse("Facet list is empty", facetList.isEmpty());
        for (WebElement facet : facetList) {
            if (doesStringContainEverySingleWord(facet.getText().toLowerCase(), docType.toLowerCase())) {
                facet.click();
                return;
            }
        }
    }

    private boolean doesStringContainEverySingleWord(String fullString, String words){
        String[] splited = words.split("\\s+");
        for (String word : splited){
            if (!fullString.contains(word)){
                return false;
            }
        }
        return true;
    }

    @Then("^the user selects random document in the '(.*)' category$")
    public void  theUserSelectsRandomDocumentInTheCategory(String category){
        int size = searchResultsPage.getCurrentCategoryLinks(category).size();
        assertFalse("No documents in the selected category", size == 0);
        int position = ThreadLocalRandom.current().nextInt(0, size);
        searchResultsPage.clickOnDocumentInGroupByIndex(++position, category);
    }

    @Then("^the user verifies the presence of all practice area document sections$")
    public void theUserVerifiesThePresenceOfAllPracticeAreaDocumentSections() {
        SoftAssertions softly = new SoftAssertions();
        commonPracticeAreaPage.waitForPageToLoad();
        softly.assertThat(commonPracticeAreaPage.documentTitlePanel().isDisplayed()).overridingErrorMessage("Document title is not present on the page").isTrue();
        softly.assertThat(commonPracticeAreaPage.endOfDocument().isDisplayed()).overridingErrorMessage("'End of the document' section is not present on the page").isTrue();
        softly.assertThat(commonPracticeAreaPage.jurisdictionLabel().isDisplayed()).overridingErrorMessage("Metadata doesn't contain jurisdiction field").isTrue();
        softly.assertThat(commonPracticeAreaPage.contentMetaInfo().isDisplayed()).overridingErrorMessage("Status doesn't contain 'Maintained' field").isTrue();
        softly.assertThat(commonPracticeAreaPage.resourceTypeText().isDisplayed()).overridingErrorMessage("Status doesn't contain 'Resource type' field").isTrue();
        softly.assertThat(commonPracticeAreaPage.getResourceId().isDisplayed()).overridingErrorMessage("'Resource information' section is not present on the page").isTrue();
        softly.assertThat(commonPracticeAreaPage.deliveryOptions().isDisplayed()).overridingErrorMessage("'Document actions' section is not present on the page").isTrue();
        softly.assertAll();
    }

    @Then("^the user clicks on 'Return to list'$")
    public void theUserClicksOnReturnToList() {
        commonPracticeAreaPage.returnToSearchLink().click();
        assertTrue("Search result page was not downloaded", searchResultsPage.searchPageLabel().isDisplayed());
    }
}