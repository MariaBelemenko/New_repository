Feature: [714595][702169][702182][714594] ukKnowHowFacetsSelectAndDeselectTest.feature
  This feature include the below feature scenarios:

  1) ukKnowHowFacetsSelectAndDeselectTest1.feature - is a combination of ukKnowHowFacetsSelectAndDeselectTest1.feature/ukKnowHowFacetsSelectAndDeselectTest2.feature/ukKnowHowFacetsSelectAndDeselectTest3.feature
  2) ukKnowHowFacetsSelectAndDeselectTest4.feature
  3) ukKnowHowFacetsSelectionS2-47.feature - As a PL+ user when I select/deselect one or more facets on the search results page, then the results are updated according to the selected facet(s).
  4) ukKnowHowSearchFacetsDeselectedByDefaultS2-68.feature - As a PL+ user when I search without applying a pre-filter then the search results are returned and none of the facets are checked by default.
  Note: Removed the another scenario as remaining scenario has already covering that functionality.
  5) ukKnowHowSelectDeselectSingleFacet.feature - Combined 3 existing scenarios into single scenario.

  Background:
    Given PL+ user is logged in with following details
      | userName | Search1_AutoUser |

  Scenario Outline: [714595] verify search results updated in light of parent facet selections. verify search results updated in light of parent and child facet selections. verify search results updated in light of child facet selections
    When the user runs a free text search for the query "<query>"
    And the user is able to check whether the option to apply filters is displayed and  if not to ensure that it is
    And the user gets the know how search result count and stores it as count "1"
    And the user verifies that the know how parent facet "<facet1>" is not selected
    And the user expands the know how facet "<facet1>"
    And the user verifies that the know how child facet "<facet2>" is not selected
    And the user expands the know how facet "<facet2>"
    And the user verifies that the know how grandchild facet "<facet3>" is not selected
    And the user selects the know how parent facet "<facet1>"
    And the user selects the know how option to apply filters
    And the user verifies that the know how facet is selected "<facet1>"
    And the user selects the parent facet "<facet2>"
    And the user selects the know how option to apply filters
    And the user verifies that the know how facet is selected "<facet2>"
    And the user gets the know how search result count and stores it as count "2"
    And the user verifies that the know how search result count "2" is less than "1"
    And the user selects the know how child facet "<facet3>"
    And the user selects the know how option to apply filters
    And the user gets the know how search result count and stores it as count "3"
    And the user verifies that the know how search result count "3" is less than "2"
  Examples:
    | query    | facet1    | facet2       | facet3             |
    | taxation | Corporate | Acquisitions | Asset Acquisitions |

  Scenario Outline: [714595] verify search results updated in light of child facet deselection and parent facet selection
    When the user runs a free text search for the query "<query>"
    And the user is able to check whether the option to apply filters is displayed and  if not to ensure that it is
    And the user verifies that the know how parent facet "<facet1>" is not selected
    And the user expands the know how facet "<facet1>"
    And the user verifies that the know how child facet "<facet2>" is not selected
    And the user expands the know how facet "<facet2>"
    And the user verifies that the know how grandchild facet "<facet5>" is not selected
    And the user verifies that the know how parent facet "<facet1>" is not selected
    And the user expands the know how facet "<facet3>"
    And the user verifies that the know how child facet "<facet4>" is not selected
    And the user selects the know how child facet "<facet2>"
    And the user selects the know how option to apply filters
    And the user verifies that the know how facet is selected "<facet2>"
    And the user expands the know how facet "<facet3>"
    And the user verifies that the know how child facet "<facet4>" is not selected
    And the user selects the know how child facet "<facet4>"
    And the user selects the know how option to apply filters
    And the user verifies that the know how facet is selected "<facet4>"
    And the user verifies that the know how parent facet "<facet1>" is not selected
    And the user verifies that the know how parent facet "<facet3>" is not selected
    And the user gets the know how search result count and stores it as count "1"
    And the user selects the know how parent facet "<facet1>"
    And the user selects the know how option to apply filters
    And the user verifies that the know how facet is selected "<facet1>"
    And the user selects the know how parent facet "<facet3>"
    And the user selects the know how option to apply filters
    And the user verifies that the know how facet is selected "<facet3>"
    And the user verifies that the know how child facet "<facet2>" has been deselected
    And the user verifies that the know how child facet "<facet4>" has been deselected
    And the user gets the know how search result count and stores it as count "2"
    And the user verifies that the know how search result count "1" is less than "2"
  Examples:
    | query    | facet1    | facet2       | facet3  | facet4          | facet5                 |
    | taxation | Corporate | Acquisitions | Finance | Project finance | Acquisitions: Auctions |

  Scenario: [702169] Select facets and verify that number of results is reduced with each selection and that search results now tally with selected facets
    When the user runs a free text search for the query "taxation"
    And the user is able to check whether the option to apply filters is displayed and  if not to ensure that it is
    And the user gets the know how search result count and stores it as count "1"
    And the user selects the know how parent facet "Glossary"
    And the user selects the option to apply filters
    And the user verifies that the know how facet is selected "Glossary"
    And the user gets the know how search result count and stores it as count "2"
    And the user verifies that the know how search result count "2" is less than "1"
    And the user selects the know how parent facet "Corporate"
    And the user selects the option to apply filters
    And the user verifies that the know how facet is selected "Corporate"
    And the user gets the know how search result count and stores it as count "3"
    And the user verifies that the know how search result count "3" is less than "2"
    And the user selects the know how child facet "Private equity and venture capital"
    And the user selects the option to apply filters
    And the user verifies that the know how facet is selected "Private Equity And Venture Capital"
    And the user gets the know how search result count and stores it as count "4"
    And the user verifies that the know how search result count "4" is less than "3"
    And the user selects the know how parent facet "Wales"
    And the user pauses for "2" seconds
    And the user selects the option to apply filters
    And the user verifies that the know how facet is selected "Wales"
    And the user gets the know how search result count and stores it as count "5"
    And the user verifies that the know how search result count "5" is less than "4"
    And the user is able to verify that the search result in position "1" within the result list has the resource type "Glossary"
    And the user is able to verify that the search result in position "1" within the result list has the jurisdiction "Wales"
    And the user opens the result in position "1"
    And the user verifies that the product detail contains the practice area "PLC UK Pensions"

  Scenario: [702169] Deselect facets (parents and children) and verify that number of results is refreshed/increased with each deselection
    When the user runs a free text search for the query "taxation"
    And the user is able to check whether the option to apply filters is displayed and  if not to ensure that it is
    And the user gets the know how search result count and stores it as count "1"
    And the user selects the know how parent facet "Glossary"
    And the user selects the option to apply filters
    And the user verifies that the know how facet is selected "Glossary"
    And the user selects the know how parent facet "Pensions"
    And the user selects the option to apply filters
    And the user verifies that the know how facet is selected "Pensions"
    And the user gets the know how search result count and stores it as count "2"
    And the user deselects the know how facet "Pensions"
    And the user selects the option to apply filters
    And the user gets the know how search result count and stores it as count "3"
    And the user verifies that the know how search result count "2" is less than "3"
    And the user deselects the know how facet "Glossary"
    And the user selects the option to apply filters
    And the user gets the know how search result count and stores it as count "4"
    And the user verifies that the know how search result count "3" is less than "4"

  #this test is checking to make sure that all facets are deselected by default following a non filtered search
  #test also checks that parent facets are visible and that children and grandchildren are not visible
  Scenario Outline: [702182] verify facets in resource type group are not selected by default when user searches without a pre-filter
    When the user runs a free text search for the query "<query>"
    And the user is able to check whether the option to apply filters is displayed and  if not to ensure that it is
    Then the user is able to verify the presence of the facet group heading Resource Type
    And the user is able to verify the presence of the know how facet "<facet1>"
    And the user verifies that the know how parent facet "<facet1>" is not selected
    And the user is able to verify the presence of the facet group heading Practice Area
    And the user is able to verify the presence of the know how facet "<facet2>"
    And the user verifies that the know how parent facet "<facet2>" is not selected
    And the user is able to verify the presence of the facet group heading Jurisdiction
    And the user is able to verify the presence of the know how facet "<facet3>"
    And the user verifies that the know how parent facet "<facet3>" is not selected
    And the user verifies that the know how child facet "<facet4>" is not displayed
    And the user verifies that the know how grandchild facet "<facet5>" is not displayed
  Examples:
    | query    | facet1   | facet2       | facet3              | facet4                           | facet5          |
    | taxation | Glossary | Construction | Any UK jurisdiction | General Contract and Boilerplate | Project finance |

  Scenario Outline: [714594] verify facets deselected by default. verify results updated in line with selected child facet. parent of selected child facet now selected - verify child deselected and results updated
    When the user runs a free text search for the query "<query>"
    And the user is able to check whether the option to apply filters is displayed and  if not to ensure that it is
    And the user gets the know how search result count and stores it as count "1"
    And the user verifies that the know how parent facet "<facet1>" is not selected
    And the user expands the know how facet "<facet1>"
    And the user verifies that the know how child facet "<facet2>" is not selected
    And the user expands the know how facet "<facet2>"
    And the user verifies that the know how grandchild facet "<facet3>" is not selected
    And the user selects the know how child facet "<facet2>"
    And the user selects the know how option to apply filters
    And the user verifies that the know how facet is selected "<facet2>"
    And the user gets the know how search result count and stores it as count "2"
    And the user verifies that the know how search result count "2" is less than "1"
    And the user verifies that the know how parent facet "<facet1>" is not selected
    And the user selects the know how parent facet "<facet1>"
    And the user selects the know how option to apply filters
    And the user verifies that the know how facet is selected "<facet1>"
    And the user verifies that the know how child facet "<facet2>" is not selected
    And the user gets the know how search result count and stores it as count "3"
    And the user verifies that the know how search result count "2" is less than "3"
  Examples:
    | query    | facet1    | facet2      | facet3               |
    | taxation | Corporate | Company Law | Corporate Governance |