Feature: [713467] The user should have the ability to select the number of Legal update documents are displayed on their results list.

  #do not remove this tag! this is to set 20 results per page after test
  @SetDefaultNumberOfResultsPerPage
  Scenario: Use the Select box on the Footer so that I can choose the number of results that I can see on my page
    Given PL+ user is logged in
    And a user is on a legal updates results page
    And the default number of results on that page is 20
    When the user selects another number from the select box
    Then the number of legal updates that are displayed should change to reflect the selection of the user

  #do not remove this tag! this is to set 20 results per page after test
  @SetDefaultNumberOfResultsPerPage
  Scenario: Use the Select box on the Footer so that I can choose the number of results that I can see on my page
    Given PL+ user is logged in
    Given a user navigate to a "Directors" Topic page from a "Corporate" Practice Area page
    When the user clicks on the 'View all' link of the "Legal Updates" widget
    And the default number of results on that page is 20
    When the user selects another number from the select box
    Then the number of legal updates that are displayed should change to reflect the selection of the user
