package search;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

/**
 * Created by Mariya_Belemenko on 3/22/2016.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        strict = true,
        plugin = {
                "pretty", "json:target/Cucumber.json",
                "html:target/cucumber-html-report"
        }
)

public class RunAcceptanceTest {
    @BeforeClass
    public static void initSelenium() {
        BaseSelenium.startBrowser();
    }

    @AfterClass
    public static void closeSelenium() {
        BaseSelenium.stopBrowser();
    }
}
