package search;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Mariya_Belemenko on 3/24/2016.
 */
public class LoginPage {
    private WebDriver driver;

    @FindBy(xpath = "//input[@class = 'fld']")
    private WebElement editLogin;

    @FindBy(xpath = "//input[@placeholder = 'Password']")
    private WebElement editPassword;

    @FindBy(xpath = "//input[@id = 'sgnBt']")
    private WebElement submitPersonalInformation;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Edit login
    public void editLogin(String login) {
        editLogin.sendKeys(login);
    }

    //Edit password
    public void editPassword(String password) {
        editPassword.sendKeys(password);
    }

    //Submit personal information
    public void submitPersonalInformation() {
        submitPersonalInformation.click();
    }
}
