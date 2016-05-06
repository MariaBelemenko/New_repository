@wip
Feature: Ask-21 - submit questions to the new Ask system via the Ask form on the PL+ website

As any external user
I can submit questions to Practical Law Plus via the Ask form on the PL+ website

  Scenario: Ask question submitted via PL+ by a logged in autosingle user
    Given PL+ user is logged in with following details
      | userName   | AskrewritePPIuser1 |
    When the user clicks on 'Ask a question' link to ask a question
    And ASK form is displayed in new window
    And the user accepts ASK disclaimer terms
    Then the following ASK form fields are pre-populated
      | First Name |
      | Last Name  |
      | Email      |
    And user completes the following ASK form fields
      | Question          | Test Question from Automation Script |
      | Organisation Type | Public Sector                        |
      | Position          | Solicitor                            |
      | Jurisdiction      | UK                                   |
      | Answering Service | Arbitration                          |
    And user submits the ASK form
    And A thank you page should appear with option to close the window
    Then a new question is created in the Ask Editorial System
    And it includes all data submitted on the form (and other data passed by the mediator)
    And It has a status of "not started"
    And and will appear on the relevant dashboard for practice area -diff requirement though

  @manual
  Scenario: submitted via PL+ by a logged in with IP authenticated user

    Given a user connects to Ip machine with these details
    | VM IP: 10.52.204.139:3389| cloud | Password1! |
    And has filled out the Ask form correctly on PL+
    When they submit the form
    Then a new question is created in the Ask Editorial System
    Then it includes all data submitted on the form (and other data passed by the mediator)
    Then It has a status of "not started"
    Then and will appear on the relevant dashboard for practice area -diff requirement though

  @manual
  Scenario: Ask form Submitted via PL+ by a nonlogged in user or openwebuser
      Given PL+ user is not logged in
      And the user navigates to the main PLCUK page
      When the user clicks on 'Ask a question' link to ask a question
      And ASK form is displayed in new window
      And the user accepts ASK disclaimer terms
      And I enter the following values on ASK form
      | agreeToDisclaimerTerms | TRUE                               |
      | firstName              | Rakesh                             |
      | lastName               | Avasarala                          |
      | Email                  | rakesh.avasarla@thomsonreuters.com |
      | organisationType       | Public Sector                      |
      | position               | Solicitor                          |
      | jurisdiction           | UK                                 |
      | answeringService       | Arbitration                        |
    And I enter the correct CAPTCH value
    And submit the ASK form
    Then ASK form is successfully submitted
    And A thank you page should appear with option to close the window
    And clicking on 'close window' button should close the window
    Then a new question is created in the Ask Editorial System
    And it includes all data submitted on the form (and other data passed by the mediator)
    And It has a status of 'not started'
    And and will be sent to Customer Support rather than a practice area

