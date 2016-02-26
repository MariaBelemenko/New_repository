@e2e @prod
Feature: As a PL+ User I want to view links to Westlaw UK on the case asset page

  Scenario Outline: The case assert documents contains  links to Westlaw UK
    Given PL+ user is logged in
    When the user opens document with <GUID> guid
    Then the user click on View Document button
    Then the document opens correctly
    Then the user see link to "Westlaw UK" Westlaw UK
    When the user click on link to "Westlaw UK" Westlaw UK
    Then the user is taken to the login page in Westlaw UK
    Then the user login Westlaw UK
    Then the user close the current window
    Then the user go back to previous window
    When the user click on link to "Westlaw UK" Westlaw UK
    Then the user see opened document in Westlaw UK
  Examples:
    | GUID                              |
    | I984ef7466cf011e498db8b09b4f043e0 |
    | I984f1d486cf011e498db8b09b4f043e0 |
    | I984ef7396cf011e498db8b09b4f043e0 |
    | I984ef7626cf011e498db8b09b4f043e0 |

