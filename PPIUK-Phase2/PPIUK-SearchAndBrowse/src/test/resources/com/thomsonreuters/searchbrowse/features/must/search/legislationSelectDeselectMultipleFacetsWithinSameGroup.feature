@wip
Feature:[687300]
  As a PL+ User with a WLUK Subscription I want to select / deselect multiple facets within the same parent group (e.g. Topics) and for my search results to be updated

  Background: Log in to website
    Given PL+ user is logged in
    And user selects the combined Know How UK link

  Scenario Outline: verify cases search results updated in light of parent facet selections
    Given user clicks on UK Legislation
    When the user runs a free text search for the query "<query>"
    And the user gets the search result count and stores it
    And the user verifies that the parent facet "<facet1>" is not selected
    And the user verifies that the parent facet "<facet2>" is not selected
    And the user verifies that the child facet "<facet3>" is not selected
    And the user verifies that the child facet "<facet4>" is not selected
    And the user verifies that the grandchild facet "<facet5>" is not selected
    And the user verifies that the grandchild facet "<facet6>" is not selected
    And the user selects the parent facet "<facet1>"
    And the user verifies that the facet "<facet1>" is selected
    And the user selects the parent facet "<facet2>"
    And the user verifies that the facet "<facet2>" is selected
    And the user verifies that the result at position "<resultposition>" contains content appropriate either to the facet "<facet1>" or the facet "<facet2>"
    And the user gets the search result count and stores it
    And the user verifies that the search result count has reduced
  Examples:
    | query    | facet1     | facet2      | facet3   | facet4        | facet5  | facet6 | resultposition |
    | contract | commercial | Arbitration | Shipping | Sale of goods | Mergers | Shares | 1              |

#  Examples:
#    | query                |
#    | offer and acceptance |

  Scenario Outline: verify cases search results updated in light of child facet selections
    Given user clicks on UK Legislation
    When the user runs a free text search for the query "<query>"
    And the user gets the search result count and stores it
    And the user verifies that the parent facet "<facet1>" is not selected
    And the user verifies that the child facet "<facet2>" is not selected
    And the user verifies that the grandchild facet "<facet3>" is not selected
    And the user selects the child facet "<facet1>"
    And the user verifies that the facet "<facet1>" is selected
    And the user selects the child facet "<facet2>"
    And the user verifies that the facet "<facet2>" is selected
    And the user verifies that the result at position "<resultposition>" contains content appropriate either to the facet "<facet1>" or the facet "<facet2>"
    And the user gets the search result count and stores it
    And the user verifies that the search result count has reduced
  Examples:
    | query    | facet1     | facet2      | facet3   | resultposition |
    | contract | commercial | Arbitration | Shipping | 1              |

  Scenario Outline: verify cases search results updated in light of parent and child facet selections
    Given user clicks on UK Legislation
    When the user runs a free text search for the query "<query>"
    And the user expands the parent facet "<facet1>"
    And the user expands the child facet "<facet2>"
    And the user verifies that the parent facet "<facet1>" is not selected
    And the user verifies that the child facet "<facet2>" is not selected
    And the user verifies that the grandchild facet "<facet3>" is not selected
    And the user selects the parent facet "<facet1>"
    And the user verifies that the facet "<facet1>" is selected
    And the user selects child facet "<facet2>"
    And the user verifies that the facet "<facet2>" is selected
    And the user selects the parent facet "<facet4>"
    And the user verifies that the facet "<facet4>" is selected
    And the user selects child facet "<facet5>"
    And the user verifies that the facet "<facet5>" is selected
    And the user verifies that the result at position "<resultposition>" contains content appropriate either to facet "<facet1>" or facet "<facet2>" or facet "<facet3>" or facet "<facet4>"
    And the user gets the search result count and stores it
    And the user verifies that the search result count has reduced
  Examples:
    | query    | facet1     | facet2      | facet3   | facet4        | facet5   | resultposition |
    | contract | Commercial | Arbitration | Contract | Sale of Goods | Shipping | 1              |

  Scenario Outline: verify cases search results updated in light of child facet deselection and parent facet selection
    Given user clicks on UK Legislation
    When the user runs a free text search for the query "<query>"
    And the user verifies that the parent facet "<facet1>" is not selected
    And the user verifies that the child facet "<facet2>" is not selected
    And the user verifies that the grandchild facet "<facet3>" is not selected
    And the user selects the child facet "<facet1>"
    And the user verifies that the facet "<facet1>" is selected
    And the user selects the child facet "<facet2>"
    And the user verifies that the facet "<facet2>" is selected
    And the user verifies that the parent facet "<facet3>" is not selected
    And the user verifies that the parent facet "<facet4>" is not selected
    And the user gets the search result count and stores it
    And the user verifies that the search result count has reduced
    And the user selects the parent facet "<facet3>"
    And the user verifies that the facet "<facet3>" is selected
    And the user selects the parent facet "<facet4>"
    And the user verifies that the facet "<facet4>" is selected
    And the user verifies that the child facet "<facet1>" has been deselected
    And the user verifies that the child facet "<facet2>" has been deselected
    And the user verifies that the result at position "<resultposition>" contains content appropriate either to the facet "<facet3>" or the facet "<facet4>"
    And the user gets the search result count and stores it
    And the user verifies that the search result count has increased
  Examples:
    | query    | facet1     | facet2      | facet3  | facet4 | resultposition |
    | contract | Commercial | Arbitration | Mergers | Shares | 1              |
