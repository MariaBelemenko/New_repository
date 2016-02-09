Feature: The ability to view a feed of legal updates based on Practice Area

  Scenario Outline: View a feed of legal updates based on Practice Area
    Given PL+ user is logged in with following details
      | userName | LU_AutoUser |
    And that a user is viewing a specific legal updates page "/Browse/Home/Resources/Legalupdates"
    And the legal updates page is based on a particular Practice area tag "<practiceArea>"
    Then the user should be displayed a feed of Legal Updates for that Practice Area "<prescoped PA value>"
    And the 'Practice Area' facets should be pre-scoped to the "<prescoped PA value>" PA that the user had come from
  Examples:
    | practiceArea                 | prescoped PA value         |
    | Arbitration                  | Arbitration                |
    | Commercial                   | Commercial                 |
    | Competition                  | Competition                |
    | Construction                 | Construction               |
    | Corporate                    | Corporate                  |
    | Dispute Resolution           | Dispute Resolution         |
    | Employment                   | Employment                 |
    | Environment                  | Environment                |
    | Family                       | Family                     |
    | Finance                      | Finance                    |
    | Financial Services           | Financial Services         |
    | IP & IT                      | IP & IT                    |
    | Media & Telecoms             | Media & Telecoms           |
    | Pensions                     | Pensions                   |
    | Private Client               | Private Client             |
    | Property                     | Property                   |
    | Public Law                   | Public Law                 |
    | Restructuring & Insolvency   | Restructuring & Insolvency |
    | Share Schemes & Incentives   | Share Schemes & Incentives |
    | Tax                          | Tax                        |
