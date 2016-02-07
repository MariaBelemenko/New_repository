package com.thomsonreuters.ask.step_definitions.common;

import com.thomsonreuters.ask.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.otherPages.NavigationCobalt;
import com.thomsonreuters.pageobjects.pages.ask.AskCategoryPage;
import com.thomsonreuters.pageobjects.pages.header.WLNHeader;
import com.thomsonreuters.pageobjects.pages.pageCreation.HomePage;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.hamcrest.Matchers;
import org.hamcrest.core.Is;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.isIn;
import static org.junit.Assert.assertTrue;

public class AskOurPeopleTest extends BaseStepDef {

    private NavigationCobalt navigationCobalt = new NavigationCobalt();
    private WLNHeader wlnHeader = new WLNHeader();
    private HomePage homePage = new HomePage();
    private AskCategoryPage askCategoryPage = new AskCategoryPage();

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

    @When("^the user clicks link '(.*)' on '(.*)' page$")
    public void theUserClicksLinkOnPage(String link, String page) throws Throwable {
        if (!link.equals("")) {
            if (page.contains("Browse")) {
                homePage.findChildElement(homePage.getPracticeAreasBrowseMenuContainer(), By.linkText((link))).click();
            } else {
                try {
                    homePage.waitForExpectedElement(By.linkText(link), 2).click();
                } catch (Exception e) {
                    homePage.waitForExpectedElement(By.partialLinkText(link), 5).click();
                }
            }
            Thread.sleep(2000);
            homePage.waitForPageToLoad();
        }
    }

    @Then("^the user verifies that Our people widget is correctly displayed$")
    public void theUserVerifiesThatOurPeopleWidgetIsCorrectlyDisplayed() throws Throwable {
        askCategoryPage.waitForPageToLoadAndJQueryProcessing();
        assertThat("The Our People Widget is NOT displayed", askCategoryPage.askOurPeopleWidget().isDisplayed(), Is.is(true));
        String ourPeopleWidgetText = askCategoryPage.askOurPeopleWidget().getText().replaceAll("\\n", "");
        assertThat("The Our People Widget-Header does not contain Our people", ourPeopleWidgetText, Matchers.containsString("Our people"));
        assertThat("The Our People Widget-Content does not contain expected text", ourPeopleWidgetText, Matchers.containsString("Our quality starts with our people. Their job is to help you do yours"));
    }

    @And("^the user verifies that Head of PracticeArea Team for '(.*)' in Our people widget is '(.*)'$")
    public void the_user_verifies_that_Head_of_PracticeArea_Team_for_PA_in_Our_people_widget_contains_HeadOfPracticeArea_(String practiceArea, String headOfPaName) throws Throwable {
        String ourPeopleWidgetText = askCategoryPage.askOurPeopleWidget().getText().replaceAll("\\n", "");
        assertThat("The Our People Widget-Head of Practice Area does nt contain correct name", ourPeopleWidgetText, Matchers.containsString(headOfPaName));
        assertThat("The Our People Widget-Head of Practice Area does nt contain correct text: Head of Practical Law " + practiceArea, ourPeopleWidgetText, Matchers.containsString("Head of Practical Law "
                + practiceArea.replaceAll("Restructuring and Insolvency", "Restructuring & Insolvency").replaceAll("IP & IT", "IP&IT").replaceAll("Share Schemes & Incentives", "Share Schemes and Incentives")));
    }

    @And("^the user verifies that Our people widget contains one of the following as Head of PracticeArea along with Practice Area$")
    public void the_user_verifies_that_Our_people_widget_contains_one_of_the_following_as_Head_of_PracticeArea_along_with_Practice_Area(DataTable dataTable) throws Throwable {
        List<String> paLinks = new ArrayList<String>();
        List<String> paHeads = new ArrayList<String>();
        for (Map<String, String> map : dataTable.asMaps(String.class, String.class)) {
            paLinks.add(map.get("PracticeAreaLink"));
            paHeads.add(map.get("HeadOfPracticeArea"));
        }
        assertThat("The Our People Widget in main Ask Landing Page-Head of Practice Area does nt contain expected Practice Area Head name", askCategoryPage.askOurPeoplePaHeadNameText().getText(), isIn(paHeads));
        String headOfPlLawText = askCategoryPage.askOurPeopleHeadPlLawText().getText();
        headOfPlLawText = headOfPlLawText.replaceAll("Head of Practical Law ", "");
        assertThat("The Our People Widget in main Ask Landing Page-Head of Practical Law--- does nt contain expected Practice Area name", headOfPlLawText, isIn(paLinks));
    }

}
