Feature: caseAnalysisDocDisplay.feature

  Background: Log in
  Given PL+ user is logged in

   Scenario Outline: [896749] Verify display for case digest
     When the user opens document with guid "<guid>"
     Then the user can verify the presence of the heading "Case Digest"
     And the user can verify the presence of the heading "Summary"
     And the user can verify the presence of the heading "Abstract"

     Examples:
       | guid                              |
       | I3312F630DF9511E58963C36B2D2F088E |

  Scenario Outline: Verify links within case digest to cases function correctly
    When the user opens document with guid "<guid>"
    And the user can verify the presence of the heading "Case Digest"
    And the user verifies the presence of a link to case "X"
    And the user selects the link
    And the user verifies that the case analysis for the corresponding case is displayed to the user

    Examples:
      | guid                              |
      | I3312F630DF9511E58963C36B2D2F088E |

  Scenario Outline: Verify links within case digest to legislation function correctly
    When the user opens document with guid "<guid>"
    And the user can verify the presence of the heading "Case Digest"
    And the user verifies the presence of a link to legislation provision "X"
    And the user selects the link
    And the user verifies that the corresponding provision for the legislative link is displayed to the user

    Examples:
      | guid                              |
      | I3312F630DF9511E58963C36B2D2F088E |

  Scenario Outline: Verify display where no case digest present
    When the user opens document with guid "<guid>"
    Then the user can verify the presence of the message "message text"
    And the user can verify that the heading "Case Digest" is not present

    Examples:
      | guid                              |
      | ICB10E92018F911DEB8F793CF9A69A7D8 |