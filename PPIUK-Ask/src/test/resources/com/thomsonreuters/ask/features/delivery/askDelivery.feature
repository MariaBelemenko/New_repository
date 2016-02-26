@wip @robot
Feature: [752399,755564,755565,752398] Ask Widget to download/email/print query-
  As a: User
  I want: to save/send query
  So that: that I can have a copy of the query to see offline

  Background:
    Given PL+ user is logged in

  Scenario Outline: Download - Microsoft Word
    And user navigates directly to document with guid "<guid>"
    And the user deletes all files with name "<name>" and extension ".doc" from Downloads
    And clicks on Download delivery option for the document
    And the user edits the basic download options as follows
      | Format | Microsoft Word |
    Then user downloads the document with name "<name>" and extension ".doc"
  Examples:
    | guid                              | name                                  |
    | I0afac67b78a211e598dc8b09b4f043e0 | Can you surrender an AHA 1986 tenancy |

  Scenario Outline: Download - RTF format
    And user navigates directly to document with guid "<guid>"
    And the user deletes all files with name "<name>" and extension ".rtf" from Downloads
    And clicks on Download delivery option for the document
    And the user edits the basic download options as follows
      | Format | Word Processor (RTF) |
    Then user downloads the document with name "<name>" and extension ".rtf"
  Examples:
    | guid                              | name                                            |
    | I17699cb5741511e598dc8b09b4f043e0 | Do overage rights have a value for IHT purposes |

  Scenario Outline: Download - PDF format
    And user navigates directly to document with guid "<guid>"
    And the user deletes all files with name "<name>" and extension ".pdf" from Downloads
    And clicks on Download delivery option for the document
    And the user edits the basic download options as follows
      | Format | PDF |
    Then user downloads the document with name "<name>" and extension ".pdf"
  Examples:
    | guid                              | name                                                                             |
    | I389320b81c6811e598db8b09b4f043e0 | Distributions should directors have regard to performance subsequent to the last |

  Scenario Outline: Email - MS Word format
    And user navigates directly to document with guid "<guid>"
    And clicks on email delivery option for the document
    Then the user should be able to see Email basic tab options as follows
      | Subject | <subject> |
    When the user edits the basic download options as follows
      | To     | <mailbox>      |
      | Format | Microsoft Word |
    And Email button is clicked
    Then user receives an email at "<mailbox>" with document in Microsoft Word format and with subject "<subject>"
  Examples:
    | guid                              | subject                                                | mailbox                   |
    | I0afac67b78a211e598dc8b09b4f043e0 | Practical Law - Can you surrender an AHA 1986 tenancy? | tr-anz-tester1@yandex.com |

  Scenario Outline: Email document - RTF format
    And user navigates directly to document with guid "<guid>"
    And clicks on email delivery option for the document
    Then the user should be able to see Email basic tab options as follows
      | Subject | <subject> |
    When the user edits the basic download options as follows
      | Format | Word Processor (RTF) |
      | To     | <mailbox>            |
    And Email button is clicked
    And user receives an email at "<mailbox>" with document in Word Processor (RTF) format and with subject "<subject>"
  Examples:
    | guid                              | subject                                                          | mailbox                   |
    | I17699cb5741511e598dc8b09b4f043e0 | Practical Law - Do overage rights have a value for IHT purposes? | tr-anz-tester1@yandex.com |

  Scenario Outline: Email document - PDF format
    And user navigates directly to document with guid "<guid>"
    And clicks on email delivery option for the document
    Then the user should be able to see Email basic tab options as follows
      | Subject | <subject> |
    When the user edits the basic download options as follows
      | Format | PDF       |
      | To     | <mailbox> |
    And Email button is clicked
    Then user receives an email at "<mailbox>" with document in PDF format and with subject "<subject>"
  Examples:
    | guid                              | subject                                                                                                          | mailbox                   |
    | I389320b81c6811e598db8b09b4f043e0 | Practical Law - Distributions: should directors have regard to performance subsequent to the last accounts date? | tr-anz-tester1@yandex.com |

  Scenario Outline: Print
    And user navigates directly to document with guid "<guid>"
    And the user deletes all files with name "Print" and extension ".pdf" from Downloads
    And clicks on Print delivery option for the document
    Then user prints the document with name "Print" and extension ".pdf"
  Examples:
    | guid                              | name                                                                             |
    | I389320b81c6811e598db8b09b4f043e0 | Distributions should directors have regard to performance subsequent to the last |
