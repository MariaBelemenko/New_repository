@e2e
Feature: Ensure Practice Area Pages are displayed correctly

  Scenario Outline: Verify that Practice Area links navigates to correct page
    Given PL+ user is logged in
    When the user clicks button 'Browse Menu' on the Home Page
    And the user clicks link '<Link>' on 'the Browse Menu on the home' page
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

  Scenario: Verify that a Practise Area page is displayed correctly
    Given PL+ user is logged in
    When the user clicks button 'Browse Menu' on the Home Page
    And the user clicks link 'Employment' on 'the Browse Menu on the home' page
    Then the user verifies that the current PageTitle contains 'Employment'
    And 'add to favorites' and 'back to home' button are present
    And the category tabs are present
