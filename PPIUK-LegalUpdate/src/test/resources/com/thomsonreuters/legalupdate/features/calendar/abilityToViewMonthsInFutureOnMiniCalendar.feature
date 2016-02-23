@wip
Feature: The ability to view  months in the future on the mini calendar

  Scenario: Ability to view  months in the future on the mini calendar
    Given PL+ user is logged in
    Given a user is on full calendar view for the current month
    And the user is presented with a mini calendar for the current month
    And the mini calendar displays the name and year of the current month
    When the user clicks on the name for the current month
    Then the user should be presented with a drop down list displaying the previous '5' months, the current month and the next '5' months
    And the current month should be displayed in bold
    And the drop down list and the lightbox should have the ability to select a month
