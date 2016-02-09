Feature: ukWhatsMarketFacetsFunctionality.feature -[702225][718866][728696][718866][702220]
  1)ukWhatsMarketExpandCollapseFacetsS2-45.feature -  As a PL+ user I should be able to expand or collapse each Topic to show or hide sub topics.
  2)ukWhatsMarketFacetCount.feature - S2-76 As a PL+ user, when I search Whats Market then the result count is returned for each Whats Market facet
  3)ukWhatsMarketFacetCountS2-76.feature S2-76  - This story is duplicate story so removed those features - As a PL+ user, when I search Whats Market then the result count is returned for each Whats Market facet (This is duplicate story)
  4)ukWhatsMarketFacetsSelectionS2-38.feature - As a PL+ user viewing What's Market search results, when I select /deselect one or more facets, then my What's Market results are updated accordingly.

  Background: Log on to test site
    Given PL+ user is logged in with following details
      | userName | Search2_AutoUser |
    And has selected the link to the What's Market homepage

  @wip
  Scenario Outline: [702225] As a PL+ user I should be able to expand or collapse each Topic to show or hide sub topics.
    #functionality has changed - no longer any facility to expand or collapse WM facets so this test NOT REQUIRED
    And the user runs a free text search for the query "<query>"
    And the user is able to verify that the result in position "<resultposition>" is whats market content because it contains one of the whats market resource types
    And the user expands the whats market facet "<area>"
    And the user is able to verify that the "<topicfacet>" is displayed
    And the user is able to select the option to collapse the facet entitled "<area>"
    And the user is able to verify that the "<topicfacet>" is no longer displayed
  Examples:
    | query | resultposition | area                | topicfacet             |
    | tax   | 1              | Deal type           | Secondary issues       |
    | tax   | 1              | Industry sector     | Equity Capital Markets |
    | tax   | 1              | Type of transaction | Acquisitions           |

  Scenario: [718866] verify whats market facet count present
    When the user runs a free text search for the query "law"
    Then the user verifies the presence of the whats market facet "Administrations"
    And the user verifies the presence of an associated whats market facet "Administrations" count
    And the user verifies the presence of the whats market facet "Secondary issues"
    And the user verifies the presence of an associated whats market facet "Secondary issues" count

  Scenario: [718866] verify whats market facet count for updated search request
    When the user runs a free text search for the query "law"
    And the user verifies the presence of the whats market facet "Secondary issues"
    And the user verifies the presence of an associated whats market facet "Secondary issues" count
    And the user gets the know how facet "Secondary issues" count and stores it as count "1"
    And the user runs a free text search for the query "mining"
    And the user verifies the presence of the whats market facet "Secondary issues"
    And the user verifies the presence of an associated whats market facet "Secondary issues" count
    And the user gets the know how facet "Secondary issues" count and stores it as count "2"
    And the user verifies that the whats market facet count "2" is less than "1"

  Scenario:[728696] verify whats market facets with a count of 1 or more are displayed
    When the user runs a free text search for the query "taxation"
    And the user gets all the facet counts for the displayed
    Then the user verifies that the facet count for all the individual facets has a value of 1 or greater

  Scenario:[728696] verify no whats market facets with a count of 0 are displayed
    When the user runs a free text search for the query "madeupword"
    Then the user verifies no facets will be displayed
    And the user verifies no facet type headers will be displayed

  Scenario: [702220] verify whats market results are updated with facet selection/deselection
    When the user runs a free text search for the query "taxation"
    And the user is able to check whether the option to apply filters is displayed and  if not to ensure that it is
    And the user gets the whats market search result count and stores it as count "1"
    And the user selects the whats market facet "Secondary issues"
    And the user selects the option to apply filters
    And the user selects the whats market facet "Food and beverage"
    And the user selects the option to apply filters
    And the user gets the whats market search result count and stores it as count "2"
    And the user verifies that the whats market search result count "2" is less than "1"
    And the user deselects the whats market facet "Food and beverage"
    And the user deselects the whats market facet "Secondary issues"
    And the user selects the option to apply filters
    And the user gets the whats market search result count and stores it as count "3"
    And the user verifies that the whats market search result count "3" equals the search result count "1"
