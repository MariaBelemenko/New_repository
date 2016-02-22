Feature: As a PPI User I want to have a page dedicated to History where I can see the documents and searches that I did.
  As a PPI I want to be able to select the History tab from the History/Folders Page so I can see the information related to History.
  As a PPI User I want to have a page dedicated to Folders where I can manage the folders that I created and its content.
  FFH060 As a PPI User I want to be able to select the Folders tab from the History/Folders Page so I can see the information related to Folders.

  Scenario: Page dedicated to History where I can see the documents
    Given PL+ user is logged in
    When the user clicks on 'History' link on the header
    Then 'History' page opens
    And All tabs present on History page
    When the user clicks on 'Folders' tab
    Then 'Folders' page opens
    When the user clicks on 'History' tab
    Then 'History' page opens
    When the user clicks on 'Folders' link on the header
    Then 'Folders' page opens
    When the user clicks on 'History' tab
    Then 'History' page opens
    And All tabs present on History page
    When the user clicks on 'Folders' tab
    Then 'Folders' page opens
