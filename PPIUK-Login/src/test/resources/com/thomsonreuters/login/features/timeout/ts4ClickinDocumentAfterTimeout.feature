@manual
Feature: Click in Document after timeout

  Scenario:
    Given a PPI user authenticated through username and password who previously selected the Super remember me cookie option
    And he is viewing a document in PL+
    When he leaves the computer unattended for more than 1 hour
    Then he is not timed out and the session is automatically re-authenticated in the background
    And he keeps seeing the same document
    And when he does click on a link within a document
    Then he is taken to the desired page

  Scenario:
    Given a PPI user authenticated through username and password who previously opted out  the Super remember me cookie option
    And have more than one tab opened
    And he is viewing a document in PL+
    Then he is timed out
    And when he signs back in
    Then he is taking back to the document that he was on
