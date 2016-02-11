package com.thomsonreuters.khpadd.step_definitions.knowHowDocuments;

import com.thomsonreuters.khpadd.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.otherPages.NavigationCobalt;
import com.thomsonreuters.pageobjects.pages.urls.plcuk.KHDocumentPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class EmailLinksInDocumentTest extends BaseStepDef {

    private NavigationCobalt navigationCobalt = new NavigationCobalt();
    private KHDocumentPage khDocumentPage = new KHDocumentPage();

    @When("^the user opens (.+) url on plcuk website$")
    public void theUserOpensUrlOnPLCUKSite(String url) throws Throwable {
        navigationCobalt.navigateToPLCUKPlusSpecificURL(url);
        navigationCobalt.waitForPageToLoadAndJQueryProcessingWithCustomTimeOut(90);
    }

    @Then("^document contains link to '(.+)'$")
    public void documentContainsLinkTo(String name) throws Throwable {
        assertTrue("Document doesn't contain link to " + name, khDocumentPage.isContainLinkTo(name));
    }

    @Then("^document contains email link to '(.+)'$")
    public void documentContainsEmailLinkTo(String email) throws Throwable {
        assertTrue("Document doesn't contain email link to " + email, khDocumentPage.isContainEmailLinkTo(email));
    }

    @Then("^document doesn't contain link to '(.+)'$")
    public void documentDoesnTContainEmailLinkTo(String name) throws Throwable {
        assertFalse("Document contains link to " + name, khDocumentPage.isContainLinkTo(name));
    }

}
