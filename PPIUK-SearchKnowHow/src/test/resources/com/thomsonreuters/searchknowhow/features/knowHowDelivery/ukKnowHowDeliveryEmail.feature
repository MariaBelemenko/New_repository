Feature: [747922][747921][702205] ukKnowHowDelivery.feature
  Delivery of know how search results in list and full text format via print, save and email

  Background: Log on to test site
    Given PL+ user is logged in

  Scenario: [747921] Basic search result email delivery pop up - layout
    When the user searches for "contract"
    And the user selects the checkbox associated with result "1"
    And the user selects the checkbox associated with result "2"
    And the user selects the email delivery option
    #SHOULD bug 850563
    #And the user verifies the presence of a pop up entitled Email Documents
    And the user verifies the presence of a basic tab
    And the user verifies that the basic option is selected by default
    And the user verifies the presence of an option entitled List of Items
    And the user verifies the presence of an option on the pop up entitled Documents
    And the user selects the list of items option
    And the user verifies the presence of a field entitled To
    And the user verifies the presence of a field entitled Subject
    And the user verifies the presence of a field entitled Email Note
    And the user verifies the presence of a list of items dropdown option entitled Format
    And the user verifies the presence of a list of items format option entitled
      | formatOption    |
      | Microsoft Word  |
      | Word Processor  |
      | PDF             |
      | Microsoft Excel |
    And the user verifies the presence of an Email option
    And the user verifies the presence of a Cancel option
    And the user selects the Documents option
    And the user verifies the presence of a checkbox for inclusion of table of contents
    And the user verifies the presence of a dropdown option entitled As
    And the user verifies the presence of an As option entitled "A Single Merged File"
    And the user verifies the presence of an As option entitled "Multiple Files"

  Scenario: [747921] Advanced search result email delivery pop up - layout
    When the user runs a free text search for the query "contract"
    And the user selects the checkbox associated with result "1"
    And the user selects the checkbox associated with result "2"
    And the user selects the email delivery option
    #SHOULD bug 850563
    #And the user verifies the presence of a pop up entitled Email Documents
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
    And the user verifies the presence of an Email option
    And the user verifies the presence of a Cancel option
    And the user selects the Basic tab
    And the user selects the list of items option
    And the user selects the advanced tab
    And the user verifies that the option entitled Expanded Margin for Notes is no longer present

  Scenario Outline: [747921] email list of know how search results from basic tab in list format (various document formats)
    When the user searches for "contract"
    And the user selects the checkbox associated with result "1"
    And the user selects the checkbox associated with result "2"
    And the user selects the email delivery option
    #SHOULD bug 850563
    #And the user verifies the presence of a pop up entitled Email Documents
    And the user selects the list of items option
    And the user selects the list of items format option "<format>"
    And the user sets up a Mailinator e-mail with the name "stephtestemail"
    And the user enters "stephtestemail@mailinator.com" into the email To field
    And the user enters "delivery test" into the email Subject field
    And the user enters "This is a test" into the email note field
    And the user selects the Email option
    And the user refreshes the Mailinator e-mail page
    And the user validates that there's at least "1" e-mail on Mailinator
    And the user validates that the most recent Mailinator e-mail contains the subject "delivery test"
    And the user clicks the most recent e-mail on Mailinator
    And the user validates that the Mailinator e-mail is displayed as being to "stephtestemail"
    And the user validates that the Mailinator e-mail is displayed with a subject of "delivery test"
    And the user validates that the Mailinator e-mail contains the text "This is a test"
  Examples:
    | format                |
    | Microsoft Word        |
    | Word Processor (RTF)  |
    | PDF                   |
    | Microsoft Excel (CSV) |

  Scenario Outline: [747921] email list of know how search results from basic tab in document format (various document formats)
    When the user searches for "contract"
    And the user selects the checkbox associated with result "1"
    And the user selects the checkbox associated with result "2"
    And the user selects the email delivery option
    #SHOULD BUG 850563
    #And the user verifies the presence of a pop up entitled Email Documents
    And the user selects the option entitled documents
    And the user selects the documents format option "<format>"
    And the user sets up a Mailinator e-mail with the name "stephtestemail"
    And the user enters "stephtestemail@mailinator.com" into the email To field
    And the user enters "delivery test" into the email Subject field
    And the user enters "This is a test" into the email note field
    And the user selects the Email option
    And the user refreshes the Mailinator e-mail page
    And the user validates that there's at least "1" e-mail on Mailinator
    And the user validates that the most recent Mailinator e-mail contains the subject "delivery test"
    And the user clicks the most recent e-mail on Mailinator
    And the user validates that the Mailinator e-mail is displayed as being to "stephtestemail"
    And the user validates that the Mailinator e-mail is displayed with a subject of "delivery test"
    And the user validates that the Mailinator e-mail contains the text "This is a test"
  Examples:
    | format               |
    | Microsoft Word       |
    | Word Processor (RTF) |
    | PDF                  |
