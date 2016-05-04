
Feature: Ask-23 Data migration

  Scenario: Verify that the QUESTION table has the sample PLCref records

    Given a user connects to the Ask Database
    When queries for the PLCreference Then a record should appear
    |PLCreference|
    |a-013-5123  |
    |a-016-9338  |
    |a-001-5769  |
    |1-517-9054  |
    #|a-022-2695  | This data is not in CI DB as export is onl;y until OCT 2015.
    #|a-022-2791  |This data is not in CI DB


  Scenario: Verify that the TEXT filed is not null for in the SUBMISSION_DATA table

    Given a user connects to the Ask Database
    When queries for the PLCreference Then the TEXT field should not be null
      |PLCreference|
      |a-013-5123  |
      |a-016-9338  |
      |a-001-5769  |
      |1-517-9054  |
    #  |a-022-2695  |This data is not in CI DB
     # |a-022-2791  |This data is not in CI DB

  Scenario: Verify that the EMAIL filed is equal in the SUBMISSION_DATA table and the SUBSCRIBER table

    Given a user connects to the Ask Database
    When queries for the Email Then the Email field should not be null
      |PLCreference|
      |a-013-5123  |
      |a-016-9338  |
      |a-001-5769  |
      |1-517-9054  |
  #1) EMAIL fields are not equal for 1-517-9054. SUBMISSION_DATA Email : lwaugh@northernrock.co.uk. SUBSCRIBER Email : clare.henderson@burges-salmon.com

  Scenario: Verify that the FIRSTNAME filed is equal in the SUBMISSION_DATA table and the SUBSCRIBER table

    Given a user connects to the Ask Database
    When queries for the FirstName Then the FirstName field should not be null
      |PLCreference|
      |a-013-5123  |
      |a-016-9338  |
      |a-001-5769  |
      |1-517-9054  |
    #1) FIRST_NAME fields are not equal for 1-517-9054. SUBMISSION_DATA FIRST_NAME : Louise Waugh. SUBSCRIBER FIRST_NAME : Clare Henderson

  Scenario: Verify that the LASTNAME filed is equal in the SUBMISSION_DATA table and the SUBSCRIBER table

    Given a user connects to the Ask Database
    When queries for the LastName Then the LastName field should not be null
      |PLCreference|
      |a-013-5123  |
      |a-016-9338  |

  @raddata
  Scenario: Verify the QUESTION_CATEGORY filed in the QUESTION table

    Given a user connects to the Ask Database
    When queries for the QuestionCategory Then the QuestionCategory field should match the Value
      |PLCreference|Value|
      |a-013-5123  |Substantive Query|
      |a-016-9338  |Substantive Query|
      |a-001-5769  |             |
      |1-517-9054  |             |

    @WIP
  Scenario: Verify the QUESTION_SOURCE filed in the QUESTION table

    Given a user connects to the Ask Database
    When queries for the QuestionSource Then the QuestionSource field should match the Value
      |PLCreference|Value|
      |a-013-5123  ||
      |a-016-9338  ||
      |a-001-5769  ||
      |1-517-9054  ||