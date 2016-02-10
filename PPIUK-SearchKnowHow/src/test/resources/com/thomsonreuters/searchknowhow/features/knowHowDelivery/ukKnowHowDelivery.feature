Feature: [747922][747921][702205] ukKnowHowDelivery.feature
  Delivery of know how search results in list and full text format via print, save and email

  Background: Log on to test site
    Given PL+ user is logged in with following details
      | userName | Search2_AutoUser |

  Scenario: [747922] Basic search result download delivery pop up - layout
    When the user runs a free text search for the query "contract of sale"
    And the user selects the checkbox associated with result "1"
    And the user selects the checkbox associated with result "2"
    And the user selects the download delivery option
    And the user pauses for "3" seconds
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

  Scenario Outline: [747922] download list of know how search results from basic tab in list format (various document formats)
    When the user runs a free text search for the query "contract for sale"
    And the user selects the checkbox associated with result "1"
    And the user selects the checkbox associated with result "2"
    And the user selects the download delivery option
    And the user pauses for "3" seconds
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

  Scenario Outline: [747922] download list of know how search results from basic tab in document format (various document formats)
    When the user runs a free text search for the query "contract"
    And the user selects the checkbox associated with result "1"
    And the user selects the checkbox associated with result "2"
    And the user selects the download delivery option
    And the user pauses for "3" seconds
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

  Scenario: [747921] Basic search result email delivery pop up - layout
    When the user runs a free text search for the query "contract"
    And the user selects the checkbox associated with result "1"
    And the user selects the checkbox associated with result "2"
    And the user selects the email delivery option
    And the user pauses for "3" seconds
    And the user verifies the presence of a pop up entitled Email Documents
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
    And the user pauses for "3" seconds
    And the user verifies the presence of a pop up entitled Email Documents
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
    When the user runs a free text search for the query "contract"
    And the user selects the checkbox associated with result "1"
    And the user selects the checkbox associated with result "2"
    And the user selects the email delivery option
    And the user pauses for "3" seconds
    And the user verifies the presence of a pop up entitled Email Documents
    And the user selects the list of items option
    And the user selects the list of items format option "<format>"
    And the user sets up a Mailinator e-mail with the name "stephtestemail"
    And the user enters "stephtestemail@mailinator.com" into the email To field
    And the user enters "delivery test" into the email Subject field
    And the user enters "This is a test" into the email note field
    And the user selects the Email option
    And the user pauses for "60" seconds
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
    When the user runs a free text search for the query "contract"
    And the user selects the checkbox associated with result "1"
    And the user selects the checkbox associated with result "2"
    And the user selects the email delivery option
    And the user pauses for "3" seconds
    And the user verifies the presence of a pop up entitled Email Documents
    And the user selects the option entitled documents
    And the user selects the documents format option "<format>"
    And the user sets up a Mailinator e-mail with the name "stephtestemail"
    And the user enters "stephtestemail@mailinator.com" into the email To field
    And the user enters "delivery test" into the email Subject field
    And the user enters "This is a test" into the email note field
    And the user selects the Email option
    And the user pauses for "60" seconds
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

  @manual
  Scenario: [702205] print list of know how search results from basic tab in list format
    When the user runs a free text search for the query "contract"
    And the user selects the checkbox associated with result "1"
    And the user selects the checkbox associated with result "2"
    And the user selects the print delivery option
    And the user pauses for "3" seconds
    And the user selects the print option
    And the user verifies the presence of a pop up entitled Print Documents
    And the user selects the list of items option
    And the user selects the print option
    And the user verifies that the request is processed and the document printed
    And the user verifies the format of the printed list

  @manual
  Scenario: [702205] print list of know how search results from basic tab in document format
    When the user runs a free text search for the query "contract"
    And the user selects the checkbox associated with result "1"
    And the user selects the checkbox associated with result "2"
    And the user selects the print delivery option
    And the user pauses for "3" seconds
    And the user selects the print option
    And the user verifies the presence of a pop up entitled Print Documents
    And the user selects the option entitled documents
    And the user selects the print option
    And the user verifies that the request is processed and the document printed
    And the user verifies the format of the printed document

  @manual
  Scenario: [no story] download delivery with and without table of contents
    When the user runs a free text search for the query "contract"
    And the user selects the checkbox associated with result "1"
    And the user selects the checkbox associated with result "2"
    And the user selects the download delivery option
    And the user pauses for "3" seconds
    And the user selects the documents option
    And the user selects the option to include a table of contents
    And the user selects the list of items format option "PDF"
    And the user selects the Download option
    And the user verifies that the delivered version contains the table of contents
    And the user selects the download delivery option
    And the user selects the documents option
    And the user deselects the option to include a table of contents
    And the user selects the list of items format option "PDF"
    And the user selects the Download option
    And the user verifies that the delivered version does not contain a table of contents

  @manual
  Scenario: [no story] download delivery (single result only) with and without annotations
    When the user runs a free text search for the query "contract"
    And the user waits for the results to load
    And the user opens the first result
    And the user selects a portion of the text and adds highlighting using the highlight tool
    And the user selects a portion of the text and adds a note using the add a note tool
    And the user selects the Return to List option
    And the user selects the checkbox associated with result "1"
    And the user selects the download delivery option
    And the user pauses for "3" seconds
    And the user selects the documents format option "Microsoft Word"
    And the user selects the option to include annotations
    And the user selects the Download option
    And the user verifies that the document is downloaded
    And the user verifies that the downloaded document includes the highlighting
    And the user verifies that the downloaded document includes the note
    And the user selects the download delivery option
    And the user ensures that the option to include annotations is not selected
    And the user selects the Download option
    And the user verifies that the document is downloaded
    And the user verifies that the downloaded document does not include the highlighting
    And the user verifies that the downloaded document does not include the note

  @manual
  Scenario: [no story] download delivery (2 results) with and without annotations
    When the user runs a free text search for the query "contract"
    And the user waits for the results to load
    And the user opens the first result
    And the user selects a portion of the text and adds highlighting using the highlight tool
    And the user selects a portion of the text and adds a note using the add a note tool
    And the user selects the Return to List option
    And the user selects the checkbox associated with result "1"
    And the user selects the checkbox associated with result "2"
    And the user selects the download delivery option
    And the user pauses for "3" seconds
    And the user selects the Documents option
    And the user selects the documents format option "Microsoft Word"
    And the user selects the option to include annotations
    And the user selects the Download option
    And the user verifies that the document is downloaded
    And the user verifies that the downloaded document includes the highlighting
    And the user verifies that the downloaded document includes the note
    And the user selects the download delivery option
    And the user ensures that the option to include annotations is not selected
    And the user selects the Download option
    And the user verifies that the document is downloaded
    And the user verifies that the downloaded document does not include the highlighting
    And the user verifies that the downloaded document does not include the note

  @manual
  Scenario: [no specific story] Verify cover sheet functionality
    When the user runs a free text search for the query "contract"
    And the user waits for the results to load
    And the user selects the checkboxes associated with the first two results on the result list
    And the user selects the download option
    And the user pauses for "3" seconds
    And the user selects List of Items
    And the user selects the advanced tab
    And the user selects the cover page option
    And the user enters the text "test" into the accompanying field
    And the user selects the download option
    And the user verifies that the downloaded version includes a cover sheet containing the specified text

  @bug @manual
  Scenario: [no specific story] Verify links within delivered document resolve to correct destination
    #804040
    When the user runs a free text search for the query "contract"
    And the user waits for the results to load
    And the user selects the checkboxes associated with the first two results on the result list
    And the user selects the download option
    And the user pauses for "3" seconds
    And the user selects List of Items
    And the user selects the download option
    And the user verifies that the links within the delivered document resolve to the correct destination
