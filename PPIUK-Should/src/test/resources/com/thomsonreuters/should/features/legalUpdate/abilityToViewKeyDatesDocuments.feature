Feature: Ability to view Key Dates documents

  Scenario Outline: [786704] Ability to view Key Dates documents
    Given PL+ user is logged in with following details
      | userName | LU_AutoUser |
    Given a user is on a "<practiceArea>" PA page
    When the user clicks on the tab "<tab>"
    And clicks on document link "<link>"
    Then user should be presented with proper document "<documentTitle>"
  Examples:
    | practiceArea         | tab                | link                                            | documentTitle                                           |
    | Commercial           | Resources          | Key dates for commercial law professionals      | Key dates for commercial lawyers: 2015                  |
    | Corporate            | Resources          | Key dates for corporate lawyers: 2015           | Key dates for corporate lawyers: 2015                   |
    | Finance              | Resources          | Key dates for finance professionals             | Key dates for finance lawyers in 2015                   |
    | Financial Services   | Resources          | Key dates for financial services practitioners  | Key dates for financial services practitioners: 2015/16 |
    | For in-house lawyers | Keeping up to date | Key dates for in-house lawyers: 2015            | Key dates for in-house lawyers: 2015                    |
    | For in-house lawyers | Keeping up to date | Key dates for in-house lawyers: 2016 and beyond | Key dates for in-house lawyers: 2016 and beyond         |
    | Employment           | Resources          | What to expect and employment law reform        | What to expect in employment law                        |
    | Environment          | Resources          | What to expect in 2015                          | Practical Law Environment: What to expect in 2015       |
    | Arbitration          | Resources          | Arbitration events calendar                     | Forthcoming events: international arbitration           |
    | Dispute Resolution   | Resources          | Events calendar                                 | Forthcoming events: litigation and ADR                  |
    | Tax                  | Resources          | Key dates for corporate tax practitioners: 2015 | Key dates for corporate tax practitioners: 2015         |