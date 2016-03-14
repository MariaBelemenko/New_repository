Feature: [718147] The ability to select my email delivery options

  Scenario: Select my email delivery options
    Given PL+ user is logged in
    Given a user is on a legal updates results page
    And a user has selected the email delivery option
    Then the user is presented with the email delivery lightbox
    And the lightbox should contain the features described in the description

  Scenario: Select my email delivery options from different pages
    Given PL+ user is logged in
    Given a user navigate to a "Insurance" Topic page from a "Construction" Practice Area page
    When the user clicks on the 'View all' link of the LU widget
    And a user has selected the email delivery option
    Then the user is presented with the email delivery lightbox
    And the lightbox should contain the features described in the description
