package search;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;

/**
 * Created by Mariya_Belemenko on 3/29/2016.
 */
public class AddToCartSteps extends BaseSelenium {
    private static final Logger logger = LogManager.getLogger(AddToCartSteps.class.getName());
    private WorkWithTheCart good = new WorkWithTheCart(driver);

    @Given("^he presses on an image of the good$")
    public void iShowDetailsOfTheGood() {
        good.showGoodDetails();
        logger.info("Image of the good has been pressed");
    }

    @When("^he sets good's color to \"([^\"]*)\"$")
    public void iChooseColor(String color) {
        good.chooseColor(color);
        logger.info("Color of the good has been chosen");
    }

    @And("^he sets good's model to \"([^\"]*)\"$")
    public void iChooseModel(String model) {
        good.chooseModel(model);
        logger.info("Model of the good has been chosen");
    }

    @And("^he sets good's glass screen protector to \"([^\"]*)\"$")
    public void iChooseGlassScreenProtector(String protector) {
        good.chooseGlassScreenProtector(protector);
        logger.info("Screen protector has been chosen");
    }

    @And("^he presses a button 'Add to cart'$")
    public void iAddGoodToTheCart() {
        good.addGoodToCart();
        logger.info("Button 'Add to cart' has been pressed");
    }

    @And("^he presses button 'Cart' to see it's content$")
    public void iShowCartContent() {
        good.showTheCart();
        logger.info("Button 'Cart' has been pressed");
    }

    @Then("^ensure \"([^\"]*)\" is in the cart$")
    public void iCheckTheCart(String expectPhrase) {
        Assert.assertEquals(good.getNameOfTheGood(), expectPhrase);
    }

    @Then("^ensure \"([^\"]*)\" is not in the cart$")
    public void iCheckTheCartNegative(String expectPhrase) {
        Assert.assertNotEquals(good.getNameOfTheGood(), expectPhrase);
    }
}
