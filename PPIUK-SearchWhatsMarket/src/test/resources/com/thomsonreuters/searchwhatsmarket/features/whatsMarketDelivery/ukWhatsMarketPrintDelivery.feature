Feature: [718904][747925][747924] ukWhatsMarketDelivery.feature
  Delivery of know how search results in list and full text format via print, save and email

  Background: Log on to test site
    Given PL+ user is logged in with following details
      | userName | Search2_AutoUser |
    And the user selects the link entitled Whats Market UK Home

  Scenario: [718904] Basic search result print delivery pop up - layout
    When the user runs a free text search for the query "deal"
    And the user selects the checkbox associated with whats market result "1"
    And the user selects the checkbox associated with whats market result "2"
    And the user selects the print delivery option
    And the user verifies the presence of a pop up entitled Print Documents
    And the user verifies the presence of a basic tab
    And the user verifies that the basic option is selected by default
    And the user verifies the presence of an option entitled List of Items
    And the user verifies the presence of an option on the pop up entitled Documents
    And the user verifies the presence of an option entitled List of Items
    And the user selects the list of items option
    And the user verifies the presence of a Print option
    And the user verifies the presence of a Cancel option

  Scenario: [718904] Advanced search result print delivery pop up - layout
    When the user runs a free text search for the query "contract"
    And the user selects the checkbox associated with whats market result "1"
    And the user selects the checkbox associated with whats market result "2"
    And the user selects the print delivery option
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
  Scenario: [718904] validate print dialog for WM search results
    #not able to automate actual printing
    When the user runs a free text search for the query "contract"
    And the user selects the checkbox associated with whats market result "1"
    And the user selects the checkbox associated with whats market result "2"
    And the user selects the print delivery option
    And the user verifies the presence of a pop up entitled Print Documents
    And the user verifies the presence of an option entitled List of Items
    And the user verifies the presence of an option on the pop up entitled Documents
    And the user verifies the presence of the Print delivery request button
    And the user checks the attribute for the print dialog
    And the user selects the print cancel option

