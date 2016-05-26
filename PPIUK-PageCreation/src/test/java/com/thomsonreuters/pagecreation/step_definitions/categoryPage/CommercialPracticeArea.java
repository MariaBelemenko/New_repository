package com.thomsonreuters.pagecreation.step_definitions.categoryPage;

import com.thomsonreuters.pagecreation.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.common.CommonMethods;
import com.thomsonreuters.pageobjects.pages.landingPage.CommercialPracticeAreaHomePage;
import com.thomsonreuters.pageobjects.pages.landingPage.PracticeAreaLandingPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

/**
 * Phil Harper, SD file for tests for CPET Commercial Practice Area
 * Created by U0162413 on 08/04/2016.
 */
public class CommercialPracticeArea extends BaseStepDef {
    PracticeAreaLandingPage PLPracticeArea = new PracticeAreaLandingPage();
    private CommonMethods commonMethods = new CommonMethods();
    CommercialPracticeAreaHomePage CommercialPAHome = new CommercialPracticeAreaHomePage();

    @Given("^the user navigates to the PL website \"(.*?)\"$")
    public void theUserNavigatesToThePLWebsite(String website) throws Throwable {
        commonMethods.navigate(website);
    }

    @And("^navigates to the Practice Area \"(.*?)\"$")
    public void navigatesToThePracticeArea(String linkText) throws Throwable {
        PLPracticeArea.genericLink(linkText).click();
    }

    @When("^the Tab is selected \"(.*?)\"$")
    public void theTopicsTabIsSelected(String linkText) throws Throwable {
        CommercialPAHome.menuTab(linkText).click();
    }

}

