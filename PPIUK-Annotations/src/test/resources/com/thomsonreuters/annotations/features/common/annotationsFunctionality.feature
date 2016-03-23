Feature: Annotations functionality

  Scenario: Verify Annotations links on Document delivery tool bar
    When PL+ user is logged in
    When user navigates directly to document with guid "I33f1066be8cd11e398db8b09b4f043e0"
    Then the user is able to see new annotations link is present
    And verify new annotations link is clickable

#  Scenario: Verify Annotations title on mouse over
#    When the user moves the mouse over on add annotations link
#    Then New annotation tooltip should be displayed
#
#  @AnnotationsSmokeTests @e2e
#  Scenario: Verify Annotations feature
#    When PL+ user is logged in
#    When user navigates directly to document with guid "I33f1066be8cd11e398db8b09b4f043e0"
#    When user click on new Annotations link
#    Then annotations textbox will be displayed with tinymce editor
#    When the user can insert the text and save it
#    Then verify saved annotations text will be displayed with metadata
#
#  @e2e
#  Scenario: Modify Annotations
#    When user clicks the saved annotation
#    Then annotations text box will be displayed with existing text
#    When user modifies the text
#    And saving the annotation
#    Then modified annotations text will be displayed with metadata
#
#  @e2e
#  Scenario: Delete Annotations
#    When PL+ user is logged in
#    When user navigates directly to document with guid "I33f1066be8cd11e398db8b09b4f043e0"
#    And user added new annotation
#    When user clicks the saved annotation
#    Then annotations text box will be displayed with delete icon
#    When user deletes the annotations
#    Then "Note has been deleted" text will be displayed with undo and close links
#    And user unable to find the deleted annotations
#
#  Scenario: Undo Deleted Annotations
#    When user clicks the undo link
#    And user able to see the deleted annotations are displayed
#
#  Scenario: Close link on Delete Annotations
#    When user clicks the saved annotation
#    Then user deletes the annotations
#    When user clicks the close link
#    Then annotations close and undo links will be disappeared
#
#  Scenario: 803697 Verify ClientId is not displayed as part of Annotations metadata
#    When PL+ user is logged in
#    When user navigates directly to document with guid "Ib5551f79e83211e398db8b09b4f043e0"
#    And user added new annotation
#    Then verify saved annotations text will be displayed with metadata
#    And the Client ID next to the timestamp will not be displayed
#
#  Scenario:User should be able to see notes added icon in history
#    Given PL+ user is logged in with following details
#      | newSession | TRUE             |
#    When user navigates directly to document with guid "Ib5551f79e83211e398db8b09b4f043e0"
#    Then adds current document to "root" folder
#    When the user clicks on 'History' link on the header
#    And the user clicks on 'Documents' tab on the History page
#    Then the "1" document will be displayed along with nodes added link
#
#  Scenario:User should be able to see notes added icon in folders
#    When the user clicks on 'Folders' link on the header
#    Then the "1" document will be displayed along with nodes added link
#
#  Scenario:User should be able to see notes added icon in search results list
#    When PL+ user is logged in
#    When the user runs a free text search for the query "Children"
#    And the user opens '1' link in the search result and store its title and guid
#    Then user added new annotation
#    When the user runs a free text search for the query "Children"
#    Then the search result "1" document will be displayed along with nodes added link
#
#  Scenario:User should be able to see the disabled save button when annotation text exceeds 3000 chars length
#    When PL+ user is logged in
#    When user navigates directly to document with guid "I1559faa0eef211e28578f7ccc38dcbee"
#    And user enters annotation text with "3001" chars length
#    Then user should be able to see the warning message for exceeded text
#
#  Scenario:User should be able to save annotation text equals 3000 chars length
#    When select ok button on warning message
#    And user removes the excess input from the annotations text
#    Then saving the annotation
#
#  Scenario:User should be able to see the disabled save button when annotation text is below 3000 chars length and tags length is > 10000
#    When PL+ user is logged in
#    When user navigates directly to document with guid "I1559faa0eef211e28578f7ccc38dcbee"
#    And user enters annotation with richText
#    Then user should be able to see the warning message for exceeded richText
#
#  Scenario:User should be able to save annotation richtext equals 10000 chars length
#    When select ok button on warning message
#    And user removes the excess input from the annotations richText
#    Then saving the annotation
#
#  Scenario:User should be able to see the disabled save button when annotation textbox is empty
#    When PL+ user is logged in
#    When user navigates directly to document with guid "I1559faa0eef211e28578f7ccc38dcbee"
#    And user enters annotation text with "empty" chars length
#    Then user verifies Save button is disabled
#    When user enters annotation text with "100" chars length
#    Then user verifies Save button is enabled
#    And clearing existing styles and annotation text
#    Then user verifies Save button is disabled
#
#  @e2e
#  Scenario: Verify show/hide Annotations links on Document delivery tool bar
#    When PL+ user is logged in
#    When user navigates directly to document with guid "Ie6a01717518811e498db8b09b4f043e0"
#    And user added new annotation
#    Then the user is able to see show/hide annotations link is present
#    And verify show/hide annotations link is clickable
#    And user selects show/hide to hide annotations
#
#  @e2e
#  Scenario: Verify Annotations Show / Hide link Hover
#    When the user hovers the Show And Hide link
#    Then verify show and hide tooltip appears
#
#  @e2e
#  Scenario: Verify Annotations Show / Hide link different icon appears and annotations will be displayed when clicking link on delivery bar
#    When the user clicks on Show And Hide link
#    And Hidden annotations are displayed
#
#  @e2e
#  Scenario: Verify Annotations Show / Hide link icon appears back and annotations will be hidden when clicking link on delivery bar
#    When the user clicks on Show And Hide link
#    Then Displayed annotations are hidden
#
#  @e2e
#  Scenario: Verify annotations count under Annotations Show / Hide link icon
#    When the user clicks on Show And Hide link
#    And the user verifies the annotations count under link
#    Then Annotations count should match with annotations present on document.
#
#  @e2e
#  Scenario: Verify annotations count should get increased when adding more annotations
#    When user added new annotation
#    And the user verifies the annotations count under link
#    Then Annotations count should match with annotations present on document.
#
#  Scenario: Delete All Annotations Present on Document
#    When PL+ user is logged in
#    Then user navigates directly to document with guid and removes annotations on it
#      | I33f1066be8cd11e398db8b09b4f043e0 |
#      | Ib5551f79e83211e398db8b09b4f043e0 |
#      | Ie6a01717518811e498db8b09b4f043e0 |
#      | I1559faa0eef211e28578f7ccc38dcbee |
#    And user logs out
#
