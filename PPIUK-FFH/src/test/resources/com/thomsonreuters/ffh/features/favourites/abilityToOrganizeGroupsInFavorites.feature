Feature: As a PPI User I want to be able to rename a group when I try to organize Favourites so I can change the name of the group.
  As a PPI User I want to be able to delete groups and/or pages on my Favourites so I can eliminate them from favourites when I don't need them anymore.

  Scenario:
    Given PL+ user is logged in
    When API cleans all folders and history and user relogs in
    When the user clicks on 'Favourites' link on the header
    And the user creates new favourites group 'new123'
    Then the favourites group 'new123' presents on Favourites page
    And the user come back on to Home page
    And the user opens 'Employment' link
    And the user adds page to favourites group 'new123'
    And the user come back on to Home page
    And the user opens 'Commercial' link
    And the user adds page to favourites group 'new123'
    And the user come back on to Home page
    And the user opens 'Competition' link
    And the user adds page to favourites group 'group1'
    And the user come back on to Home page
    And the user opens 'Construction' link
    And the user adds page to favourites group 'group1'
    When the user clicks on 'Favourites' link on the header
    Then the user checks that 'Employment' link presents in favourites group 'new123' on Favourites page
    And the user checks that 'Commercial' link presents in favourites group 'new123' on Favourites page
    And the user checks that 'Competition' link presents in favourites group 'group1' on Favourites page
    And the user checks that 'Construction' link presents in favourites group 'group1' on Favourites page
    #Rename
    When the user renames the favourites group 'new123' to 'pl33'
    Then the user checks that 'Employment' link presents in favourites group 'pl33' on Favourites page
    And the user checks that 'Commercial' link presents in favourites group 'pl33' on Favourites page
    And the favourites group 'pl33' presents on Favourites page
    #Delete group with pages
    When the user deletes the favourites group 'pl33'
    And the user come back on to Home page
    And the user clicks on 'Favourites' link on the header
    Then the user checks that 'Employment' link is not in favourites group 'pl33' on Favourites page
    And the user checks that 'Commercial' link is not in favourites group 'pl33' on Favourites page
    And the favourites group 'pl33' is absent on Favourites page
    #Delete pages
    When the user deletes the favourites page 'Competition'
    And the user deletes the favourites page 'Construction'
    And the user come back on to Home page
    And the user clicks on 'Favourites' link on the header
    Then the user checks that 'Competition' link is not in favourites group 'group1' on Favourites page
    And the user checks that 'Construction' link is not in favourites group 'group1' on Favourites page
    And the favourites group 'group1' presents on Favourites page
    