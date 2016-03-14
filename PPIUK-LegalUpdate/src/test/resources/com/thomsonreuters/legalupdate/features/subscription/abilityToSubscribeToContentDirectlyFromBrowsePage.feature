@wip
Feature: [704489] Subscribe to content directly from a browse page,
  so that I can subscribe without leaving the page I am viewing

  Background:
    Given PL+ user is logged in
    Given a user is on a browse page
    When the user enters their subscription preferences menu

  Scenario: [704490] Enter a custom name for my subscription, so that I can easily recognise my subscription
    Then the user should be presented with the default subscription name
    And should have the ability to type over the default name to enter a custom name "My New Subcription"

  Scenario: [704492] Select email delivery method for my subscription, so that I can receive the without having to visit the website.
    Then the user should be presented with an option to select 'Email' delivery of content
    Then the user should be presented with an option to select 'MyUpdates' delivery of content

  Scenario: [704494; 714939] Select the frequency of my email alerts
    When the user selects the email delivery method
    Then the user should have the ability to select the frequency that they would like to receive their email alerts
      | Daily       |
      | Weekly      |
      | Fortnightly |
      | Monthly     |

  Scenario: Enter an optional message to include in my email
    When the user selects the email delivery method
    Then the user should have the ability to enter an optional text message "My New Subcription test message" to be included in their email

  Scenario: Enter the email address that I wish to receive my email alerts
    When the user selects the email delivery method
    Then the user should have the ability to enter the email address "mytestemail@testmail.com" that they wish their email alerts to be sent to

  Scenario: Opt to receive an email notifying me that their are no new legal updates
    When the user selects the email delivery method
    Then the user should have the ability to receive an email that notifies the user of no new legal updates

  Scenario: Save my subscription preferences that I have configured on the subscription preferences menu
    Then the user should be presented with an option to save their subscription preferences

  Scenario: Cancel the my actions within the subscription menu so that I can close the menu and continue browsing content
    Then the user should be presented with an option to cancel their subscription preferences
    And the subscription preferences menu should close

#test is wip due to story 729617 As a user, I do not want to see the button for a subscription pop-up on the legal update widget
