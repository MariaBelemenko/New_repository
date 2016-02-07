Feature: As a  user, I do not want to see the sort options as they are only sorted by date

  @manual
  Scenario: User verifies the sort options dropdown should not appear on Topic LU results page
    Given a user is on a Topic LU results page
    When the user clicks the 'View all' link on the LU widget,
    Then the user should be taken to the Topic LU results list
    And the user should not be presented with the sort order drop down