Feature: Product View Awareness functionality, PL+ annotations should be not accessible to WLN for the documents and its vice versa.

  Scenario: Create Annotations on PL+ document
    Given PL+ user is logged in with following details
      | userName   | librarian1 |
      | newSession | TRUE       |
    When user navigates directly to document with guid "I33f12c20e8cd11e398db8b09b4f043e0"
    And user added new annotation
    Then verify saved annotations text will be displayed with metadata

  Scenario: Verify PL+ Annotations are not accessible in WLN
    Given WLN user is logged in with following details
      | userName         | librarian1      |
      | product          | WLN             |
      | routing          | WLN_ANNOTATIONS |
      | mandatoryRouting | YES             |
      | newSession       | TRUE            |
    And user navigates directly to WLN document with guid "I33f12c20e8cd11e398db8b09b4f043e0"
    Then user should not be able to see the annotations created in WLN site

  Scenario: Create Annotations on WLN document
    Given WLN user is logged in with following details
      | userName         | librarian1      |
      | product          | WLN             |
      | routing          | WLN_ANNOTATIONS |
      | mandatoryRouting | YES             |
      | newSession       | TRUE            |
    And user navigates directly to WLN document with guid "Ic9d547982b9f11e598dc8b09b4f043e0"
    And user added WLN new annotation
    Then verify saved annotations text will be displayed with metadata in WLN

  Scenario: Verify WLN Annotations are not accessible in PL+
    Given PL+ user is logged in with following details
      | userName   | librarian1 |
      | newSession | TRUE       |
    When user navigates directly to document with guid "Ic9d547982b9f11e598dc8b09b4f043e0"
    Then user should not be able to see the annotations created in WLN site

  Scenario: Creating annotations in PLC site
    Given PL+ user is logged in with following details
      | userName   | librarian1 |
      | newSession | TRUE       |
    When user navigates directly to document with guid "I33f12c20e8cd11e398db8b09b4f043e0"
    And the user has accessed annotations text box
    And highlight the text with cursor
    And user has shared the annotations with another contact "librarian3"
    And user logs out

  Scenario: Verifying the shared annotations in PLC site will not be visible in WLN site
    Given WLN user is logged in with following details
      | userName         | librarian3      |
      | product          | WLN             |
      | routing          | WLN_ANNOTATIONS |
      | mandatoryRouting | YES             |
      | newSession       | TRUE            |
    And user navigates directly to WLN document with guid "I33f12c20e8cd11e398db8b09b4f043e0"
    Then user should not be able to see the annotations created in PLC site

  Scenario: User shared annotation in PL+ group to verify that shared annotations are visible in WLN by login as a user from group
    Given PL+ user is logged in with following details
      | userName   | librarian1 |
      | newSession | TRUE       |
    When user navigates directly to document with guid "I63cd7ba5e68b11e398db8b09b4f043e0"
    Then user navigates to annotations textbox with text
    And user has shared the annotations with new group and "librarian3" as member
    And user logs out

  Scenario: User shared annotation in PL+ group and verifying in WLN to make sure those group memebers are not able to see the annotations which are created and shared in PL+
    Given WLN user is logged in with following details
      | userName         | librarian3      |
      | product          | WLN             |
      | routing          | WLN_ANNOTATIONS |
      | mandatoryRouting | YES             |
      | newSession       | TRUE            |
    And user navigates directly to WLN document with guid "I63cd7ba5e68b11e398db8b09b4f043e0"
    Then user should not be able to see the annotations created in WLN site

  Scenario: User shared annotation in WLN group to verify that shared annotations are visible in PL+ by login as a user from group
    Given WLN user is logged in with following details
      | userName         | librarian1      |
      | product          | WLN             |
      | routing          | WLN_ANNOTATIONS |
      | mandatoryRouting | YES             |
      | newSession       | TRUE            |
    When user navigates directly to WLN document with guid "Ic9d547982b9f11e598dc8b09b4f043e0"
    Then user navigates to WLN annotations textbox with text
    And user has shared the annotations with new group and "librarian3" as member

  Scenario: User shared annotation in WLN group and verifying in PL+ to make sure those group members are not able to see the annotations which are created and shared in WLN
    Given PL+ user is logged in with following details
      | userName   | librarian3 |
      | newSession | TRUE       |
    When user navigates directly to document with guid "Ic9d547982b9f11e598dc8b09b4f043e0"
    Then user should not be able to see the annotations created in WLN site
