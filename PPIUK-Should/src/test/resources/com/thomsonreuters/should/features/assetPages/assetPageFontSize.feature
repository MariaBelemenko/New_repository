Feature: As a PL+ User I want to view links in correct font size

  Scenario Outline: [821157] The case documents contain Links in correct font size
    Given PL+ user is logged in with following details
      | userName | Rdd_user_one |
    When the user opens document with <GUID> guid
    Then the user click on View Document button
    Then the document opens correctly
    Then the user sees link "<link1>" in the "Legal updates on this case" section
    Then the user sees link "<link2>" in the "Links to this case" section
    And font size of "<link1>" equals font size of "<link2>"
  Examples:
    | GUID                              | link1                                          | link2      |
    | Ia3640900518111e498db8b09b4f043e0 | Mitchell appeal dismissed by Court of Appeal   | Westlaw UK |
    | I984f1d486cf011e498db8b09b4f043e0 | Legal advice privilege (House of Lords)        | Westlaw UK |
    | I984ef7396cf011e498db8b09b4f043e0 | Limitation periods for suing on mortgage debts | Westlaw UK |
