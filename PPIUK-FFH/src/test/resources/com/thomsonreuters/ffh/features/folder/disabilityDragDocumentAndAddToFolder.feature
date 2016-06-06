@wip 
Feature: [894677] As a PPI User I doesn't able drug document and to add it in folder 
#remove after QED deploy 15 June
  @releaseButton
  Scenario Outline: From Search results
    Given PL+ user is logged in
    When the user runs a free text search for the query "<query>"
    And the user waits search result to load
    And the user tries to drug "2" result
    Then there is no ability to drag document
  Examples:
    | query | 
    | Bill  | 

  @releaseButton
  Scenario Outline: Whats Market
    Given PL+ user is logged in
    When the user opens 'Resources' link
    And the user opens '<resources>' link
    And the user runs a free text search for the query "<query>"
    And the user waits search result to load
    And the user tries to drug "3" result in <resources>
    Then there is no ability to drag document
  Examples:
    | query |resources		| 
    | Tax   |What's Market	| 
    | Tax   |Ask			|
  
  
   

