Feature: ukKnowHowSearchResultsSorting.feature - [702175] [706257][702174][702176][731598]
  1)ukKnowHowDefaultSortingS2-57.feature - As PL+ user when I search for Know How content then results are sorted by 'Keyword Relevancy' by default.
  Note: Removed the first scenario "verify that know how results are sorted by relevancy by default" as it is covering as part of remaining scenario in 702175
  2)ukKnowHowSortByDateLogicS2-58B.feature - Sort by date logic uk know how
  3)ukKnowHowSortByRelevancyS2-56.feature - verify sort results by keyword relevancy - this test does not validate the relevancy logic only that results from relevancy are not sorted by date
  4)ukKnowHowSortByDateS2-58.feature -   This test is covered as part of 702174 - Verify sort results by date - this test does not validate the date sorting logic only that results sorted by date are different from relevancy and that the sort by date text is displayed
  5)ukKnowHowJurisdictionOrdering.feature - Bespoke order for UK jurisdiction facets

  Background: Log on to test site
    Given PL+ user is logged in with following details
      | userName | Search1_AutoUser |

  Scenario: [702175]  verify that know how results are sorted by relevancy by default. Verify that a new search following the first search produces results sorted by relevancy by default
    When the user runs a free text search for the query "contract"
    Then the user verifies that the option for sorting by relevance is displayed by default
    And the user clears all text from the search field
    And the user runs a free text search for the query "taxation"
    And the user verifies that the option for sorting by relevance is displayed by default

  @e2e @prod
  Scenario: [706257] Sort by date logic uk know how
    When the user runs a free text search for the query "crowdfunding"
    And the user can select the option to sort by "Date"
    Then the user verifies that the option for sorting by date is displayed
    And the user verifies that the result in position is maintained
      | 1 |
      | 2 |
      | 3 |

  #test below is not ideal - there is no way to verify the algorithm used for relevancy so have been obliged to rely on the fact that
  #once the option to sort by relevance is selected then the first three results should match the results displayed
  #before the user elected to sort by date
  @e2e @prod
  Scenario: [702176] [702174] Verify sort results by date. Verify that the user is able to sort search results by relevancy
    When the user runs a free text search for the query "contract"
    And the user verifies that the option for sorting by relevance is displayed by default
    And the user obtains the title of the first result and stores it
    And the user obtains the title of the second result and stores it
    And the user obtains the title of the third result and stores it
    And the user can select the option to sort by "Date"
    And the user can verify that the title of the first result is not the same as the stored value
    And the user can verify that the title of the second result is not the same as the stored value
    And the user can verify that the title of the third result is not the same as the stored value
    And the user can select the option to sort by "Relevance"
    Then the user is able to verify that the title of the first result is the same as the stored value
    And the user is able to verify that the title of the second result is the same as the stored value
    And the user is able to verify that the title of the third result is the same as the stored value

    
  Scenario: [731598] Verify know how jurisdiction facets are displayed in bespoke order
    When the user runs a free text search for the query "tax"
    And the user verifies that the know how Jurisdiction facets appear in bespoke order
