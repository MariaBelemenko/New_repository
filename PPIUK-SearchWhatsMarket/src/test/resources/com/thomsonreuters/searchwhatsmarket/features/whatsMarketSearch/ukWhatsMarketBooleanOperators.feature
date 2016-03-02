Feature: [711536] ukWhatsMarketBooleanOperatorsS2-79.feature
Ability to use operators when searching on PL+ for what's market

  Background: Log on to test site
    Given PL+ user is logged in with following details
      | newSession | TRUE |
    And has selected the link to the What's Market homepage

  Scenario: [711536] verify that the number of results for an "and" search is lower than the number of  results for an "or" search, [711536] Searching with commas
    When the user runs a free text search for the query "contract & acceptance"
    And the user gets the know how search result count and stores it as count "1"
    And the user runs a free text search for the query "contract or acceptance"
    And the user gets the know how search result count and stores it as count "2"
    And the user verifies that the know how search result count "1" is less than "2"
    When the user runs a free text search for the query "company, administration,"
    And the user opens the whats market result in position "1"
    Then the user verifies the search result contains the search terms "company" and also "administration" within the full text

  Scenario Outline: [711536] verify that results for an "and" search against know how comprise all search terms
    When the user runs a free text search for the query "<query>"
    And the user opens the whats market result in position "<result>"
    Then the user verifies the search result contains the search terms "<term1>" and also "<term2>" within the full text
  Examples:
    | query                   | result | term1    | term2      |
    | contract and acceptance | 1      | contract | acceptance |
    | contract and acceptance | 2      | contract | acceptance |

  @bug
  Scenario Outline: [711536] Searching with a mix of and and or operators
    # http://tfsnpt.int.thomson.com:8080/tfs/Cobalt_Collection/Cobalt%20Product%20Backlog/_workItems/index#_a=editANDid=815995
    #815995
    When the user runs a free text search for the query "(company or merger) AND (insolvency or administration)"
    And the user opens the whats market result in position "<result>"
    Then the result contains either of the results
      | company AND insolvency     |
      | company AND administration |
      | merger AND administration  |
      | merger AND insolvency      |
  Examples:
    | result |
    | 1      |
    | 2      |

  Scenario Outline: [711536] verify that a user can submit a phrase search
    When the user runs a free text search for the query "<query>"
    And the user opens the whats market result in position "<result>"
    Then the user verifies the search result contains the search terms "income tax" as a phrase within the full text
  Examples:
    | query        | result |
    | "income tax" | 1      |
    | "income tax" | 3      |

  @bug
  Scenario Outline: [711536] Validate that use of AND retrieves both search terms, [711536] Validate that use of the /p connectors retrieves terms within the same sentence
    #815995
    When the user runs a free text search for the query "contract AND acceptance"
    And the user opens the whats market result in position "<result>"
    Then the user verifies the search result contains the search terms "contract" and also "acceptance" within the full text
    And returns to the WM search results by Return to list
    When the user runs a free text search for the query "company /p administration"
    And the user opens the whats market result in position "<result>"
    Then the user verifies the search result contains the search terms "company" "administration" within a single paragraph in the full text
  Examples:
    | result |
    | 2      |
    | 3      |

  Scenario Outline: [711536] Validate that use of the /s connector retrieves terms within the same sentence, [711536] Validate that use of the +s connector retrieves search terms where the first precedes the second in the same sentence
    When the user runs a free text search for the query "law /s order"
    And the user opens the whats market result in position "<result>"
    # There is a content issue where many sentences are in fact marked up as paragraphs so the functionality doesn't work as expected.
    # For this reason we are using a paragraph check
    Then the user verifies the search result contains the search terms "law" "order" within a single paragraph in the full text
    And returns to the WM search results by Return to list
    When the user runs a free text search for the query "law +s order"
    And the user opens the whats market result in position "<result>"
    # There is a content issue where many sentences are in fact marked up as paragraphs so the functionality doesn't work as expected.
    # For this reason we are using a paragraph check
    Then the user verifies the search result contains the search terms "law" "order" in the full text where the first precedes the second in the same paragraph
  Examples:
    | result |
    | 1      |
    | 2      |
    | 3      |

  Scenario Outline: [711536] Validate that use of the +p connector retrieves search terms where the first precedes the second in the same paragraph, [711536] Validate that use of the /n connector (where n is a number) retrieves terms within n terms of each other
    When the user runs a free text search for the query "administration +p company"
    And the user opens the whats market result in position "<result>"
    Then the user verifies the search result contains the search terms "administration" "company" in the full text where the first precedes the second in the same paragraph
    And returns to the WM search results by Return to list
    When the user runs a free text search for the query "guarantee /6 company"
    And the user opens the whats market result in position "<result>"
    Then the user verifies the search result contains the both search terms "guarantee" "company" within "6" terms of each other within the full text
  Examples:
    | result |
    | 2      |
    | 3      |

  Scenario Outline: [711536] Validate that use of the +n connector (where n is a number) retrieves numerical terms within n terms of each other
    When the user runs a free text search for the query "pension +6 guarantee"
    And the user opens the whats market result in position "<result>"
    Then the user verifies the search result contains the both search terms "pension" "guarantee" "6" terms of each other in the full text with the first preceding the second
  Examples:
    | result |
    | 2      |

  Scenario Outline: [711536] Validate that use of the % connector prevents terms placed after it from being retrieved,  [711536] Validate turning off plurals and equivalents using #
    When the user runs a free text search for the query "house % defect"
    And the user opens the whats market result in position "<result>"
    Then the user verifies the search result contains the first search term "house" in the full text for the first term and not the second "defect"
    And returns to the WM search results by Return to list
    When the user runs a free text search for the query "#damage"
    And the user opens the whats market result in position "<result>"
    Then the user verifies the search result contains the full text will contain the term "damage" but not the term "damages"
  Examples:
    | result |
    | 2      |
    | 3      |

  Scenario: [711536] Validate that use of the root expander ! retrieves terms with variant endings
    When the user runs a free text search for the query "obey!"
    And the user opens the whats market result in position "1"
    Then the user verifies the search result contains the full text includes one or more of the variants
      | obey    |
      | obeys   |
      | obeyed  |
      | obeying |

  Scenario Outline: [711536] Validate that use of the universal character * at the end of a term dictates the maximum length of that term
    When the user runs a free text search for the query "object***"
    And the user opens the whats market result in position "<result>"
    Then the user verifies the search result contains the full text may include the following terms
      | object    |
      | objects   |
      | objected  |
      | objective |
      | objection |
      | objecting |
  Examples:
    | result |
    | 2      |
    | 3      |

  Scenario Outline: [711536] Validating compound terms
    When the user runs a free text search for the query "good-will"
    And the user opens the whats market result in position "<result>"
    Then the user verifies the search result contains the full text will include the following variants terms
      | good-will |
      | goodwill  |
      | good will |
  Examples:
    | result |
    | 2      |
    | 3      |

  Scenario Outline: [711536] Searching with brackets
    When the user runs a free text search for the query "(<term>)"
    And the user opens the whats market result in position "<result>"
    Then the user verifies the search result contains the full text will contains the term "<term>"
  Examples:
    | result | term     |
    | 1      | scotland |
