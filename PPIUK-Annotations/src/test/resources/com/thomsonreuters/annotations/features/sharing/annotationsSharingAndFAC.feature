@AnnotationsSmokeTests
Feature: Annotations FAC

  Scenario: Delete All Annotations Present on Document
    When PL+ user is logged in
    Then user navigates directly to document with guid and removes annotations on it
      | I33f1066be8cd11e398db8b09b4f043e0 |
      | Ib5551f6ce83211e398db8b09b4f043e0 |
      | I072d4b0ee84211e398db8b09b4f043e0 |
      | Ib9512a07ad4511e498db8b09b4f043e0 |
      | I63cd7ba5e68b11e398db8b09b4f043e0 |
      | I3351a7b0e8da11e398db8b09b4f043e0 |
      | Ib5551f79e83211e398db8b09b4f043e0 |
      | Icecfe81ee58c11e398db8b09b4f043e0 |
      | I33f12dd3e8cd11e398db8b09b4f043e0 |
      | I33f12c20e8cd11e398db8b09b4f043e0 |
      | Ie6a01717518811e498db8b09b4f043e0 |
      | I1559faa0eef211e28578f7ccc38dcbee |
    And user logs out
    When PL+ user is logged in with following details
      | userName | librarian3 |
    Then user navigates directly to document with guid and removes annotations on it
      | I33f1066be8cd11e398db8b09b4f043e0 |
      | I33f12c20e8cd11e398db8b09b4f043e0 |
      | Ib5551f6ce83211e398db8b09b4f043e0 |
      | I072d4b0ee84211e398db8b09b4f043e0 |
      | Ib9512a07ad4511e498db8b09b4f043e0 |
      | I63cd7ba5e68b11e398db8b09b4f043e0 |
      | I3351a7b0e8da11e398db8b09b4f043e0 |
      | Ib5551f79e83211e398db8b09b4f043e0 |
      | Icecfe81ee58c11e398db8b09b4f043e0 |
      | I33f12dd3e8cd11e398db8b09b4f043e0 |
      | Ie6a01717518811e498db8b09b4f043e0 |
      | I1559faa0eef211e28578f7ccc38dcbee |

  #Annotations Sharing Scenarios

  Scenario: Share annotations options
    When PL+ user is logged in
    And user navigates directly to document with guid "Ib5551f79e83211e398db8b09b4f043e0"
    Then user navigates to annotations textbox with text
    Then verify the share with Contacts and Previous Contacts link is present

  Scenario: Share Contacts and Groups options
    When selecting Contacts link
    Then contacts and Groups popup window will be displayed

  Scenario: Verify the Contact is available
    When search for Contact "librarian3"
    Then "librarian3" is found in the contacts list

  @AnnotationsSmokeTests @e2e
  Scenario:User should be able to share the annotations with reviewer
    When PL+ user is logged in
    When user navigates directly to document with guid "I33f12c20e8cd11e398db8b09b4f043e0"
    Then user navigates to annotations textbox with text
    And user has shared the annotations with another contact "librarian3"
    And user logs out

  @AnnotationsSmokeTests @e2e @bug
  Scenario:(bug #852662)Reviewer should be able to see the shared annotations
    Given PL+ user is logged in with following details
      | userName   | librarian3 |
      | newSession | TRUE       |
    When user navigates directly to document with guid "I33f12c20e8cd11e398db8b09b4f043e0"
    Then shared annotation should be displayed

  @AnnotationsSmokeTests @e2e
  Scenario:User should be able to see the own annotations which are shared with others
    Given PL+ user is logged in with following details
      | newSession | TRUE |
    When user navigates directly to document with guid "I33f12c20e8cd11e398db8b09b4f043e0"
    Then shared annotation should be displayed

  @e2e
  Scenario:User should be able to share the annotations with group
    When PL+ user is logged in
    When user navigates directly to document with guid "Icecfe81ee58c11e398db8b09b4f043e0"
    Then user navigates to annotations textbox with text
    And user has shared the annotations with new group and "librarian3" as member
    And user logs out

  @e2e
  Scenario:As a User from Group should be able to see the shared annotations
    Given PL+ user is logged in with following details
      | userName   | librarian3 |
      | newSession | TRUE       |
    When user navigates directly to document with guid "Icecfe81ee58c11e398db8b09b4f043e0"
    Then shared annotation should be displayed

  Scenario: Sharing the annotations to reviewer with the links
    Given PL+ user is logged in with following details
      | newSession | TRUE |
    When user navigates directly to document with guid "I33f12dd3e8cd11e398db8b09b4f043e0"
    And user navigates to annotations textbox with text
    Then the user has inserted the url string "http://google.co.uk" into textbox
    And user has shared the annotations with another contact "librarian3"
    And user logs out

    @bug
  Scenario:(bug #852662)Reviewer should be able to see the annotations with the links
    Given PL+ user is logged in with following details
      | userName   | librarian3 |
      | newSession | TRUE       |
    When user navigates directly to document with guid "I33f12dd3e8cd11e398db8b09b4f043e0"
    Then annotation text with url is displayed
    When click on shared url link
    Then hyperlinked url will be opened in new tab with title "Google"

  Scenario:User should be able to see the annotations shared icon
    When PL+ user is logged in
    When user navigates directly to document with guid "Ie6a01717518811e498db8b09b4f043e0"
    Then user navigates to annotations textbox with text
    And user has shared the annotations with another contact "librarian3"
    And verify that user sharing icon is displayed before the createdby
    And user logs out

    @bug
  Scenario:(bug #852662)Reviewer should be able to see the annotations shared icon
    Given PL+ user is logged in with following details
      | userName   | librarian3 |
      | newSession | TRUE       |
    When user navigates directly to document with guid "Ie6a01717518811e498db8b09b4f043e0"
    Then shared annotation should be displayed
    And verify that user sharing icon is displayed before the createdby

  #Annotations FAC Scenarios

  Scenario: Librarian should be able to access Contacts/Previously Shared links
    When PL+ user is logged in with following details
      | newSession | TRUE |
    When user navigates directly to document with guid "I33f1066be8cd11e398db8b09b4f043e0"
    Then user navigates to annotations textbox with text
    And verify the share with Contacts and Previous Contacts link is present

  Scenario: As a PL+ read only user should not be able to see Contacts/Previously Shared links
    When PL+ user is logged in with following details
      | userName   | annotationsUser7 |
      | newSession | TRUE             |
    When user navigates directly to document with guid "I33f1066be8cd11e398db8b09b4f043e0"
    Then user navigates to annotations textbox with text
    And verify the share with Contacts and Previous Contacts link is not present

  Scenario: As a PL+ user should be able to see the BLOCK SHARE NOTE LINK FAC in routing
    When user is navigated to routing
    Then verify that "BlockShareNoteLink" dropdown is present routing Feature
    And verify that below options is present in BlockShareNoteLink dropdown
      | Default |
      | Grant   |
      | Deny    |