Feature: [774401] FD1 As a PL+ User I want to view a list of standard documents and drafting notes and see which documents have a FD template So that I can see which documents I can draft in Fast Draft
  [774396] FD7 As a PL+ PA User I want to start drafting a Fast Draft document from PL+ So that I can save time and effort when creating a document for my client

  Scenario Outline:
    Given PL+ user is logged in with following details
      | userName         | FDTestUser2 |
      | routing          | FAST_DRAFT  |
      | mandatoryRouting | YES         |
    When the user come back on to Home page
    And the user opens 'Resources' link
    And the user opens 'Standard documents and drafting notes' link
    And the user opens "<practiceArea>" link
    Then the user sees the FastDraft logo for "<document>" document
    When the user opens "<document>" link
    Then the user sees Start Drafting button
  Examples:
    | practiceArea   | document                                                                  | ref        |
    | Private Client | Master Will with drafting notes                                           | 5-381-4187 |
    | Property       | Lease of whole with prescribed clauses                                    | 8-201-5543 |
    | Property       | Lease of whole with guarantee and prescribed clauses                      | 2-201-5838 |
    | Employment     | Settlement agreement: employment (long form)                              | 3-200-3665 |
    | Employment     | Settlement agreement: employment (short form)                             | 4-500-0875 |
    | Employment     | Employment contract for a senior employee                                 | 5-200-2047 |
    | Property       | Contract for the sale of freehold land subject to lease                   | 5-107-4907 |
    | Property       | Contract for the sale of residential freehold land with vacant possession | 0-508-1760 |
