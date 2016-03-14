Feature: [716429] The ability to use Email delivery option on the header

  Scenario: Use the email delivery option on the header
    Given PL+ user is logged in
    And a user is on a legal updates results page
    Then they should be presented with an 'email' option
    When the User selects the 'email' option
    Then they should be presented with an email delivery light box

  Scenario: To use the email delivery option on the header from different pages
    Given PL+ user is logged in
    Given a user navigate to a "Insurance" Topic page from a "Construction" Practice Area page
    When the user clicks on the 'View all' link of the LU widget
    Then they should be presented with an 'email' option
    When the User selects the 'email' option
    Then they should be presented with an email delivery light box
