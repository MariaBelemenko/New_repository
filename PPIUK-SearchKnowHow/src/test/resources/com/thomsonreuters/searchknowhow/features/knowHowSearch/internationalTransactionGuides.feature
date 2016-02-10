Feature:[803245] internationalTransactionGuides.feature

  Background: Log on
    Given PL+ user is logged in with following details
      | userName | Search1_AutoUser |

  Scenario: verify list of questions displayed to user when topic selected
    Given a user is on the ITG tool
    And the user is presented with the Select a Topic section
    When the user selects a topic "Sponsorship"
    Then the user should be presented with a list of questions including "What action lies for using an individual’s name or image without consent"

  Scenario: verify list of jurisdictions displayed to user when questions selected
    Given a user is presented with the Select a Question section including "What action lies for using an individual’s name or image without consent"
    When the user selects checkboxes for the questions "What action lies for using an individual’s name or image without consent" and "Does an intellectual property right or any other proprietary right exist in an event"
    And the user clicks the Select Jurisdiction button
    Then the user should be presented with a list of jurisdictions including "China"

  Scenario: verify comparison report displayed to user when compare option selected
    Given a user is on the select Jurisdiction section having selected "Sponsorship" as the topic and "What action lies for using an individual’s name or image without consent" and "Does an intellectual property right or any other proprietary right exist in an event" as the questions
    When the user selects the jurisdictions "China" and "France"
    And the user clicks the Compare button
    Then the user should be presented with a comparison report which includes information based on the users selected topic the questions "What action lies for using an individual’s name or image without consent" and "Does an intellectual property right or any other proprietary right exist in an event" and the jurisdictions "China" and "France"

  Scenario: verify contents of comparison report
    Given a user is on the comparison report page which includes information based on the user having selected "Sponsorship" as the topic along with the questions "What action lies for using an individual’s name or image without consent" and "Does an intellectual property right or any other proprietary right exist in an event" and the jurisdictions "China" and "France"
    Then the user should be able to select the jurisdiction "France" to view
    And the user should be able to scroll through the selected questions "What action lies for using an individual’s name or image without consent" and "Does an intellectual property right or any other proprietary right exist in an event"
