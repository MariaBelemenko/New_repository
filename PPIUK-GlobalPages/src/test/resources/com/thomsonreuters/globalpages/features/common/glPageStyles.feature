Feature: As a User
  I see correct styles in global page

  Background:
    Given PL+ user is logged in with following details
      | userName | GlPage_UK1 |
    When the user navigates to the Global Page
    Then the Global Page opens correctly

  Scenario: Verify styles of lines that separate sections in Transactions tab
    When the user selects "Transactions" tab
    Then the "0" line has the "solid" style
    And the "1" line has the "solid" style

  @bug
  Scenario Outline: Verify font size of headers in Transactions tab
    When the user selects "Transactions" tab
    Then the header "Featured content" with tag "<tag1>" has "<fontSize>" font size
    And the header "International collections" with tag "<tag2>" has "<fontSize>" font size
  Examples:
    | tag1 | tag2 | fontSize |
    | h3   | span | 15px     |

  # 842714 GPBUG: To big distance the  between the links in �Featured content� section
  @bug
  Scenario: Verify distance between links in featured content section
    When the user selects "Transactions" tab
    Then the value of paddong-bottom style of links is "0px"
