Feature: [852617] Hide jurisdiction in the search metadata for email archive
  Scenario: bug 852617 Hide jurisdiction in the search metadata for email archive
    Given PL+ user is logged in
    When has selected the link to the practice area "Corporate"
    And has selected the link to Resources
    And the user opens 'Email archive' link
    Then the user is able to verify that jurisdiction information is not displayed
