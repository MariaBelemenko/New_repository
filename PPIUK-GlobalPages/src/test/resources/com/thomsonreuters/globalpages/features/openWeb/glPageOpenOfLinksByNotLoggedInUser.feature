Feature: As a not logged user, I want to navigate to Canada, China, Global, US resources

  Background:
    Given PL+ user is not logged in
    And the user navigates to the main PLCUK page

  Scenario Outline: verify that not logged user can US, UK, Canada, China, Global links open in the same window
    When user hovers over the country toggle dropdown
    And the user selects "<link>"
    Then the user is taken to the "<webSite>" web site in the same window and tab
  Examples:
    | link   | webSite                                                         |
    | UK     | thomsonreuters.com/Search/Home                                  |
    | US     | signon.qa.thomsonreuters.com/?productid=CBT&viewproductid=PLCUS |
    | China  | thomsonreuters.com/Browse/Home/Global/China                     |
    | Canada | ca.practicallaw.com                                             |
    | Global | thomsonreuters.com/Browse/Home/Global                           |

  Scenario Outline: verify that not logget user can open Canada, China, Global, US links in the International subscriptions section open in the same window
    When the user selects "International" tab and clicks on "<link>" link in "International subscriptions" section
    Then the user is taken to the "<webSite>" web site in the same window and tab
  Examples:
    | link   | webSite                                                         |
    | Canada | ca.practicallaw.com                                             |
    | China  | thomsonreuters.com/Browse/Home/Global/China                     |
    | Global | thomsonreuters.com/Browse/Home/Global                           |
    | US     | signon.qa.thomsonreuters.com/?productid=CBT&viewproductid=PLCUS |
