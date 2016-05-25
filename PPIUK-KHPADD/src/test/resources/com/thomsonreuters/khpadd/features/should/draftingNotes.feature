@should
Feature: [867665][863530][878470] drafting notes should bugs
[867665]anchor linking from a document to an IDN when using new tab/window is not working,
[863530]Standard docs and clauses - drafting notes need to remain sticky
[878470]Jumplinks-Related Content bar hides the jumplink in document after clicking
		
@bug
  Scenario Outline: Open drafting note in new tab
    Given PL+ user is logged in
    When user navigates directly to document with guid "<guid>"
    And clicks on the Show/Hide Drafting Notes option on the delivery toolbar
    And user clicks on the 'Show All' option
    Then user opens link "<link>" in new tab
    And user verifies if page is scrolled to drafting notes with title "<text>"
    #bug 878470 -Jumplinks-Related Content bar hides the jumplink in document after clicking
    And user verifies if sticky bar doesn't hide the target link "<anchor>"
    And user closes opened window  
  Examples:
    |guid								|link							|text									|anchor |
    |I33f105f1e8cd11e398db8b09b4f043e0	|Drafting note, Clause 2.1	 	|Assignment of Construction Documents	|a967852|


  Scenario Outline: drafting notes need to remain sticky
    Given PL+ user is logged in
    When user navigates directly to document with guid "<guid>"
    And clicks on the Show/Hide Drafting Notes option on the delivery toolbar
    And user clicks on the 'Show All' option
    And user scrolls and clicks on link "<link>" 
    Then the user clicks Back button in browser
    And user verifies if page is scrolled to link "<link>"
  Examples:
    |guid								|link			|
    |I33f153b4e8cd11e398db8b09b4f043e0	|section 112	|    
    
@bug
  Scenario Outline: [878470]Jumplinks-Related Content bar hides the jumplink in document after clicking
    Given PL+ user is logged in
    When user navigates directly to document with guid "<guid>"
    And clicks on the Show/Hide Drafting Notes option on the delivery toolbar
    And user clicks on the 'Show All' option
    And user scrolls and clicks on link "<link>" 
    And user verifies if sticky bar doesn't hide the target link "<anchor>"
  Examples:
    |guid								|link			|anchor |
    |I33f12c0ce8cd11e398db8b09b4f043e0	|Paragraph 3.1	|a984323|     
    