Feature: The ability to link to the RSS information page when I am viewing the legal updates results page

  Scenario: Link to the RSS information page when I am viewing the legal updates results page
    Given PL+ user is logged in
    Given a user is on a "Construction" PA page
    When the user clicks on the 'View all' link of the LU widget
    And the user is presented with a 'RSS' link in the result page toolbar
    When the user clicks on this link
    Then the user should be presented with the RSS information page
