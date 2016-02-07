@e2e
Feature: Verify links to asset page

  Scenario Outline: Verify link to <Resource Type> Asset Page
    Given PL+ user is logged in with following details
      | userName | Asset_page_one |
    When the user opens document with <GUID> guid
    And the user clicks on this "<Document Link>" link
    Then resource type is displayed as "<Resource Type>" on right hand panel
  Examples:
    | GUID                              | Document Link                                           | Resource Type  |
    | Ib55549aee83211e398db8b09b4f043e0 | Case T-276/04, Compagnie Maritime Belge SA v Commission | Case page      |
    | I973aa955e1c411e398db8b09b4f043e0 | section 110                                             | Primary Source |