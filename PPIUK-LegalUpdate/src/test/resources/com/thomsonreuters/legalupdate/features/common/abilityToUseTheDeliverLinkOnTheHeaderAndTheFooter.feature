Feature: The ability to use the Deliver link on the header and the footer.

  Scenario: I want to use the Deliver link on the header
    Given PL+ user is logged in
    And a user is on a legal updates results page
    When the user selects a legal update document
    And the'Email' should be a selectable option
    And the'Print' should be a selectable option
    And the 'Download' should be a selectable option

  Scenario: I want to use the Deliver link on the header via View All
    Given PL+ user is logged in
    And a user navigate to a "Insurance" Topic page from a "Construction" Practice Area page
    When the user clicks on the 'View all' link of the LU widget
    When the user selects a legal update document
    And the'Email' should be a selectable option
    And the'Print' should be a selectable option
    And the 'Download' should be a selectable option
 
