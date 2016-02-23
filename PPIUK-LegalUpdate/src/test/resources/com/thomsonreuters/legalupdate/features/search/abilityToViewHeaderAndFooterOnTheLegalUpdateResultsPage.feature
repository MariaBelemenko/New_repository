Feature: As a User, I want to see a new view in the PLCUK product so I can view legal update results lists.

  Scenario: See a header on the legal update results page.
    Given PL+ user is logged in
    And a user is on a legal updates results page "/Browse/Home/Resources/LegalUpdates/UKMediaTelecomsLegalUpdates"
    Then the user should be able to see a header on the page
    And the header should contain the '3' UI features listed in the description
      | //ol[@id='co_navigationPages'] |
      | //div[@id='saveToFolder']      |
      | //li[@id='deliveryWidget']     |
    Then the user should be able to see a footer on the page
    And the footer should contain the '2' UI features listed in the description
      | //ul[@id='co_navigationFooter']     |
      | //a[@id='selectedDisplayItemCount'] |

  Scenario: See a header on the topic legal update results page.
    Given PL+ user is logged in
    Given a user navigate to a "Insurance" Topic page from a "Construction" Practice Area page
    When the user clicks on the 'View all' link of the LU widget
    Then the user should be able to see a header on the page
    And the header should contain the '3' UI features listed in the description
      | //ol[@id='co_navigationPages'] |
      | //div[@id='saveToFolder']      |
      | //li[@id='deliveryWidget']     |
    Then the user should be able to see a footer on the page
    And the footer should contain the '2' UI features listed in the description
      | //ul[@id='co_navigationFooter']     |
      | //a[@id='selectedDisplayItemCount'] |
