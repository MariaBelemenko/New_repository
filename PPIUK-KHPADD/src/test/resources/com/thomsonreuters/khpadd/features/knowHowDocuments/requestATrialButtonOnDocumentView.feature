Feature: [848107] Ability to use request a free trial button on document view


  Scenario: [848107] As a user i want to use register or request a trial button on document view
    Given PL+ user is logged in with following details
      | userName | LimitedSubscriptionsUser |
    When user navigates directly to document with guid "Id249068d1c9611e38578f7ccc38dcbee"
    And "Request a free trial" button is present in document body
	When the user clicks on button with title "Request a free trial"
	Then the source document with guid "Id249068d1c9611e38578f7ccc38dcbee" remains open and new tab opens
    And the user is taken to "http://legalsolutions.thomsonreuters.co.uk/en/contact-us-overlay.html" resource