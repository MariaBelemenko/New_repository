package com.thomsonreuters.searchknowhow.step_definitions.knowHowSearch;

import com.thomsonreuters.pageobjects.common.CommonMethods;
import com.thomsonreuters.pageobjects.pages.generic.PPIGenericDocDisplay;
import com.thomsonreuters.pageobjects.pages.search.CommonDocumentPage;
import com.thomsonreuters.pageobjects.pages.search.KnowHowDocumentPage;
import com.thomsonreuters.pageobjects.pages.search.WhatsMarketDocumentPage;
import com.thomsonreuters.searchknowhow.step_definitions.BaseStepDef;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.regex.Pattern;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class KnowHowBooleanOperatorsTest extends BaseStepDef {

    private PPIGenericDocDisplay ppiGenericDocDisplay = new PPIGenericDocDisplay();
    private CommonMethods commonMethods = new CommonMethods();
    private KnowHowDocumentPage knowHowDocumentPage = new KnowHowDocumentPage();
    private WhatsMarketDocumentPage whatsMarketDocumentPage = new WhatsMarketDocumentPage();

    @Then("^the displayed document will have the terms \"([^\"]*)\" marked up as hits$")
    public void theDisplayedDocumentWillHaveTheTermsMarkedUpAsHits(String searchTerms) throws Throwable {;
        Assert.assertTrue("Term '" + searchTerms + "' was not found", commonMethods.theDisplayedDocumentWillHaveTheTermsMarkedUpAsHits(searchTerms));
    }

    @Then("^the displayed document will not have the terms \"([^\"]*)\" marked up as hits$")
    public void theDisplayedDocumentWillNotHaveTheTermsMarkedUpAsHits(String searchTerms) throws Throwable {;
        Assert.assertFalse("Term '" + searchTerms + "' was not found", commonMethods.theDisplayedDocumentWillHaveTheTermsMarkedUpAsHits(searchTerms));
    }

    @Then("^the displayed document will have any of the terms \"([^\"]*)\" marked up as hits$")
    public void theDisplayedDocumentWillHaveAnyOfTheTermsMarkedUpAsHits(String searchTerms) throws Throwable {
        Assert.assertTrue("Term '" + searchTerms + "' was not found", commonMethods.theDisplayedDocumentWillHaveAnyOfTheTermsMarkedUpAsHits(searchTerms));
        commonMethods.theDisplayedDocumentWillHaveAnyOfTheTermsMarkedUpAsHits(searchTerms);
    }

    @Then("^the user verifies the search result contains the search terms \"(.*?)\" as a phrase within the full text$")
    public void theUserVerifiesTheSearchResultContainsTheSearchTermsAsAPhraseWithinTheFullText(String phrase) throws Throwable {
        String docText = getFullText().toLowerCase();
        assertTrue(docText.contains(phrase));
    }

    @Then("^the user verifies the search result contains the search terms \"(.*?)\" \"(.*?)\" within a single paragraph in the full text$")
    public void theUserVerifiesTheSearchResultContainsTheSearchTermsWithinASingleParagraphInTheFullText(String firstTerm, String secondTerm) throws Throwable {
        assertTrue(isSearchTermsPresentInParagraph(CommonDocumentPage.TermsInSequence.NO, firstTerm, secondTerm));
    }

    @Then("^the user verifies the search result contains the search terms \"(.*?)\" \"(.*?)\" in the full text where the first precedes the second in the same paragraph$")
    public void theUserVerifiesTheSearchResultContainsTheSearchTermsInTheFullTextWhereTheFirstPrecedesTheSecondInTheSameParagraph(String firstTerm, String secondTerm)  throws Throwable {
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
        firstTerm = firstTerm.toLowerCase().trim();
        secondTerm = secondTerm.toLowerCase().trim();
        assertTrue(docText.contains(firstTerm));
        assertFalse(docText.contains(secondTerm));
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

    @Then("^the user verifies the search result contains the full text will contain the term \"(.*?)\" but not the term \"(.*?)\"$")
    public void theUserVerifiesThatThereIsNoPlurals(String term1, String term2) throws Throwable {
        String docText = getFullText().toLowerCase();
        assertTrue(docText.contains(term1));
        assertFalse(docText.contains(term2));
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

    @Then("^the user verifies the search result contains the search terms \"(.*?)\" and also \"(.*?)\" within the full text$")
    public void theUserCanVerifyTheSearchResultContainsTheSearchTermsAndAlsoWithinTheFullText(String firstTerm, String secondTerm) throws Throwable {
        String docText = getFullText().toLowerCase();
        assertTrue(docText.contains(firstTerm));
        assertTrue(docText.contains(secondTerm));
    }

    @Then("^the selected full text contains the term \"(.*?)\" but not the term \"(.*?)\" and the word \"(.*?)\" is accompanied by the word \"(.*?)\" in the same paragraph$")
    public void theUserVerifiesTheTermSearching(String term1, String term2, String term3, String term4) throws Throwable {
        String docText = null;
        docText = knowHowDocumentPage.getFullText().toLowerCase();
        assertTrue(docText.contains(term1.toLowerCase().trim()));
        assertFalse(docText.contains(term2.toLowerCase().trim()));
        assertTrue(isSearchTermsPresentInParagraph(KnowHowDocumentPage.TermsInSequence.NO, term3, term4));
    }

    @Then("^the user is able to verify that the full text will not contain the term \"(.*?)\"$")
    public void theUserVerifiesThatThereIsNoPluralwords(String term1) throws Throwable {
        String docText = getFullText();
        assertFalse(docText.contains(" " + term1 + " "));
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
