@e2e @prod
Feature: [752699, 752700] Log out page includes Branding

 Scenario: [752699][752700] As a PPI user I want to see a confirmation page with Practical Law Branding when I logged out
	Given PL+ user is logged in
    When user clicks on Sign out
    Then user should see Log out confirmation page
    And user should see Sign On button on this page
    And user should see session summary on this page
    And user should see a branding logo on Log out screen
