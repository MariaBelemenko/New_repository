package com.epam.TestNG.htmlElements.pageObjects;

import com.epam.TestNG.htmlElements.blocks.SearchFunction;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

/**
 * Created by Mariya_Belemenko on 6/26/2016.
 */
public class SearchPage {

    private SearchFunction searchFunction = new SearchFunction();

    String SEARCH_QUERY = "cheese";

    public SearchPage(WebDriver driver) {
        HtmlElementLoader.populatePageObject(this, driver);
    }

    public void search(String request) {
        searchFunction.search(request);
    }
}
