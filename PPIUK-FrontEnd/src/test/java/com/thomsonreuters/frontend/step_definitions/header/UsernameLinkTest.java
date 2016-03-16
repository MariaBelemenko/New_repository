package com.thomsonreuters.frontend.step_definitions.header;

import com.thomsonreuters.frontend.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.common.CommonMethods;
import com.thomsonreuters.pageobjects.pages.header.WLNHeader;
import com.thomsonreuters.pageobjects.pages.login.OnepassLogin;
import com.thomsonreuters.pageobjects.pages.onePass.OnePassLogoutPage;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static org.junit.Assert.assertTrue;

public class UsernameLinkTest extends BaseStepDef {

    private CommonMethods comMethods = new CommonMethods();
    private WLNHeader header = new WLNHeader();
    private OnepassLogin onePass = new OnepassLogin();
    private OnePassLogoutPage onePassLogoutPage = new OnePassLogoutPage();

    @Then("^user clicks on \"(.*)\" link$")
    public void userClicksOnLink(String linkText) throws Throwable {
        comMethods.waitElementByLinkText(linkText).click();
    }

    @Then("^user should see user icon link$")
    public void userShouldSeeUserIconLink() throws Throwable {
        assertTrue("User Icon link not displayed..!", header.usernameLink().isDisplayed());
    }

    @Then("^user clicks on user icon$")
    public void userHoversOnUsernameLink() throws Throwable {
        WebElement element = header.usernameIcon();
        comMethods.mouseOver(element);
    }

    @Then("^user should see the user popup$")
    public void userShouldSeeTheUserPopup() throws Throwable {
        assertTrue("Popup not displayed..!", header.userNamePopup().isDisplayed());
    }

    @Then("^user should navigate to (.*)$")
    public void userShouldNavigatedToPage(String resultPage) throws Throwable {
        if (resultPage.equalsIgnoreCase("One Pass")) {
            assertTrue("Onepass page not displayed..!", onePass.manageOnepassTitle().isDisplayed());
            header.browserGoBack();
            assertTrue("Login page not displayed..!", header.companyLogo().isDisplayed());
        } else if (resultPage.equalsIgnoreCase("Session Summary")) {
            assertTrue("Sign off page not displayed..!", onePassLogoutPage.signOffPageSignOnButton().isDisplayed());
            resetCurrentUser();
        } else if (resultPage.equalsIgnoreCase("Email preferences")) {
            assertTrue("Sign off page not displayed..!", comMethods.isTextPresent(header.emailPreferencesByHeading(), resultPage, 2000));
        }
    }

}
