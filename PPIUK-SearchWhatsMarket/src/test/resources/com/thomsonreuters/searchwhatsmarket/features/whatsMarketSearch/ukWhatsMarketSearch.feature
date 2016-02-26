Feature: ukWhatsMarketSearch.feature - [702213][702225][731586][702218][702219]
  1) ukWhatsMarketBasicSearchS2-24.feature -  Perform a search from plc homepage and view results for What’s Market content.
  2) ukWhatsMarketClearAllFacets.feature
  3) ukWhatsMarketHomepageSearch.feature - Verify search from whats market tab and view results for What’s Market content. (Deal Type) link search from the What's Market homepage - As a PL+ user, when I select a "topic" link from the What's Market homepage, then I will see search results for that "topic" as if I had performed a search for that deal type.

  Background: Log on to test site
    Given PL+ user is logged in

  @e2e @prod
  Scenario Outline: [702213] run a search request against whats market content from the plc homepage and obtain valid results
    And has selected the link to the What's Market homepage
    When the user runs a free text search for the query "<query2>"
    And the user pauses for "3" seconds
    And the user can select the option to show most detail
    Then the user is able to verify that the result in position <result> is whats market content because it contains at least one of the following transaction types
  Examples:
    | query2                          | result |
    | finsbury food group plc placing | 1      |

  Scenario:[702225] WM search results are returned on the WM Search Result page then by default 5 facets are displayed per facet type with an option to see more
    And has selected the link to the What's Market homepage
    When the user runs a free text search for the query "taxation"
    And the user pauses for "3" seconds
    And the user is able to check whether the option to apply filters is displayed and  if not to ensure that it is
    #the test below covers expansion and collapse of facets - see code
    Then the user is able to verify that the facets by default 5 facets are displayed/expanded per facet type with an option to see more

  Scenario:[731586] Verify that the clear all link clears all selected whats market facets
    And has selected the link to the What's Market homepage
    And the user is able to check whether the option to apply filters is displayed and  if not to ensure that it is
    When the user runs a free text search for the query "taxation"
    And the user pauses for "3" seconds
    And the user selects the whats market facet "Secondary issues"
    And the user selects the whats market facet "Computer and electronic equipment"
    And the user selects the option to apply filters
    And the user verifies that the whats market facet "Secondary issues" is selected
    And the user verifies that the whats market facet "Computer and electronic equipment" is selected
    When the user clicks on clear all link
    And the user verifies that the whats market facet "Secondary issues" is not selected
    And the user verifies that the whats market facet "Computer and electronic equipment" is not selected

  Scenario: [702218] verify that when a search is run from the whats market tab then results are prefiltered/scoped to the whats market tab
    And has selected the link to the What's Market homepage
    When the user runs a free text search for the query "tax"
    And the user pauses for "3" seconds
    And the user can select the option to show most detail
    Then the user is able to verify that the result in result position is whats market content because it contains one of the whats market resource types
      | 1 |
      | 2 |
      | 3 |

  Scenario:[702219] Verify that selecting a topic link within whats market automatically runs a search against the relevant content and displays results
    And has selected the link to the What's Market homepage
    And has selected the link to "Joint ventures"
    Then the user verifies that the result at position in the result list has the deal type
      | 1 | Joint ventures |
      | 2 | Joint ventures |
      | 3 | Joint ventures |
    When the user runs a free text search for the query "mining"
    And the user pauses for "3" seconds
    Then the user verifies that the result at position in the result list has the deal type
      | 1 | Joint ventures |
      | 2 | Joint ventures |
      | 3 | Joint ventures |

