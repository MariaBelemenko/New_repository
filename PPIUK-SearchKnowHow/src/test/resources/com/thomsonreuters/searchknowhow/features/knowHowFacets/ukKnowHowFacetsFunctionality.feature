Feature: ukKnowHowFacetsFunctionality.feature - [713885] [702173] [710581] [728696] [702155] [702183] [702185] [702183] [702185] [702196] [715334]
  The below given features are consolidated and refactored into this feature file.
  1) ukKnowHowAndOperatorAcrossFacetGroups.feature
  2) ukKnowHowFacetGroupsS2-52.feature -  As a PL+ user, when I conduct a search and I am viewing search results, I will see facet types available for me to apply to my results.
  3) ukKnowHowFacetCheckboxBehaviour.feature
  4) ukKnowHowFacetCount.feature - S2-76 As a PL+ user, when I search Know How then the result count is returned for each Know How facet
  Note: Removed the first 2 scenarios[702155], these functionality is covered as part of the 713885 scenarios
  5) ukKnowHowFacetsAlphabeticalOrder.feature - As a PL+ User when I am viewing Know How facet types containing parent and child facets I want to view parent and child facets in alphabetical order (Practice Area Story)
  6) ukKnowHowExpandCollapseFacets.feature
  As a PL+ user I should be able to expand or collapse each Practice Area facet to show or hide topics.
  As a PL+ user I should be able to expand or collapse each Resource Type facet to show or hide topics.
  7) ukKnowHowExpandCollapseFacets.feature
  As a PL+ user I should be able to expand or collapse each Practice Area facet to show or hide topics.
  As a PL+ user I should be able to expand or collapse each Resource Type facet to show or hide topics.
  8) ukKnowHowLogicAcrossFacetsS2-80.feature - Use of OR operators within each facet type, and AND operators across the different facet types.
  9) ukKnowHowNewSearchClearsAllFacets.feature - When a PL+ user performs another search after selecting a facet on the search result page then the selected facet will be deselected and the results are returned accordingly.
  Note: Refactored the existing two scenarios into single scenario.

  Background: Log on to test site
    Given PL+ user is logged in

  @e2e @prod
  Scenario: [713885] Verify that when two or more facets are selected across facet groups then results are updated using the "and" operator
    When the user runs a free text search for the query "taxation"
    And the user pauses for "3" seconds
    And the user is able to check whether the option to apply filters is displayed and  if not to ensure that it is
    And the user selects the know how "Resource Type" facet "Glossary"
    And the user pauses for "3" seconds
    And the user selects the know how option to apply filters
    And the user verifies that the know how facet is selected "Glossary"
    And the user gets the know how facet "Glossary" count and stores it as count "1"
    And the user selects the know how parent facet "Employment"
    And the user verifies that the know how facet is selected "Employment"
    And the user selects the know how option to apply filters
    And the user gets the know how facet "Employment" count and stores it as count "2"
    And the user gets the know how search result count and stores it as count "3"
    And the user verifies that the know how search result count "3" equals facet count "2"
    And the user verifies that the know how search result count "2" is less than "1"

  Scenario: [713885] Verify that when two or more facets are deselected then results are updated using the "and" operator
    When the user runs a free text search for the query "taxation"
    And the user pauses for "3" seconds
    And the user is able to check whether the option to apply filters is displayed and  if not to ensure that it is
    And the user selects the know how parent facet "Glossary"
    And the user verifies that the know how facet is selected "Glossary"
    And the user selects the know how option to apply filters
    And the user selects the know how parent facet "Checklists"
    And the user verifies that the know how facet is selected "Checklists"
    And the user selects the know how option to apply filters
    And the user gets the know how search result count and stores it as count "1"
    And the user selects the know how parent facet "Corporate"
    And the user verifies that the know how facet is selected "Corporate"
    And the user selects the know how option to apply filters
    And the user selects the know how parent facet "Employment"
    And the user verifies that the know how facet is selected "Employment"
    And the user selects the know how option to apply filters
    And the user gets the know how search result count and stores it as count "2"
    And the user verifies that the know how facet count "2" is less than "1"
    And the user deselects the know how facet "Glossary"
    And the user verifies that the know how parent facet "Glossary" is not selected
    And the user deselects the know how facet "Corporate"
    And the user verifies that the know how parent facet "Corporate" is not selected
    And the user selects the know how option to apply filters
    And the user gets the know how facet "Employment" count and stores it as count "2"
    And the user gets the know how search result count and stores it as count "3"
    And the user verifies that the know how search result count "3" equals facet count "2"
    And the user verifies that the know how facet count "3" is less than "1"

  Scenario Outline: [702173] Run a very general know how search request and validate facet groups are present on results page (resource type/practice area and jurisdiction)
    When the user runs a free text search for the query "<query>"
    And the user pauses for "3" seconds
    Then the user verifies the presence of the know how facet groups
  Examples:
    | query |
    | tax   |

  @e2e @prod
  Scenario Outline: [710581] verify child facet not selected when parent is selected and that selecting a child deselects the parent
    When the user runs a free text search for the query "<query>"
    And the user pauses for "3" seconds
    And the user is able to check whether the option to apply filters is displayed and  if not to ensure that it is
    And the user verifies that know how "Practice Area" facet "<facet1>" is not selected
    And the user selects the know how parent facet "<facet1>"
    And the user selects the know how option to apply filters
    And the user verifies that know how "Practice Area" facet "<facet2>" is not selected
    And the user selects the know how "Practice Area" facet "<facet2>"
    And the user selects the know how option to apply filters
    And the user verifies that know how "Practice Area" facet "<facet1>" is not selected
  Examples:
    | query    | facet1       | facet2                 |
    | taxation | Construction | Construction_Insurance |

  @e2e @prod
  Scenario Outline: [710581] Verify search without modification of query discards all selected facets
    When the user runs a free text search for the query "<query>"
    And the user pauses for "3" seconds
    And the user is able to check whether the option to apply filters is displayed and  if not to ensure that it is
    And the user selects the know how "Resource Type" facet "<facet1>"
    And the user selects the know how "Practice Area" facet "<facet2>"
    And the user selects the know how "Jurisdiction" facet "<facet3>"
    And the user selects the know how option to apply filters
    Then the user verifies that know how "Resource Type" facet "<facet1>" is selected
    And the user verifies that know how "Practice Area" facet "<facet2>" is selected
    And the user verifies that know how "Jurisdiction" facet "<facet3>" is selected
    When the user runs a free text search for the query "<query>"
    Then the user verifies that know how "Resource Type" facet "<facet1>" is not selected
    And the user verifies that know how "Practice Area" facet "<facet2>" is not selected
    And the user verifies that know how "Jurisdiction" facet "<facet3>" is not selected
  Examples:
    | query    | facet1   | facet2     | facet3              |
    | taxation | Glossary | Employment | Any UK jurisdiction |

  Scenario Outline: [710581] Verify search with modification of query discards all selected facets
    When the user runs a free text search for the query "<query>"
    And the user pauses for "3" seconds
    And the user is able to check whether the option to apply filters is displayed and  if not to ensure that it is
    And the user selects the know how "Resource Type" facet "<facet1>"
    And the user selects the know how "Practice Area" facet "<facet2>"
    And the user selects the know how "Jurisdiction" facet "<facet3>"
    And the user selects the know how option to apply filters
    Then the user verifies that know how "Resource Type" facet "<facet1>" is selected
    And the user verifies that know how "Practice Area" facet "<facet2>" is selected
    And the user verifies that know how "Jurisdiction" facet "<facet3>" is selected
    When the user runs a free text search for the query "<query2>"
    Then the user verifies that know how "Resource Type" facet "<facet1>" is not selected
    And the user verifies that know how "Practice Area" facet "<facet2>" is not selected
    And the user verifies that know how "Jurisdiction" facet "<facet3>" is not selected
  Examples:
    | query    | query2   | facet1   | facet2     | facet3              |
    | taxation | contract | Glossary | Employment | Any UK jurisdiction |

  Scenario: [no applicable story] verify that when the select multiple filter mode is cancelled facets are updated straight away
    When the user is on a know how search results page following a search for the term "fishing" and has stored the result count
    And the user is able to check whether the option to apply filters is displayed and  if not to ensure that it is
    Then the user can select the filter mode cancel option
    And the user pauses for "3" seconds
    And the user can verify the presence of the option entitled select multiple filters
    And the user selects the know how parent facet "Family"
    And the user pauses for "3" seconds
    And the user verifies that the facet is instantly applied and the search result count updated accordingly

  Scenario:[728696] verify no know how facets with a count of 0 are displayed
    When the user runs a free text search for the query "law"
    And the user pauses for "3" seconds
    And the user is able to check whether the option to apply filters is displayed and  if not to ensure that it is
    And the user pauses for "5" seconds
    And the user verifies that the facet count for all the individual facets is not "0"
    And the user verifies that the facet count for all the individual facets is not ""
    And the user verifies that the facet count for all the individual facets does not contain "-"

  Scenario: [702173] verify that parent practice area facets are listed in alphabetical order
    When the user runs a free text search for the query "taxation"
    And the user is able to check whether the option to apply filters is displayed and  if not to ensure that it is
    Then the user is able to verify the presence of the know how facets
      | Commercial         |
      | Dispute Resolution |
      | Construction       |
    And the user verifies "Practice Area" facets appear in alphabetical order

  Scenario: [702173] verify that child and grandchild practice area facets are listed in alphabetical order
    When the user runs a free text search for the query "taxation"
    And the user pauses for "3" seconds
    And the user is able to check whether the option to apply filters is displayed and  if not to ensure that it is
    And the user expands the know how facet "Corporate"
    And the user is able to verify the presence of the know how facet "Company Law"
    And the user is able to verify the presence of the know how facet "Acquisitions"
    And the user verifies know how child Practice Area "Corporate" facets appear in alphabetical order
    And the user expands the know how facet "Acquisitions"
    And the user is able to verify the presence of the know how facet "Asset Acquisitions"
    And the user is able to verify the presence of the know how facet "Public Mergers and Acquisitions"
    And the user verifies know how grandchild Practice Area "Acquisitions" facets appear in alphabetical order

  Scenario:[702183] verify expansion of parent facet to display child and collapse of parent facet
    When the user runs a free text search for the query "tax"
    And the user pauses for "3" seconds
    And the user is able to check whether the option to apply filters is displayed and  if not to ensure that it is
    And the user expands the know how facet "Corporate"
    And the user can verify the presence of a child topic entitled "Acquisitions"
    And the user collapses the know how facet "Corporate"
    And the user can verify that the topic is no longer displayed "Acquisitions"

  Scenario: [702185] verify expansion and collapse of resource type facets showing and hiding sub resources
    #note there are no grandchildren to test as at 09/03/15
    When the user runs a free text search for the query "income tax"
    And the user pauses for "3" seconds
    And the user is able to check whether the option to apply filters is displayed and  if not to ensure that it is
    And the user verifies the presence of the know how facet "Standard Documents and Clauses"
    And the user expands the know how facet "Standard Documents and Clauses"
    And the user verifies the presence of the know how child facet "Standard clauses"
    And the user collapses the know how facet "Standard Documents and Clauses"
    Then the user verifies that the know how child facet "Standard clauses" is not displayed

    #endeavouring to verify that or logic is used across facets within the same group in the test below - if and were used as the logic
    #then in most cases the number of results displayed when two facets are selected would be lower than the original individual total for those results
    #accordingly since the logic across facets within the same group is actually "or" then the total number of results displayed when two
    #facets are selected should not dip below the individual original totals for each
    #best test for this logic is practice areas since resource types and jurisdictions are largely mutually exclusive and do not form as good a basis for the test
  Scenario Outline: [702196] verify "or" logic used between facets forming part of the same facet group - practice areas
    When the user runs a free text search for the query "<query>"
    And the user pauses for "3" seconds
    And the user is able to check whether the option to apply filters is displayed and  if not to ensure that it is
    And the user starts a new record of facet counts
    And the user verifies the presence of the know how facet "<facet1>"
    And the user verifies the presence of an associated know how facet "<facet1>" count
    And the user gets the know how facet "<facet1>" count and stores it as count "1"
    And the user selects the know how parent facet "<facet1>"
    And the user selects the know how option to apply filters
    And the user verifies that the know how facet is selected "<facet1>"
    And the user verifies the presence of the know how facet "<facet2>"
    And the user verifies the presence of an associated know how facet "<facet2>" count
    And the user gets the know how facet "<facet2>" count and stores it as count "2"
    And the user selects the know how parent facet "<facet2>"
    And the user selects the know how option to apply filters
    And the user verifies that the know how facet is selected "<facet2>"
    And the user gets the know how search result count and stores it as count "3"
    And the user verifies that the know how search result count "3" exceeds facet count "1"
    And the user verifies that the know how search result count "3" exceeds facet count "2"
  Examples:
    | query       | facet1     | facet2      |
    | food safety | Employment | Environment |

    #get the facet count for the individual facets and then when the facets are selected - verify that the result for the first facet now matches the count for the second
    #also verify that the count for the search results on the page has now reduced and equals the facet count for the second selected facet (which is a subset of the first selected facet)
  Scenario Outline: [702196] Verify that when two facets are selected across facet groups then results are updated using the "and" operator
    When the user runs a free text search for the query "<query>"
    And the user pauses for "3" seconds
    And the user is able to check whether the option to apply filters is displayed and  if not to ensure that it is
    And the user starts a new record of facet counts
    And the user selects the know how parent facet "<facet1>"
    And the user verifies that the know how facet is selected "<facet1>"
    And the user selects the know how option to apply filters
    And the user gets the know how facet "<facet1>" count and stores it as count "1"
    And the user selects the know how parent facet "<facet2>"
    And the user verifies that the know how facet is selected "<facet2>"
    And the user selects the know how option to apply filters
    And the user gets the know how facet "<facet2>" count and stores it as count "2"
    And the user gets the know how facet "<facet1>" count and stores it as count "3"
    And the user gets the know how search result count and stores it as count "4"
    And the user verifies that the know how search result count "4" equals facet count "2"
    And the user verifies that the know how facet count "3" is less than "1"
    And the user verifies that the know how facet count "3" equals count "2"
  Examples:
    | query    | facet1   | facet2     |
    | taxation | Glossary | Employment |

  Scenario Outline: [715334] verify all selected facets are cleared with a new search request or same search request
    When the user runs a free text search for the query "<query>"
    And the user pauses for "3" seconds
    And the user is able to check whether the option to apply filters is displayed and  if not to ensure that it is
    And the user selects the know how parent facet "<facet1>"
    And the user verifies that the know how facet is selected "<facet1>"
    And the user runs a free text search for the query "<query2>"
    And the user pauses for "10" seconds
    And the user verifies that the know how parent facet "<facet1>" is not selected
  Examples:
    | query | facet1    | query2  |
    | tax   | Corporate | fishing |
    | tax   | Corporate | tax     |

  @e2e @prod
  Scenario: Verify "Select Multiple Filter" in Search
    Given the user searches for "Tax"
    When the user applies multiple filters
      | Commercial | Competition | EU | Family |
    Then the user sees the search result count updated accordingly
