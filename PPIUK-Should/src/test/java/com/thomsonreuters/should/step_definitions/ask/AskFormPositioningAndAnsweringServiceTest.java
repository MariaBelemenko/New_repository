package com.thomsonreuters.should.step_definitions.ask;

import com.thomsonreuters.pageobjects.otherPages.NavigationCobalt;
import com.thomsonreuters.pageobjects.pages.ask.AskFormPage;
import com.thomsonreuters.pageobjects.pages.header.WLNHeader;
import com.thomsonreuters.pageobjects.pages.plPlusKnowHowResources.KHResourcePage;
import com.thomsonreuters.pageobjects.utils.ask.AskFormField;
import com.thomsonreuters.should.step_definitions.BaseStepDef;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.hamcrest.core.Is;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.junit.Assert.assertTrue;

public class AskFormPositioningAndAnsweringServiceTest extends BaseStepDef {

    private NavigationCobalt navigationCobalt = new NavigationCobalt();
    private WLNHeader wlnHeader = new WLNHeader();
    private KHResourcePage resourcePage = new KHResourcePage();
    private AskFormPage askFormPage = new AskFormPage();

    private String mainWindowHandle;
    private String askWindowHandle;

    @And("^the user is in page '(.*)' with page Title '(.*)'$")
    public void theUserIsInPageResourcecsBooksOnlineWithPageTitle(String pages, String expectedTitle) throws Throwable {
        List<String> links = Arrays.asList(pages.split(">"));
        for (String link : links) {
            if (link.contains("/")) {
                navigationCobalt.navigateToRelativeURL(link);
            } else {
                if (link.equalsIgnoreCase("Browse Menu")) {
                    wlnHeader.browseMenuButton().click();
                } else {
                    navigationCobalt.waitForElementPresent(By.linkText(link)).click();
                }
                navigationCobalt.waitForPageToLoad();
            }
        }
        assertTrue(wlnHeader.pageHeaderLabel().getText().equals(expectedTitle));
    }

    @When("^the user clicks on 'Ask a question' link to ask a question$")
    public void theUserClicksASKILinkToAskAQuestion() throws Throwable {
        mainWindowHandle = resourcePage.getWindowHandle();
        resourcePage.askAQuestion().click();
        resourcePage.waitForPageToLoad();
    }

    @Then("^ASK form is displayed in new window$")
    public void askFormIsDisplayedInNewWindow() throws Throwable {
        resourcePage.waitForPageToLoad();
        int windowsCount;
        int counter = 10;
        do {
            windowsCount = resourcePage.getWindowHandles().size();
            counter--;
            Thread.sleep(1000);
        }
        while (windowsCount < 2 && counter > 0);
        assertThat("The no of popupWindows opened is less than 2", resourcePage.getWindowHandles().size(), greaterThanOrEqualTo(2));
        for (String windowHandle : resourcePage.getWindowHandles()) {
            if (!windowHandle.equalsIgnoreCase(mainWindowHandle)) {
                askWindowHandle = windowHandle;
                resourcePage.switchToWindow(askWindowHandle);
                assertThat("Ask form is not displayed", askFormPage.askFormPageTitle().isDisplayed(), Is.is(true));
            }
        }
    }

    @When("^the user accepts ASK disclaimer terms$")
    public void acceptsDisclaimerTerms() throws Throwable {
        askFormPage.disclaimerTermsCheckbox().click();
    }

    @Then("^user verifies that when (.*) is selected corresponding (.*) dropdownlist have valid values$")
    public void userVerifiesThatWhenOrganisationTypeIsSelectedCorrespondingPositionDroplistHaveValidValues(String baseDropDown, String childDropDown, DataTable dataTable) throws Throwable {
        for (Map<String, String> map : dataTable.asMaps(String.class, String.class)) {
            String baseDropDownValue = map.get(baseDropDown);
            String childDropDownValues = map.get(childDropDown);
            WebElement basedropdownList = askFormPage.waitForElementPresent(AskFormField.getByFieldDisplayName(baseDropDown).getBy());
            askFormPage.selectDropDownByVisibleText(basedropdownList, baseDropDownValue);
            WebElement childdropdownList = askFormPage.waitForElementPresent(AskFormField.getByFieldDisplayName(childDropDown).getBy());
            assertThat(childDropDown + " drop down list for " + baseDropDownValue + ",does  NOT contain expected values :" + childDropDownValues, childdropdownList.getText().replaceAll("\\n", ","), Is.is(childDropDownValues));
        }
    }

}
