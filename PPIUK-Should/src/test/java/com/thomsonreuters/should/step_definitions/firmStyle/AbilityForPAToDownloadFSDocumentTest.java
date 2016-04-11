package com.thomsonreuters.should.step_definitions.firmStyle;

import static org.junit.Assert.assertTrue;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.List;

import com.thomsonreuters.pageobjects.common.FileActions;
import com.thomsonreuters.pageobjects.otherPages.NavigationCobalt;
import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document.StandardDocumentPage;
import com.thomsonreuters.pageobjects.pages.widgets.CategoryPage;
import com.thomsonreuters.should.step_definitions.BaseStepDef;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;

public class AbilityForPAToDownloadFSDocumentTest extends BaseStepDef {

    private CategoryPage categoryPage = new CategoryPage();
    private StandardDocumentPage standardDocumentPage = new StandardDocumentPage();
    private NavigationCobalt navigationCobalt = new NavigationCobalt();
    private FileActions fileActions = new FileActions();
    
    private final static String DOWNLOADED_FILE_PATH = System.getProperty("user.home") + "/Downloads";
    private File downloadedFile = null;
    
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
    
    @When("^the user opens (.+) url on plcuk website$")
    public void theUserOpensUrlOnPLCUKSite(String url) throws Throwable {
        navigationCobalt.navigateToPLCUKPlusSpecificURL(url);
        navigationCobalt.waitForPageToLoadAndJQueryProcessingWithCustomTimeOut(90);
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
    
    @Then("\"([^\"]*)\" page is displayed$")
    public void loginPageIsDisplayed(String pageUrl) throws Throwable {
        standardDocumentPage.waitForPageToLoad();
        assertTrue("'" + pageUrl + "' page is not displayed", standardDocumentPage.getCurrentUrl().contains(pageUrl));
    }

    @When("^the user opens \"([^\"]*)\" link$")
    public void openLinkFromList(String linkName) throws Throwable {
        categoryPage.openPageByText(linkName);
    }

    @When("^the user clicks Firm Style link$")
    public void clickFirmStyleLink() throws Throwable {
        standardDocumentPage.firmStyle().click();
        standardDocumentPage.waitForPageToLoad();
    }

	@When("the user clicks on FS download link \"([^\"]*)\"")
	public void clickDownloadFSFile(String linkName) throws Throwable {
		standardDocumentPage.downloadFSFile(linkName).click();
	}

	@When("the user clicks on Home page")
	public void clickHomePage() throws Throwable {
		standardDocumentPage.homePage().click();
		standardDocumentPage.waitForPageToLoad();
	}
}
