package tests;

import org.testng.Assert;
import org.testng.annotations.*;

/**
 * Created by Mariya_Belemenko on 6/16/2016.
 */

@Listeners(Listener.class)
public class Tests extends Listener {
    @DataProvider(name = "calculatorDataProvider")
    public Object[][] simpleDataProvider() {
        return new Object[][]{
                {11, 22, 33},
        };
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("Before class");
    }

    @BeforeMethod
    public void preCondition() {
        System.out.println("Before each test method");
    }

    @Test(groups = {"Group1"}, alwaysRun = true)
    @Parameters(value = {"value1", "value2", "result"})
    public void checkParameters1(int value1, int value2, int result) {
        System.out.println("The first test method");
        Calculator calculator = new Calculator(value1, value2);
        int res = calculator.getResult();
        Assert.assertTrue(res == result, "The result(" + res + ") is not equal to " + result);
    }

    @Test(groups = {"Group1"}, dependsOnMethods = "checkParameters1")
    @Parameters(value = {"value1", "value2", "result", "url"})
    public void checkParameters2(int value1, int value2, int result, @Optional String url) {
        System.out.println("The second test method");
        System.out.println("URL: ".concat(url));
        Calculator calculator = new Calculator(value1, value2);
        Assert.assertTrue(calculator.getResult() == result, "The result(" + calculator.getResult() + ") is not equal to " + result);
    }

    @Test(dependsOnGroups = "Group1", dataProvider = "calculatorDataProvider")
    public void checkParameters3(int FirstArg, int SecondArg, int result) {
        System.out.println("The third test method");
        Calculator calculator = new Calculator(FirstArg, SecondArg);
        Assert.assertEquals(calculator.getResult(), result, "The result(" + calculator.getResult() + ") is not equal to " + result);
    }

    @AfterMethod
    public void afterTestMethod() {
        System.out.println("After each test method");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("After class");
        driver.close();
    }
}
