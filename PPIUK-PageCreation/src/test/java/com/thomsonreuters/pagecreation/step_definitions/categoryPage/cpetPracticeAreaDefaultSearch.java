package com.thomsonreuters.pagecreation.step_definitions.categoryPage;

import com.thomsonreuters.pagecreation.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.common.CommonMethods;
import com.thomsonreuters.pageobjects.pages.landingPage.PracticeAreaLandingPage;
import com.thomsonreuters.pageobjects.pages.pageCreation.HomePage;
import com.thomsonreuters.pageobjects.pages.pageCreation.PLRssWidget;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.Given;

public class cpetPracticeAreaDefaultSearch extends BaseStepDef {
    PLRssWidget PLRSS = new PLRssWidget();
    PracticeAreaLandingPage PLPracticeAreas = new PracticeAreaLandingPage();
    private CommonMethods commonMethods = new CommonMethods();
    HomePage HomePage = new HomePage();

/**Phil Harper, SD file for tests for CPET Practice Area testing. This relates to Default Search
        * Created by U0162413 on 19/04/2016.
 */

    @Then("^the user verifies the search default matches the practice area \"([^\"]*)\"$")
    public void theUserVerifiesTheSearchDefaultMatchesThePracticeArea(String practiceAreaSearchDefault) throws Throwable {
        PLPracticeAreas.PASearchDefault(practiceAreaSearchDefault).isDisplayed();
        }

    @Given("^the user accesses each Practice Area via Browse Menu > \"([^\"]*)\"$")
    public void theUserAccessesEachPracticeAreaViaBrowseMenu(String linktext) throws Throwable {
        HomePage.PracticeAreaViaBrowse(linktext).click();

    }

}