Feature: [834285] Feedback form for Advanced Access & Live site

  @wip
  Scenario: Verification of all the fields in the feedback form and the Feedback link on PL+
    Given PL+ user is logged in
    When user navigates directly to document with guid "Ib55549a0e83211e398db8b09b4f043e0"
    And user clicks on the Feedback link on the footer
    Then the user should see the following fields on Feedback form
      | Feedback from | KHPadd User4                                                                    |
      | User name     | KHPaddUser4                                                                     |
      | Email address | KHPaddUser4@mailinator.com                                                      |
      | Page          | Appointment of directors - Practical Law                       |
      | URL           | /Document/Ib55549a0e83211e398db8b09b4f043e0/View/FullText.html |
    When the user updates the following fields on Feedback form
      | General comments             | This is a test please ignore                      |
      | If you encountered a problem | Ignore, This is a test for feedback functionality |
      | General comments             | This is my Test comment                           |
    And the user clicks on Submit button
    Then the feedback is submitted successfully

  Scenario: Verify the close button functionality on the feedback form (Bug#781259 associated with this scenario has been deferred by business)
    Given PL+ user is logged in
    When a user navigate to a "Directors" Topic page from a "Corporate" Practice Area page
    And user clicks on the Feedback link on the footer
    Then the user should see the following fields on Feedback form
      | Feedback from | KHPadd User4                                                                    |
      | User name     | KHPaddUser4                                                                     |
      | Email address | KHPaddUser4@mailinator.com                                                      |
      | Page          | Directors - Practical Law                                                       |
      | URL           | /topic/7-200-0622?sv=3-103-1749&transitionType=Default&contextData=(sc.Default) |
    When the user clicks on the Close icon on the feedback form
    Then the user should be presented with a confirmation box
    And feedback form should close when the user clicks the ok button