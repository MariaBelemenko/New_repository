@manual
Feature: As a  user, I want to see the Home page styling according to the design

  Scenario: User checks the appearance of "Recent History" widget and "View all" button on Home Page
    Given PL+ user is logged in with collection set "w_plcuk_catpagestst_cs"
    When user navigates to the home page by using link https://plcuk.next.ci.westlaw.com/Browse/Home/Practice/Home?transitionType=Default&contextData=(sc.Default)
    Then user should see the "Recent history" title and links according to the design attached.
    Then the user should see each resource status and type under each link.
    And the user should see "View All" button at the end of the widget.

  Scenario: User checks the appearance of Home Page and its respective tabs
    Given PL+ user is logged in with collection set "w_plcuk_catpagestst_cs"
    When user navigates to the home page by using link https://plcuk.next.ci.westlaw.com/Browse/Home/Practice/Home?transitionType=Default&contextData=(sc.Default)
    Then user should see the tabs (i.e. Practice Areas, Resources and International) with no headings according to design
    Then the user clicks on the International Tab
    Then the user should see "View all" button underneath the countries column
    Then the user should also see "Country Q&A comparison tool" as per design

  Scenario: User checks the appearance of CPET Content widget appearance
    Given PL+ user is logged in with collection set "w_plcuk_catpagestst_cs"
    When user clicks on the "Browse Menu" dropdown/button
    And user clicks on the any practice area (e.g. "Commercial")
    Then the user should see the manage content sidebar widget on R.H.S of the page
    Then the user should see the headings, links and Text under the headings look like design document attached.

  Scenario: User checks the appearance of CPET Content widget appearance
    Given PL+ user is logged in with collection set "w_plcuk_catpagestst_cs"
    When user clicks on the "Browse Menu" dropdown/button
    And user clicks on the any practice area (e.g. "Commercial")
    Then the user should see the managed content on the active tab (i.e. Topics) with the separation/bottom line in every section
    Then the user should see the each widget heading and links defaults to the pattern lab

  Scenario: User checks the appearance of CPET Tabbed widget appearance
    Given PL+ user is logged in with collection set "w_plcuk_catpagestst_cs"
    When user navigates directly to Tab Page with url "https://plcuk.next.ci.westlaw.com/Browse/Home/Practice/Tax?transitionType=Default&contextData=(sc.Default)"
    And user clicks on the Resource Tab
    Then the user should see the active "Resources" tab with black border at the bottom
    Then the user should see the active "Resources" tab with black text

  Scenario: Skip to content link should be functional according to wireframe
    Given PL+ user has logged in
    When user press tab key twice
    Then user should see "Skip to content" link
    And user press enter
    And it should take to the main body content