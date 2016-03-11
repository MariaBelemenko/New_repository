@manual
Feature: [752691] Access bookmarked pages

  Scenario: [752691] As a PPI user when I try to access a bookmark page I want to be redirected automatically to that page so I avoid go through the home page.
    Given PL+ user is logged in
    Given user closes browser
    When user starts browser again
    When he clicks on a bookmarked page in a browser
    Then he is redirected to this page

  Scenario: [752691] As a PPI user when I try to access a bookmark page I want to be redirected automatically to that page so I avoid go through the home page.
    Given PL+ user is logged in
    Given user closes browser
    When user starts browser again
    When he clicks on a bookmarked page in a browser
    Then he is redirected to this page
    Then he clicks sign on link
    And he enters his username and password and clicks the sign in button
    Then he is redirected to the bookmarked page
