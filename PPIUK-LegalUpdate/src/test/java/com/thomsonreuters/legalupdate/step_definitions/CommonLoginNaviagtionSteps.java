package com.thomsonreuters.legalupdate.step_definitions;

import com.thomsonreuters.pageobjects.common.CommonMethods;
import com.thomsonreuters.pageobjects.common.ExcelFileReader;
import com.thomsonreuters.pageobjects.common.PageActions;
import com.thomsonreuters.pageobjects.otherPages.CobaltLogin;
import com.thomsonreuters.pageobjects.otherPages.NavigationCobalt;
import com.thomsonreuters.pageobjects.pages.folders.ResearchOrganizerPage;
import com.thomsonreuters.pageobjects.pages.header.WLNHeader;
import com.thomsonreuters.pageobjects.pages.landingPage.PracticalLawHomepage;
import com.thomsonreuters.pageobjects.pages.login.OnepassLogin;
import com.thomsonreuters.pageobjects.pages.login.WelcomePage;
import com.thomsonreuters.pageobjects.pages.onePass.OnePassLogoutPage;
import com.thomsonreuters.pageobjects.pages.plPlusKnowHowResources.KHResourcePage;
import com.thomsonreuters.pageobjects.pages.plcLegacy.PLCLegacyHeader;
import com.thomsonreuters.pageobjects.pages.plcLegacy.PLCLegacyLoginScreen;
import com.thomsonreuters.pageobjects.pages.search.SearchHomePage;
import com.thomsonreuters.pageobjects.utils.*;
import com.thomsonreuters.pageobjects.utils.folders.FoldersUtils;
import cucumber.api.Transpose;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import static com.thomsonreuters.pageobjects.utils.CobaltUser.isUserFirstUser;

/**
 * Login and Navigation Steps.
 */
public class CommonLoginNaviagtionSteps extends BaseStepDef {

    public static final String ROUTING = "routing";

    private RoutingPage routingPage;
    private NavigationCobalt navigationCobalt;
    private OnepassLogin onepassLogin;
    private OnepassLoginUtils onepassLoginUtils;
    private WelcomePage welcome;
    private PracticalLawHomepage plcHomePage;
    private CobaltLogin cobaltLogin;
    private WLNHeader wlnHeader;
    private CommonMethods comMethods;
    private PageActions pageActions;
    private PLCLegacyHeader plcLegacyHeader;
    private PLCLegacyLoginScreen plcLegacyLoginScreen;
    private OnePassLogoutPage onePassLogoutPage;
    private ResearchOrganizerPage researchOrganizerPage;
    private FoldersUtils foldersUtils;
    private SearchHomePage searchHomePage;
    private KHResourcePage resourcePage;

    public CommonLoginNaviagtionSteps() {
        routingPage = new RoutingPage();
        onepassLoginUtils = new OnepassLoginUtils();
        pageActions = new PageActions();
        comMethods = new CommonMethods();
        wlnHeader = new WLNHeader();
        navigationCobalt = new NavigationCobalt();
        plcHomePage = new PracticalLawHomepage();
        onepassLogin = new OnepassLogin();
        cobaltLogin = new CobaltLogin();
        welcome = new WelcomePage();
        plcLegacyHeader = new PLCLegacyHeader();
        plcLegacyLoginScreen = new PLCLegacyLoginScreen();
        onePassLogoutPage = new OnePassLogoutPage();
        researchOrganizerPage = new ResearchOrganizerPage();
        foldersUtils = new FoldersUtils();
        searchHomePage = new SearchHomePage();
        resourcePage = new KHResourcePage();
    }

    @Given("^user is logged in to WLN$")
    public void WLNLogin() throws Throwable {
        CobaltUser user = new CobaltUser();
        user.setProduct(Product.WLN);
        loginUser(user);
    }

    @Given("^WLN user is logged in with following details$")
    public void WLNLoginWithDetails(@Transpose List<CobaltUser> plPlusUserList) throws Throwable {
        CobaltUser user = CobaltUser.updateMissingFields(plPlusUserList.get(0));
        user.setProduct(Product.WLN);
        loginUser(user);
    }

    @Given("^PLC user is logged in with following details$")
    public void PLCLegacyLoginWithDetails(@Transpose List<CobaltUser> plPlusUserList) throws Throwable {
        CobaltUser user = CobaltUser.updateMissingFields(plPlusUserList.get(0));
        user.setProduct(Product.PLC_lEGACY);
        loginUser(user);
    }

    @Given("^PL\\+ user navigates to home page$")
    public void plUserNaviagatesToHomePage() throws Throwable {
        onepassLogin.deleteAllCookies();
        navigationCobalt.navigateToPLUKPlus();
        plcHomePage.closeCookieConsentMessage();
        resetCurrentUser();
    }

    public void theUserClicksOnSignOnLinkOnTheHeader() throws Throwable {
        wlnHeader.signInLink().click();
        onepassLogin.waitForPageToLoad();
    }

    @Given("^PL\\+ ANZ user navigates to home page$")
    public void plAnzUserNaviagatesToHomePage() throws Throwable {
        getDriver().manage().deleteAllCookies();
        navigationCobalt.navigateToPLANZPlus();
        plcHomePage.closeCookieConsentMessage();
        resetCurrentUser();
    }

    @Given("^PL\\+ user navigates to login page$")
    public void plUserNavigatesToLoginPage() throws Throwable {
        onepassLogin.deleteAllCookies();
        navigationCobalt.navigateToPLUKPlus();
        plcHomePage.closeCookieConsentMessage();
        resetCurrentUser();
        if (!baseUrl.contains("prod")) {
            theUserClicksOnSignOnLinkOnTheHeader();
        } else {
            LOG.info("OpenWeb is OFF on production. User already on login page");
        }
    }

    @Given("^PL\\+ user is not logged in$")
    public void plUserIsNotLoggedIn() throws Throwable {
        if (!isUserFirstUser(currentUser)) {
            newSession(currentUser);
            navigationCobalt.navigateToPLUKPlus();
            plcHomePage.closeCookieConsentMessage();
        } else {
            LOG.info("No need to create new session. Current user: " + currentUser + " is the first user");
        }
    }

    @Given("^PL\\+ user is logged in$")
    public void plUserIsLoggedIn() throws Throwable {
        CobaltUser plPlusUser = new CobaltUser();
        plPlusUser.setUserName(!"None".equalsIgnoreCase(System.getProperty("username")) ? System.getProperty("username") : currentUser.getUserName());

        if ("false".equalsIgnoreCase(System.getProperty(ROUTING))) {
            plPlusUser.setRouting(Routing.NONE);
        } else {
            plPlusUser.setRouting(Routing.DEFAULT);
        }
        plUserIsLoggedInWithFollowingDetails(Collections.singletonList(plPlusUser));
    }

    @Given("^PL\\+ user is logged in with following details after IP login$")
    public void ipUserIsLoggedIn(@Transpose List<CobaltUser> plPlusUserList) throws Throwable {
        CobaltUser plPlusUser = CobaltUser.updateMissingFields(plPlusUserList.get(0));
        if (StringUtils.isEmpty(plPlusUser.getUserName())) {
            plPlusUser.setUserName(!"None".equalsIgnoreCase(System.getProperty("username")) ? System.getProperty("username") : ExcelFileReader.getDefaultUser());
        }
        String mandatoryRouting = plPlusUser.getMandatoryRouting();
        if ("false".equalsIgnoreCase(System.getProperty(ROUTING)) && (StringUtils.isEmpty(mandatoryRouting) || mandatoryRouting.equals("NO"))) {
            plPlusUser.setRouting(Routing.NONE);
        }
        if (plPlusUser.getLoginRequired().equals("YES")) {
            login(plPlusUser);
        }
        currentUser = plPlusUser;
    }

    @Given("^PL\\+ user is logged in with following details$")
    public void plUserIsLoggedInWithFollowingDetails(@Transpose List<CobaltUser> plPlusUserList) throws Throwable {
        CobaltUser plPlusUser = CobaltUser.updateMissingFields(plPlusUserList.get(0));
        if (StringUtils.isEmpty(plPlusUser.getUserName())) {
            plPlusUser.setUserName(!"None".equalsIgnoreCase(System.getProperty("username")) ? System.getProperty("username") : ExcelFileReader.getDefaultUser());
        }
        String mandatoryRouting = plPlusUser.getMandatoryRouting();
        if ("false".equalsIgnoreCase(System.getProperty(ROUTING)) && (StringUtils.isEmpty(mandatoryRouting) || mandatoryRouting.equals("NO"))) {
            plPlusUser.setRouting(Routing.NONE);
        }
        loginUser(CobaltUser.updateMissingFields(plPlusUserList.get(0)));
    }

    @When("^user is navigated to routing$")
    public void userNavitedToRoutingPage() {
        navigateToRoutingPage(Product.PLC);
    }


    @Given("^ANZ user is not logged in$")
    public void anzUserIsNotLoggedIn() throws Throwable {
        if (!isUserFirstUser(currentUser)) {
            newSession(currentUser);
            navigationCobalt.navigateToPLANZPlus();
            plcHomePage.closeCookieConsentMessage();
        } else {
            LOG.info("No need to create new session. Current user: " + currentUser + " is the first user");
        }
    }

    @Given("^ANZ user is logged in with following details$")
    public void anzUserIsLoggedInWithFollowingDetails(@Transpose List<CobaltUser> plPlusUserList) throws Throwable {
        for (CobaltUser user : plPlusUserList) {
            user.setProduct(Product.ANZ);
        }
        plUserIsLoggedInWithFollowingDetails(plPlusUserList);
    }


    /**
     * EDGE Case where the test has no option but to go to the routing page.
     * This may be to turn off an IAC or something
     *
     * @param plPlusUserList
     * @throws Throwable
     */
    @Given("^PL\\+ user is logged in with routing details$")
    public void plUserIsLoggedInWithRoutingDetails(@Transpose List<CobaltUser> plPlusUserList) throws Throwable {
        CobaltUser plPlusUser = CobaltUser.updateMissingFields(plPlusUserList.get(0));
        if (StringUtils.isEmpty(plPlusUser.getUserName())) {
            plPlusUser.setUserName(!"None".equalsIgnoreCase(System.getProperty("username")) ? System.getProperty("username") : ExcelFileReader.getDefaultUser());
        }
        loginUser(CobaltUser.updateMissingFields(plPlusUserList.get(0)));
    }

    @Given("^ANZ user is logged in with routing details$")
    public void anzUserIsLoggedInWithRoutingDetails(@Transpose List<CobaltUser> plPlusUserList) throws Throwable {
        for (CobaltUser user : plPlusUserList) {
            user.setProduct(Product.ANZ);
        }
        plUserIsLoggedInWithRoutingDetails(plPlusUserList);
    }

    @Given("^PL\\+ user is applying routing without login$")
    public void plUserIsApplyingRoutingWithoutLogin(@Transpose List<CobaltUser> plPlusUserList) throws Throwable {
        CobaltUser plPlusUser = CobaltUser.updateMissingFields(plPlusUserList.get(0));
        if (StringUtils.isEmpty(plPlusUser.getUserName())) {
            plPlusUser.setUserName(!"None".equalsIgnoreCase(System.getProperty("username")) ? System
                    .getProperty("username") : ExcelFileReader.getDefaultUser());
        }
        doRouting(CobaltUser.updateMissingFields(plPlusUserList.get(0)));
    }

    private void loginUser(CobaltUser plPlusUser) throws InterruptedException, IOException {
        if (currentUser != null && plPlusUser.equalTo(currentUser)) {
            navigateToHomePage(plPlusUser.getProduct());
        } else {
            if (!isUserFirstUser(currentUser)) {
                newSession(currentUser);
                if (plPlusUser.getProduct().equals(Product.PLC_lEGACY)) {
                    loginLegacySite(plPlusUser);
                }
            }
            doRouting(plPlusUser);

            if (plPlusUser.getProduct().equals(Product.PLC_lEGACY) && isUserFirstUser(currentUser)) {
                loginLegacySite(plPlusUser);
            }

            if (null == plPlusUser.getUserName()) {
                plPlusUser.setUserName(ExcelFileReader.getDefaultUser());
            }

            if (plPlusUser.getLoginRequired().equals("YES")) {
                login(plPlusUser);
            }

            if (plPlusUser.getProduct().equals(Product.WLN)) {
                try {
                    clientId(plPlusUser.getClientId());
                } catch (TimeoutException e) {
                    LOG.info("Failed to find client id");
                }
                closeWelcomeDialog();
            }
        }
        currentUser = plPlusUser;
        setAnnotationUsers();
    }

    private void loginLegacySite(CobaltUser plPlusUser) {
        onepassLogin.deleteAllCookies();
        navigateToHomePage(plPlusUser.getProduct());
        plcLegacyHeader.login();
        plcLegacyLoginScreen.onePass();
    }

    private void navigateToHomePage(Product product) {
        switch (product) {
            case WLN:
                navigationCobalt.navigateToWestlawNext();
                break;
            case PLC:
                navigationCobalt.navigateToPLUKPlus();
                break;
            case ANZ:
                navigationCobalt.navigateToPLANZPlus();
                break;
            case PLC_lEGACY:
                navigationCobalt.navigateToPLCLegacy();
                break;
            default:
                break;
        }
    }

    private void closeWelcomeDialog() {
        if (comMethods.waitForElementToBeVisible(By.xpath("//*[@id='coid_lightboxOverlay']//input[@value='Close']"), 1000) != null) {
            onepassLogin.findElement(By.id("welcomePrefCheckbox")).click();
            onepassLogin.findElement(By.xpath("//*[@id='coid_lightboxOverlay']//input[@value='Close']")).click();
        }
    }

    private String getPasswordForPlPlusUser(String userName) throws IOException, InterruptedException {
        String overriddenUserName = System.getProperty("username");
        if (overriddenUserName != null && userName.equals(overriddenUserName)) {
            return null == System.getProperty("password") ? ExcelFileReader.getCobaltPassword(userName) : System.getProperty("password");
        }
        return ExcelFileReader.getCobaltPassword(userName);
    }

    private void doRouting(CobaltUser user) throws InterruptedException {
        if (user.getProduct().equals(Product.PLC) || Product.ANZ.equals(user.getProduct())) {
            switch (user.getRouting()) {
                case DEFAULT:
                    navigateToRoutingPage(user.getProduct());
                    comMethods.waitForElementToBeVisible(By.id("CategoryPageCollectionSet"), 1000).sendKeys("w_plplus_catpagestst_cs");
                    new Select(onepassLogin.findElement(By.id("WebContentCollectionSet"))).selectByValue("w_cb_wcmstst_cs");
                    break;

                case KHSEARCH:

                case RESEARCH_DOC_DISPLAY:
                    navigateToRoutingPage(user.getProduct());
                    comMethods.waitForElementToBeVisible(By.id("CategoryPageCollectionSet"), 1000).sendKeys("w_plplus_catpagestst_cs");
                    /** VERY IMPORTANT: TODO to remove when PMD issue is fixed */
                    onepassLogin.findElement(By.id("ProductMetadataDataVersion")).sendKeys("2482");
                    new Select(onepassLogin.findElement(By.id("WebContentCollectionSet"))).selectByValue("w_cb_wcmstst_cs");
                    routingPage.showFeatureSelectionsLink().click();
                    WebElement ignore = routingPage.ignoreAuthorizationBlocksDropdown();
                    routingPage.selectDropDownByVisibleText(ignore, "Grant");
                    WebElement pre = routingPage.preReleaseContentDropdown();
                    routingPage.selectDropDownByVisibleText(pre, "Grant");
                    WebElement bypass = routingPage.wlnByPass100KAncillaryDropdown();
                    routingPage.selectDropDownByVisibleText(bypass, "Grant");
                    break;

                case BETA:
                    navigateToRoutingPage(user.getProduct());
                    routingPage.showFeatureSelectionsLink().click();
                    routingPage.selectDropDownByVisibleText(routingPage.preReleaseContentDropdown(), "Grant");
                    break;

                case RDD:
                    navigateToRoutingPage(user.getProduct());
                    routingPage.showFeatureSelectionsLink().click();
                    routingPage.selectDropDownByVisibleText(routingPage.ignoreAuthorizationBlocksDropdown(), "Grant");
                    routingPage.selectDropDownByVisibleText(routingPage.preReleaseContentDropdown(), "Grant");
                    break;

                case OPEN_WEB:
                    user.setLoginRequired("NO");
                    navigateToRoutingPage(user.getProduct());
                    routingPage.selectDropDownByVisibleText(routingPage.skipAnonymousAuthenticationDropdown(), "False");
                    routingPage.anonymousRegistrationKeyTextBox().sendKeys("1890639-SKKON3");
                    break;

                case ANZ_IAC:
                    navigateToRoutingPage(user.getProduct());
                    routingPage.infrastructureAccessControls().sendKeys("IAC-LIGER-NORT-TEST-FILTER");
                    routingPage.showFeatureSelectionsLink().click();
                    routingPage.selectDropDownByVisibleText(routingPage.ignoreAuthorizationBlocksDropdown(), "Grant");
                    routingPage.selectDropDownByVisibleText(routingPage.preReleaseContentDropdown(), "Grant");
                    routingPage.selectDropDownByVisibleText(routingPage.wlnByPass100KAncillaryDropdown(), "Grant");
                    break;

                case FAST_DRAFT_OPEN_WEB:
                    user.setLoginRequired("NO");
                    navigateToRoutingPage(user.getProduct());
                    routingPage.selectDropDownByVisibleText(routingPage.skipAnonymousAuthenticationDropdown(), "False");
                    routingPage.anonymousRegistrationKeyTextBox().sendKeys("1890639-SKKON3");
                    routingPage.fastDraftHost().clear();
                    routingPage.fastDraftHost().sendKeys("d" + System.getProperty("base.legacy.url") + "-infra.dev.practicallaw.com");
                    routingPage.showFeatureSelectionsLink().click();
                    break;

                case FAST_DRAFT_IP_USERS:
                    user.setLoginRequired("NO");
                    navigateToRoutingPage(user.getProduct());
                    routingPage.fastDraftHost().clear();
                    routingPage.fastDraftHost().sendKeys("d" + System.getProperty("base.legacy.url") + "-infra.dev.practicallaw.com");
                    routingPage.showFeatureSelectionsLink().click();
                    break;

                case FAST_DRAFT:
                    navigateToRoutingPage(user.getProduct());
                    routingPage.fastDraftHost().clear();
                    routingPage.fastDraftHost().sendKeys("d" + System.getProperty("base.legacy.url") + "-infra.dev.practicallaw.com");
                    routingPage.showFeatureSelectionsLink().click();
                    break;

                case FAST_DRAFT_INCORRECT:
                    navigateToRoutingPage(user.getProduct());
                    routingPage.fastDraftHost().clear();
                    routingPage.fastDraftHost().sendKeys("http://uc199881-tpv-z:9933/");
                    routingPage.showFeatureSelectionsLink().click();
                    break;

                case FAST_DRAFT_FIRM_STYLE:
                    navigateToRoutingPage(user.getProduct());
                    routingPage.showFeatureSelectionsLink().click();
                    routingPage.selectDropDownByVisibleText(routingPage.firmStyleDropdown(), "Grant");
                    routingPage.fastDraftHost().clear();
                    routingPage.fastDraftHost().sendKeys("d" + System.getProperty("base.legacy.url") + "-infra.dev.practicallaw.com");
                    break;

                case FIRM_STYLE:
                    navigateToRoutingPage(user.getProduct());
                    routingPage.showFeatureSelectionsLink().click();
                    routingPage.selectDropDownByVisibleText(routingPage.firmStyleDropdown(), "Grant");
                    break;

                case FIRM_STYLE_NO_FAC:
                    navigateToRoutingPage(user.getProduct());
                    routingPage.showFeatureSelectionsLink().click();
                    routingPage.selectDropDownByVisibleText(routingPage.firmStyleDropdown(), "Deny");
                    break;

                case FIRM_STYLE_IP_USERS:
                    user.setLoginRequired("NO");
                    navigateToRoutingPage(user.getProduct());
                    routingPage.showFeatureSelectionsLink().click();
                    routingPage.selectDropDownByVisibleText(routingPage.firmStyleDropdown(), "Grant");
                    break;

                case FIRM_STYLE_IP_USERS_NO_FAC:
                    user.setLoginRequired("NO");
                    navigateToRoutingPage(user.getProduct());
                    routingPage.showFeatureSelectionsLink().click();
                    routingPage.selectDropDownByVisibleText(routingPage.firmStyleDropdown(), "Deny");
                    break;

                case KH_DOC_DISPLAY:
                    navigateToRoutingPage(user.getProduct());
                    routingPage.showFeatureSelectionsLink().click();
                    WebElement ignore1 = routingPage.ignoreAuthorizationBlocksDropdown();
                    routingPage.selectDropDownByVisibleText(ignore1, "Grant");
                    break;

                case CAT_PAGES:
                    navigateToRoutingPage(user.getProduct());
                    comMethods.waitForElementToBeVisible(By.id("CategoryPageCollectionSet"), 1000).sendKeys("w_plcuk_catpagestst_cs");
                    break;

                case ASK:
                    navigateToRoutingPage(user.getProduct());
                    routingPage.infrastructureAccessTextArea().sendKeys("IAC-ASK-CONTENT");
                    if (user.getLoginRequired().equalsIgnoreCase("NO")) {
                        routingPage.selectDropDownByVisibleText(routingPage.skipAnonymousAuthenticationDropdown(), "False");
                        routingPage.anonymousRegistrationKeyTextBox().sendKeys("1890639-SKKON3");
                    }
                    routingPage.showFeatureSelectionsLink().click();
                    routingPage.selectDropDownByVisibleText(routingPage.ignoreAuthorizationBlocksDropdown(), "Grant");
                    routingPage.selectDropDownByVisibleText(routingPage.preReleaseContentDropdown(), "Grant");
                    routingPage.selectDropDownByVisibleText(routingPage.wlnByPass100KAncillaryDropdown(), "Grant");
                    routingPage.selectDropDownByVisibleText(routingPage.unreleasedCatPagesDropdown(), "Grant");
                    break;

                case ASK_EDITOR:
                    navigateToRoutingPage(user.getProduct());
                    routingPage.infrastructureAccessTextArea().sendKeys("IAC-ASK-CONTENT");
                    if (user.getLoginRequired().equalsIgnoreCase("NO")) {
                        routingPage.selectDropDownByVisibleText(routingPage.skipAnonymousAuthenticationDropdown(), "False");
                        routingPage.anonymousRegistrationKeyTextBox().sendKeys("1890639-SKKON3");
                    }
                    routingPage.showFeatureSelectionsLink().click();
                    routingPage.selectDropDownByVisibleText(routingPage.askEditorDropdown(), "Grant");
                    routingPage.selectDropDownByVisibleText(routingPage.ignoreAuthorizationBlocksDropdown(), "Grant");
                    routingPage.selectDropDownByVisibleText(routingPage.preReleaseContentDropdown(), "Grant");
                    routingPage.selectDropDownByVisibleText(routingPage.wlnByPass100KAncillaryDropdown(), "Grant");
                    routingPage.selectDropDownByVisibleText(routingPage.unreleasedCatPagesDropdown(), "Grant");
                    break;

                case ASK_DEV_WEB_COLLECTION:
                    navigateToRoutingPage(user.getProduct());
                    routingPage.infrastructureAccessTextArea().sendKeys("IAC-ASK-CONTENT");
                    routingPage.setCategoryPageCollectionSet("w_plplus_catpagestst_cs");
                    routingPage.selectDropDownByVisibleText(routingPage.webContentCollectionSetDropdown(), "DEV");
                    if (user.getLoginRequired().equalsIgnoreCase("NO")) {
                        routingPage.selectDropDownByVisibleText(routingPage.skipAnonymousAuthenticationDropdown(), "False");
                        routingPage.anonymousRegistrationKeyTextBox().sendKeys("1890639-SKKON3");
                    }
                    routingPage.showFeatureSelectionsLink().click();
                    routingPage.selectDropDownByVisibleText(routingPage.ignoreAuthorizationBlocksDropdown(), "Grant");
                    routingPage.selectDropDownByVisibleText(routingPage.preReleaseContentDropdown(), "Grant");
                    routingPage.selectDropDownByVisibleText(routingPage.wlnByPass100KAncillaryDropdown(), "Grant");
                    routingPage.selectDropDownByVisibleText(routingPage.unreleasedCatPagesDropdown(), "Grant");
                    break;

                case ASK_PROD_WEB_COLLECTION_CATEGORTY_PAGE_CSET:
                    navigateToRoutingPage(user.getProduct());
                    routingPage.infrastructureAccessTextArea().sendKeys("IAC-ASK-CONTENT");
                    routingPage.setCategoryPageCollectionSet("w_plplus_catpagestst_cs");
                    routingPage.selectDropDownByVisibleText(routingPage.webContentCollectionSetDropdown(), "PROD");
                    if (user.getLoginRequired().equalsIgnoreCase("NO")) {
                        routingPage.selectDropDownByVisibleText(routingPage.skipAnonymousAuthenticationDropdown(), "False");
                        routingPage.anonymousRegistrationKeyTextBox().sendKeys("1890639-SKKON3");
                    }
                    routingPage.showFeatureSelectionsLink().click();
                    routingPage.selectDropDownByVisibleText(routingPage.ignoreAuthorizationBlocksDropdown(), "Grant");
                    routingPage.selectDropDownByVisibleText(routingPage.preReleaseContentDropdown(), "Grant");
                    routingPage.selectDropDownByVisibleText(routingPage.wlnByPass100KAncillaryDropdown(), "Grant");
                    routingPage.selectDropDownByVisibleText(routingPage.unreleasedCatPagesDropdown(), "Grant");
                    break;

                case ASK_UNRELEASEDCATEGORY:
                    navigateToRoutingPage(user.getProduct());
                    routingPage.infrastructureAccessTextArea().sendKeys("IAC-ASK-CONTENT");
                    if (user.getLoginRequired().equalsIgnoreCase("NO")) {
                        routingPage.selectDropDownByVisibleText(routingPage.skipAnonymousAuthenticationDropdown(), "False");
                        routingPage.anonymousRegistrationKeyTextBox().sendKeys("1890639-SKKON3");
                    }
                    routingPage.showFeatureSelectionsLink().click();
                    routingPage.selectDropDownByVisibleText(routingPage.ignoreAuthorizationBlocksDropdown(), "Grant");
                    routingPage.selectDropDownByVisibleText(routingPage.preReleaseContentDropdown(), "Grant");
                    routingPage.selectDropDownByVisibleText(routingPage.wlnByPass100KAncillaryDropdown(), "Grant");
                    routingPage.selectDropDownByVisibleText(routingPage.unreleasedCatPagesDropdown(), "Grant");
                    break;

                case NONE:
                    LOG.info("No routing required.");
                    navigateToHomePage(user.getProduct());
                    if (user.getLoginRequired().equalsIgnoreCase("YES") && !user.getProduct().equals(Product.ANZ)) {
                        handleOpenWebFlow();
                    }
                    plcHomePage.closeCookieConsentMessage();
                    return;

                case OPEN_WEB_SEARCH:
                    navigateToRoutingPage(user.getProduct());
                    comMethods.waitForElementToBeVisible(By.id("CategoryPageCollectionSet"), 1000).sendKeys("w_plplus_catpagestst_cs");
                    new Select(onepassLogin.findElement(By.id("WebContentCollectionSet"))).selectByVisibleText("TEST");
                    new Select(onepassLogin.findElement(By.id("SkipAnonymousAuthenticationKey"))).selectByValue("False");
                    break;

                case DOCDISPLAY_UseCollectionSet:
                    navigateToRoutingPage(user.getProduct());
                    comMethods.waitForElementToBeVisible(By.id("CategoryPageCollectionSet"), 1000).sendKeys("w_plplus_catpagestst_cs");
                    new Select(onepassLogin.findElement(By.id("WebContentCollectionSet"))).selectByValue("w_cb_wcmstst_cs");
                    routingPage.showFeatureSelectionsLink().click();
                    WebElement ignore3 = routingPage.ignoreAuthorizationBlocksDropdown();
                    routingPage.selectDropDownByVisibleText(ignore3, "Grant");
                    WebElement pre1 = routingPage.preReleaseContentDropdown();
                    routingPage.selectDropDownByVisibleText(pre1, "Grant");
                    break;

                case SPECIFIED_USER_TIMEOUT_3_MINUTES:
                    navigateToRoutingPage(user.getProduct());
                    comMethods.waitForElementToBeVisible(By.xpath("//input[@id='Text2' and @name='SessionTimeoutOverride']"), 1000).clear();
                    comMethods.waitForElementToBeVisible(By.xpath("//input[@id='Text2' and @name='SessionTimeoutOverride']"), 1000).sendKeys("3");
                    break;

                case NON_SUBSCRIBER:
                    navigateToRoutingPage(user.getProduct());
                    routingPage.showFeatureSelectionsLink().click();
                    WebElement plc = routingPage.practicalLawDropdown();
                    routingPage.selectDropDownByVisibleText(plc, "Grant");
                    break;

                case RESEARCH_SEARCH:
                    navigateToRoutingPage(user.getProduct());
                    comMethods.waitForElementToBeVisible(By.id("CategoryPageCollectionSet"), 1000).sendKeys("w_plplus_catpagestst_cs");
                    onepassLogin.findElement(By.id("ProductMetadataDataVersion")).sendKeys("2513");
                    new Select(onepassLogin.findElement(By.id("WebContentCollectionSet"))).selectByValue("w_cb_wcmstst_cs");
                    routingPage.showFeatureSelectionsLink().click();
                    routingPage.selectDropDownByVisibleText(routingPage.ignoreAuthorizationBlocksDropdown(), "Grant");
                    routingPage.selectDropDownByVisibleText(routingPage.preReleaseContentDropdown(), "Grant");
                    routingPage.selectDropDownByVisibleText(routingPage.wlnByPass100KAncillaryDropdown(), "Grant");
                    break;

                case ASSERT_PAGE:
                    navigateToRoutingPage(user.getProduct());
                    //routingPage.setPMdDataVersion("2808");
                    routingPage.showFeatureSelectionsLink().click();
                    routingPage.selectDropDownByVisibleText(routingPage.userInternal(), "Grant");
                    routingPage.selectDropDownByVisibleText(routingPage.ignoreAuthorizationBlocksDropdown(), "Grant");
                    routingPage.selectDropDownByVisibleText(routingPage.preReleaseContentDropdown(), "Grant");
                    routingPage.selectDropDownByVisibleText(routingPage.wlnByPass100KAncillaryDropdown(), "Grant");
                    break;

                case ANNOTATIONS:
                    navigateToRoutingPage(user.getProduct());
                    //routingPage.infrastructureAccessTextArea().sendKeys("IAC-WLNDOC-SHAREDNOTES");
                    //routingPage.showFeatureSelectionsLink().click();
                    //routingPage.selectDropDownByVisibleText(routingPage.waitForExpectedElement(By.id("co_website_resourceInfoTypes_BlockShareNoteLink")),"Deny");
                    //routingPage.selectDropDownByVisibleText(routingPage.ignoreAuthorizationBlocksDropdown(), "Grant");
                    //routingPage.selectDropDownByVisibleText(routingPage.preReleaseContentDropdown(), "Grant");
                    //routingPage.selectDropDownByVisibleText(routingPage.wlnByPass100KAncillaryDropdown(), "Grant");
                    break;

                case GLOBAL_PAGE:
                    navigateToRoutingPage(user.getProduct());
                    routingPage.showFeatureSelectionsLink().click();
                    routingPage.selectDropDownByVisibleText(routingPage.unreleasedCatPagesDropdown(), "Grant");

                default:
                    throw new UnknownError("Routing Code not implemented " + user.getRouting());

                case NOWHATSMARKETACCESS:
                    navigateToRoutingPage(user.getProduct());
                    routingPage.showFeatureSelectionsLink().click();
                    routingPage.selectDropDownByVisibleText(routingPage.whatsMarketSearchResultsDropdown(), "Deny");
                    break;
            }
            routingPage.saveChangesAndSignOnButton().click();
        } else if (user.getProduct().equals(Product.WLN)) {
            if (user.getRouting().equals(Routing.WLN_ANNOTATIONS)) {
                navigateToRoutingPage(user.getProduct());
                routingPage.infrastructureAccessTextArea().clear();
                routingPage.infrastructureAccessTextArea().sendKeys("IAC-WLNDOC-SHAREDNOTES");
                routingPage.selectToggleSupportedFeatures();
                routingPage.selectSharedNotesCheckBox();
                routingPage.showFeatureSelectionsLink().click();
                routingPage.selectDropDownByVisibleText(routingPage.ignoreAuthorizationBlocksDropdown(), "Grant");
                routingPage.selectDropDownByVisibleText(routingPage.preReleaseContentDropdown(), "Grant");
                routingPage.selectDropDownByVisibleText(routingPage.wlnByPass100KAncillaryDropdown(), "Grant");
                routingPage.saveChangesAndSignOnButton().click();
            } else if (user.getRouting().equals(Routing.FOLDERS)) {

                navigateToRoutingPage(user.getProduct());
                routingPage.showFeatureSelectionsLink().click();
                routingPage.waitForPageToLoad();
                routingPage.selectDropDownByVisibleText(routingPage.ignoreAuthorizationBlocksDropdown(), "Grant");
                routingPage.selectDropDownByVisibleText(routingPage.preReleaseContentDropdown(), "Grant");
                routingPage.selectDropDownByVisibleText(routingPage.wlnByPass100KAncillaryDropdown(), "Grant");
                routingPage.saveChangesAndSignOnButton().click();
            } else {
                navigateToHomePage(user.getProduct());
            }
        }
    }

    /**
     * log user in from login page
     */
    private void login(CobaltUser user) throws InterruptedException, IOException {
        if ("SUPER_REMEMBER_ME_USER".equals(user.getRole())) {
            onepassLoginUtils.loginToCobaltWithSRM(user.getUserName(), getPasswordForPlPlusUser(user.getUserName()));
        } else {
            onepassLoginUtils.loginToCobalt(user.getUserName(), getPasswordForPlPlusUser(user.getUserName()));
        }
        plcHomePage.waitForPageToLoad();
        plcHomePage.closeCookieConsentMessage();
    }

    String baseUrl = System.getProperty("base.url");

    /**
     * Do not delete this.
     * Handles login flow for Open WEB user
     *
     * @throws InterruptedException
     */
    protected void handleOpenWebFlow() throws InterruptedException {
        /**
         * The below lines ensure that PROD is being hit thinking OW is turned OFF.
         *
         * When you are ready and you want to make PROD work when OW is on,
         * Then just remove the below lines.
         */
        switch (baseUrl) {
            case "prod":
                LOG.info("Production Site is being tested.");
                break;
            case "prodA":
                LOG.info("PROD A is being tested.");
                break;
            case "prodB":
                LOG.info("PROD B is being tested.");
                break;
            default:
                wlnHeader.signInLink().click();
                break;
        }
        /**
         * When you want to run any test against PROD with OW on then just uncomment the line below.
         */
//      wlnHeader.signInLink().click();
    }

    private void hackToTRemovePortAndNavigateToOnePassPage() throws InterruptedException {
        String currentUrl;
        int count = 10;
        do {
            Thread.sleep(1000);
            currentUrl = plcHomePage.getCurrentUrl();
            LOG.info("Current Url = " + currentUrl);
            count--;
        }
        while ((!currentUrl.contains(":9001/") && !currentUrl.contains(":9517/")) && count > 0);
        LOG.info("Current Url = " + currentUrl);
        if (System.getProperty("base.url").equalsIgnoreCase("ci")) {
            onepassLogin.navigate(currentUrl.replace(":9001/", "/"));
        }
        if (System.getProperty("base.url").equalsIgnoreCase("demo")) {
            onepassLogin.navigate(currentUrl.replace(":9517/", "/"));
        }
    }

    /**
     * Sets Client id
     *
     * @param clientId clientId
     */
    private void clientId(String clientId) {
        welcome.clientID().clear();
        welcome.clientID().sendKeys(clientId);
        welcome.clientID().sendKeys(Keys.ENTER);
        plcHomePage.waitForPageToLoad();
    }

    /**
     * Navigates to Routing Page with check, If the User session is active
     */
    private void navigateToRoutingPage(Product product) {
        switch (product) {
            case WLN:
                navigationCobalt.navigateToWLNSpecificURL("/routing");
                break;
            case PLC:
                navigationCobalt.navigateToPLCUKPlusSpecificURL("/routing");
                break;
            case ANZ:
                navigationCobalt.navigateToPLCANZSpecificURL("/routing");
                break;
            default:
                break;
        }
        try {
            WebElement element = onepassLogin.findElement(By.cssSelector(".co_website_routingActiveSessionExplanation >input"));
            element.click();
        } catch (NoSuchElementException | ElementNotVisibleException nse) {
            LOG.error("User not signed in. Routing page is displayed");
        }
    }

    /**
     * Signs Off User if user is signed in
     */
    private void signOff(CobaltUser user) {
        WebElement element = null;
        try {
            switch (user.getProduct()) {
                case WLN:
                    element = onepassLogin.findElement(By.linkText("Sign Off"));
                    break;
                case PLC:
                    boolean alreadyLoggedIn = false;
                    try {
                        wlnHeader.userAvatarIcon().isDisplayed();
                        alreadyLoggedIn = true;
                    } catch (Exception e) {
                    }
                    if (alreadyLoggedIn) {
                        element = wlnHeader.userPreferencesDropdown("Sign out");
                    }
                    break;
                case ANZ:
                    wlnHeader.expandUserAvatarDropDown();
                    element = wlnHeader.signOutLink();
                    break;
                case PLC_lEGACY:
                    navigationCobalt.navigateToPLCLegacy();
                    element = onepassLogin.findElement(By.linkText("Log out"));
                    break;
                default:
                    break;
            }
            if (element != null) {
                element.click();
            }
        } catch (NoSuchElementException | ElementNotVisibleException | TimeoutException nse) {
            LOG.error("Sign-Off link not found");
        }
    }

    private void unlockUser(CobaltUser user) {
    }

    /**
     * New session is created.
     * 1. Reset Routing
     * 2. Sign-Off
     * 3. Delete Cookies
     */
    private void newSession(CobaltUser user) throws IOException, InterruptedException {
        signOff(user);
        onepassLogin.deleteAllCookies();
        ExcelFileReader.unlockUser(currentUser.getUserName());
        LOG.info("New Session Created");
    }

    @When("^user relogs in$")
    public void userRelogsIn() throws Throwable {
        LOG.info("Current user relogs in");
        signOff(currentUser);
        onepassLogin.deleteAllCookies();
        ExcelFileReader.unlockUser(currentUser.getUserName());
        CobaltUser plPlusUser = currentUser;
        resetCurrentUser();
        loginUser(plPlusUser);
    }

    @When("^user logs in$")
    public void userLogsInWithUsername() throws Throwable {
        String userName = (!"None".equalsIgnoreCase(System.getProperty("username")) ? System.getProperty("username") : ExcelFileReader.getDefaultUser());
        onepassLogin.usernameTextField().sendKeys(userName);
        String password = getPasswordForPlPlusUser(userName);
        onepassLogin.passwordTextField().clear();
        onepassLogin.passwordTextField().sendKeys(password);
        onepassLogin.signOnButton().click();
    }

    private void setAnnotationUsers() {
        if (annotationUsers == null) {
            LOG.info("Loading Annotation users...");
            annotationUsers = new HashMap<String, User>();
            annotationUsers.put(cobaltLogin.annUserName, new User(cobaltLogin.annUserFirstName, cobaltLogin.annUserLastName));
            annotationUsers.put(cobaltLogin.annAnotherUserName, new User(cobaltLogin.annAnotherFirstName, cobaltLogin.annAnotherLastName));
            annotationUsers.put(cobaltLogin.annReadOnlyUserName, new User(cobaltLogin.annReadOnlyFirstName, cobaltLogin.annReadOnlyLastName));
            LOG.info("annotationsUsers:" + annotationUsers.size());
        }
    }

    @Then("^user logs in back again from signOff page$")
    public void userLogsInBackAgainFromSignOffPage() throws Throwable {
        onePassLogoutPage.signOffPageSignOnButton().click();
        onepassLogin.waitForPageToLoad();
        userLogsInWithUsername();
    }

    @Given("^PL\\+ user '(.*)' opens '(.*)' folder$")
    public void plUserLoginAndOpenFolder(String userName, String folderName) throws Throwable {
        List<CobaltUser> cobaltUsers = new ArrayList<>();
        cobaltUsers.add(getCobaltUserForUserName(userName));
        plUserIsLoggedInWithFollowingDetails(cobaltUsers);
        userGoesToFolderSubFolder(folderName);
    }

    private void userLoginAndOpenFolder(String userName, String folderName) throws Throwable {
        List<CobaltUser> cobaltUsers = new ArrayList<>();
        cobaltUsers.add(getCobaltUserForUserName(userName));
        plUserIsLoggedInWithFollowingDetails(cobaltUsers);
        userGoesToFolderSubFolder(folderName);
    }

    private void userGoesToFolderSubFolder(String folderName) throws Throwable {
        userClicksOnHeaderLink("Folders");
        openFolder(folderName);
    }

    private void userClicksOnHeaderLink(String linkName) throws Throwable {
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

    private String folderName;

    private void openFolder(String folderName) {
        foldersUtils.openFolder(folderName);
        this.folderName = folderName;
    }

    @Given("^PL\\+ user '(.*)' navigates directly to document with guid '(.*)'$")
    public void plUserLoginAndNavigateToDoc(String userName, String docGuid) throws Throwable {
        plUserIsLoggedInWithFollowingDetails(getCobaltUserForUserNameAsList(userName));
        navigatesDirectlyToDocumentWithGuid(docGuid);
    }

    private void navigatesDirectlyToDocumentWithGuid(String guid) throws Throwable {
        navigationCobalt.navigateToWLNSpecificResourcePage("/Document/" + guid + "/View/FullText.html");
        resourcePage.waitForPageToLoadAndJQueryProcessing();
    }

    @Given("^PL\\+ user '(.*)' searches for '(.*)'$")
    public void plUserLoginAndSearch(String userName, String term) throws Throwable {
        plUserIsLoggedInWithFollowingDetails(getCobaltUserForUserNameAsList(userName));
        searchFor(term);
    }

    private void searchFor(String searchQuery) {
        searchHomePage.enterSearchText(searchQuery);
        searchHomePage.searchButton().click();
        searchHomePage.waitForPageToLoad();
        searchHomePage.waitForPageToLoadAndJQueryProcessing();
    }

    private CobaltUser getCobaltUserForUserName(String userName) {
        CobaltUser resultUser = new CobaltUser();
        resultUser.setUserName(userName);
        resultUser = CobaltUser.updateMissingFields(resultUser);
        return resultUser;
    }

    private List<CobaltUser> getCobaltUserForUserNameAsList(String userName) {
        List<CobaltUser> cobaltUsers = new ArrayList<>();
        cobaltUsers.add(getCobaltUserForUserName(userName));
        return cobaltUsers;
    }
}