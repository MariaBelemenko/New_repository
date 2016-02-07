package com.thomsonreuters.frontend.step_definitions.header;

import com.thomsonreuters.frontend.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.common.CommonMethods;
import com.thomsonreuters.pageobjects.pages.header.WLNHeader;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class BrowseMenuTest extends BaseStepDef {

    private CommonMethods comMethods = new CommonMethods();
    private WLNHeader header = new WLNHeader();

    @Given("^user clicks on \"(.*?)\" dropdown$")
    public void userClicksOnDropdown(String arg1) throws Throwable {
        comMethods.waitForElement(header.browseMenuButton(), 5000);
        int count = 0;
        do {
            count++;
            header.browseMenuButton().click();
        } while ((!comMethods.waitForElement(header.browseMenuPopup(), 500)) && count < 4);
    }

    @Then("^user should see the \"(.*?)\" button arrow and hover behavior according to design document$")
    public void userShouldSeeTheButtonArrowAndHoverBehaviorAccordingToDesignDocument(String arg1) throws Throwable {
        assertTrue("Popup is not open..!", header.browseMenuPopup().isDisplayed());
    }

    @Then("^user should see the \"(.*?)\" popup with Practice Area and Resources sub-menu$")
    public void userShouldSeeThePopupWithPracticeAreaAndResourcesSubMenu(String arg1) throws Throwable {
        assertTrue("Practice Area is not displayed..!", header.browseMenuSubMenuList().get(0).isDisplayed());
        assertTrue("Resources is not displayed..!", header.browseMenuSubMenuList().get(1).isDisplayed());
    }

    @Then("^user clicks on following sub-menu and see the respective links according to the design$")
    public void userClicksOnSubMenuAndSeeTheRespectiveLinksAccordingToTheDesign(List<String> subMenuList) throws Throwable {
        for (String aSubMenuList : subMenuList) {
            comMethods.getElementByLinkText(aSubMenuList).click();
            if (aSubMenuList.trim().equalsIgnoreCase("Practice areas")) {
                assertTrue("Practice Area Links are not displayed..!", header.practiceAreaFirstColumnLinks().get(0).isDisplayed());
            } else if (aSubMenuList.trim().equalsIgnoreCase("Resources")) {
                assertTrue("Resources Links are not displayed..!", header.resourcesFirstColumnLinks().get(0).isDisplayed());
            } else if (aSubMenuList.trim().equalsIgnoreCase("International")) {
                assertTrue("International Links are not displayed..!", header.internationalFirstColumnLinks().get(0).isDisplayed());
            }
        }
    }

}
