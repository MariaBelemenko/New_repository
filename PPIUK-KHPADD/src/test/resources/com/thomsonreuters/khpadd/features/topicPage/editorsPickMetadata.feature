Feature: [730556][770720] I want: to view document type, resource status (maintained or published date or law stated) and jurisdictions for editors picks
  So that: I can understand if they are relevant to my needs

  @e2e @prod
  Scenario: Verify the Editor's Pick metadata on topic page (Employment -> Contracts of employment)
    Given PL+ user is logged in
    When the user navigates to practice area "Employment" filtered by "Transfer of undertakings" topic page
    Then the following resources are present under the Editors Picks
      | resourceLink                                                          | metadata                                                                        |
      | TUPE: overview                                                        | Maintained ; Practice note: overview ; Any UK jurisdiction, United Kingdom      |
      | Asset purchase agreement: employment provisions                       | Maintained ; Standard clauses ; Any UK jurisdiction, England, Wales             |
      | Outsourcing agreement: employment provisions                          | Maintained ; Standard clauses ; Any UK jurisdiction, England, Wales             |
      | TUPE and collective redundancy consultation: dealing with the overlap | Maintained ; Practice notes ; Any UK jurisdiction, England, Scotland, Wales     |
      | Advice to an employee on TUPE                                         | Maintained ; Standard documents ; Any UK jurisdiction, England, Scotland, Wales |
    When the user clicks on the resource link "TUPE: overview" in Editor's pick widget
    Then document title is displayed as "TUPE: overview"
    And resource type is displayed as "Practice note: overview" on right hand panel

  Scenario: [764886] Verify editor's pick widget appears only on the first page of the topic page
    Given PL+ user is logged in
    When the user navigates to practice area "Employment" filtered by "Transfer of undertakings" topic page
    And user clicks on Page "2" of the Topic page results list
    Then user cannot see the Editor's pick widget on this page
