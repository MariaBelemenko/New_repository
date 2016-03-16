@manual
Feature: [752691] Access bookmarked pages

  Scenario: [752691] Access a bookmark page as a logged in user
    Given PL+ user is logged in
    Given user closes browser
    When user starts browser again
    When he clicks on a bookmarked page in a browser
    Then he is redirected to this page and is logged in

  Scenario: [752691] Access bookmark page as open web user
    Given PL+ user is not logged in
    Given user closes browser
    When user starts browser again
    When he clicks on a bookmarked page in a browser
    Then he is redirected to this page and is not logged in
    Then he clicks sign on link
    And he enters his username and password and clicks the sign in button
    Then he is redirected to the bookmarked page and is logged in 
