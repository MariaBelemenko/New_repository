Feature: [764438] Email not linked in a document

  Scenario: Document contains link to emails
    Given PL+ user is logged in with following details
      | routing | RESEARCH_DOC_DISPLAY |
    When the user opens /2-521-5400 url on plcuk website
    Then document contains link to
      | Hyun Soo Doh  |
      | Jae-hong Park |
      | Ryan Russell  |
    Then document doesn't contain link to 'Kim & Chang'
    Then document contains email link to
      | hsdoh@kimchang.com        |
      | jaehong.park@kimchang.com |
      | ryan.russell@kimchang.com |
