package com.thomsonreuters.should.step_definitions.khpadd;

import com.thomsonreuters.pageobjects.pages.plPlusKnowHowResources.KHResourcePage;
import com.thomsonreuters.should.step_definitions.BaseStepDef;
import cucumber.api.java.en.Then;
import org.hamcrest.core.Is;
import org.openqa.selenium.By;

import static org.hamcrest.MatcherAssert.assertThat;

public class AuthorAndExternalLinksTest extends BaseStepDef {

    private KHResourcePage resourcePage = new KHResourcePage();

    @Then("^author name \"(.*?)\" is displayed underneath the document title$")
    public void authorNameIsDisplayedUnderneathTheDocumentTitle(String authorName) throws Throwable {
        assertThat(resourcePage.author().getText().trim(), Is.is(authorName));
    }

    @Then("^clicking on (author|external) link \"(.*?)\" opens in (new|same) window$")
    public void authorLinkOpensInNewWindow(String authorOrExternal, String link, String windowType) throws Throwable {
        switch (windowType) {
            case "new":
                String currentWindowHandle = resourcePage.getWindowHandle();
                if (authorOrExternal.equalsIgnoreCase("external")) {
                    try {
                        resourcePage.contentBody().findElement(By.linkText(link)).click();
                    } catch (Exception e) {
                        resourcePage.contentBody().findElement(By.linkText(link)).click();
                    }
                } else {
                    resourcePage.author().findElement(By.linkText(link)).click();
                }
                resourcePage.switchToWindow(currentWindowHandle);
                resourcePage.clickOnSuspendBillingContinueButton();
                break;
            case "same":
                String documentTitle = resourcePage.title().getText().trim();
                resourcePage.author().findElement(By.linkText(link)).click();
                resourcePage.browserGoBack();
                assertThat(resourcePage.title().getText().trim(), Is.is(documentTitle));
                break;
            default:
                break;
        }
    }

}
