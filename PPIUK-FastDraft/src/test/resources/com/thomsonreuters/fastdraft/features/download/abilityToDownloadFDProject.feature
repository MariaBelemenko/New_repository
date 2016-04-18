@robot @e2e
Feature: [770524] FD10 Download Fast Draft Project (Document)

#  Robot Tests can only be run LOCALLY
  Scenario Outline: Standard Document and No FS
    Given PL+ user is logged in with following details
      | routing          | FAST_DRAFT |
      | mandatoryRouting | YES        |
    When the user come back on to Home page
    And the user deletes all files with name "draft" and extension "<extension>" from Downloads
    And the user opens 'Resources' link
    And the user opens 'Standard documents and drafting notes' link
    And the user opens "<practiceArea>" link
    And the user opens "<document>" link
    And the user clicks Start Drafting button
    Then the user is redirected to question page for "<document>"
    When the user goes View Draft
    And the user clicks Word document and saves .doc file
    Then draft file with extension "<extension>" should download to the users machine
    When the file should be removed
  Examples:
    | practiceArea | document                                     | extension |
    | Employment   | Settlement agreement: employment (long form) | .doc      |

  Scenario Outline: Standard Document and FS
    Given PL+ user is logged in with following details
      | userName         | FStyleUser           |
      | routing          | FAST_DRAFT_FIRM_STYLE |
      | mandatoryRouting | YES                   |
    When the user come back on to Home page
    And the user deletes all files with name "draft" and extension "<extension>" from Downloads
    And the user opens 'Resources' link
    And the user opens 'Standard documents and drafting notes' link
    And the user opens "<practiceArea>" link
    And the user opens "<document>" link
    And the user clicks Start Drafting button
    Then the user is redirected to question page for "<document>"
    When the user goes View Draft
    And the user clicks Word document and saves .doc file
    Then draft file with extension "<extension>" should download to the users machine
    And the file should be removed
  Examples:
    | practiceArea | document                               | extension |
    | Property     | Lease of whole with prescribed clauses | .doc      |

  Scenario Outline: Form E editable PDF
    Given PL+ user is logged in with following details
      | routing          | FAST_DRAFT |
      | mandatoryRouting | YES        |
    When the user come back on to Home page
    And the user deletes all files with name "draft" and extension "<extension>" from Downloads
    And the user come back on to Home page
    And the user opens "<practiceArea>" link
    And the user opens Form E page
    And the user starts here Form E
    Then the user is redirected to question page for "<document>"
    When the user goes View Draft
    And the user exports Form E as editable PDF
    Then draft file with extension "<extension>" should download to the users machine
    And the file should be removed
  Examples:
    | practiceArea | document       | extension |
    | Family       | Finance Form E | .pdf      |

  Scenario Outline: Form E printable PDF
    Given PL+ user is logged in with following details
      | routing          | FAST_DRAFT |
      | mandatoryRouting | YES        |
    When the user come back on to Home page
    And the user deletes all files with name "draft" and extension "<extension>" from Downloads
    And the user come back on to Home page
    And the user opens "<practiceArea>" link
    And the user opens Form E page
    And the user starts here Form E
    Then the user is redirected to question page for "<document>"
    When the user goes View Draft
    And the user exports Form E as printable PDF
    Then draft file with extension "<extension>" should download to the users machine
    And the file should be removed
  Examples:
    | practiceArea | document       | extension |
    | Family       | Finance Form E | .pdf      |

  Scenario:
    Given PL+ user is logged in with following details
      | routing          | FAST_DRAFT |
      | mandatoryRouting | YES        |
    When the user goes My FastDraft
    Then the user is redirected to Fast Draft dashboard
    When the user deletes all Fast Draft projects
    Then there are no Fast Draft projects
    And user relogs in

  Scenario:
    Given PL+ user is logged in with following details
      | userName         | FStyleUser           |
      | routing          | FAST_DRAFT_FIRM_STYLE |
      | mandatoryRouting | YES                   |
    When the user goes My FastDraft
    Then the user is redirected to Fast Draft dashboard
    When the user deletes all Fast Draft projects
    Then there are no Fast Draft projects
    And user relogs in
