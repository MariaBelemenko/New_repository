Feature: [747922][747921][702205] ukKnowHowDeliveryDownload.feature
  Delivery of know how search results in list and full text format via print, save and email

  Background: Log on to test site
    Given PL+ user is logged in

  Scenario: [747922] Basic search result download delivery pop up - layout
    When the user runs a free text search for the query "contract of sale"
    And the user selects the checkbox associated with result "1"
    And the user selects the checkbox associated with result "2"
    And the user selects the download delivery option
    And the user verifies the presence of a pop up entitled Download Documents
    And the user verifies the presence of a basic tab
    And the user verifies that the basic option is selected by default
    And the user verifies the presence of an option entitled List of Items
    And the user verifies the presence of an option on the pop up entitled Documents
    And the user selects the list of items option
    And the user verifies the presence of a list of items dropdown option entitled Format
    And the user verifies the presence of a list of items format option entitled
      | formatOption    |
      | Microsoft Word  |
      | Word Processor  |
      | PDF             |
      | Microsoft Excel |
    And the user verifies the presence of a Download option
    And the user verifies the presence of a Cancel option
    And the user selects the Documents option
    And the user verifies the presence of a checkbox for inclusion of table of contents
    And the user verifies the presence of a dropdown option entitled As
    And the user verifies the presence of an option entitled "A Single Merged File"
    And the user verifies the presence of an option entitled "Multiple Files"

  Scenario: [747922] Advanced search result download delivery pop up - layout
    When the user runs a free text search for the query "contract of sale"
    And the user selects the checkbox associated with result "1"
    And the user selects the checkbox associated with result "2"
    And the user selects the download delivery option
    And the user pauses for "3" seconds
    And the user verifies the presence of a pop up entitled Download Documents
    And the user selects the option entitled documents
    And the user selects the link to the advanced tab
    And the user verifies the presence of an option entitled Term Highlighting
    And the user verifies that the option entitled Term Highlighting is selected by default
    And the user verifies the presence of an option entitled Expanded Margin for Notes
    And the user verifies the presence of an option entitled Cover Page
    And the user selects the option entitled Cover Page
    And the user verifies the presence of a field entitled Cover Page Note
    And the user verifies the presence of a dropdown entitled Font Size
    And the user verifies the presence of a font sub option "Large"
    And the user verifies the presence of a font sub option "Normal"
    And the user verifies the presence of a dropdown entitled Links
    And the user verifies the presence of a links sub option "Blue"
    And the user verifies the presence of a links sub option "Black"
    And the user verifies the presence of a checkbox entitled Underline
    And the user verifies the presence of a Download option
    And the user verifies the presence of a Cancel option
    And the user selects the Basic tab
    And the user selects the list of items option
    And the user selects the advanced tab
    And the user verifies that the option entitled Expanded Margin for Notes is no longer present

  Scenario: [747922] download list of know how search results from basic tab in list format (various document formats)
    When the user searches for "contract for sale"
    And the user selects the checkbox associated with result "1"
    And the user selects the checkbox associated with result "2"
    And the user downloads as list_of_items and verifies the processed message for successful downloads
    | Microsoft Word        |
    | Word Processor (RTF)  |
    | PDF                   |
    | Microsoft Excel (CSV) |

  Scenario: [747922] download list of know how search results from basic tab in document format (various document formats)
    When the user runs a free text search for the query "contract"
    And the user selects the checkbox associated with result "1"
    And the user selects the checkbox associated with result "2"
    And the user downloads as Documents and verifies the processed message for successful downloads
    | Microsoft Word       |
    | Word Processor (RTF) |
    | PDF                  |
