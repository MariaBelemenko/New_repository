Feature: As a PL+ User I want to view hardcoded and celex links on the primary source page
  As a PL+ User I want to see and link to www.justice.gov.uk
  As a PL+ User I want to see and link to justice.gov.uk and to europa.eu and to app.westlawchina.com

  Background:
    Given PL+ user is logged in

  Scenario Outline: The primary source documents contains hardcoded links
    When the user opens document with <GUID> guid
    Then the user click on View Document button
    Then the document opens correctly
    Then the user sees the "http://www.justice.gov.uk" link
    When the user clicks on this "http://www.justice.gov.uk" link
    Then the user is taken to "http://www.justice.gov.uk" resource
  Examples:
    | GUID                              |
    | I8127783d52a011e598dc8b09b4f043e0 |
    | I0cacf9b465a511e598dc8b09b4f043e0 |

  Scenario Outline: The primary source documents contains celex links
    When the user opens document with <GUID> guid
    Then the user click on View Document button
    Then the document opens correctly
    Then the user see celex links "EUR-Lex"
    When the user click on celex link "EUR-Lex"
    Then the user is taken to "http://eur-lex.europa.eu" resource
  Examples:
    | GUID                              |
    | I73bd1d085abd11e598dc8b09b4f043e0 |

  Scenario Outline: The primary source documents contains link to justice.gov.uk and to europa.eu
    When the user opens document with <GUID> guid
    Then the user click on View Document button
    Then the document opens correctly
    Then the user sees the "<link>" link
    When the user clicks on this "<link>" link
    Then the user is taken to "<link>" resource
  Examples:
    | GUID                              | link                      |
    | I8127783d52a011e598dc8b09b4f043e0 | http://www.justice.gov.uk |
    | I662636bb63a911e598dc8b09b4f043e0 | europa.eu                 |

  Scenario Outline: The primary source documents contains link to Westlawchina.com
    When the user opens document with <GUID> guid
    Then the user click on View Document button
    Then the document opens correctly
    Then the user sees the "Westlawchina.com" link
    When the user clicks on this "Westlawchina.com" link
    Then the user is taken to "app.westlawchina.com" resource
  Examples:
    | GUID                              |
    | I2f49c89c574211e598dc8b09b4f043e0 |
    | I662636d863a911e598dc8b09b4f043e0 |

  Scenario Outline: The primary source documents contains link and every link opens in a new tab
    When the user opens document with <GUID> guid
    Then the user click on View Document button
    Then the document opens correctly
    Then the user sees the "Westlaw UK" link
    When the user clicks on this "Westlaw UK" link
    Then the user go back to previous window
    Then the user sees the "Legislation.gov.uk" link
    When the user clicks on this "Legislation.gov.uk" link
    Then the user go back to previous window
    Then the user sees the "http://www.justice.gov.uk" link
    When the user clicks on this "http://www.justice.gov.uk" link
    And the number of open tabs equals "4"
  Examples:
    | GUID                              |
    | I8127783d52a011e598dc8b09b4f043e0 |
