package com.thomsonreuters.ffh.step_definitions;

import com.thomsonreuters.driver.framework.WebDriverDiscovery;
import com.thomsonreuters.pageobjects.rest.FolderBaseUtils;
import cucumber.api.java.en.When;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ApiBehaviourSteps extends BaseStepDef {

    private FolderBaseUtils restSteps = new FolderBaseUtils();
    private CommonLoginNaviagtionSteps commonLoginNaviagtionSteps = new CommonLoginNaviagtionSteps();
    private WebDriverDiscovery webDriverDiscovery = new WebDriverDiscovery();

    @When("^API creates folder with name '(.+)' with parent '(.+)'$")
    public void apiCreatesFolderWithNameWithParent(String newFolderName, String parentFolderName) throws Throwable {
        restSteps.createFolder(newFolderName, parentFolderName);
    }

    /**
     * After using super delete user should relogin.
     */
    @When("^API cleans all folders and history$")
    public void apiCleansAllFoldersAndHistory() throws Throwable {
        restSteps.setOnepassLoginUtils(getOnepassLoginUtils());
        restSteps.doSuperDelete();
    }

    @When("^API cleans all folders and history and user relogs in$")
    public void apiCleansAllFoldersAndHistoryAndUserRelogsIn() throws Throwable {
        restSteps.setOnepassLoginUtils(getOnepassLoginUtils());
        restSteps.doSuperDelete();
        commonLoginNaviagtionSteps.userRelogsIn();
    }

    /**
     * Current implementation works only with PLCUK product.
     * Need to remove this method and use apiCleansAllFoldersAndHistory() after new implementation will be finished
     */
    @Deprecated
    @When("^WLN API cleans all folders and history$")
    public void wlnApiCleansAllFoldersAndHistory() throws Throwable {
        // TODO remove
        RemoteWebDriver driver = webDriverDiscovery.getRemoteWebDriver();
        if (driver.getCapabilities().getBrowserName().equals("internet explorer")) {
            LOG.error("API calls are not implemented for IE");
            return;
        }
        restSteps.setOnepassLoginUtils(getOnepassLoginUtils());
        restSteps.wlnDoSuperDelete();
    }

}