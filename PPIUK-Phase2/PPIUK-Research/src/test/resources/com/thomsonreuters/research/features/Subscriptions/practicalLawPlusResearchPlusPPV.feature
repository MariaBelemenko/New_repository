Feature: practicalLawPlusResearchPlusPPV.feature

  Scenario: PL + Research + PPV user - verify ppv message displayed for annotated statutes and that user able to view annotation content
    Given a user has logged into PL with the subscription
      | PL + Research + PPV |
    And the user has run a free text search for the term X
    And the user is able to verify the presence of a tab entitled Selected WLUK documents
    And the user is able to select the tab
    And the user is able to view the research content search results page
    #or will it be a facet ?
    And the user is able to select the link to legislation results
    And the user is able to open the legislation document X
    And the user is able to verify the presence of a section entitled Annotated Statutes
    And the user is able to verify the presence of the pay per view message "You may access etc"
    And the user is able to verify the presence of "Yes" and "No" options
    When the user selects the "Yes" option
    Then the user is able to view the annotation content

  Scenario: PL + Research + PPV user - verify ppv message displayed for annotated statutes and that user not able to view annotation content if "no" option selected
    Given a user has logged into PL with the subscription
      | PL + Research + PPV |
    And the user has run a free text search for the term X
    And the user is able to verify the presence of a tab entitled Selected WLUK documents
    And the user is able to select the tab
    And the user is able to view the research content search results page
    #or will it be a facet ?
    And the user is able to select the link to legislation results
    And the user is able to open the legislation document X
    And the user is able to verify the presence of a section entitled Annotated Statutes
    And the user is able to verify the presence of the pay per view message "You may access etc"
    And the user is able to verify the presence of "Yes" and "No" options
    When the user selects the "No" option
    Then the user is not able to view the annotation content

  Scenario: PL + Research + PPV user - verify ppv message displayed for law report pdf content and that user able to view pdf content from cases search results
    Given a user has logged into PL with the subscription
      | PL + Research + PPV |
    And the user has run a free text search for the term X
    And the user is able to verify the presence of a tab entitled Selected WLUK documents
    And the user is able to select the tab
    And the user is able to view the research content search results page
    #or will it be a facet ?
    And the user is able to select the link to cases results
    And the user is able to view the law report PDF icon for the search result X
    And the user is able to select the icon
    And the user is able to verify the presence of the pay per view message "You may access etc"
    And the user is able to verify the presence of "Yes" and "No" options
    When the user selects the "Yes" option
    And the user is able to view the PDF content

  Scenario: PL + Research + PPV user - verify ppv message displayed for law report pdf content and that user able to view pdf content from cases document level
    Given a user has logged into PL with the subscription
      | PL + Research + PPV |
    And the user has run a free text search for the term X
    And the user is able to verify the presence of a tab entitled Selected WLUK documents
    And the user is able to select the tab
    And the user is able to view the research content search results page
    #or will it be a facet ?
    And the user is able to select the link to cases results
    And the user is able to open the case analysis document for the search result X
    And the user is able to select the link to the law report X
    And the user is able to view the law report PDF icon for the law report X
    And the user is able to select the icon
    And the user is able to verify the presence of the pay per view message "You may access etc"
    And the user is able to verify the presence of "Yes" and "No" options
    When the user selects the "Yes" option
    And the user is able to view the PDF content

  Scenario: PL + Research + PPV user - verify ppv message displayed for law report pdf content and that user not able to view pdf content if "no" option selected
    Given a user has logged into PL with the subscription
      | PL + Research + PPV |
    And the user has run a free text search for the term X
    And the user is able to verify the presence of a tab entitled Selected WLUK documents
    And the user is able to select the tab
    And the user is able to view the research content search results page
    #or will it be a facet ?
    And the user is able to select the link to cases results
    And the user is able to view the law report PDF icon for the search result X
    And the user is able to select the icon
    And the user is able to verify the presence of the pay per view message "You may access etc"
    And the user is able to verify the presence of "Yes" and "No" options
    When the user selects the "No" option
    Then the user is not able to view the law report PDF content

  Scenario: PL + Research + PPV user - verify ppv message displayed for law report pdf content and that user not able to view pdf content from cases document level if "no" option selected
    Given a user has logged into PL with the subscription
      | PL + Research + PPV |
    And the user has run a free text search for the term X
    And the user is able to verify the presence of a tab entitled Selected WLUK documents
    And the user is able to select the tab
    And the user is able to view the research content search results page
    #or will it be a facet ?
    And the user is able to select the link to cases results
    And the user is able to open the case analysis document for the search result X
    And the user is able to select the link to the law report X
    And the user is able to view the law report PDF icon for the law report X
    And the user is able to select the icon
    And the user is able to verify the presence of the pay per view message "You may access etc"
    And the user is able to verify the presence of "Yes" and "No" options
    When the user selects the "No" option
    Then the user is not able to view the law report PDF content


