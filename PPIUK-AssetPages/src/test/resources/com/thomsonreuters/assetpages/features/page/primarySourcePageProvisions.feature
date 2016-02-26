Feature: As a PL+ User I want to view list of provisions
  As a PL+ User I want to view specific provision coverage below other provisions
  The other provisions section does not has co_borderTop style

  Background:
    Given PL+ user is logged in

  Scenario Outline: The case documents contain list of provisions
    When the user opens document with <GUID> guid
    Then the user click on View Document button
    Then the document opens correctly
    Then the user sees "Specific provision coverage" Specific provision coverage
    Then the user sees the "<link>" link in Specific provision coverage section
    When the user clicks on this "<link>" link in Specific provision coverage section
    Then the user is taken to the primary source document
  Examples:
    | GUID                              | link                                                         |
    | I3890f315651511e598dc8b09b4f043e0 | Section 1, Freedom of Information Act 2000                   |
    | I614f4589640411e598dc8b09b4f043e0 | Regulation 2, The Environmental Information Regulations 2004 |
    | I15d141d86d6f11e498db8b09b4f043e0 | Section 1, Localism Act 2011                                 |

  Scenario Outline: The case documents contain specific provision coverage below other provisions
    When the user opens document with <GUID> guid
    Then the user click on View Document button
    Then the document opens correctly
    Then the user sees "To view the other provisions relating to this primary source, see:" section
    Then the user sees "<link1>" in "To view the other provisions relating to this primary source, see:" other provisions section
    Then the user sees "Specific provision coverage" Specific provision coverage
    Then the user sees the "<link2>" link in Specific provision coverage section
    And the "Specific provision coverage" section displayed below "To view the other provisions relating to this primary source, see:" section
  Examples:
    | GUID                              | link1                                                                                     | link2                                              |
    | I3890f544651511e598dc8b09b4f043e0 | The Company and Business Names (Miscellaneous Provisions) Regulations 2009 (SI 2009/1085) | Paragraph 3, Schedule 2, The Company and Business  |
    | I8bb87be4661f11e598dc8b09b4f043e0 | The Company and Business Names (Miscellaneous Provisions) Regulations 2009                | Paragraph 3, Schedule 3, The Company and Business  |
    | I6626807c63a911e598dc8b09b4f043e0 | The Companies Act 2006 (Commencement No. 8, Transitional Provisions and Savings)          | Paragraph 2, Schedule 2, The Companies Act 2006    |
    | I06f06160659411e598dc8b09b4f043e0 | The Charities Act 2006 (Commencement No.7, Transitional and Transitory Provisions         | Paragraph 1, Schedule 2, The Charities Act 2006    |
    | Id91ef79e659711e598dc8b09b4f043e0 | The Marriage (Same Sex Couples) Act 2013                                                  | Paragraph 1, Schedule, Marriage (Same Sex Couples) |

  Scenario Outline: The other provisions section does not has co_borderTop style
    When the user opens document with <GUID> guid
    Then the user click on View Document button
    Then the document opens correctly
    Then the user sees "To view the other provisions relating to this primary source, see:" section
    And the "To view the other provisions relating to this primary source, see:" section does not has "co_borderTop" style
  Examples:
    | GUID                              |
    | Ib29e0159660011e598dc8b09b4f043e0 |
    | I6626585163a911e598dc8b09b4f043e0 |
    | I6626587663a911e598dc8b09b4f043e0 |
    | I6626588263a911e598dc8b09b4f043e0 |
