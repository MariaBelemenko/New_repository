Feature: [702211][779805] ukKnowHowSearchResultChangeDetailLevelS2-90.feature
  [702211] As a PL+ user I should be able to change my view of the level of detail that I can see for my search results,  so that I can view either full or limited information about each search result.
  [779805] Practice Area Legal Update Results: Less/More/Most

  Scenario:[702211] Verify setting for more/most/less detail
    Given PL+ user is logged in
    When the user runs a free text search for the query "taxation"
    Then the user can verify that search results are displayed according to detail selection
    |MORE|
    |MOST|
    |LESS|

  Scenario:[779805] Verify setting for more/most/less details,practice area legal updates
    Given PL+ user is logged in
    And has selected the homepage practice area link to "Arbitration"
    And has selected the link to View All on the Legal Updates Widget
    Then the user can verify that search results are displayed according to detail selection
      |MORE|
      |MOST|
      |LESS|

  Scenario:[780171] Verify setting for more/most/less details, setting for topic level area legal updates
    Given PL+ user is logged in
    And has selected the homepage practice area link to "Corporate"
    And has selected the topic link to "Directors"
    And has selected the link to View All on the Legal Updates Widget
    Then the user can verify that search results are displayed according to detail selection
      |MOST|
      |MORE|
      |LESS|

  Scenario:[779805/780171/702211] Verify default setting for more detail reflects previous user session setting for practice area legal updates
    Given PL+ user is logged in with following details
    |newSession|true|
    When the user runs a free text search for the query "Corporate"
    And the user can verify that the less detail icon is displayed
