package com.epam.TestNG.multithread;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by Mariya_Belemenko on 6/27/2016.
 */
public class MainThread {
    private static MyThread thread;

    private static final Logger LOG = LogManager.getLogger(MyThread.class.getName());

    public static void main(String[] args) {
        thread = new MyThread();

        Thread myThread = new Thread(thread);
        myThread.start();

        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                LOG.info("'Interrupted exception occured'", e);
            }

            LOG.info("Main thread is working");
        }
        if (myThread.isAlive()) {
            try {
                myThread.join();
            } catch (InterruptedException e) {
                LOG.info("'InterruptedException' occured", e);
            }

            LOG.info("Main thread is the first!");
        } else {
            System.out.println("The additional thread is the first!");
        }
    }
}
