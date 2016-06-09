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
    Then the document title "Financing an offer for a public company: the certain funds requirement" is displayed on the sticky bar
    And scrolled heading "Pre-conditional offers and certain funds" is displayed on the sticky bar

  Scenario: Related Content Link on the sticky bar
    Given PL+ user is logged in
    When user navigates directly to document with guid "I020627b21cb611e38578f7ccc38dcbee"
    And user scroll down the resource by offset 15
    Then 'Related Content' link is displayed on the sticky bar
    And clicking on 'Related Content' link on sticky bar jumps to Related Content section
    
 
  Scenario Outline: (bug#867652)When user clicks internal link he is taken to the correct section in the document and the banner title displays the correct headings
    Given PL+ user is logged in
    When user navigates directly to document with guid "<guid>"
   	And clicks on the Show/Hide Drafting Notes option on the delivery toolbar
    And user clicks on the 'Show All' option
    And clicks on document link "<link>"
    Then user verifies if page is scrolled to heading "<heading>"
    And  scrolled heading "<heading>" is displayed on the sticky bar
   Examples:
    | guid                              |link             													| heading|
    | I33f105f1e8cd11e398db8b09b4f043e0	|Practice note, Execution of deeds and documents: Execution of deeds|Execution of deeds|
 
  Scenario Outline: (bug#867652)When user clicks on item in ToC he is taken to the correct section in the document and the banner title displays the correct headings
    Given PL+ user is logged in
    When user navigates directly to document with guid "<guid>"
    And user clicks on link "<heading>" in ToC
    Then user verifies if page is scrolled to heading "<heading>"
    And  scrolled heading "<heading>" is displayed on the sticky bar
   Examples:
    | guid                              |heading             					|
    | I2a05f3d71cb811e38578f7ccc38dcbee	|When do you need a written contract?	|

    Scenario Outline: (bug#863526)Doc display - title of sections not displaying when clicking on links in Speedread(for doc with TOC)
    Given PL+ user is logged in
    When user navigates directly to document with guid "<guid>"
    And the user clicks on the '<heading>' link
    Then user verifies if page is scrolled to heading "<heading>"
    And  scrolled heading "<heading>" is displayed on the sticky bar
   Examples:
    | guid                              |heading             					|
    | I362b3d5112cc11e698dc8b09b4f043e0	|Consultation on improving charities reporting and accounting framework	|

   Scenario Outline: (bug#863526)Doc display - title of sections not displaying when clicking on links in Speedread(for doc without TOC)
    Given PL+ user is logged in
    When user navigates directly to document with guid "<guid>"
    And the user clicks on the '<heading>' link
    Then user verifies if page is scrolled to heading "<heading>"
    Examples:
    | guid                              |heading             					|
    | I6460dd8bd66811e598dc8b09b4f043e0 |Plymouth Brethren charity meeting public benefit requirements|