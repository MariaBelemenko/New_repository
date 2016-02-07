Feature: As a user,
  I want the Legal Update page looks like a design document so that I can view the Practice area legal updates results page

  Scenario: As a user, I want the ability to link to the RSS information page when I am viewing the legal updates results page
    Given PL+ user is logged in
    Given a user is on a "Media & Telecoms" PA page
    When the user clicks on the 'View all' link of the LU widget
    And the user is presented with a 'RSS' link in the result page toolbar
    When the user clicks on this link
    Then the user should be presented with the RSS information page

  @manual
  Scenario: User verifies the RSS link on the practice area Legal Update page
    Given user is logged in
    And user navigates to the Media & Telecoms practice area page
    And the user has clicked the 'View all legal updates' link on the practice area widget.
    And the user is presented with a 'RSS' link in the result page toolbar,
    When the user clicks on this link,
    Then the user should be presented with the RSS information page

  @manual
  Scenario: User checks the appearance of CPET Content widget appearance
    Given PL+ user is logged in with collection set "w_plcuk_catpagestst_cs"
    When user clicks on the "Browse Menu" dropdown/button
    And user clicks on the any practice area (e.g. "Commercial")
    Then the user should see the legal update widget on R.H.S of the page
    Then the user should see the headings, links and dates under the headings look like design document attached.