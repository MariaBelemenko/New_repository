Feature: As a  user, I want to see the document display page styling according to the design

  Scenario: User verifies the "Drafting Notes" expansion and collapsing
    Given PL+ user is logged in
    And the user runs a free text search for the query "Contract for the sale of freehold land"
    And the user clicks on search result "Contract for the sale of freehold land with vacant possession" title link
    Then user should see the Standard Document with drafting icon on the Delivery toolbar
    And clicks on the Show/Hide Drafting Notes option on the delivery toolbar
    And user clicks on the 'Show All' option
    And user should see all the drafting notes in the document expanded
    And user clicks to close the drafting note with title "Parties"
    And user should see the drafting note with title "Parties" collapsed
    And user clicks on the 'Hide All' option
    And user should see all the drafting notes in the document collapsed

  Scenario: User verifies the "Drafting Notes" popup options according to Design
    Given PL+ user is logged in
    When user navigates directly to document with plcref "8-200-0344"
    And clicks on the Show/Hide Drafting Notes option on the delivery toolbar
    Then the following drafting notes options are displayed
      | Show All        |
      | Hide All        |
      | Show Notes Only |
    And user should see the tick with "Hide All" option

  Scenario: User checks Table of Content toggle button
    Given PL+ user is logged in
    And the user searches for term "Disability discrimination"
    And the user clicks on search result "Disability discrimination" title link
    When the user closes the ToC by clicking on cross button
    Then the user should see ToC hidden with menu toggle button on left side

  @manual
  Scenario: User verifies the delivery options on document page
    Given a user using the delivery options on document display
    When I select Print, email of download from the delivery toolbar
    Then I will see the delivery modal box
    And I will be able to select the Basic and Advanced tabs to see the options on each tab.

  @manual
  Scenario: User checks the "Back to Top" link appearance and functionality
    Given PL+ user is logged in
    And user navigates directly to document with guid "Ib55520d8e83211e398db8b09b4f043e0"
    When the user scrolls down the page or clicks on the bottom links from table of content on the right.
    Then the user should see the "Back to Top" button with tooltip on the right bottom of the page
    And the user clicks on the "Back to Top" button
    And it should take the user to the top of the page with smooth transition

  @manual
  Scenario: User checks the appearance of "Recent History" widget and "View all" button on Resource Landing Page
    Given a user browsing on the maintained resource landing page (ie. Practice notes)
    When user is viewing the Recent History widget
    Then user can select the "View all" button"
    And user will be taken to the History folder.

  @manual
  Scenario: Verify the document heading and "Related Content" appearance
    Given cobalt user has logged into PLCUK site as "UKPPITester1"
    When user navigates to the home page with clientID "SYED"
    And user navigates to the KH resource page (link : http://plcuk.next.demo.westlaw.com/Document/I3351a831e8da11e398db8b09b4f043e0/View/FullText.html)
    Then the user should see the right hand side tool bar icons according to wireframe

  @manual
  Scenario: User checks the "View Related Content" link appearance and functionality
    Given PL+ user is logged in
    And user navigates directly to document with guid "Ib55520d8e83211e398db8b09b4f043e0"
    When the user hovers over the different icons.
    Then  the user should see the respective tooltip of the icon.

  @manual
  Scenario: User checks the "View Related Content" link appearance and functionality
    Given PL+ user is logged in with following details
      | clientId | SYED |
    And user navigates directly to document with guid "Ib55520d8e83211e398db8b09b4f043e0"
    Then the user should see right aligned "Related Content" button on sticky bar.
    And  the user resize the window
    And user should not see the title text wrap upon the "Related Content"

  @manual
  Scenario: User checks the main body "Author" appearance
    Given cobalt user has logged into PLCUK site as "UKPPITester1"
    When user navigates to the home page with clientID "SYED"
    And user navigates to the KH resource page (link : plcuk.next.demo.westlaw.com/Document/I2030a03e1cb611e38578f7ccc38dcbee/View/FullText.html)
    Then the user should see the "author" within the body with following features according to wireframe
      | Author text should be appeared at the top of the document |
      | Author text should be left aligned                        |

  @manual
  Scenario: User checks the main body "title" appearance
    Given cobalt user has logged into PLCUK site as "UKPPITester1"
    When user navigates to the home page with clientID "SYED"
    And user navigates to the KH resource page (link : plcuk.next.demo.westlaw.com/Document/I2030a03e1cb611e38578f7ccc38dcbee/View/FullText.html)
    Then the user should see the "title" within the body with following features according to wireframe
      | Title should be appeared at the top of the document |
      | Title should be left aligned                        |

  @manual
  Scenario: User checks the main body "Sub-heading" appearance
    Given cobalt user has logged into PLCUK site as "UKPPITester1"
    When user navigates to the home page with clientID "SYED"
    And user navigates to the KH resource page (link : plcuk.next.demo.westlaw.com/Document/I2030a03e1cb611e38578f7ccc38dcbee/View/FullText.html)
    Then the user should see the "Sub-heading" within the body according to wireframe

  @manual
  Scenario: User checks the main body "bullet list" appearance
    Given cobalt user has logged into PLCUK site as "UKPPITester1"
    When user navigates to the home page with clientID "SYED"
    And user navigates to the KH resource page (link : plcuk.next.demo.westlaw.com/Document/I2030a03e1cb611e38578f7ccc38dcbee/View/FullText.html)
    Then the user should see the "bullet list" within the body according to wireframe
