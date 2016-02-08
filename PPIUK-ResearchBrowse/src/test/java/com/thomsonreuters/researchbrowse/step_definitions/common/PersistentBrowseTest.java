package com.thomsonreuters.researchbrowse.step_definitions.common;

import com.thomsonreuters.pageobjects.common.CommonMethods;
import com.thomsonreuters.pageobjects.otherPages.NavigationCobalt;
import com.thomsonreuters.pageobjects.otherPages.PLCLegacyBooksPage;
import com.thomsonreuters.pageobjects.pages.header.WLNHeader;
import com.thomsonreuters.pageobjects.pages.plPlusKnowHowResources.GlossaryPage;
import com.thomsonreuters.pageobjects.pages.plPlusKnowHowResources.KHResourcePage;
import com.thomsonreuters.pageobjects.pages.search.SearchHomePage;
import com.thomsonreuters.researchbrowse.step_definitions.BaseStepDef;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class PersistentBrowseTest extends BaseStepDef {

    private CommonMethods comMethods = new CommonMethods();
    private WLNHeader header = new WLNHeader();
    private PLCLegacyBooksPage plcLegacyBooksPage = new PLCLegacyBooksPage();
    private GlossaryPage glossaryPage = new GlossaryPage();
    private NavigationCobalt navigationCobalt = new NavigationCobalt();
    private KHResourcePage resourcePage = new KHResourcePage();
    private SearchHomePage searchHomePage = new SearchHomePage();

    private int CUSTOM_DRIVER_WAIT_TIME = 120;
    private String currentSection;

    @Given("^user clicks on \"(.*?)\" dropdown$")
    public void userClicksOnDropdown(String arg1) throws Throwable {
        comMethods.waitForElement(header.browseMenuButton(), 5000);
        int count = 0;
        do {
            count++;
            header.browseMenuButton().click();
        } while ((comMethods.waitForElement(header.browseMenuPopup(), 500) == false) && count < 4);
    }

    @When("^user selects sub-menu '(.*)'$")
    public void userClicksOnSubMenu(String subMenuLink) throws Throwable {
        currentSection = subMenuLink;
        comMethods.waitElementByLinkText(subMenuLink).click();
    }

//   @Then("^the following links should be present on the section$")
//    public void sectionLinksIsPresent(@Transpose List<String> linkNames) {
//        List<WebElement> sectionLinks = header.getActiveSectionLinks();
//        List<String> actualLinkNames = new ArrayList<>();
//        for (WebElement tabLink : sectionLinks) {
//            actualLinkNames.add(tabLink.getText());
//        }
//        SoftAssertions softAssertions = new SoftAssertions();
//        for (String linkName : linkNames) {
//            softAssertions.assertThat(actualLinkNames)
//                    .withFailMessage("Link '" + linkName + "' is not present")
//                    .contains(linkName);
//        }
//        softAssertions.assertAll();
//    }
//
//    @Then("the following links should be present on the section and every link opens page with selected resource")
//    public void sectionLinksIsPresentAndOpensProperly(@Transpose List<String> linkNames) throws Throwable {
//        sectionLinksIsPresent(linkNames);
//        SoftAssertions softAssertions = new SoftAssertions();
//        /** Where we will check presence of expected page name */
//        String placeToCheck;
//        for (String linkName : linkNames) {
//            userClicksOnSubMenuAndSeeTheRespectiveLinks(currentSection, linkName);
//            header.waitForPageToLoad();
//            header.waitForPageToLoadAndJQueryProcessing();
//            /** On "Glossary" link open non-standard PA page */
//            if (linkName.contains("Glossary")) {
//                placeToCheck = glossaryPage.glossaryHeading().getText();
//                /** On "Book" link open Global PL page */
//            } else if (linkName.contains("book")) {
//                /** IMPORTANT! linkName redefined here */
//                linkName = "Book";
//                placeToCheck = plcLegacyBooksPage.getPageHead().getText();
//                /** In all other cases regular page with selected PA section is opened */
//            } else {
//                placeToCheck = header.pageHeaderLabel().getText();
//            }
//            webDriverDiscovery.goBack();
//            softAssertions.assertThat(placeToCheck)
//                    .withFailMessage("Page '" + linkName + "' is not opened")
//                    .contains(linkName);
//            header.waitForPageToLoad();
//            userClicksOnDropdown("Browse Menu");
//        }
//        softAssertions.assertAll();
//    }

    @Given("^user navigates directly to document with guid \"(.*?)\"$")
    public void userNavigatesDirectlyToDocumentWithGuid(String guid) throws Throwable {
        navigationCobalt.navigateToWLNSpecificResourcePage("/Document/" + guid + "/View/FullText.html");
        resourcePage.waitForPageToLoadAndJQueryProcessingWithCustomTimeOut(CUSTOM_DRIVER_WAIT_TIME);
    }

    @When("^the user searches for \"(.*?)\"$")
    public void searchFor(String searchQuery) {
        searchHomePage.enterSearchText(searchQuery);
        searchHomePage.searchButton().click();
        searchHomePage.waitForPageToLoad();
        searchHomePage.waitForPageToLoadAndJQueryProcessing();
    }

    private void userClicksOnSubMenuAndSeeTheRespectiveLinks(String subMenuLink, String linkText) throws Throwable {
        currentSection = subMenuLink;
        comMethods.waitElementByLinkText(subMenuLink).click();
        comMethods.waitElementByLinkText(linkText).click();
    }

}
