package com.thomsonreuters.fastdraft.step_definitions.common;

import com.thomsonreuters.fastdraft.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.otherPages.NavigationCobalt;
import com.thomsonreuters.pageobjects.pages.fastDraft.AddressBookPage;
import com.thomsonreuters.pageobjects.pages.fastDraft.Header;
import com.thomsonreuters.pageobjects.pages.fastDraft.QuestionPage;
import com.thomsonreuters.pageobjects.utils.fastDraft.FastDraftUtils;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertTrue;

public class FastDraftparallelTest extends BaseStepDef {

    private NavigationCobalt navigationCobalt = new NavigationCobalt();
    private Header header = new Header();
    private AddressBookPage addressBookPage = new AddressBookPage();
    private FastDraftUtils fastDraftUtils = new FastDraftUtils();
    private QuestionPage questionPage = new QuestionPage();

    @When("^the user goes to View all FastDraft items$")
    public void goViewAllFDForLecagy() {
        navigationCobalt.navigate("http://d" + System.getProperty("base.legacy.url") + "-infra.dev.practicallaw.com:8080/da/");
    }

    @When("^the user goes Address book$")
    public void goAddressBook() throws Throwable {
        header.addressBook().click();
        header.waitForPageToLoad();
    }

    @When("^creates new person contact with details title \"([^\"]*)\", first name \"([^\"]*)\", second name \"([^\"]*)\" and email \"([^\"]*)\"$")
    public void createNewContact(String title, String firstName, String secondName, String email) throws Throwable {
        String contactName = firstName + " " + secondName;
        /** remove, if the same contact is present */
        if (addressBookPage.isContactPresents(contactName)) {
            fastDraftUtils.removeContactFromAddressBook(contactName);
        }
        fastDraftUtils.createNewPersonContact(title, firstName, secondName, email);
    }

    @Then("^the contact \"([^\"]*)\" presents in Address book$")
    public void checkContactPresents(String contact) throws Throwable {
        addressBookPage.waitForPageToLoad();
        assertTrue("Contact is absent in Addressbook", addressBookPage.isContactPresents(contact));
    }

    @When("^the user closes Address book$")
    public void closeAddressBook() throws Throwable {
        addressBookPage.closeAddressBook().click();
        addressBookPage.waitForPageToLoad();
    }

    @When("^the user updates contact \"([^\"]*)\" with \"([^\"]*)\"$")
    public void addContactFromAddressBook(String contactToUpdate, String contactToSet) throws Throwable {
        fastDraftUtils.updatePersonFromAddressBook(contactToUpdate, contactToSet);
    }

    @Then("^the contact \"([^\"]*)\" has \"([^\"]*)\" value$")
    public void checkContactHasValue(String contactToUpdate, String contactToSet) throws Throwable {
        questionPage.waitForPageToLoad();
        questionPage.checkContactHasValue(contactToUpdate, contactToSet);
    }

    @Then("^there is remove \"([^\"]*)\" button in \"([^\"]*)\"$")
    public void removeContactButtonPresents(String contactToSet, String contactToUpdate) throws Throwable {
        questionPage.waitForPageToLoad();
        questionPage.checkRemoveContactButtonPresents(contactToUpdate, contactToSet);
    }

    @When("^the user removes contact \"([^\"]*)\" from Address book$")
    public void removeContact(String contact) throws Throwable {
        fastDraftUtils.removeContactFromAddressBook(contact);
    }

    @Then("^the contact \"([^\"]*)\" absents in Address book$")
    public void checkContactAbsents(String contact) throws Throwable {
        addressBookPage.waitForPageToLoad();
        assertTrue("Contact is present in Addressbook", addressBookPage.isContactAbsent(contact));
    }

}
