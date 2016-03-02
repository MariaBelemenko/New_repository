Feature: As a PL+ User I want to view links to Westlaw UK on the primary source page
  As a PL+ User I want to view links to Westlaw UK that lead to EU Content

  Background:
    Given PL+ user is logged in

  @e2e @prod
  Scenario Outline: The primary source documents contains  links to Westlaw UK
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
    | I35a77ff953d011e498db8b09b4f043e0 |
    | I1cbdc15f53cf11e498db8b09b4f043e0 |
    | I6626330963a911e598dc8b09b4f043e0 |

  Scenario Outline: The primary source documents contains  links to Westlaw UK and they lead to EU Content
    When the user opens document with <GUID> guid
    Then the user click on View Document button
    Then the document opens correctly
    Then the user see link to "Westlaw UK" Westlaw UK
    When the user click on link to "Westlaw UK" Westlaw UK
    Then the user is taken to the login page in Westlaw UK
    Then the user login Westlaw UK
    Then the user taken to EU document in Westlaw UK
    Then the user clicks on Log Out link in Westlaw Uk
    Then the user close the current window
    Then the user go back to previous window
  Examples:
    | GUID                              |
    | I8ca3a4eb65a211e598dc8b09b4f043e0 |
    | I6626330963a911e598dc8b09b4f043e0 |
    | I69061fad63a911e598dc8b09b4f043e0 |
    | I6626343a63a911e598dc8b09b4f043e0 |
