Feature: Verify topic page faceting and editor's picks

  Scenario: Topic page faceting and Editor's pick
    Given PL+ user is logged in
    When a user navigate to a "Development" Topic page from a "Property" Practice Area page
    Then user can see the Editor's pick widget on this page
    When user clicks on Page "2" of the Topic page results list
    Then user cannot see the Editor's pick widget on this page
    When clicks on the facet group "Checklists"
    Then only 'Checklists' are displayed on topic page