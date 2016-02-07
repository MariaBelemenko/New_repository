Feature: Check the list of Topic links on the Content Type Practice Area Pages.
  As a PL+ user who is also subscribed to WestLaw UK Research Content
  I want to see the list of relevant topics displayed on the Research Content Practice Area Page

  Scenario Outline: List of topics links in Cases Practice Area Page
    Given PL+ user is logged in
    And user navigates to RB PLC Home Page
    When user navigates directly to <researchLink><practiceArea> Page
    Then topic links for <practiceArea> Practice Area are displayed
  Examples:
    | researchLink | practiceArea |
    | Journals     | Tax          |
    | Cases        | Tax          |
    | Legislation  | Tax          |