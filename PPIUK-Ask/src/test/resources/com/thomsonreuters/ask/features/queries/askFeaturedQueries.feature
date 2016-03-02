@e2e @prod
Feature: Ask featured Queries Widget
  As a: PL+ user
  I want: the commonly asked question over Features Queries widget
  So that: I can quickly find questions and answers of my interest

  Scenario: Verify ask resource page from features Queries section
    Given PL+ user is logged in
    When the user is in Page '/Browse/Home/Resources/AskCorporate'
    Then the ask disclaimer text 'Disclaimer: None of the editorial team providing responses to Ask questions are practising solicitors or barristers. The Ask scope and rules apply' is displayed on ask Category page
    And the ask featured queries section have question 'Is advice given by an in-house foreign lawyer privileged?'
    When the user clicks link 'Is advice given by an in-house foreign lawyer privileged?' on 'the ask recent queries' page
    Then ask disclaimer is displayed on the document
    And document title is displayed as "Is advice given by an in-house foreign lawyer privileged?"
    And resource type is displayed as "Ask" on right hand panel
    And plc reference is displayed as "A-011-8431"
