Feature: [743670; 743677; 780299] The ability to link to the RSS information page from the Legal Updates Widget

  Scenario: [743670] Link to the RSS information page from the Legal Updates Home Widget
    Given PL+ user is logged in
    And a user is on the Legal Updates Home page
    And the user is presented with the Legal Updates widget
    And the user should be presented with an 'RSS' Link
    When the user clicks on the RSS link
    Then the user should be presented with the RSS information page

  Scenario: [743677] Link to the RSS information page from a practice area legal updates widget
    Given PL+ user is logged in
    And a user is on the Media & Telecoms practice area page
    And the user is presented with the Legal Updates widget
    And the user should be presented with an 'RSS' Link
    When the user clicks on the RSS link
    Then the user should be presented with the RSS information page
    
    Scenario: [780299] I dont want to see RSS button on a topic legal updates widget
    Given PL+ user is logged in
    Given a user navigate to a "Insurance" Topic page from a "Construction" Practice Area page
    And the user is presented with the Legal Updates widget
    And the user should not be presented with an 'RSS' Link
