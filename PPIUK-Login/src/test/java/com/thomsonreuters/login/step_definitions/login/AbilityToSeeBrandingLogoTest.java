package com.thomsonreuters.login.step_definitions.login;

import com.thomsonreuters.login.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.common.CommonMethods;
import com.thomsonreuters.pageobjects.pages.login.OnepassLogin;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AbilityToSeeBrandingLogoTest extends BaseStepDef {

    private OnepassLogin onepassLogin = new OnepassLogin();
    private CommonMethods comMethods = new CommonMethods();

    @Then("^user should see company logo on Login page$")
    public void userShouldSeeCompanyLogoOnLoginPage() {
        WebElement image = onepassLogin.logoImage();
        Assert.assertTrue("Logo image is not loaded", comMethods.isImageLoaded(image));
    }

    @Then("^user should see three images near Login box$")
    public void userShouldSeeThreeImagesNearLoginBox() {
        List<WebElement> images = onepassLogin.marketingImages();
        if (images.size() != 3) {
            throw new RuntimeException("Could not find 3 images on login page: found " + images.size());
        }
        for (int i = 0; i < images.size(); i++) {
            boolean loaded = comMethods.isImageLoaded(images.get(i));
            Assert.assertTrue("Image " + (i + 1) + " of 3 is not loaded", loaded);
        }
    }

    @Then("^image \"(\\d+)\" should lead to \"(.+?)\"$")
    public void imageShouldLeadTo(String index, String expectedUrl) {
        int idx = Integer.valueOf(index);
        List<WebElement> links = onepassLogin.marketingLinks();
        WebElement link = links.get(idx - 1);
        String linkUrl = link.getAttribute("href");
        Assert.assertEquals("Link url for image number " + index
                + " is not as expected", expectedUrl.trim(), linkUrl.trim());
    }

}
