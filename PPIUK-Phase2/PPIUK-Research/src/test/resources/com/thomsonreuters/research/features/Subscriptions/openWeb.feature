@wip
Feature: openWeb.feature

  Scenario: verify open web user has no access to WLUK tab and links to research content from PL content link to correct destination
    Given a user has logged into PL with the subscription
      | Open Web |
    And the user has run a free text search for the term X
    Then the user is able to verify that a page of know how search results is displayed by default to the user
    And the user is able to verify the presence of a tab entitled Selected Westlaw UK documents
    And the user is able to verify that the tab is not accessible
    And the user is able to select a link to a PL topic
    And the user is able to view a section containing WLUK content
    And the user is able to view a link to cases content
    And the user is able to select the link and view the cases asset page
    And the user is able to revert to the PL document previously viewed
    And the user is able to view a link to legislation content
    And the user is able to select the link and view the legislation asset page
    And the user is able to revert to the PL document previously viewed
    And the user is able to view a link to journals content
    And the user is able to select the journals link and is presented with the log in page
