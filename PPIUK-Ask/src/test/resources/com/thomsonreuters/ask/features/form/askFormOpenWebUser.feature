Feature: Non-Subscriber Form Submission
  As a sales or marketing person at Practical Law
  I want to receive an email whenever a non-subscriber submits an Ask question
  So that I can target marketing and sales efforts towards those potential customers.

  Background:
    Given PL+ user is not logged in
    And the user navigates to the main PLCUK page

  @CloseAskWindow
  Scenario: Display correct fields and indicate required fields
    When the user clicks on 'Ask a question' link to ask a question
    And ASK form is displayed in new window
    And the user accepts ASK disclaimer terms
    Then the following fields are displayed on the form
      | Question          |
      | Document Id       |
      | First Name        |
      | Last Name         |
      | Email             |
      | Organisation Type |
      | Position          |
      | Jurisdiction      |
      | Answering Service |
    And Contact Details are indicated as required

  @manual
  Scenario Outline: Submit button is enabled only after all mandatory fields are completed
    When the user clicks on 'Ask a question' link to ask a question
    And ASK form is displayed in new window
    And the user accepts ASK disclaimer terms
    Then submit button on ASK form is disabled by default
    And I enter the following values on ASK form
      | agreeToDisclaimerTerms | <agreeToDisclaimerTerms> |
      | firstName              | <firstName>              |
      | lastName               | <lastName>               |
      | organisationType       | <organisationType>       |
      | position               | <position>               |
      | jurisdiction           | <jurisdiction>           |
      | answeringService       | <answeringService>       |
    And I enter the correct CAPTCH value
    Then submit button on ASK form is <submitButton>
  Examples:
    | agreeToDisclaimerTerms | firstName | lastName  | organisationType | position  | jurisdiction | answeringService | submitButton |
    | TRUE                   | Rakesh    | Avasarala | Public Sector    | Solicitor | UK           | Arbitration      | enabled      |
    | TRUE                   |           | Avasarala | Public Sector    | Solicitor | UK           | Arbitration      | disabled     |
    | TRUE                   | Rakesh    |           | Public Sector    | Solicitor | UK           | Arbitration      | disabled     |

  @manual
  Scenario: Successful ASK form submission
    When I open the ASK form to ask a question from anywhere on website
    And I enter the following values on ASK form
      | agreeToDisclaimerTerms | TRUE                               |
      | firstName              | Rakesh                             |
      | lastName               | Avasarala                          |
      | Email                  | rakesh.avasarla@thomsonreuters.com |
      | organisationType       | Public Sector                      |
      | position               | Solicitor                          |
      | jurisdiction           | UK                                 |
      | answeringService       | Arbitration                        |
    And I enter the correct CAPTCH value
    And submit the ASK form
    Then ASK form is successfully submitted
    And A thank you page should appear with option to close the window
    And clicking on 'close window' button should close the window

  @manual
  Scenario Outline: Email Address Format Validation
    When I open the ASK form to ask a question from anywhere on website
    And I enter the following values on ASK form
      | agreeToDisclaimerTerms | TRUE          |
      | firstName              | Rakesh        |
      | lastName               | Avasarala     |
      | Email                  | <email>       |
      | organisationType       | Public Sector |
      | position               | Solicitor     |
      | jurisdiction           | UK            |
      | answeringService       | Arbitration   |
    And I enter the correct CAPTCH value
    And submit the ASK form
    Then ASK form submission fails with error message "Invalid email address"
  Examples:
    | email  |
    | 1234   |
    | abcd   |
    | 12@ab. |
    | 12.ab  |

  @manual
  Scenario Outline: CAPTCHA validation
    When I open the ASK form to ask a question from anywhere on website
    And I enter the following values on ASK form
      | agreeToDisclaimerTerms | TRUE                                |
      | firstName              | Rakesh                              |
      | lastName               | Avasarala                           |
      | Email                  | rakesh.avasarala@thomsonreuters.com |
      | organisationType       | Public Sector                       |
      | position               | Solicitor                           |
      | jurisdiction           | UK                                  |
      | answeringService       | Arbitration                         |
    And I enter the <type> value for CAPTCH
    And submit the ASK form
    Then ASK form submission fails with error message "Enter correct CAPTCHA value"
  Examples:
    | type  |
    | wrong |
    | no    |
