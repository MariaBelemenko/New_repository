@manual
Feature: Annotations Common Functionality Manual tests

Scenario:User should be able to see the disabled save button when inline notes text exceeds 3000 chars length & User should be able to see the disabled save button when inline notes text is below 3000 chars length and tags length is > 10000
Given PL+ user is logged in with following details
| userName | librarian1 |
When user navigates directly to WLN document with guid "I3351a6a1e8da11e398db8b09b4f043e0"
And user enters inline notes text with "3001" chars length
Then user verifies Save button is disabled
And user should be able to see the warning message for exceeded text
When select ok button on warning message
And user removes the excess input from the inline notes text
Then user able to save the inline notes
When user enters new inline notes with richText with 3000 chars length and tags length is > 10000
Then user verifies Save button is disabled
And user should be able to see the warning message for exceeded richText
When select ok button on warning message
And user removes the excess input from the inline notes richText
Then user able to save the inline notes

@manual
Scenario:Cut/Copy/Paste is not available in TinyMCE editor
Given PL+ user is logged in with following details
| userName | librarian1 |
When user navigates directly to WLN document with guid "I3351a7b0e8da11e398db8b09b4f043e0"
And the user has accessed Inline Notes text box
Then Cut/Copy/Paste icons are not avaialble on TinyMCE toolbar
When the user has accessed New Annotations text box
Then Cut/Copy/Paste icons are not avaialble on TinyMCE toolbar

@manual
Scenario: Verify show/hide Annotations for inline notes
Given PL+ user is logged in with following details
| userName | librarian1 |
When user navigates directly to WLN document with guid "Ie6a01717518811e498db8b09b4f043e0"
And user added new inline notes
And the user clicks on Show And Hide link
Then verify that different Show and Hide icon displayed
And Hidden inline notes are displayed
When the user clicks on Show And Hide link
Then verify that different Show and Hide icon displayed
And Displayed inline notes are hidden
When user deletes All annotations
And the user verifies the annotations count under link
Then Annotations count should be displayed as zero
