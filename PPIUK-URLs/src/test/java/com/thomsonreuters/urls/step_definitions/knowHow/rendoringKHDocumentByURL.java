package com.thomsonreuters.urls.step_definitions.knowHow;

import com.thomsonreuters.pageobjects.otherPages.NavigationCobalt;
import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document.StandardDocumentPage;
import com.thomsonreuters.pageobjects.pages.urls.plcuk.KHDocumentPage;
import com.thomsonreuters.pageobjects.pages.urls.plcuk.PLCUKPage;
import com.thomsonreuters.urls.step_definitions.BaseStepDef;

import cucumber.api.java.en.Then;

import java.util.Set;

import org.assertj.core.api.SoftAssertions;

import static org.junit.Assert.assertTrue;
import static com.thomsonreuters.pageobjects.utils.urls.URLsUtils.getDocumentPlcRef;

public class rendoringKHDocumentByURL extends BaseStepDef {

    public static final String REGEX_KH_DOC_URL = ".+(com/)(\\w{1})-(\\d{3})-(\\d{4}).+";

    private NavigationCobalt navigation = new NavigationCobalt();
    private PLCUKPage plcukPage = new PLCUKPage();
    private KHDocumentPage khDocumentPage = new KHDocumentPage();
    private StandardDocumentPage standardDocumentPage = new StandardDocumentPage();

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
    	SoftAssertions softly = new SoftAssertions();
        Set<String> urlsSet = plcukPage.getAllLinksMatches(REGEX_KH_DOC_URL);
        for (String url : urlsSet) {
            navigation.navigate(url);
            navigation.waitForPageToLoad();
            String resourceType = standardDocumentPage.resourceType().getText();
            if(resourceType.contains("Primary Source") || resourceType.contains("Case Page")) {
            	LOG.info(String.format("Document resource type is: <%s> ; primary source URL is: <%s> ; actual url is: <%s> ; This document should not contain PLCRef", resourceType, url, khDocumentPage.getCurrentUrl()));
            }
    		softly.assertThat(khDocumentPage.isURLmatches(REGEX_KH_DOC_URL)).overridingErrorMessage("URL does not contain PLCRef. actual address: <%s> , origianl url: <%s> , Resource type is: <%s>", khDocumentPage.getCurrentUrl(), url, resourceType).isTrue();
        }
        softly.assertAll();
    }

    @Then("^current url contain PLC Ref$")
    public void currentUrlContainPLCRef() throws Throwable {
        assertTrue("URL doesnt contain PLC ref: " + khDocumentPage.getCurrentUrl(), khDocumentPage.isURLmatches(REGEX_KH_DOC_URL));
    }

}
