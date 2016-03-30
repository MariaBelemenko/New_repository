@wip
Feature: Cases Judgement Document (Official Transcript)

  Scenario Outline: Cases Judgment Left Hand Navigation doesn't have jump links.
    Given PL+ user is logged in
    When User navigates to the "CaseJudgment" "<document>"
    Then User is able to see all primary menu links on Cases judgmentDocument
    When User selects "Judgment" as primary menu
    Then Verify the "Judgment" child menus are not present
  Examples:
    | document                                                                                          |
    | R. (on the application of Rotherham MBC) v Secretary of State for Business, Innovation and Skills |
    | Mainstream Properties Ltd v Young                                                                 |
    | Banerjee v Revenue and Customs Commissioners                                                      |

  Scenario Outline: User selects the Judgment link and verify the other primary sections are collapsed
    Given PL+ user is logged in
    When User navigates to the "Case" "<document>"
    Then The Primary and Secondary menus should appear on the left hand side of the screen
    When User selects "<other menu>" as primary menu
    And Other primary menus will be collapsed except the selected "<other menu>" menu
    When User selects "Judgment" as primary menu
    Then Other primary menus will be collapsed except the selected "Judgment" menu
  Examples:
    | document                                                                                          | other menu         |
    | R. (on the application of Rotherham MBC) v Secretary of State for Business, Innovation and Skills | Case Analysis      |
    | Mainstream Properties Ltd v Young                                                                 | Law Reports        |
    | Mainstream Properties Ltd v Young                                                                 | Primary References |
    | Mainstream Properties Ltd v Young                                                                 | Commentary         |

  Scenario Outline: Cases Document doesn't have Judgment link and document.
    Given PL+ user is logged in
    When User navigates to the "Case" "<document>"
    Then User is not able to see Cases "Judgment" left hand navigation link
  Examples:
    | document                                                                     |
    | R. (on the application of Chancery uk LLP) v Financial Ombudsman Service Ltd |

  Scenario Outline: View or download the case judgment pdf document
    Given PL+ user is logged in
    When User navigates to the "CaseJudgment" "<document>"
    Then User able to see the case judgment pdf download link
    When User select pdf download link
    Then User able to see Case judgment pdf downloaded document in local folder
  Examples:
    | document                          |
    | Mainstream Properties Ltd v Young |

  Scenario Outline: Citation Ref, Hearing dates, Respondents in Case Judgment Document
    Given PL+ user is logged in
    When User navigates to the "CaseJudgment" "<document>"
    Then User is able to see the 1 or more CaseJudgmentDeails
      | Citation Ref  |
      | Hearing dates |
      | Respondents   |
  Examples:
    | document        |
    | OBG Ltd v Allan |

  Scenario Outline: Appellate History, Counsel Appellants  in Case Judgment Document
    Given PL+ user is logged in
    When User navigates to the "CaseJudgment" "<document>"
    Then User is able to see the none or more CaseJudgmentDeails
      | Appellate History  |
      | Counsel Appellants |
  Examples:
    | document        |
    | OBG Ltd v Allan |

  Scenario Outline: Star paging in Case Judgment Document
    Given PL+ user is logged in
    When User navigates to the "CaseJudgment" "<document>"
    Then User is able to see StarPagings
      | *553 |
      | *554 |
      | *555 |
  Examples:
    | document                                          |
    | Plevin v Paragon Personal Finance Ltd and another |

  Scenario Outline: Display party names on the left hand side
    Given PL+ user is logged in
    When User navigates to the "CaseJudgment" "<document>"
    Then User able to see the "<Party Names>" including the alias names on left hand side
  Examples:
    | document                                          | Party Names |
    | Plevin v Paragon Personal Finance Ltd and another |             |

  Scenario Outline: Display judgment date in the correct format
    Given PL+ user is logged in
    When User navigates to the "CaseJudgment" "<document>"
    Then User able to see the Judgment date under the Party names section
    And User verifies the dateformat as DDMMMYYYY
  Examples:
    | document                                          |
    | Plevin v Paragon Personal Finance Ltd and another |

  Scenario Outline: Display status icon
    Given PL+ user is logged in
    When User navigates to the "CaseJudgment" "<document>"
    Then User able to see the 0 or 1 Status and Status Icon on left hand side of the document
  Examples:
    | document                                          |
    | Plevin v Paragon Personal Finance Ltd and another |

  Scenario Outline: Display Internal links in Case Judgment Document
    Given PL+ user is logged in
    When User navigates to the "CaseJudgment" "<document>"
    And Select the internal link "<linkname>"
    Then Current "<document>" will be closed
    And Appropriate section link "<linkTitle>" will be displayed in the same cases window
  Examples:
    | document                                                        | linkname      | linkTitle                                  |
    | s. 1 OFCOM reports on infrastructure, internet domain names etc | section 134A  | s. 134 Restrictions in leases and licences |
    | s. 3 Functions of Revenue Scotland                              | section 51(3) | s. 51 Interpretation                       |
