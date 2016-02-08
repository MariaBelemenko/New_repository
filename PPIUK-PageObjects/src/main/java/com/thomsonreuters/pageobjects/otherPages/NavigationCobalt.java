package com.thomsonreuters.pageobjects.otherPages;

import com.thomsonreuters.driver.exception.PageOperationException;
import com.thomsonreuters.driver.framework.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.net.URL;

public class NavigationCobalt extends AbstractPage {
    
    protected static final org.slf4j.Logger logger = LoggerFactory.getLogger(NavigationCobalt.class);

    public static final By HOME_PAGE_CSS_SELECTOR = By.xpath("//*[@id='header_lower_logo']//a");
    public static final By WLN_HOME_PAGE_CSS_SELECTOR = By.id("coid_website_logo");

    String baseUrl = System.getProperty("base.url");
    String baseLegacyUrl = System.getProperty("base.legacy.url");

    public NavigationCobalt() {
        super();
    }

    public void navigateToWestlawNext() {
        getDriver.get(getWlnProductBase() + baseUrl + getWlnDomain());
    }

    public void navigateToWestlawNextBrowsePreview() {
        getDriver.get(getWlnProductBase() + baseUrl + getWlnDomain() + "/BrowsePreview/Home");
    }

    public void navigateToWLNSpecificURL(String sitePage) {
        getDriver.get(getWlnProductBase() + baseUrl + getWlnDomain() + sitePage);
    }

    /**
     * This method is to navigate to the temporary routing page needed to log
     * onto demo as at 21/01/15
     */
    public void navigateToTempRoutingPage() {
        getDriver.get(getPlcukProductBase() + baseUrl + getPlcukDomain() + "/routing?SessionStartEventProductNameOverride=PLCUK");
    }

    /**
     * This method is to navigate to the temporary routing page needed to log
     * onto demo as at 03/02/15
     */
    public void navigateToNewTempRoutingPage() {
        getDriver.get(getPlcukProductBase() + baseUrl + getPlcukDomain()
                + "/routing?routingOptions=%5B%7B%22WebContentCollectionSet%22%3A%22w_cb_wcmstst_cs%22%7D%2C%7B%22CategoryPageCollectionSet%22%3A%22w_plplus_catpagestst_cs%22%7D%2C%7B%22includeSignOnClick%22%3Atrue%7D%5D");
    }

    public void navigateToWLNGlossaryPage() {
        getDriver.get(getPlcukProductBase() + baseUrl + getPlcukDomain() + "/Glossary/UKPracticallaw");
    }

    public void navigateToWLNSpecificResourcePage(String page) {
        switch (baseUrl) {
            case "prod":
                getDriver.get(getPlcukProductBase() + getPlcukProdDomain() + page);
                break;
            case "prodA":
                getDriver.get(getUkProdA() + getPlcukProdDomain() + page);
                break;
            case "prodB":
                getDriver.get(getUkProdB() + getPlcukProdDomain() + page);
                break;
            case "qedA":
                getDriver.get(getUkQedA() + baseUrl + getPlcukDomain() + page);
                break;
            case "qedB":
                getDriver.get(getUkQedB() + baseUrl + getPlcukDomain() + page);
                break;
            default:
                getDriver.get(getPlcukProductBase() + baseUrl + getPlcukDomain() + page);
        }
    }
    
    public void navigateToANZSpecificResourcePage(String page) {
        getDriver.get(getPlcauProductBase() + baseUrl + getPlcukDomain() + page);
    }

    public void navigateToPLUKPlus() {
        switch (baseUrl) {
            case "prod":
                getDriver.get(getPlcukProductBase() + getPlcukProdDomain());
                break;
            case "prodA":
                getDriver.get(getUkProdA() + getPlcukProdDomain());
                break;
            case "prodB":
                getDriver.get(getUkProdB() + getPlcukProdDomain());
                break;
            case "qedA":
                getDriver.get(getUkQedA() + baseUrl + getPlcukDomain());
                break;
            case "qedB":
                getDriver.get(getUkQedB() + baseUrl + getPlcukDomain());
                break;
            default:
                getDriver.get(getPlcukProductBase() + baseUrl + getPlcukDomain());
                break;
        }
    }
    
    public void navigateToPLANZPlus() {
            getDriver.get(getPlcauProductBase() + baseUrl + getPlcukDomain());
    }

    public void navigateToPLCLegacy() {
        getDriver.get(getPlcLegacyProductBase() + baseLegacyUrl + getPlcLegacyDomain());
    }

    public void navigateToTempHomePage() {
        getDriver.get(getPlcukProductBase() + baseUrl + getPlcukDomain() + "/Browse/Home/Practice/Home?transitionType=Default&contextData=(sc.Default)&CobaltRefresh=52840&firstPage=true&bhcp=1");
        waitForPageToLoad();
    }

    public void navigateToPLCUKPlusSpecificURL(String sitePage) {
        switch (baseUrl) {
            case "prod":
                getDriver.get(getPlcukProductBase() + getPlcukProdDomain() + sitePage);
                break;
            case "prodA":
                getDriver.get(getUkProdA() + getPlcukProdDomain() + sitePage);
                break;
            case "prodB":
                getDriver.get(getUkProdB() + getPlcukProdDomain() + sitePage);
                break;
            case "qedA":
                getDriver.get(getUkQedA() + baseUrl + getPlcukDomain() + sitePage);
                break;
            case "qedB":
                getDriver.get(getUkQedB() + baseUrl + getPlcukDomain() + sitePage);
                break;
            default:
                getDriver.get(getPlcukProductBase() + baseUrl + getPlcukDomain() + sitePage);
        }
    }

	public void navigateToPLCANZSpecificURL(String sitePage) {
		getDriver.get(getPlcauProductBase() + baseUrl + getPlcukDomain() + sitePage);
	}

    public void navigateToPLCUKPlusWithRouting(String routingString) {
        getDriver.get(getPlcukProductBase() + baseUrl + getPlcukDomain() + routingString);
    }

    public void navigateToRelativeURL(String relativeUrl) {
        String currUrl = getDriver.getCurrentUrl();
        String baseURL = "";
        URL url = null;

        try {
            url = new URL(currUrl);
        } catch (MalformedURLException e) {
            LOG.info("context", e);
        }
        baseURL = url.getProtocol() + "://" + url.getHost();

        if (relativeUrl.startsWith("/")) {
            getDriver.get(baseURL + relativeUrl);
        } else {
            getDriver.get(baseURL + "/" + relativeUrl);
        }
    }

    /**
     * This method takes back to to the home page of PLC UK.
     */
    public void navigateToHomePage() {
        waitFluentForElement(HOME_PAGE_CSS_SELECTOR).click();
        waitForPageToLoad();
    }

    public void navigateToWLNHomePage() {
        waitFluentForElement(WLN_HOME_PAGE_CSS_SELECTOR).click();
        waitForPageToLoad();
    }

    /**
     * This method is to open the History navigation menu by placing mouse over on it.
     */
    public void navigateToHistoryMenu() {
        try {
            WebElement ele = retryingFindElement(By.cssSelector("a[title='Open Recent History']"));
            ele.click();
        } catch (TimeoutException ne) {
            LOG.info("context", ne);
            throw new PageOperationException(ne.getMessage());
        }
    }

    /**
     * This method is to open the My Folders Page by clicking on Folders menu.
     */
    public void navigateToFoldersPage() {
        try {
            retryingFindElement(By.cssSelector("#co_recentFoldersContainer a.co_dropdownBoxanchorLabel")).click();
        } catch (TimeoutException ne) {
            LOG.info("context", ne);
            throw new PageOperationException(ne.getMessage());
        }
    }

}