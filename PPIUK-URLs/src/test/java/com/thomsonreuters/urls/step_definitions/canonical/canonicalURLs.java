package com.thomsonreuters.urls.step_definitions.canonical;

import com.thomsonreuters.pageobjects.pages.urls.plcuk.KHDocumentPage;
import com.thomsonreuters.urls.step_definitions.BaseStepDef;
import cucumber.api.java.en.Then;

import static org.junit.Assert.assertTrue;

public class canonicalURLs extends BaseStepDef {

    private KHDocumentPage khDocumentPage = new KHDocumentPage();

    @Then("^current url contains link tag with attribute rel=\"canonical\"$")
    public void currentUrlContainsLinkTagWithAttributeRel() throws Throwable {
        assertTrue("Page doesn't contain canonical attribute", khDocumentPage.isContainCanonicalAttribute());
    }

}
