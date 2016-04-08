@e2e
Feature: [735042] FFH029 As a PPI User I want to see a  Title, Content, Date/Time that I visited it and Client ID for every document in the Document view in the History page so I can go back to a document visited before.
  [752039] FFH092 As a PPI User I want to see the content type  for every document in History so I can identify and organize my documents.
  [735044] FFH031 As a PPI User I want to see Event, Description, Date/Time that I visit it and Client ID for every event in the All History view in the History page so I can go back to a event done/visited before.

  #Content type changed for Know-how = practical law, What's Market = What's Market,
  #Cases = cases, Legislation = statutes, Journals = secondary sources, Know-how = Legal Updates
  #Resource type was added for Know-how documents only

  Scenario:
    Given PL+ user is logged in
    When API cleans all folders and history and user relogs in

  Scenario Outline: Know how and All History view
    Given PL+ user is logged in
    When the user opens 'Resources' link
    And the user opens 'Standard documents and drafting notes' link
    And the user runs a free text search for the query "<query>"
    And the user waits search result to load
    And the user opens '3' link in the search result and store its title and guid
    When the user clicks on 'History' link on the header
    When the user clicks on 'Documents' tab on the History page
    Then the '1' link contains the document title and guid
    Then the '1' link contains the document Content Type
    Then the '1' link contains the document Resource Type
    Then the '1' link contains ClientId and date
    When the user clicks on 'All_History' tab on the History page
    Then the '1' link contains the document title and guid
    Then the '1' link contains event type 'Document View'
    Then the '1' link contains ClientId and date
    Then the '1' link contains the document Resource Type
    Then the '2' link contains text "<query>" and url '/Search/Results.html?query=School'
    Then the '2' link contains event type 'Search'
    Then the '2' link contains ClientId and date
  Examples:
    | query  |
    | School |

  Scenario Outline: Legal Updates and All History view
    Given PL+ user is logged in
    When the user opens 'Resources' link
    When the user opens 'Legal updates' link
    And the user runs a free text search for the query "<query>"
    And the user waits search result to load
    And the user opens '1' link in the search result and store its title and guid
    When the user clicks on 'History' link on the header
    When the user clicks on 'Documents' tab on the History page
    Then the '1' link contains the document title and guid
    Then the '1' link contains the document Content Type
    Then the '1' link contains the document Resource Type
    Then the '1' link contains ClientId and date
    When the user clicks on 'All_History' tab on the History page
    Then the '1' link contains the document title and guid
    Then the '1' link contains event type 'Document View'
    Then the '1' link contains ClientId and date
    Then the '1' link contains the document Resource Type
    Then the '2' link contains text "<query>" and url '/Search/Results.html?query=School'
    Then the '2' link contains event type 'Search'
    Then the '2' link contains ClientId and date
  Examples:
    | query  |
    | School |

  Scenario Outline: Topics page
    Given PL+ user is logged in
    When the user opens 'IP & IT' link
    And the user opens 'General IP' link
    And the user runs a free text search for the query "<query>"
    And the user waits search result to load
    And the user opens '1' link in the search result and store its title and guid
    When the user clicks on 'History' link on the header
    When the user clicks on 'Documents' tab on the History page
    Then the '1' link contains the document title and guid
    Then the '1' link contains the document Content Type
    Then the '1' link contains the document Resource Type
    Then the '1' link contains ClientId and date
    When the user clicks on 'All_History' tab on the History page
    Then the '1' link contains the document title and guid
    Then the '1' link contains event type 'Document View'
    Then the '1' link contains ClientId and date
    Then the '1' link contains the document Resource Type
    Then the '2' link contains text "<query>" and url '/Search/Results.html?query=Data'
    Then the '2' link contains event type 'Search'
    Then the '2' link contains ClientId and date
  Examples:
    | query |
    | Data  |

  Scenario Outline: Whats Market
    Given PL+ user is logged in
    When the user opens 'Resources' link
    And the user opens 'What's Market' link
    And the user runs a free text search for the query "<query>"
    And the user waits search result to load
    And the user opens '1' link in the search result and store its title and guid
    When the user clicks on 'History' link on the header
    When the user clicks on 'Documents' tab on the History page
    Then the '1' link contains the document title and guid
    Then the '1' link contains the document Content Type
    Then the '1' link contains ClientId and date
  Examples:
    | query  |
    | School |

  # 854196 [REGRESSION] Ask documents inaccessible
  @bug
  Scenario Outline: Ask
    Given PL+ user is logged in
    When the user opens 'Resources' link
    And the user opens 'Ask' link
    And the user runs a free text search for the query "<query>"
    And the user waits search result to load
    And the user opens '4' link in the search result and store its title and guid
    When the user clicks on 'History' link on the header
    When the user clicks on 'Documents' tab on the History page
    Then the '1' link contains the document title and guid
    Then the '1' link contains the document Content Type
    Then the '1' link contains ClientId and date
  Examples:
    | query |
    | Ask   |

  Scenario Outline: [799682] As a PL+ User I want to see that the primary source documents saves in the history
    Given PL+ user is logged in
    When the user opens document with <GUID> guid
    Then the user click on View Document button
    Then the document opens correctly
    Then the user store title and guid of primary source document
    When the user clicks on 'History' link on the header
    When the user clicks on 'Documents' tab on the History page
    Then the '1' link contains the document title and guid
    Then the '1' link contains the document Content Type
    Then the '1' link contains the document Resource Type
    Then the '1' link contains ClientId and date
  Examples:
    | GUID                              | link                 |
    | I984ef7626cf011e498db8b09b4f043e0 | Duty to give reasons |
