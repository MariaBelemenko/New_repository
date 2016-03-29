Feature: [752383,752385,752386] View comment, report this post, reply/add comment to a ask resource

  Background:
    Given PL+ user is logged in

  Scenario: View comment - Display name, service, posted date, report this post and reply
    When user navigates directly to document with guid "Ie30b7a17ce4611e498db8b09b4f043e0"
    Then answer and comment are displayed with correct details

  # (Should) 857960:[REGRESSION] Ask: jump-link from "Report this post" message does not work properly
  @bug
  Scenario: Report this post
    When user navigates directly to document with guid "Ie30b7a17ce4611e498db8b09b4f043e0"
    And get mailto and subject from 'Report this Post' link
    Then verify that mailto and subject fields are not empty
    And verify that the view scrolled to reply text area

  Scenario: Add Reply - Validations
    And user navigates directly to document with guid "Ie30b7a17ce4611e498db8b09b4f043e0"
    When user submits reply without agreeing to Ask PLC scope and rules
    Then error message is displayed for user to agree to Ask PLC scope and rules

  @e2e
  Scenario: Add Reply - Success Flow  with users name and organisation
    And user navigates directly to document with guid "Ie30b7a17ce4611e498db8b09b4f043e0"
    When user clicks on 'Add Reply' link on last comment
    And user enters some test comment in the reply window
    And user selects to display the name and organisation
    And user agrees to Ask PLC scope and rules
    And user submits the reply
    Then newly added reply is displayed as comment on the ask resource
    And users name, organisation and posted date are displayed along with the comment

  Scenario: Add Reply - Success Flow  with Anonymous Reply
    And user navigates directly to document with guid "Ie30b7a17ce4611e498db8b09b4f043e0"
    When user clicks on 'Add Reply' link on last comment
    And user enters some test comment in the reply window
    And user agrees to Ask PLC scope and rules
    And user submits the reply
    Then newly added reply is displayed as comment on the ask resource
    And anonymous is displayed along with the comment
