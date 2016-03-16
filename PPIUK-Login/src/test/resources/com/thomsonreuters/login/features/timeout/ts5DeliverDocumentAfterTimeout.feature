@manual
Feature: [797999] Deliver document after timeout

  Scenario: [797999] Deliver document after timeout with SRM enabled
    Given a PPI user authenticated through username and password who previously selected the Super remember me cookie option
    And he is viewing a document in PL+
    When he leaves the computer unattended for more than 1 hour
    And he keeps seeing the same document
    And when he does click anywhere
    Then he does not notice anything about the reauthentication process
    And the delivery widget is still present.

  Scenario: [797999] Deliver document after timeout and login back
    Given a PPI user authenticated through username and password without SRM option and with routing option Timeout = 3 minutes
    And have more than one tab opened
    And he is viewing some documents in PL+ in different tabs
    Then he is timed out in all the tabs, some delay is possible (less than a minute)
    And when he signs back in one of the tabs
    Then he is taking back to the document that he was on and is logged in
    And when he refreshes the second tab
    Then he is viewing the same document that was there and is logged in
    And the delivery widget is still present.
