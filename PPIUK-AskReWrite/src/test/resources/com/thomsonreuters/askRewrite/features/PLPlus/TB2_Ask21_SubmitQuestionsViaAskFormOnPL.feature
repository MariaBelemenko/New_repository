@wip
Feature: Ask-21 - submit questions to Practical Law via the Ask form on the PL website

As any external user
I can submit questions to Practical Law via the Ask form on the PL website (potentially legacy and PL+)

  Scenario: submitted via legacy PL.com by a logged in user (including IP authenticated)

    Given a user logs into PLwebsite with the below credentials
    |askrewritepluser2|Password2|d102 one pass user|
    Given a logged in user has filled out the Ask form correctly on PL+
    When they submit the form
    Then a new question is created in the Ask Editorial System
    Then it includes all data submitted on the form (and other data passed by the mediator)
    Then It has a status of "not started"
    Then and will appear on the relevant dashboard for practice area -diff requirement though

  Scenario: submitted via legacy PL.com by an IP authenticated user


    Given a logged in user has filled out the Ask form correctly on PL+
      |askrewritepluser3|my machine- 10.222.8.137|
    When they submit the form
    Then a new question is created in the Ask Editorial System
    Then it includes all data submitted on the form (and other data passed by the mediator)
    Then It has a status of "not started"
    Then and will appear on the relevant dashboard for practice area -diff requirement though

  Scenario: submitted via legacy PL.com by a non-logged in user

    Given a user has filled out the Ask form
    And they're not logged
    Then a new question is created in the Ask Editorial System
    Then it includes all data submitted on the form (and other data passed by the mediator)
    Then It has a status of "not started"
    Then and will be sent to Customer Support rather than a practice area
