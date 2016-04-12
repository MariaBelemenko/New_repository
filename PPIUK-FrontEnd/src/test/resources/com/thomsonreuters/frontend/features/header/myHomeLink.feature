Feature: As a PL+ user I want the My Home link or button to appear if the user has set a Home
  So that if the user has not set a Home it does not appear

  Scenario: User verifies My Home link gets appeared and funcitonal.
    Given PL+ user is logged in
    When the user clicks link 'Commercial' on 'the home' page
    Then the user verifies that the current PageTitle contains 'Commercial'
    And user clicks the Home Icon to make it as Start Page
    And user clicks on company logo
    And user should see the "My Home" link
    And user clicks the "My Home" link
    Then the user verifies that the current PageTitle contains 'Commercial'
    And user logs out
    And user tries to log in again
    And user logs in
    And the user verifies that the current PageTitle contains 'Commercial'
    And user clicks the Home Icon to remove it as Start Page
    And user clicks on company logo
    And user should not see any "My Home" link
