Feature: As a PL+ user, I want to view widget so that I can use them appropriately
  @widgetToggle
  Scenario: User varifies the "Add reply" link next to ask question
    Given PL+ user is logged in
    When user navigates directly to document with plcref "A-021-4562"
    Then the user should see the "Add reply" link next to question