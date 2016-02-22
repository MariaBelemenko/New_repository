Feature: PL+ Home Page Browse
  In Order to view Practice areas, Resources and International links
  As a User
  I want to select the relevant resources on the homepage

  Scenario: Verify default link is 'Practice areas' in menu 'Browse Menu' on the Home Page
    Given PL+ user is logged in
    When the user clicks button 'Browse Menu' on the Home Page
    Then user can view three links: Practice Areas, Resources and International
    And the user verifies that default Link is 'Practice areas'

  @e2e @prod
  Scenario: Verify that 'Practice Area' links are displayed in menu 'Browse Menu' on the Home Page
    Given PL+ user is logged in
    When the user clicks button 'Browse Menu' on the Home Page
    Then the user verifies that following 'Practice areas' links are displayed in in menu 'Browse Menu' on the Home Page
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
