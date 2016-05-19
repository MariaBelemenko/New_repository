@should
Feature: Scenarios with the SHOULD bugs

  #806688 REGRESSION:Ask Form:Fields are not mandatory
  @bug
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
    | TRUE                   | Rakesh    | Avasarala | Public Sector    |           | UK           | Arbitration      | disabled     |
    | TRUE                   | Rakesh    | Avasarala | Public Sector    | Solicitor | UK           |                  | disabled     |

  # 847381:[REGRESSION] Ask form: there is ability to submit form with invalid email "12@ab"
  @bug
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
    | email |
    | 12@ab |

  # 806688 REGRESSION:Ask Form:Fields are not manadtory
  @bug
  Scenario: ASK Form Validation when submitted without entering any field
    Given PL+ user is logged in
    And the user access the ASK form directly via url
    And the user accepts ASK disclaimer terms
    When user submits the ASK form
    Then error message is displayed for user to complete the following fields
      | Position          |
      | Answering Service |

  @bug
  Scenario Outline: ASK Form Validation when submitted without entering some fields
    Given PL+ user is logged in
    And the user access the ASK form directly via url
    And the user accepts ASK disclaimer terms
    When user completes the following ASK form fields
      | Question          | <question>         |
      | First Name        | <firstName>        |
      | Last Name         | <lastName>         |
      | Organisation Type | <organisationType> |
      | Position          | <position>         |
      | Jurisdiction      | <jurisdiction>     |
      | Answering Service | <answeringService> |
    And user submits the ASK form
    Then error message is displayed for user to complete the following fields
      | <fields> |
  Examples:
    | question | firstName | lastName  | organisationType | position  | jurisdiction | answeringService | fields            |
    | q3       | Rakesh    | Avasarala | Public Sector    |           | UK           | Arbitration      | Position          |
    | q5       | Rakesh    | Avasarala | Public Sector    | Solicitor | UK           |                  | Answering Service |
    | q6       | Rakesh    | Avasarala | Public Sector    | Solicitor |              |                  | Answering Service |
