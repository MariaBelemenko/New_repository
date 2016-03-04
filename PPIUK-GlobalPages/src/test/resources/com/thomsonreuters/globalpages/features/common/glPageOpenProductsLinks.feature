Feature: As a PL+ User, I can open US, UK, Canada, China, Global links from country toggle dropdown

  Scenario Outline: verify that logged user can open US, UK, Canada, China, Global links open in the same window
    Given PL+ user is logged in
    When the user navigates to the main PLCUK page
    When user hovers over the country toggle dropdown
    And the user selects "<link>"
    And the user clicks on Continue button
    Then the user is taken to the "<webSite>" web site in the same window and tab
  Examples:
    | link   | webSite                                     |
    | UK     | thomsonreuters.com/Search/Home              |
    | US     | westlaw.com                                 |
    | China  | thomsonreuters.com/Browse/Home/Global/China |
    | Canada | ca.practicallaw.com                         |
    | Global | thomsonreuters.com/Browse/Home/Global       |
