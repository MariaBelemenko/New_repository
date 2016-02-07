package com.thomsonreuters.frontend.step_definitions.header;

import com.thomsonreuters.frontend.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.pages.header.WLNHeader;
import cucumber.api.java.en.Then;
import org.junit.Assert;

public class HeaderDropdownTest extends BaseStepDef {

    private WLNHeader header = new WLNHeader();

    @Then("^user should see history link$")
    public void userShouldSeeHitoryLink() throws Throwable {
        Assert.assertTrue("History link not displayed..!", header.historyLink().isDisplayed());
    }

    @Then("^user clicks on history mainlink$")
    public void userClicksOnHistoryLink() throws Throwable {
        header.historyLink().click();
    }

    @Then("^user should see history page$")
    public void userShouldSeeHistoryPage() throws Throwable {
        Assert.assertTrue("History page not displayed..!", header.historyHeadingTitle().isDisplayed());
    }

}
