@e2e @prod
Feature: [730962] As a: website user  I want: to be able to show or hide individual drafting notes for Standard Documents and clauses

  Scenario Outline: Expand and Close Individual Drafting Notes for <documentType>
    Given PL+ user is logged in
    When user navigates directly to document with guid "<guid>"
    Then user is able to expand the first drafting notes
    And see the expanded drafting notes heading is "<heading>"
    And user is able to close the first drafting notes
  Examples:
    | documentType      | guid                              | heading             |
    | Standard Document | Idfa7d588e25211e398db8b09b4f043e0 | About this document |
    | Standard Clauses  | I2a0644671cb811e38578f7ccc38dcbee | General Notes       |

  Scenario: Verify the 'Show All', 'Hide All' and Show Notes only functionality of a standard document
    Given PL+ user is logged in
    When user navigates directly to document with guid "Idfa7d588e25211e398db8b09b4f043e0"
    And clicks on the Show/Hide Drafting Notes option on the delivery toolbar
    Then the following drafting notes options are displayed
    |Show All|
    |Hide All|
    |Show Notes Only|
    When user clicks on the 'Show All' option
    Then the document text along with the drafting notes expanded version is displayed
    When user clicks on the 'Hide All' option
    Then the document text along with drafting notes collapsed version is displayed
    When user clicks on the 'Show Notes Only' option
    Then only the drafting notes expanded version is displayed
