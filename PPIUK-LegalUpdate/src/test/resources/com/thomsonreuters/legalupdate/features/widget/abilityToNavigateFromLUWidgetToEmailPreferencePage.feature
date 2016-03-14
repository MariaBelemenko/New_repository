@wip
Feature: [729278] The ability to navigate from the legal Update widget to the email preference page

  Scenario: Navigate from the legal Update widget to the email preference page
    Given PL+ user is logged in
    And a user is on the media and telecoms practice area page
    And the user has been presented with the legal updates widget
    Then the legal update widget should display a link labelled 'email preferences'
