Feature: Ability to Verify Links in Resource History

  @e2e @prod
  Scenario Outline: Verify Legal Update on Development Link in Resource History
    Given PL+ user 'FFHUser3' navigates directly to document with guid '<GUID>'
    When the user clicks on the R.H.S Actions sub-link "View Resource History" link
    Then it should take user to the Resource History section at the bottom of the page
    When the user expands the resource history section by clicking "View All" link and then clicking on "<Resource History Section>" link
    Then it should take user to the corresponding link
  Examples:
    | Resource History Section            | GUID                              |
    | Further developments                | Id5a1824b18d111e498db8b09b4f043e0 |
    | What are the pensions implications? | Id5a1824b18d111e498db8b09b4f043e0 |