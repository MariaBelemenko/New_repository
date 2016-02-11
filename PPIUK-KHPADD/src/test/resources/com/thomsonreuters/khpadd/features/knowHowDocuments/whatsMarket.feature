Feature: [770676][745800] What's Market resource type configuration and also removal of Last viewed on

  Background:
    Given PL+ user is logged in

  Scenario: Verify What's Market resource configuration and also verify the removal of "Last Viewed on" tag
    When user navigates directly to document with guid "Ia242c3cdf4cb11e498db8b09b4f043e0"
    Then document title is displayed as "Creightons plc disposal of The Real Shaving Company business"
    When the user navigates to the main PLCUK page
    And user navigates directly to document with guid "Ia242c3cdf4cb11e498db8b09b4f043e0"
    Then the user should not see the "Last viewed" tag on the What's Market document

  Scenario: (bug 833268)Verify What's Market resource Email delivery
    When user navigates directly to document with guid "Ia242c3cdf4cb11e498db8b09b4f043e0"
    Then document title is displayed as "Creightons plc disposal of The Real Shaving Company business"
    When clicks on email delivery option for the document
    Then the user should be able to see Email basic tab options as follows
      | Subject    | Practical Law - Creightons plc disposal of The Real Shaving Company business |
      | Email Note | optional notes                                                               |
    And the following options will not be displayed
      | Table of Contents |
      | Annotations       |
    Then the user edits the basic email options as follows
      | To         | deliveryTests@mailinator.com           |
      | Subject    | Practical Law - What's Market Resource |
      | Email Note | Resource for your Information          |
      | Format     | PDF                                    |
    Then the user clicks on Email advanced tab
    Then the user should be able to see Email advanced tab options as follows
      | Expanded Margin for Notes | Not Selected |
      | Cover Page                | Not Selected |
      | Links                     | Blue         |
      | Font Size                 | Normal       |
    And an email is sent successfully by clicking on the Email button

  Scenario: Verify What's Market resource Email delivery by resource link only
    When user navigates directly to document with guid "Ia242c3cdf4cb11e498db8b09b4f043e0"
    Then document title is displayed as "Creightons plc disposal of The Real Shaving Company business"
    And clicks on email delivery option for the document
    And the user selects "Resource Link Only" as email format
    Then the "Advanced" tab is not displayed
    And an email is sent successfully by clicking on the Email button

  Scenario: Verify What's Market resource Print delivery functionality
    When user navigates directly to document with guid "Ia242c3cdf4cb11e498db8b09b4f043e0"
    Then document title is displayed as "Creightons plc disposal of The Real Shaving Company business"
    And clicks on Print delivery option for the document
    Then the "Basic" tab is not displayed
    And the user clicks on Print advanced tab
    And the user should be able to see Print advanced tab options as follows
      | Expanded Margin for Notes | Not Selected |
      | Cover Page                | Not Selected |
      | Links                     | Blue         |
      | Font Size                 | Normal       |

  Scenario: Verify What's Market resource download delivery functionality
    When user navigates directly to document with guid "Ia242c3cdf4cb11e498db8b09b4f043e0"
    Then document title is displayed as "Creightons plc disposal of The Real Shaving Company business"
    And clicks on Download delivery option for the document
    And the user edits the basic download options as follows
      | Format | Microsoft Word |
    And the user clicks on Download advanced tab
    When the user edits the advanced download options as follows
      | Cover Page | Not Selected |
      | Links      | Black        |
      | Underline  | Selected     |
      | Font Size  | Large        |
