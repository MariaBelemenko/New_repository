
Feature: Ask-21 - submit questions to the new Ask system via the Ask form on the PL+ website

As any external user
I can submit questions to Practical Law via the Ask form on the PL website (potentially legacy and PL+)

  @rad
  Scenario: Ask question submitted via PL+ by a logged in autosingle user

    #Given IIP has been switched 'OFF'
    Given a logged in user has filled out the Ask form correctly on PL+
    When they submit the form
    Then a new question is created in the Ask Editorial System
    Then it includes all data submitted on the form (and other data passed by the mediator)
    Then It has a status of "not started"
    Then and will appear on the relevant dashboard for practice area -diff requirement though

  Scenario: submitted via PL+ by a logged in with IP authenticated user

    Given a logged in user has filled out the Ask form correctly on PL+
    When they submit the form
    Then a new question is created in the Ask Editorial System
    Then it includes all data submitted on the form (and other data passed by the mediator)
    Then It has a status of "not started"
    Then and will appear on the relevant dashboard for practice area -diff requirement though

  Scenario: submitted via PL+ by a nonlogged in user
  # not sure if this is still possible on PL+
