Feature: Case document includes date in correct format, metadata, link for downloading pdf and footnotes

  Background: 
    Given PL+ user is logged in

  Scenario Outline: [742457] Document has correct date
    When the user opens document with <GUID> guid
    Then the user click on View Document button
    Then the document opens correctly
    And the document contains date in "dd MMMM yyyy" format

    Examples: 
      | GUID                              |
      | I79273E60A8EF11E0888FEF03F0EFCF17 |
      | I65D353E0B03111E1A9C0890F1F61FF5D |
      | IE8146150B21311E49FBB8F994A94F811 |
      | IA77ABBF0A43711E0BAE6C7A444C8F8F8 |

  Scenario Outline: [742452] case document contains link for downloading pdf
    When the user opens document with <GUID> guid
    Then the user click on View Document button
    Then the document opens correctly
    Then the pdf image is displayed
    And the table of contents is displayed
    And the metadata is displayed in the right hand side of the central column
    And delivery options are displayed
    And the document contains the link for downloading
    Then the user downloads the "<document>" with "<name>"

    Examples: 
      | GUID                              | document                               | name               |
      | IA77ABBF0A43711E0BAE6C7A444C8F8F8 | Original Image of 2011 WL 933912 (PDF) | 2011_WL_933912.pdf |
      | IE8146150B21311E49FBB8F994A94F811 | Original Image of 2015 WL 376157 (PDF) | 2015_WL_376157.pdf |

  Scenario Outline: [742452] case document contains footnotes
    When the user opens document with <GUID> guid
    Then the user click on View Document button
    Then the document opens correctly
    And the "Footnotes" section contains footnotes body with numbers

    Examples: 
      | GUID                              |
      | IB774C9C0877511DC885DEC23ABB54428 |
      | I00004260E42911DA8FC2A0F0355337E9 |
      | I00006971E42911DA8FC2A0F0355337E9 |


  Scenario Outline: [742463] The case documents contain judgement navigation menu is disabled
    When the user opens document with <GUID> guid
    Then the user click on View Document button
    Then the document opens correctly
    Then the "Judgment" navigation menu is disabled

    Examples: 
      | GUID                              |
      | I79273E60A8EF11E0888FEF03F0EFCF17 |
      | I65D353E0B03111E1A9C0890F1F61FF5D |
      | IE8146150B21311E49FBB8F994A94F811 |
      | IA77ABBF0A43711E0BAE6C7A444C8F8F8 |