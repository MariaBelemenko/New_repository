Feature: As a PL+ User that requested to turn on Bailii link I want to see Bailii link on the case asset page
  As a PL+ User that requested to turn off Bailii link I do not see Bailii link

  @e2e @prod
  Scenario Outline: The user that requested to turn on Bailii link has the ability to see it
    Given PL+ user is logged in with following details
      | userName | RDD_test_user |
    When the user opens document with <GUID> guid
    Then the user click on View Document button
    Then the document opens correctly
    Then the user see links to "Bailii" Bailii
    When the user click on "Bailii" Bailii link
    Then the user is taken to "http://www.bailii.org" resource
  Examples:
    | GUID                              |
    | Ieda8cc31f27711e498db8b09b4f043e0 |
    | I984f1d486cf011e498db8b09b4f043e0 |
    | I984ef7396cf011e498db8b09b4f043e0 |

  Scenario Outline: The user that requested to turn off Bailii link has not the ability to see it
    Given PL+ user is logged in with following details
      | userName | Rdd_user_two |
    When the user opens document with <GUID> guid
    Then the user click on View Document button
    Then the document opens correctly
    Then the user does not see links to "Bailii" Bailii
  Examples:
    | GUID                              |
    | Ieda8cc31f27711e498db8b09b4f043e0 |
    | I984f1d486cf011e498db8b09b4f043e0 |
    | I984ef7466cf011e498db8b09b4f043e0 |
