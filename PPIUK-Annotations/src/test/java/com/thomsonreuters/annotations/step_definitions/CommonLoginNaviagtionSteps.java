package com.thomsonreuters.annotations.step_definitions;

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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static final Logger LOG = LoggerFactory.getLogger(CommonLoginNaviagtionSteps.class);

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
        LOG.info("The user has logged in to WLN");
    }

    @Given("^WLN user is logged in with following details$")
    public void WLNLoginWithDetails(@Transpose List<CobaltUser> plPlusUserList) throws Throwable {
        CobaltUser user = CobaltUser.updateMissingFields(plPlusUserList.get(0));
        user.setProduct(Product.WLN);
        loginUser(user);
        LOG.info("The WLN user is logged in with the following details");
    }

    @Given("^PLC user is logged in with following details$")
    public void PLCLegacyLoginWithDetails(@Transpose List<CobaltUser> plPlusUserList) throws Throwable {
        CobaltUser user = CobaltUser.updateMissingFields(plPlusUserList.get(0));
        user.setProduct(Product.PLC_lEGACY);
        loginUser(user);
        LOG.info("The PLC user is logged in with the following details");
    }

    @Given("^PL\\+ user navigates to home page$")
    public void plUserNaviagatesToHomePage() throws Throwable {
        onepassLogin.deleteAllCookies();
        navigationCobalt.navigateToPLUKPlus();
        plcHomePage.closeCookieConsentMessage();
        resetCurrentUser();
        LOG.info("The PL+ user has navigated to the home page");
    }

    public void theUserClicksOnSignOnLinkOnTheHeader() {
        wlnHeader.signInLink().click();
        onepassLogin.waitForPageToLoad();
        LOG.info("The user has clicked on the SignOn link on the header");
    }

    @Given("^PL\\+ ANZ user navigates to home page$")
    public void plAnzUserNaviagatesToHomePage() throws Throwable {
        getDriver().manage().deleteAllCookies();
        navigationCobalt.navigateToPLANZPlus();
        plcHomePage.closeCookieConsentMessage();
        resetCurrentUser();
        LOG.info("The PL+ ANZ user has navigated to the home page");
    }

    @Given("^PL\\+ user navigates to login page$")
    public void plUserNavigatesToLoginPage() throws Throwable {
        onepassLogin.deleteAllCookies();
        navigationCobalt.navigateToPLUKPlus();
        plcHomePage.closeCookieConsentMessage();
        resetCurrentUser();
        if (!baseUrl.contains("hotprod")) {
            theUserClicksOnSignOnLinkOnTheHeader();
            LOG.info("The PL+ user has navigated to the login page");
        } else {
            LOG.info("OpenWeb is OFF on HOT PROD. User is already on login page");
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
        LOG.info("The PL+ user is logged in");
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
        LOG.info("The PL+ user has logged in with the following details after IP login");
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
        LOG.info("The PL+ user has logged in with the following details");
    }

    @When("^user is navigated to routing$")
    public void userNavitedToRoutingPage() {
        navigateToRoutingPage(Product.PLC);
        LOG.info("The user has navigated to the routing page");
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
        LOG.info("ANZ user has logged in");
    }

    @Given("^ANZ user is logged in with following details$")
    public void anzUserIsLoggedInWithFollowingDetails(@Transpose List<CobaltUser> plPlusUserList) throws Throwable {
        for (CobaltUser user : plPlusUserList) {
            user.setProduct(Product.ANZ);
        }
        plUserIsLoggedInWithFollowingDetails(plPlusUserList);
        LOG.info("ANZ user has logged in with the following details");
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
        LOG.info("The PL+ user has logged in with routing details");
    }

    @Given("^ANZ user is logged in with routing details$")
    public void anzUserIsLoggedInWithRoutingDetails(@Transpose List<CobaltUser> plPlusUserList) throws Throwable {
        for (CobaltUser user : plPlusUserList) {
            user.setProduct(Product.ANZ);
        }
        plUserIsLoggedInWithRoutingDetails(plPlusUserList);
        LOG.info("ANZ user has logged in with routing details");
    }

    @Given("^PL\\+ user is applying routing without login$")
    public void plUserIsApplyingRoutingWithoutLogin(@Transpose List<CobaltUser> plPlusUserList) throws Throwable {
        CobaltUser plPlusUser = CobaltUser.updateMissingFields(plPlusUserList.get(0));
        if (StringUtils.isEmpty(plPlusUser.getUserName())) {
            plPlusUser.setUserName(!"None".equalsIgnoreCase(System.getProperty("username")) ? System
                    .getProperty("username") : ExcelFileReader.getDefaultUser());
        }
        doRouting(CobaltUser.updateMissingFields(plPlusUserList.get(0)));
        LOG.info("The PL+ user has applied routing without login");
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
        LOG.info("The user has logged in");
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
        LOG.info("The user has navigated to the home page");
    }

    private void closeWelcomeDialog() {
        if (comMethods.waitForElementToBeVisible(By.xpath("//*[@id='coid_lightboxOverlay']//input[@value='Close']"), 1000) != null) {
            onepassLogin.findElement(By.id("welcomePrefCheckbox")).click();
            onepassLogin.findElement(By.xpath("//*[@id='coid_lightboxOverlay']//input[@value='Close']")).click();
        }
        LOG.info("The welcome dialog has closed");
    }

    private String getPasswordForPlPlusUser(String userName) throws IOException, InterruptedException {
        String overriddenUserName = System.getProperty("username");
        if (overriddenUserName != null && userName.equals(overriddenUserName)) {
            return null == System.getProperty("password") ? ExcelFileReader.getCobaltPassword(userName) : System.getProperty("password");
        }
        LOG.info("The password for PLPlusUser is got");
        return ExcelFileReader.getCobaltPassword(userName);
    }

    private void doRouting(CobaltUser user) throws InterruptedException {
        if (user.getProduct().equals(Product.PLC) || Product.ANZ.equals(user.getProduct())) {
            switch (user.getRouting()) {
                case DEFAULT:
                    LOG.info("DEFAULT routing");
                    navigateToRoutingPage(user.getProduct());
                    comMethods.waitForElementToBeVisible(By.id("CategoryPageCollectionSet"), 1000).sendKeys("w_plplus_catpagestst_cs");
                    new Select(onepassLogin.findElement(By.id("WebContentCollectionSet"))).selectByValue("w_cb_wcmstst_cs");
                    break;
                case KHSEARCH:
                    LOG.info("KHSEARCH routing");
                case RESEARCH_DOC_DISPLAY:
                    LOG.info("RESEARCH_DOC_DISPLAY routing");
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
                    LOG.info("BETA routing");
                    navigateToRoutingPage(user.getProduct());
                    routingPage.showFeatureSelectionsLink().click();
                    routingPage.selectDropDownByVisibleText(routingPage.preReleaseContentDropdown(), "Grant");
                    break;
                case RDD:
                    LOG.info("RDD routing");
                    navigateToRoutingPage(user.getProduct());
                    routingPage.showFeatureSelectionsLink().click();
                    routingPage.selectDropDownByVisibleText(routingPage.ignoreAuthorizationBlocksDropdown(), "Grant");
                    routingPage.selectDropDownByVisibleText(routingPage.preReleaseContentDropdown(), "Grant");
                    break;
                case OPEN_WEB:
                    LOG.info("OPEN_WEB routing");
                    user.setLoginRequired("NO");
                    navigateToRoutingPage(user.getProduct());
                    routingPage.selectDropDownByVisibleText(routingPage.skipAnonymousAuthenticationDropdown(), "False");
                    routingPage.anonymousRegistrationKeyTextBox().sendKeys("1890639-SKKON3");
                    break;
                case ANZ_IAC:
                    LOG.info("ANZ_IAC routing");
                    navigateToRoutingPage(user.getProduct());
                    routingPage.infrastructureAccessControls().sendKeys("IAC-LIGER-NORT-TEST-FILTER");
                    routingPage.showFeatureSelectionsLink().click();
                    routingPage.selectDropDownByVisibleText(routingPage.ignoreAuthorizationBlocksDropdown(), "Grant");
                    routingPage.selectDropDownByVisibleText(routingPage.preReleaseContentDropdown(), "Grant");
                    routingPage.selectDropDownByVisibleText(routingPage.wlnByPass100KAncillaryDropdown(), "Grant");
                    break;
                case FAST_DRAFT_OPEN_WEB:
                    LOG.info("FAST_DRAFT_OPEN_WEB routing");
                    user.setLoginRequired("NO");
                    navigateToRoutingPage(user.getProduct());
                    routingPage.selectDropDownByVisibleText(routingPage.skipAnonymousAuthenticationDropdown(), "False");
                    routingPage.anonymousRegistrationKeyTextBox().sendKeys("1890639-SKKON3");
                    routingPage.fastDraftHost().clear();
                    routingPage.fastDraftHost().sendKeys("d" + System.getProperty("base.legacy.url") + "-infra.dev.practicallaw.com");
                    routingPage.showFeatureSelectionsLink().click();
                    break;
                case FAST_DRAFT_IP_USERS:
                    LOG.info("FAST_DRAFT_IP_USERS routing");
                    user.setLoginRequired("NO");
                    navigateToRoutingPage(user.getProduct());
                    routingPage.fastDraftHost().clear();
                    routingPage.fastDraftHost().sendKeys("d" + System.getProperty("base.legacy.url") + "-infra.dev.practicallaw.com");
                    routingPage.showFeatureSelectionsLink().click();
                    break;
                case FAST_DRAFT:
                    LOG.info("FAST_DRAFT routing");
                    navigateToRoutingPage(user.getProduct());
                    routingPage.fastDraftHost().clear();
                    routingPage.fastDraftHost().sendKeys("d" + System.getProperty("base.legacy.url") + "-infra.dev.practicallaw.com");
                    routingPage.showFeatureSelectionsLink().click();
                    break;
                case FAST_DRAFT_INCORRECT:
                    LOG.info("FAST_DRAFT_INCORRECT routing");
                    navigateToRoutingPage(user.getProduct());
                    routingPage.fastDraftHost().clear();
                    routingPage.fastDraftHost().sendKeys("http://uc199881-tpv-z:9933/");
                    routingPage.showFeatureSelectionsLink().click();
                    break;
                case FAST_DRAFT_FIRM_STYLE:
                    LOG.info("FAST_DRAFT_FIRM_STYLE routing");
                    navigateToRoutingPage(user.getProduct());
                    routingPage.showFeatureSelectionsLink().click();
                    routingPage.selectDropDownByVisibleText(routingPage.firmStyleDropdown(), "Grant");
                    routingPage.fastDraftHost().clear();
                    routingPage.fastDraftHost().sendKeys("d" + System.getProperty("base.legacy.url") + "-infra.dev.practicallaw.com");
                    break;
                case FIRM_STYLE:
                    LOG.info("FIRM_STYLE routing");
                    navigateToRoutingPage(user.getProduct());
                    routingPage.showFeatureSelectionsLink().click();
                    routingPage.selectDropDownByVisibleText(routingPage.firmStyleDropdown(), "Grant");
                    break;
                case FIRM_STYLE_NO_FAC:
                    LOG.info("FIRM_STYLE_NO_FAC routing");
                    navigateToRoutingPage(user.getProduct());
                    routingPage.showFeatureSelectionsLink().click();
                    routingPage.selectDropDownByVisibleText(routingPage.firmStyleDropdown(), "Deny");
                    break;
                case FIRM_STYLE_IP_USERS:
                    LOG.info("FIRM_STYLE_IP_USERS routing");
                    user.setLoginRequired("NO");
                    navigateToRoutingPage(user.getProduct());
                    routingPage.showFeatureSelectionsLink().click();
                    routingPage.selectDropDownByVisibleText(routingPage.firmStyleDropdown(), "Grant");
                    break;
                case FIRM_STYLE_IP_USERS_NO_FAC:
                    LOG.info("FIRM_STYLE_IP_USERS_NO_FAC routing");
                    user.setLoginRequired("NO");
                    navigateToRoutingPage(user.getProduct());
                    routingPage.showFeatureSelectionsLink().click();
                    routingPage.selectDropDownByVisibleText(routingPage.firmStyleDropdown(), "Deny");
                    break;
                case KH_DOC_DISPLAY:
                    LOG.info("KH_DOC_DISPLAY routing");
                    navigateToRoutingPage(user.getProduct());
                    routingPage.showFeatureSelectionsLink().click();
                    WebElement ignore1 = routingPage.ignoreAuthorizationBlocksDropdown();
                    routingPage.selectDropDownByVisibleText(ignore1, "Grant");
                    break;
                case CAT_PAGES:
                    LOG.info("CAT_PAGES routing");
                    navigateToRoutingPage(user.getProduct());
                    comMethods.waitForElementToBeVisible(By.id("CategoryPageCollectionSet"), 1000).sendKeys("w_plcuk_catpagestst_cs");
                    break;
                case ASK:
                    LOG.info("ASK routing");
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
                    LOG.info("ASK_EDITOR routing");
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
                    LOG.info("ASK_DEV_WEB_COLLECTION routing");
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
                    LOG.info("ASK_PROD_WEB_COLLECTION_CATEGORTY_PAGE_CSET routing");
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
                    LOG.info("ASK_UNRELEASEDCATEGORY routing");
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
                    LOG.info("OPEN_WEB_SEARCH routing");
                    navigateToRoutingPage(user.getProduct());
                    comMethods.waitForElementToBeVisible(By.id("CategoryPageCollectionSet"), 1000).sendKeys("w_plplus_catpagestst_cs");
                    new Select(onepassLogin.findElement(By.id("WebContentCollectionSet"))).selectByVisibleText("TEST");
                    new Select(onepassLogin.findElement(By.id("SkipAnonymousAuthenticationKey"))).selectByValue("False");
                    break;
                case DOCDISPLAY_UseCollectionSet:
                    LOG.info("DOCDISPLAY_UseCollectionSet routing");
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
                    LOG.info("SPECIFIED_USER_TIMEOUT_3_MINUTES routing");
                    navigateToRoutingPage(user.getProduct());
                    comMethods.waitForElementToBeVisible(By.xpath("//input[@id='Text2' and @name='SessionTimeoutOverride']"), 1000).clear();
                    comMethods.waitForElementToBeVisible(By.xpath("//input[@id='Text2' and @name='SessionTimeoutOverride']"), 1000).sendKeys("3");
                    break;
                case NON_SUBSCRIBER:
                    LOG.info("NON_SUBSCRIBER routing");
                    navigateToRoutingPage(user.getProduct());
                    routingPage.showFeatureSelectionsLink().click();
                    WebElement plc = routingPage.practicalLawDropdown();
                    routingPage.selectDropDownByVisibleText(plc, "Grant");
                    break;
                case RESEARCH_SEARCH:
                    LOG.info("RESEARCH_SEARCH routing");
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
                    LOG.info("ASSERT_PAGE routing");
                    navigateToRoutingPage(user.getProduct());
                    //routingPage.setPMdDataVersion("2808");
                    routingPage.showFeatureSelectionsLink().click();
                    routingPage.selectDropDownByVisibleText(routingPage.userInternal(), "Grant");
                    routingPage.selectDropDownByVisibleText(routingPage.ignoreAuthorizationBlocksDropdown(), "Grant");
                    routingPage.selectDropDownByVisibleText(routingPage.preReleaseContentDropdown(), "Grant");
                    routingPage.selectDropDownByVisibleText(routingPage.wlnByPass100KAncillaryDropdown(), "Grant");
                    break;
                case ANNOTATIONS:
                    LOG.info("ANNOTATIONS routing");
                    navigateToRoutingPage(user.getProduct());
                    //routingPage.infrastructureAccessTextArea().sendKeys("IAC-WLNDOC-SHAREDNOTES");
                    //routingPage.showFeatureSelectionsLink().click();
                    //routingPage.selectDropDownByVisibleText(routingPage.waitForExpectedElement(By.id("co_website_resourceInfoTypes_BlockShareNoteLink")),"Deny");
                    //routingPage.selectDropDownByVisibleText(routingPage.ignoreAuthorizationBlocksDropdown(), "Grant");
                    //routingPage.selectDropDownByVisibleText(routingPage.preReleaseContentDropdown(), "Grant");
                    //routingPage.selectDropDownByVisibleText(routingPage.wlnByPass100KAncillaryDropdown(), "Grant");
                    break;
                case GLOBAL_PAGE:
                    LOG.info("GLOBAL_PAGE routing");
                    navigateToRoutingPage(user.getProduct());
                    routingPage.showFeatureSelectionsLink().click();
                    routingPage.selectDropDownByVisibleText(routingPage.unreleasedCatPagesDropdown(), "Grant");
                default:
                    throw new UnknownError("Routing Code not implemented " + user.getRouting());
                case NOWHATSMARKETACCESS:
                    LOG.info("NOWHATSMARKETACCESS routing");
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
        LOG.info("The user has logged in from the login page");
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
         * The below commented lines ensure that HOTPROD is being hit thinking OW is turned OFF.
         *
         * Please uncomment and update the lines if OW will be turned OFF on any of the sites.
         */
   /*     switch (baseUrl) {
            case "hotprod":
                LOG.info("HOT PROD Site is being tested.");
                break;
            case "prod":
                LOG.info("Production Site is being tested.");
                wlnHeader.signInLink().click();
                break;
            case "prodA":
                LOG.info("PROD A is being tested.");
                wlnHeader.signInLink().click();
                break;
            case "prodB":
                LOG.info("PROD B is being tested.");
                wlnHeader.signInLink().click();
                break;
            default:
                wlnHeader.signInLink().click();
                break;
        } */
        wlnHeader.signInLink().click();
        LOG.info("The web flow is handled to open");
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
        LOG.info("The user hacked to remove port and navigated to the OnePass page");
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
        LOG.info("Client id is set");
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
        LOG.info("The user session is active, so the user is navigated to the Routing Page");
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
                    LOG.info("The user is signed off from WLN");
                    break;
                case PLC:
                    boolean alreadyLoggedIn = false;
                    try {
                        wlnHeader.userAvatarIcon().isDisplayed();
                        alreadyLoggedIn = true;
                    } catch (Exception e) {
                        LOG.error("The user is not logged in", e);
                    }
                    if (alreadyLoggedIn) {
                        element = wlnHeader.userPreferencesDropdown("Sign out");
                    }
                    LOG.info("The user is signed off from PLC");
                    break;
                case ANZ:
                    wlnHeader.expandUserAvatarDropDown();
                    element = wlnHeader.signOutLink();
                    LOG.info("The user is signed off from ANZ");
                    break;
                case PLC_lEGACY:
                    navigationCobalt.navigateToPLCLegacy();
                    element = onepassLogin.findElement(By.linkText("Log out"));
                    LOG.info("The user is signed off from PLC_LEGACY");
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
        LOG.info("New Session is created");
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
        LOG.info("Current user has reloged in");
    }

    @When("^user logs in$")
    public void userLogsInWithUsername() throws Throwable {
        LOG.info("The user is logging in");
        String userName = (!"None".equalsIgnoreCase(System.getProperty("username")) ? System.getProperty("username") : ExcelFileReader.getDefaultUser());
        onepassLogin.usernameTextField().sendKeys(userName);
        String password = getPasswordForPlPlusUser(userName);
        onepassLogin.passwordTextField().clear();
        onepassLogin.passwordTextField().sendKeys(password);
        onepassLogin.signOnButton().click();
        LOG.info("The user has logged in");
    }

    private void setAnnotationUsers() {
        if (annotationUsers == null) {
            LOG.info("Loading Annotation users...");
            annotationUsers = new HashMap<String, User>();
            annotationUsers.put(cobaltLogin.annUserName, new User(cobaltLogin.annUserFirstName, cobaltLogin.annUserLastName));
            annotationUsers.put(cobaltLogin.annAnotherUserName, new User(cobaltLogin.annAnotherFirstName, cobaltLogin.annAnotherLastName));
            annotationUsers.put(cobaltLogin.annReadOnlyUserName, new User(cobaltLogin.annReadOnlyFirstName, cobaltLogin.annReadOnlyLastName));
            annotationUsers.put(cobaltLogin.annAnotherReadOnlyUserName, new User(cobaltLogin.annAnotherReadOnlyFirstName, cobaltLogin.annAnotherReadOnlyLastName));
            LOG.info("annotationsUsers:" + annotationUsers.size());
        }
    }

    @Then("^user logs in back again from signOff page$")
    public void userLogsInBackAgainFromSignOffPage() throws Throwable {
        LOG.info("The user is logging in back from the signOff page");
        onePassLogoutPage.signOffPageSignOnButton().click();
        onepassLogin.waitForPageToLoad();
        userLogsInWithUsername();
        LOG.info("THe user has logged back again from the signOff page");
    }

    @Given("^PL\\+ user '(.*)' opens '(.*)' folder$")
    public void plUserLoginAndOpenFolder(String userName, String folderName) throws Throwable {
        LOG.info("The " + userName + " opens " + folderName + " folder");
        List<CobaltUser> cobaltUsers = new ArrayList<>();
        cobaltUsers.add(getCobaltUserForUserName(userName));
        plUserIsLoggedInWithFollowingDetails(cobaltUsers);
        userGoesToFolderSubFolder(folderName);
        LOG.info("The " + userName + " has opened " + folderName + " folder");
    }

    private void userLoginAndOpenFolder(String userName, String folderName) throws Throwable {
        LOG.info("The user" + userName + " logins and opens a folder " + folderName);
        List<CobaltUser> cobaltUsers = new ArrayList<>();
        cobaltUsers.add(getCobaltUserForUserName(userName));
        plUserIsLoggedInWithFollowingDetails(cobaltUsers);
        userGoesToFolderSubFolder(folderName);
        LOG.info("The user" + userName + " has logined and opened a folder " + folderName);
    }

    private void userGoesToFolderSubFolder(String folderName) {
        LOG.info("The user is going to a folder subfolder");
        userClicksOnHeaderLink("Folders");
        openFolder(folderName);
        LOG.info("The user has gone to a folder subfolder");
    }

    private void userClicksOnHeaderLink(String linkName) {
        researchOrganizerPage.waitForPageToLoad();
        switch (linkName) {
            case "Folders":
                LOG.info("The user is clicking on 'Folders' link");
                wlnHeader.foldersLink().click();
                LOG.info("The user has clicked on 'Folders' link");
                break;
            case "History":
                LOG.info("The user is clicking on 'History' link");
                wlnHeader.historyLink().click();
                LOG.info("The user has clicked on 'History' link");
                break;
            case "Favourites":
                LOG.info("The user is clicking on 'Favourites' link");
                wlnHeader.favouritesLink().click();
                LOG.info("The user has clicked on 'Favourites' link");
                break;
            default:
        }
        researchOrganizerPage.waitForPageToLoad();
        researchOrganizerPage.waitForPageToLoadAndJQueryProcessing();
    }

    private String folderName;

    private void openFolder(String folderName) {
        LOG.info("Open folder " + folderName);
        foldersUtils.openFolder(folderName);
        this.folderName = folderName;
        LOG.info(folderName + " has been opened");
    }

    @Given("^PL\\+ user '(.*)' navigates directly to document with guid '(.*)'$")
    public void plUserLoginAndNavigateToDoc(String userName, String docGuid) throws Throwable {
        LOG.info("The PL+ user is navigating directly to the document with guid " + docGuid);
        plUserIsLoggedInWithFollowingDetails(getCobaltUserForUserNameAsList(userName));
        navigatesDirectlyToDocumentWithGuid(docGuid);
        LOG.info("The PL+ user has directly navigated to the document with guid " + docGuid);
    }

    private void navigatesDirectlyToDocumentWithGuid(String guid) {
        LOG.info("The user is navigating directly to the document with guid");
        navigationCobalt.navigateToWLNSpecificResourcePage("/Document/" + guid + "/View/FullText.html");
        resourcePage.waitForPageToLoadAndJQueryProcessing();
        LOG.info("The user has navigated directly to the document with guid");
    }

    @Given("^PL\\+ user '(.*)' searches for '(.*)'$")
    public void plUserLoginAndSearch(String userName, String term) throws Throwable {
        LOG.info("The PL+ user " + userName + "searches for " + term);
        plUserIsLoggedInWithFollowingDetails(getCobaltUserForUserNameAsList(userName));
        searchFor(term);
        LOG.info("The PL+ user " + userName + " found" + term);
    }

    private void searchFor(String searchQuery) {
        LOG.info("Searching for " + searchQuery);
        searchHomePage.enterSearchText(searchQuery);
        searchHomePage.searchButton().click();
        searchHomePage.waitForPageToLoad();
        searchHomePage.waitForPageToLoadAndJQueryProcessing();
        LOG.info("Found " + searchQuery);
    }

    private CobaltUser getCobaltUserForUserName(String userName) {
        LOG.info("Getting a Cobalt user for a user name");
        CobaltUser resultUser = new CobaltUser();
        resultUser.setUserName(userName);
        resultUser = CobaltUser.updateMissingFields(resultUser);
        LOG.info("Got a Cobalt user for a user name");
        return resultUser;
    }

    private List<CobaltUser> getCobaltUserForUserNameAsList(String userName) {
        LOG.info("Getting a Cobalt user for a user name as a link");
        List<CobaltUser> cobaltUsers = new ArrayList<>();
        cobaltUsers.add(getCobaltUserForUserName(userName));
        LOG.info("Got a Cobalt user for a user name as a link");
        return cobaltUsers;
    }
}
