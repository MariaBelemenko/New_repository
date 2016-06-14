Feature: [638468] knowHowSearch.feature
  Know How content matches search criteria for UK/US/Global Know How content
  This feature covers tests for the following stories:
  [638468]

  Scenario Outline: UK and US Know-How matches Search Criteria and returns UK Know-How Content
    Given PL+ user is logged in
    When has selected the Know How - <region> link
    And the user runs a free text search for the query "<query>"
    Then the user is able to verify that a page of search results is displayed
    When the user can select the option to show most detail
    Then the user is able to verify the presence of the title of the first result
    And the user is able to verify the presence of a resource type description
    And the user is able to verify a brief description of the content
    And the user is able to verify that jurisdiction information is displayed
    And the user is able to verify that the content is either maintained or non maintained
  Examples:
    | region | query                                             |
    | UK     | IR35                                              |
    | US     | Analyzing a relevant market in Horizontal mergers |

  Scenario: Know-How search does not match search criteria
    Given PL+ user is logged in
    When the user runs a free text search for the query "blubber"
    Then the user is notified that the search does not match any of the know how resources
