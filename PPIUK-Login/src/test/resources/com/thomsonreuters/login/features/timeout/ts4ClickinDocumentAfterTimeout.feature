@manual
Feature: [798000] Click in Document after timeout

  Scenario: [798000] Click in Document after timeout
    Given a PPI user authenticated through username and password who previously selected the Super remember me cookie option
    And he is viewing a document in PL+
    When he leaves the computer unattended for more than 1 hour
    Then he is not timed out and the session is automatically re-authenticated in the background
    And he keeps seeing the same document
    And when he does click on a link within a document
    Then he is taken to the desired page
