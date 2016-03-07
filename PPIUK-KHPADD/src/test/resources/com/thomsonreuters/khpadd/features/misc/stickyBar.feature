Feature: [730588, 730584] Verify Title and Related Content on the sticky bar
  I want: to see resource page document title and sub heading when I am scrolling through the document
  So that: I always know where I am in the document
  I want: to see “Related Content” link appearing persistently on the sticky bar
  So that: I can navigate to the related content wherever I am in the content

  Scenario: As a user starts to scroll, the document title should stick to the top of the document (sticky bar)
    Given PL+ user is logged in
    When user navigates directly to document with guid "I020627b21cb611e38578f7ccc38dcbee"
    And user scroll down the resource by offset 20
    Then the document title "Financing an offer for a public company: the certain funds requirement" is displayed on the sticky bar

  Scenario: As a user scrolls to each heading, that heading will appear in the sticky bar underneath the document title
    Given PL+ user is logged in
    When user navigates directly to document with guid "I020627b21cb611e38578f7ccc38dcbee"
    And user scroll down the resource to heading "Private company acquisitions"
    Then the document title "Financing an offer for a public company: the certain funds requirement" is displayed on the sticky bar
    And scrolled heading "Private company acquisitions" is displayed on the sticky bar

  Scenario: Related Content Link on the sticky bar
    Given PL+ user is logged in
    When user navigates directly to document with guid "I020627b21cb611e38578f7ccc38dcbee"
    And user scroll down the resource by offset 15
    Then 'Related Content' link is displayed on the sticky bar
    And clicking on 'Related Content' link on sticky bar jumps to Related Content section