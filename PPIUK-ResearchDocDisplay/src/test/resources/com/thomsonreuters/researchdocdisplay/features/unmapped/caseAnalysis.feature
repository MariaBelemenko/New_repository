@wip
Feature: As a PL+ User I want to navigate between the primary sections in the cases document

  Scenario Outline: User verifies the document is viewable
    Given PL+ user is logged in
    And user clicks on UK New Content Link
    Given user clicks on UK CASES
    When user enters search with "<document>"
    And user clicks on Search button
    When user clicks on Sort By Relevancy
    Then user verifies Cases Results
    When User selects "<document>"
    Then User is viewing a Case "<document>"
  Examples:
    | document      |
    | caseDocument1 |
    | caseDocument2 |

  Scenario Outline: : User verifies the Case Document primary links
    Given PL+ user is logged in
    When User navigates to the "Cases" "<document>"
    Then User is able to see all primary menu links "<document>"
  Examples:
    | document      |
    | caseDocument1 |
    | caseDocument2 |

  Scenario Outline: : Case Analysis and Case Digest is the default selection for the first time
    Given PL+ user is logged in
    When User navigates to the "Cases" "<document>"
    Then Case Analysis menu will be selected and expanded as default
    And Case Digest child menu will be selected as default
  Examples:
    | document      |
    | caseDocument1 |
    | caseDocument2 |

  Scenario Outline: User selects the Case analysis primary link and its child menu links
    Given PL+ user is logged in
    When User navigates to the "Cases" "<document>"
    Then Case Analysis menu will be selected and expanded as default
    And "Case Analysis" secondary menus will be displayed
    And All child data within the "Case Analysis" secondary menus will be displayed
    And Other primary menus will be collapsed except the selected "Case Analysis" menu
  Examples:
    | document      |
    | caseDocument1 |
    | caseDocument2 |

  Scenario Outline:User selects the Law Reports and its child menu links in Case Document
    Given PL+ user is logged in
    When User navigates to the "Cases" "<document>"
    And User selects "Law Reports"
    Then "Law Reports" menu will be expanded
    And "Law Reports" secondary menus will be displayed
    And All child data within the "Law Reports" secondary menus will be displayed
    And Other primary menus will be collapsed except the selected "Law Reports" menu
  Examples:
    | document      |
    | caseDocument1 |

  Scenario Outline: User selects the Judgement in Case Digest and its child menu links in Case Document
    Given PL+ user is logged in
    When User navigates to the "Cases" "<document>"
    Then User is viewing a Case "<document>"
    When User selects "Judgement"
    Then "Judgement" menu will be expanded
    And Official transcript data will be displayed
    And Other primary menus will be collapsed except the selected "Judgement" menu
  Examples:
    | document      |
    | caseDocument1 |

  Scenario Outline: : User selects the Primary References in Case Digest and its child menu links in Case Document
    Given PL+ user is logged in
    When User navigates to the "Cases" "<document>"
    Then User is viewing a Case "<document>"
    When User selects "Primary References"
    Then "Primary References" menu will be expanded
    And "Primary References" secondary menus will be displayed
    And All child data within the "Primary References" secondary menus will be displayed
    And Other primary menus will be collapsed except the selected "Primary References" menu
  Examples:
    | document      |
    | caseDocument1 |

  Scenario Outline: User selects the Commentary in Case Digest and its child menu links in Case Document
    Given PL+ user is logged in
    When User navigates to the "Cases" "<document>"
    Then User is viewing a Case "<document>"
    When User selects "Commentary"
    Then "Commentary" menu will be expanded
    And "Commentary" secondary menus will be displayed
    And All child data within the "Commentary" secondary menus will be displayed
    And Other primary menus will be collapsed except the selected "Commentary" menu
  Examples:
    | document      |
    | caseDocument1 |
