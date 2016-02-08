package com.thomsonreuters.pageobjects.utils.fastDraft;

import com.thomsonreuters.pageobjects.common.CommonMethods;
import com.thomsonreuters.pageobjects.common.WindowHandler;
import com.thomsonreuters.pageobjects.pages.fastDraft.*;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;

public class FastDraftUtils {

    private static final Logger LOG = org.slf4j.LoggerFactory.getLogger(FastDraftUtils.class);

    private QuestionPage questionPage = new QuestionPage();
    private ProjectPage projectPage = new ProjectPage();
    private SaveProjectPopup saveProjectPopup = new SaveProjectPopup();
    private WindowHandler windowHandler = new WindowHandler();
    private FormEPage formEpage = new FormEPage();
    private NewDocumentPage newDocumentPage = new NewDocumentPage();
    private NewDocumentPopup newDocumentPopup = new NewDocumentPopup();
    private DashboardPage dashboardPage = new DashboardPage();
    private RenamePopup renamePopup = new RenamePopup();
    private AddressBookPage addressBookPage = new AddressBookPage();
    private NewContactPopup newContactPopup = new NewContactPopup();
    private Header header = new Header();
    private NewProjectPopup newProjectPopup = new NewProjectPopup();
    private CommonMethods comMethods = new CommonMethods();

    public void saveNewProjectFromQuestionPage(String projectName, String documentName) {
        questionPage.saveProject().click();
        questionPage.waitForPageToLoad();
        saveProjectPopup.documentName().clear();
        saveProjectPopup.documentName().sendKeys(documentName);
        saveProjectPopup.projectName().clear();
        saveProjectPopup.projectName().sendKeys(projectName);
        saveProjectPopup.save().click();
        saveProjectPopup.waitForPageToLoad();
    }

    public void renameDocument(String documentName) {
        projectPage.actionsButton(documentName).click();
        projectPage.renameDocument(documentName).click();
    }

    public void uploadFormEFromFD(String documentName, String path) throws Throwable {
        projectPage.uploadFormE(documentName).click();
        projectPage.selectUploadFormE().click();
        windowHandler.fileUpload(path);
        projectPage.upload().click();
        projectPage.waitForPageToLoad();
    }

    public void clickUploadFormEFromFormEPage() throws Throwable {
        formEpage.uploadFormE().click();
        formEpage.waitForPageToLoad();
    }

    public void uploadFormEFromFormEPage(String path) throws Throwable {
        clickUploadFormEFromFormEPage();
        projectPage.selectUploadFormE().click();
        windowHandler.fileUpload(path);
        projectPage.upload().click();
        projectPage.waitForPageToLoad();
    }

    public void deleteDocument(String documentName) {
        projectPage.actionsButton(documentName).click();
        projectPage.deleteDocumentButton(documentName).click();
        projectPage.confirmationYes().click();
        projectPage.waitForPageToLoad();
    }

    public void deleteDocumentAndCancel(String documentName) {
        projectPage.actionsButton(documentName).click();
        projectPage.deleteDocumentButton(documentName).click();
        projectPage.confirmationCancel().click();
        projectPage.waitForPageToLoad();
    }

    public void addedNewDocumentInProject(String documentType, String documentName, String projectName) {
        dashboardPage.openProject(projectName).click();
        dashboardPage.waitForPageToLoad();
        projectPage.createNewDocument().click();
        projectPage.waitForPageToLoad();
        newDocumentPage.selectDocument(documentType).click();
        newDocumentPage.waitForPageToLoad();
        newDocumentPopup.documentName().clear();
        newDocumentPopup.documentName().sendKeys(documentName);
        newDocumentPopup.createDocument().click();
        newDocumentPopup.waitForPageToLoad();
    }

    public void fillInRenamePopupDetails(String newName) {
        renamePopup.projectOrDocument().clear();
        renamePopup.projectOrDocument().sendKeys(newName);
        renamePopup.renameButton().click();
        renamePopup.waitForPageToLoad();
    }

    public void renameAndClickCancel(String newName) {
        renamePopup.projectOrDocument().clear();
        renamePopup.projectOrDocument().sendKeys(newName);
        renamePopup.cancelButton().click();
        renamePopup.waitForPageToLoad();
    }

    public void createNewPersonContact(String title, String firstName, String secondName, String email) {
        addressBookPage.waitForPageToLoad();
        addressBookPage.createNewContact().click();
        newContactPopup.selectPersonContactType();
        newContactPopup.salutationComboButton().click();
        newContactPopup.selectSalutation(title);
        newContactPopup.firstName().clear();
        newContactPopup.firstName().sendKeys(firstName);
        newContactPopup.secondName().clear();
        newContactPopup.secondName().sendKeys(secondName);
        newContactPopup.email().clear();
        newContactPopup.email().sendKeys(email);
        newContactPopup.save().click();
        newContactPopup.waitForPageToLoadAndJQueryProcessing();
    }

    public void unarchiveProject(String projectName) {
        dashboardPage.actions(projectName).click();
        dashboardPage.unarchive(projectName).click();
        dashboardPage.confirmationActivate().click();
        dashboardPage.waitForPageToLoad();
    }

    public void unarchiveProjectAndClickCancel(String projectName) {
        dashboardPage.actions(projectName).click();
        dashboardPage.unarchive(projectName).click();
        dashboardPage.cancel().click();
        dashboardPage.waitForPageToLoad();
    }

    public void archiveProjectAndClickCancel(String projectName) {
        dashboardPage.actions(projectName).click();
        dashboardPage.archive(projectName).click();
        dashboardPage.cancel().click();
        dashboardPage.waitForPageToLoad();
    }

    public void goArchive() {
        dashboardPage.viewingCurrentProjects().click();
        dashboardPage.switchToArchive().click();
        dashboardPage.waitForPageToLoad();
    }

    public void switchesToCurrentProjects() {
        dashboardPage.viewingArchive().click();
        dashboardPage.switchToCurrentProjects().click();
        dashboardPage.waitForPageToLoad();
    }

    public void archiveProject(String projectName) {
        dashboardPage.actions(projectName).click();
        dashboardPage.archive(projectName).click();
        dashboardPage.confirmationArchive().click();
        dashboardPage.waitForPageToLoad();
    }

    public void renameProject(String projectName) {
        dashboardPage.actions(projectName).click();
        dashboardPage.rename(projectName).click();
    }

    public void deleteProjectAndCancel(String projectName) {
        dashboardPage.actions(projectName).click();
        dashboardPage.delete(projectName).click();
        dashboardPage.cancel().click();
        dashboardPage.waitForPageToLoad();
    }

    public void deleteProject(String projectName) {
        dashboardPage.actions(projectName).click();
        dashboardPage.delete(projectName).click();
        dashboardPage.confirmationDelete().click();
        dashboardPage.waitForPageToLoad();
    }

    public void deleteProject(int projectPosition) {
        dashboardPage.actions(projectPosition).click();
        dashboardPage.delete(projectPosition).click();
        dashboardPage.confirmationDelete().click();
        dashboardPage.waitForPageToLoad();
    }

    public void goMyProjects() {
        try {
            header.myProjects().click();
            header.waitForPageToLoad();
        } catch (NullPointerException e) {
            if (header.getCurrentUrl().contains("projects.zevon")) {
                LOG.info("My Projects already opened");
            } else {
                throw e;
            }
        }
    }

    public void fillInNewProjectDetails(String projectName, String documentName) {
        newProjectPopup.documentName().clear();
        newProjectPopup.documentName().sendKeys(documentName);
        newProjectPopup.projectName().clear();
        newProjectPopup.projectName().sendKeys(projectName);
        newProjectPopup.create().click();
        newProjectPopup.waitForPageToLoad();
    }

    public void updatePersonFromAddressBook(String contactToUpdate, String contactToSet) {
        questionPage.updateContactField(contactToUpdate).click();
        questionPage.waitForPageToLoad();
        questionPage.chooseContact(contactToSet).click();
        questionPage.save().click();
        questionPage.waitForPageToLoad();
    }

    public void editDropdownField(String fieldId, String optionValue) {
        WebElement dropDown = questionPage.dropDownField(fieldId);
        comMethods.mouseOver(dropDown);
        dropDown.click();
        WebElement option = questionPage.dropDownFieldOption(fieldId, optionValue);
        comMethods.mouseOver(option);
        option.sendKeys("");
        option.click();
    }

    public void removeContactFromAddressBook(String contact) {
        addressBookPage.removeContact(contact).click();
        addressBookPage.removeContactConfirmation().click();
        addressBookPage.waitForPageToLoad();
    }

}
