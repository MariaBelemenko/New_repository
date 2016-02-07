Feature: Not logged in user cannot see any FFH links

  Scenario: As a not logged in user I do not want to see any related links to Favourites Folders and/or History so I do not get confused when I am not able to use them.
    Given PL+ user is not logged in
    When the user navigates to the main PLCUK page
    And he does a search "tax"
    Then he does not see any link related to FFH
      | Favourites |
      | Folders    |
      | History    |

  Scenario: As a not logged in user I do not want to see any related links to Favourites Folders and/or History so I do not get confused when I am not able to use them.
    Given PL+ user is not logged in
    When the user navigates to the main PLCUK page
    And he looks at the header , no matter which page he is at
    Then he does not see in the header any link related to FFH

  Scenario: As a not logged in user I do not want to see any related links to Favourites Folders and/or History so I do not get confused when I am not able to use them.
    Given PL+ user is not logged in
    When the user navigates to the main PLCUK page
    And he is viewing a free document "/Document/I7ab265477b3d11e498db8b09b4f043e0/View/FullText.html"
    Then he does not see any link related to FFH
      | Favourites |
      | Folders    |
      | History    |
