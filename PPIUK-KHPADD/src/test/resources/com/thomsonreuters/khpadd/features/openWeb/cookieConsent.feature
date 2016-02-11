Feature: [786052] Verify cookie consent message on the homepage when the user accesses the PL+ site

  Background:
    Given PL+ user is not logged in
    When the user navigates to the main PLCUK page
    Then the user 'is' presented with the cookie consent message
    When the user clicks on Sign On link on the header
    And user logs in

  Scenario: Verify the links on the cookie consent
    When the user clicks on the "cookies" link on the cookie consent message
    Then document title is displayed as "Thomson Reuters (Professional) UK Ltd - Privacy and Data Protection Policy"
    When the user navigates to the main PLCUK page
    When the user clicks on the "Privacy Policy and Cookies" link on the cookie consent message
    Then document title is displayed as "Thomson Reuters (Professional) UK Ltd - Privacy and Data Protection Policy"
    And user sign out

  Scenario: Verify the cookie consent message and the its acceptance by clicking on close button
    Then the user 'is' presented with the cookie consent message
    When the user clicks on close button on the cookie consent message
    And user navigates directly to document with guid "I3351a82be8da11e398db8b09b4f043e0"
    Then the user 'is not' presented with the cookie consent message
