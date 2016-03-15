package com.thomsonreuters.ipusers.step_definitions.fastDraft;

import com.thomsonreuters.ipusers.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.pages.fastDraft.*;
import com.thomsonreuters.pageobjects.pages.header.WLNHeader;
import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document.PracticalLawToolsPage;
import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document.StandardDocumentPage;
import com.thomsonreuters.pageobjects.utils.fastDraft.FastDraftUtils;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.SoftAssertions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BaseFastDraftBehaviour extends BaseStepDef {

    private StandardDocumentPage standardDocumentPage;
    private DashboardPage dashboardPage;
    private Header header;
    private NewProjectPage newProjectPage;
    private QuestionPage questionPage;
    private ProjectPage projectPage;
    private DraftViewPage draftViewPage;
    private NewDocumentPage newDocumentPage;
    private WLNHeader wlnHeader;
    private FastDraftUtils fastDraftUtils;
    private PracticalLawToolsPage practicalLawToolsPage;

    public BaseFastDraftBehaviour() {
        standardDocumentPage = new StandardDocumentPage();
        dashboardPage = new DashboardPage();
        header = new Header();
        newProjectPage = new NewProjectPage();
        questionPage = new QuestionPage();
        projectPage = new ProjectPage();
        draftViewPage = new DraftViewPage();
        newDocumentPage = new NewDocumentPage();
        wlnHeader = new WLNHeader();
        fastDraftUtils = new FastDraftUtils();
        practicalLawToolsPage = new PracticalLawToolsPage();

    }

    @When("^the user goes My FastDraft$")
    public void goMyFastDraft() {
        wlnHeader.myFastDraft();
    }

    @When("^My FastDraft link absents in the header$")
    public void checkMyFastDraftAbsents() {
        wlnHeader.checkMyFastDraftAbsents();
    }

    @Then("^current Fast Draft URL is correct$")
    public void checkFastDraftDashboardURL() {
        if (!dashboardPage.getCurrentUrl().contains("http://d" + System.getProperty("base.legacy.url") + "-infra.dev.practicallaw.com:8080/da/")) {
            throw new RuntimeException("Current url is not correct");
        }
    }

    @When("^the user clicks save new document with project name \"([^\"]*)\" and document name \"([^\"]*)\"$")
    public void saveDocumentAndProject(String projectName, String documentName) {
        fastDraftUtils.saveNewProjectFromQuestionPage(projectName, documentName);
    }

    @Then("^the user sees the FastDraft logo for \"([^\"]*)\" document$")
    public void checkFastDraftLogo(String document) throws Throwable {
        standardDocumentPage.checkDocumentHasFastDratLogo(document);
    }

    @Then("^the user clicks Start Drafting button$")
    public void clickStartDraftingButton() throws Throwable {
        standardDocumentPage.startDraftingButton().click();
        standardDocumentPage.waitForPageToLoad();
    }

    @Then("^the user sees Start Drafting button$")
    public void checkStartDraftingButton() throws Throwable {
        standardDocumentPage.waitForPageToLoad();
        standardDocumentPage.checkStartDraftingButtonPresents();
    }

    @Then("^the user sees Learn more button$")
    public void checkLearnMoreButtonPresents() throws Throwable {
        standardDocumentPage.waitForPageToLoad();
        standardDocumentPage.checkLearnMoreButtonPresents();
    }

    @Then("^the user sees Login as single user button$")
    public void checkLoginAsSingleUserButtonPresents() throws Throwable {
        standardDocumentPage.waitForPageToLoad();
        standardDocumentPage.checkLoginAsSingleUserButtonPresents();
    }

    @Then("^the draft message presents$")
    public void checkDraftMessagePresents() throws Throwable {
        standardDocumentPage.waitForPageToLoad();
        standardDocumentPage.checkDraftMessagePresents();
    }

    @Then("^the draft message for PA presents$")
    public void checkDraftMessageForPAPresents() throws Throwable {
        standardDocumentPage.waitForPageToLoad();
        standardDocumentPage.checkDraftMessageForPAPresents();
    }

    @Then("^the draft message for IP users presents$")
    public void checkDraftMessageForIPUsersPresents() throws Throwable {
        standardDocumentPage.waitForPageToLoad();
        standardDocumentPage.checkDraftMessageForIPUsersPresents();
    }

    @When("^the user clicks Learn more button$")
    public void clickLearnMoreButton() throws Throwable {
        standardDocumentPage.learnMoreButton().click();
        standardDocumentPage.waitForPageToLoad();
    }

    @When("^the user clicks Login as single user button$")
    public void clickLoginAsSingleUserButton() throws Throwable {
        standardDocumentPage.loginAsSingleUserButton().click();
        standardDocumentPage.waitForPageToLoad();
        resetCurrentUser();
    }

    @Then("^Fast Draft Tools page is displayed$")
    public void checkToolsPageIsDisplayed() {
        practicalLawToolsPage.waitForPageToLoad();
        practicalLawToolsPage.waitForPageToLoadAndJQueryProcessing();
        String learnMoreLink = "/About/PracticalLawTools";
        String currentUrl = getDriver().getCurrentUrl();
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(currentUrl.contains(learnMoreLink))
                .overridingErrorMessage(
                        "Expected current URL contains link '" + learnMoreLink + "', current is '" + currentUrl + "'")
                .isTrue();
        softly.assertThat(practicalLawToolsPage.isFastDraftTabActive())
                .overridingErrorMessage("Fastdraft tab is not active").isTrue();
        softly.assertAll();
    }

    @Then("^the project \"([^\"]*)\" presents$")
    public void checkProjectPresents(String projectName) throws Throwable {
        assertTrue("Project with name '" + projectName + "' absents on Dashboard", dashboardPage.isProjectPresent(projectName));
    }

    @Then("^the document \"([^\"]*)\" presents$")
    public void checkDocumentPresents(String documentName) throws Throwable {
        projectPage.waitForPageToLoad();
        assertTrue("Document with name '" + documentName + "' absents", projectPage.isDocumentPresent(documentName));
    }

    @Then("\"([^\"]*)\" page is displayed$")
    public void loginPageIsDisplayed(String pageUrl) throws Throwable {
        standardDocumentPage.waitForPageToLoad();
        assertTrue("'" + pageUrl + "' page is not displayed", standardDocumentPage.getCurrentUrl().contains(pageUrl));
    }

    @Then("^the user is redirected to Fast Draft dashboard$")
    public void checkFastDraftDashboardPresent() throws Throwable {
        dashboardPage.waitForPageToLoad();
        dashboardPage.checkFastDraftDashboardPresents();
    }

    @Then("^the user is redirected to question page for \"([^\"]*)\"$")
    public void checkFastDraftQuestionPagePresent(String documentName) throws Throwable {
        questionPage.waitForPageToLoad();
        questionPage.checkQuestionPageForDocument(documentName);
    }

    @When("^creates new project \"([^\"]*)\" and \"([^\"]*)\" with project name \"([^\"]*)\" and document name \"([^\"]*)\"$")
    public void createFastDraftProject(String projectType, String documentType, String projectName, String documentName)
            throws Throwable {
        dashboardPage.waitForPageToLoad();
        dashboardPage.createNewProject().click();
        dashboardPage.waitForPageToLoad();
        newProjectPage.selectProjectType(projectType).click();
        dashboardPage.waitForPageToLoad();
        newDocumentPage.selectDocument(documentType).click();
        newDocumentPage.waitForPageToLoad();
        fastDraftUtils.fillInNewProjectDetails(projectName, documentName);
    }

    @When("^the user goes to \"([^\"]*)\" on Fast Draft$")
    public void openFastDraftPage(String page) throws Throwable {
        questionPage.page(page).click();
        questionPage.page(page);
        questionPage.waitForPageToLoad();
    }

    @When("^the user update text field \"([^\"]*)\" with value \"([^\"]*)\"$")
    public void updateTextField(String fieldId, String value) throws Throwable {
        questionPage.textField(fieldId).clear();
        questionPage.textField(fieldId).sendKeys(value);
    }

    @When("^the user update dropdown field \"([^\"]*)\" with value \"([^\"]*)\"$")
    public void updateDropdownField(String fieldId, String value) throws Throwable {
        fastDraftUtils.editDropdownField(fieldId, value);
    }

    @When("^the user goes My projects$")
    public void openMyProjects() throws Throwable {
        fastDraftUtils.goMyProjects();
    }

    @When("^the user goes View questions$")
    public void goViewQuestions() throws Throwable {
        header.viewQuestions().click();
        header.waitForPageToLoad();
    }

    @When("^the user goes View Draft$")
    public void goViewDraft() throws Throwable {
        header.viewDraft().click();
        header.waitForPageToLoad();
    }

    @When("^the user opens project \"([^\"]*)\" and document \"([^\"]*)\"$")
    public void openFastDraftProject(String projectName, String documentName) throws Throwable {
        dashboardPage.openProject(projectName).click();
        dashboardPage.waitForPageToLoad();
        projectPage.openDocument(documentName).click();
        projectPage.waitForPageToLoad();
    }

    @When("^the user opens project \"([^\"]*)\"$")
    public void openFastDraftProject(String projectName) throws Throwable {
        dashboardPage.openProject(projectName).click();
        dashboardPage.waitForPageToLoad();
    }

    @Then("^the user checks draft text contains value \"([^\"]*)\" in field \"([^\"]*)\"$")
    public void checkDraftHasValueInField(String value, String field) throws Throwable {
        draftViewPage.waitForPageToLoad();
        draftViewPage.checkFieldHasValue(field, value);
    }

    @Then("^the user checks text field \"([^\"]*)\" has value \"([^\"]*)\"$")
    public void checkTextField(String fieldId, String value) throws Throwable {
        questionPage.waitForPageToLoad();
        assertEquals("User name field is incorrect", value, questionPage.textField(fieldId).getAttribute("value"));
    }

    @Then("^the user checks dropdown field \"([^\"]*)\" has value \"([^\"]*)\"$")
    public void checkDropdownField(String fieldId, String value) throws Throwable {
        questionPage.waitForPageToLoad();
        assertEquals("User name field is incorrect", value, questionPage.dropDownField(fieldId).getAttribute("value"));
    }

    @When("^the user deletes the project \"([^\"]*)\"$")
    public void deleteProject(String projectName) throws Throwable {
        fastDraftUtils.deleteProject(projectName);
    }

    @When("^the user deletes the document \"([^\"]*)\"$")
    public void deleteDocument(String document) throws Throwable {
        fastDraftUtils.deleteDocument(document);
    }

    @When("^creates new document with \"([^\"]*)\" with document name \"([^\"]*)\" in project with name \"([^\"]*)\"$")
    public void addedNewDocumentInProject(String documentType, String documentName, String projectName) throws Throwable {
        fastDraftUtils.addedNewDocumentInProject(documentType, documentName, projectName);
    }

    @Then("^the project \"([^\"]*)\" is absent$")
    public void checkProjectAbsents(String projectName) throws Throwable {
        dashboardPage.waitForPageToLoad();
        assertTrue("Project with name '" + projectName + "' presents on Fast Draft Dashboard", dashboardPage.isProjectAbsent(projectName));
    }

    @Then("^the document \"([^\"]*)\" is absent$")
    public void checkDocumentAbsents(String documentName) throws Throwable {
        projectPage.waitForPageToLoad();
        assertTrue("Document with name '" + documentName + "' presents", projectPage.isDocumentAbsent(documentName));
    }

    @When("^the user deletes all Fast Draft projects$")
    public void deleteAllFastDraftProjects() throws Throwable {
        int countProjects = dashboardPage.getProjectsCount();
        if (countProjects != 0) {
            for (int i = countProjects; i >= 1; i--) {
                dashboardPage.waitForPageToLoad();
                dashboardPage.checkFastDraftDashboardPresents();
                fastDraftUtils.deleteProject(String.valueOf(i));
            }
        } else {
            LOG.info("There are no Fast Draft projects to delete");
        }
    }

    @Then("^there are no Fast Draft projects$")
    public void checkNoProjectPresent() throws Throwable {
        assertTrue("There is projects / project in Fast Draft", dashboardPage.isNoProjectPresent());
    }

    @Then("^the user sees Redirecting to FastDraft popup$")
    public void checkRedirectingToFastDraftPopupPresents() throws Throwable {
        standardDocumentPage.checkRedirectingToFastDraftPopupPresents();
    }

    @Then("^the user sees Cancel Request button$")
    public void checkCancelRequestButtonPresents() throws Throwable {
        standardDocumentPage.checkCancelRequestButtonPresents();
    }

    @When("^the user clicks Cancel Request button$")
    public void clickCancelRequestButton() throws Throwable {
        standardDocumentPage.cancelRequestButton().click();
    }

    @Then("^there is no Redirecting to FastDraft popup$")
    public void checkRedirectingToFastDraftPopupAbsents() throws Throwable {
        standardDocumentPage.checkRedirectingToFastDraftPopupAbsents();
    }

    @When("^the user closes Redirecting to FastDraft$")
    public void closeRedirectingToFastDraftPopup() throws Throwable {
        standardDocumentPage.closeRedirectingToFastDraftPopup().click();
    }

}