Feature: Ask Practice Area Widget
  As a PL+ user
  I want to view Ask Pages per Practice Area
  So that I can quickly find questions and answers of my interested Practice Area

  Background: 
    Given PL+ user is logged in with following details
      | userName | AskTestuser |

  Scenario: Verify that only resources belonging to pre- configured Practice Areas are displayed
    When the user is in Page '/Browse/Home/Resources/AskConstruction'
    Then the user verifies that only '5' ask resource  is displayed
    And the user verifies that link 'How do I prevent a contractor abusing its position as both main contractor and enabling works contractor?' is  displayed on 'the page'
    When the user clicks link 'How do I prevent a contractor abusing its position as both main contractor and enabling works contractor?' on 'the ask recent queries' page
    Then ask disclaimer is displayed on the document
    And document title is displayed as "How do I prevent a contractor abusing its position as both main contractor and enabling works contractor?"

  @manual
  Scenario: Verify Ask document has apropriate numbers of replies
    When the user is in Page '/Browse/Home/Resources/AskConstruction'
    And the user open one ask document and remember the numbers of replies
    And the user can see the same number of replies on the document
