@manual
Feature: As a  user,I want to see the History page as in Design Document

  Scenario: User verifies the "Narrow"  label is hidden
    Given user is logged in
    When user navigates to the History page
    Then the user should not see the label "Narrow" on the left column of History Page.

  Scenario: User verifies the "New" and "Options" buttons displayed correctly
    Given cobalt user has logged into PLCUK site as "Yuri.Lupinov"
    When user navigates to the home page with clientID "SYED"
    And user clicks on "History" link
    Then user should see the active "History" tab visible
    And  user clicks on the "Folders" tab
    And user should see the active "Folders" tab visible
