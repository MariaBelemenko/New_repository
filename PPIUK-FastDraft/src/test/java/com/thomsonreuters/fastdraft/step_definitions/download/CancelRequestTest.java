package com.thomsonreuters.fastdraft.step_definitions.download;

import com.thomsonreuters.fastdraft.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.utils.fastDraft.FastDraftUtils;
import cucumber.api.java.en.When;

public class CancelRequestTest extends BaseStepDef {

    private FastDraftUtils fastDraftUtils = new FastDraftUtils();

    @When("^the user clicks Upload Form E$")
    public void clickUploadFormE() throws Throwable {
        fastDraftUtils.clickUploadFormEFromFormEPage();
    }

}
