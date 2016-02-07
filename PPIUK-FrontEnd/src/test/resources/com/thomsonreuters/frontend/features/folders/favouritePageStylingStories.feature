Feature: As a  user, I want to see the Favourite page styling according to the design

  Scenario: User checks if the Done button is present
    Given PL+ user is logged in
    And user clicks on "Favourites" link
    When user clicks on "organize" button
    Then user should see "Done" button

  Scenario: User checks if the delete and undo links are present
    Given PL+ user is logged in
    And user clicks on "Favourites" link
    And user creates new favourites group 'NewFavTestGroup'
    And user clicks on "organize" button
    When user hovers over the group 'NewFavTestGroup'
    Then user should see the "Delete" link
    And user clicks on "Delete" link
    And user should see the "Undo" link
    And user clicks on "Undo" link
    And user should see the group 'NewFavTestGroup'

  Scenario: User checks if the "Save" and "Cancel" buttons are present
    Given PL+ user is logged in
    And user clicks on "Favourites" link
    And user creates new favourites group 'NewFavTestGroup'
    And user clicks on "organize" button
    When user hovers over the group 'NewFavTestGroup'
    And user clicks on "Rename" link
    Then user should see the aligned "Save" and "Cancel" button for group 'NewFavTestGroup'

  @manual
  Scenario: Favourites link should be visible and displayed according to the style guide
    Given PL+ user is logged in
    When the user clicks on the "Favourites" link
    Then user should see "organize" and "Add a Group" in top side corner on the Favourites page according to the wireframe (page 5)

  @manual
  Scenario: Favourites link should be visible and displayed according to the style guide
    Given PL+ user is logged in
    When the user clicks on the "Favourites" link
    Then user should see favourites page in two columns according to the wireframe
