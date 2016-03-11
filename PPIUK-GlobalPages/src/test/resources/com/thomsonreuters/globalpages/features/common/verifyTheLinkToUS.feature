@wip
Feature: [838727][838102] As a user I am authenticated into PLUS using a Transfer Token and am not dependent upon a OnePass cookie

  Scenario: [838727] Verify that user has the abitity to login PLSU automatically
    Given PL+ user is logged in
    When the user navigates to the main PLCUK page
    When the user selects "International" tab and clicks on "US" link in "International subscriptions" section
    Then the user is taken to the "signon.qa.thomsonreuters.com/?productid=CBT&viewproductid=PLCUS" web site in the same window and tab
    When the user logged in PLUS in the login screen
      | userName | GlobalPagesUser1 |
    Then the user is taken to the "westlaw.com/Search/Home" with the "Practical Law" title in the same window and tab
    And the "Toggle Profile Settings" settings icon is displayed
    When the user navigates to the main PLCUK page
    When the user selects "International" tab and clicks on "US" link in "International subscriptions" section
    Then the user is taken to the "westlaw.com/Search/Home" with the "Practical Law" title in the same window and tab
