Feature: When 2+ year old ASK resource or deleted ask resourced is accessed, appropriate error message is displayed
  As a user
  I want to see appropriate error message while accessing 2+ year old ASK resource or deleted ASK resource
  So that I can get access only to latest ASK resource only

  Scenario: As a logged in user, verify error message displayed while accessing 2+ year old ASK resource
    Given PL+ user is logged in with following details
      | userName | AskTestuser |
    When the user is in Page '/0-522-1826'
    Then the user verifies that ask error message displayed contains 'Content not available\nContent is out of date and has been removed from the site'

  Scenario Outline: As a logged in user,verify error message is NOT displayed while accessing 2+ year old ASK resource, that has been  re-published
    Given PL+ user is logged in with following details
      | userName | AskTestuser |
    When the user is in Page '<Page>'
    Then the user verifies that ask error message displayed does NOT contains 'Content not available\nContent is out of date and has been removed from the site'
  Examples:
    | Page        |
    | /2-525-2464 |
    | /0-525-8443 |

  Scenario Outline: As a logged in user,verify error message displayed while accessing deleted ASK resource
    Given PL+ user is logged in with following details
      | userName | AskTestuser |
    When the user is in Page '<Page>'
    Then the user verifies that ask error message displayed contains 'Content not available\nContent has been removed from the site'
  Examples:
    | Page        |
    | /0-520-2998 |
    | /3-520-3166 |

  Scenario: As anonymous user, verify error message displayed while accessing 2+ year old ASK resource
    Given PL+ user is not logged in
    When the user is in Page '/0-522-1826'
    Then the user verifies that ask error message displayed contains 'Content not available\nContent is out of date and has been removed from the site'

  Scenario Outline: As a logged in user,verify error message displayed while accessing 2 or less years old ASK resource, that has been removed by moderator
    Given PL+ user is logged in with following details
      | userName | AskTestuser |
    When the user is in Page '<Page>'
    Then the user verifies that ask error message displayed contains 'Content not available\nContent has been removed from the site'
  Examples:
    | Page        |
    | /0-515-1852 |
    | /0-516-0328 |

  Scenario Outline: As anonymous user,verify error message displayed while accessing 2 or less years old ASK resource, that has been removed by moderator
    Given PL+ user is not logged in
    When the user is in Page '<Page>'
    Then the user verifies that ask error message displayed contains 'Content not available\nContent has been removed from the site'
  Examples:
    | Page        |
    | /0-515-1852 |
    | /0-516-0328 |
