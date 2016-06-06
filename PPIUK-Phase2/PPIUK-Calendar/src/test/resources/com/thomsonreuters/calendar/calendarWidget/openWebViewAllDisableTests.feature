Feature: As a PL+ user, I want the ability to navigate to another  months by selecting a future month from the drop down on the widget
@wip
  Scenario: User verifies the month drop-down with the current month selected
    Given PL+ user is logged in with following details
      | routing          | OPEN_WEB  |
      | mandatoryRouting | YES             |
    When the user navigates to "/Browse/Home/TestPages/TestPACalendar" url
    Then a calendar widget is presented to the user

