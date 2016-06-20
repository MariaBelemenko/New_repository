package search;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;

/**
 * Created by Mariya_Belemenko on 3/22/2016.
 */
public class SearchSteps extends BaseSelenium {
    private static final Logger logger = LogManager.getLogger(SearchSteps.class.getName());
    private WorkWithTheCart good = new WorkWithTheCart(driver);

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
    public void iCheckSearchRequest(String nameOfTheGood) {
        Assert.assertTrue(good.getGood().equals(nameOfTheGood));
    }

    @Then("^ensure \"([^\"]*)\" has not been searched$")
    public void iCheckSearchRequestNegative(String nameOfTheGood) {
        Assert.assertNotEquals(good.getGood(), nameOfTheGood);
    }
}

