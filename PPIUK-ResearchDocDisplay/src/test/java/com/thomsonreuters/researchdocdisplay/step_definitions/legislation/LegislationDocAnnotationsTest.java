package com.thomsonreuters.researchdocdisplay.step_definitions.legislation;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebElement;

import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document.CaseDocumentPage;
import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document.LegislationDocumentPage;
import com.thomsonreuters.pageobjects.utils.plPlusResearchDocDisplay.CaseDocumentPageUtils;
import com.thomsonreuters.researchdocdisplay.step_definitions.BaseStepDef;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LegislationDocAnnotationsTest extends BaseStepDef {

    private CaseDocumentPageUtils caseDocumentPageUtils = new CaseDocumentPageUtils();
    private CaseDocumentPage caseDocumentPage = new CaseDocumentPage();
    private LegislationDocumentPage legislationDocumentPage = new LegislationDocumentPage();


    @Then("^show and hide link is displayed as part of annotations header$")
    public void showAndHideLinkIsDisplayedAsPartOfAnnotationsHeader() throws Throwable {
    	caseDocumentPage.waitForPageToLoad();
		assertTrue("Show and hide link is not displayed", caseDocumentPage.showAndHideLink().isDisplayed());
    }

    @When("^the user selects option to annotation$")
    public void theUserSelectsOptionToAnnotation() throws Throwable {
        caseDocumentPageUtils.selectOnShowAndHideLink();
    }

    @Then("^annotations will be hidden$")
    public void annotationsWillBeHidden() throws Throwable {
        assertFalse("The annotations didn't hidden",
                caseDocumentPageUtils.isAnnotationSectionIsDisplayed());
    }

    @Then("^annotations will be displayed$")
    public void annotationsWillBeDisplayed() throws Throwable {
        assertTrue("The annotations is not displayed on document",
                caseDocumentPageUtils.isAnnotationSectionIsDisplayed());
    }

	@Then("^the \"([^\"]*)\" section contains paragraphs$")
	public void theSectionContainsParagraphs(String section) throws Throwable {
		SoftAssertions softly = new SoftAssertions();
		softly.assertThat(legislationDocumentPage.paragraphsInSection(section).isEmpty())
				.overridingErrorMessage("There is no paragraph in the " + section + " section").isFalse();
		for (WebElement element : legislationDocumentPage.paragraphsInSection(section)) {
			softly.assertThat(element.isDisplayed()).overridingErrorMessage("The paragraph is not displayed").isTrue();

		}
		softly.assertAll();

	}
	
	@Then("^the \"([^\"]*)\" section contains \"([^\"]*)\"$")
	public void theSectionContains(String section, String text) throws Throwable {
		assertTrue("The " + section + " section doesn't contain " + text,
				legislationDocumentPage.textInSection(section, text).isDisplayed());
	}
}
