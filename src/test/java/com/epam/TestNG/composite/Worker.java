package com.epam.TestNG.composite;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by Mariya_Belemenko on 6/27/2016.
 */
public class Worker implements Employee {

    private String name;
    private int happiness;
    private static final Logger LOG = LogManager.getLogger(Worker.class.getName());

    public Worker(String name, int happiness) {
        this.name = name;
        this.happiness = happiness;
    }

    public void showHappiness() {
        LOG.info(name + " showed happiness level of " + happiness);
    }
}
