Feature: [747922][747921][702205] ukKnowHowDelivery.feature
  Delivery of know how search results in list and full text format via print, save and email

  Background: Log on to test site
    Given PL+ user is logged in with following details
      | userName | Search2_AutoUser |

  Scenario: [702205] Basic search result print delivery pop up - layout
    When the user runs a free text search for the query "contract"
    And the user selects the checkbox associated with result "1"
    And the user selects the checkbox associated with result "2"
    And the user selects the print delivery option
    And the user pauses for "3" seconds
    And the user verifies the presence of a pop up entitled Print Documents
    And the user verifies the presence of a basic tab
    And the user verifies that the basic option is selected by default
    And the user verifies the presence of an option entitled List of Items
    And the user verifies the presence of an option on the pop up entitled Documents
    And the user verifies the presence of an option entitled List of Items
    And the user selects the list of items option
    And the user verifies the presence of a Print option
    And the user verifies the presence of a Cancel option

  Scenario: [702205] Advanced search result print delivery pop up - layout
    When the user runs a free text search for the query "contract"
    And the user selects the checkbox associated with result "1"
    And the user selects the checkbox associated with result "2"
    And the user selects the print delivery option
    And the user pauses for "3" seconds
    And the user verifies the presence of a pop up entitled Print Documents
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
    And the user verifies the presence of a Print option
    And the user verifies the presence of a Cancel option
    And the user selects the Basic tab
    And the user selects the list of items option
    And the user selects the advanced tab
    And the user verifies that the option entitled Expanded Margin for Notes is no longer present

  @wip
  Scenario: [702205] validate print dialog for search results
    #not able to automate actual printing
    When the user runs a free text search for the query "contract"
    And the user selects the checkbox associated with result "1"
    And the user selects the checkbox associated with result "2"
    And the user selects the print delivery option
    And the user pauses for "3" seconds
    And the user verifies the presence of a pop up entitled Print Documents
    And the user verifies the presence of an option entitled List of Items
    And the user verifies the presence of an option on the pop up entitled Documents
    And the user verifies the presence of the Print delivery request button
    And the user checks the attribute for the print dialog
    And the user selects the print cancel option

  @bug
  Scenario Outline: [no story] download delivery where only 1 checkbox selected - to deliver in document format only
    #850541 - REGRESSION - ask document contains no reply although response text does appear within terms in context
    #logged 26/01/16
    When the user runs a free text search for the query "contract"
    And the user selects the checkbox associated with result "1"
    And the user selects the download delivery option
    And the user pauses for "3" seconds
    And the user verifies that a pop up entitled Download This Document is displayed to the user
    And the user selects the documents format option "<format>"
    And the user selects the Download option
    And the user verifies that the single request is processed and a message displayed that the items are ready to download
    Examples:
      | format               |
      | Microsoft Word       |
      | Word Processor (RTF) |
      | PDF                  |
