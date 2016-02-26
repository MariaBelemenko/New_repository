Feature: PL+ user ASK Question link over Category,Topic and Home Page
  As a user
  I want the Ask a question link over various pages
  So that I can quickly ask a question

  Background:
    Given PL+ user is logged in

  @CloseAskWindow
  Scenario Outline: Verify Ask question link on Category Page
    When the user clicks link '<Link>' on 'the home' page
    Then 'Ask a question' link is displayed
    When the user clicks on 'Ask a question' link to ask a question
    Then ASK form is displayed in new window
    And user closes the ASK window
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

  @CloseAskWindow
  Scenario: Verify Ask question link on Home Page
    When the user clicks on 'Ask a question' link to ask a question
    Then ASK form is displayed in new window
    And user closes the ASK window

  @CloseAskWindow
  Scenario Outline: Verify Ask question link on Topic Page
    When the user clicks category link '<CategoryLink>'and topic link '<TopicLink>' on 'the home' page
    Then 'Ask a question' link is displayed
    When the user clicks on 'Ask a question' link to ask a question
    Then ASK form is displayed in new window
    And user closes the ASK window
  Examples:
    | CategoryLink | TopicLink                          |
    | Arbitration  | Arbitration agreements             |
    | Arbitration  | Costs and funding                  |
    | Commercial   | Advertising and marketing          |
    | Commercial   | Agency                             |
    | Construction | Building contracts and contractors |
    | Employment   | Civil litigation                   |
    | Environment  | Air pollution                      |
