@manual
Feature: As a  user, I want to see the header styling according to the design

  Scenario:[783407] User verifies removal/hidding the alerts in header
    Given a user is logged in
    When user navigates to any page like home page/practice area/topic
    Then the user should not see the alert link/dropdown

  Scenario: [757201]Upper and Lower header color  should be displayed according to design document
    Given cobalt user has logged into PLCUK site as "UKPPITester1v"
    When user navigates to the home page with clientID "SYED"
    Then user should Upper and Lower header are displayed according to design document

  Scenario: [747457]"Advanced" link should be displayed according to style guide
    Given PL+ user has logged in
    When user navigates to the home page with clientID "TEST01"
    Then user should see company logo according to the design document

  Scenario: [726617] Search Bar and button should be displayed according to style guide
    Given cobalt user has logged into PLCUK site as "UKPPITester1v"
    When user navigates to the home page with clientID "SYED"
    Then user should see company logo according to the style guide

  Scenario: [732052] Horizontal menu links  should be displayed according to style guide
    Given cobalt user has logged into PLCUK site as "UKPPITester1v" in IE8
    When user navigates to the home page with clientID "SYED"
    Then user should see the menu link aligned horizontally according to the style guide

  Scenario:  [732055]Browse button should be displayed according to style guide
    Given cobalt user has logged into PLCUK site as "UKPPITester1"
    When user navigates to the home page with clientID "SYED"
    Then user should see browse button according to the style guide
    And user hovers the browse button
    And it should again changes according to the design document.