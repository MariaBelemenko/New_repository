@wip
Feature: [713462; 713410] The ability to use subscription link on header and footer to config subscription preferences

  Scenario Outline: Use the Subscription link on the Header and Footer so that I can configure my subscription preferences
    Given PL+ user is logged in
    Given a user is on a legal updates results page
    When the user selects 'Subscribe' on the "<header or footer>"
    Then the user should be presented with a subscription popup
    And the popup should contain features listed in the description
      | //div[@id='nameBox']//descendant::input[@id='SubscriptionName']            |
      | //div[@id='deliveryBox']//descendant::input[@id='emailCheck']              |
      | //div[@id='deliveryBox']//descendant::input[@id='myUpdatesCheck']          |
      | //div[@id='frequencyBox']//descendant::select[@id='frequency']             |
      | //div[@id='emailBox']//descendant::input[@id='email']                      |
      | //div[@id='emailBox']//descendant::input[@id='message']                    |
      | //div[@id='emailBox']//descendant::input[@id='notifyMecheck']              |
      | //ul[@id='submitBox']//descendant::input[@type='button' and @value='Save'] |
      | //ul[@id='submitBox']//descendant::a[@id='cancelLink']                     |
  Examples:
    | header or footer                                               |
    | //div[@id='co_search_footerToolbar']//a[text()='Subscription'] |
    | //div[@id='co_search_headerToolbar']//a[text()='Subscription'] |

#test is wip due to story 729645 As a user, I do not want to see the button for a subscription pop-up on the legal update results page
