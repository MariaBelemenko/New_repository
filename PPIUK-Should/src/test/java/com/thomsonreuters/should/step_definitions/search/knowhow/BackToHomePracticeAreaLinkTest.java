package com.thomsonreuters.should.step_definitions.search.knowhow;


import com.thomsonreuters.pageobjects.otherPages.NavigationCobalt;
import com.thomsonreuters.should.step_definitions.BaseStepDef;
import cucumber.api.java.en.Given;

public class BackToHomePracticeAreaLinkTest extends BaseStepDef {

    private NavigationCobalt navigationCobalt = new NavigationCobalt();

    @Given("^the user is on the home page$")
    public void aUserIsOnTheHomePage() throws Throwable {
        navigationCobalt.navigateToHomePage();
    }

}
