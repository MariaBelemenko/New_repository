package com.epam.TestNG.hook;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by Mariya_Belemenko on 6/24/2016.
 */
public class ShutdownHook {
    private static final Logger LOG = LogManager.getLogger(ShutdownHook.class.getName());

    public void attachShutdownHook() {
        Runtime.getRuntime().addShutdownHook(
                new Thread() {
                    @Override
                    public void run() {
                        LOG.info("Shutdown hook is running");
                    }
                });
    }
}
