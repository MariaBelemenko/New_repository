Feature: caseAnalysisDocDisplay.feature
  As a user I want to see Case analysis content within Case document so that I can read and understand the case.

  Scenario: [885375] Verify case name
    Given the user is viewing the Case Analysis tab of a Case document
    Then the user can verify the presence of the case name
    And the user can verify the presence of any alias by which the case is also known


  Scenario: [885375] Verify case digest
    Given the user is viewing the Case Analysis tab of a Case document
    Then the user is able to verify the presence of a Summary and Abstract within the Case digest section


  Scenario: [885375] Verify Appellate History Section
    Given the user is viewing the Case Analysis tab of a Case document
    Then the user can verify the presence of an Appellate history section
    And the user is able to verify that within appellate history cases are sorted by relevance by default
    And the user is able to verify that within appellate history the user is able to sort by TBD
    And the user is able to verify that each appellate history case contains the judgment date
    And the user is able to verify that each appellate history case contains the Party Names
    And the user is able to verify that each appellate history case contains the Status icon
    And the user is able to verify that each appellate history case contains the court
    And the user is able to verify that each appellate history case contains citation information
    And the user is able to verify that each appellate history case contains subject data
    And the user is able to verify that each appellate history case contains a link from the party names to the corresponding case
    And the user is able to verify the presence of an option to View Graphical History within the appellate history section

    #query - what about validating sorting order within appellate history

  Scenario: [885375] Verify related cases
    Given the user is viewing the Case Analysis tab of a Case document
    Then the user is able to verify the presence of a Related Cases section
    And the user is able to verify that cases within the related cases section are linked from the case name to the corresponding case record
    And the user is able to verify that cases within the related cases section include a status icon
    And the user is able to verify that cases within the related cases section include court information
    And the user is able to verify that cases within the related cases section include subject data
    And the user is able to verify that cases within the related cases section include one citation per reference