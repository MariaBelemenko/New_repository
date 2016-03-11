Feature: [845124][838713][834292] As a PL+ User, I want to navigate to Canada, China, Global, US resources from homepage

  Scenario Outline: [845124] Verify that logged user can open Canada, China, Global, US links in the International subscriptions section open in the same window
    Given PL+ user is logged in
    When the user navigates to the main PLCUK page
    When the user selects "International" tab and clicks on "<link>" link in "International subscriptions" section
    And the user clicks on Continue button
    Then the user is taken to the "<webSite>" web site in the same window and tab
  Examples:
    | link   | webSite                                     |
    | Canada | ca.practicallaw.com                         |
    | China  | thomsonreuters.com/Browse/Home/Global/China |
    | Global | thomsonreuters.com/Browse/Home/Global       |
    | US     | westlaw.com                                 |
