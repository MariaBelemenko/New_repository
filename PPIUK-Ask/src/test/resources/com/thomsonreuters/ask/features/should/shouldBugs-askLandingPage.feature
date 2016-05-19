@bug @should
Feature: Ask Landing Page
  As a: PL+ user
  I want: to go to main Ask Landing Page
  So that: I can quickly ask question from the ask Landing Page

  Background:
    Given PL+ user is logged in

  # 847368:[REGRESSION] Ask: Recent queries at ask page has a post date in US format
  Scenario: Verify ask landing page from Browse Menu-Resources Tab
    When the user is in page 'Browse Menu>Resources>Ask' with page Title 'Ask'
    Then the ask disclaimer text 'Disclaimer: None of the editorial team providing responses to Ask questions are practising solicitors or barristers. The Ask scope and rules apply' is displayed on ask Landing page
    And the user verifies that the current PageTitle contains 'Ask'
    Then the user verifies that at least '5' recent questions are displayed
    And the user verifies that all queries have date in format 'DD MMMM YYYY'
    And the user verifies that ask landing queries are sorted by 'Posted date' by descending order
    And the user verifies that all queries have at least 1 reply/replies'
