Feature: As a PL+ user, I should be able to see metadata details for each Know How Result returned on the Search Result page as shown in attached wireframes

  Scenario: Verify search result structure according to the design
    Given PL+ user is logged in
    When the user runs a free text search for the query "tax"
    Then the user is able to see the search results with following features according to the design document
      | Document Type |
      | Jurisdiction  |
      | Status        |
      | summary       |

  Scenario: User checks the "Pagination" appearance for KH search results.
    Given PL+ user is logged in
    When the user runs a free text search for the query "tax"
    And the user can select the option to show less detail
    And the user selects the "20" from per page dropdown
    Then user verifies the navigation to "First Page" not present
    And user verifies the "Last Page" present
    And clicks on the "Last Page" pagination link
    Then user verifies the navigation to "Last Page" not present
    And user verifies the "First Page" present

  Scenario: User verifies the "All Content" label for the search results appears while searching from home page
    Given PL+ user is logged in
    When the user runs a free text search for the query "tax"
    Then user should see the label "All Content" in the search result heading

  Scenario: Front End: Option to select number of results per Page Control option
    Given PL+ user is logged in
    When the user runs a free text search for the query "tax"
    When the user selects the "20" from per page dropdown
    Then the user should be seeing "20" per page
    And the user selects the "50" from per page dropdown
    Then the user should be seeing "50" per page
    And the user selects the "100" from per page dropdown
    Then the user should be seeing "100" per page

  Scenario: User checks the suggestions for the typo term
    Given PL+ user is logged in
    When the user runs a free text search for the query "taxx"
    Then user should see the label "0 Results for "taxx"" in the search result heading
    Then user should have suggestion i.e. "Did you mean: tax"
    And user should not see any filters on the left hand side

  @manual
  Scenario: User checks the zero results after selecting mismatched filters options
    Given a user on the homepage
    When user types in a search term "Tax"
    And user will see the search page results
    When user apply couple of mismatched filters (Toolkit and Arbitration)
    Then user should see the zero result message
    And user should still see the filters on the L.H.S

  @manual
  Scenario: User verifies that the individual delivery dropdown options are hidden
    Given a user is logged in
    When user searches for any term like "Tax"
    Then the user should not see any individual delivery dropdown options with each search result on Search Result page.

  @manual
  Scenario: User verifies that the individual delivery dropdown options are hidden
    Given a user is logged in
    When user searches for any term like "Tax"
    Then the user should not see any individual delivery dropdown options with each search result on Search Result page.

  @manual
  Scenario: User verifies the less/more/most for Search Result Page.
    Given a user is logged in
    And user is on the home page
    And user searches for term "Tax" to have some results
    When user selects less from less/more/most drop-down
    Then search result should display the least amount of data in the search results
    And user selects more from less/more/most drop-down
    And search result should display the more amount of data in the search results
    And user selects more from less/more/most drop-down
    And search result should display the more amount of data in the search results

  @manual
  Scenario: User verifies the delivery options on search result page
    Given a user using the delivery options from search results page
    When I select Print, email of download from the delivery toolbar
    Then I will see the delivery modal box
    And I will be able to select the Basic and Advanced tabs to see the options on each tab.

  @manual
  Scenario: User checks the search result structure
    Given a user on the homepage
    When user types in a search term "Taxx"
    Then user should see the result page with "Back to home page", "Relevancy" and "More details" in the first row
    And user should see the result page with "Title(xx)", "Select all" and "1-20" in the second row

  @manual
  Scenario: User checks the "Right hand side tool bar" appearance
    Given cobalt user has logged into PLCUK site as "UKPPITester1"
    When user navigates to the home page with clientID "SYED"
    And user navigates to the KH resource page (link : http://plcuk.next.demo.westlaw.com/Document/I3351a831e8da11e398db8b09b4f043e0/View/FullText.html)
    Then the user should see the sticky header icons according to wireframe

  @manual
  Scenario: User checks the "Right hand side tool bar" appearance
    Given cobalt user has logged into PLCUK site as "UKPPITester1"
    When user navigates to the home page with clientID "SYED"
    And user navigates to the KH resource page
    Then the user should see the right hand side tool bar icons according to wireframe

  @manual
  Scenario: User verifies the "back to search" button  according to design document
    Given user is logged in
    And searches for the term like "Tax"
    When user clicks on the first link
    Then user should see document with the "back to search" button according to design
    And user clicks on the "back to search" button
    And user should be taken back to search result.

  @manual
  Scenario: User verifies the "search term toggle" button  according to design document
    Given user is logged in
    And searches for the term like "Tax"
    When user clicks on the first link
    Then user should see document with the "search term toggle" button according to design
