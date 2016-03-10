Feature: The ability to see alerts controls on a single page

  Background: Logging in for Adestra
    Given PL+ user is logged in with following details
      | userName | adestra_user33 |
    And a user is viewing the email preference page

  Scenario Outline: As user I want to see services and relevant checkboxes the page
    When the user has opened the "<region>" Services tab
    Then the user should be presented with each "<region>" service
    And each "<region>" service should have the relevant check box options
  Examples:
    | region |
    | US     |
    | UK     |
    | EU     |
    | Global |
    | Canada |

  Scenario: As user I want to see HTML and Text Only radiobuttons and 'Receive an email even if there are no new items' checkbox
    Then the user should be presented with two radio buttons as email options
    And the options should include HTML and Text Only
    And the user should be presented with a checkbox for 'Receive an email even if there are no new items'

  Scenario: As a user i want to see Save and Cancel buttons on preference page
    Then the user should be presented with two buttons to save their preferences or cancel their changes
    And one button should be labelled 'Save preferences'
    And one button should be labelled 'cancel changes'

  @UsubscribeUserFromAllSubscriptionsAndRemoveUnsubscribeOption
  Scenario Outline: As user i want save all subscriptions in adestra
    When the user has opened the "<region>" Services tab
    And the user selects checkboxes for each  "<region>" service
    And the user saves his preferences
    Then user "adestra_user33@mailinator.com" preferences should be saved in adestra
  Examples:
    | region |
    | US     |
    | UK     |
    | EU     |
    | Global |
    | Canada |
