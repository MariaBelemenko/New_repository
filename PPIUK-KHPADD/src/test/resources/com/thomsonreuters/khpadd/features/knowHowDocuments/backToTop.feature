Feature: [730965] As a: website user  I want: to navigate back to the top of the resource  So that: I don’t have to scroll through the resource

  Scenario Outline: Back to top sticky link for <documentType>
    Given PL+ user is logged in
    When user navigates directly to document with guid "<guid>"
    And user scroll down the resource by offset 2500
    Then back to top sticky link is displayed
    And user can navigate to top from anywhere in the document by clicking on the back to top link
  Examples:
    | documentType      | guid                              |
    | Standard Document | Idfa7d588e25211e398db8b09b4f043e0 |
    | Practice Note     | I3351a82be8da11e398db8b09b4f043e0 |
