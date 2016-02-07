Feature: As a PL+ User, I am able to browse by Related jurisdictions links in the China category page

  Background:
    Given PL+ user is logged in with following details
      | userName | GlPage_UK1 |
    And the user navigates to the main PLCUK page
    When the user selects "International" tab and clicks on "China" link in "International subscriptions" section
    Then the Category Page opens correctly

  Scenario Outline: verify the related jurisdictions links in the China category page
    When the user clicks on "<link>" in "Related jurisdictions" section
    Then the user verifies that the current PageTitle contains '<link>'
  Examples:
    | link        |
    | Hong Kong   |
    | Australia   |
    | Indonesia   |
    | Japan       |
    | Singapore   |
    | New Zealand |
    | Malaysia    |
