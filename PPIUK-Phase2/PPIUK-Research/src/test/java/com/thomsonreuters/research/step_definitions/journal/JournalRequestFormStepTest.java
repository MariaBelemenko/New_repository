package com.thomsonreuters.research.step_definitions.journal;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import com.thomsonreuters.driver.exception.PageOperationException;
import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document.JournalDocumentPage;
import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document.JournalRequestFormPage;
import com.thomsonreuters.pageobjects.utils.email.EmailMessageUtils;
import com.thomsonreuters.pageobjects.utils.email.Mailbox;
import com.thomsonreuters.pageobjects.utils.email.MailboxFactory;
import com.thomsonreuters.research.step_definitions.BaseStepDef;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.mail.Message;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;

public class JournalRequestFormStepTest extends BaseStepDef {

	private JournalDocumentPage journalPage = new JournalDocumentPage();
	private JournalRequestFormPage journalRequestForm = new JournalRequestFormPage();
	private EmailMessageUtils emailMessageUtils = new EmailMessageUtils();

	private static String REQUIRED = "(required)";
	private static String DISABLED_ATTR = "disabled";
	private static String DISABLED_CLASS = "co_disabled";
	private static String CLASS = "class";

	private static int THREE_MINUTES = 60 * 3;
	private static int TEN_SECONDS = 10;

	private ThreadLocal<Map<FormFields, String>> formDataMap = new ThreadLocal<Map<FormFields, String>>() {
		@Override
		protected Map<FormFields, String> initialValue() {
			return new HashMap<FormFields, String>();
		};
	};

	private enum FormFields {
		DOCUMENT_CITATION("Document citation", "Document Citation"),
		NAME("Name", "Name"),
		ORGANISATION("Organisation", "Organisation"),
		TELEPHONE("Telephone", "Telephone"),
		EMAIL("E-mail", "Email"),
		FAX("Fax", "FaxNumber"),
		DX("DX", "DXNumber"),
		ADDRESS1("Address 1", "Address1"),
		ADDRESS2("Address 2", "Address2"),
		TOWNCITY("Town/City", "TownCity"),
		COUNTYSTATE("County/State", "State"),
		COUNTRY("Country", "Country"),
		POSTCODE("Postcode", "Postcode");

		private FormFields(String formName, String emailName) {
			this.formName = formName;
			this.emailName = emailName;
		}

		private String formName;
		private String emailName;

		public String getFormName() {
			return formName;
		}

		public String getEmailName() {
			return emailName;
		}

		public static FormFields getByFormName(String formName) {
			for (FormFields value : values()) {
				if (value.getFormName().equalsIgnoreCase(formName)) {
					return value;
				}
			}
			return null;
		}
	}

	@Then("^the user should(| not) see button with text \"(.+)\" within the document$")
	public void theUserShouldSeeButtonWithTextWithinTheDocument(String not, String text) {
		boolean buttonExpected = !not.contains("not");
		boolean buttonPresent = false;
		try {
			WebElement button = journalPage.buttonInDocumentWithValue(text);
			buttonPresent = button != null;
		} catch (ElementNotVisibleException | ElementNotFoundException | PageOperationException | TimeoutException e) {
			buttonPresent = false;
		}
		assertEquals("Full text button is" + not + " expected to be displayed", buttonExpected, buttonPresent);
	}

	@When("^the user clicks on button with text \"(.+)\" within the document$")
	public void theUserClicksOnTheRequestFullTextButton(String text) {
		journalPage.buttonInDocumentWithValue(text).click();
	}

	@Then("^the user should see request form popup with title \"(.+)\"$")
	public void theUserShouldSeeRequestFormPopupWithTitle(String title) {
		assertTrue("The form title is '" + journalRequestForm.widgetTitle().getText() + "', while expected '" + title + "'",
				journalRequestForm.widgetTitle().getText().contains(title));
	}

	@Then("^the following lines should be present on the request form$")
	public void theTextIsPresentOnTheRequestForm(List<String> lines) {
		String formText = journalRequestForm.widget().getText();
		SoftAssertions softly = new SoftAssertions();
		for (String line : lines) {
			softly.assertThat(formText.contains(line)).describedAs("The text '" + line + "' is not present on the form").isTrue();
		}
		softly.assertAll();
	}

	@Then("^the following fields should have Required marks$")
	public void theFollowingFieldsShouldHaveRequiredMarks(List<String> fields) {
		SoftAssertions softly = new SoftAssertions();
		for (String field : fields) {
			softly.assertThat(journalRequestForm.formFieldLabel(field).getText().contains(REQUIRED))
					.describedAs("The field '" + field + "' is not marked as required").isTrue();
		}
		softly.assertAll();
	}

	@Then("^the following fields should be prepopulated with values$")
	public void theFollowingFieldsShouldBePrepopulatedWithValues(DataTable dataTable) {
		SoftAssertions softly = new SoftAssertions();
		for (Map.Entry<String, String> entry : dataTable.asMap(String.class, String.class).entrySet()) {
			String actualValue = journalRequestForm.formField(entry.getKey()).getAttribute("value").trim();
			softly.assertThat(entry.getValue().equals(actualValue))
					.describedAs("The field '%s' has value '%s', while expected '%s'", entry.getKey(), actualValue, entry.getValue())
					.isTrue();
			formDataMap.get().put(FormFields.getByFormName(entry.getKey()), entry.getValue());
		}
		softly.assertAll();
	}

	@When("^the user fills in the following fields$")
	public void theUserFillsInTheFollowingFields(DataTable dataTable) {
		for (Map.Entry<String, String> entry : dataTable.asMap(String.class, String.class).entrySet()) {
			journalRequestForm.formField(entry.getKey()).clear();
			journalRequestForm.formField(entry.getKey()).sendKeys(entry.getValue());
			formDataMap.get().put(FormFields.getByFormName(entry.getKey()), entry.getValue());
		}
	}

	@Then("^the following fields should be disabled$")
	public void theFollowingFieldsShouldBeDisabled(List<String> fields) {
		SoftAssertions softly = new SoftAssertions();
		for (String field : fields) {
			String disabled = journalRequestForm.formField(field).getAttribute(DISABLED_ATTR);
			softly.assertThat(disabled).describedAs("The field '" + field + "' is not disabled").isNotNull();
		}
		softly.assertAll();
	}

	@Then("^the following fields should not be visible$")
	public void theFollowingFieldsShouldNotBeVisible(List<String> fields) {
		for (String field : fields) {
			try {
				boolean displayed = journalRequestForm.formField(field).isDisplayed();
				assertFalse("The field '" + field + "' is displayed", displayed);
			} catch (ElementNotVisibleException | ElementNotFoundException | PageOperationException e) {
			}
		}
	}

	@When("^the user selects preferred delivery method \"(.+)\"$")
	public void theUserSelectsPreferredDeliveryMethod(String method) {
		journalRequestForm.radioButton(method).click();
	}

	@Then("^the button \"(.+)\" is disabled$")
	public void buttonIsDisabled(String button) {
		assertTrue(button + " button is not disabled",
				journalRequestForm.buttonWithText(button).getAttribute(CLASS).contains(DISABLED_CLASS));
	}

	@When("^the user checks the agreement checkbox$")
	public void theUserChecksTheAgreementCheckbox() {
		journalRequestForm.agreeCheckbox().click();
	}

	@When("^the user clicks on button \"(.+)\"$")
	public void theUserClicksOnButton(String button) {
		journalRequestForm.buttonWithText(button).click();
	}

	@When("^the user clicks on close button$")
	public void theUserClicksOnCloseButton() {
		journalRequestForm.xButton().click();
	}

	@Then("^the request form popup disappears$")
	public void theRequestFormPopupDisappears() {
		try {
			boolean displayed = journalRequestForm.widget().isDisplayed();
			assertFalse("The request form is still displayed", displayed);
		} catch (ElementNotVisibleException | ElementNotFoundException | PageOperationException e) {
		}
	}

	@Then("^the user (accepts|declines) alert with message \"(.+)\"$")
	public void theAlertMessageIsDisplayed(String accepts, String message) {
		Alert alert = journalRequestForm.waitForAlertDialog();
		String alertMsg = alert.getText();
		assertTrue("The alert message is '" + alertMsg + "' while expected '" + message + "'", alertMsg.contains(message));
		if (accepts.equals("accepts")) {
			alert.accept();
		} else {
			alert.dismiss();
		}
	}

	@Then("^the admins receive an email at \"(.*?)\" from \"(.*?)\" with subject \"(.*?)\" with all the proper information$")
	public void adminsReceiveAnEmail(String adminEmail, String senderEmail, String subject) throws Throwable {
		Mailbox mailbox = MailboxFactory.getMailboxByEmail(adminEmail);
		Message message = mailbox.waitForMessageWithTitleAndSender(subject, senderEmail, THREE_MINUTES, TEN_SECONDS);
		SoftAssertions softly = new SoftAssertions();
		for (Entry<FormFields, String> pair : formDataMap.get().entrySet()) {
			String regex = pair.getKey().getEmailName() + ":\\s+" + pair.getValue().replaceAll("\\(", "\\\\(").replaceAll("\\)", "\\\\)");
			softly.assertThat(emailMessageUtils.isEmailContainsRegex(message, regex))
					.describedAs("The email does not contain pattern: " + regex)
					.isTrue();
		}
		softly.assertAll();
	}



}
