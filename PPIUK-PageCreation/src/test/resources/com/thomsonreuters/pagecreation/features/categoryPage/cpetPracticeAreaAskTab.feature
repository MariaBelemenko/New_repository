@wip

Feature: Check that the Ask Tab on each Practice Area page that has one (not all of them do) has:
* Disclaimer
* 5 recent queries are displayed
* Each recent query has a reply number and date
* Go to Ask link is present and resolves to expected location

#Phil Harper for CPET

  Background:
    Given PL+ user is logged in

  Scenario Outline: Verify the Ask Tab functionality for each relevant Practice Area page
    Given  the user clicks button 'Browse Menu' on the Home Page
    And the user accesses each Practice Area via Browse Menu > "<practiceArea>"
    When navigates to the Ask Tab
    Then the user verifies the Ask disclaimer is present
    Then the user clicks the Scope and Rules link
    And the user verifies the resulting 'Scope and Rules' page
    And the user clicks on the browser back button
    Then navigates to the Ask Tab
    Then All Recent Queries are displayed
    And verifies each Recent Query has associated reply information
    And verifies each Recent Query has a Date
    Then confirms the Go to Ask "<practiceArea>" Button is present
    And clicks the Go to Ask "<practiceArea>"
    And the resulting Go to Ask "<practiceArea>" contains the associated Page Label
    And the user clicks on the browser back button

    Examples:
      | practiceArea               |
      | Agriculture & Rural Land   |
      | Commercial                 |
      | Construction               |
      | Corporate                  |
      | Data Protection            |
      | Dispute Resolution         |
      | Employment                 |
      | Finance                    |
      | IP & IT                    |
      | Local Government           |
      | Media & Telecoms           |
      | Planning                   |
      | Private Client             |
      | Property                   |
      | Property Litigation        |
      | Public Law                 |
      | Restructuring & Insolvency |
      | Share Schemes & Incentives |
      | Tax                        |