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
public class DeleteFromTheCartSteps extends BaseSelenium {
    static final Logger logger = LogManager.getLogger(DeleteFromTheCartSteps.class.getName());
    private WorkWithTheCart good = new WorkWithTheCart(driver);
    private LoginPage login = new LoginPage(driver);

    @Given("^he presses button 'Save for future'$")
    public void iSaveForFuture() {
        good.saveTheGoodForFuture();
        logger.info("Button 'Save for future' has been pressed");
    }

    @When("^he edits \"([^\"]*)\" into the field 'Login'$")
    public void iEditLogin(String log) {
        login.editLogin(log);
        logger.info("Login of the user has been edited");
    }

    @And("^he edits \"([^\"]*)\" into the field 'Password'")
    public void iEditPassword(String pwd) {
        login.editPassword(pwd);
        logger.info("Password of the user has been edited");
    }

    @And("^he submits his personal information$")
    public void iSubmitPersonalInformation() {
        login.submitPersonalInformation();
        logger.info("Personal information of the user has been submitted");
    }

    @And("^ensure \"([^\"]*)\" has been successfully removed to 'Saved goods'$")
    public void iCheckRemovedForFuture(String expectPhrase) {
        Assert.assertEquals(good.getResultsOfRemovingTheGood(), expectPhrase);
    }

    @And("^he presses button 'Delete the good from the cart'$")
    public void iDeleteFromTheCart() {
        good.deleteGoodFromTheCart();
        logger.info("Button 'Delete from the cart' has been pressed");
    }

    @And("^he presses button 'Show the cart'$")
    public void iShowCart() {
        good.showTheCart();
        logger.info("Button 'Show the cart' has been pressed");
    }

    @Then("^ensure \"([^\"]*)\" his cart is empty$")
    public void iCheckTheCartWithDeletedGood(String expectPhrase) {
        Assert.assertEquals(good.getResultsOfDeletingTheGood(), expectPhrase);
    }

    @Then("^ensure \"([^\"]*)\" his cart doesn't consist anything$")
    public void iCheckTheCartWithDeletedGoodNegative(String expectPhrase) {
        Assert.assertNotEquals(good.getResultsOfDeletingTheGood(), expectPhrase);
    }
}
