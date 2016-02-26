Feature: ukWhatsMarketComparisonToolDelivery.feature
  [815685][815692][815714][815248][815245][815246][815247][815705][811160][811159]

  Background: Log on to test site
    Given PL+ user is logged in
    And the user selects the link entitled Whats Market UK Home

  @bug
  Scenario Outline: [815247] Download whats market comparison report
      #850563 logged 26/01/15
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
    And the user selects the download icon on the comparison report page
      # Bug 850563 can prevent the title showing.
    And the user verifies the presence of a pop up entitled 'Download Report'
    And the user verifies the presence of a dropdown entitled Format
    And the user selects the format option entitled "<option>"
    And the user click on download button
    Then the user verifies that 'Preparing For Download' is displayed on the overlay
    And the user verifies that 'Ready For Download' is displayed on the overlay
    And the user verifies 'Download' button is displayed on Ready For Download overlay
  Examples:
    | option                |
    | Microsoft Excel (CSV) |
    | Microsoft Word        |
    | Microsoft Excel (XLS) |

  @bug
  Scenario Outline: [815247] Email whats market comparison report
      #850563 logged 26/01/15
    When the user runs a free text search for the query "law"
    And the user is able to check whether the option to apply filters is displayed and  if not to ensure that it is
    And the user verifies the presence of the whats market facet "Administrations"
    And the user selects the whats market facet "Administrations"
    And the user selects the option to apply filters
    And the user pauses for "3" seconds
    And the user selects the checkbox associated with whats market result "1"
    And the user selects the checkbox associated with whats market result "2"
    And the user selects the checkbox associated with whats market result "3"
    And the user selects the compare button
    And the user verifies the presence of the heading Deal Comparison Report
    And the user ensures that the left hand column select is displayed
    And the user selects the Email icon on the comparison report page
    # Bug 850563 can prevent the title showing.
    And the user verifies the presence of a pop up entitled 'Email Report'
    And the user verifies the presence of a dropdown entitled Format
    And the user selects the format option entitled "<option>"
    And the user selects the Email option
    And the user verifies that 'Ready For Email' is displayed on the overlay
  Examples:
    | option                |
    | Microsoft Excel (CSV) |
    | Microsoft Word        |
    | Microsoft Excel (XLS) |
