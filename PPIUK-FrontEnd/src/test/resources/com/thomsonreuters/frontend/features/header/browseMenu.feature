Feature: As a PL+ user, I want the "Browse Menu" popup to be displayed as similar to the one in design document

  Scenario: User checks the "Browse Menu" appearance
    Given PL+ user is logged in
    And user clicks on "Browse Menu" dropdown
    Then user should see the "Browse Menu" button arrow and hover behavior according to design document
    Then  user should see the "Browse Menu" popup with Practice Area and Resources sub-menu
    And  user clicks on following sub-menu and see the respective links according to the design
      | Practice areas |
      | Resources      |
      | International  |
