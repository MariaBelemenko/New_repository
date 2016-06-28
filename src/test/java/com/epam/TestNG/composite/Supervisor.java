package com.epam.TestNG.composite;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mariya_Belemenko on 6/27/2016.
 */
public class Supervisor implements Employee {

    private String name;
    private int happiness;
    private static final Logger LOG = LogManager.getLogger(Supervisor.class.getName());

    private List<Employee> subordinates = new ArrayList<Employee>();

    public Supervisor(String name, int happiness) {
        this.name = name;
        this.happiness = happiness;
    }

    public void addSubordinate(Employee employee) {
        subordinates.add(employee);
    }

    public void showHappiness() {
        LOG.info(name + " showed happiness level of " + happiness);
        for (Employee employee : subordinates) {
            employee.showHappiness();
        }
    }
}
