Feature: KnowHowGlobalSearch.feature - [702180] [750884][702204][729245][702178][702179]
  1) KnowHowGlobalSearchReturnsGlobalContentOnlyS2-63.feature - As a PL+ user, when I search from the Global content section then only content coded to Global (US/UK/International) is returned.
  2) ukCountryPageSearchResultsReturnedKnowHowTabS2-92.feature -
  If a PL+ user starts his search from the 'What's Market' page then What's Market content type Search Results are displayed on the Search Result page.
  If a PL+ user starts his search from the PLC Mag page then PLC Mag content type Search Results are displayed on the Search Result page.
  3) ukKnowHowScopedSearchPLCMagPageS2-96B.feature - As a PL+ user when I perform a scoped search from the 'PLC Magazine Page' then the Search results are returned on the Know How Tab
  4)combined the below two feature scenarios as a single one
  ukKnowHowUKSearchReturnsUKContentOnlyS2-62.feature -  As a PL+ user, when I search from the UK content section then only content coded to UK are returned.
  ukKnowHowUSSearchReturnsUSContentOnlyS2-61.feature -  As a PL+ user, when I search from the US content section then only content coded to US are returned.

  Scenario Outline: Verify search from Global site retrieves Global resources
    Given PL+ user is logged in
    When has selected the Know How - Global link
    And the user runs a free text search for the query "<query>"
    And opens the link associated with the first result
    Then it is clear to the user that results are restricted to Global content because the product details contain at least one of the following categories
  Examples:
    | query             |
    | china arbitration |

  Scenario Outline:[750884] As a user, I want the ability to view content with the PLC US product codes
    Given PL+ user is logged in
    When the user runs a free text search for the query "<searchTerm>"
    And the user pauses for "3" seconds
    And the user can open the first know how search result "1"
    And the user pauses for "3" seconds
    Then the user verifies that the product detail contains the practice area "<productArea>"
  Examples:
    | searchTerm                        | productArea       |
    | adv: "Timeline of the Chapter 11" | PLC US Bankruptcy |
    | adv: "Timeline of the Chapter 11" | PLC US Finance    |

  Scenario Outline: [702204] verify search results from a country page search are returned on the know how page
    Given PL+ user is logged in
    When the user selects the link to Know How Spain
    And the user runs a free text search for the query "<query>"
    And the user pauses for "3" seconds
    Then the user is able to verify that result "1" is filtered to the relevant jurisdiction "Spain"
  Examples:
    | query      |
    | disaster   |
    | tax        |
    | employment |
    | commercial |

  Scenario Outline: [729245] verify search results appear on know how tab and are scoped for PLC Magazine
    Given PL+ user is logged in
    When the user selects the link to the PLC magazine page
    And the user runs a free text search for the query "<query>"
    And the user pauses for "3" seconds
    And the user can open the first know how search result "1"
    And the user pauses for "3" seconds
    Then the user verifies that the product detail contains the practice area "<productArea>"
  Examples:
    | query             | productArea       |
    | treaty            | PLC Magazine (UK) |
    | taxation          | PLC Magazine (UK) |
    | Commercial        | PLC Magazine (UK) |
    | Disaster Recovery | PLC Magazine (UK) |

  Scenario Outline:[702178][702179] Search from UK site retrieves UK resources. Search from US site retrieves US resources
    Given PL+ user is logged in
    When has selected the Know How - <region> link
    And the user runs a free text search for the query "<query>"
    And the user pauses for "3" seconds
    Then the user is able to verify that result "1" is filtered to the relevant jurisdiction "<jurisdiction>"
  Examples:
    | region | query                                                                                         | jurisdiction        |
    | UK     | takeovers                                                                                     | Any UK jurisdiction |
    | US     | Investment Company Act of 1940 Exceptions: Guide for Transactional Lawyers                    | USA                 |
    | US     | Section 409A Six-month Delay, Short-term Deferral and Separation Pay Plan Analysis Flowcharts | USA                 |
