package com.thomsonreuters.pageobjects.pages.urls.plcuk;

import com.thomsonreuters.driver.framework.AbstractPage;
import org.openqa.selenium.By;



public class ErrorPage extends AbstractPage {

    public boolean isErrorPageBlockPresent() {
        waitForPageToLoadAndJQueryProcessing();
        return !findElements(By.id("co_404Box")).isEmpty();
    }

}
