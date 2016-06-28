package com.epam.TestNG.multithread;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static java.lang.Thread.sleep;

/**
 * Created by Mariya_Belemenko on 6/27/2016.
 */
public class MyThread implements Runnable {
    private static final Logger LOG = LogManager.getLogger(MyThread.class.getName());

    public void run() {
        LOG.info("The additional thread is working");
        for (int i = 0; i < 5; i++) {
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                LOG.info("'InterruptedException' occured", e);
            }

            LOG.info("Second thread");
        }
    }
}
