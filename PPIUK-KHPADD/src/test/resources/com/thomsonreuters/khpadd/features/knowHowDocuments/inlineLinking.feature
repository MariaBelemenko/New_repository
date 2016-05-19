@e2e @prod @e2eprod
Feature: E2E Inline Linking

  Background:
    Given PL+ user 'KHPaddUser4' searches for 'section 110 liquidation'
    When the user clicks on the first link in results
    Then document title is displayed as "Section 110 liquidation schemes: step-by-step process"
    And resource type is displayed as "Practice notes" on right hand panel

  Scenario: Verify Link to the Same Document
    When the user clicks on 'Step 5: Liquidator transfers assets to Newcos' link in table of contents
    Then it should take user to the corresponding link

  Scenario: Verify Link to the Other Document, verify Link to the point on the other document page
    When the user clicks on 'hive up' link in 'Step 2: Intra-group asset transfer from Holdco to Topco' section of the document
    Then the glossary modal pop up box opens with the title "hive up"
    When the user selects the "Close" icon at the top right of the modal window
    Then the modal closes and returns the user to the document view
    When the user clicks on 'Documenting an asset purchase' link in 'Step 2: Intra-group asset transfer from Holdco to Topco' section of the document
    Then scrolled heading "Documenting an asset purchase" is displayed on the sticky bar
    When the user clicks Back button in browser '1' times
    Then scrolled heading "Step 3: General meeting to approve the section 110 scheme" is displayed on the sticky bar

  Scenario: Verify Link to the External Document in new Tab
    When the user searches for "Tax fraud and evasion"
    And the user clicks on result with title "Tax fraud and evasion: Council calls for global system of automatic exchange of information"
    Then document title is displayed as "Tax fraud and evasion: Council calls for global system of automatic exchange of information"
    And resource type is displayed as "Legal update: archive" on right hand panel
    When the user clicks on any link with text 'Action Plan'
    Then new Tab/Windows is displayed
