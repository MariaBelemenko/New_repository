Feature: caseAnalysisDocDisplay.feature
  [896749] Case digest
  [893361] Appellate history

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

  Scenario Outline: [896749] Verify links within case digest to cases function correctly
    When the user opens document with guid "<guid>"
    And the user can verify the presence of the heading "Case Digest"
    And the user verifies the presence of a link to case "X"
    And the user selects the link
    And the user verifies that the case analysis for the corresponding case is displayed to the user

    Examples:
      | guid                              |
      | I3312F630DF9511E58963C36B2D2F088E |

  Scenario Outline: [896749] Verify links within case digest to legislation function correctly
    When the user opens document with guid "<guid>"
    And the user can verify the presence of the heading "Case Digest"
    And the user verifies the presence of a link to legislation provision "X"
    And the user selects the link
    And the user verifies that the corresponding provision for the legislative link is displayed to the user

    Examples:
      | guid                              |
      | I3312F630DF9511E58963C36B2D2F088E |

  Scenario Outline: [896749] Verify display where no case digest present
    When the user opens document with guid "<guid>"
    Then the user can verify the presence of the message "message text"
    And the user can verify that the heading "Case Digest" is not present

    Examples:
      | guid                              |
      | ICB10E92018F911DEB8F793CF9A69A7D8 |

  Scenario Outline: [893361] Verify appellate history
    When the user opens document with guid "<guid>"
    Then the user can verify that the case analysis document is displayed to the user
    And the user can verify the presence of the heading "Appellate History"
    And the user can verify the presence of an option entitled "View Graphical History"
    And the user can verify the presence of the first hearing
    And the user can verify the presence of the case name "OBG Ltd v Allan"
    And the user can verify the presence of the judgment date "2 May 2007"
    And the user can verify the presence of the court "Court of Appeal (Civil Division)"
    And the user can verify the presence of the citation "[2005] EWCA Civ 861"
    And the user can verify the presence of the associated subject data
    And the user can verify the presence of a "Positive" status icon
    And the user can verify the presence of the text "Positive or Neutral Judicial Treatment"
    And the user can verify the presence of the second hearing
    And the user can verify the presence of the case name "OBG Ltd v Allan"
    And the user can verify the presence of the judgment date "9 February 2005"
    And the user can verify the presence of the court "Court of Appeal (Civil Division)"
    And the user can verify the presence of the citation "[2005] EWCA Civ 106"
    And the user can verify the presence of the associated subject data
    And the user can verify the presence of a "Positive" status icon
    And the user can verify the presence of the text "Positive or Neutral Judicial Treatment"
    And the user can verify the presence of the third hearing
    And the user can verify the presence of the case name "OBG Ltd v Allan"
    And the user can verify the presence of the court "Chancery Division (Manchester)"
    And the user can verify the presence of the citation "Unreported"
    And the user can verify the presence of the associated subject data

    Examples:
      | guid                              |
      | ICB10E92018F911DEB8F793CF9A69A7D8 |

  Scenario Outline: [893361] Verify links within appellate history resolve to appropriate destination
    When the user opens document with guid "<guid>"
    Then the user can verify that the case analysis document is displayed to the user
    And the user can select the party name link within the appellate history section
    And the user can verify that the case analysis document for the corresponding case is displayed to the user

    Examples:
      | guid                              |
      | ICB10E92018F911DEB8F793CF9A69A7D8 |

  @manual
  Scenario: [893361] Verify visual representation of appellate history timeline
    And the user runs a free text search for "X"
    When the user opens the case analysis document for result "1"
    Then the user can verify that the case analysis document is displayed to the user
    And the user can verify the presence of the heading "Appellate History"
    And the user can verify a visual representation of the appellate history timeline
