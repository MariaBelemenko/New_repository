Feature: [752396] Ask Recent Queries Widget
  As a PL+ user
  I want the recently asked question over Recent Queries widget
  So that I can quickly find questions and answers of my interest

  Background:
    Given PL+ user is logged in

  Scenario: Verify Recent Queries section has at least one ask resource
    When the user is in Page '/Browse/Home/Resources/AskCorporate'
    And the user clicks 'Recent queries' tab
    Then the user verifies that at least '5' recent questions are displayed
    And the user verifies that queries are sorted by 'Posted date' by descending order

  # 839330:WCMS widgets not displaying document titles for legal updates and ask widgets
  @manual @bug
  Scenario: Verify Recent Queries links have appropriate name
    When the user is in Page '/Browse/Home/Resources/AskCorporate'
    And the user clicks 'Recent queries' tab
    Then the user verifies that each link has appropriate name



