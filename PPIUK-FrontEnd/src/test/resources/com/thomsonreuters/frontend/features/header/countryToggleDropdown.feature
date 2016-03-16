Feature: As a user,I want to see the "Country Toggle Drop-down" links according to the design with respective links

  Scenario: User verifies the "Country Toggle Drop-down" links and styling
    Given PL+ user is logged in
    When user hovers over the country toggle dropdown
    Then user should be seeing the following countries with respective links
      | Country | Link                                                                                                                    |
      | UK      | http://uk.practicallaw.demo.thomsonreuters.com/                                                                         |
      | US      | https://a.uk.practicallaw.demo.thomsonreuters.com/Transfer.html?domainKey=PLCUS                                         |
      | China   | http://uk.practicallaw.demo.thomsonreuters.com/Browse/Home/Global/China?transitionType=Default&contextData=(sc.Default) |
      | Canada  | http://ca.practicallaw.com/                                                                                             |
      | Global  | http://uk.practicallaw.demo.thomsonreuters.com/Browse/Home/Global?transitionType=Default&contextData=(sc.Default)       |
