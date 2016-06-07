Feature: [851088] As a not logged user
  I want to navigate to China page and see the featured content links

  Background:
    Given PL+ user is not logged in
    When the user navigates to the main PLCUK page
    Then the user clicks on "Close" link

  Scenario Outline: verify featured content links
    When the user selects "International" tab and clicks on "China" link in "International subscriptions" section
    Then the Category Page opens correctly
    When the user selects "Topics" tab and clicks on "<link>" link in "Featured" section
    Then the document opens correctly
  Examples:
    | link                            |
    | China legislation               |
    | GC Agenda China                 |
    | Understanding China legislation |

  Scenario Outline: verify Compare the law across countries link
    When the user selects "International" tab and clicks on "China" link in "International subscriptions" section
    Then the Category Page opens correctly
    When the user selects "Topics" tab and clicks on "<link>" link in "Featured" section
    Then the user is taken on the comparison tool page with header "Global guides | Country Q&A comparison tool"
  Examples:
    | link                             |
    | Compare the law across countries |

  Scenario Outline: verify International collections link
    When the user selects "International" tab and clicks on "China" link in "International subscriptions" section
    Then the Category Page opens correctly
    When the user selects "Topics" tab and clicks on "<link>" link in "Featured" section
    Then the user verifies that the current PageTitle contains '<title>'
    Then the Category Page opens correctly
  Examples:
    | link                      | title                            |
    | International collections | International transaction guides |
    | Contributors              | Contributors                     |
