@wip
Feature: [706089] The ability save my subscription preferences and receive a notification that my subscription has been successful

  Scenario: Save my subscription preferences and receive a notification that my subscription has been successful
    Given PL+ user is logged in
    Given a user is on a subscription panel
    When the user actions to save their subscription preferences
    Then the user should be presented a notification that their subscription has been successful

    #test is wip due to story 729617 As a user, I do not want to see the button for a subscription pop-up on the legal update widget
