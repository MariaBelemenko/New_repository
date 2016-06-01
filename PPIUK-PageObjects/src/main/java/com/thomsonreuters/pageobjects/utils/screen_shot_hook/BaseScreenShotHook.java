package com.thomsonreuters.pageobjects.utils.screen_shot_hook;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

import com.thomsonreuters.driver.framework.ScreenShots;
import com.thomsonreuters.pageobjects.common.ExcelFileReader;
import com.thomsonreuters.pageobjects.common.PageActions;
import com.thomsonreuters.pageobjects.otherPages.NavigationCobalt;
import com.thomsonreuters.pageobjects.rest.service.impl.RestServiceFFHImpl;
import com.thomsonreuters.pageobjects.utils.TimeoutUtils;

import cucumber.api.Scenario;

public class BaseScreenShotHook extends BaseStepDef {

	protected static final Logger LOG = LoggerFactory.getLogger(BaseScreenShotHook.class);

	private static final String BASE_ELEMENT_XPATH = "//body//div";

	private static final int WAIT_FOR_PAGE_LOADING_TIMEOUT_SEC = 60;

	private RestServiceFFHImpl restServiceFFHImpl = new RestServiceFFHImpl();
	private PageActions pageActions = new PageActions();
	private NavigationCobalt navigationCobalt = new NavigationCobalt();

	public void deleteCookies() {
		LOG.info("Deleting cookies");
		navigationCobalt.deleteAllCookies();
		resetCurrentUser();
	}

	/**
	 * Takes screen-shot if the scenario fails
	 *
	 * @param scenario
	 */
	public void afterTest(Scenario scenario) throws InterruptedException {
		LOG.info("Taking screenshot if test failed");
		if (!System.getProperty("driverType").equalsIgnoreCase("browserStack")) {
			try {
				Map<String, Object> screenShots = ScreenShots.getScreenShotsForCurrentTest();
				for (Map.Entry<String, Object> screenShot : screenShots.entrySet()) {
					scenario.write(screenShot.getKey());
					scenario.embed((byte[]) screenShot.getValue(), "image/png");
				}
				ScreenShots.tidyUpAfterTestRun();

				if (scenario.isFailed()) {
					scenario.write(navigationCobalt.getCurrentUrl());
					//if blank page is present  - log error and wait
					if (!navigationCobalt.isExists(By.xpath(BASE_ELEMENT_XPATH))) {
						LOG.error(
								String.format(
										"Page has no base element (%s), probably loading operation is in progress."
												+ " Attempt to wait until all elements will be loaded",
										BASE_ELEMENT_XPATH));
						TimeoutUtils.sleepInSeconds(WAIT_FOR_PAGE_LOADING_TIMEOUT_SEC);
					}
					byte[] screenShot = ((TakesScreenshot) navigationCobalt.getDriver)
							.getScreenshotAs(OutputType.BYTES);
					scenario.embed(screenShot, "image/png");
					LOG.info(navigationCobalt.getPageSource());
					logCurrentSessionId(scenario);
					signOffCobalt();
					resetCurrentUser();
				}
			} catch (WebDriverException | IOException e) {
				LOG.error(e.getMessage());
			}
		}
	}

	/**
	 * Log session ID of current user to report and console output. If some
	 * server errors will occurred, then exception stack trace will be print to
	 * output and nothing to report.
	 *
	 * @param scenario
	 *            Current test scenario
	 */
	private void logCurrentSessionId(Scenario scenario) {
		try {
			String logText = "<br><b>Session ID:</b> " + restServiceFFHImpl.getCurrentSession() + "";
			LOG.info(logText);
			scenario.write(logText);
		} catch (HttpClientErrorException | HttpServerErrorException ex) {
			LOG.info(
					"Error occurred at attempt to obtain Session Id of current user. Maybe he is not authorized now. Exception: ",
					ex);
		}
	}

	private void signOffCobalt() throws IOException, InterruptedException {
		LOG.info("Sign-off cobalt user");
		WebElement element = null;
		try {
			if (currentUser.getProduct() != null) {
				switch (currentUser.getProduct()) {
				case WLN:
					element = navigationCobalt.findElement(By.linkText("Sign Off"));
					break;
				case PLC:
					pageActions.mouseOver(navigationCobalt.findElement(By.xpath("//*[@id='preferences-dropdown']")));
					element = navigationCobalt.findElement(By.linkText("Sign out"));
					break;
				case ANZ:
					pageActions.mouseOver(navigationCobalt.findElement(By.xpath("//*[@id='preferences-dropdown']")));
					element = navigationCobalt.findElement(By.linkText("Sign out"));
					break;
				case PLC_lEGACY:
					navigationCobalt.navigateToPLCLegacy();
					element = navigationCobalt.findElement(By.linkText("Log out"));
					break;
				default:
					break;
				}
				element.click();
			} else {
				LOG.error("Current user's product is null");
			}
		} catch (NoSuchElementException | ElementNotVisibleException nse) {
			LOG.error("Sign-Off link not found");
		} finally {
			deleteCookies();
			ExcelFileReader.unlockUser(currentUser.getUserName());
		}
	}

	public boolean newSession() {
		return System.getProperty("newSession").equalsIgnoreCase("true");
	}
}