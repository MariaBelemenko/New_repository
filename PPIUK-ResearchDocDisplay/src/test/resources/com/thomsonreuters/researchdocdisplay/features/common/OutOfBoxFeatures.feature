@wip
Feature: As a PL+ user verifying the Out of box functionalities

  Scenario: As a PL+ User I want to view the History of Recent Documents
    Given PL+ user is logged in
    And user clicks on UK New Content Link
    Given user clicks on UK Legislation
    When user enters search term "Personal Pension"
    And user clicks on Search button
    And User selects document "1"
    Then User is viewing legislation document "1"
    When Go back to list of results
    And User selects document "2"
    Then User is viewing legislation document "2"
    When Go back to list of results
    And User selects document "3"
    Then User is viewing legislation document "3"
    And Verify history has documents in the list of recent documents and those are accessible
      | 1 |
      | 2 |
      | 3 |

  Scenario Outline: As a PL+ User I want to navigate to the next or previous case document in the search results as document carosal links so that I can read the next or previous document in my search results
    Given PL+ user is logged in
    And user clicks on UK New Content Link
    Given user clicks on "<doctype>"
    When user enters search term "<document1>"
    And user clicks on Search button
    And user can see the list of results
    And user clicks on Less Details
    And User selects document "2"
    Then User is able to see previous link in left hand side as carosal
    And User is able to see previous document "1" in carosal link
    And User is able to see next link in right hand side as carosal
    And User is able to see next document "3" in carosal link
    When User clicks on previous link in left hand side as carosal
    Then User is not able to see previous link in left hand side as carosal
    And User is able to see next link in right hand side as carosal
    And User is able to see next document "2" in carosal link
    When User clicks on next link in right hand side as carosal
    Then User is able to see previous link in left hand side as carosal
    And User is able to see previous document "1" in carosal link
    And User is able to see next link in right hand side as carosal
    And User is able to see next document "3" in carosal link
    When User clicks on next link in right hand side as carosal
    Then User is able to see previous link in left hand side as carosal
    And User is able to see previous document "2" in carosal link
    And User is able to see next link in right hand side as carosal
    And User is able to see next document "4" in carosal link
    When User come back on to Home page
    And user clicks on UK New Content Link
    And user clicks on "<doctype>"
    And user enters search term "<document2>" which has 1 search result
    And user clicks on Search button
    And user can see the list of results
    And User selects document "1"
    Then User is not able to see previous link in left hand side as carosal
    And User is not able to see next link in right hand side as carosal
  Examples:
    | document1                      | document2                                                | doctype         |
    | OBG Ltd v Allan                | Jones (A Minor) v Wrexham CBC                            | UK-CASES        |
    | discrimination #and harassment | Northern Ireland Statute 2014 c. 9 (N.I.) Sch. 1 para. 1 | UK-LEGISLATIONS |

  Scenario Outline: As a PL+ User I want to navigate to the next or previous case document in the search results from results navigation widget so that I can read the next or previous document in my search results
    Given PL+ user is logged in
    And user clicks on UK New Content Link
    And user clicks on "<doctype>"
    When user enters search term "<document1>"
    And user clicks on Search button
    And user can see the list of results
    And user clicks on Less Details
    And User selects document "2"
    Then User is able to see the results navigation links on results navigation widget
    And User is able to see previous result link is enabled on left hand side of results navigation widget
    And User is able to see next result link is enabled and on right hand side of results navigation widget
    When User clicks on previous result link on results navigation widget
    Then Verify that previous document link is disabled
    And User is able to see next result link is enabled and on right hand side of results navigation widget
    When User clicks on next document link on results navigation
    Then User is able to see previous result link is enabled on left hand side of results navigation widget
    And User is able to see next result link is enabled and on right hand side of results navigation widget
    When User clicks on next document link on results navigation
    Then User is able to see previous result link is enabled on left hand side of results navigation widget
    And User is able to see next result link is enabled and on right hand side of results navigation widget
    And user clicks on "<doctype>"
    And user enters search term "<document2>" which has 1 search result
    And user clicks on Search button
    And user can see the list of results
    And User selects document "1"
    Then Verify that previous document link is not present
    And Verify that next document link is not present
  Examples:
    | document1                     | document2                                                | doctype         |
    | OBG Ltd v Allan               | Jones (A Minor) v Wrexham CBC                            | UK-CASES        |
    | discrimination and harassment | Northern Ireland Statute 2014 c. 9 (N.I.) Sch. 1 para. 1 | UK-LEGISLATIONS |

  Scenario Outline: As a PL+ User I can add a document to folder
    Given PL+ user is logged in
    And user clicks on UK New Content Link
    And user clicks on "<doctype>"
    When user enters search term "<document>"
    And user clicks on Search button
    And user clicks on Sort By Relevancy
    When User selects "<document>" based on name
    Then User is viewing "<document>" of "<doctype>"
    When User has selected add the document to folder
    And User selects the "<folder>" the document should be added to
    Then Verify that "<document>" added to the "<folder>"
  Examples:
    | document                              | doctype         | folder           |
    | Jones (A Minor) v Wrexham CBC         | UK-CASES        | Myfolder         |
    | s. 4 Effect of ceasing to be a member | UK-LEGISLATIONS | Myfolder/Testing |

  Scenario Outline: As a PL+ User I can add a document to folder so that I can retrieve at a later date from the folder
    Given PL+ user is logged in with following details
      | newSession | TRUE |
    When User selected the folders options
    And User has opened the "<folder>" that contains the "<document>" they want to retrieve
    And User selects the "<document>" to retrieve it
    Then User is viewing "<document>" of "<doctype>"
  Examples:
    | document                              | doctype         | folder           |
    | Jones (A Minor) v Wrexham CBC         | UK-CASES        | Myfolder         |
    | s. 4 Effect of ceasing to be a member | UK-LEGISLATIONS | Myfolder/Testing |

  Scenario: As a PL+ User I want to view star paging within the law report document
    Given PL+ user is logged in with following details
      | newSession | TRUE |
    And user clicks on UK New Content Link
    And user clicks on "UK-CASES"
    When user enters search term "Plevin v Paragon Personal Finance Ltd and another"
    And user clicks on Search button
    When User selects "Plevin v Paragon Personal Finance Ltd" based on name
    Then User is able to see StarPagings
      | *553 |
      | *554 |
      | *555 |
