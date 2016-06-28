package com.epam.ProxyWork.tests;

import net.lightbody.bmp.core.har.Har;
import net.lightbody.bmp.core.har.HarEntry;
import net.lightbody.bmp.proxy.ProxyServer;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

/**
 * Created by Mariya_Belemenko on 6/28/2016.
 */
public class TestProxy {

    @Test
    public void testMobProxyServer() throws Exception {
        ProxyServer server = new ProxyServer(4444);
        server.start();

        Proxy proxy = server.seleniumProxy();

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.PROXY, proxy);

        WebDriver driver = new FirefoxDriver(capabilities);

        server.newHar("google.com");

        driver.get("http://google.com");

        Har har = server.getHar();

        //List of all queries
        for (HarEntry entry : har.getLog().getEntries()) {
            System.out.println(entry.getRequest().getUrl());
            //Time waiting for a response from the server in milliseconds
            System.out.println(entry.getTimings().getWait());
            //Time of reading of a response from the server in milliseconds
            System.out.println(entry.getTimings().getReceive());
        }

        driver.quit();
        server.stop();
    }
}
