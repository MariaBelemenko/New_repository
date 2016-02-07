@e2e @prod
Feature: Ask featured Queries Widget:Anonymous
  As a: PL+ user
  I want: the commonly asked question over Features Queries widget
  So that: I can quickly find questions and answers of my interest

  Scenario: As anonymous user, verify ask resource exists  and can be opened from features Queries section in Practice Area page
    Given PL+ user is not logged in
    When the user navigates to the main PLCUK page
    And the user is in Page '/Browse/Home/Resources/AskCorporate'
    Then features queries is selected by default
    Then the ask disclaimer text 'Disclaimer: None of the editorial team providing responses to Ask questions are practising solicitors or barristers. The Ask scope and rules apply' is displayed on ask Category page
    And the ask featured queries section have question 'Distributions: should directors have regard to performance subsequent to the last accounts date?'
    When the user clicks link 'Distributions: should directors have regard to performance subsequent to the last accounts date?' on 'the ask recent queries' page
    Then ask disclaimer is displayed on the document
    And document title is displayed as "Distributions: should directors have regard to performance subsequent to the last accounts date?"
    And resource type is displayed as "Ask" on right hand panel
    And Sign In button is shown to user
