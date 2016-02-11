package com.thomsonreuters.khpadd.step_definitions.glossary;

import com.thomsonreuters.khpadd.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.otherPages.NavigationCobalt;
import com.thomsonreuters.pageobjects.pages.plPlusKnowHowResources.GlossaryPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GlossaryModalTest extends BaseStepDef {

    private NavigationCobalt navigation = new NavigationCobalt();
    private GlossaryPage glossaryPage = new GlossaryPage();

    @Given("^user navigates to a (.+) resource$")
    public void userNavigatesToAPracticeNoteResource(String resource) throws Throwable {
        if (resource.equals("Practice Note")) {
            navigation.navigateToWLNSpecificResourcePage("/Document/I0206eb261cb611e38578f7ccc38dcbee/View/FullText.html");
        }
    }

    @When("^user clicks on glossary term \"(.*?)\" in the resource page$")
    public void userClicksOnGlossaryTermInTheResourcePage(String glossaryTerm) throws Throwable {
        WebElement element = glossaryPage.glossaryTerm(glossaryTerm);
//        new getDriver().moveToElement(element).build().perform();
        element.click();
    }

    @Then("^the glossary modal pop up box opens with the title \"(.*?)\"$")
    public void theGlossaryModalPopUpBoxOpensWithTheDefinitionOfTheAboveTerm(String modalTitle) throws Throwable {
        assertTrue(glossaryPage.glossaryModalTitle().getText().toLowerCase().contains(modalTitle));
    }

    @When("^the user selects the \"(.*?)\" icon at the top right of the modal window$")
    public void theUserSelectsTheIconAtTheTopRightOfTheModalWindow(String arg1) throws Throwable {
        glossaryPage.glossaryModalClose().click();
    }

    @Then("^the modal closes and returns the user to the document view$")
    public void theModalClosesAndReturnsTheUserToTheDocumentView() throws Throwable {
        assertFalse(glossaryPage.isGlossaryModalTitleDisplayed());
    }

    @When("^user clicks on glossary term \"(.*?)\" inside this modal box$")
    public void userClicksOnGlossaryTermInsideThisModalBox(String glossaryTermOnModal) throws Throwable {
        glossaryPage.glossaryTermOnModalBox(glossaryTermOnModal).click();
    }

    @Then("^letter \"(.*?)\" should be selected on the alphabet tab$")
    public void letterAShouldBeSelectedOnTheAlphabetTab(String alphabet) throws Throwable {
        assertTrue("Selected alphabet is different..!",
                glossaryPage.selectedGlossaryAlphabetLink().getText().trim().equals(alphabet));
    }

    @Then("^the title \"(.*?)\" is displayed in the definition$")
    public void theTitleIsDisplayedInTheDefinition(String glossaryTitle) throws Throwable {
        assertTrue("Selected Link Text has not been found in heading..!",
                glossaryPage.glossaryHeading().getText().contains(glossaryTitle));
    }

}
