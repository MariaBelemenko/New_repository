Feature: As a PL+ user,I want to include the twitter logo and dropdown So that the footer looks like the high resolution designs

  Scenario: I want the company log to display and function correctly.
    Given PL+ user is logged in
    Then user should see footer
    And user should see the "Twitter" link
    And user clicks the Twitter link
    And user should check the following links
      | Practical Law UK             |
      | Practical Law GLobal         |
      | Arbitration                  |
      | Employment                   |
      | Pensions                     |
      | Procurement                  |
      | Restructuring and Insolvency |
      | Tax                          |