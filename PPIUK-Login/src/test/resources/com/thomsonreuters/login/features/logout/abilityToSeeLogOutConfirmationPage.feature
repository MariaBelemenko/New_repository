@e2e @prod
Feature: Log out page includes Branding

  Scenario: As a PPI user I want to see a confirmation page and Practical Law Branding when I log out
    Given PL+ user is logged in
    When user clicks on Sign out
    Then user should see Log out confirmation page
    And user should see Sign On button on this page
    And user should see session summary on this page
    And user should see a branding logo on Log out screen
