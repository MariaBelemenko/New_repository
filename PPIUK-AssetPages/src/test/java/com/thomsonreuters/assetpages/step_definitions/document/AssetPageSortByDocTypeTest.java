package com.thomsonreuters.assetpages.step_definitions.document;

import com.thomsonreuters.assetpages.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document.PrimarySourceDocumentPage;
import com.thomsonreuters.pageobjects.utils.plPlusResearchDocDisplay.AssetPageUtils;
import cucumber.api.java.en.Then;

import static org.junit.Assert.assertTrue;

public class AssetPageSortByDocTypeTest extends BaseStepDef {

    private PrimarySourceDocumentPage primarySourceDocumentPage = new PrimarySourceDocumentPage();
    private AssetPageUtils assetPageUtils = new AssetPageUtils();

    @Then("^the user sees \"(.*?)\" type of document$")
    public void theUserSeesTypeOfDocument(String documentTypeText) throws Throwable {
        assertTrue("The user doesn't see type of document",
                primarySourceDocumentPage.isElementDisplayed(primarySourceDocumentPage
                        .typeOfDocumentInContentReferringSection(documentTypeText))
        );
    }

    @Then("^links of \"(.*?)\" type of document are sorted alphabetically$")
    public void linksOfTypeOfDocumentAreSortedAlphabetically(String documentTypeText) throws Throwable {
        assertTrue("The links are not sorted alphabetically",
                assetPageUtils.isTheLinksOfTypeOfDocumentAreSortedAlphabetically(documentTypeText));
    }

    @Then("^the user sees \"(.*?)\" type of document below \"(.*?)\"$")
    public void theUserSeesTypeOfDocumentBelow(String nextDocumentTypeText, String documentTypeText) throws Throwable {
        assertTrue("The user doesn't document type below previous document type",
                primarySourceDocumentPage.isElementDisplayed(primarySourceDocumentPage
                        .typeOfDocumentBelowPreviousDocumentType(nextDocumentTypeText, documentTypeText))
        );
    }

}
