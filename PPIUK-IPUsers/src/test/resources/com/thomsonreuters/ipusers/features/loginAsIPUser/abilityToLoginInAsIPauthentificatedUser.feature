@ip
Feature: [738889] Create a landing page for IP authenticated users to enter an email

  @manual
  Scenario: [815290] improve security around Adestra email preferences for IP users
    Given PL+ user is logged in with following details
      | loginRequired    | NO      |
    When the user navigates to the email preference page
    Then the user should be presented with the login page
    When user enters his email address "adestra_user22@mailinator.com"
    Then the user should receive a encrypted token with a link to their email inbox
    When an IP user has received the encrypted token/link in their email inbox
    And the user is using a IP authenticated device
    When the user clicks on this link,
    Then the user should be granted access and presented with their email preferences page.

  @manual
  Scenario: [815290] User accessing the token from a non IP authenticated device
    Given an IP user has received the encrypted token/link in their email inbox
    And the user is using a non-IP authenticated device (eg. mobile)
    When the user clicks on this link
    Then the user should be denied access and presented with an error page.
