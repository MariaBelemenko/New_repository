Feature: [752115] Check all the meta data is displayed on ASK resources

  Scenario: Check correct metadata is displayed for "Ask Resource"
    Given PL+ user is logged in
    When user navigates directly to document with guid "Ie30b7a17ce4611e498db8b09b4f043e0"
    Then ask disclaimer is displayed on the document
    And document title is displayed as "Does TUPE apply to a child employed by a local news agent to do newspaper rounds?"
    And author name "Anonymous" is displayed underneath the document title
    And resource status "Date published\n19 March 2015" is displayed on the document right hand panel
    And following jurisdictions are displayed on the document right hand panel
      | England  |
      | Scotland |
      | Wales    |
    And 'Ask a question' link is displayed
    And 'Related Content' link is displayed on the right hand panel
    And 'View Resource History' link is Not displayed on the right hand panel
    And resource type is displayed as "Ask" on right hand panel
    And plc reference is displayed as "A-015-4204"
