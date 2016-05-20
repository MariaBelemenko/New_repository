package com.thomsonreuters.annotations.step_definitions.common;

import com.thomsonreuters.pageobjects.pages.annotations.SharedAnnotationsPage;
import cucumber.api.java.en.When;

public class ProductViewAwarenessTest extends AnnotationsTest {

    private SharedAnnotationsPage sharedAnnotationsPage = new SharedAnnotationsPage();
    public static String input;

    @When("^highlight the text with cursor$")
    public void highlighTextWithCursor() throws Throwable {
        input = "input" + System.currentTimeMillis();
        sharedAnnotationsPage.amendInput(input);
        sharedAnnotationsPage.selectText();
    }
}
