package search;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Mariya_Belemenko on 3/23/2016.
 */
public class WorkWithTheCart {
    private WebDriver driver;

    @FindBy(xpath = "//a[@id = 'gh-eb-Geo-a-default']")
    private WebElement editLanguage;

    @FindBy(xpath = "//span[text() = 'English']")
    private WebElement buttonSetLanguage;

    @FindBy(xpath = "//input[@id = 'gh-ac']")
    private WebElement fieldSearch;

    @FindBy(xpath = "//input[@id = 'gh-btn']")
    private WebElement buttonSearch;

    @FindBy(xpath = "//a[text() = 'Luxury Aluminum Ultra-thin Mirror Metal Case Cover for iPhone 5/ 5s/ 6/ 6+ Plus']")
    private WebElement linkNameOfTheGood;

    @FindBy(xpath = "//img[@alt = 'Luxury Aluminum Ultra-thin Mirror Metal Case Cover for iPhone 5/ 5s/ 6/ 6+ Plus']")
    private WebElement imageGood;

    @FindBy(xpath = "//select[@id = 'msku-sel-1']")
    private WebElement checkboxColor;

    @FindBy(xpath = "//select[@id = 'msku-sel-2']")
    private WebElement checkboxModel;

    @FindBy(xpath = "//select[@id = 'msku-sel-3']")
    private WebElement checkboxGlassScreenProtector;

    @FindBy(xpath = "//a[@id = 'isCartBtn_btn']")
    private WebElement buttonAddToTheCart;

    @FindBy(xpath = "//a[text() = 'Remove']")
    private WebElement buttonDeleteFromTheCart;

    @FindBy(xpath = "//i[@id = 'gh-cart-i']")
    private WebElement buttonShowTheCart;

    @FindBy(xpath = "//a[text() = 'Save for later']")
    private WebElement buttonSaveForFuture;

    @FindBy(xpath = "//div[@class = 'fw-b']")
    private WebElement linkYourCart1;

    @FindBy(xpath = "//span[text() = ' has been saved for later.']")
    private WebElement linkYourCart2;

    @FindBy(xpath = "//a[text() = 'Luxury Aluminum Ultra-thin Mirror Metal Case Cover for iPhone 5/ 5s/ 6/ 6+ Plus']")
    private WebElement linkNameOfGood;

    public WorkWithTheCart(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Edit language
    public void editLanguage() {
        editLanguage.click();
    }

    //Set language to English
    public void setLanguage() {
        buttonSetLanguage.click();
    }

    //Edit a name of a good for searching
    public void editGood(String nameOfGood) {
        fieldSearch.sendKeys(nameOfGood);
    }

    //Press button "Search"
    public void findGood() {
        fieldSearch.click();
        buttonSearch.click();
    }

    //Press on an image of the good
    public void showGoodDetails() {
        imageGood.click();
    }

    //Get a name of the searched good
    public String getGood() {
        return linkNameOfTheGood.getText();
    }

    //Choose color of the good
    public void chooseColor(String color) {
        checkboxColor.sendKeys(color);
    }

    //Choose model of the good
    public void chooseModel(String model) {
        checkboxModel.sendKeys(model);
    }

    //Choose a glass screen protector for the good
    public void chooseGlassScreenProtector(String protector) {
        checkboxGlassScreenProtector.sendKeys(protector);
    }

    //Press button "Add to cart"
    public void addGoodToCart() {
        buttonAddToTheCart.click();
    }

    //Press button "Delete from the cart"
    public void deleteGoodFromTheCart() {
        buttonDeleteFromTheCart.click();
    }

    //Press button "Cart"
    public void showTheCart() {
        buttonShowTheCart.click();
    }

    //Press button "Save for future"
    public void saveTheGoodForFuture() {
        buttonSaveForFuture.click();
    }

    //Get a name of the good
    public String getNameOfTheGood() {
        return linkNameOfGood.getText();
    }

    //Get results of deleting the good
    public String getResultsOfDeletingTheGood() {
        return linkYourCart1.getText();
    }

    //Get results of removing the good to "Saved for future" goods
    public String getResultsOfRemovingTheGood() {
        return linkYourCart2.getText();
    }
}
