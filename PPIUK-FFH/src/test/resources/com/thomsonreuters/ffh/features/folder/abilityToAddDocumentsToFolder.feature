Feature: As a PPI User I want to be able to add documents to a folder so I can access them easier in next sessions.

  Scenario:
    Given PL+ user is logged in
    When API cleans all folders and history and user relogs in

  Scenario Outline: From Home Page
    Given PL+ user is logged in
    And the user runs a free text search for the query "<query>"
    And the user waits search result to load
    And the user selects '2' documents, stores its titles and guids and saves to new "<folder>" folder with parent folder "<parentFolder>"
    When the user clicks on 'Folders' link on the header
    Then all documents present in the "<folder>" folder
    When the user deletes all documents from "<folder>" folder
    Then the folder "<folder>" is empty
  Examples:
    | query | folder | parentFolder |
    | Bill  | test1  | root         |

  Scenario Outline: From Resource page
    Given PL+ user is logged in
    And the user opens 'Resources' link
    And the user opens 'PLC Magazine' link
    And the user runs a free text search for the query "<query>"
    And the user waits search result to load
    And the user selects '2' documents, stores its titles and guids and saves to new "<folder>" folder with parent folder "<parentFolder>"
    When the user clicks on 'Folders' link on the header
    Then all documents present in the "<folder>" folder
    When the user deletes all documents from "<folder>" folder
    Then the folder "<folder>" is empty
  Examples:
    | query  | folder | parentFolder |
    | Client | test2  | root         |

  Scenario Outline: Know how
    Given PL+ user is logged in
    When the user opens 'Resources' link
    And the user opens 'Standard documents and drafting notes' link
    And the user runs a free text search for the query "<query>"
    And the user waits search result to load
    And the user selects '2' documents, stores its titles and guids and saves to new "<folder>" folder with parent folder "<parentFolder>"
    When the user clicks on 'Folders' link on the header
    Then all documents present in the "<folder>" folder
    When the user deletes all documents from "<folder>" folder
    Then the folder "<folder>" is empty
  Examples:
    | query | folder | parentFolder |
    | Tax   | test24 | root         |

  Scenario Outline: Whats Market
    Given PL+ user is logged in
    When the user opens 'Resources' link
    And the user opens 'What's Market' link
    And the user runs a free text search for the query "<query>"
    And the user waits search result to load
    And the user selects '2' documents, stores its titles and guids and saves to "<folder>" folder
    When the user clicks on 'Folders' link on the header
    Then all documents present in the "<folder>" folder
    When the user deletes all documents from "<folder>" folder
    Then the folder "<folder>" is empty
  Examples:
    | query | folder |
    | Tax   | root   |

  Scenario Outline: Legal Updates
    Given PL+ user is logged in
    When the user opens 'Resources' link
    When the user opens 'Legal updates' link
    And the user runs a free text search for the query "<query>"
    And the user waits search result to load
    And the user selects '2' documents, stores its titles and guids and saves to "<folder>" folder
    When the user clicks on 'Folders' link on the header
    Then all documents present in the "<folder>" folder
    When the user deletes all documents from "<folder>" folder
    Then the folder "<folder>" is empty
  Examples:
    | query    | folder |
    | Telecoms | root   |

  Scenario Outline: Topics page
    Given PL+ user is logged in
    When the user opens 'IP & IT' link
    And the user opens 'Media & Telecoms' link
    And the user opens 'Music' link
    And the user runs a free text search for the query "<query>"
    And the user waits search result to load
    And the user selects '2' documents, stores its titles and guids and saves to "<folder>" folder
    When the user clicks on 'Folders' link on the header
    Then all documents present in the "<folder>" folder
    When the user deletes all documents from "<folder>" folder
    Then the folder "<folder>" is empty
  Examples:
    | query | folder |
    | Music | root   |
