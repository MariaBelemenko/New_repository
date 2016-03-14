Feature: [780300;780301;780302] Ability to see last 5 legal updates on a widget with dates

  Scenario: See last 5 legal updates with list of LU Documents
    Given PL+ user is logged in
    Given a user navigate to a "Insurance" Topic page from a "Construction" Practice Area page
    And the user is presented with the Legal Updates widget
    And the user should see 5 updates on a "Legal Updates" widget
    And "Legal Updates" widget should display publication dates of documents
    When the user clicks on the 'View all' link of the "Legal Updates" widget
    Then the user should be taken to the "Insurance" Topic LU results list
    Then the user should be presented with a list of LU documents

  Scenario: See last 5 widgets displayed in publication
    Given PL+ user is logged in
    And a user is on the Legal Updates Home page
    And the user is presented with the Legal Updates widget
    And the user should see 5 updates on a "Legal updates" widget
    And "Legal updates" widget should display publication dates of documents
    When the user clicks on the 'View all' link of the "Legal updates" widget
    Then the user should be presented with a list of LU documents

  @e2e @prod
  Scenario Outline: Legal Update Widget showing correct results
    Given PL+ user is logged in
    Given a user is on a "<practiceArea>" PA page
    And the user is presented with the Legal Updates widget
    And the user should see 5 updates on a "<widgetName>" widget
    And "<widgetName>" widget should display publication dates of documents
    When the user clicks on the 'View all' link of the "<widgetName>" widget
    Then the user should be presented with a list of LU documents
    And the results should be from the relevant PA "<practiceArea>"
  Examples:
    | practiceArea               | widgetName       |
    | Arbitration                | Legal updates    |
    | Commercial                 | Legal updates    |
    | Competition                | UK Legal updates |
    | Competition                | EU Legal updates |
    | Construction               | Legal updates    |
    | Corporate                  | Legal updates    |
    | Dispute Resolution         | Legal updates    |
    | Employment                 | Legal updates    |
    | Environment                | Legal updates    |
    | Family                     | Legal updates    |
    | Finance                    | Legal updates    |
    | Financial Services         | Legal updates    |
    | IP & IT                    | Legal updates    |
    | Media & Telecoms           | Legal updates    |
    | Pensions                   | Legal updates    |
    | Private Client             | Legal updates    |
    | Property                   | Legal updates    |
    | Public Law                 | Legal updates    |
    | Restructuring & Insolvency | Legal updates    |
    | Share Schemes & Incentives | Legal updates    |
    | Tax                        | Legal updates    |