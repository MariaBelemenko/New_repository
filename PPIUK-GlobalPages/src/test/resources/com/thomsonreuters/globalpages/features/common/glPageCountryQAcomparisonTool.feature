Feature: As a not logged user
  I want to navigate to Global page and see Country Q&A comparison tool

  Scenario: Verify Country Q&A comparison tool
    Given PL+ user is not logged in
    And the user navigates to the main PLCUK page
    When the user selects "International" tab and clicks on "Global" link in "International subscriptions" section
    Then the Category Page opens correctly
    Then the text on widget "Compare the law across countries" is "Use the Q&A tool to check for differences between countries on key points."
    And the user clicks on button "Start comparing" on widget "Compare the law across countries"
    Then the user is taken on the comparison tool page with header "International transaction guides | Country Q&A comparison tool"
