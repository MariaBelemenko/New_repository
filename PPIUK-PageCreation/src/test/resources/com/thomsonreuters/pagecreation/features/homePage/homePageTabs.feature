Feature: PL+ Home Page Tabs
  In Order to view Practice areas, Resources and International tabs
  As a User
  I want to select the relevant tabs on the homepage

  Scenario: Verify default Tab is 'Practice Areas' in Home Page
    Then user can view three tabs: Practice Areas, Resources and International
    And the user verifies that default Tab is 'Practice areas'

  @e2e @prod @e2eprod
  Scenario: Verify Practice Area Tab-links in Home Page
    Given PL+ user is logged in
    Then the user verifies that following 'Practice areas' links are displayed
      | Agriculture & Rural Land        |
      | Arbitration                     |
      | Business Crime & Investigations |
      | Commercial                      |
      | Competition                     |
      | Construction                    |
      | Corporate                       |
      | Data Protection                 |
      | Dispute Resolution              |
      | Employment                      |
      | Environment                     |
      | EU Law                          |
      | Family                          |
      | Finance                         |
      | Financial Services              |
      | IP & IT                         |
      | Local Government                |
      | Media & Telecoms                |
      | Pensions                        |
      | Planning                        |
      | Private Client                  |
      | Property                        |
      | Property Litigation             |
      | Public Law                      |
      | Restructuring & Insolvency      |
      | Share Schemes & Incentives      |
      | Tax                             |

  @e2e @prod @e2eprod
  Scenario Outline: Verify that Practice Area Tab-links when clicked, navigates to correct page
    Given PL+ user is logged in
    When the user clicks link '<Link>' on 'the home' page
    Then the user verifies that the current PageTitle contains '<Link>'
  Examples:
    | Link                            |
    | Agriculture & Rural Land        |
    | Arbitration                     |
    | Business Crime & Investigations |
    | Commercial                      |
    | Competition                     |
    | Construction                    |
    | Corporate                       |
    | Data Protection                 |
    | Dispute Resolution              |
    | Employment                      |
    | Environment                     |
    | EU Law                          |
    | Family                          |
    | Finance                         |
    | Financial Services              |
    | IP & IT                         |
    | Local Government                |
    | Media & Telecoms                |
    | Pensions                        |
    | Planning                        |
    | Private Client                  |
    | Property                        |
    | Property Litigation             |
    | Public Law                      |
    | Restructuring & Insolvency      |
    | Share Schemes & Incentives      |
    | Tax                             |