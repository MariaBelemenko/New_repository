@wip
Feature: [690608] legislationSelectDeselectFacetSameGroup.feature
  As a PL+ User with a WLUK Subscription I want to select / deselect a single facet
  So that I can update / refresh my search results and view the data I am interested in researching


    Background: Log in to website
      Given PL+ user is logged in
      And user selects the combined Know How UK link

    Scenario Outline:
      And the user starts a new record of legislation facet counts
      When user clicks on UK Legislation
      When user enters "<search>" criteria
      And user clicks on Search button
      #get the facet count for two facets
      And the user gets the legislation facet count "<facet1>" and stores it as count "1"
      And the user gets the legislation facet count "<facet2>" and stores it as count "2"
      #select one of the facets
      And the user selects the legislation facet "<facet2>"
      And the user selects the legislation option to apply filters
      #get the search result count for the page
      And the user gets the legislation search result count and stores it as count "3"
      #verify search result count based on facet selected ie result count and facet count should match
      And the user verifies that the legislation search result count "3" equals the facet count "2"
      #verify facet counts not updated by verifying non selected facet still present and has same count
      And the user verifies the presence of the legislation facet "<facet1>"
      And the user gets the legislation facet count "<facet1>" and stores it as count "4"
      And the user verifies that legislation facet count "4" equals facet count "1"

    Examples:
      | search    |  facet1  | facet2  |
      | academies |  Other   | UK      |

 Scenario Outline:
    Given user clicks on UK Legislation
    When user enters "<search>" criteria
    And user clicks on Search button
    And the user gets the legislation facet count "<facet1>" and stores it as count "1"
    And the user gets the legislation facet count "<facet2>" and stores it as count "2"
    #select both of the facets
    And the user selects the legislation facet "<facet1>"
    And the user selects the legislation facet "<facet2>"
    #apply the filters
    And the user selects the legislation option to apply filters
    And the user verifies that the legislation facet "<facet1>" is selected
    And the user verifies that the legislation facet "<facet1>" is selected
    #deselect a facet
    And the user deselects the legislation facet "<facet1>"
    #apply the filters
    And the user selects the legislation option to apply filters
    And the user verifies "<facet1>" is no longer selected
    #get the search result count for the page
    And the user gets the legislation search result count and stores it as count "3"
    #get the facet count for the two facets once again now that one has been deselected
    And the user gets the legislation facet count "<facet1>" and stores it as count "4"
    And the user gets the legislation facet count "<facet2>" and stores it as count "5"
    #verify that the search result count is now based only on the selected facet by verifying that the count and the facet count match
    And the user verifies that the legislation search result count "3" equals the facet count "5"
    #verify that the facets are still displayed and that their count has not changed
    And the user verifies that the legislation facet "<facet1>" is displayed
    And the user verifies that legislation facet count "1" equals facet count "4"
    And the user verifies that the legislation facet "<facet2>" is displayed
    And the user verifies that legislation facet count "2" equals facet count "5"

 Examples:
   | search    |  facet1  | facet2  |
   | academies |  Other   | UK      |






