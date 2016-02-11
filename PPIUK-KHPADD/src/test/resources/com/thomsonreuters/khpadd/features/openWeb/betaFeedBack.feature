@manual
Feature: [771426][771456][771477][773264] Verify the beta Feedback form functionality

  Scenario: Verification of all the fields in the Beta feedback form and the Feedback button on all Beta pages
    Given a user has logged into PL+
    When the user has clicked the feedback button labelled "Beta Feedback"  on the PL+ page(Homepage, Practice Area Page, Resources page, Topic Page)
    Then the user is presented with the feedback form with the following fields
      | Name of tester (created automatically from User first name + User last name) but can be edited                                                  |
      | User name (automatically populate this as user is logged in with UN/PW?)                                                        |
      | Email address (automatically populate with users email address)                                                                 |
      | Page (this field to be automatically populated according to the page that the user is on when they press the ‘feedback button’) |
      | Feedback (text field – unlimited)                                                                                               |
      | Steps taken immediately prior to issue – please give as much detail as possible (text field – unlimited)                        |
      | Additional comments (text field – unlimited)                                                                                    |
      | ‘Submit’ button                                                                                                                 |
      | ‘Close window’ button (less prominent & away from the ‘Submit’ button)                                                          |
    When the user clicks on the submit button
    Then the feedback should be sent along with a confirmation message 'The feedback was successfully submitted' and a OK button
    And user resumes to view PL+ after clicking on the OK button
    And the feedback is received in an email account "betafeedback@thomsonreuters.com"

  Scenario: Verification of the Close feedback form (Bug#781259 associated with this scenario has been deferred by business)
    Given a user is on a beta page in the PL+ website
    And the user has opened the feedback form
    And the user has provided information in the feedback form
    When the user clicks the close button
    Then a dialog box is generated with the text "All changes will be lost. Do you really want to cancel feedback?"
    And the dialog box presents an OK button
    And the dialog box presents a cancel box
    When the user clicks OK
    Then the dialog box and feedback forms are closed
    When If the user clicks the Cancel button
    Then the dialog box is closed
    And the user is returned to their feedback form



