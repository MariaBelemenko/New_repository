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
    And the user verifies that Head of PracticeArea Team for '<PracticeAreaLink>' in Our people widget is '<HeadOfPracticeArea>' and has a '<Title>' title

    Examples:
      | PracticeAreaLink           | HeadOfPracticeArea | Title                                              |
      | Agriculture & Rural Land   | Katharine Paulson  | Leads Practical Law Agriculture & Rural Land       |
      | Commercial                 | Lisa Millar        | Head of Practical Law Commercial                   |
      | Construction               | Iain Murdoch       | Head of Practical Law Construction                 |
      | Corporate                  | Lucy Ryland        | Head of Practical Law Corporate                    |
      | Data Protection            | Roger Wesson       | Head of Practical Law Data Protection              |
      | Dispute Resolution         | Raichel Hopkinson  | Head of Practical Law Dispute Resolution           |
      | Employment                 | Sophie Capel       | Head of Practical Law Employment                   |
      | Finance                    | Lucy Cutler        | Head of Practical Law Finance                      |
      | IP & IT                    | Roger Wesson       | Head of Practical Law IP&IT                        |
      | Local Government           | Chris Knuckey      | Head of Practical Law Local Government             |
      | Media & Telecoms           | Roger Wesson       | Head of Practical Law Media & Telecoms             |
      | Planning                   | Caroline Cox       | Leads Practical Law Planning                       |
      | Private Client             | Claire White       | Head of Practical Law Private Client               |
      | Property                   | Nikki Martin       | Head of Practical Law Property                     |
      | Property Litigation        | Chloe Shanley      | Head of Practical Law Property Litigation          |
      | Public Law                 | Chris Knuckey      | Head of Practical Law Public Law                   |
      | Restructuring & Insolvency | Rebecca Catterson  | Leads Practical Law Restructuring & Insolvency     |
      | Share Schemes & Incentives | Katharine Long     | Head of Practical Law Share Schemes and Incentives |
      | Tax                        | Emma Nendick       | Head of Practical Law Tax                          |

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
      | Finance                      | Lucy Cutler        |
      | IP&IT                        | Roger Wesson       |
      | Local Government             | Chris Knuckey      |
      | Media & Telecoms             | Roger Wesson       |
      | Planning                     | Caroline Cox       |
      | Private Client               | Claire White       |
      | Property                     | Nikki Martin       |
      | Property Litigation          | Chloe Shanley      |
      | Public Law                   | Chris Knuckey      |
      | Restructuring & Insolvency   | Rebecca Catterson  |
      | Share Schemes and Incentives | Katharine Long     |
      | Tax                          | Emma Nendick       |
      | Data Protection              | Roger Wesson       |
      | BCI                          | Morag Rea          |
      | Family                       | Emma Wilkins       |
      | Arbitration                  | Saira Singh        |
      | Environment                  | Sara Feijao        |
      | Pensions                     | Loreto Miranda     |
