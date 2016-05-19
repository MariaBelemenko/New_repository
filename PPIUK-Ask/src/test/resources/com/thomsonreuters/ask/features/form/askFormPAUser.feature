Feature: [751653] PL+ user ASK form submission and Validations
  As a user
  I want the Ask form to appear in the same format as it currently is on the Practical Law site
  So that I am not confused and there is consistency between the two sites.

  Background:
    Given PL+ user is logged in

  Scenario: Display correct fields and indicate required fields
    When the user access the ASK form directly via url
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

  # 833679 [REGRESSION] Ask Unable to submit query
  @bug
  Scenario: Successful ASK form submission
    When the user access the ASK form directly via url
    And the user accepts ASK disclaimer terms
    Then the following ASK form fields are pre-populated
      | First Name |
      | Last Name  |
      | Email      |
    And user completes the following ASK form fields
      | Question          | Test Question from Automation Script |
      | Organisation Type | Public Sector                        |
      | Position          | Solicitor                            |
      | Jurisdiction      | UK                                   |
      | Answering Service | Arbitration                          |
    And user submits the ASK form
    And A thank you page should appear with option to close the window

  # 833679 [REGRESSION] Ask Unable to submit query
  @CloseAskWindow @bug
  Scenario: Successful ASK form submission from resource/question page
    When user navigates directly to document with guid "I020627b21cb611e38578f7ccc38dcbee"
    And the user clicks on ASK icon to ask a question
    Then ASK form is displayed in new window
    When the user accepts ASK disclaimer terms
    And the following ASK form fields are pre-populated
      | Document Id |
      | First Name  |
      | Last Name   |
      | Email       |
    And user completes the following ASK form fields
      | Question          | Test Question from Automation Script for document with guid I020627b21cb611e38578f7ccc38dcbee |
      | Organisation Type | Public Sector                                                                                 |
      | Position          | Solicitor                                                                                     |
      | Jurisdiction      | UK                                                                                            |
      | Answering Service | Arbitration                                                                                   |
    And user submits the ASK form
    And A thank you page should appear with option to close the window
    And user closes the ASK window

  Scenario: Pre-populated email address is read-only
    When the user access the ASK form directly via url
    And the user accepts ASK disclaimer terms
    Then the pre-populated email address cannot be edited

  Scenario: ASK Form Validation when submitted without entering any field
    And the user access the ASK form directly via url
    And the user accepts ASK disclaimer terms
    When user submits the ASK form
    Then error message is displayed for user to complete the following fields
      | Question |

  Scenario Outline: ASK Form Validation when submitted without entering some fields
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
    | question | firstName | lastName  | organisationType | position  | jurisdiction | answeringService | fields              |
    | q1       | Rakesh    |           | Public Sector    | Solicitor | UK           | Arbitration      | Last Name           |
    |          |           | Avasarala | Public Sector    | Solicitor | UK           | Arbitration      | Question,First Name |
    | q4       | Rakesh    | Avasarala |                  |           | UK           | Arbitration      | Position          |
