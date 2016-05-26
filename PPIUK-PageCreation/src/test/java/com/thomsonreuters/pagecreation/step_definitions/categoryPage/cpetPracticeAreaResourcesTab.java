package com.thomsonreuters.pagecreation.step_definitions.categoryPage;

/**
 * Phil Harper, SD file for tests for CPET Practice Area Resources Tab.
 * Created by U0162413 on 19/05/2016.
 */

import com.thomsonreuters.pagecreation.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.common.CommonMethods;
import com.thomsonreuters.pageobjects.pages.pageCreation.AskPracticeAreaPage;
import com.thomsonreuters.pageobjects.pages.pageCreation.HomePage;
import com.thomsonreuters.pageobjects.pages.pageCreation.PracticeAreaTopicsResourcesTabs;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;


public class cpetPracticeAreaResourcesTab extends BaseStepDef {
    PracticeAreaTopicsResourcesTabs PLPATopRes = new PracticeAreaTopicsResourcesTabs();
    AskPracticeAreaPage AskPracticeArea = new AskPracticeAreaPage();
    private CommonMethods commonMethods = new CommonMethods();
    private HomePage homePage = new HomePage();



    @Then("^user clicks on Resources Tab, verifies the links$")
    public void userclicksonResourcesTabverifiesthelinks(DataTable PracticeAreaResources) throws Throwable {
        List<String> PracticeareaResourcesLink = new ArrayList<String>();
        for (Map<String, String> map : PracticeAreaResources.asMaps(String.class, String.class)) {
            PracticeareaResourcesLink.add(map.get("practiceAreaResourceslink"));
        }
        for (int i = 0; i < PracticeareaResourcesLink.size(); i++) {
            PLPATopRes.ResourcesTab().click();
            String resourceLinkLabel=PLPATopRes.ResourcesDefaultLabel().getText();
            assertThat("Actual resourcelink heading is : " + resourceLinkLabel + " Expected heading is : " +
                    PracticeareaResourcesLink.get(i), resourceLinkLabel.equals(PracticeareaResourcesLink.get(i)));
            commonMethods.browserGoBack();
        }
    }

    @And("^user clicks on Resources Tab$")
    public void userclicksonResourcesTab() throws Throwable {
        PLPATopRes.ResourcesTab().click();
    }

    @Then("^the user verifies that the Practice Area \"([^\"]*)\" links are displayed$")
    public void theuserverifiesthatthePracticeArealinksaredisplayed (String ResourceList) throws Throwable {
        assertThat ("The 'Resource' link is NOT displayed ", PLPATopRes.ResourcesDefault(ResourceList).isDisplayed());
    }


}
