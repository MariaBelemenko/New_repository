package com.thomsonreuters.pagecreation.step_definitions.categoryPage;

import com.thomsonreuters.pagecreation.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.pages.pageCreation.CommonPracticeAreaPage;
import cucumber.api.java.en.Then;

public class PracticeAreaPageSteps extends BaseStepDef {

    private CommonPracticeAreaPage commonPracticeAreaPage;

    public PracticeAreaPageSteps() {
        commonPracticeAreaPage = new CommonPracticeAreaPage();
    }

    @Then("^'add to favorites' and 'back to home' button are present$")
    public void addToFavoritesAndBackToHomeButtonArePresent() throws Throwable {
        commonPracticeAreaPage.addTpFavoritesButton().isDisplayed();
    }

    @Then("^the category tabs are present$")
    public void theCategoryTabsArePresent() throws Throwable {
        commonPracticeAreaPage.backToHomepageButton().isDisplayed();
    }

}