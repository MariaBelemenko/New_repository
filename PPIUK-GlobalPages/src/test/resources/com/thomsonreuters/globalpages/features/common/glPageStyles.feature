Feature: [841722] [842369] [842714] As a User
  I see correct styles in global page

  Background:
    Given PL+ user is logged in
    When the user navigates to the main PLCUK page
    When the user selects "International" tab and clicks on "Global" link in "International subscriptions" section
    Then the Category Page opens correctly

  Scenario: [841722] Verify styles of lines that separate sections in Transactions tab
    When the user selects "Transactions" tab
    Then the "0" line has the "solid" style
    And the "1" line has the "solid" style

  Scenario Outline: [842369] Verify font size of headers in Transactions tab
    When the user selects "Transactions" tab
    Then the header "Popular international resources" with tag "<tag1>" has "<fontSize>" font size
    And the header "International collections" with tag "<tag2>" has "<fontSize>" font size
  Examples:
    | tag1 | tag2 | fontSize |
    | h3   | span | 15px     |

  Scenario: [842714] Verify distance between links in featured content section
    When the user selects "Transactions" tab
    Then the value of line-height style of links is "24px"