Feature: As a subscribed user i want to see existing subscriptions.

  Scenario Outline: As a subscribed user i want to see existing subscriptions.
    Given PL+ user is logged in with following details
      | userName | adestra_user22 |
    And a user "adestra_user22@mailinator.com" has a subscription to the '13' Corporate practice areas "<region>" content
    When the user navigates to the email preference page
    Then the user should be presented with their "<region>" corporate email service
    And the check boxes should reflect their existing email subscriptions
    And the check boxes should be selectable
  Examples:
    | region |
    | US     |
    | UK     |
    | EU     |
    | Global |
    | Canada |
