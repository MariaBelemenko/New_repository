@wip
Feature: practicalLawPlusResearch.feature

  Scenario: PL + Research user has no access to Annotated Statutes
    Given a user has logged into PL with the subscription
    | PL + Research |
    And the user has run a free text search for the term X
    And the user is able to verify the presence of a tab entitled Selected WLUK documents
    And the user is able to select the tab
    And the user is able to view the research content search results page
    #or will it be a facet ?
    And the user is able to select the link to legislation results
    And the user is able to open the legislation document X
    And the user is able to verify the presence of a section entitled Annotated Statutes
    And the user is able to verify the presence of the message "You do not have access etc"


  Scenario: PL + Research user has no access to law report PDFs
    Given a user has logged into PL with the subscription
      | PL + Research |
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
    #needs to be verified for search results and at document level - do we also need to test browse path ?

  Scenario: PL + Research user has no access to lawtel transcript PDFs
    #this will prove to be a very difficult test to write and ensure it is not brittle since the lawtel transcripts are
  #overwritten by the official transcript when the official transcript arrives - need a way to search and obtain lawtel
  #transcript results every time


