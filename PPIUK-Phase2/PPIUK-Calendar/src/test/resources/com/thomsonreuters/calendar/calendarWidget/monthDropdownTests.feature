
Feature: As a PL+ user, I want the ability to navigate to another  months by selecting a future month from the drop down on the widget

  Background:
    Given PL+ user is logged in
   # When the user navigates to practice area "Employment"
    When the user navigates to "/Browse/Home/TestPages/TestPACalendar" url
    Then a calendar widget is presented to the user

  Scenario: User verifies the month drop-down with the current month selected
    And the current month should be selected by default
    And the user should be presented with the "current" month option selected in the drop down
    And the user should be seeing the next 6 months and the past 5 months to "current" month
  @widgetMonth
  Scenario: User verifies the month drop-down with different month selected
    And the user has selected "November 2016" month in the drop down
    When the user clicks on the drop down
    Then the user should be presented with the "November" month option selected in the drop down
    And the user should be seeing the next 6 months and the past 5 months to "November" month
@wip
  Scenario: User verifies the month drop-down with navigational arrows
    Given a user has selected "December 2016" month using the navigation arrows
    When the user clicks on the drop down
    Then the user should be presented with the "December" month option selected in the drop down
    And the user should be seeing the next 6 months and the past 5 months to "December" month
