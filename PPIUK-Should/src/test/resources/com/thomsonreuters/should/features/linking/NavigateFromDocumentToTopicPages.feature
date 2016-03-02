Feature: Navigate from Also Found In section within documents to topic pages

  Scenario Outline: Links to related Topics within Also Found in section of documents
    Given PL+ user is logged in
    When the user runs a free text search for the query "<query>"
    And the user opens the result in position "1"
    And the user verifies the presence of the Also Found In heading
    And the user verifies the presence of a link entitled "<link>"
    And the user validates that the left hand table of contents is displayed
    And the user selects the link entitled "<link>"
    And the user verifies that the topic page entitled "<topic>" is displayed to the user
  Examples:
    | query                     | link                  | topic                 |
    | Overview of cybersecurity | Internet              | Internet              |
    | Waste offences            | Waste                 | Waste                 |
    | Consumer credit resources | Consumer Credit       | Consumer Credit       |
   