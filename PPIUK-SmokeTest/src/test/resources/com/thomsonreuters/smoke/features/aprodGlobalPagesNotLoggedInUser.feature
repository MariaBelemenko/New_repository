Feature: Verify Global pages - Not logged in user

  Background:
    Given PL+ user is not logged in
    And the user navigates to the main PLCUK page

  Scenario Outline: verify that not logged user can open US, UK, Canada, China, Global links in the same window
    When user hovers over the country toggle dropdown
    And the user selects "<link>"
    Then the user is taken to the "<webSite>" web site in the same window and tab
  Examples:
    | link   | webSite                                                         |
    | UK     | thomsonreuters.com/Search/Home                                  |
    | US     | signon.thomsonreuters.com/?productid=CBT&viewproductid=PLCUS    |
    | China  | thomsonreuters.com/Browse/Home/Global/China                     |
    | Canada | ca.practicallaw.com                                             |
    | Global | thomsonreuters.com/Browse/Home/Global                           |