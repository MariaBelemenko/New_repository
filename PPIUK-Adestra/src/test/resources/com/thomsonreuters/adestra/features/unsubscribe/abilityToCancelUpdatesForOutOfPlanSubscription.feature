Feature: Have out of plan checkboxes uncheckable ONLY so a user can unsubscribe

  @UsubscribeUserFromAllSubscriptionsAndRemoveUnsubscribeOption
  Scenario: As a user i want to have ability to unsubcribe from update for out of plan subscription.
    Given a user "adestra_user44@mailinator.com" has subscription for corporate daily "EMCORPD" out of plan email service
    And PL+ user is logged in with following details
      | userName         | adestra_user44 |
    When the user navigates to the email preference page
    And the user has opened the UK Services tab
    Then the user should be presented with their Corporate email service row
    And the user should be presented with a 'Request a trial' link on the row
    And the daily check box should be ticked
    When the user unchecks the Daily check box
    Then the daily check box becomes uncheckable
