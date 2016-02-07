package com.thomsonreuters.fastdraft.step_definitions.download;

import com.thomsonreuters.fastdraft.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.common.WindowHandler;
import com.thomsonreuters.pageobjects.pages.fastDraft.DraftViewPage;
import cucumber.api.java.en.When;

public class DownloadFDProjectTest extends BaseStepDef {

    private WindowHandler windowHandler = new WindowHandler();
    private DraftViewPage draftViewPage = new DraftViewPage();

    @When("^the user clicks Word document and saves .doc file$")
    public void clickWordDocument() throws Throwable {
        windowHandler.fileDownload(draftViewPage.wordDocument());
    }

    @When("^the user exports Form E as editable PDF$")
    public void exportEditablePDF() throws Throwable {
        Thread.sleep(10000);
        draftViewPage.export().click();
        windowHandler.fileDownloadAutomatically(draftViewPage.exportEditablePDF());
    }

    @When("^the user exports Form E as printable PDF$")
    public void exportPrintablePDF() throws Throwable {
        Thread.sleep(10000);
        draftViewPage.export().click();
        windowHandler.fileDownloadAutomatically(draftViewPage.exportPrintablePDF());
    }

}
