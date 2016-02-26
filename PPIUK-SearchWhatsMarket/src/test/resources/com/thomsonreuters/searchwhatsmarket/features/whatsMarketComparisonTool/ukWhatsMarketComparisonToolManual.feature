@manual
Feature:  ukWhatsMarketComparisonToolManual.feature
  [815685][815692][815714][815248][815245][815246][815247][815705][811160][811159]

  Background: Log on to test site
    Given PL+ user is logged in
    And the user selects the link entitled Whats Market UK Home

  @manual
  Scenario: [815247] Download whats market comparison report and verify format
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
    And the user selects the download icon on the comparison report page
      # Bug 850563 can prevent the title showing.
    And the user verifies the presence of a pop up entitled 'Download Report'
    And the user verifies the presence of a dropdown entitled Format
    And the user selects the format option entitled "<option>"
    And the user selects the download icon on the comparison report page
    Then the user verifies that 'Preparing For Download' is displayed on the overlay
    And the user verifies that 'Ready For Download' is displayed on the overlay
    And the user clicks download on ready to download overlay
    And the user downloads the file and verifies that it is correctly formatted

  @manual
  Scenario: [815247] Email whats market comparison report and verify format
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
    And the user selects the Email icon on the comparison report page
      # Bug 850563 can prevent the title showing.
    And the user verifies the presence of a pop up entitled 'Email Report'
    And the user verifies the presence of a dropdown entitled Format
    And the user selects the format option entitled "<option>"
    And the user selects the Email option
    And the user verifies that 'Ready For Email' is displayed on the overlay
    And the user emails the file and verifies that it is correctly formatted

  @manual
  Scenario: [815246] verify user can drag and drop rows in the comparison report
    Given the user is on the WM comparison page,
    And the user is presented with the deal comparison report
    When the user clicks on a row in the table
    Then the user should be to drag and drop the row above or below the other rows in the table

  @manual
  Scenario: [815245] verify user can change the order of the items in the report using drag and drop in the the organise columns tool
    Given the user is on the WM comparison page
    And the user is presented with the deal comparison report
    When the user clicks on 'Organise Columns' button
    Then the user should be presented with a dialogue box with the list of columns
    And the user should be able to change the order of the columns using drag and drop with their mouse

  @manual
  Scenario: [815714] verify user can scroll through the list of comparison terms
    Given the 'Comparison Terms' selector is open
    And the user is presented with the list of comparison terms
    When the user clicks on the scrollbar
    Then the user should have the ability to scroll through the comparison terms

  @manual
  Scenario: [815714] - verify user can use scrolling wheel to scroll through list of comparison terms
    Given the 'Comparison Terms' selector is open
    And the user is presented with the list of comparison terms
    When the user hovers their cursor over the comparison terms selector
    Then the user should have the ability to scroll through the comparison terms using their scrolling wheel on their mouse.
