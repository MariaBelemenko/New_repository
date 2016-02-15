@bug
Feature: [729635] FFH017 As a PPI User I want to have a faceted view column where I can see the folders, a search tool and filters so I can filter and find the document that I am looking for

  # Search checks are absent, because there are no Cases, Legislation, Journals and Current Awareness documents type on PL+ now.
  #	834341 [REGRESSION] Incorrect Faceted view on History
  # 834339 [REGRESSION] Incorrect Faceted view on Folders
  Scenario:
    Given PL+ user is logged in with following details
      | userName | FFHTestUser |
    When API cleans all folders and history and user relogs in
    #Know-how
    When the user opens 'Resources' link
    And the user opens 'Standard documents and drafting notes' link
    And the user runs a free text search for the query "Property"
    And the user waits search result to load
    And the user opens '2' link in the search result and store its details
    And the user adds current document to "root" folder
    #What's Market
    And the user come back on to Home page
    When the user opens 'Resources' link
    And the user opens 'What's Market' link
    And the user runs a free text search for the query "Credit"
    And the user waits search result to load
    And the user opens '1' link in the search result and store its details
    And the user adds current document to "root" folder
    #Know-how
    And the user come back on to Home page
    When the user opens 'Resources' link
    When the user opens 'Legal updates' link
    And the user runs a free text search for the query "Tax"
    And the user waits search result to load
    And the user opens '1' link in the search result and store its details
    And the user adds current document to "root" folder
    #Check on Folders page
    And the user clicks on 'Folders' link on the header
    And the user clicks Select Multiple Filters
    And the user selects 'Document' Type
    And the user selects 'Know-how' Content type
    And the user clicks Apply Filters
    Then the following documents content type present only
      | Know-how |
    When the user clicks Cancel Filters
    And the user selects 'What's Market' Content type
    Then the following documents content type present only
      | What's Market |
    #Check on History page
    When the user clicks on 'History' link on the header
    And the user clicks on 'Documents' tab on the History page
    And the user clicks Select Multiple Filters
    And the user selects 'PRACTICAL LAW UK' Client ID
    And the user selects 'Know-how' Content type
    And the user clicks Apply Filters
    Then the following documents content type present only
      | Know-how |
    When the user clicks Cancel Filters
    And the user selects 'What's Market' Content type
    Then the following documents content type present only
      | What's Market |
