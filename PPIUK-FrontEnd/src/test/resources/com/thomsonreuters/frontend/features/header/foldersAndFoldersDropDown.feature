Feature: As a PL+ user, I want to use folders link and associated functionality

  Background: user logins and select the clientID
    Given PL+ user is logged in with following details
      | clientId | SYED |

  Scenario: I want the folders page to display when clicking on "Folders" link So that users are navigated to the Folders page So that users are navigated to the Folders page
    Then user should see "Folders" link
    And  user clicks on folders mainlink
    And  user should see folders page

  @wip
  Scenario: I want a drop down icon to appear next to "Folders" that upon clicking/hovering? reveals a drop down displaying recent folders
    Then user should see folders dropdown arrow
    And  user clicks on the folders dropdown arrow
    And  user should see "1" recent folders and view all link