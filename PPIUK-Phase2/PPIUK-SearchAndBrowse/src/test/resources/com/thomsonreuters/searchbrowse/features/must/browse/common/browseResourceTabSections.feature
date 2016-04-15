@wip
Feature: Verify the Browse to Standard Doc and Clause
  Verify the Browse to Practice Notes

  # Test takes too much time (~2h) because of huge link count

  # NOTICE: The count of links suggested by Sam Newman:
  # "Are you verifying that the links are the correct links? Or simply that they are present?
  # If the latter is the case, we could change the test to just check for the presence of one or more links.
  # If we did have to test the links themselves, I would suggest testing a minimum of 25 links per resource type."

  # Waiting answer for Sam Newman about back browser action. Last step fail now because active tab is 'Practice area' after return
  Scenario Outline: Verify the Browse to Standard Doc and Clause
    Given PL+ user is logged in
    When the user opens 'Resources' link
    And the user opens '<Resource Link>' link
    Then the Practice Area section links are present and the first '25' related links are valid for every PA section
    When the user clicks Back button in browser
    Then the user verifies that default Tab is 'Resources'
  Examples:
    | Resource Link                         |
    | Practice notes                        |
    | Standard documents and drafting notes |
    | Standard clauses and drafting notes   |