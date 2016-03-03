Feature: Ask Practice Area Widget
  As a PL+ user
  I want to view Ask Pages per Practice Area
  So that I can quickly find questions and answers of my interested Practice Area

  Background: 
    Given PL+ user is logged in

  Scenario: Verify that only resources belonging to pre- configured Practice Areas are displayed
    When the user is in Page '/Browse/Home/Resources/AskConstruction'
    Then the user verifies that only '6' ask resource  is displayed
    And the user verifies that link 'Can parties agree a collateral warranty is not a construction contract?' is  displayed on 'the page'
    When the user clicks link 'Can parties agree a collateral warranty is not a construction contract?' on 'the ask recent queries' page
    Then ask disclaimer is displayed on the document
    And document title is displayed as "Can parties agree a collateral warranty is not a construction contract?"

  # (Deleted) 839916:ASK - discrepancy between ask question listing for the number of replies and the actual link to the response /// (but fine for prod. See issue details)
  @manual @pendingAutomation @bug
  Scenario: Verify Ask document has apropriate numbers of replies
    When the user is in Page '/Browse/Home/Resources/AskConstruction'
    And the user open one ask document and remember the numbers of replies
    And the user can see the same number of replies on the document
