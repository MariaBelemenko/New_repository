Feature: [706256] ukKnowHowResultsSortedByRelevancyOnAllTabsS2-57B.feature
  Know How Search Results are sorted by keyword relevancy even if I move from Know How tab to any other tab

  @wip
  Scenario: Sorting of results when doing a Know How search ( As this story needs to tested if the tabs are available in next release otherwise place on hold)
    #no tabbed search on site as at 30/07/15 not delivered for ppi phase 1
    Given PL+ user is logged in
    And the user runs a free text search for the query "contract"
    And the user verifies that the option for sorting by relevance is displayed by default
    And the user obtains the title of the first result and stores it
    And the user obtains the title of the second result and stores it
    And the user obtains the title of the third result and stores it
    And the user is able to select the link to whats market results
    And the user is able to select the link to know how results
    Then the user verifies that the option for sorting by relevance is displayed by default
    And the user is able to verify that the title of the first result is the same as the stored value
    And the user is able to verify that the title of the second result is the same as the stored value
    And the user is able to verify that the title of the third result is the same as the stored value
