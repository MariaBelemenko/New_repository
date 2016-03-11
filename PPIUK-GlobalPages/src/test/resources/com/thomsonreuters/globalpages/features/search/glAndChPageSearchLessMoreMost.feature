Feature: [838717][839947] As a PL+ User I can display less, more or most detail for each of my search results

  Scenario Outline: [838717][839947] Verify default setting for more detail in open web
    Given PL+ user is logged in
    And the user navigates to the main PLCUK page
    When the user selects "International" tab and clicks on "<link>" link in "International subscriptions" section
    Then the Category Page opens correctly
    And the user runs a free text search for the query "tax"
    When the user can select the option to show less detail
    Then the user can verify that the less detail icon is displayed
    And the user should verify the presence of following search structure for "less" option
      | Title         |
      | Resource Type |
      | Jurisdiction  |
      | Status        |
    When the user can select the option to show more detail
    Then the user can verify that the more detail icon is displayed
    And the user should verify the presence of following search structure for "more" option
      | Title         |
      | Resource Type |
      | Jurisdiction  |
      | Status        |
      | Absract       |
      | First Snippet |
    When the user can select the option to show most detail
    Then the user can verify that the most detail icon is displayed
    And the user should verify the presence of following search structure for "most" option
      | Title          |
      | Resource Type  |
      | Jurisdiction   |
      | Status         |
      | Absract        |
      | First Snippet  |
      | Second Snippet |
  Examples:
    | link   |
    | Global |
    | China  |
