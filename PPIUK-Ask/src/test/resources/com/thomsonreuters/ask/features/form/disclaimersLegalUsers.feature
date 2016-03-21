Feature: [752129] Disclaimers for Users
  As a user
  I want to view the legal disclaimers on the Ask Form
  So that I know the legal disclaimers for the Ask services

  @CloseAskWindow
  Scenario: Disclaimer text for logged in PL+ user
    Given PL+ user is logged in
    When the user clicks on 'Ask a question' link to ask a question
    And ASK form is displayed in new window
    Then the legal disclaimer is displayed on the ASK form
    And the user cannot view/submit the ASK form without agreeing to the disclaimer terms
    And user closes the ASK window

  @CloseAskWindow
  Scenario: Disclaimer text for Non-Subscribers
    Given PL+ user is not logged in
    When the user navigates to the main PLCUK page
    When the user clicks on 'Ask a question' link to ask a question
    And ASK form is displayed in new window
    Then the legal disclaimer is displayed on the ASK form
    And the user cannot view/submit the ASK form without agreeing to the disclaimer terms
    And user closes the ASK window
