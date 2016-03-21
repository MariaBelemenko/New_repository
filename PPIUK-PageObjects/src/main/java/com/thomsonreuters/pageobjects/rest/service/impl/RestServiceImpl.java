package com.thomsonreuters.pageobjects.rest.service.impl;

import com.thomsonreuters.driver.framework.WebDriverDiscovery;
import com.thomsonreuters.pageobjects.rest.auth.UDSCredentials;
import com.thomsonreuters.pageobjects.rest.auth.UDSService;
import com.thomsonreuters.pageobjects.rest.service.RestService;
import com.thomsonreuters.pageobjects.utils.OnepassLoginUtils;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.LoggerFactory;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public abstract class RestServiceImpl implements RestService {

    protected static final org.slf4j.Logger LOG = LoggerFactory.getLogger(RestServiceImpl.class);

    protected WebDriverDiscovery webDriverDiscovery = new WebDriverDiscovery();
    private RestTemplate restTemplate = new RestTemplate();
    protected OnepassLoginUtils onepassLoginUtils = new OnepassLoginUtils();
    private UDSService udsService = new UDSService();

    private static final String SECURE_PROTOCOL = "https://";
    private static final String PROTOCOL = "http://";

    /**
     * Custom response handler to make possibility to log response body with error from Cobalt
     */
    public class CustomResponseErrorHandler extends DefaultResponseErrorHandler {

        private final org.slf4j.Logger LOG = LoggerFactory.getLogger(CustomResponseErrorHandler.class);

        @Override
        public void handleError(ClientHttpResponse response) throws IOException {
            try {
                super.handleError(response);
            } catch (HttpServerErrorException | HttpClientErrorException httpException) {
                LOG.info("RESPONSE HANDLER (Client / Server error). \nHeaders: "
                        + httpException.getResponseHeaders().toString()+ "\nResponse: " + httpException.getResponseBodyAsString());
                throw httpException;
            }
        }
    }

    public RestTemplate getRestTemplate() {
        restTemplate.setErrorHandler(new CustomResponseErrorHandler());
        return restTemplate;
    }

    public String getSite() {
        String[] rawCookieParams = getCookies().split(";");
        String[] rawCookieNameAndValue = rawCookieParams[0].split("=");
        if (rawCookieNameAndValue.length != 2) {
            throw new RuntimeException("Invalid cookie: missing name and value.");
        }
        String cookie = null;
        for (int i = 0; i < rawCookieParams.length; i++) {
            String rawCookieParamNameAndValue[] = rawCookieParams[i].trim().split("=");
            String paramName = rawCookieParamNameAndValue[0].trim();
            if (paramName.equalsIgnoreCase("site")) {
                cookie = rawCookieParamNameAndValue[1].trim();
            }
        }
        return cookie;
    }

    public String getSiteCookie() {
        return "site=" + getSite();
    }

    public String getCookies() {
        RemoteWebDriver driver = webDriverDiscovery.getRemoteWebDriver();
        StringBuilder stringBuilder = new StringBuilder();
        for (Cookie cookie : driver.manage().getCookies()) {
            try {
                stringBuilder.append(cookie.getName() + "=" + URLEncoder.encode(cookie.getValue(), "UTF-8") + ";");
            } catch (UnsupportedEncodingException e) {
                LOG.info("context", e);
            }
        }
        return stringBuilder.toString();
    }

	public UDSCredentials getUDSCredentials() {
		return udsService.getUdsCredentials(getUserName(), getUserPassword(), getProductView(), getSiteCookie());
	}
	
	public String getCurrentSession() {
        if (null != getUserName()) {
            return udsService.getCurrentSession(getUserName(), getUserPassword(), getProductView(), getSiteCookie());
        } else {
            //for Open Web and IP users that do not have user name
            JavascriptExecutor jsEx = ((JavascriptExecutor) webDriverDiscovery.getRemoteWebDriver());
            return (String) jsEx.executeScript("return $(Cobalt.User.GetUserName()).selector;");
        }
	}

    public String getCurrentBaseUrl() {
        RemoteWebDriver driver = webDriverDiscovery.getRemoteWebDriver();
        return driver.getCurrentUrl().split("/")[2];
    }

    public String getUserName() {
        return onepassLoginUtils.getUserName();
    }

    public String getUserPassword() {
        return onepassLoginUtils.getPassword();
    }

    public String getProtocol() {
		if (System.getProperty("base.url").equalsIgnoreCase("qed") || System.getProperty("base.url").equalsIgnoreCase("demo")) {
			return SECURE_PROTOCOL;
		} else {
            return PROTOCOL;
        }
    }

    public String getProductView() {
        String productBase = getCurrentBaseUrl();
        if (productBase.contains("au")) {
            return "PLCAU";
        }
        if (productBase.contains("uk")) {
            return "PLCUK";
        }
        return null;
    }

    public WebDriverDiscovery getWebDriverDiscovery() {
        return webDriverDiscovery;
    }
}
