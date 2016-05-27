package com.thomsonreuters.sitestructure.step_definitions.urls;

import com.thomsonreuters.pageobjects.common.CommonMethods;
import com.thomsonreuters.pageobjects.otherPages.NavigationCobalt;
import com.thomsonreuters.pageobjects.pages.header.WLNHeader;
import com.thomsonreuters.pageobjects.pages.plPlusKnowHowResources.KHResourcePage;
import com.thomsonreuters.sitestructure.step_definitions.BaseStepDef;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertTrue;

public class ProductViewTest extends BaseStepDef {

    private WLNHeader wlnHeader = new WLNHeader();
    private CommonMethods comMethods = new CommonMethods();

    @Then("^the user should see \"(.*)\" homepage$")
    public void theUserShouldSeePLHomepage(String product) throws Throwable {
    }

    @Then("^the user should not see either the \"(.*)\" or \"(.*)\" homepage$")
    public void theUserShouldNotSeeEiterhTheCommentaryOrWLUKHomepage(String prod1, String prod2) throws Throwable {
    }


}

