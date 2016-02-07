Feature: Not logged in user cannot read or create annotations

  Scenario: As a Not logged in user I want to not be able to read and create annotations so I can not use this feature.
    Given PL+ user is not logged in
    When he is viewing a free document "/Document/I7ab265477b3d11e498db8b09b4f043e0/View/FullText.html"
    Then he does not see in the document page any link related to annotations
    And he is not able to use annotations
