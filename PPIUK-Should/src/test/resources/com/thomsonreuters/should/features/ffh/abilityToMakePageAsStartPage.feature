@e2e
Feature: [748592] FFH049 As a PPI User I want to be able to see my start page in Favourites so I can I am aware about which is my start page.

  Background:
    Given PL+ user is logged in with following details
      | userName | FFHTestUser |

  Scenario:
    When API cleans all folders and history and user relogs in

  # 847213 [REGRESSION] Topics page as Start page is absent on Favourites page
  @bug
  Scenario Outline: Start Page
    When the user opens '<parent>' link
    And the user opens '<page>' link
    And the user makes page as My Start Page
    When the user clicks on 'Favourites' link on the header
    And the user checks that '<page>' link presents in favourites group 'My Start Page' on Favourites page
    And the user clicks '<page>' link on Favourites page
    Then page '<page>' opens
    When user relogs in
    Then page '<page>' opens
    When the user clicks the Start Page to remove it from Start Page
    And the user clicks on 'Favourites' link on the header
    Then the user checks that '<page>' link is not in favourites group 'My Start Page' on Favourites page
    When user relogs in
    Then page 'Home' opens
  Examples:
    | parent  | page      |
    | IP & IT | Copyright |
