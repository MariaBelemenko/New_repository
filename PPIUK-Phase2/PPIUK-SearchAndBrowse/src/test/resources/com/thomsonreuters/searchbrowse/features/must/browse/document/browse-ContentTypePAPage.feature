Feature: Browse to Cases, Legislation & Journals Practice Area Pages. Check static text and marketing page
  #this test has been transferred from the research browse project
  As a PL+ user who is also subscribed to WestLaw UK Research Content
  I want to browse to Cases, Legislation and Journals Practice Area Pages from the PLC Home Page

  Background:
    Given PL+ user is logged in
    And user navigates to RB PLC Home Page

  Scenario Outline: RB PLC Home Page ->  <researchLink> Page -> <practiceArea> <researchLink> Page
    And user clicks on <researchLink> Link on RB Resources Tab
    When user clicks on the "<practiceArea>" Practice Area Link
    Then RB <researchLink><practiceArea> Practice Area Page with heading "<heading>" is displayed
    When user does click on Find out more link
    Then marketing page for "<researchLink><practiceArea>" research content is displayed
  Examples:
    | researchLink | practiceArea | heading         |
    | Journals     | Tax          | Journals Tax    |
    | Cases        | Tax          | Cases-Tax       |
    | Legislation  | Tax          | Legislation Tax |

  Scenario Outline: RB PLC Home Page -> <practiceArea> Practice Area Page -> <practiceArea> <researchLink> Page
    And user clicks on "<practiceArea>" Link on RB PLC Home Page
    And user clicks on the Resources Tab
    And user clicks on <researchLink> Link on RB Resources Tab
    Then RB <researchLink><practiceArea> Practice Area Page with heading "<heading>" is displayed
  Examples:
    | researchLink | practiceArea | heading         |
    | Journals     | Tax          | Journals Tax    |
    | Cases        | Tax          | Cases-Tax       |
    | Legislation  | Tax          | Legislation Tax |