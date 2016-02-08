@ip
Feature: [752703]  LI012 - IP user does not see start page or favourite icons

  Scenario: [752703] As an IP user I do not want to see the favourites or start page icons so I do not get confused when I am not able to use them.
    Given PL+ user is logged in with following details
      | loginRequired | NO |
    When he navigates to a page "/Browse/Home/Practice/MediaTelecoms" eligible to be selected as Start Page
    Then he does not see any Start Page icon/link
    And he is not able to select the page as start page