Feature: [712496][706631][702217][731605] ukWhatsMarketSorting.feature
  Ensure sorting of search results is correct and can be sorted in different ways
  The following scenarios test the following stories:
  [712496], [706631], [702217], [731605]

  Scenario: Know How Search Result DATE FORMAT
    Given PL+ user is logged in with following details
        | userName          | Search2_AutoUser       |
    And the user runs a free text search for the query "taxation"
    And the user is able to check whether the option to apply filters is displayed and  if not to ensure that it is
    And the user selects the know how parent facet "Legal Updates"
    And the user selects the option to apply filters
    Then the results displayed with date in "dd MMM yyyy" format
    And results date should contain 0 if day has single digit in date
      
  Scenario: What's Market Search Result DATE FORMAT
    Given PL+ user is logged in with following details
      | userName          | Search2_AutoUser       |
    When has selected the link to the What's Market homepage
    When the user runs a free text search for the query "taxation"
    Then results date should contain 0 if day has single digit in date
    Then the results displayed with date in "dd MMM yyyy" format
    Then the results displayed with sorted by date with most recent first

  Scenario: [731605] Whats Market Facet Display Order
    Given PL+ user is logged in with following details
      | userName          | Search2_AutoUser       |
    And the user selects the link entitled Whats Market UK Home
    And the user runs a free text search for the query "law"
    And the user selects the more link for the facet group "Deal Type"
    And the user selects the whats market facet "Administrations" on popup
    And the user clicks the filter button on more facet group popup
    And the user selects the option to apply filters
    And the user verifies "Industry Sector" facets appear in alphabetical order
    And the user selects the option to clear all filters
    And the user selects the more link for the facet group "Deal Type"
    And the user selects the whats market facet "Public M&A deals" on popup
    And the user clicks the filter button on more facet group popup
    And the user selects the option to apply filters
    And the user verifies Main Market is listed first then AIM under 'Market' facet group
    And the user selects the option to clear all filters
    And the user selects the more link for the facet group "Deal Type"
    And the user selects the whats market facet "IPOs: AIM" on popup
    And the user selects the whats market facet "IPOs: Main Market" on popup
    And the user selects the whats market facet "Secondary issues" on popup
    And the user clicks the filter button on more facet group popup
    And the user selects the option to apply filters
    And the user verifies Yes is listed before No under 'Underwritten' facet group
    And the user selects the option to clear all filters
    And the user selects the more link for the facet group "Deal Type"
    And the user selects the whats market facet "Public M&A deals" on popup
    And the user clicks the filter button on more facet group popup
    And the user selects the option to apply filters
    And the user verifies facets under 'Value' are ordered from smallest to largest
    And the user selects the option to clear all filters
    And the user selects the more link for the facet group "Deal Type"
    And the user selects the whats market facet "AGMs: FTSE 350: 2015" on popup
    And the user selects the whats market facet "AGMs: FTSE 350: 2014" on popup
    And the user selects the whats market facet "AGMs: FTSE 350: 2013" on popup
    And the user clicks the filter button on more facet group popup
    And the user selects the option to apply filters
    And the user verifies facets under 'Deal Type' are ordered by decreasing facet count
    And the user selects the option to clear all filters
    And the user selects the more link for the facet group "Deal Type"
    And the user selects the whats market facet "Administrations" on popup
    And the user clicks the filter button on more facet group popup
    And the user selects the option to apply filters
    And the user verifies facets under 'Date' are ordered most recent first
    And the user selects the option to clear all filters
    And the user selects the more link for the facet group "Deal Type"
    And the user selects the whats market facet "Listing Rules transactions" on popup
    And the user clicks the filter button on more facet group popup
    And the user selects the option to apply filters
    And the user verifies "Type of transaction" facets appear in alphabetical order
    And the user selects the option to clear all filters
    And the user selects the more link for the facet group "Deal Type"
    And the user selects the whats market facet "Reorganisations and schemes" on popup
    And the user selects the whats market facet "Demergers" on popup
    And the user clicks the filter button on more facet group popup
    And the user selects the option to apply filters
    And the user verifies "Type of reorganisation" facets appear in alphabetical order
    And the user verifies "Structure of demerger" facets appear in alphabetical order
    And the user selects the option to clear all filters
    And the user selects the more link for the facet group "Deal Type"
    And the user selects the whats market facet "Returns of value to shareholders" on popup
    And the user clicks the filter button on more facet group popup
    And the user selects the option to apply filters
    And the user verifies "Type of return" facets appear in alphabetical order
    And the user selects the option to clear all filters
    And the user selects the more link for the facet group "Deal Type"
    And the user selects the whats market facet "Secondary issues" on popup
    And the user clicks the filter button on more facet group popup
    And the user selects the option to apply filters
    And the user verifies "Structure of issue" facets appear in alphabetical order
    And the user selects the option to clear all filters
    And the user selects the more link for the facet group "Deal Type"
    And the user selects the whats market facet "Listed company restructurings" on popup
    And the user clicks the filter button on more facet group popup
    And the user selects the option to apply filters
    And the user verifies "Nature of restructuring" facets appear in alphabetical order
    And the user selects the option to clear all filters
    And the user selects the more link for the facet group "Deal Type"
    And the user selects the whats market facet "Administrations" on popup
    And the user clicks the filter button on more facet group popup
    And the user selects the option to apply filters
    And the user verifies facets under 'Administrators: firm name' are ordered by decreasing facet count
    And the user verifies facets under 'Administrators: location' are ordered by decreasing facet count
