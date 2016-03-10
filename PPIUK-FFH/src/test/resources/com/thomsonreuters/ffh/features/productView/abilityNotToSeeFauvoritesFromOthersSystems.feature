Feature: As a PPI User I do not want to see Favourites from other systems in my Favourites so I avoid to see undesireable Favourites

# when Cases is available, add removed steps
  Scenario: Verify the correct details are seen in Favourites
    Given PL+ user is logged in
    When API cleans all folders and history
    Given WLN user is logged in with following details
      | userName         | FFHUser4 |
      | routing          | FOLDERS  |
      | mandatoryRouting | YES      |
    When API cleans all folders and history and user relogs in
    #And the user come back on to WLN Home page
    #And the user opens WLN 'Cases' link
    #And the user adds page to favourites group 'wln1'
    And the user come back on to WLN Home page
    And the user opens WLN 'Forms' link
    And the user adds page to favourites group 'group23'
    And the user come back on to WLN Home page
    And the user opens WLN 'Briefs' link
    And the user adds page to favourites group 'wln1'
    And the user come back on to WLN Home page
    And the user opens WLN 'Dockets' link
    And the user come back on to WLN Home page
    And the user opens WLN 'Regulations' link
    And the user come back on to WLN Home page
    And the user opens WLN 'Business Law Center' link
    And the user makes page as My Start Page
    Given PL+ user is logged in with following details
      | userName | FFHUser4 |
    Then the user checks the start page is Home page
    When the user clicks on 'Favourites' link on the header
    #Then the user checks that 'Cases' link is not in favourites group 'wln1' on Favourites page
    And the user checks that 'Briefs' link is not in favourites group 'wln1' on Favourites page
    And the user checks that 'Dockets' link is not in favourites group 'Frequently Used Items' on Favourites page
    And the user checks that 'Regulations' link is not in favourites group 'Frequently Used Items' on Favourites page
    And the user checks that 'Business Law Center' link is not in favourites group 'My Start Page' on Favourites page
    And the user checks that 'Forms' link is not in favourites group 'group23' on Favourites page
    # the check below was added due to bug 743569
    #And the user come back on to Home page
    #And the user opens /Browse/Home/Resources url on plcuk website
    #And the user checks that 'Cases' link is not saved to Favourites

  Scenario: Correct WLN links appear in favourites
    Given WLN user is logged in with following details
      | userName         | FFHUser4 |
      | routing          | FOLDERS  |
      | mandatoryRouting | YES      |
    When API cleans all folders and history
    Given PL+ user is logged in with following details
      | userName | FFHUser4 |
    When API cleans all folders and history and user relogs in
    #And the user opens /Browse/Home/Resources url on plcuk website
    #And the user opens 'Cases' link
    #And the user adds page to favourites group 'pl1'
    And the user come back on to Home page
    And the user opens 'Commercial' link
    And the user adds page to favourites group 'pl1'
    And the user come back on to Home page
    And the user opens 'Family' link
    And the user adds page to favourites group 'group23'
    And the user come back on to Home page
    And the user opens 'Finance' link
    And the user makes page as My Start Page
    Given WLN user is logged in with following details
      | userName         | FFHUser4 |
      | routing          | FOLDERS  |
      | mandatoryRouting | YES      |
    Then the user checks the start page is Home page
    #And the user checks that WLN 'Cases' link is not in favorites group 'pl1' on Favorites widget
    And the user checks that WLN 'Commercial' link is not in favorites group 'pl1' on Favorites widget
    And the user checks that WLN 'Resources' link is not in favorites group 'Frequently Used Items' on Favorites widget
    And the user checks that WLN 'Finance' link is not in favorites group 'My Start Page' on Favorites widget
    And the user checks that WLN 'Family' link is not in favorites group 'group23' on Favorites widget
    # the check below was added due to bug 743569
    #And the user come back on to Home page
    #And the user checks that 'Cases' link is not saved to Favourites
    