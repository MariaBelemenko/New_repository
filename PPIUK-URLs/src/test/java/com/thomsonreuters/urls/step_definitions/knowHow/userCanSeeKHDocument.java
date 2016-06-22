package com.thomsonreuters.urls.step_definitions.knowHow;

import com.thomsonreuters.pageobjects.otherPages.NavigationCobalt;
import com.thomsonreuters.pageobjects.pages.urls.DocumentPage;
import com.thomsonreuters.pageobjects.pages.urls.plcuk.ErrorPage;
import com.thomsonreuters.pageobjects.pages.urls.plcuk.KHDocumentPage;
import com.thomsonreuters.pageobjects.pages.urls.practcallaw.KHDocumentPagePracticalLaw;
import com.thomsonreuters.urls.step_definitions.BaseStepDef;
import com.thomsonreuters.urls.step_definitions.URLsCommonBehaviorPLCUK;
import cucumber.api.java.en.Then;

import static org.junit.Assert.*;

public class userCanSeeKHDocument extends BaseStepDef {

    public static final String REGEX = ".+(com/)(\\w{1})-(\\d{3})-(\\d{4}).+";

    private NavigationCobalt navigationCobalt = new NavigationCobalt();
    private ErrorPage errorPage = new ErrorPage();
    private KHDocumentPage documentPagePLCUK = new KHDocumentPage();
    private KHDocumentPagePracticalLaw documentPagePracticalLaw = new KHDocumentPagePracticalLaw();

    @Then("^the user see title of opened document$")
    public void theUserSeeTitleOfOpenedDocument() throws Throwable {
        String currentURL = navigationCobalt.getCurrentUrl();
        DocumentPage page = currentURL.contains("practicallaw.com") ? documentPagePracticalLaw : documentPagePLCUK;
        String title = page.getDocumentTitle();
        assertFalse("Can't find document title on the " + page.getWebSiteName(), title.isEmpty());
    }

    @Then("^the user see title of opened document as '(.*)'$")
    public void theUserSeeTitleOfOpenedDocument(String title) throws Throwable {
        String currentURL = navigationCobalt.getCurrentUrl();
        DocumentPage page = currentURL.contains("practicallaw.com") ? documentPagePracticalLaw : documentPagePLCUK;
        assertEquals("Title of the page does nt match expected title " + title, page.getDocumentTitle(), title.toLowerCase());
    }

    @Then("^the user should see the same titles on new (.+) and old (.+) pages$")
    public void theUserShouldSeeTheSameContentOnBothOldAndNewPages(String urlNew, String urlOld) throws Throwable {
        navigationCobalt.navigateToPLCUKPlusSpecificURL(urlNew);
        navigationCobalt.waitForPageToLoadAndJQueryProcessing();
        String titleNew = documentPagePLCUK.getDocumentTitle();
        urlOld = URLsCommonBehaviorPLCUK.oldDomain + urlOld;
        navigationCobalt.navigate(urlOld);
        navigationCobalt.waitForPageToLoadAndJQueryProcessing();
        String titleOld = documentPagePracticalLaw.getDocumentTitle();
        assertEquals("Titles of documents not equals", titleNew, titleOld);
    }

    @Then("^the user is redirected to an error page$")
    public void theUserIsRedirectedToAnErrorPage() throws Throwable {
        assertTrue("Error page not found", errorPage.isErrorPageBlockPresent());
    }

    @Then("^the document opens correctly with PLC Ref$")
    public void theDocumentOpensCorrectlyWithPLCRef() throws Throwable {
        assertTrue("Document not present", documentPagePLCUK.isDocumentBlockPresent());
        assertTrue("Document doesn't contain PLCRef", documentPagePLCUK.isURLmatches(REGEX));
    }

}