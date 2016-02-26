@bug
Feature: As a PL+ User I want to view links to view and link to Practice notes

#[REGRESSION]827373-RDDBUG: Document doesn't contain "UK Practice Note" in Related content
  Scenario Outline: The case documents contain Practice Notes
    Given PL+ user is logged in
    When the user opens document with <GUID> guid
    Then the user click on View Document button
    Then the document opens correctly
    Then the user sees "UK Practice Notes" UK Practice Notes section
    And the user sees "<link>" in UK Practice Notes section
    When the user clicks on "<link>" links in Practice Notes section
    Then the user is taken to the internal document
  Examples:
    | GUID                              | link                                                   |
    | I984ef7606cf011e498db8b09b4f043e0 | Contracts: structure and terms of commercial contracts |
    | I984ef7626cf011e498db8b09b4f043e0 | Duty to give reasons                                   |
    | I984f1d556cf011e498db8b09b4f043e0 | The registration gap and the case of Brown and Root    |
