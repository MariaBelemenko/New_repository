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
@wip
  Scenario Outline: Verify that the documents are displayed correctly
    Given PL+ user is logged in
    When the user selects practice area page '<Practice Area>'
    When the user click on the topic link '<Topic Page>'
    And the user verifies the presence of a next page navigation arrow
    And the user selects document type '<Document Type>'
    Then the user selects random document in the '<Document Type>' category
    Then the user verifies the presence of all practice area document sections
    Then the user clicks on 'Return to list'
    Examples:
      | Practice Area              |  Topic Page                                 |  Document Type             |
      | Employment                 |  Contracts of employment                    |  Practice notes            |
      | Corporate                  |  Share acquisitions: private                |  Practice notes            |
      | Commercial                 |  General commercial                         |  Practice notes            |
      | Property                   |  Any                                        |  Practice notes            |
      | Employment                 |  Contracts of employment                    |  Standard documents        |
      | Corporate                  |  Share acquisitions: private                |  Standard documents        |
      | Commercial                 |  General contract and boilerplate           |  Standard documents        |
      | IP & IT                    |  Trade marks                                |  Standard documents        |
      | Employment                 |  Contracts of employment                    |  Standard clauses          |
      | Corporate                  |  Company administration and meetings        |  Standard clauses          |
      | Commercial                 |  Supply of goods and services               |  Standard clauses          |
      | Property                   |  Any                                        |  Standard clauses          |
      | Employment                 |  Contracts of employment                    |  Checklists                |
      | Corporate                  |  Share acquisitions: private                |  Checklists                |
      | Commercial                 |  General contract and boilerplate           |  Checklists                |
      | Property 		           |  Any							             |  Checklists                |
      | Employment                 |  Transfer of undertakings                   |  Glossary                  |
      | Property 		           |  Any							             |  Glossary                  |
      | Commercial                 |  General commercial                         |  Glossary                  |
      | Property                   |  Development                                |  Glossary                  |