Feature: [752715] Not logged in user cannot add a document to a folder

  Scenario: [752715] As a not logged in user I want to not be able to add a document to a folder so I do not get confused when I am not able to use it.
    Given PL+ user is not logged in
    When he is viewing a free document "/Document/I7ab265477b3d11e498db8b09b4f043e0/View/FullText.html"
    Then he does not see in the document page Add To Folder link