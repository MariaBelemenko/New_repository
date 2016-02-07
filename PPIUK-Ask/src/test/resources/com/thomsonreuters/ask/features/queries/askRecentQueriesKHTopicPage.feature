Feature: Ask Recent Queries Widget for KH Topic Page
  As a PL+ user
  I want the recently asked question over Recent Queries widget
  So that I can quickly find questions and answers of my interest

  Background:
    Given PL+ user is logged in with following details
      | userName | AskTestuser |

  # 839330:WCMS widgets not displaying document titles for legal updates and ask widgets
  @e2e @prod @bug
  Scenario Outline: Verify Recent Queries resources on Topic page
    When the user is in page '<page>' with page Title '<title>'
    Then the user verifies that at least '2' recent questions are displayed
    When the user clicks recent query no 1
    Then resource type is displayed as "Ask" on right hand panel
    And ask disclaimer is displayed on the document
  Examples:
    | page                                        | title                            |
    | Commercial>General contract and boilerplate | General Contract and Boilerplate |
    | Commercial>Agency                           | Agency                           |

  Scenario: Verify Recent Queries section- no of resources,date format, reply and date sorting order by descending order
    When the user is in page 'Commercial>General contract and boilerplate' with page Title 'General Contract and Boilerplate'
    Then the user verifies that at least '2' recent questions are displayed
    And the user verifies that all queries have date in format 'DD MMMM YYYY'
    And the user verifies that all queries have at least 1 reply/replies'
    And the user verifies that queries are sorted by 'Posted date' by descending order
