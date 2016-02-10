  Feature: [718904][747925][747924] ukWhatsMarketDelivery.feature
  Delivery of know how search results in list and full text format via print, save and email


  @manual
    Scenario: [718904] print list of WM search results from basic tab in list format
    When the user runs a free text search for the query "contract"
    And the user selects the checkbox associated with whats market result "1"
    And the user selects the checkbox associated with whats market result "2"
    And the user selects the print delivery option
    And the user selects the print option
    And the user verifies the presence of a pop up entitled Print Documents
    And the user selects the list of items option
    And the user selects the print option
    And the user verifies that the request is processed and the document printed
    And the user verifies the format of the printed list

    @manual
    Scenario: [718904] print list of WM search results from basic tab in document format
    When the user runs a free text search for the query "contract"
    And the user selects the checkbox associated with whats market result "1"
    And the user selects the checkbox associated with whats market result "2"
    And the user selects the print delivery option
    And the user selects the print option
    And the user verifies the presence of a pop up entitled Print Documents
    And the user selects the option entitled documents
    And the user selects the print option
    And the user verifies that the request is processed and the document printed
    And the user verifies the format of the printed document



    @manual
    Scenario: [no story] download delivery (single result only) with and without annotations
    When the user runs a free text search for the query "contract"
    And the user opens the first result
    And the user selects a portion of the text and adds highlighting using the highlight tool
    And the user selects a portion of the text and adds a note using the add a note tool
    And the user selects the Return to List option
    And the user selects the checkbox associated with whats market result "1"
    And the user selects the download delivery option
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
    And the user opens the first result
    And the user selects a portion of the text and adds highlighting using the highlight tool
    And the user selects a portion of the text and adds a note using the add a note tool
    And the user selects the Return to List option
    And the user selects the checkbox associated with whats market result "1"
    And the user selects the download delivery option
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
    And the user selects the checkbox associated with whats market result "1"
    And the user selects the checkbox associated with whats market result "2"
    And the user selects the download option
    And the user selects List of Items
    And the user selects the advanced tab
    And the user selects the cover page option
    And the user enters the text "test" into the accompanying field
    And the user selects the download option
    And the user verifies that the downloaded version includes a cover sheet containing the specified text

    @manual @bug
    Scenario: [no specific story] Verify links within delivered document resolve to correct destination
        #804040
    When the user runs a free text search for the query "contract"
    And the user selects the checkbox associated with whats market result "1"
    And the user selects the checkbox associated with whats market result "2"
    And the user selects the download option
    And the user selects List of Items
    And the user selects the download option
    And the user verifies that the links within the delivered document resolve to the correct destination