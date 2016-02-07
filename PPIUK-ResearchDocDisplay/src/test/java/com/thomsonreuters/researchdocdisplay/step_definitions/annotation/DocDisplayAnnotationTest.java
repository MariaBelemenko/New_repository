package com.thomsonreuters.researchdocdisplay.step_definitions.annotation;

import com.thomsonreuters.pageobjects.otherPages.NavigationCobalt;
import com.thomsonreuters.pageobjects.pages.urls.plcuk.KHDocumentPage;
import com.thomsonreuters.pageobjects.utils.plPlusResearchDocDisplay.CaseDocumentPageUtils;
import com.thomsonreuters.researchdocdisplay.step_definitions.BaseStepDef;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DocDisplayAnnotationTest extends BaseStepDef {

    private NavigationCobalt navigationCobalt = new NavigationCobalt();
    private KHDocumentPage documentPagePLCUK = new KHDocumentPage();
    private CaseDocumentPageUtils caseDocumentPageUtils = new CaseDocumentPageUtils();

    @When("^the user opens document with (.+) guid$")
    public void theUserOpensDocumentWithGuid(String guid) throws Throwable {
        navigationCobalt.navigateToPLCUKPlusSpecificURL("/Document/" + guid + "/View/FullText.html");
        navigationCobalt.waitForPageToLoad();
    }

    @Then("^the document opens correctly$")
    public void theDocumentOpensCorrectly() throws Throwable {
        assertTrue("Document not present", documentPagePLCUK.isDocumentBlockPresent());
    }

    @Then("^the provision has \"(.*?)\" annotations$")
    public void theProvisionHasAnnotations(String annotationsLinkText) throws Throwable {
        assertTrue("The provision doesn't contain annotations",
                caseDocumentPageUtils.istheProvisionHasAnnotations(annotationsLinkText));
    }

    @When("^the user navigates to annotations section$")
    public void theUserNavigatesToAnnotationsSection() throws Throwable {
        caseDocumentPageUtils.navigatesToAnnotationsSection();
    }

    @Then("^\"(.*?)\" annotations will be displayed by default$")
    public void annotationsWillBeDisplayedByDefault(String annotationsText) throws Throwable {
        assertTrue("The annotations didn't displayed by default",
                caseDocumentPageUtils.isAnnotationsDisplayedByDefault(annotationsText));
    }

    @Then("^show and hide link is displayed as part of annotations header$")
    public void showAndHideLinkIsDisplayedAsPartOfAnnotationsHeader() throws Throwable {
        assertTrue("Show and hide link is not displayed",
                caseDocumentPageUtils.isShowAndHideLinkIsDisplayed());
    }

    @When("^the user selects option to annotation$")
    public void theUserSelectsOptionToAnnotation() throws Throwable {
        caseDocumentPageUtils.selectOnShowAndHideLink();
    }

    @Then("^annotations will be hidden$")
    public void annotationsWillBeHidden() throws Throwable {
        assertFalse("The annotations didn't hidden",
                caseDocumentPageUtils.isAnnotationSectionIsDisplayed());
    }

    @Then("^annotations will be displayed$")
    public void annotationsWillBeDisplayed() throws Throwable {
        assertTrue("The annotations is not displayed on document",
                caseDocumentPageUtils.isAnnotationSectionIsDisplayed());
    }

}
