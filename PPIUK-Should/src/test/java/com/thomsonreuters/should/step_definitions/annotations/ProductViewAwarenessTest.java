package com.thomsonreuters.should.step_definitions.annotations;

import com.thomsonreuters.pageobjects.otherPages.NavigationCobalt;
import com.thomsonreuters.pageobjects.pages.annotations.SharedAnnotationsPage;
import com.thomsonreuters.pageobjects.pages.header.WLNHeader;
import com.thomsonreuters.pageobjects.pages.login.OnepassLogin;
import com.thomsonreuters.pageobjects.pages.plPlusKnowHowResources.KHResourcePage;
import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.documentNavigation.DocumentDeliveryPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

public class ProductViewAwarenessTest extends AnnotationsTest {

    private NavigationCobalt navigationCobalt = new NavigationCobalt();
    private KHResourcePage resourcePage = new KHResourcePage();
    private DocumentDeliveryPage deliveryPage = new DocumentDeliveryPage();
    private SharedAnnotationsPage sharedAnnotationsPage = new SharedAnnotationsPage();
    private WLNHeader wlnHeader = new WLNHeader();
    private OnepassLogin onePassLogin = new OnepassLogin();

    public static String editOption;
    public static String input;

    public static final String groupName = "annotationsTestGroup";

    @Given("^user navigates directly to document with guid \"(.*?)\"$")
    public void userNavigatesDirectlyToDocumentWithGuid(String guid) throws Throwable {
        navigationCobalt.navigateToWLNSpecificResourcePage("/Document/" + guid + "/View/FullText.html");
        int CUSTOM_DRIVER_WAIT_TIME = 120;
        resourcePage.waitForPageToLoadAndJQueryProcessingWithCustomTimeOut(CUSTOM_DRIVER_WAIT_TIME);
    }

    @When("user added new annotation")
    public void userAddedNewAnnotation() throws Throwable {
        deliveryPage.clickOnLink(DocumentDeliveryPage.Links.NEW_ANNOTATION);
        input = "input" + System.currentTimeMillis();
        sharedAnnotationsPage.amendInput(input);
        sharedAnnotationsPage.saveAnnotation();
    }

    @Then("^verify saved annotations text will be displayed with metadata$")
    public void verifySavedAnnotationsTextWillBeDisplyedWithMetadata() throws Throwable {
        assertTrue(sharedAnnotationsPage.isSavedAnnotationDisplayed(input, SharedAnnotationsPage.ExpectedResult.VISIBLE));
        assertTrue(sharedAnnotationsPage.isMetaDataDispalyed(input));
    }

    @When("^user navigates directly to WLN document with guid \"(.*?)\"$")
    public void userNavigatesDirectlyToWLNDocumentWithGuid(String guid) throws Throwable {
        navigationCobalt.navigateToWLNSpecificURL("/Document/" + guid + "/View/FullText.html");
        navigationCobalt.waitForPageToLoadAndJQueryProcessing();
    }

    @Then("^user should not be able to see the annotations created in (PLC|WLN) site$")
    public void userShouldNotBeAbleToSeeAnnotation(String site) throws Throwable {
        boolean status = true;
        if (site.equals("WLN"))
            status = sharedAnnotationsPage.isSavedAnnotationDisplayed(input,
                    SharedAnnotationsPage.ExpectedResult.NOT_VISIBLE);
        else if (site.equals("PLC"))
            status = sharedAnnotationsPage.isSavedAnnotationDisplayedInWLN(input);
        assertFalse("Annotations are displaying which are created in " + site, status);
    }

    @When("user added WLN new annotation")
    public void userAddedNewAnnotationInWLN() throws Throwable {
        deliveryPage.clickOnLink(DocumentDeliveryPage.Links.NEW_ANNOTATION);
        input = "input" + System.currentTimeMillis();
        sharedAnnotationsPage.insertInputInWLNAnnotationTextBox(input);
        sharedAnnotationsPage.saveAnnotation();
    }

    @Then("^verify saved annotations text will be displayed with metadata in WLN$")
    public void verifySavedAnnotationsTextWillBeDisplyedWithMetadataWLN() throws Throwable {
        assertTrue(sharedAnnotationsPage.isSavedAnnotationDisplayedInWLN(input));
    }

    @When("^the user has accessed annotations text box$")
    public void theUserHasAccessedAnnotationsTextBox() throws Throwable {
        deliveryPage.clickOnLink(DocumentDeliveryPage.Links.NEW_ANNOTATION);
        editOption = "toolbar";
    }

    @When("^highlight the text with cursor$")
    public void highlighTextWithCursor() throws Throwable {
        input = "input" + System.currentTimeMillis();
        sharedAnnotationsPage.amendInput(input);
        sharedAnnotationsPage.selectText();
    }

    @Then("^user logs out$")
    public void userLogsOut() throws Throwable {
        wlnHeader.signOff();
        onePassLogin.waitForPageToLoad();
    }

    @When("^user navigates to annotations textbox with text$")
    public void theUserCanInsertText() throws Throwable {
        deliveryPage.clickOnLink(DocumentDeliveryPage.Links.NEW_ANNOTATION);
        input = "input" + System.currentTimeMillis();
        sharedAnnotationsPage.insertInput(input);
    }

    @When("^user has shared the annotations with new group and \"(.*?)\" as member$")
    public void userHasSharedTheAnnotationsWithAnotherGroup(String contact) throws Throwable {
        sharedAnnotationsPage.clickOnContactsLink();
        sharedAnnotationsPage.searchGroup(groupName);
        if (!sharedAnnotationsPage.isGroupFoundInSearch(groupName)) {
            sharedAnnotationsPage.addGroup(groupName, getUserNameStartswithLastName(contact));
        }
        sharedAnnotationsPage.selectGroup(groupName);
        sharedAnnotationsPage.selectInsertButtonOnContactsPage();
        sharedAnnotationsPage.saveAnnotation();
    }

    @When("^user navigates to WLN annotations textbox with text$")
    public void theUserCanInsertTextIntoWLNAnnotationTextBox() throws Throwable {
        deliveryPage.clickOnLink(DocumentDeliveryPage.Links.NEW_ANNOTATION);
        input = "input" + System.currentTimeMillis();
        sharedAnnotationsPage.insertInputInWLNAnnotationTextBox(input);
    }

    @When("^user has shared the annotations with another contact \"(.*?)\"$")
    public void userHasSharedTheAnnotationsWithAnotherContact(String contact) throws Throwable {
        sharedAnnotationsPage.clickOnContactsLink();
        sharedAnnotationsPage.searchContact(getUserFullName(contact));
        sharedAnnotationsPage.selectContact(getUserNameStartswithLastName(contact));
        sharedAnnotationsPage.selectInsertButtonOnContactsPage();
        sharedAnnotationsPage.scrollToTinyMceEditor();
        sharedAnnotationsPage.saveAnnotation();
        assertTrue("Application having page loading issue", sharedAnnotationsPage.isMetaDataDispalyed(input));
    }
}
