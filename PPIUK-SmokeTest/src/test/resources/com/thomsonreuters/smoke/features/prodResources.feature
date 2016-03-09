Feature: Verify resources: Glossary/What's Market/Ask

  Scenario: Glossary and glossary search
    Given PL+ user is logged in
    When user navigates to a glossary page
    And searches for the term "garden leave" using the glossary search
    Then the user should be able to see a list of resulting glossary terms containing this search term "garden leave"
    And the first result item's definition should be displayed in the right hand pane

  Scenario: What's Market - compare deals
    Given PL+ user is logged in with following details
      | userName | Search2_AutoUser |
    When the user selects the link entitled Whats Market UK Home
    And has selected the link to the deal type "Administrations"
    And the user selects the checkbox associated with whats market result "1"
    And the user selects the checkbox associated with whats market result "2"
    And the user selects the compare button
    And the user verifies the presence of the heading Deal Comparison Report
    And the user verifies the presence of a column entitled "Deal"

  Scenario: Verify browsing within Ask
    Given PL+ user is logged in
    When the user clicks on the resources tab on the home page
    And the user clicks on "Ask" link
    And user clicks on the "Construction" Practice Area Link
    And the user clicks 'Recent queries' tab
    Then the user verifies that at least '5' recent questions are displayed
    And the user verifies that queries are sorted by 'Posted date' by descending order
    And the user clicks 'Featured queries' tab
    When the user clicks featured query no 1
    Then resource type is displayed as "Ask" on right hand panel
    And ask disclaimer is displayed on the document

  @CloseAskWindow
  Scenario: Verify Ask form
    Given PL+ user is logged in
    And the user navigates to the main PLCUK page
    When the user clicks on 'Ask a question' link to ask a question
    And ASK form is displayed in new window
    And the user accepts ASK disclaimer terms
    Then the following fields are displayed on the form
      | Question          |
      | Document Id       |
      | First Name        |
      | Last Name         |
      | Email             |
      | Organisation Type |
      | Position          |
      | Jurisdiction      |
      | Answering Service |
    And user closes the ASK window
