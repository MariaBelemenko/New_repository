Feature: [702195] Ability to use operators when searching on PL+ (know how)

  Background:
    Given PL+ user is logged in

  Scenario: verify that the number of results for an "and" search is lower than the number of  results for an "or" search
    When the user runs a free text search for the query "contract and acceptance"
    Then the user gets the know how search result count and stores it as count "1"
    When the user runs a free text search for the query "contract or acceptance"
    Then the user gets the know how search result count and stores it as count "2"
    And the user verifies that the know how search result count "1" is less than "2"

  Scenario Outline: verify that results for an "and" search comprise all search terms
    When the user runs a free text search for the query "<query>"
    And the user opens the result in position "<result>"
    Then the displayed document will have the terms "<terms>" marked up as hits
  Examples:
    | query                   | result | terms               |
    | contract and acceptance | 1      | contract acceptance |
#    | contract and acceptance | 2      | contract acceptance |

  Scenario Outline: verify that a user can submit a phrase search
    When the user runs a free text search for the query "income tax"
    And the user opens the result in position "<result>"
    And the user pauses for "5" seconds
    Then the user verifies the search result contains the search terms "<term1>" as a phrase within the full text
  Examples:
    | result | term1      |
    | 2      | income tax |
#    | 3      | income tax |

  Scenario Outline: Validate that use of & retrieves both search terms
    When the user runs a free text search for the query "contract and acceptance"
    And the user opens the result in position "<result>"
    And the user pauses for "5" seconds
    Then the displayed document will have any of the terms "<terms>" marked up as hits
  Examples:
    | result | terms               |
    | 2      | contract acceptance |
#    | 3      | contract acceptance |

  @bug
  Scenario Outline: Searching with a mix of and and or operators
    #850541
    When the user runs a free text search for the query "(school OR schol) & (holiday OR vacation)"
    And the user selects the know how "Resource Type" facet "Practice Notes"
    And the user selects the know how option to apply filters
    And the user opens the result in position "<result>"
    Then the displayed document will have the terms "school+schol holiday+vacation" marked up as hits
    #Then the result in position "<result>" contains either school & holiday or school & vacation or schol & holiday or schol & vacation
  Examples:
    | result |
    | 1      |
#    | 2      |
#    | 3      |

  Scenario Outline: Validate that use of the /s connector retrieves terms within the same sentence (not working)
    #there is an issue with sentence mark up - sometimes results not correct - business determined this is a won't fix so not an active bug
    #content is marked up within co_paragraphText so doesn't mark as detailed as sentence, so a paragraph check is done.
    When the user runs a free text search for the query "car /s defect"
    And the user opens the result in position "<result>"
    And the user pauses for "5" seconds
    Then the user verifies the search result contains the search terms "car" "defect" within a single paragraph in the full text
  Examples:
    | result |
    | 1      |
#    | 2      |
#    | 3      |

  Scenario Outline: Validate that use of the /p connectors retrieves terms within the same paragraph
    When the user runs a free text search for the query "house /p defect"
    And the user opens the result in position "<result>"
    Then the user verifies the search result contains the search terms "house" "defect" within a single paragraph in the full text
  Examples:
    | result |
    | 2      |
#    | 3      |

  Scenario Outline: Validate that use of the +s connector retrieves search terms where the first precedes the second in the same sentence
    #there is an issue with sentence mark up - sometimes results not correct - business determined this is a won't fix so not an active bug
    #content is marked up within co_paragraphText so doesn't mark as detailed as sentence, so a paragraph check is done.
    When the user runs a free text search for the query "hague +s convention"
    And the user opens the result in position "<result>"
    And the user pauses for "5" seconds
    Then the user verifies the search result contains the search terms "hague" "convention" in the full text where the first precedes the second in the same paragraph
  Examples:
    | result |
    | 1      |
#    | 2      |

  Scenario Outline: Validate that use of the +p connector retrieves search terms where the first precedes the second in the same paragraph
    When the user runs a free text search for the query "contractual +p break"
    And the user opens the result in position "<result>"
    And the user pauses for "5" seconds
    Then the user verifies the search result contains the search terms "contractual" "break+broke+broken" in the full text where the first precedes the second in the same paragraph
  Examples:
    | result |
    | 2      |
#    | 3      |

  Scenario Outline: Validate that use of the /n connector (where n is a number) retrieves terms within n terms of each other
    When the user runs a free text search for the query "building /6 inspection"
    And the user opens the result in position "<result>"
    And the user pauses for "5" seconds
    Then the user verifies the search result contains the both search terms "building" "inspection" within "6" terms of each other within the full text
  Examples:
    | result |
    | 2      |
#    | 3      |

  Scenario Outline: Validate that use of the /n connector (where n is a number) retrieves numerical terms within n terms of each other
    When the user runs a free text search for the query "building +6 inspection"
    And the user opens the result in position "<result>"
    And the user pauses for "5" seconds
    Then the user verifies the search result contains the both search terms "building" "inspection" "6" terms of each other in the full text with the first preceding the second
  Examples:
    | result |
    | 2      |
#    | 3      |

  Scenario Outline: Validate that use of the % connector prevents terms placed after it from being retrieved
    When the user runs a free text search for the query "house % defect"
    And the user opens the result in position "<result>"
    And the user pauses for "5" seconds
    #hous used to allow for "housing"
    Then the user verifies the search result contains the first search term "hous" in the full text for the first term and not the second "defect"
  Examples:
    | result |
    | 2      |
#    | 3      |

  Scenario Outline: Validate that use of the root expander ! retrieves terms with variant endings
    When the user runs a free text search for the query "obey!"
    And the user selects the know how "Resource Type" facet "Practice Notes"
    And the user selects the know how option to apply filters
    And the user opens the result in position "<result>"
    And the user pauses for "5" seconds
    Then the user verifies the search result contains the full text includes one or more of the variants
      | obey    |
      | obeys   |
      | obeyed  |
      | obeying |
  Examples:
    | result |
    | 2      |

  Scenario Outline: Validate that use of the universal character retrieves terms which are an appropriate match
    When the user runs a free text search for the query "g**se"
    And the user opens the result in position "<result>"
    And the displayed document will have the terms "g**se" marked up as hits
  Examples:
    | result |
    | 2      |
#    | 3      |

  Scenario Outline: Validate that use of the universal character * at the end of a term dictates the maximum length of that term
    When the user runs a free text search for the query "object***"
    And the user opens the result in position "<result>"
    And the displayed document will have the terms "object***" marked up as hits
  Examples:
    | result |
    | 2      |
#    | 3      |

  Scenario Outline: Validate turning off plurals and equivalents using #
    When the user runs a free text search for the query "#damage"
    And the user opens the result in position "<result>"
    And the user pauses for "5" seconds
    Then the user verifies the search result contains the full text will contain the term "damage" but not the term "damages"
  Examples:
    | result |
    | 2      |
#    | 3      |

  Scenario Outline: Validating compound terms
    When the user runs a free text search for the query "good-will"
    And the user opens the result in position "<result>"
    Then the user verifies the search result contains the full text will include the following variants terms
      | good-will |
      | goodwill  |
      | good will |
  Examples:
    | result |
    | 2      |
#    | 3      |

  Scenario Outline: Searching with brackets
    When the user runs a free text search for the query "(scotland)"
    And the user opens the result in position "<result>"
    And the user pauses for "5" seconds
    Then the displayed document will have the terms "scotland" marked up as hits
  Examples:
    | result |
    | 2      |
#    | 3      |

  Scenario: Searching with commas
    When the user runs a free text search for the query "contract, acceptance,"
    And the user opens the result in position "1"
    And the user pauses for "5" seconds
    Then the user verifies the search result contains the search terms "contract" and also "acceptance" within the full text

  Scenario: Advanced terms and connectors
    When the user runs a free text search for the query "((house % defect) & (local /p authority))"
    And the user opens the result in position "1"
    And the user pauses for "5" seconds
    #Then the user verifies the search result contains the search terms "local" "authority" within a single paragraph in the full text
    Then the selected full text contains the term "house" but not the term "defect" and the word "local" is accompanied by the word "authority" in the same paragraph

  Scenario: Validate that plurals are turned off when exact match qualifer is used along with wild cards
    When the user runs a free text search for the query "#tes*"
    And the user opens the result in position "2"
    And the user pauses for "5" seconds
    Then the user is able to verify that the full text will not contain the term "tests"

  @manual
  Scenario Outline: Advanced terms and connectors
    When the user runs a free text search for the query "<query>"
    And the user opens the result in position "1"
    And the user pauses for "5" seconds
    Then the user is able to verify that the full text contains either the phrase "earlier decision" or "local authority" or both and also contains the term "economic" in the same sentence as the term "loss"
  Examples:
    | query                                                            |
    | ("earlier decision" OR "local authority") AND (economic /s loss) |

  @manual
  Scenario Outline: Advanced terms and connectors
    When the user runs a free text search for the query "<query>"
    And the user opens the result in position "1"
    And the user pauses for "5" seconds
    Then the user is able to verify that the full text contains the terms "recoverable" and "loss" within the same sentence or the terms "Anns" and "case" within the same paragraph and the terms "economic" or "loss" somewhere within the document
  Examples:
    | query                                                            |
    | ((recoverable +s loss) OR (Anns +p case)) AND (economic OR loss) |

  @manual
  Scenario: Advanced terms and connectors
    When the user runs a free text search for the query "(recoverable /3 loss) OR (Anns +6 Lords)"
    And the user opens the result in position "1"
    And the user pauses for "5" seconds
    Then the user is able to verify that the full text contains the term "recoverable" within "3" terms of the term "loss" or the term "Anns" within "6" terms of the term "Lords"