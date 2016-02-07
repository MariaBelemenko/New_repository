package com.thomsonreuters.fastdraft.step_definitions.create;

import com.thomsonreuters.fastdraft.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.utils.fastDraft.FastDraftUtils;
import cucumber.api.java.en.When;

public class RenameAndArchiveProjectTest extends BaseStepDef {

    private FastDraftUtils fastDraftUtils = new FastDraftUtils();

    @When("^the user renames the project \"([^\"]*)\" with \"([^\"]*)\"$")
    public void renameProject(String projectName, String projectNewName) throws Throwable {
        fastDraftUtils.renameProject(projectName);
        fastDraftUtils.fillInRenamePopupDetails(projectNewName);
    }

    @When("^the user renames the project \"([^\"]*)\" with \"([^\"]*)\" and clicks cancel$")
    public void renameProjectAndClickCancel(String projectName, String projectNewName) throws Throwable {
        fastDraftUtils.renameProject(projectName);
        fastDraftUtils.renameAndClickCancel(projectNewName);
    }

    @When("^the user renames the document \"([^\"]*)\" with \"([^\"]*)\"$")
    public void renameDocument(String documentName, String documentNewName) throws Throwable {
        fastDraftUtils.renameDocument(documentName);
        fastDraftUtils.fillInRenamePopupDetails(documentNewName);
    }

    @When("^the user renames the document \"([^\"]*)\" with \"([^\"]*)\" and clicks cancel$")
    public void renameDocumentAndClickCancel(String documentName, String documentNewName) throws Throwable {
        fastDraftUtils.renameDocument(documentName);
        fastDraftUtils.renameAndClickCancel(documentNewName);
    }

    @When("^the user archives the project \"([^\"]*)\" and clicks cancel$")
    public void archiveProjectAndClickCancel(String projectName) throws Throwable {
        fastDraftUtils.archiveProjectAndClickCancel(projectName);
    }

    @When("^the user archives the project \"([^\"]*)\"$")
    public void archiveProject(String projectName) throws Throwable {
        fastDraftUtils.archiveProject(projectName);
    }

    @When("^the user goes Archive$")
    public void goArchive() throws Throwable {
        fastDraftUtils.goArchive();
    }

    @When("^the user unarchives the project \"([^\"]*)\" and clicks cancel$")
    public void unarchiveProjectAndClickCancel(String projectName) throws Throwable {
        fastDraftUtils.unarchiveProjectAndClickCancel(projectName);
    }

    @When("^the user unarchives the project \"([^\"]*)\"$")
    public void unarchiveProject(String projectName) throws Throwable {
        fastDraftUtils.unarchiveProject(projectName);
    }

    @When("^the user switches to current projects$")
    public void switchesToCurrentProjects() throws Throwable {
        fastDraftUtils.switchesToCurrentProjects();
    }

}
