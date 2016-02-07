package com.thomsonreuters.urls.step_definitions.knowHow;

import com.thomsonreuters.pageobjects.otherPages.NavigationCobalt;
import com.thomsonreuters.pageobjects.pages.urls.plcuk.KHDocumentPage;
import com.thomsonreuters.pageobjects.pages.urls.plcuk.PLCUKPage;
import com.thomsonreuters.urls.step_definitions.BaseStepDef;
import cucumber.api.java.en.Then;

import java.util.Set;

import static org.junit.Assert.assertTrue;
import static com.thomsonreuters.pageobjects.utils.urls.URLsUtils.getDocumentPlcRef;

public class rendoringKHDocumentByURL extends BaseStepDef {

    public static final String REGEX_KH_DOC_URL = ".+(com/)(\\w{1})-(\\d{3})-(\\d{4}).+";

    private NavigationCobalt navigation = new NavigationCobalt();
    private PLCUKPage plcukPage = new PLCUKPage();
    private KHDocumentPage khDocumentPage = new KHDocumentPage();

    @Then("^all links to KH Documents with PLC Ref on the page takes user to correct page$")
    public void allLinksToKHDocumentsOnThePageTakesUserToCorrectPage() throws Throwable {
        Set<String> urlsSet = plcukPage.getAllLinksMatches(REGEX_KH_DOC_URL);
        String currentURL = plcukPage.getCurrentUrl();
        String docPlcRef = getDocumentPlcRef(currentURL);
        for (String url : urlsSet) {
            if (url.matches(".+com/" + docPlcRef + ".+")) {
                continue;
            }
            navigation.navigate(url);
            navigation.waitForPageToLoadAndJQueryProcessing();
            assertTrue("Document block doesn't present on: " + url, khDocumentPage.isDocumentBlockPresent());
        }
    }

    @Then("^all links to KH Documents with PLC Ref on the page takes user to page with PLCRef$")
    public void allLinksToKHDocumentsOnThePageTakesUserToPageWithPLCRef() throws Throwable {
        Set<String> urlsSet = plcukPage.getAllLinksMatches(REGEX_KH_DOC_URL);
        for (String url : urlsSet) {
            navigation.navigate(url);
            navigation.waitForPageToLoad();
            assertTrue("Document doesnt contain PLC ref: " + url, khDocumentPage.isURLmatches(REGEX_KH_DOC_URL));
        }
    }

    @Then("^current url contain PLC Ref$")
    public void currentUrlContainPLCRef() throws Throwable {
        assertTrue("URL doesnt contain PLC ref: " + khDocumentPage.getCurrentUrl(), khDocumentPage.isURLmatches(REGEX_KH_DOC_URL));
    }

}
