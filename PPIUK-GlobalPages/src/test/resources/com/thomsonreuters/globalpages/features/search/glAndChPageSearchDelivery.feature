Feature: [838717][839947] As a PL+ User, I want to download the document from global search result page
  Delivery of global search results in list and full text format via print, save and email

  Background:
    Given PL+ user is logged in with following details
      | userName | GlPage_UKUS1 |
    And the user navigates to the main PLCUK page

  Scenario Outline: [838717] [839947] Basic search result download delivery pop up - layout
    When the user selects "International" tab and clicks on "<link>" link in "International subscriptions" section
    Then the Category Page opens correctly
    When the user runs a free text search for the query "tax"
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
    And the user verifies the presence of a dropdown option entitled As
    And the user verifies the presence of an option entitled "A Single Merged File"
    And the user verifies the presence of an option entitled "Multiple Files"
  Examples:
    | link   |
    | Global |
    | China  |

  Scenario Outline: [838717][839947] Basic search result email delivery pop up - layout
    When the user selects "International" tab and clicks on "<link>" link in "International subscriptions" section
    Then the Category Page opens correctly
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
  Examples:
    | link   |
    | Global |
    | China  |

  Scenario Outline: [838717][839947] Basic search result print delivery pop up - layout
    When the user selects "International" tab and clicks on "<link>" link in "International subscriptions" section
    Then the Category Page opens correctly
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
  Examples:
    | link   |
    | Global |
    | China  |

  Scenario Outline: [838717] The user download pdf document in pdf extention
    When the user selects "International" tab and clicks on "<link>" link in "International subscriptions" section
    Then the Category Page opens correctly
    When the user runs a free text search for the query "contract of sale"
    And the user selects the checkbox associated with result "1"
    And the user selects the download delivery option
  Examples:
    | link   |
    | Global |
    | China  |
