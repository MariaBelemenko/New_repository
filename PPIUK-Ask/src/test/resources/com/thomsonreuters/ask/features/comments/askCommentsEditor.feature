Feature: [752388,752389] Delete/Edit comments by editor
  As an Editor
  I want to edit existing comments
  So that the users don't see inappropiate comment

  Background:
    Given PL+ user is logged in with following details
      | userName | ask.ranjesh |

  Scenario: Edit existing Reply
    And user navigates directly to document with guid "Ie30b7a17ce4611e498db8b09b4f043e0"
    When user clicks on 'Edit' link on last comment
    And user enters some new comments in the reply window
    And user submits the reply
    Then newly edited reply is displayed as comment on the ask resource

  Scenario: Delete an existing Reply
    And user navigates directly to document with guid "Ie30b7a17ce4611e498db8b09b4f043e0"
    When user clicks on 'Delete' link on last comment
    And the comment is deleted on the ask resource
