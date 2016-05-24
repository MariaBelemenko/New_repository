@should
Feature: [730589 730956] As a website user,
  I want to see author displayed underneath the document title
  I want to browse to external links within the body of the resource
  So that I can view external websites

  Background:
    Given PL+ user is logged in with following details
      | routing | KH_DOC_DISPLAY |

  @bug
  Scenario Outline: Author name is external link (Regression bug# 807808)
    When user navigates directly to document with guid "<guid>"
    Then author name "<authorName>" is displayed underneath the document title
    And clicking on author link "<authorLink>" opens in new window
  Examples:
    | guid                              | authorName                                                        | authorLink               |
    | Ib55520d8e83211e398db8b09b4f043e0 | by Practical Law Employment with Mathew Purchase, Matrix Chambers | Practical Law Employment |
    | Ib55520d8e83211e398db8b09b4f043e0 | by Practical Law Employment with Mathew Purchase, Matrix Chambers | Mathew Purchase          |

  @bug
  Scenario: Author name is internal link (Bug# 820365)
    When user navigates directly to document with guid "I020627b21cb611e38578f7ccc38dcbee"
    Then author name "by Practical Law Finance and Richard Spedding and Simon Buckingham, Travers Smith LLP" is displayed underneath the document title
    And clicking on author link "Practical Law Finance" opens in same window

  Scenario Outline: Browse to External websites
    When user navigates directly to document with guid "<guid>"
    And clicking on external link "<link>" opens in new window
  Examples:
    | guid                              | link                                                           |
    | Ie5e3dc57900c11e498db8b09b4f043e0 | https://www.gov.uk/government/organisations/hm-revenue-customs |
