@manual
Feature:  As a  user,I want to see the Folders page as in Design Document

  Scenario: User verifies left column folder's styling
    Given a user is logged in
    When user navigates to the Folders page
    Then user should see no Folders' Icon on the tab
    And user should see the Folders tab selected bigger than the History
    And user should see only "+" sign alongside with "New" tab
    And user should not see any "Narrow" text below the folder tree
    And user should see "Search within results" text in one row
    And user should not see "Select multiple filter" button
    And user selects any sub-folder
    And user should see the selected folder background blue and has a black vertical bar on left.

  Scenario: User verifies the New Folder Popup according to design document
    Given user is logged in
    And user navigates to the Folders page
    When user opens the New Folder popup
    Then user should see the New Folders popup including the removal of blue background selection and appearance of "required" word according to the design document

  Scenario: User verifies the "New" and "Options" buttons displayed correctly
    Given cobalt user has logged into PLCUK site as "Yuri.Lupinov"
    When user navigates to the home page with clientID "SYED"
    And user clicks on "Folders" link
    Then user should see the "Folders" tab
    And  user should see "New" and "Options" buttons