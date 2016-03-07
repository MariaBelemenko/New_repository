Feature: [685266] As a user, I want to be able to access a specific Case tracker (Parent), so that I can view content embedded content within that tracker.

  Scenario: (Bug#786438) Verify a typical EU case tracker parent page showing embedded resources
    Given PL+ user is logged in
    And user navigates directly to document with guid "I33f1f225e8cd11e398db8b09b4f043e0"
    Then user "can" see the embedded resources within this document
    And user is able to see the "Hide individual cases" link on the document
    When the user clicks on the embedded resources link "Retail policy at the Outdoors Show"
    And user can navigate to top from anywhere in the document by clicking on the back to top link

  Scenario: Verify the linking of child case tracker from the parent case tracker resource
    Given PL+ user is logged in
    And user navigates directly to document with guid "I33f1f225e8cd11e398db8b09b4f043e0"
    When user clicks on "Hide individual cases" link on this case tracker page
    Then user "cannot" see the embedded resources within this document
    And user is able to see the "Show individual cases" link on the document
    When the user clicks on the embedded resources link "Retail policy at the Outdoors Show"
    Then the user is navigated to the child case tracker page with title "Retail policy at the Outdoors Show"