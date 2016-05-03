Feature: [685245, 685246] As a Know How user,
  I want the ability to search for glossary terms,
  So that view the relevant results and glossary document.

  Background:
    Given PL+ user is logged in
    And user navigates to a glossary page

  Scenario: Verification of the search text box
    Then the user should be able to see the Search text box on the right hand side of the page
    And the search text "Find in list" should be pre-populated in the textbox
    When searches for the term "sear" using the glossary search
    Then the user should be able to see a list of resulting glossary terms containing this search "sear" highlighted
    And the first result item's definition should be displayed in the right hand pane
    And clicking on listed result 3 displays the corresponding definition on the right hand page
    And no alphabets are selected while the search is active

  Scenario: Verify the closing of search box functionality
    When the user has selected the letter "H" from the tabbed alphabet list
    And searches for the term "headlease" using the glossary search
    Then the search icon should be changed to a "cross" icon
    And clicking on this "cross" icon should reset the page back to the default state
    And the search query is removed from the search input field

  Scenario: Verify the search results returned
    When the user enters a "head" into the search box
    Then the user should be able to see a list of resulting glossary terms containing this search term "head"
    And the first result item's definition should be displayed in the right hand pane
    And the user clicks on a glossary term in the glossary definition page "Headline rent"
    And the user should be able to view the definition of the term "Headline rent" on the page
    And no alphabets are selected while the search is active

  Scenario: Verify the search results are returned sorted alphabetically
    When the user enters a "sear" into the search box
    Then the user should be able to see a list of resulting glossary terms containing this search term "sear"
    And the result list displayed should be sorted alphabetically as below
      | Collaborative research agreement                  |
      | Keyword search                                    |
      | Pensions Investment Research Consultants (PIRC)   |
      | Reasonable search                                 |
      | Research Recommendations Electronic Voting (RREV) |
      | Search engine                                     |
      | Search order                                      |
      | Search warrant                                    |
      | Sears tooth agreement                             |

  Scenario: Verify number of search results
    When searches for the term "res" using the glossary search
    Then the total should be displayed as "174 matches"

  @manual
  Scenario: Verify exiting out of the search results
    When searches for the term "asha" using the glossary search
    And the user has selected the letter "R" from the tabbed alphabet list
    Then letter "R" should be selected on the alphabet tab
    Then the glossary terms list should roll such that first term in the alphabet R is displayed on the top
    And the corresponding definition of this first term is displayed on the right hand side

  Scenario: Verify zero search results
    When searches for the term "asha" using the glossary search
    Then the total should be displayed as "0 matches"
    And the user should be able to view the definition of the term "Cash alternative" on the page
