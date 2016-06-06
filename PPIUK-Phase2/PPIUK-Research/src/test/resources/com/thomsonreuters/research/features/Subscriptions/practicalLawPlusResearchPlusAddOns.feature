@wip
Feature: practicalLawPlusResearchPlusAddOns.feature

  Scenario: Verify that PL + Research + Annotations user is able to access annotations content
    Given a user has logged into PL with the subscription
      | PL + Research + Annotations |
    And the user has run a free text search for the term X
    And the user is able to verify the presence of a tab entitled Selected WLUK documents
    And the user is able to select the tab
    And the user is able to view the research content search results page
  #or will it be a facet ?
    And the user is able to select the link to legislation results
    And the user is able to open the legislation document X
    And the user is able to verify the presence of a section entitled Annotated Statutes
    And the user is able to view the Annotation content

  Scenario: Verify that PL + Research + Annotations user has no access to law report PDFs
    Given a user has logged into PL with the subscription
      | PL + Research + Annotations |
    And the user has run a free text search for the term X
    And the user is able to verify the presence of a tab entitled Selected WLUK documents
    And the user is able to select the tab
    And the user is able to view the research content search results page
    #or will it be a facet ?
    And the user is able to select the link to case results
    And the user is able to view the case document X in the list of search results
    And the user is able to verify the presence of a link to the law report X
    And the user is able to verify that there is no PDF associated with the law report link on the search result
    And the user is able to select the link to the law report X
    And the user is able to verify that there is no PDF version of the law report present

  #need a test to verify no access to lawtel transcripts but this depends on findin



