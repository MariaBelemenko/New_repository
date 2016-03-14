@wip
Feature: [719407] See what content that will be included in my alert when I enter the subscription panel from a widget,
  So I can choose wether to save or cancel the subscription

  Scenario: Verify what content that will be included in my alert when I enter the subscription panel from a widget
    Given PL+ user is logged in
    Given a user is on the 'media and telecoms' practice area page
    When the user clicks the 'Subscribe' link on the Legal Updates Widget
    Then the user should be presented the subscription panel with a Subscription Details box
    And the subscription details box should display 'media & telecoms' under a Practice area heading
    And the subscription details box should display 'All' under a Topic heading
    And the subscription details box should display 'All' under a Jurisdiction heading
