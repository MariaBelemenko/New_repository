Feature: Verify asset pages and links to external pages(Bailii, Westlaw UK, legislation.gov.uk)

  Scenario: Bailii asset page links
    Given PL+ user is logged in
    And the user come back on to Home page
    When the user runs a free text search for the query "Instructing an expert in financial remedy proceedings"
    When the user clicks link 'Instructing an expert in financial remedy proceedings' on 'search' page
    And the user clicks on "Kranidiotes v Paschali [2001] EWCA Civ 357" link
    Then document title is displayed as "Kranidiotes v Paschali & Anor [2001] EWCA Civ 357 (8 March, 2001)"
    And resource type is displayed as "Case page" on right hand panel
    Then the user see links to "Bailii" Bailii
    When the user click on "Bailii" Bailii link
    Then the user is taken to "http://www.bailii.org" resource

  Scenario: Westlaw/Legislation.gov asset page links
    Given PL+ user is logged in
    When the user runs a free text search for the query "section 110 liquidation"
    And the user can open the first know how search result "1"
    And the user clicks on "section 110" link
    Then document title is displayed as "Section 110, Insolvency Act 1986"
    And resource type is displayed as "Primary Source" on right hand panel
    Then the user see link to "Westlaw UK" Westlaw UK
    When the user click on link to "Westlaw UK" Westlaw UK
    Then the user is taken to the login page in Westlaw UK
    Then the user close the current window
    And the user go back to previous window
    Then the user see links to "Legislation.gov.uk" Legislation
    When the user click on "Legislation.gov.uk" Legislation link
    Then the user is taken to "legislation.gov.uk" resource
