package com.thomsonreuters.pageobjects.utils;

import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TimeoutUtils {

	protected static final Logger LOG = LoggerFactory.getLogger(TimeoutUtils.class);

	public static void sleepInSeconds(int timeoutInSeconds) {
		LOG.info(String.format("Sleeping %s seconds...", timeoutInSeconds));
		Sleeper.sleepTightInSeconds(timeoutInSeconds);
	}

}
