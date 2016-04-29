package com.thomsonreuters.pageobjects.utils.search;

import com.thomsonreuters.pageobjects.common.CommonMethods;
import com.thomsonreuters.pageobjects.pages.plPlusResearchSearch.BaseResultsPage;
import com.thomsonreuters.pageobjects.pages.search.KnowHowSearchResultsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

/**
 * Created by Pavel_Ardenka on 10.11.2015.
 * Utils for working with search results
 */

public class SearchUtils {

    private static final String GLOSSARY_SEARCH_HIGHLIGHT_COLOR = "rgba(249, 249, 193, 1)";

    private KnowHowSearchResultsPage knowHowSearchResultsPage = new KnowHowSearchResultsPage();

    private CommonMethods commonMethods = new CommonMethods();

    /**
     * Check that every result contains one string from text. Method will check the part of word (without last two letters) because
     * word form can be another (e.g., user searches "company", but result contains "companies" word).
     * Method checks results with case ignoring
     * @param resultItems List with result elements {@link BaseResultsPage#getResultListWithFullText()}.
     * @param text List with one of expected strings which should be exists in every result
     * @return True if check passed. Otherwise - false.
     */
    public boolean isEveryResultContains(List<WebElement> resultItems, List<String> text) {
        for (WebElement oneResult : resultItems) {
            if (!isWordFoundIn(oneResult, text)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Get search results count as int
     * @return Search results count
     */
    public int getSearchResultsCountAsInt() {
        return commonMethods.getIntFromString(knowHowSearchResultsPage.waitKnowHowSearchResultCount().getText());
    }

    /**
     * Check that user query in result element is highlighted. Method check that all <span> elements in result element contain search query
     * and are highlighted using css-style.
     * Method checks results with case ignoring
     * @param element One of result elements {@link com.thomsonreuters.pageobjects.pages.plPlusKnowHowResources.GlossaryPage#glossaryTermsWithSearchTermList()}.
     * @param term String with user query which should be highlighted in every result
     * @return True if check passed. Otherwise - false.
     */
    public boolean isSearchWordHighlightedInGlossaryPage(WebElement element, String term) {
        for (WebElement spanElement : element.findElements(By.xpath("./span"))) {
            if((!spanElement.getText().trim().toLowerCase().contains(term))&&(!GLOSSARY_SEARCH_HIGHLIGHT_COLOR.equals(spanElement.getCssValue("background-color"))))
                return false;
        }
        return true;
    }

    //////////////////
    // Private methods
    //////////////////

    /**
     * Check if one word from list contains in text of given WebElement. Method will check the part of word
     * (without last two letters) because word form can be another
     * (e.g., the user searches "company", but result contains "companies" word).
     * @param where WebElement which text should contain one word from list
     * @param wordList Word list
     * @return True if check passed. Otherwise - false.
     */
    private boolean isWordFoundIn(WebElement where, List<String> wordList) {
        for (String oneWord : wordList) {
            String expectedWord = oneWord.substring(0, oneWord.length() - 2).toLowerCase();
            if (where.getText().toLowerCase().contains(expectedWord)) {
                return true;
            }
        }
        return false;
    }

}
