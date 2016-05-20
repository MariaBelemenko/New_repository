package com.thomsonreuters.annotations.step_definitions.common;

import com.thomsonreuters.pageobjects.pages.annotations.SharedAnnotationsPage;
import cucumber.api.java.en.When;
import static junit.framework.Assert.assertTrue;

public class TinyMceEditorTest extends AnnotationsTest {

    private SharedAnnotationsPage sharedAnnotationsPage = new SharedAnnotationsPage();
    public static String input;

    @When("^user shared the annotations with another contact \"(.*?)\"$")
    public void userSharedTheAnnotationsWithAnotherContact(String contact) throws Throwable {
        sharedAnnotationsPage.clickOnContactsLink();
        sharedAnnotationsPage.searchContact(getUserFullName(contact));
        sharedAnnotationsPage.selectContact(getUserNameStartswithLastName(contact));
        sharedAnnotationsPage.selectInsertButtonOnContactsPage();
        sharedAnnotationsPage.scrollToTinyMceEditor();
        sharedAnnotationsPage.saveAnnotation();
        assertTrue("Application having page loading issue", sharedAnnotationsPage.isMetaDataDispalyed(input));
    }
}
