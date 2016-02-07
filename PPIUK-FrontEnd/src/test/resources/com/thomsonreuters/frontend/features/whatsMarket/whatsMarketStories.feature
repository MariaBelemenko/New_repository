Feature: As a user,
  I want to see the What's Market page as in Design Document

  Scenario: User verifies Whats Market Search Structure
    Given PL+ user is logged in
    And the user navigates to "What's Market" resource Page
    When the user searches for term "contract"
    Then user should see the following metadata in the deal "Poundland Group plc placing"
      | Resource Title    | Value                          |
      | Announcement Date | 24 Sep 2015                    |
      | Deal Type         | Secondary issues               |
      | Deal Value        | 49.11 million                  |
      | Deal Summary      | Placing of new ordinary shares |

  @manual
  Scenario: User verifies the "Number of Results per page label on What's Market
    Given user is logged in
    And user navigates to the What's Market page "Public M&A" thorough Resources
    When user searches for any term like "Tax"
    Then the user should see "Number of Results(1-20)" accoding to the design document

  @manual
  Scenario: User verifies the Less/More/Most styling on the What's Market search page
    Given user is logged in
    And user navigates to the What's Market page "Public M&A" thorough Resources
    When user searches for any term like "Tax"
    And user sees the seach results
    And user clicks on the Less/More/Most dropdown
    Then user should see the Less/More/Most dropdown according to the design document
