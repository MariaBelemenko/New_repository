@manual
Feature: [747922][747921][702205] ukKnowHowDeliveryManual.feature
  Delivery of know how search results in list and full text format via print, save and email

  Background: Log on to test site
    Given PL+ user is logged in

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

  @bug
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
