Feature: As a PL+ user, I want to use history link and associated functionality

  Scenario: I want the History page to display upon clicking the History link So that customers can navigate to the History page
    Given PL+ user is logged in with following details
      | clientId | SYED |
    Then user should see history link
    And user clicks on history mainlink
    And user should see history page

  @wip
  Scenario: I want a drop down icon to appear next to "History" that upon clicking/hovering? reveals a drop down displaying recent folders
    Given PL+ user is logged in with following details
      | clientId | SYED |
    And user clicks on history mainlink
    And user should see View all link and recent documents and searches results and labels
    And user clicks on recent docs view all links and should see history searches
    And user clicks on recent searches view all links and should see history searches
