package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by Mariya_Belemenko on 6/16/2016.
 */
public class Calculator {

    private static final Logger LOG = LogManager.getLogger(Calculator.class.getName());
    private int first;
    private int second;

    public Calculator(int first, int second) {
        this.first = first;
        this.second = second;
    }

    public int getResult(){
        LOG.info("Getting sum of two counts");
        return first + second;
    }
}
