package com.thomsonreuters.sitestructure.step_definitions.compartments;

import com.thomsonreuters.pageobjects.common.CommonMethods;
import com.thomsonreuters.pageobjects.pages.header.WLNHeader;
import com.thomsonreuters.sitestructure.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.otherPages.NavigationCobalt;
import com.thomsonreuters.pageobjects.pages.plPlusKnowHowResources.KHResourcePage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertTrue;

public class CompartmentSwitchingTest extends BaseStepDef {

    private NavigationCobalt navigationCobalt = new NavigationCobalt();
    private KHResourcePage resourcePage = new KHResourcePage();
    private WLNHeader wlnHeader = new WLNHeader();
    private CommonMethods comMethods = new CommonMethods();

    @When("^user navigates directly to document with plcref \"(.*?)\"$")
    public void userNavigatesDirectlyToDocumentWithPlcref(String plcRef) throws Throwable {
        navigationCobalt.navigateToWLNSpecificResourcePage("/" + plcRef);
        resourcePage.waitForPageToLoadAndJQueryProcessing();
    }

    @When("^the user expands the prodcut drop-down$")
    public void theUserTogglesToProduct() throws Throwable {
        comMethods.mouseOver(wlnHeader.compartmentToggleDropDown());
    }

    @When("^the user selects \"(.*)\" product$")
    public void theUserSelectsProduct(String prodName) throws Throwable {

        if(prodName.equalsIgnoreCase("Practical Law")){
            wlnHeader.compartmentToggleDropDownLink("pluk").click();
        }else if(prodName.equalsIgnoreCase("Westlaw UK")){
            wlnHeader.compartmentToggleDropDownLink("wluk").click();
        }else if(prodName.equalsIgnoreCase("Library")){
            wlnHeader.compartmentToggleDropDownLink("library").click();
        }
    }

    @Then("^user should see \"([^\"]*)\" as a text rather than a link in product drop-down$")
    public void userShouldSeeAsATextRatherThanALinkInProductDropDown(String prodName) throws Throwable {
        comMethods.mouseOver(wlnHeader.compartmentToggleDropDown());

         if(prodName.equalsIgnoreCase("Practical Law")){
            System.out.println("PL : "+comMethods.waitForElementToBeVisible(wlnHeader.compartmentToggleDropDownByLink("pluk"), 100) == null);
            assertTrue(prodName + " still visible as a link..!", comMethods.waitForElementToBeVisible(wlnHeader.compartmentToggleDropDownByLink("pluk"), 100)==null);
        }else if(prodName.equalsIgnoreCase("Westlaw UK")){
            System.out.println("WLUK : "+comMethods.waitForElementToBeVisible(wlnHeader.compartmentToggleDropDownByLink("wluk"), 100) == null);
            assertTrue(prodName +" still visible as a link..!",comMethods.waitForElementToBeVisible(wlnHeader.compartmentToggleDropDownByLink("wluk"), 100)==null);
        }else if(prodName.equalsIgnoreCase("Commentary")){
            System.out.println("Commentary : "+comMethods.waitForElementToBeVisible(wlnHeader.compartmentToggleDropDownByLink("library"), 100) == null);
            assertTrue(prodName +" still visible as a link..!",comMethods.waitForElementToBeVisible(wlnHeader.compartmentToggleDropDownByLink("library"),100)==null);
        }
    }

}

