package com.thomsonreuters.frontend.step_definitions.header;

import com.thomsonreuters.frontend.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.pages.header.WLNHeader;
import cucumber.api.java.en.Then;
import org.junit.Assert;

public class CompanyLogoTest extends BaseStepDef {

    private WLNHeader header = new WLNHeader();

    @Then("^user should see company logo$")
    public void userShouldSeeCompanyLogo() throws Throwable {
        Assert.assertTrue("Company logo not displayed..!", header.companyLogo().isDisplayed());
    }

    @Then("^user clicks on company logo$")
    public void userClicksOnCompanyLogo() throws Throwable {
        header.companyLogo().click();
    }

    @Then("^user should see \"(.*)\" page$")
    public void userShouldSeeHomePage(String pageTitle) throws Throwable {
        Assert.assertTrue(pageTitle+" page not displayed..!", header.pageHeaderLabel().getText().trim().contains(pageTitle));
    }

}
