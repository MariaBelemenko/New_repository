package search;

import cucumber.api.java.After;
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
 * Created by Mariya_Belemenko on 3/29/2016.
 */
public class DeleteFromTheCartSteps extends BaseSelenium {
    static final Logger logger = LogManager.getLogger(DeleteFromTheCartSteps.class.getName());
    private WorkWithTheCart good = new WorkWithTheCart(driver);
    private LoginPage login = new LoginPage(driver);
    private File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    private int signOfPass = 0;

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
    public void iCheckRemovedForFuture(String expectPhrase) throws IOException {
        Assert.assertEquals(good.getResultsOfRemovingTheGood(), expectPhrase);
        if (good.getResultsOfRemovingTheGood().equals(expectPhrase)) {
            signOfPass = 1;
        }
    }

    @After("@tagToIdentifyThatTheGoodHasBeenSuccessfullyDeletedFromTheCartPositive")
    private void iTakeScreenShotInCaseOfFailurePositive() throws IOException {
        if (signOfPass == 1) {
            logger.info("The good has been successfully removed to 'Saved goods'");
        } else {
            FileUtils.copyFile(srcFile, new File("target/screenshots/notSavedForLater.png"));
        }
    }

    @After("@tagToIdentifyThatTheGoodHasBeenSuccessfullyDeletedFromTheCartNegative")
    private void iTakeScreenShotInCaseOfFailureNegative() throws IOException {
        if (signOfPass == 1) {
            logger.info("The good has been successfully removed to 'Saved goods'");
        } else {
            FileUtils.copyFile(srcFile, new File("target/screenshots/notSavedForLater.png"));
        }
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
    public void iCheckTheCartWithDeletedGood(String expectPhrase) throws IOException {
        Assert.assertEquals(good.getResultsOfDeletingTheGood(), expectPhrase);
        if (good.getResultsOfDeletingTheGood().equals(expectPhrase)) {
            signOfPass = 1;
        }
    }

    @After("@tagToIdentifyThatTheGoodHasBeenSuccessfullyDeletedFromTheCartPositive")
    public void iTakeScreenshotInCaseOfFailurePositive() throws IOException {
        if (signOfPass == 1) {
            logger.info("The cart is empty");
        } else {
            logger.info("The cart is not empty!");
            FileUtils.copyFile(srcFile, new File("target/screenshots/emptyCart_positive.png"));
        }
    }

    @Then("^ensure \"([^\"]*)\" his cart doesn't consist anything$")
    public void iCheckTheCartWithDeletedGoodNegative(String expectPhrase) throws IOException {
        Assert.assertNotEquals(good.getResultsOfDeletingTheGood(), expectPhrase);
        if (good.getResultsOfDeletingTheGood().equals(expectPhrase)) {
            signOfPass = 2;
        }
    }

    @After("@tagToIdentifyThatTheGoodHasBeenSuccessfullyDeletedFromTheCartNegative")
    public void iTakeScreenshotInCaseOfFailureNegative() throws IOException {
        if (signOfPass != 2) {
            logger.info("The cart doesn't consist anything");
        } else {
            FileUtils.copyFile(srcFile, new File("target/screenshots/emptyCart_negative.png"));
        }
    }
}
