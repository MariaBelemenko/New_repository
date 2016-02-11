package com.thomsonreuters.khpadd.step_definitions.glossary;

import com.thomsonreuters.khpadd.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.pages.pageCreation.HomePage;
import com.thomsonreuters.pageobjects.pages.plPlusKnowHowResources.GlossaryPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.hamcrest.CoreMatchers;
import org.hamcrest.core.Is;
import org.openqa.selenium.WebElement;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;

public class GlossaryPageTest extends BaseStepDef {

    private HomePage homePage = new HomePage();
    private GlossaryPage glossaryPage = new GlossaryPage();

    private String selectedAlphabet = null;
    private String selectedLinkText = null;

    @When("^user navigates to a glossary page$")
    public void userNavigatesToAGlossaryPage() throws Throwable {
        homePage.selectResourceTab();
        homePage.selectLinkPresentOnTab("Glossary");
        assertThat("Glossary heading is not displayed", glossaryPage.glossaryHeading().isDisplayed(), Is.is(true));
    }

    @Then("^the user is able to see the tabbed alphabetical list$")
    public void theUserIsAbleToSeeTheTabbedAlphabeticalList() throws Throwable {
        String[] expectedTabbedAlphabets = new String[]{"#", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        assertThat("Glossary heading is not displayed", glossaryPage.glossaryHeading().isDisplayed(), Is.is(true));
        assertThat(glossaryPage.alphabetListToString(), CoreMatchers.hasItems(expectedTabbedAlphabets));
    }

    @When("^the user clicks on the alphabet \"(.*?)\" in the tabbed alphabetical list$")
    public void theUserClicksOnTheAlphabetInTheTabbedAlphabeticalList(String alphabet) throws Throwable {
        glossaryPage.glossaryLetter(alphabet).click();
        selectedAlphabet = alphabet;
    }

    @Then("^the glossary list rolls up and the first term in the respective list is selected \\(except x, Y and Z\\)$")
    public void theGlossaryListRollsUpAndTheFirstTermInTheRespectiveListIsSelectedExceptXYAndZ() throws Throwable {
        selectedLinkText = glossaryPage.selectedGlossaryTermLink().getText().trim();
        boolean isTermSelected = false;
        if (glossaryPage.nextElementToAlphabetTitle(selectedAlphabet).getText().trim().equalsIgnoreCase(selectedLinkText)) {
            isTermSelected = true;
        }
        assertTrue("First term link has not been selected..!", isTermSelected);
    }

    @Then("^the corresponding definition of the selected term should be displayed on the right hand side$")
    public void theCorrespondingDefinitionOfTheSelectedTermIsDisplayedOnTheRightHandSide() throws Throwable {
        assertTrue("Selected Link Text has not been found in heading..!",
                glossaryPage.glossaryHeading().getText().contains(selectedLinkText));
    }

    @Then("^the user should be able to view the scroll up and scroll down button on the list$")
    public void theUserShouldBeAbleToViewTheScrollUpAndScrollDownButtonOnTheList() throws Throwable {
        assertTrue("Scroll up button not displayed..!", glossaryPage.scrollUpButton().isDisplayed());
        assertTrue("Scroll down button not displayed..!", glossaryPage.scrollDownButton().isDisplayed());
    }

    @Then("^clicking on the scroll up button the user should be able to roll up the list of terms$")
    public void clickingOnTheScrollUpButtonTheUserShouldBeAbleToRollUpTheListOfTerms() throws Throwable {
        for (int i = 0; i < 9; i++) {
            glossaryPage.scrollUpButton().click();
        }
    }

    @Then("^clicking on the scroll down button the user should be able to traverse down the list of terms$")
    public void clickingOntHeScrollDownButtonTheUserShouldBeAbleToTraverseDownTheListOfTerms() throws Throwable {
        for (int i = 0; i < 9; i++) {
            glossaryPage.scrollDownButton().click();
        }
    }

    @When("^the user selects another letter \"(.*?)\"$")
    public void theUserSelectsAnotherLetter(String letter2) throws Throwable {
        glossaryPage.glossaryLetter(letter2).click();
    }

    @Then("^the corresponding terms for \"(.*?)\" are displayed$")
    public void theCorrespondingTermsForAreDisplayed(String letter2) throws Throwable {
        assertTrue(glossaryPage.glossaryTermListLetter(letter2).isDisplayed());
    }

    @When("^the user selects a term e\\.g\\. \"(.*?)\" on the tabbed alphabetical list$")
    public void theUserSelectsATermEGOnTheTabbedAlphabeticalList(String linkText) throws Throwable {
        selectedLinkText = linkText;
        glossaryPage.glossaryTerm(linkText).click();
    }

    @Then("^the term should adjust itself to roll up the list as the first item$")
    public void theTermShouldAdjustItselfToRollUpTheListAsTheFirstItem() throws Throwable {
        assertTrue("Selected alphabet is different..!",
                glossaryPage.selectedGlossaryTermLink().getText().trim().equalsIgnoreCase(selectedLinkText));
    }

    @When("^the user clicks on glossary term \"(.*?)\"$")
    public void theUserClicksOnGlossaryTerm(String termLink) throws Throwable {
        glossaryPage.glossaryTerm(termLink).click();
    }

    @Then("^the user should be able to view the definition of the term \"(.*?)\" on the page$")
    public void theUserShouldBeAbleToViewTheDefinitionOfTheTermOnThePage(String arg1) throws Throwable {
        WebElement term = glossaryPage.glossaryHeading();
        assertTrue(term.getText().contains(arg1));
    }

    @When("^clicks on the (know how resource|glossary term) link \"(.*?)\" in the definition page$")
    public void clicksOnTheKnowHowResourceLinkInTheDefinitionPage(String type, String resourceLink) throws Throwable {
        glossaryPage.PracticeNoteLink(resourceLink).click();
    }

    @Then("^the user is navigated to the actual know how resource page$")
    public void theUserIsNavigatedToTheActualKnowHowResourcePage() throws Throwable {
        assertTrue("Practice note not displayed..!", glossaryPage.glossaryHeading().getText().equals("Legal Aid, Sentencing and Punishment of Offenders Act 2012"));
    }

    @Then("^the definition of the selected term should be displayed$")
    public void theDefinitionOfTheSelectedTermShouldBeDisplayed() throws Throwable {
        assertTrue("Glossary Term definition is not displayed on the modal box",
                glossaryPage.glossaryModalTermDefinition().isDisplayed());
    }

}
