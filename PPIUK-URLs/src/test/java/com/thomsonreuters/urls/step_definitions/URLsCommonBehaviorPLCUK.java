package com.thomsonreuters.urls.step_definitions;

import com.thomsonreuters.pageobjects.otherPages.NavigationCobalt;
import cucumber.api.java.en.When;

public class URLsCommonBehaviorPLCUK extends BaseStepDef {

    private NavigationCobalt navigationCobalt = new NavigationCobalt();

    public static final String oldDomain = "http://uk.practicallaw.com";

    @When("^the user opens (.+) url on plcuk website$")
    public void theUserOpensUrlOnPLCUKSite(String url) throws Throwable {
        navigationCobalt.navigateToPLCUKPlusSpecificURL(url);
        navigationCobalt.waitForPageToLoadAndJQueryProcessingWithCustomTimeOut(90);
    }

    @When("^the user opens (.+) on the old practical law website$")
    public void theUserOpensURLOnTheOldPracticalLawWebsite(String url) throws Throwable {
        if (url.startsWith("/")) {
            url = oldDomain + url;
        }
        navigationCobalt.navigate(url);
    }

}
