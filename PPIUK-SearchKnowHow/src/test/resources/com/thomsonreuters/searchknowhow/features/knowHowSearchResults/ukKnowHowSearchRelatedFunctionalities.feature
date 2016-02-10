Feature: [706631][702181][702209][702202][713886][702199]
  1) ukKnowHowDateFormat.feature
  2) ukKnowHowMetadataS2-67.feature - Have the ability to view relevant metadata for Know How search results.
  3) ukKnowHowPaginationNextPageS2-27.feature - As a PL+ user when I perform a search then search results are returned and displayed with pagination
  4) ukKnowHowPaginationS2-27.feature - As a PL+ user when I perform a search then search results are returned and displayed with pagination
  5) ukKnowHowResultListTermHighlightingS2-87.feature - As a PL+ user, when I perform a search, then I will see my search terms highlighted on the search results page.
  6) ukKnowHowSearchResultTotalNoResults.feature - Verify text displayed following an unsuccessful search
  7) ukKnowHowSpellingCorrectionsS2-84.feature - As a PL+ user when I search without applying a pre-filter then the search results are returned and none of the facets are checked by default.

  Background: Log on to test site
    Given PL+ user is logged in with following details
      | userName | Search1_AutoUser |

  Scenario: [706631] Know How Date Format
    Given PL+ user is logged in with following details
      | routing          | BETA |
      | mandatoryRouting | YES  |
    When the user runs a free text search for the query "contract"
    And the user is able to check whether the option to apply filters is displayed and  if not to ensure that it is
    And the user selects the parent facet "Legal Updates"
    And the user selects the know how option to apply filters
    And the user verifies that the know how facet is selected "Legal Updates"
    Then the user is able to verify that sample results contain a date in the "dd MMM yyyy" format

  Scenario Outline:[702181]Have the ability to view relevant metadata for Know How search results.
    When the user runs a free text search for the query "<query>"
    And the user can select the option to show more detail
    And the user is able to verify the presence of the title of the first result
    And the user is able to verify the presence of a resource type description
    And the user is able to verify that jurisdiction information is displayed
    And the user is able to verify that the content is either maintained or non maintained
    And the user is able to verify a brief description of the content
    And the user is able to verify that terms in context are displayed
  Examples:
    | query    |
    | taxation |

  Scenario:[702209] user verifies when perform a search then search results are returned and displayed with pagination
    And the user runs a free text search for the query "contract"
    And the user is able to verify the presence of page number "2"
    And the user is able to select the link to the next page
    And the user is able to verify the presence of page number "1"
    And the user is able to select the link to page "1"
    And the user is able to verify the presence of page number "2"

  Scenario: [702209] As a PL+ user when I perform a search then search results are returned and displayed with pagination
    Given PL+ user is logged in
    When the user runs a free text search for the query "contract"
    Then the user is able to verify the presence of below page numbers
      | 2 |
      | 3 |
      | 4 |
      | 5 |

  Scenario Outline:[702202] As a PL+ user, when I perform a search, then I will see my search terms highlighted on the search results page.
    When the user runs a free text search for the query "<query>"
    And the user can select the option to show most detail
    Then the user is able to verify that for result "<rank>" the search term "<highlightedTerm>" is highlighted within the snippet text
  Examples:
    | query    | rank | highlightedTerm |
    | contract | 1    | contract        |

  Scenario Outline:[713886] Verify text displayed following an unsuccessful search
    When the user runs a free text search for the query "<query>"
    Then the user can verify the presence of the text No Documents Found
  Examples:
    | query   |
    | blubber |

  Scenario Outline: [702199] Verify that corrected spelling displayed when misspelled search query inputted by user
    When the user runs a free text search for the query "<query>"
    Then the user is able to verify the display of the text Did You Mean
    And the user is able to verify the display of the corrected query "<correction>"
    And the user is able to select the link to the corrected search results
    And the user is able to verify that the free text field now contains the term "<correction2>"
  Examples:
    | query      | correction  | correction2 |
    | contactual | contractual | contractual |
