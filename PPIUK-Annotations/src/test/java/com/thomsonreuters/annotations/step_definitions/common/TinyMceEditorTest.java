package com.thomsonreuters.annotations.step_definitions.common;

import com.thomsonreuters.pageobjects.common.CommonMethods;
import com.thomsonreuters.pageobjects.pages.annotations.SharedAnnotationsPage;
import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.documentNavigation.DocumentDeliveryPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.Keys;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertTrue;

public class TinyMceEditorTest extends AnnotationsTest {

    private SharedAnnotationsPage sharedAnnotationsPage = new SharedAnnotationsPage();
    private CommonMethods commonMethods = new CommonMethods();
    private DocumentDeliveryPage deliveryPage = new DocumentDeliveryPage();

    public static String editOption = "";
    public static String mainWindow;
    public static List<String> numbersList;
    public static String input;

    @When("^clearing existing styles and annotation text$")
    public void cleanStyle() throws Throwable {
        sharedAnnotationsPage.clearAll();
    }

    @When("^selecting \"(.*?)\" and writing text$")
    public void selectingAndWritingText(String style) throws Throwable {
        input = "input" + System.currentTimeMillis();
        sharedAnnotationsPage.selectStyle(getFormatType(style));
        sharedAnnotationsPage.amendInput(input);
    }

    @Then("^text displays with \"(.*?)\" character style$")
    public void textDisplaysWithCharacterStyle(String style) throws Throwable {
        assertTrue(sharedAnnotationsPage.isAnnoatationsTextDisplayedWithCharacterStyle(getFormatType(style), input));
    }

    @When("^selecting \"(.*?)\"$")
    public void selecting(String style) throws Throwable {
        String styleChar = null;
        if (editOption.equals("keyboard")) {
            if (style.contains("copy"))
                styleChar = "c";
            else if (style.contains("paste"))
                styleChar = "v";
            else if (style.contains("cut"))
                styleChar = "x";
            sharedAnnotationsPage.amendInput(Keys.chord(Keys.CONTROL + styleChar));

        } else {
            sharedAnnotationsPage.selectStyle(getFormatType(style));
        }
    }

    @When("^highlighted text with the cursor$")
    public void highlightedTextWithTheCursor() throws Throwable {
        input = "input" + System.currentTimeMillis();
        sharedAnnotationsPage.amendInput(input);
        sharedAnnotationsPage.selectText();
    }

    @Then("^character style of highlighted text changes to \"(.*?)\"$")
    public void characterStyleOfHighlightedTextChangesTo(String style) throws Throwable {
        assertTrue(sharedAnnotationsPage.isAnnoatationsTextDisplayedWithCharacterStyle(getFormatType(style), input));
    }

    @When("^saving the annotation$")
    public void savingTheAnnotation() throws Throwable {
        sharedAnnotationsPage.saveAnnotation();
    }

    @Then("^the saved annotations text should be displayed in the (selected Link|Headers|Inline|Blocks|Alignment) \"(.*?)\" format$")
    public void theAnnotationsTextShouldBeDisplayedInTheFormat(String menu, String styleOption) throws Throwable {
        if (!menu.equals("selected Link")) {
            styleOption = menu + "_" + StringUtils.trimAllWhitespace(styleOption);
        }
        assertTrue(sharedAnnotationsPage.isSavedAnnotationDisplayedWithSelectedStyle(getFormatType(styleOption),
                SharedAnnotationsPage.ExpectedResult.VISIBLE, input));
    }

    @When("selecting (Headers|Inline|Blocks|Alignment) format \"(.*?)\"$")
    public void selectedMenuFormatStyle(String menu, String styleName) throws Throwable {
        sharedAnnotationsPage.selectStyleGroupFromFormatsMenu(menu);
        String style = menu + "_" + StringUtils.trimAllWhitespace(styleName);
        sharedAnnotationsPage.selectStyle(getFormatType(style));
    }

    @Then("^highlighted text changes to (Headers|Inline|Blocks|Alignment) format \"(.*?)\"$")
    public void hightLightedTextChangesToMenuFormat(String menu, String styleName) throws Throwable {
        String style = menu + "_" + StringUtils.trimAllWhitespace(styleName);
        assertTrue(sharedAnnotationsPage.isAnnoatationsTextDisplayedWithCharacterStyle(getFormatType(style), input));
    }

    @When("^selecting (Headers|Inline|Blocks|Alignment) format \"(.*?)\" and writing text$")
    public void selectingMenuItemAndWritingText(String styleGroupName, String menuItem) throws Throwable {
        input = "input" + System.currentTimeMillis();
        sharedAnnotationsPage.selectStyleGroupFromFormatsMenu(styleGroupName);
        String style = styleGroupName + "_" + StringUtils.trimAllWhitespace(menuItem);
        sharedAnnotationsPage.selectStyle(getFormatType(style));
        sharedAnnotationsPage.amendInput(input);
    }

    @Then("^text displays with \"(.*?)\" (Headers|Inline|Blocks|Alignment) style$")
    public void textDisplaysWithCharacterStyle(String styleName, String styleGroupName) throws Throwable {
        String style = styleGroupName + "_" + StringUtils.trimAllWhitespace(styleName);
        assertTrue(sharedAnnotationsPage.isAnnoatationsTextDisplayedWithCharacterStyle(getFormatType(style), input));
    }

    @When("^enter the sample text$")
    public void creatingANewNote() throws Throwable {
        input = "input" + System.currentTimeMillis();
        sharedAnnotationsPage.amendInput(input);
    }

    @Then("^text should be added with the \"(.*?)\" style by default$")
    public void textShouldBeAddedInTheParagraphStyleByDefault(String style) throws Throwable {
        assertTrue(sharedAnnotationsPage.isParagraphStyleAddedAsDefault(input));
    }

    @When("^selecting \"(.*?)\" from the toolbar and writing text in multiple lines$")
    public void selectingFromTheToolbarAndWritingTextInMultipleLines(String style) throws Throwable {
        sharedAnnotationsPage.selectStyle(getFormatType(style));
        numbersList = new ArrayList<String>();
        numbersList.add("input" + 1);
        numbersList.add("input" + 2);
        numbersList.add("input" + 3);
        sharedAnnotationsPage.amendInput(numbersList.get(0));
        sharedAnnotationsPage.amendInput("\n");
        sharedAnnotationsPage.amendInput(numbersList.get(1));
        sharedAnnotationsPage.amendInput("\n");
        sharedAnnotationsPage.amendInput(numbersList.get(2));
    }

    @Then("^multiple lines text displays same \"(.*?)\" format$")
    public void textInLinesWithStyle(String styleName) throws Throwable {
        assertTrue(sharedAnnotationsPage.isAnnoatationsTextDisplayedWithCharacterStyle(getFormatType(styleName),
                numbersList.get(0), numbersList.get(2), numbersList.get(2)));
    }

    @Then("^the saved annotations multiple text should be displayed in the \"(.*?)\" format$")
    public void theAnnotationsTextShouldBeDisplayedInTheFormat(String styleOption) throws Throwable {
        assertTrue(sharedAnnotationsPage.isSavedAnnotationDisplayedWithSelectedStyle(getFormatType(styleOption),
                SharedAnnotationsPage.ExpectedResult.VISIBLE, numbersList.get(0), numbersList.get(1), numbersList.get(2)));
    }

    @When("^use the \"(.*?)\" to select options$")
    public void useTheToSelectOptions(String option) throws Throwable {
        editOption = option;
    }

    @Then("^textbox will not be having that text$")
    public void textboxWillNotBeHavingThatText() throws Throwable {
        assertTrue(StringUtils.isEmpty(sharedAnnotationsPage.getText()));
    }

    @Then("^textbox will be having copied text$")
    public void textboxWillBeHavingCopiedText() throws Throwable {
        assertTrue(sharedAnnotationsPage.getText().contains(input));
    }

    @When("^empty the textbox$")
    public void emptyTheTextbox() throws Throwable {
        sharedAnnotationsPage.clearAll();
    }

    @When("^the user has inserted the url string \"(.*?)\" into textbox$")
    public void theUserAddsUrlString(String url) throws Throwable {
        sharedAnnotationsPage.amendInput("\n");
        sharedAnnotationsPage.amendInput(url);
        sharedAnnotationsPage.amendInput("\n");
    }

    @Then("^url string \"(.*?)\" become as hyperlinked text$")
    public void urlStringBecomesLink(String url) throws Throwable {
        assertTrue(sharedAnnotationsPage.isSavedAnnotationTextDisplayedAsLink(url));
    }

    @When("^click on that link text \"(.*?)\"$")
    public void clickOnThatLinkText(String url) throws Throwable {
        mainWindow = sharedAnnotationsPage.getCurrentWindowHandle();
        sharedAnnotationsPage.clickOnAnnotationLinkText(url);
    }

    @Then("^hyperlinked url will be opened in new tab with title \"(.*?)\"$")
    public void hyperlinkedUrlWillBeOpenedInNewWindow(String windowName) throws Throwable {
        commonMethods.switchDriverToAnotherWindow(windowName);
        commonMethods.close();
        commonMethods.switchToWindow(mainWindow);
    }


    @Then(("^the annotations text should be displayed in the \"(.*?)\" format$"))
    public void theAnotationTextShouldBeDisplayedInStyleFormat(String style) {
        assertTrue(sharedAnnotationsPage.isSavedAnnotationDisplayedWithSelectedStyle(getFormatType(style),
                SharedAnnotationsPage.ExpectedResult.VISIBLE, input));
    }

    @When("^user shared the annotations with another contact \"(.*?)\"$")
    public void userSharedTheAnnotationsWithAnotherContact(String contact) throws Throwable {
        sharedAnnotationsPage.clickOnContactsLink();
        sharedAnnotationsPage.searchContact(getUserFullName(contact));
        sharedAnnotationsPage.selectContact(getUserNameStartswithLastName(contact));
        sharedAnnotationsPage.selectInsertButtonOnContactsPage();
        sharedAnnotationsPage.scrollToTinyMceEditor();
        sharedAnnotationsPage.saveAnnotation();
        assertTrue("Application having page loading issue", sharedAnnotationsPage.isMetaDataDispalyed(input));
    }

    @When("^user has created the annotations with \"(.*?)\"$")
    public void userHasCreatedTheAnnotationsWith(String style) throws Throwable {
        deliveryPage.clickOnLink(DocumentDeliveryPage.Links.NEW_ANNOTATION);
        input = "input" + System.currentTimeMillis();
        sharedAnnotationsPage.amendInput(input);
        sharedAnnotationsPage.selectText();
        sharedAnnotationsPage.selectStyle(getFormatType(style));
    }
}
