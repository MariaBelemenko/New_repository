package com.thomsonreuters.sitestructure.step_definitions.compartments;

import com.thomsonreuters.sitestructure.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.otherPages.NavigationCobalt;
import com.thomsonreuters.pageobjects.pages.plPlusKnowHowResources.KHResourcePage;
import cucumber.api.java.en.When;

public class CompartmentSwitchingTest extends BaseStepDef {

    private NavigationCobalt navigationCobalt = new NavigationCobalt();
    private KHResourcePage resourcePage = new KHResourcePage();

    @When("^user navigates directly to document with plcref \"(.*?)\"$")
    public void userNavigatesDirectlyToDocumentWithPlcref(String plcRef) throws Throwable {
        navigationCobalt.navigateToWLNSpecificResourcePage("/" + plcRef);
        resourcePage.waitForPageToLoadAndJQueryProcessing();
    }
}