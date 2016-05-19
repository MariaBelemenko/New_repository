@should
Feature: [816738] Navigate from Topics sections (previously Also Found In) section within documents to topic pages

  # 860453:REGRESSION - topic information missing from know how resources
  # 885342:[HS]Topics are not appearing in the related content section of a document on Firefox
  @bug
  Scenario Outline: Links to related Topics within Topic section of documents related content
    Given PL+ user is logged in
    When the user runs a free text search for the query "<query>"
    And the user opens the result in position "1"
    Then the user verifies the presence of the Topics heading in Related Content section
    And the user verifies the presence of a link entitled "<link>"
    And the user validates that the left hand table of contents is displayed
    And the user selects the link entitled "<link>"
    And the user verifies that the topic page entitled "<link>" is displayed to the user
  Examples:
    | query                     | link                  |
    | Overview of cybersecurity | Internet              |
    | Waste offences            | Waste                 |
    | Consumer credit resources | Consumer Credit       |
   