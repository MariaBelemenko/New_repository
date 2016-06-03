Feature: Browse to Cases, Legislation & Journals Topic Pages.
  this test has been transferred from the research browse project
  As a PL user who is also subscribed to WestLaw UK Research Content
  I want to browse to Cases, Legislation & Journals Topic Pages from PLC Home Page

  Background:
    Given PL+ user is logged in
    And user navigates to RB PLC Home Page

  Scenario Outline: Navigate from <researchLink><practiceArea> Page to <researchLink> Topic Page
    When user navigates directly to <researchLink><practiceArea> Page
    And clicks on <topic> topic link
    Then RB <researchLink> <topic> Topic Page is displayed
  Examples:
    | researchLink | practiceArea | topic                       |
    | Journals     | Tax          | Companies and Groups        |
    | Cases        | Tax          | Asset Acquisitions          |
    | Legislation  | Tax          | Disputes and Investigations |

  @bug
  Scenario: Browse from Topic Page to Cases, Legislation & Journals Topic Pages and back to Topic page
    When user clicks on "Tax" Link on RB PLC Home Page
    And clicks on A55et Acqu1s1t10n5 topic link
    Then RB Know-How Topic Page for "Asset Acquisitions" is displayed
    And browse functionality between KH Topic Page and "cases" Topic page works correctly
    And browse functionality between KH Topic Page and "legislation" Topic page works correctly