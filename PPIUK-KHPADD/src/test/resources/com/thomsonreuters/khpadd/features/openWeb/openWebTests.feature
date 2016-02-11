Feature: [744574] [748210] [748211] [756795] [756801] verify the anonymous login homepage, document display,
  Non-subscribed view, hidden Delivery toolbar on logged out document view and sign on functionality

  Scenario: Verify the anonymous homepage view of PLCUK and also the anonymous document view with disabled delivery toolbar
    Given PL+ user is not logged in
    When the user navigates to the main PLCUK page
    Then the user is navigated to the PL+ homepage anonymous view
    And user navigates directly to document with guid "I0b3ad4e3e01011e398db8b09b4f043e0"
    Then the user is provided with an option to sign-in or register for free trial
    And he does not see in the document page any link related to delivery options (email, download, print)

  Scenario: Verify the sign on link on the anonymous homepage view
    Given PL+ user is not logged in
    When the user navigates to the main PLCUK page
    And the user clicks on Sign On link on the header
    Then user logs in
    And Sign On link is not shown to user
    And the user is navigated to the logged in view of the PL+ homepage
    And when the user logs out

  Scenario: Verify the sign in link on the logged out view of a document
    Given PL+ user is not logged in
    When user navigates directly to document with guid "Idfa7d588e25211e398db8b09b4f043e0"
    Then the user is provided with an option to sign-in or register for free trial
    When the user clicks on the Sign in link on the document
    And user logs in
    Then the user is navigated to the logged in view of the document
    And when the user logs out

  Scenario: Verify the sign on button on the header from logged out view of a document
    Given PL+ user is not logged in
    When user navigates directly to document with guid "I0b3ad4e3e01011e398db8b09b4f043e0"
    Then the user is provided with an option to sign-in or register for free trial
    When the user clicks on Sign On link on the header
    And user logs in
    Then the user is navigated to the logged in view of the document

  Scenario: Verify the non-subscribed view of a document by a logged in user.
    Given PL+ user is logged in with following details
      | userName | plcuknosubs |
    When user navigates directly to document with plcref "3-518-1249"
    Then the user is provided with an option to Upgrade or register for free access

