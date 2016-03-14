@e2e @prod 
Feature: Verify links to asset page

  Scenario Outline: Verify link to <Resource Type> Asset Page
    Given PL+ user is logged in
    When the user opens document with <GUID> guid
    When the user clicks on "<link>" link
    Then resource type is displayed as "<Resource Type>" on right hand panel

    Examples: 
      | GUID                              | link                                                 | Resource Type  |
      | Ib55549aee83211e398db8b09b4f043e0 | Case 27/76 United Brands v Commission [1978] ECR 207 | Case page      |
      | I973aa955e1c411e398db8b09b4f043e0 | section 110                                          | Primary Source |
