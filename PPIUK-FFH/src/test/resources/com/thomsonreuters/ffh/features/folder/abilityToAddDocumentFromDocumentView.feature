@e2e
Feature: [730616] FFH083 As a PPI User When I am in a document I want to have the option to add it directly to my folders so I can access it later.
  [729771] FFH052 As a PPI User I want to be able to delete a document from Folders so I can move it to Trash.
  [755256] FFH004 As a PPI User I want to see the content type  for every document in my Folders so I can identify and organize my documents.
  [755257] FFH005 As a PPI User I want to see a  Title, Resource Type and Date about the documents saved on Folders so I can identify the type of document.
  #Content type changed for Know-how = practical law, What's Market = What's Market,
  #Cases = cases, Legislation = statutes, Journals = secondary sources, Know-how = Legal Updates
  #Resource type was added for Know-how documents only

  Background:
    Given PL+ user is logged in

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


  @wip
  Scenario Outline:
  #This test starts by cleaning up - assuming the test could have failed on a previous run
    Given the user clicks on 'Folders' link on the header
    And the user deletes the document with the guid "<guid>" from the current folder if it exists
    When the user opens document with <guid> guid
    Then the user adds current document to the root folder
    And the user clicks on 'Folders' link on the header
    And the user adds the item to the folder
    And the user verifies that the case of Pipe  appears in the folder list as the first item
    And the user verifies that the Content type for the case is Primary Sources
    And the user verifies that the description of the document is “Pipe v Spicerhaart Estate Agents Ltd (t/a Haart) [2016] EWHC 61 (QB) (18 January 2016)”
    And the user verifies the date is “18-Jan-2016”
    And the user verifies the presence of the notation “Case Page”
    And the user selects the history documents link
    And the user verifies that the case of Pipe appears in the history list as the first item
    And the user verifies that the description of the document is “Pipe v Spicerhaart Estate Agents Ltd (t/a Haart) [2016] EWHC 61 (QB) (18 January 2016)”
    And the user verifies the date is “18-Jan-2016”
    And the user verifies the presence of the notation “Case Page”
    And the user selects the link to the homepage
    And the user views the recent history widget
    And the user verifies that the case of Pipe  appears in the recent history list as the first item
    And the user verifies that the description of the document is “Pipe v Spicerhaart Estate Agents Ltd (t/a Haart) [2016] EWHC 61 (QB) (18 January 2016)”
    And the user verifies the date is “18-Jan-2016”
    And the user verifies the presence of the notation “Case Page”
    And the user selects the link to folders
    And the user deletes the case of Pipe from folders
  Examples:
    | guid                              |
    | Ieda8cc31f27711e498db8b09b4f043e0 |

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
