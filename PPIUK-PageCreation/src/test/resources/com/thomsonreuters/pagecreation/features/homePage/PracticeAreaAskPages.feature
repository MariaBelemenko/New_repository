@wip
Feature: To verify the Ask pages for all the ASK Practice area pages for Heading, Disclaimer Text, Featured and Recent queries, Our team and Ask button.

  Scenario Outline: Scenario to verify the ASK Practice area pages
    Given PL+ user is logged in
    And The user clicks the Home page tab link "Resources"
    And clicks on Ask link
    When the user clicks link '<practiceArea>' on 'the Ask Landing' page
    Then the user verifies that the current PageTitle contains 'Ask: <practiceArea>'
    And the ask disclaimer text 'Disclaimer: None of the editorial team providing responses to Ask questions are practising solicitors or barristers. The Ask scope and rules apply' is displayed on ask tab page
    And Featured queries has "<FeaturedItems>" items showing post date and nos replies showning
    And Recent queries has 5 RecentItems items showing, post date and nos replies showning
    And the user verifies that Our people widget is correctly displayed
    And the user verifies that Head of PracticeArea Team for '<PracticeAreaLink>' in Our people widget is '<HeadOfPracticeArea>' and has a '<Title>' title
    And Ask a question button is displayed
    When the user clicks on 'Ask a question' link to ask a question
    And ASK form is displayed in new window
    And user closes the ASK window

    Examples:
    |practiceArea                     |FeaturedItems             |HeadOfPracticeArea | Title                                              |
    | Agriculture & Rural Land        |4                         |Katharine Paulson  | Leads Practical Law Agriculture & Rural Land       |
    | Commercial                      |3                         |Lisa Millar        | Head of Practical Law Commercial                   |
    | Construction                    |6                         |Iain Murdoch       | Head of Practical Law Construction                 |
    | Corporate                       |5                         |Lucy Ryland        | Head of Practical Law Corporate                    |
    | Data Protection                 |3                         |Roger Wesson       | Head of Practical Law Data Protection              |
    | Dispute Resolution              |5                         |Raichel Hopkinson  | Head of Practical Law Dispute Resolution           |
    | Employment                      |5                         |Sophie Capel       | Head of Practical Law Employment                   |
    #| Family                          |0                         |Emma Wilkins       | Head of Practical Law Family                       |
    | Finance                         |10                        |Lucy Cutler        | Head of Practical Law Finance                      |
    | IP & IT                         |3                         |Roger Wesson       | Head of Practical Law IP&IT                        |
    | Local Government                |4                         |Chris Knuckey      | Head of Practical Law Local Government             |
    | Media & Telecoms                |3                         |Roger Wesson       | Head of Practical Law Media & Telecoms             |
   # | Pensions                        |0                         |Loreto Miranda     | Head of Practical Law Pensions                     |
    | Planning                        |5                         |Caroline Cox       | Leads Practical Law Planning                       |
    | Private Client                  |5                         |Claire White       | Head of Practical Law Private Client               |
    | Property                        |6                         |Nikki Martin       | Head of Practical Law Property                     |
    | Property Litigation             |6                         |Chloe Shanley      | Head of Practical Law Property Litigation          |
    | Public Law                      |5                         |Chris Knuckey      | Head of Practical Law Public Law                   |
    | Restructuring & Insolvency      |7                         |Rebecca Catterson  | Leads Practical Law Restructuring & Insolvency     |
    | Share Schemes & Incentives      |5                         |Katharine Long     | Head of Practical Law Share Schemes and Incentives |
    | Tax                             |5                         |Emma Nendick       | Head of Practical Law Tax                          |
# Family and Pension Jim asked to leave for for now as they are yet to be finished by CPET pages team

