Feature: [752397] Ask Tab on each Practice Area Page
  As a PL+ user
  I want to view Ask Tab per Practice Area Page
  So that I can quickly find Ask content from each Practice Area page

  Background: 
    Given PL+ user is logged in

  Scenario: Verify that on a Practice Area Page ask Tab exists and it has 5 queries and queries are sorted by Post Date
    When the user is in page 'Construction' with page Title 'Construction'
    Then the Ask Tab is displayed on the page
    When the user clicks 'Ask' tab
    And the user verifies that exactly '5' ask tab recent questions are displayed
    And the user verifies that Ask Tab queries are sorted by 'Posted date' by descending order

  Scenario: Verify that disclaimer text on Ask tab page
    When the user is in page 'Construction' with page Title 'Construction'
    And the user clicks 'Ask' tab
    Then the ask disclaimer text 'Disclaimer: None of the Editorial team providing responses to Ask Questions are practising solicitors or barristers. The Ask scope and rules apply' is displayed on ask tab page
    And the user verifies that link 'Go to Ask: Construction' is  displayed on 'the Ask Tab Page'
    When the user clicks link 'Go to Ask: Construction' on 'the Ask Tab Page' page
    Then the user verifies that the current PageTitle contains 'Ask: Construction'
