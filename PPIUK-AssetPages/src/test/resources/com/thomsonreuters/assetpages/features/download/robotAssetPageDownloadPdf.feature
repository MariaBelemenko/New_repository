@wip
Feature: [805839] As a PL+ User I want to view links to Westlaw UK and Bailii on downloaded from PL+ pdf document
  [798569] As a PL+ User I want to download pdf document and view Content referring to this case in downloaded document

  Background: 
    Given PL+ user is logged in

  Scenario Outline: [805839] The user download pdf document
    When the user opens document with <GUID> guid
    Then the user click on View Document button
    Then the document opens correctly
    Then the user see links to "Bailii" Bailii
    Then the user see link to "Westlaw UK" Westlaw UK
    Then the user see Download icon in delivery options in right hand side
    When the user click on Download icon
    Then download document in "pdf" extension
    And the downloaded PDF document contain hyperlink to "Bailii" Bailii
    And the downloaded PDF document contain hyperlink to "Westlaw UK" Westlaw UK

    Examples: 
      | GUID                              |
      | I984f1fea6cf011e498db8b09b4f043e0 |
      | I984ef7626cf011e498db8b09b4f043e0 |

  Scenario Outline: [798569] [818357] The user download pdf document and view Content referring to this case in downloaded document
    When the user opens document with <GUID> guid
    Then the user click on View Document button
    Then the document opens correctly
    Then the user see Download icon in delivery options in right hand side
    When the user click on Download icon
    Then download document in "pdf" extension
    And the downloaded document does not contain "Content referring to this case" section

    Examples: 
      | GUID                              |
      | I984ef7606cf011e498db8b09b4f043e0 |
      | I984ef7626cf011e498db8b09b4f043e0 |
      | I984f1d556cf011e498db8b09b4f043e0 |

  Scenario Outline: [819052] The downloaded pdf documents contain hyperlinks that contain specific parameters
    When the user opens document with <GUID> guid
    Then the user click on View Document button
    Then the document opens correctly
    Then the user see Download icon in delivery options in right hand side
    When the user click on Download icon
    Then download document in "pdf" extension
    And the hyperlink "<link>" in downloaded document contain text "&vr=3.0&rs=PLUK1.0"

    Examples: 
      | GUID                              | link                                                             |
      | I984ef7626cf011e498db8b09b4f043e0 | The obligation to act 'promptly' in applying for judicial review |

  Scenario Outline: [818909] The user download document with different styles
    When the user opens document with <GUID> guid
    Then the user click on View Document button
    Then the document opens correctly
    Then the user see Download icon in delivery options in right hand side
    When the user click on Download icon
    Then download document in "pdf" extension
    And the downloaded document contains "<text>" in "blue" color
    Examples: 
      | GUID                              | text    |
      | I984f1d556cf011e498db8b09b4f043e0 | Westlaw |
