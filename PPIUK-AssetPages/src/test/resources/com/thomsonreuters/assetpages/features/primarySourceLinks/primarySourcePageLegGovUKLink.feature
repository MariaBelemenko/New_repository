Feature: [790581] As a PL+ User that requested to turn on Legislation.gov.uk link I want to see Legislation.gov.uk link on the primary source page
  As a PL+ User that requested to turn off Legislation.gov.uk link I do not see Legislation.gov.uk link on the primary source page

  @e2e @prod
  Scenario Outline: [790581] The user that requested to turn on Legislation link has the ability to see it
    Given PL+ user is logged in with following details
      | userName | RDD_test_user |
    When the user opens document with <GUID> guid
    Then the document opens correctly
    Then the user see links to "Legislation.gov.uk" Legislation
    When the user click on "Legislation.gov.uk" Legislation link
    Then the user is taken to "legislation.gov.uk" resource
  Examples:
    | GUID                              |
    | I8127783d52a011e598dc8b09b4f043e0 |

  Scenario Outline: [790581] The user that requested to turn off Legislation link has not the ability to see it
    Given PL+ user is logged in with following details
      | userName         | Rdd_user_two |
      | mandatoryRouting | YES          |
    When the user opens document with <GUID> guid
    Then the document opens correctly
    Then the user does not see links to "Legislation.gov.uk" Legislation
  Examples:
    | GUID                              |
    | I023b605f53d211e498db8b09b4f043e0 |
