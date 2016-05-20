package com.thomsonreuters.smoke.step_definitions;

import com.thomsonreuters.pageobjects.pages.annotations.SharedAnnotationsPage;
import com.thomsonreuters.pageobjects.pages.fastDraft.QuestionPage;
import com.thomsonreuters.pageobjects.pages.globalPage.GlobalCategoryPage;
import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document.StandardDocumentPage;
import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.documentNavigation.DocumentDeliveryPage;
import com.thomsonreuters.pageobjects.pages.search.KnowHowSearchResultsPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static junit.framework.Assert.assertTrue;

public class ProdFirmStyleFastDraftAnnotationsTest extends BaseStepDef {

    private KnowHowSearchResultsPage knowHowSearchResultsPage = new KnowHowSearchResultsPage();
    private GlobalCategoryPage globalCategoryPage = new GlobalCategoryPage();
    private StandardDocumentPage standardDocumentPage = new StandardDocumentPage();
    private QuestionPage questionPage = new QuestionPage();
    private DocumentDeliveryPage deliveryPage = new DocumentDeliveryPage();
    private SharedAnnotationsPage sharedAnnotationsPage = new SharedAnnotationsPage();

    @When("^the user selects the know how parent facet \"(.*?)\"$")
    public void theUserSelectsTheKnowHowParentFacet(String arg1) throws Throwable {
        knowHowSearchResultsPage.knowHowFacetCheckbox(arg1).click();
    }

    @When("^the user selects the know how option to apply filters$")
    public void theUserSelectsTheKnowHowOptionToApplyFilters() throws Throwable {
        globalCategoryPage.executeScript("scroll(250,0);");
        theUserIsAbleToCheckWhetherTheOptionToApplyFiltersIsDisplayedAndIfNotToEnsureThatItIs();
        knowHowSearchResultsPage.applyFiltersButton().click();
        knowHowSearchResultsPage.waitForSearchResults();
    }

    @When("^the user clicks Firm Style link$")
    public void clickFirmStyleLink() throws Throwable {
        standardDocumentPage.firmStyle().click();
        standardDocumentPage.waitForPageToLoad();
    }

    @Then("^Firm Style download box appiars$")
    public void checkDownloadboxAppiars() throws Throwable {
        standardDocumentPage.waitForPageToLoad();
        standardDocumentPage.checkDownloadboxAppiars();
        standardDocumentPage.waitForPageToLoad();
    }

    @Then("^the user clicks Start Drafting button$")
    public void clickStDraftingButton() throws Throwable {
        standardDocumentPage.startDraftingButton().click();
        standardDocumentPage.waitForPageToLoad();
    }

    @Then("^the user is redirected to question page for \"([^\"]*)\"$")
    public void checkFastDraftQuestionPagePresent(String documentName) throws Throwable {
        questionPage.waitForPageToLoad();
        questionPage.checkQuestionPageForDocument(documentName);
    }

    @When("^user click on new Annotations link$")
    public void userClickOnNewAnnotationsLink() throws Throwable {
        deliveryPage.clickOnLink(DocumentDeliveryPage.Links.NEW_ANNOTATION);
    }

    @Then("^annotations textbox will be displayed with tinymce editor$")
    public void annotationsTextboxWillBeDisplayedWithTinymceEditor() throws Throwable {
        assertTrue(sharedAnnotationsPage.isTextBoxDisplayed());
    }

    @When("^user cancels new annotation$")
    public void userCancelsNewAnnotation() throws Throwable {
        sharedAnnotationsPage.cancelSavingAnnotation();
    }

    @Then("^the user is able to check whether the option to apply filters is displayed and if not to ensure that it is$")
    public void theUserIsAbleToCheckWhetherTheOptionToApplyFiltersIsDisplayedAndIfNotToEnsureThatItIs() {
        try {
            if (knowHowSearchResultsPage.selectMultipleFiltersButton().isDisplayed()) {
                knowHowSearchResultsPage.clickOnSelectMultipleFilters();
            }
        } catch (Exception e) {
        }
    }




}
