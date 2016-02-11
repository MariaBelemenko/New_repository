Feature: [730582] Verify resource history on the document
  I want: to view the top 3 resource history entries
  So that: I can see the most recent resource updates

  Scenario: Verify the "View All" link is  visible for resources having more than 3 resource history entries
    Given PL+ user is logged in
    And user navigates directly to document with guid "Ib55520d8e83211e398db8b09b4f043e0"
    When the user clicks on the 'View Resource History' link on the resource page
    Then the user can see 3 latest resource histories displayed
    When user clicks on 'View All' to view all resource histories
    Then the user can now see more than 3 resource history entries
    When user clicks on 'View Latest' to view latest resource histories
    Then the user can see 3 latest resource histories displayed

  Scenario: Verify resources with no resource history
    Given PL+ user is logged in
    When user navigates directly to document with guid "Ifc80d200e02811e398db8b09b4f043e0"
    Then the following message is displayed in the resource history section
      | Changes made to this resource. We will record here any changes to this resource as a result of developments in the law or practice. |

  Scenario: Verify the "View All" is not visible for resources with 3 or less resource history entries
    Given PL+ user is logged in
    When user navigates directly to document with guid "Id4cfb63ef3ad11e28578f7ccc38dcbee"
    Then the user can see 3 latest resource histories displayed
    And the link 'View All' to display more resource entries is not visible
