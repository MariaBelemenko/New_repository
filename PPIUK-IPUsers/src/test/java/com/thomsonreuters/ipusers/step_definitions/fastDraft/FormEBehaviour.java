package com.thomsonreuters.ipusers.step_definitions.fastDraft;

import com.thomsonreuters.ipusers.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.pages.fastDraft.ChangesInUploadedPDF;
import com.thomsonreuters.pageobjects.pages.fastDraft.FormEPage;
import com.thomsonreuters.pageobjects.pages.widgets.CategoryPage;
import com.thomsonreuters.pageobjects.utils.fastDraft.FastDraftUtils;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertTrue;

public class FormEBehaviour extends BaseStepDef {

    private CategoryPage categoryPage;

    private FormEPage formEpage;

    private ChangesInUploadedPDF changesInUploadedPDF;

    private FastDraftUtils fastDraftUtils;

    public FormEBehaviour() {
        categoryPage = new CategoryPage();
        formEpage = new FormEPage();
        changesInUploadedPDF = new ChangesInUploadedPDF();
        fastDraftUtils = new FastDraftUtils();
    }

    @When("^the user opens Form E page$")
    public void openFormE() throws Throwable {
        categoryPage.formE().click();
        categoryPage.waitForPageToLoad();
    }

    @When("^the user starts here Form E$")
    public void submitFormE() throws Throwable {
        formEpage.startHereFormE().click();
        formEpage.waitForPageToLoad();
    }

    @When("^the user clicks link Form E user guide \"([^\"]*)\"$")
    public void clickFormEUserGuideOnFormEPage(String userGuideLink) {
        formEpage.waitForPageToLoad();
        formEpage.formEUserGuide(userGuideLink).click();
        formEpage.waitForPageToLoad();
    }

    @Then("^the user sees Upload button with Upload message$")
    public void checkUploadButton() throws Throwable {
        formEpage.waitForPageToLoad();
        formEpage.checkUploadButtonWithMessagePresents();
    }

    @Then("^the user sees Start here button with Start here message$")
    public void checkStartHereButton() throws Throwable {
        formEpage.waitForPageToLoad();
        formEpage.checkStartHereButtonWithMessagePresents();
    }

    @Then("^the user sees Sign On button with Sign On message$")
    public void checkSignOnButton() throws Throwable {
        formEpage.waitForPageToLoad();
        formEpage.waitForPageToLoadAndJQueryProcessing();
        formEpage.checkSignOnButtonWithMessagePresents();
    }

    @Then("^the user sees Log in as single user button with Sign On message$")
    public void checkLogInAsSingleUserButton() throws Throwable {
        formEpage.waitForPageToLoad();
        formEpage.waitForPageToLoadAndJQueryProcessing();
        formEpage.checkLogInAsSingleUserButtonWithMessagePresents();
    }

    @When("^the user clicks on Log in as single user button on Form E page$")
    public void clickLogInAsSingleUserButton() throws Throwable {
        formEpage.waitForPageToLoad();
        formEpage.logInAsSingleUserButton().click();
        resetCurrentUser();
    }

    @When("^the user clicks on Sign On button on Form E page$")
    public void clickSignOnButton() throws Throwable {
        formEpage.signOnButton().click();
        formEpage.waitForPageToLoad();
        resetCurrentUser();
    }

    @When("^the user clicks Upload Form E$")
    public void clickUploadFormE() throws Throwable {
        fastDraftUtils.clickUploadFormEFromFormEPage();
    }

    @Then("^the user is redirected to Changes in the uploaded PDF page$")
    public void checkChangesInUploadedPDF() throws Throwable {
        changesInUploadedPDF.waitForPageToLoad();
        changesInUploadedPDF.checkChangesInUploadedPDFDisplayed();
        assertTrue("Changes in the uploaded PDF page is not displayed", changesInUploadedPDF.getCurrentUrl().contains("uploadPDF"));
    }

    @Then("^the user is redirected to document page with upload error$")
    public void checkDocumentPageWithErrorPresents() throws Throwable {
        changesInUploadedPDF.waitForPageToLoad();
        assertTrue("Document page with upload error is not displayed", changesInUploadedPDF.isDocumentPageWithErrorPresents());
    }

    @Then("^the user is redirected to document page with upload not the correct type error$")
    public void checkDocumentPageWithUploadNotCorrectTypeErrorPresents() throws Throwable {
        changesInUploadedPDF.waitForPageToLoad();
        assertTrue("Document page with upload not the correct type error is not displayed", changesInUploadedPDF.isDocumentPageWithUploadNotCorrectTypeErrorPresents());
    }

    @Then("^there is a section \"([^\"]*)\" with original \"([^\"]*)\" and reviced \"(.*?)\"$")
    public void checkSectionHasOriginalAndRevicedValues(String sectionName, String originalValue, String revisedValue) throws Throwable {
        changesInUploadedPDF.checkChangesInUploadedPDFDisplayed();
        changesInUploadedPDF.checkSectionHasOriginalAndRevicedValues(sectionName, originalValue, revisedValue);
    }

    @When("^the user deselects \"([^\"]*)\" section$")
    public void deselectSection(String sectionName) throws Throwable {
        WebElement checkBox = changesInUploadedPDF.section(sectionName);
        if (checkBox.isSelected()) {
            checkBox.click();
        }
    }

    @When("the users clicks accept changes on Changes in the uploaded PDF page")
    public void acceptChanges() throws Throwable {
        changesInUploadedPDF.acceptChanges().click();
    }

}