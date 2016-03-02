@e2e @prod
Feature: [752395] Ask featured Queries Widget:Anonymous
  As a: PL+ user
  I want: the commonly asked question over Features Queries widget
  So that: I can quickly find questions and answers of my interest

  Scenario: As anonymous user, verify ask resource exists  and can be opened from features Queries section in Practice Area page
    Given PL+ user is not logged in
    When the user navigates to the main PLCUK page
    And the user is in Page '/Browse/Home/Resources/AskCorporate'
    Then features queries is selected by default
    Then the ask disclaimer text 'Disclaimer: None of the editorial team providing responses to Ask questions are practising solicitors or barristers. The Ask scope and rules apply' is displayed on ask Category page
    And the ask featured queries section have question 'Is advice given by an in-house foreign lawyer privileged?'
    When the user clicks link 'Is advice given by an in-house foreign lawyer privileged?' on 'the ask recent queries' page
    Then ask disclaimer is displayed on the document
    And document title is displayed as "Is advice given by an in-house foreign lawyer privileged?"
    And resource type is displayed as "Ask" on right hand panel
    And Sign In button is shown to user
