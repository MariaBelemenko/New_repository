Feature: Ask Our People Widget
  As a PL+ user
  I want to view the list of editors per practice area
  So that I can see who is answering my question and have a more personal connection with the Ask system

  Background:
    Given PL+ user is logged in

  Scenario Outline: Verify Our people widget contains correct Head of Practice Area for each Practice Area
    When the user is in page 'Browse Menu>Resources>Ask' with page Title 'Ask'
    And the user clicks link '<PracticeAreaLink>' on 'the Ask Landing' page
    Then the user verifies that Our people widget is correctly displayed
    And the user verifies that Head of PracticeArea Team for '<PracticeAreaLink>' in Our people widget is '<HeadOfPracticeArea>'
  Examples:
    | PracticeAreaLink           | HeadOfPracticeArea |
    | Agriculture & Rural Land   | Katharine Paulson  |
    | Commercial                 | Lisa Millar        |
    | Construction               | Iain Murdoch       |
    | Corporate                  | Lucy Ryland        |
    | Dispute Resolution         | Raichel Hopkinson  |
    | Employment                 | Sophie Capel       |
    | Finance                    | Isabella May       |
    | IP & IT                    | Roger Wesson       |
    | Local Government           | Chris Knuckey      |
    | Media & Telecoms           | Roger Wesson       |
    | Planning                   | Caroline Cox       |
    | Private Client             | Claire White       |
    | Property                   | Nikki Martin       |
    | Property Litigation        | Chloe Shanley      |
    | Public Law                 | Chris Knuckey      |
    | Restructuring & Insolvency | David Rawson       |
    | Share Schemes & Incentives | Katharine Long     |
    | Tax                        | Emma Nendick       |
    | Data Protection            | Judith Rauhofer    |

  Scenario: Verify Our people widget in main Ask Landing Page contains one of the members mentioned at any time
    When the user is in page 'Browse Menu>Resources>Ask' with page Title 'Ask'
    Then the user verifies that Our people widget is correctly displayed
    And the user verifies that Our people widget contains one of the following as Head of PracticeArea along with Practice Area
      | PracticeAreaLink             | HeadOfPracticeArea |
      | Agriculture & Rural Land     | Katharine Paulson  |
      | Commercial                   | Lisa Millar        |
      | Construction                 | Iain Murdoch       |
      | Corporate                    | Lucy Ryland        |
      | Dispute Resolution           | Raichel Hopkinson  |
      | Employment                   | Sophie Capel       |
      | Finance                      | Isabella May       |
      | IP&IT                        | Roger Wesson       |
      | Local Government             | Chris Knuckey      |
      | Media & Telecoms             | Roger Wesson       |
      | Planning                     | Caroline Cox       |
      | Private Client               | Claire White       |
      | Property                     | Nikki Martin       |
      | Property Litigation          | Chloe Shanley      |
      | Public Law                   | Chris Knuckey      |
      | Restructuring & Insolvency   | David Rawson       |
      | Share Schemes and Incentives | Katharine Long     |
      | Tax                          | Emma Nendick       |
      | Data Protection              | Judith Rauhofer    |
      | BCI                          | Morag Rea          |
      | Family                       | Emma Wilkins       |
      | Arbitration                  | Saira Singh        |
      | Environment                  | Sara Feijao        |
      | Pensions                     | Loreto Miranda     |
