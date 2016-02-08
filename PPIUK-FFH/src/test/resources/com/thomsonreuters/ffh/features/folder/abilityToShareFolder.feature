Feature: Share Folders with one contact (Read Only access)
  Share Folders with one contact (Read Only access) (Part 2)
  Share Folders with one contact (Contributor access)
  Share a folder with a group (Read only access)
  Share a folder with a group (Read only access) (Part 2)
  Share a Folder with a group providing contributor access
  Share a folder via email address read only access
  Share a Folder via email Contributor access
  End Share a folder

  Background:
    Given PL+ user is logged in with following details
      | userName | FFHTestUser1_Firm1 |

  Scenario:
    When API cleans all folders and history
    Given PL+ user is logged in with following details
      | userName | FFHTestUser2_Firm1 |
    When API cleans all folders and history
    Given PL+ user is logged in with following details
      | userName | FFHTestUser3_Firm1 |
    When API cleans all folders and history
    Given PL+ user is logged in with following details
      | userName | FFHTestUser2_Firm3 |
    When API cleans all folders and history

  Scenario Outline: Share via email address
    When the user clicks on 'Folders' link on the header
    And the user creates new folder "<folder>" in "<parentFolder>" folder
    Then the folder "<folder>" appears in the "<parentFolder>" folder
    When the user '<owner>' share the folder "<folder>" with the user '<userToShare>' via email
    Then the user '<userToShare>' recieve invitation from 'noreply.practicallaw@thomsonreuters.com' in specified email inbox
  Examples:
    | folder | parentFolder | owner              | userToShare        |
    | share1 | root         | FFHTestUser1_Firm1 | FFHTestUser2_Firm3 |

  Scenario Outline: Share with groups and endsharing
    When the user clicks on 'Folders' link on the header
    And the user creates new folder "<folder>" in "<parentFolder>" folder
    Then the folder "<folder>" appears in the "<parentFolder>" folder
    When the user share the folder "<folder>" with new group "<group>" and member 'Share 2, Firm 1' as "<role>"
    Then new message about the folder "<folder>" sharing is displayed
    Given PL+ user is logged in with following details
      | userName | FFHTestUser2_Firm1 |
    When the user clicks on 'Folders' link on the header
    Then the folder "<folder>" appears in shared folders
    Given PL+ user is logged in with following details
      | userName | FFHTestUser1_Firm1 |
    When the user clicks on 'Folders' link on the header
    And the user unshare the folder "<folder>"
    Then new message about the folder "<folder>" is no longer shared
    And the user closes share folder popup
    Given PL+ user is logged in with following details
      | userName | FFHTestUser2_Firm1 |
    When the user clicks on 'Folders' link on the header
    Then the folder "<folder>" is absent in shared folders
  Examples:
    | folder | parentFolder | role     | group |
    | share2 | root         | Reviewer | gr1   |

  Scenario Outline: Share with contacts and endsharing
    When the user clicks on 'Folders' link on the header
    And the user creates new folder "<folder>" in "<parentFolder>" folder
    Then the folder "<folder>" appears in the "<parentFolder>" folder
    When the user share the folder "<folder>" with contact 'Share 2, Firm 1' as "<role>" and contact 'Share 3, Firm 1' as "<role2>"
    Then new message about the folder "<folder>" sharing is displayed
    Given PL+ user is logged in with following details
      | userName | FFHTestUser2_Firm1 |
    When the user clicks on 'Folders' link on the header
    Then the folder "<folder>" appears in shared folders
    Given PL+ user is logged in with following details
      | userName | FFHTestUser3_Firm1 |
    When the user clicks on 'Folders' link on the header
    Then the folder "<folder>" appears in shared folders
    Given PL+ user is logged in with following details
      | userName | FFHTestUser1_Firm1 |
    When the user clicks on 'Folders' link on the header
    And the user unshare the folder "<folder>"
    Then new message about the folder "<folder>" is no longer shared
    And the user closes share folder popup
    Given PL+ user is logged in with following details
      | userName | FFHTestUser2_Firm1 |
    When the user clicks on 'Folders' link on the header
    Then the folder "<folder>" is absent in shared folders
    Given PL+ user is logged in with following details
      | userName | FFHTestUser3_Firm1 |
    When the user clicks on 'Folders' link on the header
    Then the folder "<folder>" is absent in shared folders
  Examples:
    | folder | parentFolder | role     | role2       |
    | share3 | root         | Reviewer | Contributor |
