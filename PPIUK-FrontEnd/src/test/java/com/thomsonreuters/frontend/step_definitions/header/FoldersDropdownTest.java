package com.thomsonreuters.frontend.step_definitions.header;

import com.thomsonreuters.frontend.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.common.CommonMethods;
import com.thomsonreuters.pageobjects.pages.header.WLNHeader;
import cucumber.api.java.en.Then;
import org.junit.Assert;

public class FoldersDropdownTest extends BaseStepDef {

    private CommonMethods comMethods = new CommonMethods();
    private WLNHeader header = new WLNHeader();

    @Then("^user should see \"(.*)\" link$")
    public void userShouldSeeLink(String linkText) throws Throwable {
        Assert.assertTrue(linkText + " link not displayed..!", comMethods.isLinkTextPresent(linkText, 2000));
    }

    @Then("^user clicks on folders mainlink$")
    public void userClicksOnFoldersLink() throws Throwable {
        header.foldersLink().click();
    }

    @Then("^user should see folders page$")
    public void userShouldSeeFoldersPage() throws Throwable {
        Assert.assertTrue("Folders page not displayed..!", header.folderHeadingTitle().isDisplayed());
    }

}
