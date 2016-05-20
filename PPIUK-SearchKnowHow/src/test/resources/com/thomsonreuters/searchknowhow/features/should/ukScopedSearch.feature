@should
Feature: [702171][702170] - Scoped Search - Practice Area Search

  Background: Log on to test site
    Given PL+ user is logged in

  #860453:REGRESSION - topic information missing from know how resources
  #885342:[HS]Topics are not appearing in the related content section of a document on Firefox
  @e2e @prod
  Scenario Outline: [702171] As a PL+ user conducting a search from a subject area (topic) page (and therefore the search is already scoped), I will only see results coded to that subject area and its parent practice area.
    And the user selects the link to Media and Telecoms
    And the user selects the link to Social Media
    And the user runs a free text search for the query "<query>"
    And the user pauses for "3" seconds
    Then the user opens the result in position "<position>"
    And the user pauses for "3" seconds
    And the user verifies that the product detail contains the practice area "<practicearea>"
    And the user verifies that the product detail contains the topic area "<topicarea>"
  Examples:
    | query   | position | practicearea     | topicarea    |
    | profile | 1        | Media & Telecoms | Social Media |
