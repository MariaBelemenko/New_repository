package com.thomsonreuters.firmstyle.step_definitions.common;

import com.thomsonreuters.firmstyle.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.common.FileActions;
import com.thomsonreuters.pageobjects.common.WindowHandler;
import com.thomsonreuters.pageobjects.otherPages.NavigationCobalt;
import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document.StandardDocumentPage;
import com.thomsonreuters.pageobjects.pages.widgets.CategoryPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class PADownloadFSDocumentTest extends BaseStepDef {

    private NavigationCobalt navigationCobalt = new NavigationCobalt();
    private CategoryPage categoryPage = new CategoryPage();
    private WindowHandler windowHandler = new WindowHandler();
    private StandardDocumentPage standardDocumentPage = new StandardDocumentPage();
    private FileActions fileActions = new FileActions();

    private final static String DOWNLOADED_FILE_PATH = System.getProperty("user.home") + "/Downloads";

    private File downloadedFile = null;

    @When("^the user come back on to Home page$")
    public void userComeBackOnToHomePage() throws Throwable {
        navigationCobalt.waitForPageToLoad();
        if (!isHomePage()) {
            navigationCobalt.navigateToHomePage();
            navigationCobalt.waitForPageToLoad();
        }
    }

    @When("^the user deletes all files with name \"([^\"]*)\" and extension \"([^\"]*)\" from Downloads$")
    public void deleteFilesFormDownloads(String name, String extension) throws Throwable {
        File dir = new File(DOWNLOADED_FILE_PATH);
        List<File> files = (List<File>) FileUtils.listFiles(dir, TrueFileFilter.INSTANCE, null);
        for (File file : files) {
            if (file.getName().contains(name) && file.getName().contains(extension)) {
                file.delete();
            }
        }
    }

    @When("^the user opens '(.+)' link$")
    public void openLink(String linkName) throws Throwable {
        categoryPage.openPageByText(linkName);
    }

    @When("^the user opens \"([^\"]*)\" link$")
    public void openLinkFromList(String linkName) throws Throwable {
        categoryPage.openPageByText(linkName);
    }

    @When("the user clicks Firm Style link and download a document")
    public void clickFirmStyleAndDownloadDocument() throws Throwable {
        windowHandler.fileDownload(standardDocumentPage.firmStyle());
    }

    @Then("^the file \"([^\"]*)\" should be downloaded to the users machine$")
    public void fileShouldDownloadToTheUsersMachine(String name) throws Throwable {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ESCAPE);
        robot.keyRelease(KeyEvent.VK_ESCAPE);

        downloadedFile = fileActions.findFile(name, DOWNLOADED_FILE_PATH);
        assertTrue("File was not downloaded", downloadedFile != null && downloadedFile.exists());
    }

    @Then("^the file \"([^\"]*)\" should be removed$")
    public void deleteDownloadedDocFile(String name) throws Throwable {
        fileActions.deleteFile(downloadedFile);
    }

    @When("^the user opens (.+) url on plcuk website$")
    public void theUserOpensUrlOnPLCUKSite(String url) throws Throwable {
        navigationCobalt.navigateToPLCUKPlusSpecificURL(url);
        navigationCobalt.waitForPageToLoadAndJQueryProcessingWithCustomTimeOut(90);
    }

    private boolean isHomePage() {
        if (!(navigationCobalt.getCurrentUrl().contains("/Search/Home.html")
                || navigationCobalt.getCurrentUrl().contains("/Search/BrowseRoot.html") || navigationCobalt.getCurrentUrl()
                .contains("Home/Home"))) {
            return false;
        }
        return true;
    }

}
