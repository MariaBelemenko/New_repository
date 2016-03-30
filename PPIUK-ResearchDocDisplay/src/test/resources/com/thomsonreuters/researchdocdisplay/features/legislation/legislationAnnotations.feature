@wip
Feature: Legislation Annotations

  Scenario Outline: User Scrolls the document to the Annotations section and verify the annotation section is present.
    Given PL+ user is logged in
    When User navigates to the "Legislation" "<document>"
    Then "Annotations" section is present on document
    And "Annotations" Header will be displayed
  Examples:
    | document                                                                                           |
    | s. 1 OFCOM reports on infrastructure, internet domain names etc                                    |
    | s. 3 Functions of Revenue Scotland                                                                 |
    | s. 122 The Health and Social Care Information Centre: restrictions on dissemination of information |
    | s. 3 Interpretation of legislation                                                                 |
    | s. 14 Rectification of registers                                                                   |
    | s. 21 Interpretation, etc.                                                                         |
    | s. 1 Definition of partnership                                                                     |

  Scenario Outline: User Scrolls the document to the Annotations section if it is available, and verify the section internal links
    Given PL+ user is logged in
    When User navigates to the "Legislation" "<document>"
    Then "Annotations" section is present on document
    And Verify Annotations section has internal link "<linkname>"
    When Select the internal link "<linkname>" in Annotations
    Then the legislation "<document>" will be closed
    And Appropriate section link "<linkTitle>" will be opened in the same window
    And Verify that document is the type of "<doctype>"
  Examples:
    | document                                                                                           | linkname                                                        | doctype     | linkTitle                                                                 |
    | s. 1 OFCOM reports on infrastructure, internet domain names etc                                    | section 134A                                                    | Legislation | s. 134 Restrictions in leases and licences                                |
    | s. 3 Functions of Revenue Scotland                                                                 | section 51(3)                                                   | Legislation | s. 51 Interpretation                                                      |
    | s. 122 The Health and Social Care Information Centre: restrictions on dissemination of information | preamble                                                        | Legislation | preamble                                                                  |
    | s. 3 Interpretation of legislation                                                                 | DM, R. v [2011] EWCA Crim 2752                                  | Case        | R. v M                                                                    |
    | s. 14 Rectification of registers                                                                   | Paddico (267) Ltd v Kirklees Metropolitan Council [2014] UKSC 7 | Case        | Betterment Properties (Weymouth) Ltd v Dorset CC                          |
    | s. 21 Interpretation, etc.                                                                         | Section 8 of the Ministers of the Crown Act 1975                | Legislation | s. 8 Interpretation, consequential amendment and repeals.                 |
    | s. 1 Definition of partnership                                                                     | I.C.C.L.R. 1996, 7(8), 297â€“299                                | Journal     | The interpretation of section 1(1) of the Partnership Act 1890 in Ireland |

  Scenario Outline: User Scrolls the document to the Annotations section if it is available, and verify the section external links
    Given PL+ user is logged in
    When User navigates to the "Legislation" "<document>"
    Then "Annotations" section is present on document
    And Verify Annotations section has link to external website link "<linkname>"
    When Select the external link "<linkname>" in Annotations
    Then New browser will be displayed with appropriate link "<linkname>"
    And The internal "<document>" and browser window that the user has focus on will remain open
  Examples:
    | document                           | linkname                          |
    | s. 14 Enforcement of obligations   | OFCOM                             |
    | s. 3 Functions of Revenue Scotland | SP Official Report, June 11, 2014 |

  Scenario Outline: As a PL+ User Scrolls the document to the Annotations section and I want to click on link to notes and come back to Document Annotations
    Given PL+ user is logged in
    When User navigates to the "Legislation" "<document>"
    Then "Annotations" section is present on document
    And Verify Annotations section has "<linkname>" to general notes on common legal terms
    When the user selects the "<linkname>" of the note
    Then the legislation "<document>" will be closed
    And the general note "<linkname>" will be retrieved in the same browser
    When User able to see back to document link
    And User selects back to document link
    Then the legislation "<document>" will be displayed
  Examples:
    | document                                                     | linkname          |
    | s. 1 Overview of Act                                         | Explanatory Notes |
    | s. 1 Sheriffdoms, sheriff court districts and sheriff courts | Explanatory Notes |

  Scenario Outline: As a PL+ User I want to see the expanded annotations section by default
    Given PL+ user is logged in
    When User navigates to the "Legislation" "<document>"
    Then "Annotations" section is present on document
    And Verify "Annotations" section has expanded by default
  Examples:
    | document                                                           |
    | s.19  Discrimination in relation to goods, facilities and services |
    | Schedule 3 ENFORCEMENT AND PROCEDURE para. 17                      |
    | Antarctic Act 2013 c. 15 - Preamble                                |
    | art. 1 Citation, commencement and effect                           |
    | rule 6.20 Methods of service -Civil Procedure Rules 1998/3132      |
    | reg. 5 Local development documents                                 |

  Scenario Outline: As a PL+ User I want to hide/show the expanded annotations section when click on show/hide annotations button
    Given PL+ user is logged in
    When User navigates to the "Legislation" "<document>"
    Then "Annotations" section is present on document
    And Verify "Annotations" section has expanded by default
    And Verify "Annotations" show/hide button is present on Annotations header
    When Click on show/hide button is present on "Annotations" header
    Then Verify "Annotations" section has hidden
    And Verify "Annotations" show/hide button is present on Annotations header
    When Click on show/hide button is present on "Annotations" header
    Then Verify "Annotations" section has expanded
    And Verify "Annotations" show/hide button is present on Annotations header
  Examples:
    | document                                                           |
    | s.19  Discrimination in relation to goods, facilities and services |
    | Schedule 3 ENFORCEMENT AND PROCEDURE para. 17                      |
    | Antarctic Act 2013 c. 15 - Preamble                                |
    | art. 1 Citation, commencement and effect                           |
    | rule 6.20 Methods of service -Civil Procedure Rules 1998/3132      |
    | reg. 5 Local development documents                                 |

  Scenario Outline: User selects the Provision document which does not have Annotations
    Given PL+ user is logged in
    When User navigates to the "Legislation" "<document>"
    Then "Annotations" header will not be displayed
    And "Annotations" section will not be displayed
  Examples:
    | document                                                             |
    | Rent Officers (Housing Benefit Functions) (Amendment) Order 2012/646 |

  Scenario Outline: User is able to select the Annotations as child menu link and able to see the Annotations in Provision section of Provision Document
    Given PL+ user is logged in
    When User navigates to the "Legislation" "<document>"
    Then Verify the Title of the act
    And and year of the act
    And the part of the act
    And the individual section of the document
    And the status of the Law
    And the Version number
    And the Provision effective date
    And User is able to see all primary menu links
    When User selects "Provision" as primary menu
    Then "Provision" secondary menu links will be displayed
    And Verify the "Annotations" child menu is present under "Provision" menu
    And User selects "Annotations" as child menu
    Then "Annotations" section will be displayed
    And "Annotations" Header will be displayed
  Examples:
    | document                                                                                             |
    | s.19  Discrimination in relation to goods, facilities and services                                   |
    | Schedule 3 ENFORCEMENT AND PROCEDURE Part V Discrimination in General Qualifications Bodies_para. 17 |
    | Antarctic Act 2013 c. 15 - Preamble                                                                  |
    | art. 1 Citation, commencement and effect                                                             |
    | rule 6.20 Methods of service -Civil Procedure Rules 1998/3132                                        |
    | reg. 5 Local development documents                                                                   |

  Scenario Outline: User selects the Provision document which does not have Annotations
    Given PL+ user is logged in
    When User navigates to the "Legislation" "<document>"
    Then User is able to see all primary menu links
    When User selects "Provision" as primary menu
    Then "Provision" secondary menu links will be displayed
    And Verify the "Annotations" child menu is not present under "Provision" menu
    And "Annotations" header will not be displayed
    And "Annotations" section will not be displayed
  Examples:
    | document                                                             |
    | Rent Officers (Housing Benefit Functions) (Amendment) Order 2012/646 |

  Scenario Outline: As a PL+ User I want to link to external websites from annotations
    Given PL+ user is logged in
    When User navigates to the "Legislation" "<document>"
    Then User is able to see all primary menu links
    When User selects "Provision" as primary menu
    Then "Provision" secondary menu links will be displayed
    When User selects "Annotations" as child menu
    Then "Annotations" section will be displayed
    And Verify Annotations section has link to external website link "<linkname>"
  Examples:
    | document                           | linkname                          |
    | s. 14 Enforcement of obligations   | OFCOM                             |
    | s. 3 Functions of Revenue Scotland | SP Official Report, June 11, 2014 |

  Scenario Outline: As a PL+ User I want to link to internal documents from annotations
    Given PL+ user is logged in
    When User navigates to the "Legislation" "<document>"
    Then User is able to see all primary menu links
    When User selects "Provision" as primary menu
    Then "Provision" secondary menu links will be displayed
    When User selects "Annotations" as child menu
    Then "Annotations" section will be displayed
    And Verify Annotations section has internal link "<linkname>"
  Examples:
    | document                                                                                           | linkname                                                        |
    | s. 1 OFCOM reports #on infrastructure, internet domain names etc                                   | section 134A                                                    |
    | s. 3 Functions of Revenue Scotland                                                                 | section 51(3)                                                   |
    | s. 122 The Health and Social Care Information Centre: restrictions on dissemination of information | preamble                                                        |
    | s. 3 Interpretation of legislation                                                                 | DM, R. v [2011] EWCA Crim 2752                                  |
    | s. 14 Rectification of registers                                                                   | Paddico (267) Ltd v Kirklees Metropolitan Council [2014] UKSC 7 |
    | s. 1 Definition of partnership                                                                     | I.C.C.L.R. 1996, 7(8), 297â€“299                                |

  Scenario Outline: As a PL+ User I want to see the expanded annotations section by default
    Given PL+ user is logged in
    When User navigates to the "Legislation" "<document>"
    Then User is able to see all primary menu links
    When User selects "Provision" as primary menu
    Then "Provision" secondary menu links will be displayed
    When User selects "Annotations" as child menu
    Then "Annotations" section will be displayed
    And Verify "Annotations" section has expanded by default
  Examples:
    | document                                                           |
    | s.19  Discrimination in relation to goods, facilities and services |
    | Schedule 3 ENFORCEMENT AND PROCEDURE para. 17                      |
    | Antarctic Act 2013 c. 15 - Preamble                                |
    | art. 1 Citation, commencement and effect                           |
    | rule 6.20 Methods of service -Civil Procedure Rules 1998/3132      |
    | reg. 5 Local development documents                                 |

  Scenario Outline: As a PL+ User I want to hide/show the expanded annotations section when click on show/hide annotations button
    Given PL+ user is logged in
    When User navigates to the "Legislation" "<document>"
    Then User is able to see all primary menu links
    When User selects "Provision" as primary menu
    Then "Provision" secondary menu links will be displayed
    When User selects "Annotations" as child menu
    Then "Annotations" section will be displayed
    And Verify "Annotations" section has expanded by default
    And Verify "Annotations" show/hide button is present on Annotations header
  Examples:
    | document                                                           |
    | s.19  Discrimination in relation to goods, facilities and services |
    | Schedule 3 ENFORCEMENT AND PROCEDURE para. 17                      |
    | Antarctic Act 2013 c. 15 - Preamble                                |
    | art. 1 Citation, commencement and effect                           |
    | rule 6.20 Methods of service -Civil Procedure Rules 1998/3132      |
    | reg. 5 Local development documents                                 |

  Scenario Outline: As a PL+ UserI want to view/link notes links when viewing annotations
    Given PL+ user is logged in
    When User navigates to the "Legislation" "<document>"
    And User selects "Provision" as primary menu
    Then "Provision" secondary menu links will be displayed
    When User selects "Annotations" as child menu
    Then "Annotations" section will be displayed
    And Verify Annotations section has "<linkname>" to general notes on common legal terms
  Examples:
    | document                                                     | linkname          |
    | s. 1 Overview of Act                                         | Explanatory Notes |
    | s. 1 Sheriffdoms, sheriff court districts and sheriff courts | Explanatory Notes |

  Scenario Outline: As a Unsubscribed user I want to see the annotations section hidden by default
    Given PL+ user is logged in
    When User navigates to the "Legislation" "<document>"
    Then "Annotations" section is present on document
    And Verify "Annotations" section has hidden by default
  Examples:
    | document                                                           |
    | s.19  Discrimination in relation to goods, facilities and services |
    | Schedule 3 ENFORCEMENT AND PROCEDURE para. 17                      |
    | Antarctic Act 2013 c. 15 - Preamble                                |
    | art. 1 Citation, commencement and effect                           |
    | rule 6.20 Methods of service -Civil Procedure Rules 1998/3132      |
    | reg. 5 Local development documents                                 |

  Scenario Outline: As a Unsubscribed User, I want to see the blocked message when expanded the annotations section
    Given PL+ user is logged in
    When User navigates to the "Legislation" "<document>"
    Then "Annotations" section is present on document
    And Verify "Annotations" show/hide button is present on Annotations header
    When Click on show/hide button is present on "Annotations" header
    Then Verify "Annotations" section has expanded
    And Blocked message will be displayed
  Examples:
    | document                                                           |
    | s.19  Discrimination in relation to goods, facilities and services |
    | Schedule 3 ENFORCEMENT AND PROCEDURE para. 17                      |
    | Antarctic Act 2013 c. 15 - Preamble                                |
    | art. 1 Citation, commencement and effect                           |
    | rule 6.20 Methods of service -Civil Procedure Rules 1998/3132      |
    | reg. 5 Local development documents                                 |

  Scenario Outline: As a PPV user I want to see the annotations section hidden by default
    Given PL+ user is logged in
    When User navigates to the "Legislation" "<document>"
    Then "Annotations" section is present on document
    And Verify "Annotations" section has hidden by default
  Examples:
    | document                                                           |
    | s.19  Discrimination in relation to goods, facilities and services |
    | Schedule 3 ENFORCEMENT AND PROCEDURE para. 17                      |
    | Antarctic Act 2013 c. 15 - Preamble                                |
    | art. 1 Citation, commencement and effect                           |
    | rule 6.20 Methods of service -Civil Procedure Rules 1998/3132      |
    | reg. 5 Local development documents                                 |

  Scenario Outline: As a PPV User, I want to see the warning message when expanded the annotations section
    Given PL+ user is logged in
    When User navigates to the "Legislation" "<document>"
    Then "Annotations" section is present on document
    And Verify "Annotations" show/hide button is present on Annotations header
    When Click on show/hide button is present on "Annotations" header
    Then Verify "Annotations" section has expanded
    And Warning message will be displayed
  Examples:
    | document                                                           |
    | s.19  Discrimination in relation to goods, facilities and services |
    | Schedule 3 ENFORCEMENT AND PROCEDURE para. 17                      |
    | Antarctic Act 2013 c. 15 - Preamble                                |
    | art. 1 Citation, commencement and effect                           |
    | rule 6.20 Methods of service -Civil Procedure Rules 1998/3132      |
    | reg. 5 Local development documents                                 |

  Scenario Outline: As a PPV User, View Annoations link will appear when user expanded the annotations section
    Given PL+ user is logged in
    When User navigates to the "Legislation" "<document>"
    Then "Annotations" section is present on document
    And Verify "Annotations" show/hide button is present on Annotations header
    When Click on show/hide button is present on "Annotations" header
    Then Verify "Annotations" section has expanded
    And Warning message will be displayed
    And Verify "View Annotations" links is present on "Annotations" section
  Examples:
    | document                                                           |
    | s.19  Discrimination in relation to goods, facilities and services |
    | Schedule 3 ENFORCEMENT AND PROCEDURE para. 17                      |
    | Antarctic Act 2013 c. 15 - Preamble                                |
    | art. 1 Citation, commencement and effect                           |
    | rule 6.20 Methods of service -Civil Procedure Rules 1998/3132      |
    | reg. 5 Local development documents                                 |

  Scenario Outline: As a PPV User, View Annoations link will appear when user expanded the annotations section
    Given PL+ user is logged in
    When User navigates to the "Legislation" "<document>"
    Then "Annotations" section is present on document
    And Verify "Annotations" show/hide button is present on Annotations header
    When Click on show/hide button is present on "Annotations" header
    Then Verify "Annotations" section has expanded
    When User clicks on "View Annotations" link on Annotations section
    And User Clicks "Yes" on PPV message box
    Then "Annotations" section will be displayed
  Examples:
    | document                                                           |
    | s.19  Discrimination in relation to goods, facilities and services |
    | Schedule 3 ENFORCEMENT AND PROCEDURE para. 17                      |
    | Antarctic Act 2013 c. 15 - Preamble                                |
    | art. 1 Citation, commencement and effect                           |
    | rule 6.20 Methods of service -Civil Procedure Rules 1998/3132      |
    | reg. 5 Local development documents                                 |

  Scenario Outline: As a PPV User, View Annoations link will appear when user expanded the annotations section
    Given PL+ user is logged in
    When User navigates to the "Legislation" "<document>"
    Then "Annotations" section is present on document
    And Verify "Annotations" show/hide button is present on Annotations header
    When Click on show/hide button is present on "Annotations" header
    Then Verify "Annotations" section has expanded
    When User clicks on "View Annotations" link on Annotations section
    And User Clicks "No" on PPV message box
    Then PPV message box will be closed
    And "Annotations" section will not be displayed
    And User clicks on "View Annotations" link on Annotations section
  Examples:
    | document                                                           |
    | s.19  Discrimination in relation to goods, facilities and services |
    | Schedule 3 ENFORCEMENT AND PROCEDURE para. 17                      |
    | Antarctic Act 2013 c. 15 - Preamble                                |
    | art. 1 Citation, commencement and effect                           |
    | rule 6.20 Methods of service -Civil Procedure Rules 1998/3132      |
    | reg. 5 Local development documents                                 |