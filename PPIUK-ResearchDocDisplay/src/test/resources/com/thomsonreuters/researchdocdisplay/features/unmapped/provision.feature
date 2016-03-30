@wip
Feature: As a PL+ User I want to navigate between the primary sections in the Provision Section

  Scenario Outline: User verifies the Provision document is viewable
    Given PL+ user is logged in
    And user clicks on UK New Content Link
    And user clicks on UK Legislation
    When user enters search with "<document>"
    And user clicks on Search button
    And user clicks on Sort By Relevancy
    And User selects "<document>"
    Then User is viewing Provision "<document>"
  Examples:
    | document           |
    | provisionDocument1 |
    | provisionDocument2 |

  Scenario Outline: User verifies the Provision primary links are displayed
    Given PL+ user is logged in
    And user clicks on UK New Content Link
    And user clicks on UK Legislation
    When user enters search with "<document>"
    And user clicks on Search button
    And user clicks on Sort By Relevancy
    And User selects "<document>"
    Then User is able to see all primary menu links "<document>"
  Examples:
    | document           |
    | provisionDocument1 |
    | provisionDocument2 |

  Scenario Outline: User verifies the Provision primary links expand/collapse
    Given PL+ user is logged in
    And user clicks on UK New Content Link
    And user clicks on UK Legislation
    When user enters search term "<document>"
    And user clicks on Search button
    And user clicks on Sort By Relevancy
    And User selects "<document>" based on name
    Then User is able to see all primary menu links
    And Verify expand and collapse icon present on primary links
    And Verify expand button is expanding When clicking on the primary menu link and others are collapsing
  Examples:
    | document                                                           |
    | s.19  Discrimination in relation to goods, facilities and services |

  Scenario Outline: Provision is the default selection of Provision document primary link
    Given PL+ user is logged in
    When User navigates to the "Legislation" "<document>"
    Then User is able to see all primary menu links
    And Provision menu will be selected and expanded as default
    And "Provision" secondary menu links will be displayed
  Examples:
    | document                                                           |
    | s.19  Discrimination in relation to goods, facilities and services |
    | Schedule 3 ENFORCEMENT AND PROCEDURE para. 17                      |

  Scenario Outline: User verifies the Provision Navigation links are displayed on left hand side of the page and Provision section child links are jump links
    Given PL+ user is logged in
    When User navigates to the "Legislation" "<document>"
    Then The Primary and Secondary menus should appear on the left hand side of the screen
    And Provision menu will be selected and expanded as default
    And "Provision" Secondary menus are jump links
  Examples:
    | document                                                           |
    | s.19  Discrimination in relation to goods, facilities and services |

  Scenario Outline: User selects the child links and verify the then they will be taken to that part of the document
    When User selects child menu "<childLinkName>"
    Then All child data within the "<childLinkName>" will be displayed
    And Other primary menus will be collapsed except the selected "Provision" menu
  Examples:
    | document                                                           | childLinkName               |
    | s.19  Discrimination in relation to goods, facilities and services | England, Scotland and Wales |
    | s.19  Discrimination in relation to goods, facilities and services | Northern Ireland            |
    | s.19  Discrimination in relation to goods, facilities and services | Amendments                  |
    | s.19  Discrimination in relation to goods, facilities and services | Modifications               |
    | s.19  Discrimination in relation to goods, facilities and services | Annotations                 |

  Scenario Outline: User selects the Provision primary link and its child menu links in Provision Document
    Given PL+ user is logged in
    When User navigates to the "Legislation" "<document>"
    Then User is able to see all primary menu links
    When User selects "Provision" as primary menu
    Then Provision menu will be selected and expanded as default
    And All child data within the "Provision" secondary menus will be displayed
  Examples:
    | document                                                           |
    | s.19  Discrimination in relation to goods, facilities and services |
    | Schedule 3 ENFORCEMENT AND PROCEDURE para. 17                      |

  Scenario Outline: As a PL+ User with a WLUK Subscription I want to view the Jurisdiction(s) the provision applies to (within the Legislation Provision Section)
    Given PL+ user is logged in
    When User navigates to the "Legislation" "<document>"
    Then User is able to see all primary menu links
    When User selects "Provision" as primary menu
    Then "Provision" secondary menu links will be displayed
    And Verify the Title of the act
    And and year of the act
    And the part of the act
    And the individual section of the document
    And the status of the Law
    And the Version number
    And the Provision effective date
    And the Individual "<Jurisdiction>"(s) the provision applies to and the details of the law
  Examples:
    | document                                                                                  | Jurisdiction                                 |
    | s.19  Discrimination in relation to goods, facilities and services                        | England, Scotland and Wales_Northern Ireland |
    | s. 29A Medical lists                                                                      | England_Wales                                |
    | s. 7 Requirement for landlords to be licensed to carry out property management activities | Wales                                        |
    | s. 2 Payments to HMRC                                                                     | Northern Ireland                             |
    | s. 2 Appeal from decisions etc. of sheriff under sections 64, 65 and 66 of 1984 Act       | Scotland                                     |

  Scenario Outline: As a PL+ User, I want to click on the Jurisdiction(s) links present on left hand side navigation of the provision applies to.
    Given PL+ user is logged in
    When User navigates to the "Legislation" "<document>"
    Then User is able to see all primary menu links
    When User selects "Provision" as primary menu
    Then "Provision" secondary menu links will be displayed
    When Click on Individual "<Jurisdiction>" link
    Then "<Jurisdiction>" block will be displayed as the first block in the document
  Examples:
    | document                                                           | Jurisdiction                |
    | s.19  Discrimination in relation to goods, facilities and services | England, Scotland and Wales |
    | s.19  Discrimination in relation to goods, facilities and services | Northern Ireland            |
    | s. 29A Medical lists                                               | England                     |
    | s. 29A Medical lists                                               | Wales                       |

  Scenario Outline: As a PL+ User wants to view the provision with no Jurisdiction(s) Links when the law is same in all Jurisdictions
    Given PL+ user is logged in
    When User navigates to the "Legislation" "<document>"
    And User selects "Provision" as primary menu
    Then "Provision" secondary menu links will be displayed
    And The jurisdiction(s) are not present in provision section for legislation document
  Examples:
    | document                                                                                             |
    | s. 28N Civil proceedings                                                                             |
    | Schedule 3 ENFORCEMENT AND PROCEDURE Part V Discrimination in General Qualifications Bodies_para. 17 |
    | reg. 15 Duty of Board to consult with host State authority                                           |

  Scenario Outline: User selects the  Modifications in Provision section and verify the Modifications Header and section
    Given PL+ user is logged in
    When User navigates to the "Legislation" "<document>"
    And User selects "Provision" as primary menu
    Then "Provision" secondary menu links will be displayed
    And Verify the "Modifications" child menu is present under "Provision" menu
    When User selects "Modifications" as child menu
    Then "Modifications" section will be displayed
    And "Modifications" Header will be displayed
  Examples:
    | document                                                                                                                   |
    | s.19  Discrimination in relation to goods, facilities and services                                                         |
    | Schedule 3 ENFORCEMENT AND PROCEDURE Part V Discrimination in General Qualifications Bodies_para. 17                       |
    | Town and Country Planning (Local Planning) (England) Regulations 2012/767_reg. 17 Application and interpretation of Part 6 |
    | rule 6.27 Change of address for service                                                                                    |

  Scenario Outline: User cannot see the Modifications link under Provision section in the Provision document which is not having any modifications
    Given PL+ user is logged in
    When User navigates to the "Legislation" "<document>"
    And User selects "Provision" as primary menu
    Then "Provision" secondary menu links will be displayed
    And Verify the "Modifications" child menu is not present under "Provision" menu
    And "Modifications" header will not be displayed
    And "Modifications" section will not be displayed
  Examples:
    | document                                                             |
    | Rent Officers (Housing Benefit Functions) (Amendment) Order 2012/646 |

  Scenario Outline: User Scrolls the document to the Modifications section if it is available, and verify the section internal links
    Given PL+ user is logged in
    When User navigates to the "Legislation" "<document>"
    Then "Modifications" section is present on document
    And Verify Modifications section has internal link "<linkname>"
    When Select the internal link "<linkname>" in Modifications
    Then the legislation "<document>" will be closed
    And Appropriate section link "<linkTitle>" will be opened in the same window
  Examples:
    | document                                                                                             | linkname                                                                                                                                                            | linkTitle                                                     |
    | s. 19 Discrimination in relation to goods, facilities and services.                                  | Disability Discrimination Act 1995 c. 50, Sch. 2 para. 2_Disability Discrimination Act 1995 c. 50, Pt III s. 21A(4)_Pt I s. 2(2)                                    | Schedule 2 PAST DISABILITIES                                  |
    | Schedule 3 ENFORCEMENT AND PROCEDURE Part V Discrimination in General Qualifications Bodies_para. 17 | Disability Discrimination Act 1995 (Amendment etc.) (General Qualifications Bodies) (Alteration of Premises and Enforcement) Regulations 2007/2405, Pt 5 reg. 14(2) | Alteration of Premises and Enforcement                        |
    | reg. 17 Application and interpretation of Part 6                                                     | Town and Country Planning (Local Planning) (England) Regulations 2012/767, Sch. 1 para. 3(4)                                                                        | para. 3 Procedure for pre-submission local plans              |
    | rule 6.27 Change of address for service                                                              | Court of Protection Rules 2007/1744, Pt 6 rule 39                                                                                                                   | rule 39 Application of Family Procedure (Adoption) Rules 2005 |
    | s. 21 Duty of providers of services to make adjustments.                                             | Disability Discrimination Act 1995 c. 50, Pt III s. 21A(6)_Disability Discrimination Act 1995 c. 50, Sch. 2 para. 2_Pt I s. 2(2)                                    | s. 21A Employment services                                    |

  Scenario Outline: As a PL+ User I want to link to internal documents from Modifications
    Given PL+ user is logged in
    When User navigates to the "Legislation" "<document>"
    Then User is able to see all primary menu links
    When User selects "Provision" as primary menu
    Then "Provision" secondary menu links will be displayed
    When User selects "Modifications" as child menu
    Then "Modifications" section will be displayed
    And Verify Modifications section has internal link "<linkname>"
  Examples:
    | document                                                                                             | linkname                                                                                                                                                            | linkTitle                                                     |
    | s. 19 Discrimination in relation to goods, facilities and services.                                  | Disability Discrimination Act 1995 c. 50, Sch. 2 para. 2_Disability Discrimination Act 1995 c. 50, Pt III s. 21A(4)                                                 | Schedule 2 PAST DISABILITIES                                  |
    | Schedule 3 ENFORCEMENT AND PROCEDURE Part V Discrimination in General Qualifications Bodies_para. 17 | Disability Discrimination Act 1995 (Amendment etc.) (General Qualifications Bodies) (Alteration of Premises and Enforcement) Regulations 2007/2405, Pt 5 reg. 14(2) | Alteration of Premises and Enforcement                        |
    | reg. 17 Application and interpretation of Part 6                                                     | Town and Country Planning (Local Planning) (England) Regulations 2012/767, Sch. 1 para. 3(4)                                                                        | para. 3 Procedure for pre-submission local plans              |
    | rule 6.27 Change of address for service                                                              | Court of Protection Rules 2007/1744, Pt 6 rule 39                                                                                                                   | rule 39 Application of Family Procedure (Adoption) Rules 2005 |
    | s. 21 Duty of providers of services to make adjustments                                              | Disability Discrimination Act 1995 c. 50, Pt III s. 21A(6)_Disability Discrimination Act 1995 c. 50, Sch. 2 para. 2_Pt I s. 2(2)                                    | s. 21A Employment services                                    |

  Scenario Outline: As a PL+ User, want to hide/show the expanded modifications section when click on show/hide annotations button
    Given PL+ user is logged in
    When User navigates to the "Legislation" "<document>"
    Then User is able to see all primary menu links
    When User selects "Provision" as primary menu
    Then "Provision" secondary menu links will be displayed
    When User selects "Modifications" as child menu
    Then "Modifications" section will be displayed
    And Verify "Modifications" section has expanded by default
    And Verify "Modifications" show/hide button is present on Annotations header
    When Click on show/hide button is present on "Modifications" header
    Then Verify "Modifications" section has hidden
    And Verify "Modifications" show/hide button is present on Annotations header
    When Click on show/hide button is present on "Modifications" header
    Then Verify "Modifications" section has expanded
    And Verify "Modifications" show/hide button is present on Annotations header
  Examples:
    | document                                                                                                                   |
    | s.19  Discrimination in relation to goods, facilities and services                                                         |
    | Schedule 3 ENFORCEMENT AND PROCEDURE Part V Discrimination in General Qualifications Bodies_para. 17                       |
    | Town and Country Planning (Local Planning) (England) Regulations 2012/767_reg. 17 Application and interpretation of Part 6 |
    | rule 6.27 Change of address for service                                                                                    |

  Scenario Outline: User selects the  Amendments in Provision section and verify the Amendments Header
    Given PL+ user is logged in
    When User navigates to the "Legislation" "<document>"
    And user clicks on Search button
    When user clicks on Sort By Relevancy
    And User selects specific "<document>" based on name
    When User selects "Provision" as primary menu
    Then "Provision" secondary menu links will be displayed
    When User selects "Amendments" as child menu
    Then "Amendments" section will be displayed
    And "Amendments" Header will be displayed
  Examples:
    | document           |
    | provisionDocument1 |

  Scenario Outline: User cannot see the Amendments link under Provision section in the Provision document which is not having any Amendments
    Given PL+ user is logged in
    When User navigates to the "Legislation" "<document>"
    And User selects "Provision" as primary menu
    Then "Provision" secondary menu links will be displayed
    And Verify the "Modifications" child menu is not present under "Provision" menu
    And "Amendments" section will not be displayed
  Examples:
    | document |
    | doc name |

  Scenario Outline: User selects the Primary References and its child menu links in Provision Document
    Given PL+ user is logged in
    When User navigates to the "Legislation" "<document>"
    And user clicks on Search button
    When user clicks on Sort By Relevancy
    When User selects "<document>" based on name
    And User selects "Primary References" as primary menu
    Then "Primary References" menu will be expanded
    And User is able to see all primary menu links "<document>"
    And All child data within the "Primary References" secondary menus will be displayed
    And Other primary menus will be collapsed except the selected "Primary References" menu
  Examples:
    | document           |
    | provisionDocument1 |

  Scenario Outline: User selects the Commentary and its child menu links in Provision Document
    Given PL+ user is logged in
    When User navigates to the "Legislation" "<document>"
    And User selects "Commentary" as primary menu
    Then "Commentary" menu will be expanded
    When "Commentary" secondary menu links will be displayed
    Then User is able to see all primary menu links "<document>"
    And All child data within the "Commentary" secondary menus will be displayed
    And Other primary menus will be collapsed except the selected "Commentary" menu
  Examples:
    | document           |
    | provisionDocument1 |

  Scenario Outline: As a PL+ User I want to link to and retrieve the Arrangement of Provisions / SI document from anywhere in a provision document
    Given PL+ user is logged in
    When User navigates to the "Legislation" "<document>"
    Then Verify the "<Primary Link>" is present
    When User selects "<Primary Link>" as primary menu
    Then Verify the "<Arrangement of Act or SI>" link is present
    When Click On "<Arrangement of Act or SI>" link
    Then "<Arrangement of Act or SI>" page is displayed with Other provisions
  Examples:
    | document                                                                                             | Primary Link       | Arrangement of Act or SI                                                   |
    | s.19  Discrimination in relation to goods, facilities and services                                   | Provision          | Disability Discrimination Act 1995 c. 50                                   |
    | s.19  Discrimination in relation to goods, facilities and services                                   | Provision Details  | Disability Discrimination Act 1995 c. 50                                   |
    | s.19  Discrimination in relation to goods, facilities and services                                   | Primary References | Disability Discrimination Act 1995 c. 50                                   |
    | s.19  Discrimination in relation to goods, facilities and services                                   | Commentary         | Disability Discrimination Act 1995 c. 50                                   |
    | Schedule 3 ENFORCEMENT AND PROCEDURE Part V Discrimination in General Qualifications Bodies_para. 17 | Provision          | Disability Discrimination Act 1995 c. 50                                   |
    | Antarctic Act 2013 c. 15-Preamble                                                                    | Provision          | Antarctic Act 2013 c. 15                                                   |
    | art. 1 Citation, commencement and effect                                                             | Provision          | New Firefighters' Pension Scheme (Amendment) Order (Northern Ireland) 2015 |
    | rule 6.20 Methods of service                                                                         | Provision          | Civil Procedure Rules 1998/3132                                            |
    | reg. 5 Local development documents                                                                   | Provision          | Town and Country Planning (Local Planning) (England) Regulations 2012/767  |

  Scenario Outline: As a PL+ User I want to view images in a legislation provision document
    Given PL+ user is logged in
    When User navigates to the "Legislation" "<document>"
    And User selects "Provision" as primary menu
    Then Verify the image is present on left hand side of Provision document
  Examples:
    | document                                                        |
    | School Crossing Patrol Sign (Scotland) Regulations 2008_para. 1 |
    | Harrogate Stray Act 1985 (Tour de France) Order 2014_para. 1    |
