Feature: As a KH user,
  I want to view the "View Related Content" link for each type of resource page

  @e2e @prod @e2eprod
  Scenario: User checks the "View Related Content" link appearance and functionality, Verify Link to the Related Document
    Given PL+ user is logged in
    And the user searches for term "Disability discrimination"
    When the user clicks on search result "Disability discrimination" title link
    And the user clicks on "Related Content" link
    Then the user should see the related content section displayed
    When the user clicks on link in related content with title "Discrimination and harassment: a quick guide"
    Then document title is displayed as "Discrimination and harassment: a quick guide"
    And resource type is displayed as "Practice note: overview" on right hand panel

  @e2eprod
  Scenario: User checks the "Related Content" button appearance and functionality on Sticky header
    Given PL+ user is logged in
    And the user searches for term "Disability discrimination"
    When the user clicks on search result "Disability discrimination" title link
    And the user scrolls down the page "a bit"
    Then the user should see the related content button on the sticky header
    When the user clicks on "Related Content" button
    Then the user should see the related content section displayed

  @e2e @prod @e2eprod
  Scenario: Verify Link to the External Resource document under Related Document
    Given PL+ user is logged in
    And the user searches for term "Construction Industry"
    When the user clicks on search result "Construction Industry Scheme (CIS)" title link
    And the user clicks on "Related Content" link
    Then the user should see the related content section displayed
    When the user clicks on link in related content with title "HMRC: Gross-paid subcontractors and the annual compliance review"
    Then document title is displayed as "HMRC: Gross-paid subcontractors and the annual compliance review"
    And resource type is displayed as "External resources" on right hand panel
    And document contains link to 'http://www.hmrc.gov.uk/cis/subcontractors/gross-paid-review.htm'
