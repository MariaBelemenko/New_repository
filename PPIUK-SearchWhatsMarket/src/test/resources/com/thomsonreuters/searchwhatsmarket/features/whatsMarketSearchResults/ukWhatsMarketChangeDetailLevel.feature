Feature: [705430] ukWhatsMarketChangeDetailsLevel.feature
  As a PL+ user I should be able to change my view of the level of detail that I can see for my What's Market search results,  so that I can view either full or limited information about each search result
  LESS/MORE/MOST - (WHATs Market)

  Scenario: Verify default setting for more detail reflects previous user session setting
    Given PL+ user is logged in with following details
      | userName | Search2_AutoUser |
    And has selected the link to the What's Market homepage
    When the user runs a free text search for the query "taxation"
    And the user can select the option to show more detail

  Scenario: Verify setting for more detail
    Given PL+ user is logged in with following details
      | userName   | Search2_AutoUser |
      | newSession | TRUE             |
    And has selected the link to the What's Market homepage
    # Exclude "possible" from the results
    When the user runs a free text search for the query "merger million %possible"
    And the user is able to verify that the result in position "1" is whats market content because it contains one of the whats market resource types
    Then the user can verify that the more detail icon is displayed
    And the user is able to check whether the option to apply filters is displayed and  if not to ensure that it is
    And the user verifies the presence of the whats market facet "Secondary issues"
    And the user selects the whats market facet "Secondary issues"
    And the user selects the option to apply filters
    And the user is able to verify the presence of the resource title for the first result "1"
    And the user is able to verify the presence of a date of announcement for the first result "1"
    And the user is able to verify the presence of the deal value for the first result "2"
    And the user is able to verify that a deal summary for the first result is not displayed "1"

  Scenario: Verify setting for most detail
    Given PL+ user is logged in with following details
      | userName | Search2_AutoUser |
    And has selected the link to the What's Market homepage
    # A specific document is used here to ensure a deal summary is displayed
    When the user runs a free text search for the query "Possible offer for Kolar Gold Limited (strategic review including formal sale process)"
    And the user is able to verify that the result in position "1" is whats market content because it contains one of the whats market resource types
    Then the user can select the option to show most detail
    And the user can verify that the most detail icon is displayed
    And the user is able to verify the presence of the resource title for the first result "1"
    And the user is able to verify the presence of a deal summary for the first result "1"
    And the user is able to verify the presence of a date of announcement for the first result "1"

  Scenario: Verify setting for less detail
    Given PL+ user is logged in with following details
      | userName | Search2_AutoUser |
    And has selected the link to the What's Market homepage
    When the user runs a free text search for the query "merger and 2014"
    And the user is able to verify that the result in position "1" is whats market content because it contains one of the whats market resource types
    Then the user can select the option to show less detail
    And the user can verify that the less detail icon is displayed
    And the user is able to verify the presence of the resource title for the first result "1"
    And the user is able to verify that a deal summary for the first result is not displayed "1"
    And the user is able to verify that a date of announcement for the first result is not displayed "1"
    And the user is able to verify that a deal value for the first result is not displayed "1"
