Feature: PL+ Home Page Tabs
  In Order to view Practice areas, Resources and International tabs
  As a User
  I want to select the relevant tabs on the homepage

  Background:
    When PL+ user is logged in

  Scenario: Verify default Tab is 'Practice Areas' in Home Page
    Then user can view three tabs: Practice Areas, Resources and International
    And the user verifies that default Tab is 'Practice areas'

  @e2e @prod
  Scenario: Verify Practice Area Tab-links in Home Page
    Then the user verifies that following 'Practice areas' links are displayed
      | Arbitration                |
      | Commercial                 |
      | Competition                |
      | Construction               |
      | Corporate                  |
      | Dispute Resolution         |
      | Employment                 |
      | Environment                |
      | Family                     |
      | Finance                    |
      | Financial Services         |
      | IP & IT                    |
      | Media & Telecoms           |
      | Pensions                   |
      | Private Client             |
      | Property                   |
      | Public Law                 |
      | Restructuring & Insolvency |
      | Share Schemes & Incentives |
      | Tax                        |

  @e2e @prod
  Scenario Outline: Verify that Practice Area Tab-links when clicked, navigates to correct page
    When the user clicks link '<Link>' on 'the home' page
    Then the user verifies that the current PageTitle contains '<Link>'
  Examples:
    | Link                       |
    | Arbitration                |
    | Commercial                 |
    | Competition                |
    | Construction               |
    | Dispute Resolution         |
    | Employment                 |
    | Environment                |
    | Family                     |
    | Finance                    |
    | Financial Services         |
    | IP & IT                    |
    | Media & Telecoms           |
    | Pensions                   |
    | Private Client             |
    | Property                   |
    | Public Law                 |
    | Restructuring & Insolvency |
    | Share Schemes & Incentives |
    | Tax                        |
