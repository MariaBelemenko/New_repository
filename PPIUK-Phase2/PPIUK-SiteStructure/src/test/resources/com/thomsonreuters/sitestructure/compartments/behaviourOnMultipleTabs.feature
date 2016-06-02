Feature: [895907] As a user, I want to open WLUK, PL and Commentary products in multiple tabs, so that I can view features/content in the product that I subscribe to.


  Scenario Outline: User verify compartments behaviour on multiple tabs
    Given PL+ user is logged in with following details
      | userName         | <Subscriber>    |
    When user opens <FirstProduct> in the browser
    Then user should see <FirstProduct> homepage
    Then user opens <SecondProduct> in new tab
    And  user opens <ThirdProduct> in new tab
    And  user navigates between the tabs in a quick succession
    And  user clicks on the "Folders" link in the <FirstProduct>
    Then user should see the "Folders" page opens in the <FirstProduct>
    And  user should not see the "Folders" page opens in the <SecondProduct>
    And  user should not see the "Folders" page opens in the <ThirdProduct>
    Examples:
    | Subscriber         | FirstProduct | SecondProduct | ThirdProduct |
    | SS_WLUK_Subs       | WLUK         | PL            | Commentary   |
    | SS_PL_Subs         | PL           | WLUK          | Commentary   |
    | SS_Commentary_Subs | Commentary   | WLUK          | PL           |