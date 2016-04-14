@wip
Feature: [690606] legislationExpandCollapseFacets.feature
  As a PL+ User with a WLUK subscription I want to be able to expand / collapse Legislation facets
  So that I can focus on the facets I am interested in viewing


  Background: Log in to website
    Given PL+ user is logged in
    And user selects the combined Know How UK link

  #lines are commented out in the test below as there are no grandchild facets currently within legislation

  Scenario Outline: This test verifies the following scenarios
  1. Verify presence of parent facets
  2. Verify children not displayed by default
  3. Expand the parent and verify the child is displayed
  4. Verify child displayed
  5. Expand child and verify grandchild displayed


    Given user clicks on UK Legislation
    When user enters "<query>" criteria
    And user clicks on Search button
    #verify parent facets displayed by default
    And the user verifies the presence of the legislation facet "<facet1>"
    And the user verifies the presence of the legislation facet "<facet2>"
    #verify children not displayed by default
    And the user verifies that the child legislation facet "<facet3>" is not displayed
    #expand the parent
    And the user expands the legislation facet "<facet1>"
    #verify child facet now displayed
    And the user verifies that the child legislation facet "<facet3>" is displayed
    #expand the child facet
    And the user expands the legislation facet "<facet3>"
    #verify presence of grandchild facet
    And the user verifies that the grandchild legislation facet "<facet4>" is displayed

  Examples:
  | query    | facet1   | facet2      | facet3     | facet4        |
  | taxation | Finance  | Equity      | Banks      | Dormant funds |



  Scenario Outline:  This test verifies the following scenarios
    1. Verify parent facets displayed
    2. Expand the parent and view the child
    3. Collapse the parent and verify child no longer visible
    4. Verify parent facet remains visible

    Given user clicks on UK Legislation
    When user enters "<search>" criteria
    And user clicks on Search button
    #verify parent facets displayed by default
    And the user verifies the presence of the legislation facet "<facet1>"
    #verify children not displayed by default
    And the user verifies that the child legislation facet "<facet2>" is not displayed
    #expand the parent
    And the user expands the legislation facet "<facet1>"
    #verify child facet now displayed
    And the user verifies that the child legislation facet "<facet2>" is displayed
    #collapse the parent facet
    And the user collapses the legislation facet "<facet1>"
    #verify children no longer displayed
    And the user verifies that the legislation facet "<facet1>" is collapsed (subfacet no longer displayed)
    #verify parent facets still displayed
    And the user verifies the presence of the legislation facet "<facet1>"

  Examples:
    | search   | facet1  | facet2  |
    | taxation | UK      | England |

  Scenario Outline: This test verifies the following scenarios
    1. Expand parent and child facets to display grandchildren
    2. Collapse child facet - with the consequence that grandchild facets are no longer visible
    3. Verify parent and child still visible


    Given user clicks on UK Legislation
    When user enters "<search>" criteria
    And user clicks on Search button
    #verify parent facets displayed by default
    And the user verifies the presence of the legislation facet "<facet1>"
    And the user verifies the presence of the legislation facet "<facet2>"
    #verify children not displayed by default
    And the user verifies that the child legislation facet "<facet3>" is not displayed
    #expand the parent
    And the user expands the legislation facet "<facet1>"
    #verify child facet now displayed
    And the user verifies that the child legislation facet "<facet3>" is displayed
    #expand the child facet
    And the user expands the legislation facet "<facet3>"
    #verify presence of grandchild facet
    And the user verifies that the grandchild legislation facet "<facet4>" is displayed
    #collapse the child facet
    And the user collapses the legislation facet "<facet3>"
    #verify grandchildren no longer displayed
    And the user verifies that the legislation facet "<facet3>" is collapsed (subfacet no longer displayed)
    And the user verifies that the grandchild legislation facet "<facet4>" is not displayed
    #verify children still displayed
    And the user verifies that the child legislation facet "<facet3>" is displayed
    #verify parent facets still displayed
    And the user verifies that the parent legislation facet "<facet1>" is displayed

  Examples:
    | search   | facet1   | facet2     |  facet3  | facet4        |
    | taxation | Finance  | Equity     |  Banks   | Dormant funds |