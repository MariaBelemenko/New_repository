@wip
Feature: [687292] casesSelectDeselectSingleFacet.feature
  As a PL+ User with a WLUK Subscription I want to select / deselect a single facet so that I can
  update / refresh my search results and view the data I am interested in researching

  Background:
    Given PL+ user is logged in
    And user selects the combined Know How UK link

  Scenario Outline: verify facets deselected by default
    Given user clicks on UK CASES
    When the user runs a free text search for the query "<query>"
    And the user verifies that the parent facet "<facet1>" is not selected
    And the user expands the facet "<facet1>"
    And the user verifies that the child facet "<facet2>" is not selected
    And the user expands the facet "<facet2>"
    And the user verifies that the grandchild facet "<facet3>" is not selected
  Examples:
    | query              | facet1         | facet2 | facet3            |
    | trademark teacakes | Commercial law | Agency | Commercial agents |

  Scenario Outline: verify results updated in line with selected child facet
    Given user clicks on UK CASES
    When the user runs a free text search for the query "<query>"
    And the user gets the search result count and stores it as count "1"
    And the user verifies that the parent facet "<facet1>" is not selected
    And the user expands the facet "<facet1>"
    And the user verifies that the child facet "<facet2>" is not selected
    And the user expands the facet "<facet2>"
    And the user verifies that the grandchild facet "<facet3>" is not selected
    And the user selects the child facet "<facet2>"
    And the user selects the option to apply filters
    And the user verifies that the facet is selected "<facet2>"
    And the user verifies that the parent facet "<facet1>" is not selected
    And the user gets the search result count and stores it as count "2"
    And the user verifies that the search result count "2" is less than "1"
  Examples:
    | query              | facet1         | facet2 | facet3            |
    | trademark teacakes | Commercial law | Agency | Commercial agents |

  Scenario Outline: parent of selected child facet now selected - verify child deselected and results updated
    Given user clicks on UK CASES
    When the user runs a free text search for the query "<query>"
    And the user verifies that the parent facet "<facet1>" is not selected
    And the user expands the facet "<facet1>"
    And the user verifies that the child facet "<facet2>" is not selected
    And the user expands the facet "<facet2>"
    And the user verifies that the grandchild facet "<facet3>" is not selected
    And the user selects the child facet "<facet2>"
    And the user selects the option to apply filters
    And the user verifies that the facet is selected "<facet2>"
    And the user gets the search result count and stores it as count "1"
    And the user verifies that the parent facet "<facet1>" is not selected
    And the user selects the parent facet "<facet1>"
    And the user selects the option to apply filters
    And the user verifies that the facet is selected "<facet1>"
    And the user expands the facet "<facet1>"
    And the user verifies that the child facet "<facet2>" is not selected
    And the user gets the search result count and stores it as count "2"
    And the user verifies that the search result count "1" is less than "2"
  Examples:
    | query              | facet1         | facet2 | facet3            |
    | trademark teacakes | Commercial law | Agency | Commercial agents |
