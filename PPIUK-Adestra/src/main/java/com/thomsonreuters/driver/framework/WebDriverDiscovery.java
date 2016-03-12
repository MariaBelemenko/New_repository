//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.thomsonreuters.driver.framework;

import com.thomsonreuters.driver.framework.ExcelFileTracker;
import com.thomsonreuters.driver.framework.ReportMerger;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.openqa.selenium.remote.CapabilityType;

public class WebDriverDiscovery extends EventFiringWebDriver {
    protected static final Logger LOG = LoggerFactory.getLogger(WebDriverDiscovery.class);
    private static RemoteWebDriver remoteWebDriver;
    private static String operatingSystem;
    private static String os_Version;
    private static String browserName;
    private static String browserVersion;
    private static Properties props;
    private static final Map<String, String> browserMap = Collections.unmodifiableMap(new HashMap() {
        {
            this.put("chrome", "org.openqa.selenium.chrome.ChromeDriver");
            this.put("firefox", "org.openqa.selenium.firefox.FirefoxDriver");
            this.put("safari", "org.openqa.selenium.safari.SafariDriver");
            this.put("ie", "org.openqa.selenium.ie.InternetExplorerDriver");
            this.put("browserStack", "BrowserStackDriver");
            this.put("htmlUnit", "org.openqa.selenium.htmlunit.HtmlUnitDriver");
        }
    });
    private static final Thread CLOSE_THREAD = new Thread() {
        public void run() {
            try {
                WebDriverDiscovery.remoteWebDriver.quit();
                (new ReportMerger()).mergeReports(new File("target/cucumber-htmlreport/"));
            } catch (Throwable var2) {
                ;
            }

        }
    };

    public static String getOperatingSystem() {
        return operatingSystem;
    }

    public static String getOs_Version() {
        return os_Version;
    }

    public static String getBrowserVersion() {
        return browserVersion;
    }

    public static String getBrowserName() {
        return browserName;
    }

    private static void loadUserProperties() {
        InputStream inputStream = null;

        try {
            inputStream = WebDriverDiscovery.class.getClassLoader().getResourceAsStream("grid.properties");
            LOG.info("Loading the properties as proj root /src/test/resources:");
            Properties e = new Properties();
            e.load(inputStream);
            props = e;
        } catch (IOException var5) {
            LOG.info("No prop file found, trying load the properties as proj root /src/test/resources:");
        } finally {
            IOUtils.closeQuietly(inputStream);
        }

    }

    public WebDriverDiscovery() {
        super(remoteWebDriver);
    }

    public RemoteWebDriver getRemoteWebDriver() {
        return remoteWebDriver;
    }

    public static void getBrowserStackConfiguration() {
        String runConfig = System.getProperty("browserConfig");
        if(StringUtils.isNotBlank(runConfig)) {
            List commandLineArgumentsList = Arrays.asList(runConfig.split(","));
            Iterator i$ = commandLineArgumentsList.iterator();

            while(i$.hasNext()) {
                String configType = (String)i$.next();
                if(configType.contains("=")) {
                    String configKey = configType.substring(0, configType.lastIndexOf("="));
                    String configValue = configType.substring(configType.indexOf("=") + 1);
                    byte var7 = -1;
                    switch(configKey.hashCode()) {
                        case -775273005:
                            if(configKey.equals("browserName")) {
                                var7 = 2;
                            }
                            break;
                        case 2532:
                            if(configKey.equals("OS")) {
                                var7 = 0;
                            }
                            break;
                        case 805776528:
                            if(configKey.equals("browserVersion")) {
                                var7 = 3;
                            }
                            break;
                        case 2039955805:
                            if(configKey.equals("OS_Version")) {
                                var7 = 1;
                            }
                    }

                    switch(var7) {
                        case 0:
                            operatingSystem = configValue;
                            break;
                        case 1:
                            os_Version = configValue;
                            break;
                        case 2:
                            browserName = configValue;
                            break;
                        case 3:
                            browserVersion = configValue;
                    }
                }
            }
        }

    }

    public static void startBrowserStackLocal() throws IOException, InterruptedException {
        ProcessBuilder pb = new ProcessBuilder(new String[]{System.getProperty("browserStackLocal"), "kZMyzjYgGConPxfGuQzg", "localhost,3000,0", "-forcelocal"});
        pb.start();
        Thread.sleep(3000L);
    }

    private static Capabilities caps() {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("platform", "WINDOWS");
        cap.setCapability("browserName", props.getProperty("grid.browser"));
        cap.setCapability(CapabilityType.ELEMENT_SCROLL_BEHAVIOR, 1);
        return cap;
    }

    public void close() {
        remoteWebDriver.quit();
    }

    public String getBrowserCookiesAsString() {
        return this.getBrowserCookiesAsString((Set)null);
    }

    public String getBrowserCookiesAsStringWithoutTS77Cookie() {
        HashSet ignoredCookies = new HashSet();
        Cookie ignoredTS77Cookie = new Cookie("_77", "");
        ignoredCookies.add(ignoredTS77Cookie);
        return this.getBrowserCookiesAsString(ignoredCookies);
    }

    public String getBrowserCookiesAsString(Set<Cookie> ignoredCookies) {
        Set cookies = this.removeCookiesFrom(remoteWebDriver.manage().getCookies(), ignoredCookies);
        StringBuilder sb = new StringBuilder();
        int i = 1;
        int cookiesCount = cookies.size();

        for(Iterator i$ = cookies.iterator(); i$.hasNext(); ++i) {
            Cookie cookie = (Cookie)i$.next();
            sb.append(cookie.getName()).append("=").append(cookie.getValue());
            if(i < cookiesCount) {
                sb.append("; ");
            }
        }

        return sb.toString();
    }

    public void goBack() {
        for(int i = 0; i < 2; ++i) {
            remoteWebDriver.navigate().back();
        }

    }

    public String getCurrentRootAddress(boolean withProtocol) {
        String currUrl = remoteWebDriver.getCurrentUrl();
        String[] splitedUrlBySlash = currUrl.split("/");
        return withProtocol?splitedUrlBySlash[0] + "//" + splitedUrlBySlash[2]:splitedUrlBySlash[2];
    }

    private Set<Cookie> removeCookiesFrom(Set<Cookie> sourceCookies, Set<Cookie> cookiesToRemove) {
        if(cookiesToRemove == null) {
            return sourceCookies;
        } else {
            HashSet resultCookiesList = new HashSet();
            boolean isFound = false;
            Iterator i$ = sourceCookies.iterator();

            while(i$.hasNext()) {
                Cookie sourceCookie = (Cookie)i$.next();
                Iterator i$1 = cookiesToRemove.iterator();

                label31: {
                    Cookie cookieToRemove;
                    do {
                        if(!i$1.hasNext()) {
                            break label31;
                        }

                        cookieToRemove = (Cookie)i$1.next();
                    } while(!sourceCookie.getName().endsWith(cookieToRemove.getName()) && !sourceCookie.getName().startsWith(cookieToRemove.getName()));

                    isFound = true;
                }

                if(!isFound) {
                    resultCookiesList.add(sourceCookie);
                }
            }

            return resultCookiesList;
        }
    }

    static {
        LOG.info("Entered in to browser initialization......");
        loadUserProperties();
        String driverType = System.getProperty("driverType");
        if(StringUtils.isEmpty(driverType)) {
            driverType = "firefox";
        }

        if(driverType.equalsIgnoreCase("seleniumGrid")) {
            try {
                remoteWebDriver = new RemoteWebDriver(new URL(props.getProperty("grid.url")), caps());
            } catch (MalformedURLException var9) {
                var9.printStackTrace();
            }

            remoteWebDriver.manage().window().maximize();
            remoteWebDriver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
        } else {
            String localBrowserType = (String)browserMap.get(driverType);
            if(null != localBrowserType) {
                if(driverType.equalsIgnoreCase("browserStack")) {
                    getBrowserStackConfiguration();

                    try {
                        startBrowserStackLocal();
                    } catch (IOException var7) {
                        LOG.info("Browser Stack Terminated with Error" + var7.getMessage());
                    } catch (InterruptedException var8) {
                        LOG.info("Browser Stack Terminated with Error" + var8.getMessage());
                    }
                } else {
                    Class retrievedClass = null;

                    try {
                        retrievedClass = Class.forName(localBrowserType);
                    } catch (ClassNotFoundException var6) {
                        var6.printStackTrace();
                    }

                    if(!retrievedClass.getSuperclass().equals(RemoteWebDriver.class)) {
                        throw new IllegalArgumentException("driverType must extends RemoteWebDriver");
                    }

                    try {
                        remoteWebDriver = (RemoteWebDriver)retrievedClass.newInstance();
                    } catch (InstantiationException var4) {
                        var4.printStackTrace();
                    } catch (IllegalAccessException var5) {
                        var5.printStackTrace();
                    }

                    remoteWebDriver.manage().window().maximize();
                }
            }
        }

        (new ExcelFileTracker()).setBrowserCounts();
        Runtime.getRuntime().addShutdownHook(CLOSE_THREAD);
    }
}
