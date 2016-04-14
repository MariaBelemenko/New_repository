@wip
Feature: [687292] legislationSelectDeselectSingleFacet.feature
  As a PL+ User with a WLUK Subscription I want to select / deselect a single facet so that I can
  update / refresh my search results and view the data I am interested in researching

  Background:
    Given PL+ user is logged in
    And user selects the combined Know How UK link

  Scenario Outline: verify facets deselected by default
    Given user clicks on UK Legislation
    When the user runs a free text search for the query "<query>"
    And the user verifies that the parent facet "<facet1>" is not selected
    And the user verifies that the child facet "<facet2>" is not selected
    And the user verifies that the grandchild facet "<facet3>" is not selected
  Examples:
    | query    | facet1   | facet2   | facet3 |
    | taxation | Shipping | Contract | Shares |

  Scenario Outline: verify results updated in line with selected child facet
    Given user clicks on UK Legislation
    When the user runs a free text search for the query "<query>"
    And the user gets the search result count and stores it
    And the user verifies that the parent facet "<facet1>" is not selected
    And the user verifies that the child facet "<facet2>" is not selected
    And the user verifies that the grandchild facet "<facet3>" is not selected
    And the user selects the child facet "<facet>"
    And the user verifies that the facet is selected
    And the user verifies that the parent facet is not selected "<facet1>"
    And the user verifies that the result at position "<resultposition>" contains content appropriate either to the facet "<facet3>" or the facet "<facet4>"
    And the user gets the search result count and stores it
    And the user verifies that the search result count has decreased
  Examples:
    | query    | facet1     | facet2      | facet3  |
    | contract | Commercial | Arbitration | Mergers |

  Scenario Outline: parent of selected child facet now selected - verify child deselected and results updated
    Given user clicks on UK Legislation
    When the user runs a free text search for the query "<query>"
    And the user verifies that the parent facet "<facet1>" is not selected
    And the user verifies that the child facet "<facet2>" is not selected
    And the user verifies that the grandchild facet "<facet3>" is not selected
    And the user selects the child facet "<facet4>"
    And the user verifies that the facet is selected
    And the user gets the search result count and stores it
    And the user verifies that the parent facet is not selected "<facet1>"
    And the user selects the parent facet "<facet1>"
    And the user verifies that the facet is selected
    And the user verifies that the child facet is not selected "<facet4>"
    And the user verifies that the result at position "<resultposition>" contains content appropriate to the facet "<facet1>"
    And the user gets the search result count and stores it
    And the user verifies that the search result count has increased
  Examples:
    | query    | facet1     | facet2      | facet3  | facet4 |
    | contract | Commercial | Arbitration | Mergers | child  |
