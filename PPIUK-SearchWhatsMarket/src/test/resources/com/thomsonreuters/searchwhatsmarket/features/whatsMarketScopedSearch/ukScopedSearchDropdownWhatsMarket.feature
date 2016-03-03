Feature: [792551][792565][729246] ukScopedSearchDropdownWhatsMarket.feature
  ukScopedSearchWhatsMarketPageS2-96C.feature -  As a PL+ user when I perform a scoped search from the 'What's Market' page (tab) then results are prefiltered/scoped for Whats Market

  Background: Log on to test site with user having routing set to view the product details
    Given PL+ user is logged in
    And the user is on the home page

  Scenario: [792551] - Scoped search on what's market pages
    And has selected the link to the What's Market homepage
    Then the user can verify that the scoped search dropdown states "What's Market"
    And the user can display the scoped search dropdown menu options
    And the user can verify that the dropdown options include "All Content"
    When the user runs a free text search for the query "deal"
    Then the user can verify that the scoped search dropdown states "What's Market"
    And the user can verify that the title listed above the search results is "What's Market "
    And the user can select the option to show most detail
    And the user is able to verify that the result in position "1" is whats market content because it contains one of the whats market resource types

  Scenario Outline: [792565] - Scoped search on what's market deal type pages
    And has selected the link to the What's Market homepage
    And has selected the link to the deal type "<dealType>"
    Then the user can verify that the scoped search dropdown states "<dealType>"
    And the user can display the scoped search dropdown menu options
    And the user can verify that the dropdown options include "All Content"
    When the user runs a free text search for the query "deal"
    Then the user can verify that the scoped search dropdown states "<dealType>"
    And the user can verify that the title listed above the search results is "<dealType>"
  #Note there isn't spaces between M & and A
    And the user is able to verify that the result in position "1" has the deal type "Public M&A"
  Examples:
    | dealType     |
    | Public M & A |

  ## Please rerun the below scenario if it fails the first time. It should pass in rerun
  Scenario Outline: [729246] - Verify search results prefiltered for what's market
    When has selected the link to the What's Market homepage
    And the user runs a free text search for the query "<query2>"
    And the user can select the option to show most detail
    Then the user is able to verify that the result in position "<position>" is whats market content because it contains one of the whats market resource types
  Examples:
    | query2  | position |
    | tax     | 1        |
    | brand   | 1        |
    | fishing | 1        |

  Scenario: Verify the scoped search dropdown options when a user navigates to a comparison report from a what's market page
    And has selected the link to the What's Market homepage
    When the user runs a free text search for the query "law"
    And the user is able to check whether the option to apply filters is displayed and  if not to ensure that it is
    And the user verifies the presence of the whats market facet "Administrations"
    And the user selects the whats market facet "Administrations"
    And the user selects the option to apply filters
    And the user selects the checkbox associated with whats market result "1"
    And the user selects the checkbox associated with whats market result "2"
    And the user selects the checkbox associated with whats market result "3"
    And the user selects the compare button
    And the user verifies the presence of the heading Deal Comparison Report
    Then the user can verify that the scoped search dropdown states "What's Market"
    And the user can display the scoped search dropdown menu options
    And the user can verify that the dropdown options include "All Content"

  Scenario: Verify the scoped search dropdown options when a user navigates to a comparison report from a deal type page
    And has selected the link to the What's Market homepage
    And has selected the link to the deal type "Public M & A"
    And the user selects the checkbox associated with whats market result "1"
    And the user selects the checkbox associated with whats market result "2"
    And the user selects the checkbox associated with whats market result "3"
    And the user selects the compare button
    And the user verifies the presence of the heading Deal Comparison Report
    Then the user can verify that the scoped search dropdown states "Public M & A"
    And the user can display the scoped search dropdown menu options
    And the user can verify that the dropdown options include "All Content"
