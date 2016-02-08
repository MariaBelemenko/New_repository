@ip
Feature: [757156]  LI007 - IP users do not see folders favourites, alerts or history

  Scenario: [757156] As an IP user I want to have no access to folders, favourites and history so I do not get confused when I am not able to use them
    Given PL+ user is logged in with following details
      | loginRequired | NO |
    When the user navigates to the main PLCUK page
    And he does a search "tax"
    Then he does not see in the search results page any link related to FFH
      | Favourites |
      | Folders    |
      | History    |

  Scenario: [757156] As an IP user I want to have no access to folders, favourites and history so I do not get confused when I am not able to use them
   Given PL+ user is logged in with following details
      | loginRequired | NO |
    When the user navigates to the main PLCUK page
    And he looks at the header , no matter which page he is at
    Then he does not see in the header any link related to FFH

  Scenario: [757156] As an IP user I want to have no access to folders, favourites and history so I do not get confused when I am not able to use them
    Given PL+ user is logged in with following details
      | loginRequired | NO |
    When the user navigates to the main PLCUK page
    And he is viewing a free document "/Document/I7ab265477b3d11e498db8b09b4f043e0/View/FullText.html"
    Then he does not see in the document page any link related to FFH
      | Favourites |
      | Folders    |
      | History    |