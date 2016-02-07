Feature: When clicking on a link from a location to the product to another TR product, expect the page to open in a different browser tab

  Scenario Outline: For the sample docs verify Linking to another TR product
    Given the "<PLC document>" of type "<PLC document TYPE>" exists on Novus platform
    When user captures all the WestLaw Links in the Novus xml for "<GUID>"
    Then for "<GUID>" the total number of WestLaw links should be the equal
  Examples:
    | PLC document TYPE | PLC document | GUID                              |
    | Ask document      | 0-532-0845   | I44a0417e53ac11e498db8b09b4f043e0 |
    | Legal Update      | 1-586-8405   | I0da888ec64ee11e498db8b09b4f043e0 |
    | Ask document      | 2-531-8926   | I749fe5224b2b11e498db8b09b4f043e0 |
