Feature: Case page test scenario

  Scenario Outline: Verify the case page attributes from the case page xml
    Given a user openes the Novus XML of the "<CasePageGUID>" document and captures all the important case page fields
    When the user openes the Fatwire XML of the "<PLC document>" document and captures all the important case page fields
    Then the casepage details should be equal
  Examples:
    | PLC document | CasePageGUID                      |
    | D-000-1680   | Ib9aa18e61c9a11e38578f7ccc38dcbee |
    | D-023-8161   | Ia3640900518111e498db8b09b4f043e0 |
    | D-000-4494   | Id3bb875a6cf011e498db8b09b4f043e0 |
    | D-007-9526   | Ia8dec9b1533611e598dc8b09b4f043e0 |

  # 841129:Unlinked content on primary source
  @bug
  Scenario Outline: Verify the primary source page attributes from the case page xml
    Given a user openes the Novus XML of the PS doc "<PrimarySourceGUID>" document and captures all the important case page fields
    When the user openes the Fatwire XML of the PS doc "<PLC document>" document and captures all the important case page fields
    Then the PrimarySource details should be equal
  Examples:
    | PLC document | PrimarySourceGUID                 |
    | 6-508-6670   | I05d79db1640811e598dc8b09b4f043e0 |
    | 1-518-6182   | I2537ea4963f011e598dc8b09b4f043e0 |
    | 0-529-5285   | I81ff7b128bdb11e498db8b09b4f043e0 |
    #There is a asset pages bug on this - 9th Nov 2015
    | 3-503-8567   | Ib07a7b8853cf11e498db8b09b4f043e0 |
