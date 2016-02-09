@e2e
Feature: As a PPI User I want to be able to add a page to Favourites so I can access it whenever I want.
  As a PPI User I want to have a page dedicated to Favourites where I can manage the Favourites that I added.
  As a PPI User I want to be able to see my start page in Favourites so I can I am aware about which is my start page.

  Background:
    Given PL+ user is logged in with following details
      | userName | FFHTestUser |

  Scenario:
    When API cleans all folders and history and user relogs in

  Scenario: Favourites
    When the user opens 'Commercial' link
    And the user adds page to favourites group 'pl1'
    And the user come back on to Home page
    And the user opens 'Family' link
    And the user adds page to favourites group 'group_new'
    And the user come back on to Home page
    And the user opens 'Share Schemes & Incentives' link
    And the user come back on to Home page
    And the user opens 'Resources' link
    And the user opens 'What's Market' link
    And the user adds page to favourites group 'group_new'
    And the user come back on to Home page
    And the user opens 'Tax' link
    And the user opens 'VAT' link
    And the user adds page to favourites group 'group_new'
    When the user clicks on 'Favourites' link on the header
    And the user checks that 'Commercial' link presents in favourites group 'pl1' on Favourites page
    And the user checks that 'Share Schemes & Incentives' link presents in favourites group 'Frequently Used Items' on Favourites page
    And the user checks that 'Family' link presents in favourites group 'group_new' on Favourites page
    And the user checks that 'What's Market' link presents in favourites group 'group_new' on Favourites page
    And the user checks that 'VAT' link presents in favourites group 'group_new' on Favourites page
    And the user clicks 'Commercial' link on Favourites page
    Then page 'Commercial' opens

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
    | parent         | page         |
    | Practice areas | Finance      |
    | Resources      | PLC Magazine |
