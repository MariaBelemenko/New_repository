Feature: Browse to Cases, Legislation & Journals Pages. Check static text and marketing page
  this test has been transferred from the research browse project
  As a PL user who is also subscribed to WestLaw UK Research Content
  I want to browse to Cases, Legislation and Journals Pages from the PLC Home Page

  Scenario Outline: Navigate to <researchLink> Page from PLC Home page and check static text and marketing page
    Given PL+ user is logged in
    And user navigates to RB PLC Home Page
    And user clicks on <researchLink> Link on RB Resources Tab
    And RB <researchLink> Page is displayed with static text & link to marketing page
    When user does click on Find out more link
    Then marketing page for "<researchLink>" research content is displayed
  Examples:
    | researchLink |
    | Journals     |
    | Cases        |
    | Legislation  |
