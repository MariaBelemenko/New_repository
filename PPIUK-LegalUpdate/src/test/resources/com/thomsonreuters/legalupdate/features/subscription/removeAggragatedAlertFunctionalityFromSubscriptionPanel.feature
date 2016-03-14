@wip
Feature: [718136] Remove aggregated alert functionality from Subscription panel

  Scenario: Remove aggregated alert functionality from Subscription panel
    Given PL+ user is logged in
    Given a user is on a subscription panel
    Then the user should not be presented with the 'Add to existing Update' Checkbox
    And the user should not be presented with the 'Select update' Select box
    
    #test is wip due to story 729617 As a user, I do not want to see the button for a subscription pop-up on the legal update widget