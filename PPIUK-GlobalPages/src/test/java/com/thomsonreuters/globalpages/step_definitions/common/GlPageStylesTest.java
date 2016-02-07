package com.thomsonreuters.globalpages.step_definitions.common;

import com.thomsonreuters.globalpages.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.utils.globalPage.GlobalPageUtils;
import cucumber.api.java.en.Then;

import static org.junit.Assert.assertEquals;

public class GlPageStylesTest extends BaseStepDef {

    private GlobalPageUtils globalPageUtils = new GlobalPageUtils();

    @Then("^the \"(.*?)\" line has the \"(.*?)\" style$")
    public void theLineHasTheStyle(String number, String style) throws Throwable {
        assertEquals("The " + number + " line hasn't the " + style + " style",
                globalPageUtils.getLineStyle(Integer.parseInt(number)), style);
    }

    @Then("^the header \"(.*?)\" with tag \"(.*?)\" has \"(.*?)\" font size$")
    public void theHeaderWithTagHasFontSize(String header, String tag, String fontSize) throws Throwable {
        assertEquals("The " + header + " header has incorrect font size", globalPageUtils.getTextFontSize(header, tag), fontSize);
    }

    @Then("^the value of paddong-bottom style of links is \"(.*?)\"$")
    public void theValueOfPaddongBottomStyleOfLinksIs(String value) throws Throwable {
        assertEquals("The value of padding bottom style of links is not correct", globalPageUtils.getPaddongBottomStyle(), value);
    }

}
