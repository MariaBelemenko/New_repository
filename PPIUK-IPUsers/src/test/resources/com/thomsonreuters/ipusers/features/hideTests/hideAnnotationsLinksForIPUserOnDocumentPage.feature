@ip
Feature: [752707]  LI014 - IP user cannot create annotations

  Scenario: [752707] As an IP user I want to not be able to create annotations so I can not include annotations in a document.

    Given PL+ user is logged in with following details
      | loginRequired | NO |
    When he is viewing a free document "/Document/I7ab265477b3d11e498db8b09b4f043e0/View/FullText.html"
    Then he does not see in the document page any link related to annotations
    And he is not able to use annotations
