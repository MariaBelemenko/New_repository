package com.thomsonreuters.fastdraft.step_definitions.create;

import com.thomsonreuters.fastdraft.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.utils.fastDraft.FastDraftUtils;
import cucumber.api.java.en.When;

public class CreateDeleteSaveFastDraftProjectTest extends BaseStepDef {

    private FastDraftUtils fastDraftUtils = new FastDraftUtils();

    @When("^the user deletes the document \"([^\"]*)\" and click cancel$")
    public void deleteDocumentAndCancel(String document) throws Throwable {
        fastDraftUtils.deleteDocumentAndCancel(document);
    }

    @When("^the user deletes the project \"([^\"]*)\" and click cancel$")
    public void deleteProjectAndCancel(String projectName) throws Throwable {
        fastDraftUtils.deleteProjectAndCancel(projectName);
    }

}
