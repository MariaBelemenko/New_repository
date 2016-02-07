@manual
Feature: Legal Updates search - Sort by Relevance

  #from Beecham, Chris (Legal) <Chris.Beecham@thomsonreuters.com>
  # formula is rather involved, it is described in more detail here:
  #https://thehub.thomsonreuters.com/docs/DOC-887315
  #The formula weights up a number of items � hits is only 1 aspect of this. The most important tool we have for testing search quality is the automated relevancy testing tool.
  #For manual testing, I would  just check that the results look �sensible� in terms of the results at the top having:
  #-The search terms in the title
  #-The search terms in the abstract
  #-Relatively recent documents
  #I would also use a search term with 2 or more words as this should be clearer
  Scenario: 
    Given a user is on the Corporate PA LU results page
    When user runs a search
    Then the�results should all be sorted by relevancy to the query
    Then the�Results should all be Legal Update documents
    Then the�Results should all be from the Corporate PA.

  Scenario: 
    Given a user is on the�Tax: Energy and Environment Topic�LU results page
    When user runs a search
    Then the�results should all be sorted by relevancy to the query
    Then the�Results should all be Legal Update documents
    Then the�Results should all be from the Tax: Energy and Environment Topic.
