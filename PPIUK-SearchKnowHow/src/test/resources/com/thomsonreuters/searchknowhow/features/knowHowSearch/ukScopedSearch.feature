Feature: [702171][702170] - Scoped Search - Practice Area Search

  Background: Log on to test site
    Given PL+ user is logged in with following details
      | userName | Search1_AutoUser |

  @e2e @prod
  Scenario Outline: [702171] As a PL+ user conducting a search from a subject area (topic) page (and therefore the search is already scoped), I will only see results coded to that subject area and its parent practice area.
    And the user selects the link to Media and Telecoms
    And the user selects the link to Social Media
    And the user runs a free text search for the query "<query>"
    And the user pauses for "3" seconds
    Then the user opens the result in position "<position>"
    And the user pauses for "3" seconds
    And the user verifies that the product detail contains the practice area "<practicearea>"
    And the user verifies that the product detail contains the topic area "<topicarea>"
  Examples:
    | query   | position | practicearea     | topicarea    |
    | profile | 1        | Media & Telecoms | Social Media |

  Scenario Outline: [702170]  If I search Know-How Content for a specific Practice Area then the returned search results are only for the specified Practice Area
    And the user selects the link to Media and Telecoms
    And the user runs a free text search for the query "<query>"
    And the user pauses for "3" seconds
    And the user can open the first know how search result "1"
    And the user pauses for "3" seconds
    And the user verifies that the product detail contains the practice area "<productArea>"
  Examples:
    | query       | productArea      |
    | competition | Media & Telecoms |
    | takeovers   | Media & Telecoms |
    | mergers     | Media & Telecoms |

  Scenario Outline: verify search results prefiltered for what's market
    When has selected the link to the What's Market homepage
    And the user runs a free text search for the query "<query2>"
    And the user pauses for "3" seconds
    And the user can select the option to show most detail
    Then the user is able to verify that the result in position "<position>" is whats market content because it contains one of the whats market resource types
  Examples:
    | query2  | position |
    | tax     | 1        |
    | brand   | 1        |
    | fishing | 1        |
