package com.epam.TestNG.composite;

import org.testng.annotations.Test;

/**
 * Created by Mariya_Belemenko on 6/27/2016.
 */
public class CompositeExample {
    @Test
    public void testComposite() {
        Worker workerTom = new Worker("Worker Tom", 5);
        Worker workerJack = new Worker("Worker Jack", 8);

        Supervisor supervisorMary = new Supervisor("Supervisor Mary", 6);
        Supervisor supervisorJerry = new Supervisor("Supervisor Jerry", 7);
        Supervisor supervisorBob = new Supervisor("Supervisor Bob", 9);

        supervisorMary.addSubordinate(workerTom);
        supervisorBob.addSubordinate(workerJack);

        supervisorJerry.addSubordinate(supervisorMary);
        supervisorJerry.addSubordinate(supervisorBob);

        supervisorJerry.showHappiness();
    }
}
