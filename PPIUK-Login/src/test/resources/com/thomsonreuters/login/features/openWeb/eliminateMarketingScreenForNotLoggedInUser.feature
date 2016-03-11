Feature: [757142] As a not logged in user when I visit for the first time PL+ I do not want to see a marketing scree so I avoid unexpected messages

  Scenario: [757142] As a not logged in user when I visit for the first time PL+ I do not want to see a marketing scree so I avoid unexpected messages
    Given PL+ user is not logged in
    When the user navigates to the main PLCUK page
    Then the user should not be presented with the marketing screen lightbox

  Scenario: [757142] As a logged in user when I visit for the first time PL+ I do not want to see a marketing scree so I avoid unexpected messages
    Given PL+ user is logged in
    Then the user should not be presented with the marketing screen lightbox
   