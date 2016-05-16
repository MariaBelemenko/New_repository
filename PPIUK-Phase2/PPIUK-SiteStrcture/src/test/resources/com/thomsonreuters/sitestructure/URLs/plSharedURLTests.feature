Feature: As a user, I want to access Practical Law product via the shared URL domain, so that I can view Practical Law content.

  @ssToggle
  Scenario: User varifies the "Add reply" link next to ask question
    Given PL+ user is logged in
    When user navigates directly to document with plcref "A-021-4562"
    Then the user should see the "Add reply" link next to question