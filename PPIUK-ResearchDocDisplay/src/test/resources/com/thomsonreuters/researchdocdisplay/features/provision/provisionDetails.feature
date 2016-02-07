@wip
Feature: As a PL+ User I want to navigate between the Provision Details primary section and child links in the Provision document

  Scenario Outline: User selects the  Provision Details and its child menu links in Provision Document
    Given PL+ user is logged in
    And user clicks on UK New Content Link
    And user clicks on UK Legislation
    When user enters search term "<document>"
    And user clicks on Search button
    And user clicks on Sort By Relevancy
    And User selects "<document>" based on name
    And User selects "Provision Details" as primary menu
    Then "Provision Details" menu will be expanded
    And "Provision Details" secondary menus will be displayed
    And All child data within the "Provision Details" secondary menus will be displayed
    And Other primary menus will be collapsed except the selected "Provision Details" menu
  Examples:
    | document           |
    | provisionDocument1 |

  Scenario Outline: User verifies the Provision Details are displayed on left hand side of the page
    Given PL+ user is logged in
    When User navigates to the "Legislation" "<document>"
    Then The Primary and Secondary menus should appear on the left hand side of the screen
  Examples:
    | document                                                                                         |
    | s.19  Discrimination in relation to goods, facilities and services                               |
    | Disability Discrimination Act 1995 c. 50 Preamble_Preamble                                       |
    | Schedule 5 THE NATIONAL DISABILITY COUNCIL_para. 1                                               |
    | Student Support and European University Institute_reg. 1                                         |
    | Civil Procedure (Amendment No. 8) Rules 2014_Signatures                                          |
    | Part I SCOPE OF THIS PART AND INTERPRETATION_rule 6.1 Part 6 rules about service apply generally |

  Scenario Outline: User Verifies When the Provision Details primary menu is selected then data for each part of the document will be displayed
    Given PL+ user is logged in
    When User navigates to the "Legislation" "<document>"
    Then The Primary and Secondary menus should appear on the left hand side of the screen
    When User selects "Provision Details" as primary menu
    Then Verify the provision document is displayed with each part of in it
  Examples:
    | document                                                           |
    | s.19  Discrimination in relation to goods, facilities and services |

  Scenario Outline: The Provision Details primary navigation menu will appear directly underneath the Provision Section And Child links are present underneath the Provision Details Section
    Given PL+ user is logged in
    When User navigates to the "Legislation" "<document>"
    Then The User verifies the "Provision Details" Section appears underneath the "Provision" Section
    When User selects "Provision Details" as primary menu
    Then "Provision Details" menu will be expanded
    And "Provision Details" secondary menus will be displayed underneath it
  Examples:
    | document                                                                                         |
    | s.19  Discrimination in relation to goods, facilities and services                               |
    | Disability Discrimination Act 1995 c. 50 Preamble_Preamble                                       |
    | Schedule 5 THE NATIONAL DISABILITY COUNCIL_para. 1                                               |
    | Student Support and European University Institute_reg. 1                                         |
    | Civil Procedure (Amendment No. 8) Rules 2014_Signatures                                          |
    | Part I SCOPE OF THIS PART AND INTERPRETATION_rule 6.1 Part 6 rules about service apply generally |

  Scenario Outline: User verifies Provision Details section child links are jump links
    Given PL+ user is logged in
    When User navigates to the "Legislation" "<document>"
    When User selects "Provision Details" as primary menu
    Then "Provision Details" menu will be expanded
    And "Provision Details" Secondary menus are jump links
  Examples:
    | document                                                           |
    | Schedule 3 ENFORCEMENT AND PROCEDURE para. 17                      |
    | s.19  Discrimination in relation to goods, facilities and services |

  Scenario Outline: User selects the child links and verify the other primary sections are collapsed.
    When User selects child menu "<childLinkName>"
    Then All child data within the "<childLinkName>" will be displayed
    And Other primary menus will be collapsed except the selected "Provision Details" menu
  Examples:
    | document                                                           | childLinkName         |
    | s.19  Discrimination in relation to goods, facilities and services | Table of Amendments   |
    | s.19  Discrimination in relation to goods, facilities and services | Commencement & Extent |
    | s.19  Discrimination in relation to goods, facilities and services | Modifications         |
    | s.19  Discrimination in relation to goods, facilities and services | SIs Made Under Act    |

  Scenario Outline: User selects the Enabling Act link and verify the other primary sections are collapsed.
    Given PL+ user is logged in
    When User navigates to the "Legislation" "<document>"
    And User selects "Provision Details" as primary menu
    Then "Provision Details" menu will be expanded
    And "Provision Details" Secondary menus are jump links
    When User selects child menu "<childLinkName>"
    Then All child data within the "<childLinkName>" will be displayed
    And Other primary menus will be collapsed except the selected "Provision Details" menu
  Examples:
    | document                                                                                         | childLinkName |
    | Student Support and European University Institute_reg. 1                                         | Enabling Act  |
    | Civil Procedure (Amendment No. 8) Rules 2014_Signatures                                          | Enabling Act  |
    | Part I SCOPE OF THIS PART AND INTERPRETATION_rule 6.1 Part 6 rules about service apply generally | Enabling Act  |

  Scenario Outline: User verifies no Provision Details menu and child links are present
    Given PL+ user is logged in
    When User navigates to the "Legislation" "<document>"
    Then Verify the "Provision Details" menu link is not present
    And Verify the "Provision Details" child menus are not present
  Examples:
    | document      |
    | Test document |
