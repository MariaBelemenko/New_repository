@e2e
Feature: [730616] FFH083 As a PPI User When I am in a document I want to have the option to add it directly to my folders so I can access it later.
  [729771] FFH052 As a PPI User I want to be able to delete a document from Folders so I can move it to Trash.
  [755256] FFH004 As a PPI User I want to see the content type  for every document in my Folders so I can identify and organize my documents.
  [755257] FFH005 As a PPI User I want to see a  Title, Resource Type and Date about the documents saved on Folders so I can identify the type of document.

  #Content type changed for Know-how = practical law, What's Market = What's Market,
  #Cases = cases, Legislation = statutes, Journals = secondary sources, Know-how = Legal Updates
  #Resource type was added for Know-how documents only
  
  Background: 
    Given PL+ user is logged in with following details
      | userName | FFHTestUser |

  Scenario: 
    When API cleans all folders and history and user relogs in

  Scenario Outline: Know how
    When the user opens 'Resources' link
    And the user opens 'Standard documents and drafting notes' link
    And the user runs a free text search for the query "<query>"
    And the user waits search result to load
    And the user opens '1' link in the search result and store its title and guid
    And the user adds current document to new "<folder>" folder with parent folder "<parentFolder>"
    When the user clicks on 'Folders' link on the header
    Then document present in the "<folder>" folder
    And the document Content type is correct
    And the document Resource type is correct
    And the document date is correct
    When the user deletes the document from "<folder>" folder
    Then document does not present in the "<folder>" folder
    Then document present in the "Trash" folder
    And the document Content type in Trash is correct
    And the document date in Trash is correct
    When the user selects the document and moves back to original folder "<folder>"
    Then the document should be removed from Trash and be moved to folder "<folder>"

    Examples: 
      | query | folder | parentFolder |
      | Tax   | test22 | root         |

  Scenario Outline: Whats Market
    When the user opens 'Resources' link
    And the user opens 'What's Market' link
    And the user runs a free text search for the query "<query>"
    And the user waits search result to load
    And the user opens '1' link in the search result and store its title and guid
    And the user adds current document to "<folder>" folder
    When the user clicks on 'Folders' link on the header
    Then document present in the "<folder>" folder
    And the document Content type is correct
    And the document date is correct
    When the user deletes the document from "<folder>" folder
    Then document does not present in the "<folder>" folder
    Then document present in the "Trash" folder
    And the document Content type in Trash is correct
    And the document date in Trash is correct

    Examples: 
      | query | folder |
      | Media | root   |

  Scenario Outline: Legal Updates
    When the user opens 'Resources' link
    When the user opens 'Legal updates' link
    And the user runs a free text search for the query "<query>"
    And the user waits search result to load
    And the user opens '2' link in the search result and store its title and guid
    And the user adds current document to "<folder>" folder
    When the user clicks on 'Folders' link on the header
    Then document present in the "<folder>" folder
    And the document Content type is correct
    And the document Resource type is correct
    And the document date is correct
    When the user deletes the document from "<folder>" folder
    Then document does not present in the "<folder>" folder
    Then document present in the "Trash" folder
    And the document Content type in Trash is correct
    And the document date in Trash is correct

    Examples: 
      | query  | folder |
      | Credit | root   |

  Scenario Outline: Topics page
    When the user opens 'IP & IT' link
    And the user opens 'Media & Telecoms' link
    And the user opens 'Film' link
    And the user opens '2' link in the search result and store its title and guid
    And the user adds current document to "<folder>" folder
    When the user clicks on 'Folders' link on the header
    Then document present in the "<folder>" folder
    And the document Content type is correct
    And the document Resource type is correct
    And the document date is correct
    When the user deletes the document from "<folder>" folder
    Then document does not present in the "<folder>" folder
    Then document present in the "Trash" folder
    And the document Content type in Trash is correct
    And the document date in Trash is correct

    Examples: 
      | folder |
      | root   |

  # 854196 [REGRESSION] Ask documents inaccessible
  @bug
  Scenario Outline: Ask
    When the user opens 'Resources' link
    And the user opens 'Ask' link
    And the user runs a free text search for the query "<query>"
    And the user waits search result to load
    And the user opens '1' link in the search result and store its title and guid
    And the user adds current document to "<folder>" folder
    When the user clicks on 'Folders' link on the header
    Then document present in the "<folder>" folder
    And the document Content type is correct
    And the document Resource type is correct
    And the document date is correct
    When the user deletes the document from "<folder>" folder
    Then document does not present in the "<folder>" folder
    Then document present in the "Trash" folder
    And the document Content type in Trash is correct
    And the document date in Trash is correct

    Examples: 
      | query       | folder |
      | JCT DB 2011 | root   |

  # 835031 History, Recent history and Folders: Asset pages info display needs amending
  @bug
  Scenario Outline: [799682] As a PL+ User I want to see that the primary source documents saves in the history
    Given PL+ user is logged in with following details
      | userName | Asset_page_one |
    And API cleans all folders and history and user relogs in
    When the user opens document with <GUID> guid
    Then the user click on View Document button
    Then the document opens correctly
    Then the user store title and guid of primary source document
    And the user adds current document to "<folder>" folder
    When the user clicks on 'Folders' link on the header
    Then document present in the "<folder>" folder
    And the document Content type is correct
    And the document Resource type is correct
    And the document date is correct
    When the user deletes the document from "<folder>" folder
    Then document does not present in the "<folder>" folder
    Then document present in the "Trash" folder
    And the document Content type in Trash is correct
    And the document date in Trash is correct

    Examples: 
      | GUID                              | link                 | folder |
      | I984ef7626cf011e498db8b09b4f043e0 | Duty to give reasons | root   |

  Scenario Outline: [785298] add glossary document to folder
    When the user is on the glossary tool page
    And the user opens the link to the glossary term "<glossaryDocPosition>" and store its title and guid
    And the user adds current document to "<folder>" folder
    When the user clicks on 'Folders' link on the header
    Then document present in the "<folder>" folder
    And the document Content type is correct
    And the document Resource type is correct
    And the document date is correct
    When the user deletes the document from "<folder>" folder
    Then document does not present in the "<folder>" folder
    Then document present in the "Trash" folder
    And the document Content type in Trash is correct
    And the document date in Trash is correct

    Examples: 
      | folder | glossaryDocPosition |
      | root   | 2                   |
