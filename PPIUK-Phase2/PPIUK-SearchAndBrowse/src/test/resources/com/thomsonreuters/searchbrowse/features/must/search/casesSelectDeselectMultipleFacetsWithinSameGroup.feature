@wip
Feature:[687300]
  As a PL+ User with a WLUK Subscription I want to select / deselect multiple facets within the same parent group (e.g. Topics) and for my search results to be updated

  Background: Log in to website
    Given PL+ user is logged in
    And user selects the combined Know How UK link

  Scenario Outline: verify cases search results updated in light of parent facet selections
    Given user clicks on UK CASES
    When the user runs a free text search for the query "<query>"
    And the user gets the search result count and stores it as count "1"
    And the user verifies that the parent facet "<facet1>" is not selected
    And the user expands the facet "<facet1>"
    And the user verifies that the parent facet "<facet2>" is not selected
    And the user expands the facet "<facet2>"
    And the user verifies that the child facet "<facet3>" is not selected
    And the user expands the facet "<facet3>"
    And the user verifies that the child facet "<facet4>" is not selected
    And the user expands the facet "<facet4>"
    And the user verifies that the grandchild facet "<facet5>" is not selected
    And the user verifies that the grandchild facet "<facet6>" is not selected
    And the user selects the parent facet "<facet1>"
    And the user verifies that the facet is selected "<facet1>"
    And the user selects the parent facet "<facet2>"
    And the user verifies that the facet is selected "<facet2>"
    And the user gets the search result count and stores it as count "2"
    And the user verifies that the search result count "2" is less than "1"
  Examples:
    | query              | facet1         | facet2       | facet3 | facet4             | facet5            | facet6      |
    | Pleural | Commercial law | Contract law | Agency | Breach of contract | Commercial agents | Repudiation |

  Scenario Outline: verify cases search results updated in light of child facet selections
    Given user clicks on UK CASES
    When the user runs a free text search for the query "<query>"
    And the user gets the search result count and stores it as count "1"
    And the user verifies that the parent facet "<facet1>" is not selected
    And the user expands the facet "<facet1>"
    And the user verifies that the child facet "<facet2>" is not selected
    And the user expands the facet "<facet2>"
    And the user verifies that the grandchild facet "<facet3>" is not selected
    And the user selects the parent facet "<facet1>"
    And the user selects the option to apply filters
    And the user verifies that the facet is selected "<facet1>"
    And the user gets the search result count and stores it as count "2"
    And the user verifies that the search result count "2" is less than "1"
    And the user expands the facet "<facet1>"
    And the user selects the child facet "<facet2>"
    And the user selects the option to apply filters
    And the user verifies that the facet is selected "<facet2>"
    And the user gets the search result count and stores it as count "3"
    And the user verifies that the search result count "3" is less than "2"
  Examples:
    | query              | facet1         | facet2 | facet3            |
    | trademark teacakes | Commercial law | Agency | Commercial agents |

  Scenario Outline: verify cases search results updated in light of parent and child facet selections
    Given user clicks on UK CASES
    When the user runs a free text search for the query "<query>"
    And the user expands the facet "<facet1>"
    And the user expands the facet "<facet2>"
    And the user verifies that the parent facet "<facet1>" is not selected
    And the user verifies that the child facet "<facet2>" is not selected
    And the user verifies that the grandchild facet "<facet3>" is not selected
    And the user selects the parent facet "<facet1>"
    And the user selects the option to apply filters
    And the user gets the search result count and stores it as count "1"
    And the user verifies that the facet is selected "<facet1>"
    And the user expands the facet "<facet1>"
    And the user selects the child facet "<facet2>"
    And the user selects the option to apply filters
    And the user verifies that the facet is selected "<facet2>"
    And the user gets the search result count and stores it as count "2"
    And the user verifies that the search result count "2" is less than "1"
    And the user selects the parent facet "<facet3>"
    And the user selects the option to apply filters
    And the user verifies that the facet is selected "<facet3>"
    And the user gets the search result count and stores it as count "3"
    And the user verifies that the search result count "3" is greater than "2"
    And the user expands the facet "<facet3>"
    And the user selects the child facet "<facet4>"
    And the user selects the option to apply filters
    And the user verifies that the facet is selected "<facet4>"
    And the user gets the search result count and stores it as count "4"
    And the user verifies that the search result count "4" is less than "3"
  Examples:
    | query              | facet1         | facet2 | facet3       | facet4             |
    | trademark teacakes | Commercial law | Agency | Contract law | Breach of contract |

  Scenario Outline: verify cases search results updated in light of child facet deselection and parent facet selection
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
    And the user expands the facet "<facet4>"
    And the user selects the child facet "<facet5>"
    And the user selects the option to apply filters
    And the user verifies that the facet is selected "<facet5>"
    And the user verifies that the parent facet "<facet4>" is not selected
    And the user gets the search result count and stores it as count "2"
    And the user verifies that the search result count "2" is less than "1"
    And the user selects the parent facet "<facet1>"
    And the user selects the option to apply filters
    And the user verifies that the facet is selected "<facet1>"
    And the user selects the parent facet "<facet4>"
    And the user selects the option to apply filters
    And the user verifies that the facet is selected "<facet4>"
    And the user expands the facet "<facet1>"
    And the user expands the facet "<facet4>"
    And the user verifies that the child facet "<facet2>" has been deselected
    And the user verifies that the child facet "<facet5>" has been deselected
    And the user gets the search result count and stores it as count "3"
    And the user verifies that the search result count "2" is less than "3"
  Examples:
    | query              | facet1         | facet2 | facet3            | facet4       | facet5             |
    | trademark teacakes | Commercial law | Agency | Commercial agents | Contract law | Breach of contract |
