package search;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

/**
 * Created by Mariya_Belemenko on 3/22/2016.
 */
public class SearchSteps extends BaseSelenium {
    private static final Logger logger = LogManager.getLogger(SearchSteps.class.getName());
    private WorkWithTheCart good = new WorkWithTheCart(driver);
    private File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

    @Given("^The user sets language to English$")
    public void iSetLanguage() {
        good.editLanguage();
        good.setLanguage();
        logger.info("Language has been set to English");
    }

    @And("^he enters \"([^\"]*)\" in the searching field$")
    public void iSetSearchRequest(String nameOfGood) {
        good.editGood(nameOfGood);
        logger.info("Name of the good has been added to the search field");
    }

    @When("^he presses a button 'Search'$")
    public void iSearchRequest() {
        good.findGood();
        logger.info("Button 'Search' has been pressed");
    }

    @Then("^ensure \"([^\"]*)\" has been searched correctly$")
    public void iCheckSearchRequest(String nameOfTheGood) throws IOException {
        Assert.assertTrue(good.getGood().equals(nameOfTheGood));
        if (good.getGood().equals(nameOfTheGood)) {
            logger.info("The good has been searched correctly");
        } else {
            logger.info("The good has not been searched correctly");
            FileUtils.copyFile(srcFile, new File("target/screenshots/positive_search.png"));
        }
    }

    @Then("^ensure \"([^\"]*)\" has not been searched$")
    public void iCheckSearchRequestNegative(String nameOfTheGood) throws IOException {
        Assert.assertNotEquals(good.getGood(), nameOfTheGood);
        if (good.getGood().equals(nameOfTheGood)) {
            FileUtils.copyFile(srcFile, new File("target/screenshots/positive_search.png"));
        } else {
            logger.info("The good has not been searched correctly");
        }
    }
}

