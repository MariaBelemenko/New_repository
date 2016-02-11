Feature: [764438] Email not linked in a document

  Scenario: Document contains link to emails
    Given PL+ user is logged in with following details
      | routing | RESEARCH_DOC_DISPLAY |
    When the user opens /2-521-5400 url on plcuk website
    Then document contains link to 'Hyun Soo Doh'
    Then document contains link to 'Jae-hong Park'
    Then document contains link to 'Ryan Russell'
    Then document doesn't contain link to 'Kim & Chang'
    Then document contains email link to 'hsdoh@kimchang.com'
    Then document contains email link to 'jaehong.park@kimchang.com'
    Then document contains email link to 'ryan.russell@kimchang.com'
