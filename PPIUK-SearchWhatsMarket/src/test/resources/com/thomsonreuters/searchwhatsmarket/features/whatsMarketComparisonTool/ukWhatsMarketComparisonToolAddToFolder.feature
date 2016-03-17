Feature: ukWhatsMarketComparisonToolAddToFolder.feature
  [815685][815692][815714][815248][815245][815246][815247][815705][811160][811159]

  Scenario Outline: [815247] Add WM comparison report to folder
    Given PL+ user is logged in
    And the user clicks on 'Folders' link on the header
    And the user deletes the folder "<folderName>" if it exists
    And the user clicks the TR Practical Law logo
    And the user selects the link entitled Whats Market UK Home
    When the user runs a free text search for the query "law"
    And the user is able to check whether the option to apply filters is displayed and  if not to ensure that it is
    And the user verifies the presence of the whats market facet "Administrations"
    And the user selects the whats market facet "Administrations"
    And the user selects the option to apply filters
    And the user selects the checkbox associated with whats market result "1"
    And the user selects the checkbox associated with whats market result "2"
    And the user selects the checkbox associated with whats market result "3"
    And the user selects the compare button
    And the user verifies the presence of the heading Deal Comparison Report
    And the user ensures that the left hand column select is displayed
    # If this test fails here it could be screen size if the icon is rendered off screen to the right
    And the user adds whats market deal comparison report to new "<folderName>" folder with parent folder "root"
    And the user clicks on 'Folders' link on the header
    Then the folder "<folderName>" appears in the "root" folder
    And the user verifies the whats market deal comparison report is present in the "<folderName>" folder
  Examples:
    | folderName |
    | WMDeals    |