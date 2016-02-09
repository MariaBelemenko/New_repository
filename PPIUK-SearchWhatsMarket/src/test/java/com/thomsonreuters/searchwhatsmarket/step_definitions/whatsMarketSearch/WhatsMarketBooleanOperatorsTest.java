package com.thomsonreuters.searchwhatsmarket.step_definitions.whatsMarketSearch;

import com.thomsonreuters.pageobjects.common.CommonMethods;
import com.thomsonreuters.pageobjects.pages.search.*;
import com.thomsonreuters.searchwhatsmarket.step_definitions.BaseStepDef;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class WhatsMarketBooleanOperatorsTest extends BaseStepDef {

    private KnowHowSearchResultsPage knowHowSearchResultsPage = new KnowHowSearchResultsPage();
    private WhatsMarketSearchResultsPage whatsMarketSearchResultsPage = new WhatsMarketSearchResultsPage();
    private CommonMethods commonMethods = new CommonMethods();
    private KnowHowDocumentPage knowHowDocumentPage = new KnowHowDocumentPage();
    private WhatsMarketDocumentPage whatsMarketDocumentPage = new WhatsMarketDocumentPage();

    Integer[] resultArray = new Integer[10];

    @When("^the user gets the know how search result count and stores it as count \"(.*?)\"$")
    public void theUserGetsTheKnowHowSearchResultCountAndStoresItAsCount(Integer count) throws Throwable {
        String numberReturnedFromWebsite = knowHowSearchResultsPage.knowHowSearchResultCount().getText();
        numberReturnedFromWebsite = numberReturnedFromWebsite.replaceAll("[^0-9]", "");
        resultArray[count] = Integer.parseInt(numberReturnedFromWebsite);
    }

    @When("^the user verifies that the know how search result count \"(.*?)\" is less than \"(.*?)\"$")
    public void theUserVerifiesThatTheKnowHowSearchResultCountIsLessThan(Integer count1, Integer count2) throws Throwable {
        assertTrue(resultArray[count1] < resultArray[count2]);
    }

    @When("^the user opens the whats market result in position \"(.*?)\"$")
    public void theUserOpenTheWhatsMarketResultInPosition(String resultIndex) throws Throwable {
        whatsMarketSearchResultsPage.selectResultItemByIndex(resultIndex);
    }

    @Then("^the user verifies the search result contains the search terms \"(.*?)\" and also \"(.*?)\" within the full text$")
    public void theUserCanVerifyTheSearchResultContainsTheSearchTermsAndAlsoWithinTheFullText(String firstTerm, String secondTerm) throws Throwable {
        String docText = getFullText().toLowerCase();
        assertTrue(docText.contains(firstTerm));
        assertTrue(docText.contains(secondTerm));
    }

    @Then("^the result contains either of the results$")
    public void whatsMarketEitherOfTheResults(List<String> results) throws Throwable {
        int count, actualCount = 0;
        String resultParts[];
        String docText = getFullText().toLowerCase();
        for (String result : results) {
            resultParts = result.split("&");
            count = 0;
            for (String resultPart : resultParts) {
                if (docText.contains(resultPart.toLowerCase().trim())) {
                    if (++count == resultParts.length) {
                        actualCount++;
                    }
                }
            }
        }
        assertTrue(actualCount > 0);
    }

    @Then("^the user verifies the search result contains the search terms \"(.*?)\" as a phrase within the full text$")
    public void theUserVerifiesTheSearchResultContainsTheSearchTermsAsAPhraseWithinTheFullText(String phrase) throws Throwable {
        String docText = getFullText().toLowerCase();
        assertTrue(docText.contains(phrase));
    }

    @Then("^returns to the WM search results by Return to list$")
    public void returnstotheWMsearchresultsbyReturntolist() throws Throwable {
        commonMethods.waitElementByLinkText("Return to list").click();
    }

    @Then("^the user verifies the search result contains the search terms \"(.*?)\" \"(.*?)\" within a single paragraph in the full text$")
    public void theUserVerifiesTheSearchResultContainsTheSearchTermsWithinASingleParagraphInTheFullText(String firstTerm, String secondTerm) throws Throwable {
        assertTrue(isSearchTermsPresentInParagraph(CommonDocumentPage.TermsInSequence.NO, firstTerm, secondTerm));
    }

    @Then("^the user verifies the search result contains the search terms \"(.*?)\" \"(.*?)\" in the full text where the first precedes the second in the same paragraph$")
    public void theUserVerifiesTheSearchResultContainsTheSearchTermsInTheFullTextWhereTheFirstPrecedesTheSecondInTheSameParagraph(String firstTerm, String secondTerm) throws Throwable {
        Boolean result = false;
        /** Split the first term using the + plus character to represent more than one check on a term */
        String firstEachTerms[] = firstTerm.split("\\+");
        /** Split the second term using the + plus character to represent more than one check on a term */
        String secondEachTerms[] = secondTerm.split("\\+");
        for (int dataRow = 0; dataRow < firstEachTerms.length; dataRow++) {
            String firstTermToCheck = firstEachTerms[dataRow];
            for (int dataRowTwo = 0; dataRowTwo < secondEachTerms.length; dataRowTwo++) {
                String secondTermToCheck = secondEachTerms[dataRowTwo];
                if (!result) {
                    result = isSearchTermsPresentInParagraph(KnowHowDocumentPage.TermsInSequence.YES, firstTermToCheck, secondTermToCheck);
                } else {
                    /** Test has passed */
                    break;
                }
            }
        }
        assertTrue(result);
    }

    @Then("^the user verifies the search result contains the both search terms \"(.*?)\" \"(.*?)\" within \"(.*?)\" terms of each other within the full text$")
    public void theUserVerifiesTheSearchResultContainsTheBothSearchTermsWithinTermsOfEachOtherWithinTheFullText(String firstTerm, String secondTerm, String withInWords) throws Throwable {
        assertTrue(isSearchTermsPresentInParagraphWithInNumberOfWords(KnowHowDocumentPage.TermsInSequence.NO, Integer.valueOf(withInWords), firstTerm, secondTerm));
    }

    @Then("^the user verifies the search result contains the both search terms \"(.*?)\" \"(.*?)\" \"(.*?)\" terms of each other in the full text with the first preceding the second$")
    public void theUserVerifiesTheResultsWithNumberOfTermsWithEachOtherInSequence(String firstTerm, String secondTerm, String withInWords) throws Throwable {
        assertTrue("Unable to find the search terms with the preceding sequence", isSearchTermsPresentInParagraphWithInNumberOfWords(KnowHowDocumentPage.TermsInSequence.YES, Integer.valueOf(withInWords), firstTerm, secondTerm));
    }

    @Then("^the user verifies the search result contains the first search term \"(.*?)\" in the full text for the first term and not the second \"(.*?)\"$")
    public void theUserVerifiesTheSearchResultsContainsTheFirstSearchNotTheSecondOne(String firstTerm, String secondTerm) throws Throwable {
        String docText = getFullText().toLowerCase();
        assertTrue(docText.contains(firstTerm.toLowerCase().trim()));
        assertFalse(docText.contains(secondTerm.toLowerCase().trim()));
    }

    @Then("^the user verifies the search result contains the full text will contain the term \"(.*?)\" but not the term \"(.*?)\"$")
    public void theUserVerifiesThatThereIsNoPlurals(String term1, String term2) throws Throwable {
        String docText = getFullText().toLowerCase();
        assertTrue(docText.contains(term1));
        assertFalse(docText.contains(term2));
    }

    @Then("^the user verifies the search result contains the full text includes one or more of the variants$")
    public void theUserVerifiesTheResultContainsWithOneOrMoreVariants(List<String> results) throws Throwable {
        String docText = getFullText();
        int count = 0;
        for (String result : results) {
            if (docText.contains(result)) {
                count++;
            }
        }
        assertTrue(count > 0);
    }

    @Then("^the user verifies the search result contains the full text may include the following terms$")
    public void theUserVerifiesTheSearchResultContainsWordsStartingAndEndingWithGivenCriteria(List<String> results) throws Throwable {
        String docText = getFullText().toLowerCase();
        int count = 0;
        for (String result : results) {
            if (docText.contains(result.toLowerCase())) {
                count++;
            }
        }
        assertTrue(count > 0);
    }

    @Then("^the user verifies the search result contains the full text will include the following variants terms$")
    public void theSearchResultContainsVariantTerms(List<String> results) throws Throwable {
        String docText = getFullText().toLowerCase();
        int count = 0;
        for (String result : results) {
            if (docText.contains(result.toLowerCase())) {
                count++;
            }
        }
        assertTrue(count > 0);
    }

    @Then("^the user verifies the search result contains the full text will contains the term \"(.*?)\"$")
    public void theUserVerifiesTheBracetsSearchWillNotImpactTheTerm(String termText) throws Throwable {
        String docText = getFullText().toLowerCase();
        assertTrue(docText.contains(termText));
    }

    private String getFullText() {
        String docText;
        if (commonMethods.isCurrentDocumentFromKnowHow()) {
            docText = knowHowDocumentPage.getFullText();
        } else {
            docText = whatsMarketDocumentPage.getFullText();
        }
        return docText;
    }

    private boolean isSearchTermsPresentInParagraph(KnowHowDocumentPage.TermsInSequence termsInSequence, String firstTerm, String secondTerm) {
        if (commonMethods.isCurrentDocumentFromKnowHow()) {
            return knowHowDocumentPage.isSearchTermsPresentInParagraph(termsInSequence, firstTerm, secondTerm);
        } else {
            return whatsMarketDocumentPage.isSearchTermsPresentInParagraph(termsInSequence, firstTerm, secondTerm);
        }
    }

    private boolean isSearchTermsPresentInParagraphWithInNumberOfWords(KnowHowDocumentPage.TermsInSequence termsInSequence, int noOfTerms, String firstTerm, String secondTerm) {
        if (commonMethods.isCurrentDocumentFromKnowHow()) {
            return knowHowDocumentPage.isSearchTermsPresentInParagraphWithInNumberOfWords(termsInSequence, noOfTerms, firstTerm, secondTerm);
        } else {
            return whatsMarketDocumentPage.isSearchTermsPresentInParagraphWithInNumberOfWords(termsInSequence, noOfTerms, firstTerm, secondTerm);
        }
    }

}
