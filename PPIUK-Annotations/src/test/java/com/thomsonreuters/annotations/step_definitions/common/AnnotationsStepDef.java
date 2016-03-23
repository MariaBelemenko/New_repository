package com.thomsonreuters.annotations.step_definitions.common;

import com.thomsonreuters.annotations.step_definitions.BaseStepDef;
import com.thomsonreuters.driver.exception.PageOperationException;
import com.thomsonreuters.pageobjects.common.CommonMethods;
import com.thomsonreuters.pageobjects.otherPages.NavigationCobalt;
import com.thomsonreuters.pageobjects.pages.annotations.FormatType;
import com.thomsonreuters.pageobjects.pages.annotations.InsertEditLink;
import com.thomsonreuters.pageobjects.pages.annotations.SharedAnnotationsPage;
import com.thomsonreuters.pageobjects.pages.folders.HistoryTabs;
import com.thomsonreuters.pageobjects.pages.folders.ResearchOrganizerPage;
import com.thomsonreuters.pageobjects.pages.folders.SaveToPopup;
import com.thomsonreuters.pageobjects.pages.header.WLNHeader;
import com.thomsonreuters.pageobjects.pages.landingPage.PracticalLawUKCategoryPage;
import com.thomsonreuters.pageobjects.pages.login.OnepassLogin;
import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document.StandardDocumentPage;
import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.documentNavigation.DocumentDeliveryPage;
import com.thomsonreuters.pageobjects.pages.search.KnowHowSearchResultsPage;
import com.thomsonreuters.pageobjects.pages.search.SearchResultsPage;
import com.thomsonreuters.pageobjects.utils.RoutingPage;
import com.thomsonreuters.pageobjects.utils.User;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.springframework.util.StringUtils;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;


public class AnnotationsStepDef extends BaseStepDef {

    private DocumentDeliveryPage deliveryPage;

    private CommonMethods commonMethods;

    private NavigationCobalt navigationCobalt;

    private SharedAnnotationsPage sharedAnnotationsPage;

    private InsertEditLink insertEditLink;

    private SaveToPopup saveToPopup;

    private KnowHowSearchResultsPage knowHowSearchResultsPage;

    private ResearchOrganizerPage researchOrganizerPage;
    private PracticalLawUKCategoryPage practicalLawUKCategoryPage;
    private SearchResultsPage searchResultsPage;
    private RoutingPage routingPage;
    private OnepassLogin onePassLogin;
    private WLNHeader wlnHeader;
    private StandardDocumentPage standardDocumentPage;

    public static String input;
    public static String modifiedInput;

    public static List<String> numbersList;

    private static final String ANNOTATIONS_RICH_TEXT_WARNING_MESSAGE_1 = "Yournotecannotbesavedbecauseitcontainstoomuchformatting/hiddenHTMLstyling(mostlikelyduetotextcopiedfromawebpage).Pleaseremovesomeoftheformattingandtryagain.Suggestions:";
    private static final String ANNOTATIONS_RICH_TEXT_WARNING_MESSAGE_2 = "UseCtrl+Shift+Vorrightclickandselect\"pasteasplaintext\"topastethetextcopiedfromelsewherewithoutformatting;itshouldstillbepossibletoaddformattingwithourtool.";
    private static final String ANNOTATIONS_RICH_TEXT_WARNING_MESSAGE_3 = "Copyandpasteyourtextintoaworddocumentandthenpasteitbackwithreducedformatting";
    private static final String ANNOTATIONS_TEXT_WARNING_MESSAGE = "You have exceeded the 3,000 character limit for this field. Please remove some of your text and try again.";
    private static final String richTextInput = "<h4 style=\"text-align: center;\">Sample of complex formatting</h4><p>vbnvbn<span style=\"text-decoration: underline;\"><em><strong>v</strong></em></span><h4 style=\"text-align: center;\">Sample of complex formatting</h4><p>vbnvbn<span style=\"text-decoration: underline;\"><em><strong>v</strong></em></span><h4 style=\"text-align: center;\">Sample of complex formatting</h4><p>vbnvbn<span style=\"text-decoration: underline;\"><em><strong>v</strong></em></span><h4 style=\"text-align: center;\">Sample of complex formatting</h4><p>vbnvbn<span style=\"text-decoration: underline;\"><em><strong>v</strong></em></span><h4 style=\"text-align: center;\">Sample of complex formatting</h4><p>vbnvbn<span style=\"text-decoration: underline;\"><em><strong>v</strong></em></span><h4 style=\"text-align: center;\">Sample of complex formatting</h4><p>vbnvbn<span style=\"text-decoration: underline;\"><em><strong>v</strong></em></span><h4 style=\"text-align: center;\">Sample of complex formatting</h4><p>vbnvbn<span style=\"text-decoration: underline;\"><em><strong>v</strong></em></span><h4 style=\"text-align: center;\">Sample of complex formatting</h4><p>vbnvbn<span style=\"text-decoration: underline;\"><em><strong>v</strong></em></span><h4 style=\"text-align: center;\">Sample of complex formatting</h4><p>vbnvbn<span style=\"text-decoration: underline;\"><em><strong>v</strong></em></span><h4 style=\"text-align: center;\">Sample of complex formatting</h4><p>vbnvbn<span style=\"text-decoration: underline;\"><em><strong>v</strong></em></span><h4 style=\"text-align: center;\">Sample of complex formatting</h4><p>vbnvbn<span style=\"text-decoration: underline;\"><em><strong>v</strong></em></span><h4 style=\"text-align: center;\">Sample of complex formatting</h4><p>vbnvbn<span style=\"text-decoration: underline;\"><em><strong>v</strong></em></span><h4 style=\"text-align: center;\">Sample of complex formatting</h4><p>vbnvbn<span style=\"text-decoration: underline;\"><em><strong>v</strong></em></span><h4 style=\"text-align: center;\">Sample of complex formatting</h4><p>vbnvbn<span style=\"text-decoration: underline;\"><em><strong>v</strong></em></span><h4 style=\"text-align: center;\">Sample of complex formatting</h4><p>vbnvbn<span style=\"text-decoration: underline;\"><em><strong>v</strong></em></span><h4 style=\"text-align: center;\">Sample of complex formatting</h4><p>vbnvbn<span style=\"text-decoration: underline;\"><em><strong>v</strong></em></span><h4 style=\"text-align: center;\">Sample of complex formatting</h4><p>vbnvbn<span style=\"text-decoration: underline;\"><em><strong>v</strong></em></span><h4 style=\"text-align: center;\">Sample of complex formatting</h4><p>vbnvbn<span style=\"text-decoration: underline;\"><em><strong>v</strong></em></span><h4 style=\"text-align: center;\">Sample of complex formatting</h4><p>vbnvbn<span style=\"text-decoration: underline;\"><em><strong>v</strong></em></span><h4 style=\"text-align: center;\">Sample of complex formatting</h4><p>vbnvbn<span style=\"text-decoration: underline;\"><em><strong>v</strong></em></span><h4 style=\"text-align: center;\">Sample of complex formatting</h4><p>vbnvbn<span style=\"text-decoration: underline;\"><em><strong>v</strong></em></span><h4 style=\"text-align: center;\">Sample of complex formatting</h4><p>vbnvbn<span style=\"text-decoration: underline;\"><em><strong>v</strong></em></span><h4 style=\"text-align: center;\">Sample of complex formatting</h4><p>vbnvbn<span style=\"text-decoration: underline;\"><em><strong>v</strong></em></span><h4 style=\"text-align: center;\">Sample of complex formatting</h4><p>vbnvbn<span style=\"text-decoration: underline;\"><em><strong>v</strong></em></span><h4 style=\"text-align: center;\">Sample of complex formatting</h4><p>vbnvbn<span style=\"text-decoration: underline;\"><em><strong>v</strong></em></span><h4 style=\"text-align: center;\">Sample of complex formatting</h4><p>vbnvbn<span style=\"text-decoration: underline;\"><em><strong>v</strong></em></span><h4 style=\"text-align: center;\">Sample of complex formatting</h4><p>vbnvbn<span style=\"text-decoration: underline;\"><em><strong>v</strong></em></span><h4 style=\"text-align: center;\">Sample of complex formatting</h4><p>vbnvbn<span style=\"text-decoration: underline;\"><em><strong>v</strong></em></span><h4 style=\"text-align: center;\">Sample of complex formatting</h4><p>vbnvbn<span style=\"text-decoration: underline;\"><em><strong>v</strong></em></span><h4 style=\"text-align: center;\">Sample of complex formatting</h4><p>vbnvbn<span style=\"text-decoration: underline;\"><em><strong>v</strong></em></span><h4 style=\"text-align: center;\">Sample of complex formatting</h4><p>vbnvbn<span style=\"text-decoration: underline;\"><em><strong>v</strong></em></span><h4 style=\"text-align: center;\">Sample of complex formatting</h4><p>vbnvbn<span style=\"text-decoration: underline;\"><em><strong>v</strong></em></span><h4 style=\"text-align: center;\">Sample of complex formatting</h4><p>vbnvbn<span style=\"text-decoration: underline;\"><em><strong>v</strong></em></span><h4 style=\"text-align: center;\">Sample of complex formatting</h4><p>vbnvbn<span style=\"text-decoration: underline;\"><em><strong>v</strong></em></span><h4 style=\"text-align: center;\">Sample of complex formatting</h4><p>vbnvbn<span style=\"text-decoration: underline;\"><em><strong>v</strong></em></span><h4 style=\"text-align: center;\">Sample of complex formatting</h4><p>vbnvbn<span style=\"text-decoration: underline;\"><em><strong>v</strong></em></span><h4 style=\"text-align: center;\">Sample of complex formatting</h4><p>vbnvbn<span style=\"text-decoration: underline;\"><em><strong>v</strong></em></span><h4 style=\"text-align: center;\">Sample of complex formatting</h4><p>vbnvbn<span style=\"text-decoration: underline;\"><em><strong>v</strong></em></span><h4 style=\"text-align: center;\">Sample of complex formatting</h4><p>vbnvbn<span style=\"text-decoration: underline;\"><em><strong>v</strong></em></span><h4 style=\"text-align: center;\">Sample of complex formatting</h4><p>vbnvbn<span style=\"text-decoration: underline;\"><em><strong>v</strong></em></span><h4 style=\"text-align: center;\">Sample of complex formatting</h4><p>vbnvbn<span style=\"text-decoration: underline;\"><em><strong>v</strong></em></span><h4 style=\"text-align: center;\">Sample of complex formatting</h4><p>vbnvbn<span style=\"text-decoration: underline;\"><em><strong>v</strong></em></span><h4 style=\"text-align: center;\">Sample of complex formatting</h4><p>vbnvbn<span style=\"text-decoration: underline;\"><em><strong>v</strong></em></span><h4 style=\"text-align: center;\">Sample of complex formatting</h4><p>vbnvbn<span style=\"text-decoration: underline;\"><em><strong>v</strong></em></span><h4 style=\"text-align: center;\">Sample of complex formatting</h4><p>vbnvbn<span style=\"text-decoration: underline;\"><em><strong>v</strong></em></span><h4 style=\"text-align: center;\">Sample of complex formatting</h4><p>vbnvbn<span style=\"text-decoration: underline;\"><em><strong>v</strong></em></span><h4 style=\"text-align: center;\">Sample of complex formatting</h4><p>vbnvbn<span style=\"text-decoration: underline;\"><em><strong>v</strong></em></span><h4 style=\"text-align: center;\">Sample of complex formatting</h4><p>vbnvbn<span style=\"text-decoration: underline;\"><em><strong>v</strong></em></span><h4 style=\"text-align: center;\">Sample of complex formatting</h4><p>vbnvbn<span style=\"text-decoration: underline;\"><em><strong>v</strong></em></span><h4 style=\"text-align: center;\">Sample of complex formatting</h4><p>vbnvbn<span style=\"text-decoration: underline;\"><em><strong>v</strong></em></span><h4 style=\"text-align: center;\">Sample of complex formatting</h4><p>vbnvbn<span style=\"text-decoration: underline;\"><em><strong>v</strong></em></span><h4 style=\"text-align: center;\">Sample of complex formatting</h4><p>vbnvbn<span style=\"text-decoration: underline;\"><em><strong>v</strong></em></span><h4 style=\"text-align: center;\">Sample of complex formatting</h4><p>vbnvbn<span style=\"text-decoration: underline;\"><em><strong>v</strong></em></span><h4 style=\"text-align: center;\">Sample of complex formatting</h4><p>vbnvbn<span style=\"text-decoration: underline;\"><em><strong>v</strong></em></span><h4 style=\"text-align: center;\">Sample of complex formatting</h4><p>vbnvbn<span style=\"text-decoration: underline;\"><em><strong>v</strong></em></span><h4 style=\"text-align: center;\">Sample of complex formatting</h4><p>vbnvbn<span style=\"text-decoration: underline;\"><em><strong>v</strong></em></span><h4 style=\"text-align: center;\">Sample of complex formatting</h4><p>vbnvbn<span style=\"text-decoration: underline;\"><em><strong>v</strong></em></span><h4 style=\"text-align: center;\">Sample of complex formatting</h4><p>vbnvbn<span style=\"text-decoration: underline;\"><em><strong>v</strong></em></span><h4 style=\"text-align: center;\">Sample of complex formatting</h4><p>vbnvbn<span style=\"text-decoration: underline;\"><em><strong>v</strong></em></span><h4 style=\"text-align: center;\">Sample of complex formatting</h4><p>vbnvbn<span style=\"text-decoration: underline;\"><em><strong>v</strong></em></span><h4 style=\"text-align: center;\">Sample of complex formatting</h4><p>vbnvbn<span style=\"text-decoration: underline;\"><em><strong>v</strong></em></span><h4 style=\"text-align: center;\">Sample of complex formatting</h4><p>vbnvbn<span style=\"text-decoration: underline;\"><em><strong>v</strong></em></span><h4 style=\"text-align: center;\">Sample of complex formatting</h4><p>vbnvbn<span style=\"text-decoration: underline;\"><em><strong>v</strong></em></span><h4 style=\"text-align: center;\">Sample of complex formatting</h4><p>vbnvbn<span style=\"text-decoration: underline;\"><em><strong>v</strong></em></span><h4 style=\"text-align: center;\">Sample of complex formatting</h4><p>vbnvbn<span style=\"text-decoration: underline;\"><em><strong>v</strong></em></span><h4 style=\"text-align: center;\">Sample of complex formatting</h4><p>vbnvbn<span style=\"text-decoration: underline;\"><em><strong>v</strong></em></span><h4 style=\"text-align: center;\">Sample of complex formatting</h4><p>vbnvbn<span style=\"text-decoration: underline;\"><em><strong>v</strong></em></span><h4 style=\"text-align: center;\">Sample of complex formatting</h4><p>vbnvbn<span style=\"text-decoration: underline;\"><em><strong>v</strong></em></span><h4 style=\"text-align: center;\">Sample of complex formatting</h4><p>vbnvbn<span style=\"text-decoration: underline;\"><em><strong>v</strong></em></span><h4 style=\"text-align: center;\">Sample of complex formatting</h4><p>vbnvbn<span style=\"text-decoration: underline;\"><em><strong>v</strong></em></span>";
    private static final String exactLengthRichText= "<h4 style=\"text-align: center;\">Sample of complex formatting</h4><p>vbnvbn<span style=\"text-decoration: underline;\"><em><strong>v</strong></em></span><h4 style=\"text-align: center;\">Sample of complex formatting</h4><p>vbnvbn<span style=\"text-decoration: underline;\"><em><strong>v</strong></em></span><h4 style=\"text-align: center;\">Sample of complex formatting</h4><p>vbnvbn<span style=\"text-decoration: underline;\"><em><strong>v</strong></em></span><h4 style=\"text-align: center;\">Sample of complex formatting</h4><p>vbnvbn<span style=\"text-decoration: underline;\"><em><strong>v</strong></em></span><h4 style=\"text-align: center;\">Sample of complex formatting</h4><p>vbnvbn<span style=\"text-decoration: underline;\"><em><strong>v</strong></em></span><h4 style=\"text-align: center;\">Sample of complex formatting</h4><p>vbnvbn<span style=\"text-decoration: underline;\"><em><strong>v</strong></em></span><h4 style=\"text-align: center;\">Sample of complex formatting</h4><p>vbnvbn<span style=\"text-decoration: underline;\"><em><strong>v</strong></em></span><h4 style=\"text-align: center;\">Sample of complex formatting</h4><p>vbnvbn<span style=\"text-decoration: underline;\"><em><strong>v</strong></em></span><h4 style=\"text-align: center;\">Sample of complex formatting</h4><p>vbnvbn<span style=\"text-decoration: underline;\"><em><strong>v</strong></em></span><h4 style=\"text-align: center;\">Sample of complex formatting</h4><p>vbnvbn<span style=\"text-decoration: underline;\"><em><strong>v</strong></em></span><h4 style=\"text-align: center;\">Sample of complex formatting</h4><p>vbnvbn<span style=\"text-decoration: underline;\"><em><strong>v</strong></em></span><h4 style=\"text-align: center;\">Sample of complex formatting</h4><p>vbnvbn<span style=\"text-decoration: underline;\"><em><strong>v</strong></em></span><h4 style=\"text-align: center;\">Sample of complex formatting</h4><p>vbnvbn<span style=\"text-decoration: underline;\"><em><strong>v</strong></em></span><h4 style=\"text-align: center;\">Sample of complex formatting</h4><p>vbnvbn<span style=\"text-decoration: underline;\"><em><strong>v</strong></em></span><h4 style=\"text-align: center;\">Sample of complex formatting</h4><p>vbnvbn<span style=\"text-decoration: underline;\"><em><strong>v</strong></em></span><h4 style=\"text-align: center;\">Sample of complex formatting</h4><p>vbnvbn<span style=\"text-decoration: underline;\"><em><strong>v</strong></em></span><h4 style=\"text-align: center;\">Sample of complex formatting</h4><p>vbnvbn<span style=\"text-decoration: underline;\"><em><strong>v</strong></em></span><h4 style=\"text-align: center;\">Sample of complex formatting</h4><p>vbnvbn<span style=\"text-decoration: underline;\"><em><strong>v</strong></em></span><h4 style=\"text-align: center;\">Sample of complex formatting</h4><p>vbnvbn<span style=\"text-decoration: underline;\"><em><strong>v</strong></em></span><h4 style=\"text-align: center;\">Sample of complex formatting</h4><p>vbnvbn<span style=\"text-decoration: underline;\"><em><strong>v</strong></em></span><h4 style=\"text-align: center;\">Sample of complex formatting</h4><p>vbnvbn<span style=\"text-decoration: underline;\"><em><strong>v</strong></em></span><h4 style=\"text-align: center;\">Sample of complex formatting</h4><p>vbnvbn<span style=\"text-decoration: underline;\"><em><strong>v</strong></em></span><h4 style=\"text-align: center;\">Sample of complex formatting</h4><p>vbnvbn<span style=\"text-decoration: underline;\"><em><strong>v</strong></em></span><h4 style=\"text-align: center;\">Sample of complex formatting</h4><p>vbnvbn<span style=\"text-decoration: underline;\"><em><strong>v</strong></em></span><h4 style=\"text-align: center;\">Sample of complex formatting</h4><p>vbnvbn<span style=\"text-decoration: underline;\"><em><strong>v</strong></em></span><h4 style=\"text-align: center;\">Sample of complex formatting</h4><p>vbnvbn<span style=\"text-decoration: underline;\"><em><strong>v</strong></em></span><h4 style=\"text-align: center;\">Sample of complex formatting</h4><p>vbnvbn<span style=\"text-decoration: underline;\"><em><strong>v</strong></em></span><h4 style=\"text-align: center;\">Sample of complex formatting</h4><p>vbnvbn<span style=\"text-decoration: underline;\"><em><strong>v</strong></em></span><h4 style=\"text-align: center;\">Sample of complex formatting</h4><p>vbnvbn<span style=\"text-decoration: underline;\"><em><strong>v</strong></em></span><h4 style=\"text-align: center;\">Sample of complex formatting</h4><p>vbnvbn<span style=\"text-decoration: underline;\"><em><strong>v</strong></em></span><h4 style=\"text-align: center;\">Sample of complex formatting</h4><p>vbnvbn<span style=\"text-decoration: underline;\"><em><strong>v</strong></em></span><h4 style=\"text-align: center;\">Sample of complex formatting</h4><p>vbnvbn<span style=\"text-decoration: underline;\"><em><strong>v</strong></em></span><h4 style=\"text-align: center;\">Sample of complex formatting</h4><p>vbnvbn<span style=\"text-decoration: underline;\"><em><strong>v</strong></em></span><h4 style=\"text-align: center;\">Sample of complex formatting</h4><p>vbnvbn<span style=\"text-decoration: underline;\"><em><strong>v</strong></em></span><h4 style=\"text-align: center;\">Sample of complex formatting</h4><p>vbnvbn<span style=\"text-decoration: underline;\"><em><strong>v</strong></em></span><h4 style=\"text-align: center;\">Sample of complex formatting</h4><p>vbnvbn<span style=\"text-decoration: underline;\"><em><strong>v</strong></em></span><h4 style=\"text-align: center;\">Sample of complex formatting</h4><p>vbnvbn<span style=\"text-decoration: underline;\"><em><strong>v</strong></em></span><h4 style=\"text-align: center;\">Sample of complex formatting</h4><p>vbnvbn<span style=\"text-decoration: underline;\"><em><strong>v</strong></em></span><h4 style=\"text-align: center;\">Sample of complex formatting</h4><p>vbnvbn<span style=\"text-decoration: underline;\"><em><strong>v</strong></em></span><h4 style=\"text-align: center;\">Sample of complex formatting</h4><p>vbnvbn<span style=\"text-decoration: underline;\"><em><strong>v</strong></em></span><h4 style=\"text-align: center;\">Sample of complex formatting</h4><p>vbnvbn<span style=\"text-decoration: underline;\"><em><strong>v</strong></em></span><h4 style=\"text-align: center;\">Sample of complex formatting</h4><p>vbnvbn<span style=\"text-decoration: underline;\"><em><strong>v</strong></em></span><h4 style=\"text-align: center;\">Sample of complex formatting</h4><p>vbnvbn<span style=\"text-decoration: underline;\"><em><strong>v</strong></em></span><h4 style=\"text-align: center;\">Sample of complex formatting</h4><p>vbnvbn<span style=\"text-decoration: underline;\"><em><strong>v</strong></em></span><h4 style=\"text-align: center;\">Sample of complex formatting</h4><p>vbnvbn<span style=\"text-decoration: underline;\"><em><strong>v</strong></em></span><h4 style=\"text-align: center;\">Sample of complex formatting</h4><p>vbnvbn<span style=\"text-decoration: underline;\"><em><strong>v</strong></em></span><h4 style=\"text-align: center;\">Sample of complex formatting</h4><p>vbnvbn<span style=\"text-decoration: underline;\"><em><strong>v</strong></em></span><h4 style=\"text-align: center;\">Sample of complex formatting</h4><p>vbnvbn<span style=\"text-decoration: underline;\"><em><strong>v</strong></em></span><h4 style=\"text-align: center;\">Sample of complex formatting</h4><p>vbnvbn<span style=\"text-decoration: underline;\"><em><strong>v</strong></em></span><h4 style=\"text-align: center;\">Sample of complex formatting</h4><p>vbnvbn<span style=\"text-decoration: underline;\"><em><strong>v</strong></em></span><h4 style=\"text-align: center;\">Sample of complex formatting</h4><p>vbnvbn<span style=\"text-decoration: underline;\"><em><strong>v</strong></em></span><h4 style=\"text-align: center;\">Sample of complex formatting</h4><p>vbnvbn<span style=\"text-decoration: underline;\"><em><strong>v</strong></em></span><h4 style=\"text-align: center;\">Sample of complex formatting</h4><p>vbnvbn<span style=\"text-decoration: underline;\"><em><strong>v</strong></em></span><h4 style=\"text-align: center;\">Sample of complex formatting</h4><p>vbnvbn<span style=\"text-decoration: underline;\"><em><strong>v</strong></em></span><h4 style=\"text-align: center;\">Sample of complex formatting</h4><p>vbnvbn<span style=\"text-decoration: underline;\"><em><strong>v</strong></em></span><h4 style=\"text-align: center;\">Sample of complex formatting</h4><p>vbnvbn<span style=\"text-decoration: underline;\"><em><strong>v</strong></em></span><h4 style=\"text-align: center;\">Sample of complex formatting</h4><p>vbnvbn<span style=\"text-decoration: underline;\"><em><strong>v</strong></em></span><h4 style=\"text-align: center;\">Sample of complex formatting</h4><p>vbnvbn<span style=\"text-decoration: underline;\"><em><strong>v</strong></em></span><h4 style=\"text-align: center;\">Sample of complex formatting</h4><p>vbnvbn<span style=\"text-decoration: underline;\"><em><strong>v</strong></em></span><h4 style=\"text-align: center;\">Sample of complex formatting</h4><p>vbnvbn<span style=\"text-decoration: underline;\"><em><strong>v</strong></em></span><h4 style=\"text-align: center;\">Sample of complex formatting</h4><p>vbnvbn<span style=\"text-decoration: underline;\"><em><strong>v</strong></em></span><h4 style=\"text-align: center;\">Sample of complex formatting</h4><p>vbnvbn<span style=\"text-decoration: underline;\"><em><strong>v</strong></em></span><h4 style=\"text-align: center;\">Sample of complex formatting</h4><p>vbnvbn<span style=\"text-decoration: underline;\"><em><strong>v</strong></em></span><h4 style=\"text-align: center;\">Sample of complex formatting</h4>";

    public AnnotationsStepDef(){
        deliveryPage = new DocumentDeliveryPage();
        commonMethods = new CommonMethods();
        navigationCobalt = new NavigationCobalt();
        sharedAnnotationsPage = new SharedAnnotationsPage();
        insertEditLink = new InsertEditLink();
        knowHowSearchResultsPage = new KnowHowSearchResultsPage();
        researchOrganizerPage = new ResearchOrganizerPage();
        routingPage = new RoutingPage();
        saveToPopup = new SaveToPopup();
        onePassLogin = new OnepassLogin();
        wlnHeader = new WLNHeader();
        practicalLawUKCategoryPage = new PracticalLawUKCategoryPage();
        searchResultsPage = new SearchResultsPage();
        standardDocumentPage = new StandardDocumentPage();
    }

    @When("^the user has accessed annotations text box$")
    public void theUserHasAccessedAnnotationsTextBox() throws Throwable {
        deliveryPage.clickOnLink(DocumentDeliveryPage.Links.NEW_ANNOTATION);
        editOption = "toolbar";
    }

    @When("^clearing existing styles and annotation text$")
    public void cleanStyle() {
        sharedAnnotationsPage.clearAll();
    }

    @When("^selecting \"(.*?)\" and writing text$")
    public void selectingAndWritingText(String style) throws Throwable {
        input = "input" + System.currentTimeMillis();
        sharedAnnotationsPage.selectStyle(getFormatType(style));
        sharedAnnotationsPage.amendInput(input);
    }

    @When("^selecting (Headers|Inline|Blocks|Alignment) format \"(.*?)\" and writing text$")
    public void selectingMenuItemAndWritingText(String styleGroupName, String menuItem) throws Throwable {
        input = "input" + System.currentTimeMillis();
        sharedAnnotationsPage.selectStyleGroupFromFormatsMenu(styleGroupName);
        String style = styleGroupName + "_" + StringUtils.trimAllWhitespace(menuItem);
        sharedAnnotationsPage.selectStyle(getFormatType(style));
        sharedAnnotationsPage.amendInput(input);
    }

    @When("selecting (Headers|Inline|Blocks|Alignment) format \"(.*?)\"$")
    public void selectedMenuFormatStyle(String menu, String styleName) {
        sharedAnnotationsPage.selectStyleGroupFromFormatsMenu(menu);
        String style = menu + "_" + StringUtils.trimAllWhitespace(styleName);
        sharedAnnotationsPage.selectStyle(getFormatType(style));
    }

    @Then("^highlighted text changes to (Headers|Inline|Blocks|Alignment) format \"(.*?)\"$")
    public void hightLightedTextChangesToMenuFormat(String menu, String styleName) {
        String style = menu + "_" + StringUtils.trimAllWhitespace(styleName);
        assertTrue(sharedAnnotationsPage.isAnnoatationsTextDisplayedWithCharacterStyle(getFormatType(style), input));
    }

    @Then("^text displays with \"(.*?)\" character style$")
    public void textDisplaysWithCharacterStyle(String style) throws Throwable {
        assertTrue(sharedAnnotationsPage.isAnnoatationsTextDisplayedWithCharacterStyle(getFormatType(style), input));
    }


    @Then("^text displays with \"(.*?)\" (Headers|Inline|Blocks|Alignment) style$")
    public void textDisplaysWithCharacterStyle(String styleName, String styleGroupName) throws Throwable {
        String style = styleGroupName + "_" + StringUtils.trimAllWhitespace(styleName);
        assertTrue(sharedAnnotationsPage.isAnnoatationsTextDisplayedWithCharacterStyle(getFormatType(style), input));
    }


    @Then("^multiple lines text displays same \"(.*?)\" format$")
    public void textInLinesWithStyle(String styleName) throws Throwable {
        assertTrue(sharedAnnotationsPage.isAnnoatationsTextDisplayedWithCharacterStyle(getFormatType(styleName), numbersList.get(0), numbersList.get(2), numbersList.get(2)));
    }

    @Then("^text displays with (Headers|Inline|Blocks|Alignment) \"(.*?)\" style$")
    public void textDisplaysWithMenuStyle(String styleGroupName, String menuItem) throws Throwable {
        String style = styleGroupName + "_" + StringUtils.trimAllWhitespace(menuItem);
        assertTrue(sharedAnnotationsPage.isAnnoatationsTextDisplayedWithCharacterStyle(getFormatType(style), input));
    }

    @When("^highlighted text with the cursor$")
    public void highlightedTextWithTheCursor() throws Throwable {
        input = "input" + System.currentTimeMillis();
        sharedAnnotationsPage.amendInput(input);
        sharedAnnotationsPage.selectText();
    }

    @When("^highlighted text$")
    public void highlightedText() throws Throwable {
        sharedAnnotationsPage.selectText();
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

    @Then("^verify the UNDO and REDO is disabled$")
    public void verifyTheUndoAndRedoIsDisabled() {
        assertFalse(sharedAnnotationsPage.isLinkOptionEnabled(FormatType.UNDO));
        assertFalse(sharedAnnotationsPage.isLinkOptionEnabled(FormatType.REDO));
    }

    @Then("^entered text will be removed$")
    public void verifyEntedTextIsRemoved() {
        assertFalse(sharedAnnotationsPage.isAnnoatationsTextDisplayedWithCharacterStyle(FormatType.BLOCKS_PARAGRAPH, input));
    }

    @Then("^removed text will be displayed$")
    public void verifyRemovedTextIsDisplayed() {
        assertTrue(sharedAnnotationsPage.isAnnoatationsTextDisplayedWithCharacterStyle(FormatType.BLOCKS_PARAGRAPH, input));
    }

    @Then("^character style of highlighted text changes to \"(.*?)\"$")
    public void characterStyleOfHighlightedTextChangesTo(String style) throws Throwable {
        assertTrue(sharedAnnotationsPage.isAnnoatationsTextDisplayedWithCharacterStyle(getFormatType(style), input));
    }

    @When("^the user verifies the annotations link is present$")
    public void theUserVerifiesTheAnnotationsLinkIsPresent() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^user click on Annotations$")
    public void userClickOnAnnotations() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^annotations textbox will be displayed with tinymce editor$")
    public void annotationsTextboxWillBeDisplayedWithTinymceEditor() throws Throwable {
        assertTrue(sharedAnnotationsPage.isTextBoxDisplayed());
    }

    @When("^enter the sample text$")
    public void creatingANewNote() throws Throwable {
        input = "input" + System.currentTimeMillis();
        sharedAnnotationsPage.amendInput(input);
    }

    @Then("^verify the \"(.*?)\" is enabled$")
    public void verifyTheOptionEnabled(String style) {
        assertTrue(sharedAnnotationsPage.isLinkOptionEnabled(getFormatType(style)));
    }

    @Then("^verify the \"(.*?)\" is disabled$")
    public void verifyTheOptionDisabled(String style) {
        assertFalse(sharedAnnotationsPage.isLinkOptionEnabled(getFormatType(style)));
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

    @When("^the user has accessed annotations text box in multiple lines$")
    public void theUserHasAccessedAnnotationsTextBoxInMultipleLines() throws Throwable {
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

    public static String editOption;

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

    @When("^selecting the Insert/Edit link on the toolbar$")
    public void selectingTheInsertEditLinkOnTheToolbar() throws Throwable {
        sharedAnnotationsPage.selectStyle(FormatType.INSERT_EDIT_LINK);
    }

    @Then("^a pop up box will display to enter a URL$")
    public void aPopUpBoxWillDisplayToEnterAURL() throws Throwable {
        assertTrue(insertEditLink.isPopUpDisplayed());
    }

    @Then("^text is already populated with the selected text$")
    public void enteredTextIsPopulated() throws Throwable {
        assertTrue(insertEditLink.isTextDisplayed(input));
    }

    @Then("^Title and Target fields are should not be displayed$")
    public void titleAndTargetFieldsShouldNotBeDisplayed() throws Throwable {
        assertFalse(insertEditLink.isTitleFieldDisplayed());
        assertFalse(insertEditLink.isTargetFieldDisplayed());
    }

    @Then("Text,URL fields and buttons displayed")
    public void textURLButtonsDisplayed() {
        assertTrue(insertEditLink.isTextFieldDisplayed());
        assertTrue(insertEditLink.isUrlFieldDisplayed());
        assertTrue(insertEditLink.isOKButtonDisplayed());
        assertTrue(insertEditLink.isCancelButtonDisplayed());

    }

    @When("^the user (adds|cancels) the url \"(.*?)\"$")
    public void theUserAddsOrCancelsTheUrlAmending(String action, String url) {
        insertEditLink.enterUrl(url);
        if (action.equals("adds")) {
            insertEditLink.clickOK();
        } else if (action.equals("cancels")) {
            insertEditLink.clickCancel();
        }
    }

    @When("^the user has inserted the url string \"(.*?)\" into textbox$")
    public void theUserAddsUrlString(String url) {
        sharedAnnotationsPage.amendInput("\n");
        sharedAnnotationsPage.amendInput(url);
        sharedAnnotationsPage.amendInput("\n");
    }


    @When("^the user can insert the text|URL and save it$")
    public void theUserCanInsertTheURLAndSaveIt() throws Throwable {
        input = "input" + System.currentTimeMillis();
        sharedAnnotationsPage.amendInput(input);
        sharedAnnotationsPage.saveAnnotation();
    }

    @When("^user navigates to annotations textbox with text$")
    public void theUserCanInsertText() throws Throwable {
        deliveryPage.clickOnLink(DocumentDeliveryPage.Links.NEW_ANNOTATION);
        input = "input" + System.currentTimeMillis();
        sharedAnnotationsPage.insertInput(input);
    }

    @When("^user navigates to WLN annotations textbox with text$")
    public void theUserCanInsertTextIntoWLNAnnotationTextBox() throws Throwable {
        deliveryPage.clickOnLink(DocumentDeliveryPage.Links.NEW_ANNOTATION);
        input = "input" + System.currentTimeMillis();
        sharedAnnotationsPage.insertInputInWLNAnnotationTextBox(input);
    }

    @When("^saving the annotation$")
    public void savingTheAnnotation() throws Throwable {
        sharedAnnotationsPage.saveAnnotation();
    }

    @Then("^that url hyperlinked to the selected text\\.$")
    public void thatUrlHyperlinkedToTheSelectedText() throws Throwable {
        assertTrue(sharedAnnotationsPage.isSavedAnnotationTextDisplayedAsLink(input));
    }

    public static String mainWindow;

    @When("^click on that link text$")
    public void clickOnLinkText() throws Throwable {
        mainWindow = sharedAnnotationsPage.getCurrentWindowHandle();
        sharedAnnotationsPage.clickOnAnnotationLinkText(input);
    }

    @When("^click on that link text \"(.*?)\"$")
    public void clickOnThatLinkText(String url) throws Throwable {
        mainWindow = sharedAnnotationsPage.getCurrentWindowHandle();
        sharedAnnotationsPage.clickOnAnnotationLinkText(url);
    }

    @When("^click on shared url link$")
    public void clickOnURL() throws Throwable {
        mainWindow = sharedAnnotationsPage.getCurrentWindowHandle();
        sharedAnnotationsPage.clickOnURLLink(input);
    }

    @Then("^url string \"(.*?)\" become as hyperlinked text$")
    public void urlStringBecomesLink(String url) throws Throwable {
        assertTrue(sharedAnnotationsPage.isSavedAnnotationTextDisplayedAsLink(url));
    }

    @Then("^hyperlinked url will be opened in new tab with title \"(.*?)\"$")
    public void hyperlinkedUrlWillBeOpenedInNewWindow(String windowName) throws Throwable {
        commonMethods.switchDriverToAnotherWindow(windowName);
        commonMethods.close();
        commonMethods.switchToWindow(mainWindow);
    }

    @Then("^verify No link is added to annotation$")
    public void verifyNoLinkIsAddedToAnnotation() {
        sharedAnnotationsPage.saveAnnotation();
        assertFalse(sharedAnnotationsPage.isSavedAnnotationTextDisplayedAsLink(input));
    }

    @When("^clicking on the \"(.*?)\" button from the toolbar$")
    public void clickingOnTheButtonFromTheToolbar(String style) throws Throwable {
        sharedAnnotationsPage.selectStyle(getFormatType(style));
    }

    @Then("^text doesn't render as a hyperlink$")
    public void textDoesnTRenderAsAHyperlink() throws Throwable {
        assertFalse(sharedAnnotationsPage.isSavedAnnotationTextDisplayedAsLink(input));
    }

    @Then("^the saved annotations text should be displayed in the (selected Link|Headers|Inline|Blocks|Alignment) \"(.*?)\" format$")
    public void theAnnotationsTextShouldBeDisplayedInTheFormat(String menu, String styleOption) throws Throwable {
        if (!menu.equals("selected Link")) {
            styleOption = menu + "_" + StringUtils.trimAllWhitespace(styleOption);
        }
        assertTrue(sharedAnnotationsPage.isSavedAnnotationDisplayedWithSelectedStyle(getFormatType(styleOption), SharedAnnotationsPage.ExpectedResult.VISIBLE, input));
    }

    @Then("^shared annotation should be displayed$")
    public void sharedAnnotaitonIsDisplayedToViewer() throws Throwable {
        assertTrue(sharedAnnotationsPage.isSavedAnnotationDisplayed(input, SharedAnnotationsPage.ExpectedResult.VISIBLE));
    }

    @Then("^shared annotation should be displayed with \"(.*?)\"$")
    public void sharedAnnotaitonIsDisplayedToViewer(String linkName) throws Throwable {
        assertTrue(sharedAnnotationsPage.isSavedAnnotationDisplayed(linkName, SharedAnnotationsPage.ExpectedResult.VISIBLE));
    }

    @Then("^shared annotation text will be displayed as link$")
    public void sharedAnnotaitonIsDisplayedToViewerAsLink() throws Throwable {
        assertTrue(sharedAnnotationsPage.isSavedAnnotationTextDisplayedAsLink(input));
    }

    @Then("^annotation text with url is displayed$")
    public void sharedAnnotaitonTextWithUrlIsDisplayed() throws Throwable {
        assertTrue(sharedAnnotationsPage.isSavedAnnotationDisplayed(input, SharedAnnotationsPage.ExpectedResult.VISIBLE));
        assertTrue(sharedAnnotationsPage.isSavedAnnotationTextDisplayedWithLink(input));
    }

    @Then("^the saved annotations multiple text should be displayed in the \"(.*?)\" format$")
    public void theAnnotationsTextShouldBeDisplayedInTheFormat(String styleOption) throws Throwable {
        assertTrue(sharedAnnotationsPage.isSavedAnnotationDisplayedWithSelectedStyle(getFormatType(styleOption), SharedAnnotationsPage.ExpectedResult.VISIBLE, numbersList.get(0), numbersList.get(1), numbersList.get(2)));
    }

    @Then("^verify the share with Contacts and Previous Contacts link is present$")
    public void verifyTheShareWithContactsAndGroupsLinkIsPresent() throws Throwable {
        assertTrue("Contacts Link is not displayed", sharedAnnotationsPage.isContactsLinkDisplayed());
        assertTrue("Previously Shared Link is not displayed", sharedAnnotationsPage.isPreviousContactsLinkDisplayed());
    }

    @Then("^verify that below options is present in BlockShareNoteLink dropdown$")
     public void verifyThatBelowOptionsIsPresentInBlockShareNoteLinkDropDown(List<String> expectedOptions){
        assertTrue("BLOCK SHARE NOTE LINK dropdown values are changed in routing page", expectedOptions.containsAll(routingPage.getFACDropdownOptionValues("BlockShareNoteLink")));
    }

    @Then("^verify that \"(.*?)\" dropdown is present routing Feature$")
    public void verifyThatBlockShareNoteLinkDropDown(String facName){
        assertTrue("BLOCK SHARE NOTE LINK FAC is not available", routingPage.isBlockShareNoteLinkPresent());
    }

    @Then("^verify the share with Contacts and Previous Contacts link is not present$")
    public void verifyTheShareWithContactsAndGroupsLinkIsNotPresent() throws Throwable {
        assertFalse("Contacts Link is displayed", sharedAnnotationsPage.isContactsLinkDisplayed());
        assertFalse("Previously Shared Link is displayed", sharedAnnotationsPage.isPreviousContactsLinkDisplayed());
    }

    @When("^selecting Contacts link$")
    public void selectingContactsAndGroupsLink() throws Throwable {
        sharedAnnotationsPage.clickOnContactsLink();
    }

    @Then("^contacts and Groups popup window will be displayed$")
    public void contactsAndGroupsPopupWindowWillBeDisplayed() throws Throwable {
        assertTrue(sharedAnnotationsPage.isContactsGroupsPageDisplayed());
    }

    @When("^search for Contact \"(.*?)\"$")
    public void searchForContact(String contact) throws Throwable {
        sharedAnnotationsPage.searchContact(getUserFullName(contact));
    }

    @Then("^\"(.*?)\" is found in the contacts list$")
    public void isFoundInTheContactsList(String contact) throws Throwable {
        assertTrue(sharedAnnotationsPage.isContactFoundInSearch(getUserNameStartswithLastName(contact)));
    }

    @When("^selecting the add Group option$")
    public void selectingTheAddGroupOption() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^add \"(.*?)\" as group member$")
    public void addAsGroupMember(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^save group name as \"(.*?)\"$")
    public void saveGroupNameAs(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^\"(.*?)\" is saved with \"(.*?)\" as a group memeber$")
    public void isSavedWithAsAGroupMemeber(String arg1, String arg2) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^user has created the annotations with \"(.*?)\"$")
    public void userHasCreatedTheAnnotationsWith(String style) throws Throwable {
        deliveryPage.clickOnLink(DocumentDeliveryPage.Links.NEW_ANNOTATION);
        input = "input" + System.currentTimeMillis();
        sharedAnnotationsPage.selectStyle(getFormatType(style));
        sharedAnnotationsPage.amendInput(input);
    }

    @Then("^annotations saved with the \"(.*?)\"$")
    public void annotationsSavedWithThe(String style) throws Throwable {
        assertTrue(sharedAnnotationsPage.isAnnoatationsTextDisplayedWithCharacterStyle(getFormatType(style), input));
    }

    @Then(("^the annotations text should be displayed in the \"(.*?)\" format$"))
    public void theAnotationTextShouldBeDisplayedInStyleFormat(String style) {
        assertTrue(sharedAnnotationsPage.isSavedAnnotationDisplayedWithSelectedStyle(getFormatType(style), SharedAnnotationsPage.ExpectedResult.VISIBLE, input));
    }

    @When("^user has shared the annotations with another contact \"(.*?)\"$")
    public void userHasSharedTheAnnotationsWithAnotherContact(String contact) throws Throwable {
        sharedAnnotationsPage.clickOnContactsLink();
        sharedAnnotationsPage.searchContact(getUserFullName(contact));
        sharedAnnotationsPage.selectContact(getUserNameStartswithLastName(contact));
        sharedAnnotationsPage.selectInsertButtonOnContactsPage();
        sharedAnnotationsPage.scrollToTinyMceEditor();
        sharedAnnotationsPage.saveAnnotation();
        assertTrue("Application having page loading issue", sharedAnnotationsPage.isMetaDataDispalyed(input));
    }

    public static final String groupName = "annotationsTestGroup";

    @When("^user has shared the annotations with new group and \"(.*?)\" as member$")
    public void userHasSharedTheAnnotationsWithAnotherGroup(String contact) throws Throwable {
        sharedAnnotationsPage.clickOnContactsLink();
        sharedAnnotationsPage.searchGroup(groupName);
        if (!sharedAnnotationsPage.isGroupFoundInSearch(groupName)) {
            sharedAnnotationsPage.addGroup(groupName, getUserNameStartswithLastName(contact));
        }
        sharedAnnotationsPage.selectGroup(groupName);
        sharedAnnotationsPage.selectInsertButtonOnContactsPage();
        sharedAnnotationsPage.saveAnnotation();
    }

    @When("^\"(.*?)\" clicks the link$")
    public void clicksTheLink(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^link will be direct the \"(.*?)\" user to the hyperlinked URL by opening a new window/tab$")
    public void linkWillBeDirectTheUserToTheHyperlinkedURLByOpeningANewWindowTab(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^\"(.*?)\" navigates to the same document with guid \"(.*?)\"$")
    public void navigatesToTheSameDocumentWithGuid(String arg1, String arg2) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^verify new annotations link is clickable$")
    public void verifyAddAnnotationsLinkIsClickable() throws Throwable {
        assertTrue(deliveryPage.isLinkClickable(DocumentDeliveryPage.Links.NEW_ANNOTATION));
    }

    @When("^the user is able to see new annotations link is present$")
    public void theUserIsAbleToSeeNewAnnotationsLinkIsPresent() throws Throwable {
        assertTrue(deliveryPage.isLinkPresent(DocumentDeliveryPage.Links.NEW_ANNOTATION));
    }

    @When("^the user moves the mouse over on add annotations link$")
    public void theUserMovesTheMouseOverOnAddAnnotationsLink() throws Throwable {
        deliveryPage.mouseOverOnLink(DocumentDeliveryPage.Links.NEW_ANNOTATION);
    }

    @Then("^New annotation tooltip should be displayed$")
    public void addAnnotationTooltipShouldBeDisplayed() throws Throwable {
        assertTrue(deliveryPage.isToolTipDisplayed(DocumentDeliveryPage.Links.NEW_ANNOTATION));
    }

    @When("^user click on new Annotations link$")
    public void userClickOnNewAnnotationsLink() throws Throwable {
        deliveryPage.clickOnLink(DocumentDeliveryPage.Links.NEW_ANNOTATION);
    }

    @When("^user cancels new annotation$")
    public void userCancelsNewAnnotation() throws Throwable {
        sharedAnnotationsPage.cancelSavingAnnotation();
    }

    @Then("^verify saved annotations text will be displayed with metadata$")
    public void verifySavedAnnotationsTextWillBeDisplyedWithMetadata() throws Throwable {
        assertTrue(sharedAnnotationsPage.isSavedAnnotationDisplayed(input, SharedAnnotationsPage.ExpectedResult.VISIBLE));
        assertTrue(sharedAnnotationsPage.isMetaDataDispalyed(input));
    }

    @Then("^verify saved annotations text is displayed$")
    public void verifySavedAnnotationsTextWillBeDisplyed() throws Throwable {
        assertTrue(sharedAnnotationsPage.isSavedAnnotationDisplayed(input, SharedAnnotationsPage.ExpectedResult.VISIBLE));
    }

    @Then("^verify saved annotations text will be displayed with metadata in WLN$")
    public void verifySavedAnnotationsTextWillBeDisplyedWithMetadataWLN() throws Throwable {
        assertTrue(sharedAnnotationsPage.isSavedAnnotationDisplayedInWLN(input));
    }

    @And("^the Client ID next to the timestamp will not be displayed$")
    public void noCliedId() {
        assertTrue(sharedAnnotationsPage.verifyClientIDNotDisplayed(input));
    }

    @When("^user clicks the saved annotation$")
    public void userClicksTheSavedAnnotation() throws Throwable {
        sharedAnnotationsPage.selectEditMode(input);
    }

    @Then("^annotations text box will be displayed with existing text$")
    public void annotationsTextBoxWillBeDisplayedWithExistingText() throws Throwable {
        assertTrue(sharedAnnotationsPage.isEditModeDisplayedWithText(input));
    }

    @When("^user modifies the text$")
    public void userModifiesTheText() throws Throwable {
        modifiedInput = "modified" + System.currentTimeMillis();
        sharedAnnotationsPage.insertInput(modifiedInput);
    }

    @Then("^modified annotations text will be displayed with metadata$")
    public void verifyTheModifiedTextIsDisplayed() throws Throwable {
        assertTrue(sharedAnnotationsPage.isSavedAnnotationDisplayed(modifiedInput, SharedAnnotationsPage.ExpectedResult.VISIBLE));
        assertFalse(sharedAnnotationsPage.isSavedAnnotationDisplayed(input, SharedAnnotationsPage.ExpectedResult.NOT_VISIBLE));
        assertTrue(sharedAnnotationsPage.isMetaDataDispalyed(modifiedInput));
    }

    @Then("^annotations text box will be displayed with delete icon$")
    public void annotationsTextBoxWillBeDisplayedWithDeleteIcon() throws Throwable {
        assertTrue("Bug #808769- Delete Icon is hiding by tinymce editor.", sharedAnnotationsPage.isDeleteIconDisplayedOnAnnotation(input));
    }

    @When("^user deletes the annotations$")
    public void userDeletesTheAnnotations() throws Throwable {
        sharedAnnotationsPage.deleteAnnotation(input);
    }

    @Then("^\"(.*?)\" text will be displayed with undo and close links$")
    public void withUndoAndCloseLinks(String message) throws Throwable {
        assertTrue(sharedAnnotationsPage.isDeleteNotesDisplayed(message));
        assertTrue(sharedAnnotationsPage.isUndoButtonDisplayed());
        assertTrue(sharedAnnotationsPage.isCloseButtonDisplayed());
    }

    @Then("^user unable to find the deleted annotations$")
    public void userUnableToFindTheDeletedAnnotations() throws Throwable {
        assertFalse(sharedAnnotationsPage.isSavedAnnotationDisplayed(input, SharedAnnotationsPage.ExpectedResult.NOT_VISIBLE));
    }

    @When("^user clicks the undo link$")
    public void userClicksTheUndoLink() throws Throwable {
        sharedAnnotationsPage.undoDelete();
    }

    @When("^user able to see the deleted annotations are displayed$")
    public void userAbleToSeeTheDeletedAnnotationsAreDisplayed() throws Throwable {
        assertTrue(sharedAnnotationsPage.isSavedAnnotationDisplayed(input, SharedAnnotationsPage.ExpectedResult.VISIBLE));
    }

    @When("^user clicks the close link$")
    public void userClicksTheCloseLink() throws Throwable {
        sharedAnnotationsPage.closeDeleteMessage();
    }

    @Then("^annotations close and undo links will be disappeared$")
    public void annotationsCloseAndUndoLinksWillBeDisappeared() throws Throwable {
        assertFalse(sharedAnnotationsPage.isCloseButtonDisplayed());
        assertFalse(sharedAnnotationsPage.isUndoButtonDisplayed());
    }

    @When("user added new annotation")
    public void userAddedNewAnnotation() {
        deliveryPage.clickOnLink(DocumentDeliveryPage.Links.NEW_ANNOTATION);
        input = "input" + System.currentTimeMillis();
        sharedAnnotationsPage.amendInput(input);
        sharedAnnotationsPage.saveAnnotation();

    }

    @When("user enters annotation text with \"(.*?)\" chars length")
    public void userAddedNewAnnotationWithLength(String length) {
        deliveryPage.clickOnLink(DocumentDeliveryPage.Links.NEW_ANNOTATION);
        if (!length.equals("empty")) {
            input = commonMethods.getRandomStringWithGivenLength(Integer.parseInt(length));
            sharedAnnotationsPage.amendInput(input);
        }
    }

    @Then("^user verifies Save button is (enabled|disabled)$")
    public void userVerifiesSaveButtonIsDisabled(String status) {
        if (status.equals("enabled")) {
            assertTrue(sharedAnnotationsPage.isSaveAnnotationEnabled());
        } else if (status.equals("disabled")) {
            assertFalse(sharedAnnotationsPage.isSaveAnnotationEnabled());
        }
    }

    @When("user added WLN new annotation")
    public void userAddedNewAnnotationInWLN() {
        deliveryPage.clickOnLink(DocumentDeliveryPage.Links.NEW_ANNOTATION);
        input = "input" + System.currentTimeMillis();
        sharedAnnotationsPage.insertInputInWLNAnnotationTextBox(input);
        sharedAnnotationsPage.saveAnnotation();

    }

    @Then("^verify that user sharing icon is displayed before the createdby$")
    public void userSharingIcons() {
        assertTrue(sharedAnnotationsPage.isSharingIconVisible(input));
    }

    @Then("^user should not be able to see the annotations created in (PLC|WLN) site$")
    public void userShouldNotBeAbleToSeeAnnotation(String site) {
        boolean status = true;

        if (site.equals("WLN"))
            status = sharedAnnotationsPage.isSavedAnnotationDisplayed(input, SharedAnnotationsPage.ExpectedResult.NOT_VISIBLE);
        else if (site.equals("PLC"))
            status = sharedAnnotationsPage.isSavedAnnotationDisplayedInWLN(input);

        assertFalse("Annotations are displaying which are created in " + site, status);
    }

    @When("^user navigates directly to WLN document with guid \"(.*?)\"$")
    public void userNavigatesDirectlyToDocumentWithGuid(String guid) throws Throwable {
        navigationCobalt.navigateToWLNSpecificURL("/Document/" + guid + "/View/FullText.html");
        navigationCobalt.waitForPageToLoadAndJQueryProcessing();
    }

    @Given("^user navigates directly to document with guid \"(.*?)\"$")
    public void userNavigatesToDocumentWithGuid(String guid) throws Throwable {
        navigationCobalt.navigateToWLNSpecificResourcePage("/Document/" + guid + "/View/FullText.html");
        navigationCobalt.waitForPageToLoadAndJQueryProcessing();
    }

    @When("^user navigates directly to document with guid and removes annotations on it$")
    public void userNavigatesDirectlyToDocumentWithGuid(List<String> guids) throws Throwable {
        for (String guid : guids) {
            navigationCobalt.navigateToWLNSpecificResourcePage("/Document/" + guid + "/View/FullText.html");
            //navigationCobalt.waitForPageToLoad();
            sharedAnnotationsPage.deleteAllAnnotations(getUserFullName(currentUser.getUserName()));
        }
    }

    @When("^user selects the text \"(.*?)\"$")
    public void userSelectTheGivenText(String text) {
        sharedAnnotationsPage.selectTextPresentInParaUsingDoubleClick(text);
    }

    @When("^user selects an add note color link$")
    public void userSelectsAnAddNoteColorLink() throws Throwable {
        sharedAnnotationsPage.selectInlineNotesYellowColor();
    }

    public String getUserFullName(String contact) {
        User user = annotationUsers.get(contact);
        if (StringUtils.isEmpty(user)) {
            throw new PageOperationException("Usernames are not matching between usernameAndPassword properties and plPlusUser username value.");
        }
        return user.getFullName();
    }

    public String getUserNameStartswithLastName(String contact) {
        User user = annotationUsers.get(contact);
        if (StringUtils.isEmpty(user)) {
            throw new PageOperationException("Usernames are not matching between usernameAndPassword properties and plPlusUser username value.");
        }
        return user.getLastName() + ", " + user.getFirstName();
    }

    private FormatType getFormatType(String style) {
        return FormatType.valueOf(style.toUpperCase().trim());
    }

    @When("^adds current document to \"(.*?)\" folder$")
    public void addToFolder(String folderName) {
        deliveryPage.clickOnAddToFolderLink();
        saveToFolder(folderName);
        deliveryPage.waitForPageToLoad();
    }

    @Then("^the \"(.*?)\" document will be displayed along with nodes added link$")
    public void notesIconOnList(String index) {
        assertTrue(researchOrganizerPage.isNotesIconPresentForDocument(index));
    }

    @Then("^the search result \"(.*?)\" document will be displayed along with nodes added link$")
    public void listNotesIconPresentOrNot(String index){
        assertTrue(knowHowSearchResultsPage.isNotesAddedLinkPresent(index));
    }

    @Then("^user should be able to see the warning message for exceeded (text|richText)$")
    public void userShouldSeeTheWarningMessage(String messageType){
        if(messageType.equals("richText")){
            String actualMessage = StringUtils.trimAllWhitespace(sharedAnnotationsPage.getWarningMessage(SharedAnnotationsPage.MessageType.RICH_TEXT));
            assertTrue(actualMessage.contains(ANNOTATIONS_RICH_TEXT_WARNING_MESSAGE_1) && actualMessage.contains(ANNOTATIONS_RICH_TEXT_WARNING_MESSAGE_2) && actualMessage.contains(ANNOTATIONS_RICH_TEXT_WARNING_MESSAGE_3));
        }else if(messageType.equals("text")){
            assertTrue(sharedAnnotationsPage.getWarningMessage(SharedAnnotationsPage.MessageType.TEXT).contains(ANNOTATIONS_TEXT_WARNING_MESSAGE));
        }
    }

    @Then("^select ok button on warning message$")
    public void userSelectsOkayButton(){
        sharedAnnotationsPage.selectOKButtonOnWarningMessage();
    }

    @When("^user removes the excess input from the annotations (text|richText)$")
    public void userRemovesTheExcessInputFromTheAnnotationsText(String contentType) {
        if (contentType.equals("text")){
            sharedAnnotationsPage.insertContent(input.substring(0, input.length() - 2));
        }else if(contentType.equals("richText")){
            sharedAnnotationsPage.insertContent(exactLengthRichText);
        }
    }

    @When("^user enters annotation with richText$")
    public void userEntersRichTextWith10000Length(){
        deliveryPage.clickOnLink(DocumentDeliveryPage.Links.NEW_ANNOTATION);
        sharedAnnotationsPage.insertContent(richTextInput);
    }

    @When("^the user is able to see show/hide annotations link is present$")
    public void theUserIsAbleToSeeShowHideAnnotationsLinkIsPresent() throws Throwable {
       assertTrue(deliveryPage.isLinkPresent(DocumentDeliveryPage.Links.SHOW_HIDE_ANNOTATIONS));
    }

    @Then("^verify show/hide annotations link is clickable$")
    public void verifyShowHideAnnotationsLinkIsClickable() throws Throwable {
        assertTrue(deliveryPage.isLinkClickable(DocumentDeliveryPage.Links.SHOW_HIDE_ANNOTATIONS));
    }

    @When("^the user hovers the Show And Hide link$")
    public void theUserHoversTheShowAndHideLink() throws Throwable {
        deliveryPage.mouseOverOnLink(DocumentDeliveryPage.Links.SHOW_HIDE_ANNOTATIONS);
    }

    @Then("^verify show and hide tooltip appears$")
    public void verifyThatTooltipAppears() throws Throwable {
        assertTrue(deliveryPage.isToolTipDisplayed(DocumentDeliveryPage.Links.SHOW_HIDE_ANNOTATIONS));
    }

    @When("^user selects show/hide to hide annotations$")
    public void theUserSelectsToHideAnnotations() throws Throwable {
        deliveryPage.mouseOverOnLink(DocumentDeliveryPage.Links.SHOW_HIDE_ANNOTATIONS);
        if(deliveryPage.getTootlTipText().contains("Hide"))
        deliveryPage.clickOnLink(DocumentDeliveryPage.Links.SHOW_HIDE_ANNOTATIONS);
    }

    @When("^the user clicks on Show And Hide link$")
    public void theUserClicksOnShowAndHideLink() throws Throwable {
       deliveryPage.clickOnLink(DocumentDeliveryPage.Links.SHOW_HIDE_ANNOTATIONS);
    }

    @Then("^verify that different Show and Hide icon displayed$")
    public void verifyThatDifferentShowAndHideLinkDisplayed() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^Hidden annotations are displayed$")
    public void hiddenAnnotationsAreDisplayed() throws Throwable {
        assertTrue(sharedAnnotationsPage.isAnnotationsDisplayed());
    }

    @Then("^Displayed annotations are hidden$")
    public void displayedAnnotationsAreHidden() throws Throwable {
        assertFalse(sharedAnnotationsPage.isAnnotationsDisplayed());
    }

    @When("^user deletes All annotations$")
    public void userDeletesAllAnnotations(){
        sharedAnnotationsPage.deleteAllAnnotations(getUserFullName(currentUser.getUserName()));
        sharedAnnotationsPage.deleteInlineAnnotations();
    }

    private static int annotationsCount;
    @When("^the user verifies the annotations count under link$")
    public void theUserVerifiesTheAnnotationsCountUnderLink() throws Throwable {
        assertTrue(sharedAnnotationsPage.isAnnotationsCountDisplayed());
        annotationsCount = sharedAnnotationsPage.getNotesCountFromShowAndHideIcon();
    }

    @Then("^Annotations count should match with annotations present on document\\.$")
    public void annotationsCountShouldMatchWithAnnotationsPresentOnDocument() throws Throwable {
        assertTrue(annotationsCount == sharedAnnotationsPage.getTotalNotesOnDocument());
    }

    @Then("^Annotations count should be displayed as zero$")
    public void annotationsCountShouldBeDisplayedAsZero() throws Throwable {
        sharedAnnotationsPage.deleteAllAnnotations(getUserFullName(currentUser.getUserName()));
        sharedAnnotationsPage.deleteInlineAnnotations();
        assertTrue(0 == sharedAnnotationsPage.getTotalNotesOnDocument());
    }

    public String saveToFolder(String folder) {
        String folderName = null;
        saveToPopup.waitForPageToLoad();
        saveToPopup.waitForPageToLoadAndJQueryProcessing();
        if (folder.equals("root")) {
            saveToPopup.selectRootFolder().click();
            folderName = saveToPopup.selectRootFolder().getText();
        } else {
            saveToPopup.waitForPageToLoadAndJQueryProcessing();
            try {
                saveToPopup.expandRootFolderWait().click();
                saveToPopup.selectFolderWait(folder).click();
            } catch (NoSuchElementException e) {
                throw new RuntimeException("Folder '" + folder + "'doesn't present");
            }
        }
        saveToPopup.save().click();
        return folderName;
    }

    @Then("^user logs out$")
    public void userLogsOut() throws Throwable {
        wlnHeader.signOff();
        //onePassLogin.waitForPageToLoad();
    }

    @When("^the user clicks on '(.+)' link on the header$")
    public void theUserClicksOnLinkOnTheHeader(String linkName) throws Throwable {
        researchOrganizerPage.waitForPageToLoad();
        switch (linkName) {
            case "Folders":
                wlnHeader.foldersLink().click();
                break;
            case "History":
                wlnHeader.historyLink().click();
                break;
            case "Favourites":
                wlnHeader.favouritesLink().click();
                break;
            default:
        }
        researchOrganizerPage.waitForPageToLoad();
        researchOrganizerPage.waitForPageToLoadAndJQueryProcessing();
    }

    @When("^the user clicks on '(.+)' tab on the History page$")
    public void theUserClicksOnTabOnHistoryPage(String tabName) throws Throwable {
        HistoryTabs tab = HistoryTabs.valueOf(tabName);
        openHistoryTab(tab);
    }

    @When("^the user runs a free text search for the query \"(.*)\"$")
    public void theUserRunsAFreeTextSearchForTheQuery(String query) throws Throwable {

        //paste string into the system clipboard instead
        StringSelection stringSelection = new StringSelection(query);
        Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();

        // Ensure the search button has rendered
        practicalLawUKCategoryPage.searchButton().isDisplayed();

        practicalLawUKCategoryPage.freeTextField().clear();
        //sendKeys isn't always working
        //practicalLawUKCategoryPage.freeTextField().sendKeys(query);

        //Paste the clipboard text if the query contains brackets or ampersand
        if (query.contains("(") || query.contains(")") || query.contains("&")) {
            clpbrd.setContents(stringSelection, null);
            practicalLawUKCategoryPage.freeTextField().sendKeys(Keys.CONTROL + "v");
        } else {
            practicalLawUKCategoryPage.freeTextField().sendKeys(query);
        }

//        if (practicalLawUKCategoryPage.getDriver().getClass().equals(ChromeDriver.class)) {
//            pageActions.keyPress(Keys.ENTER);
//        } else {
            practicalLawUKCategoryPage.searchButton().click();
        //}

        // Wait for the results list to display
        theUserVerifiesThatTheResultsListPageIsDisplayed();

    }
    protected void openHistoryTab(HistoryTabs tab) {
        researchOrganizerPage.waitForPageToLoad();
        researchOrganizerPage.waitForPageToLoadAndJQueryProcessing();
        WebElement historyTabNonClicked = researchOrganizerPage.findElement(tab.getId());
        WebElement historyTabClicked = researchOrganizerPage.findElement(tab.getIdClickable());
        if (historyTabNonClicked.isDisplayed()) {
            historyTabNonClicked.click();
            researchOrganizerPage.waitForPageToLoadAndJQueryProcessing();
        }
        if (historyTabClicked.isDisplayed()) {
            researchOrganizerPage.waitForElementPresent(tab.getPageHeader());
        } else {
            throw new RuntimeException("History tab '" + tab.getName() + "' absent!");
        }
    }

    @When("^the user verifies that the results list page is displayed$")
    public void theUserVerifiesThatTheResultsListPageIsDisplayed() throws Throwable {

        // A robot to allow a pause for the page to refresh
        Robot robot = new Robot();

        // Wait 5 seconds
        robot.delay(5000);

        try {
            searchResultsPage.resultsListHeader().isDisplayed();
            searchResultsPage.filterHeader().isDisplayed();
        } catch (Exception e) {
        }

    }

    @When("^the user opens '(.+)' link in the search result and store its title and guid$")
    public void openSearchResultLinkAtPositionAndStore(String linkPosition) throws Throwable {
        searchResultsPage.searchResultPosition(linkPosition).click();
        try {
            searchResultsPage.waitForPageToLoad();
            searchResultsPage.waitForPageToLoadAndJQueryProcessing();
        } catch (Exception e) {
            LOG.info("The document failed to load");
        }
    }
//
//    private void openSearchResultLinkAtPositionAndStoreItsTitleAndGuid(String linkPosition) throws Throwable {
//        searchResultsPage.waitForPageToLoad();
//        Document singleDocument = new Document();
//        searchResultsPage.searchResultPosition(linkPosition).click();
//        try {
//            searchResultsPage.waitForPageToLoad();
//            searchResultsPage.waitForPageToLoadAndJQueryProcessing();
//        } catch (Exception e) {
//            LOG.info("The document failed to load");
//        }
//        //Wait for this document appears in History. If it is to quickly the document could be missing
//        Thread.sleep(5000);
//        singleDocument.setTitle(standardDocumentPage.documentTitle().getText());
//        singleDocument.setGuid(getDocumentGUID());
//    }
//
//    private String getDocumentGUID() {
//        return standardDocumentPage.documentMetaInfo().getAttribute("id").split("_")[3];
//    }
}