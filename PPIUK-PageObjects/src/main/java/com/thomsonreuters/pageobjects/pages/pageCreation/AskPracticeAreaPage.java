package com.thomsonreuters.pageobjects.pages.pageCreation;

import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document.DocumentDisplayAbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AskPracticeAreaPage extends DocumentDisplayAbstractPage {

    public WebElement askResourcesLink() {
        return waitForExpectedElement(By.id("coid_ask"));
    }

}