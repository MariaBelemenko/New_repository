package com.thomsonreuters.should.step_definitions.search.knowhow;

import com.thomsonreuters.should.step_definitions.BaseStepDef;
import cucumber.api.java.en.Then;

import java.awt.*;

public class KnowHowDeliveryTest extends BaseStepDef {

    @Then("^the user pauses for \"(.*?)\" seconds$")
    public void theUserPausesForSeconds(Integer timeToWait) throws Throwable {
        Robot robot = new Robot();
        timeToWait = timeToWait * 1000;
        robot.delay(timeToWait);
    }
}
