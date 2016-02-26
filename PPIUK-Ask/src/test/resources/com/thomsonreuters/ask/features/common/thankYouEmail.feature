@e2e
Feature: Thank You Email
  As a user
  I want to receive a thank you / acknowledgement email after I submit a question
  So that I can confirm PL+ received my question

  @CloseAskWindow
  Scenario: Thanks You Email
    Given PL+ user is logged in
    When the user clicks on 'Ask a question' link to ask a question
    And ASK form is displayed in new window
    And the user accepts ASK disclaimer terms
    And user completes the following ASK form fields
      | Question          | Test Question from Automation Script |
      | First Name        | Ira                                  |
      | Last Name         | Smolic                               |
      | Organisation Type | Public Sector                        |
      | Position          | Legal Advisor                        |
      | Jurisdiction      | UK                                   |
      | Answering Service | Arbitration                          |
    And user submits the ASK form
    And A thank you page should appear with option to close the window
    And user closes the ASK window
    Then 'AskTestuser' should receive Thanks You email from 'info.practicallaw@thomsonreuters.com' in specified email inbox

  @manual
  Scenario: Thanks You Email
    Given PL+ user is not logged in
    When I open the ASK form to ask a question from anywhere on website
    And I complete the following ASK form fields
      | agreeToDisclaimerTerms | TRUE          |
      | firstName              | Rakesh        |
      | lastName               | Avasarala     |
      | organisationType       | Public Sector |
      | position               | Solicitor     |
      | jurisdiction           | UK            |
      | answeringService       | Arbitration   |
    And submit the ASK form
    Then the user should receive Thanks You email from 'info.practicallaw@thomsonreuters.com' in specified email inbox
