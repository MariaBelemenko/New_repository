Feature: ukWhatsMarketDownloadDelivery.feature
  [718904][747925][747924]
  Delivery of know how search results in list and full text format via save

    Background: Log on to test site
    Given PL+ user is logged in with following details
    | userName | Search2_AutoUser |
    And the user selects the link entitled Whats Market UK Home

    Scenario: Basic search result download delivery pop up - layout
    When the user runs a free text search for the query "deal"
    And the user selects the checkbox associated with whats market result "1"
    And the user selects the checkbox associated with whats market result "2"
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
    And the user verifies the presence of a dropdown option entitled As
    And the user verifies the presence of an option entitled "A Single Merged File"
    And the user verifies the presence of an option entitled "Multiple Files"

    Scenario: [747924] Advanced search result download delivery pop up - layout
    When the user runs a free text search for the query "deal"
    And the user selects the checkbox associated with whats market result "1"
    And the user selects the checkbox associated with whats market result "2"
    And the user selects the download delivery option
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

    Scenario Outline: [747924] download list of know how search results from basic tab in list format (various document formats)
    When the user runs a free text search for the query "contract"
    And the user selects the checkbox associated with whats market result "1"
    And the user selects the checkbox associated with whats market result "2"
    And the user selects the download delivery option
    And the user verifies the presence of a pop up entitled Download Documents
    And the user selects the list of items option
    And the user selects the list of items format option "<format>"
    And the user selects the Download option
    And the user verifies that the request is processed and a message displayed that the items are ready to download
    Examples:
    | format                |
    | Microsoft Word        |
    | Word Processor (RTF)  |
    | PDF                   |
    | Microsoft Excel (CSV) |

    Scenario Outline: [747924] download list of WM search results from basic tab in document format (various document formats)
    When the user runs a free text search for the query "contract"
    And the user selects the checkbox associated with whats market result "1"
    And the user selects the checkbox associated with whats market result "2"
    And the user selects the download delivery option
    And the user verifies the presence of a pop up entitled Download Documents
    And the user selects the Documents option
    And the user selects the documents format option "<format>"
    And the user selects the Download option
    And the user verifies that the request is processed and a message displayed that the items are ready to download
    Examples:
    | format               |
    | Microsoft Word       |
    | Word Processor (RTF) |
    | PDF                  |

    Scenario Outline: [no story] download delivery where only 1 checkbox selected - to deliver in document format only
    When the user runs a free text search for the query "contract"
    And the user selects the checkbox associated with whats market result "1"
    And the user selects the download delivery option
    And the user verifies that a pop up entitled Download This Document is displayed to the user
    And the user selects the documents format option "<format>"
    And the user selects the Download option
    And the user verifies that the single request is processed and a message displayed that the items are ready to download
    Examples:
      | format               |
      | Microsoft Word       |
      | Word Processor (RTF) |
      | PDF                  |