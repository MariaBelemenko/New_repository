Feature: [818592] As a PL+ User I want to see applied css styles in asset pages

  Background:
    Given PL+ user is logged in

  Scenario Outline: [818592] The asset pages have css styles
    When the user opens document with <GUID> guid
    Then the document opens correctly
    Then the bullets have "disc" style
    Then the double lines have "double" style
    And the spacing between double lines and links have "20px" size
    And the "<link>" has font size "16px"
  Examples:
    | GUID                              | link                      |
    | I6905aad063a911e598dc8b09b4f043e0 | Legislation.gov.uk        |
    | Ib29e0159660011e598dc8b09b4f043e0 | Schedule 4, The Companies |
    | I73bd1d085abd11e598dc8b09b4f043e0 | EUR-Lex                   |
    | I8127783d52a011e598dc8b09b4f043e0 | http://www.justice.gov.uk |

  Scenario Outline: [818592] The show more link located on the right side
    When the user opens document with <GUID> guid
    Then the document opens correctly
    Then the user see "Content referring to this primary source" jump link in the left hand side navigation panel
    When the user clicks on "Content referring to this primary source" jump link
    When the user scrolled to the bottom of the document
    Then the user sees Show more "Show more..." link
    And this link located on the "right" side
  Examples:
    | GUID                              |
    | I35a6e3dd53d011e498db8b09b4f043e0 |

  Scenario Outline: [825949] The headers of section have correct font size
    When the user opens document with <GUID> guid
    Then the document opens correctly
    And the "<header>" displayed on the document
    And the "<header>" header has "21px" font size
  Examples:
    | GUID                              | header                                   |
    | I3890f315651511e598dc8b09b4f043e0 | Specific provision coverage              |
    | I73bd1d085abd11e598dc8b09b4f043e0 | Content referring to this primary source |
    | I8127783d52a011e598dc8b09b4f043e0 | Links to this primary source             |

  Scenario Outline: [825954] The bullets near links have correct font size
    When the user opens document with <GUID> guid
    Then the document opens correctly
    And near the "<reference>" bullet have "16px" font size
  Examples:
    | GUID                              | reference                      |
    | I3890f315651511e598dc8b09b4f043e0 | Legislation.gov.uk             |
    | I73bd1d085abd11e598dc8b09b4f043e0 | Competition regime: State aids |
    | I8127783d52a011e598dc8b09b4f043e0 | http://www.justice.gov.uk      |
