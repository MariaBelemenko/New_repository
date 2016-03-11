Feature: [752714] Not logged in user cannot use delivery options

  Scenario: [752714] As a Not logged in user I want to not be able to to use delivery options on document page
    Given PL+ user is not logged in
    When he is viewing a free document "/Document/I7ab265477b3d11e498db8b09b4f043e0/View/FullText.html"
    Then he does not see in the document page any link related to delivery options (email, download, print)
    And he is not able to use these features on document page

  Scenario: [752714] As a Not logged in user I want to not be able to to use delivery options on search page
    Given PL+ user is not logged in
    When the user navigates to the main PLCUK page
    And he does a search "tax"
    Then he does not see in the search results page any link related to delivery options (email, download, print)
    And he is not able to use these features on search page

  Scenario: [752714] As a Not logged in user I want to not be able to to use delivery options on legal updates results page
    Given PL+ user is not logged in
    Given a user is on a legal updates results page "/Browse/Home/Resources/LegalUpdates/UKMediaTelecomsLegalUpdates"
    Then he does not see on a legal updates results page any link related to delivery options (email, download, print)
    And he is not able to use these features on legal updates results page
