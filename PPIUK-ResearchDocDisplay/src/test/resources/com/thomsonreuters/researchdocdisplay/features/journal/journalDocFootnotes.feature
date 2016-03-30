Feature: [777596] I want to view notes in Full Text content

  Background:
    Given PL+ user is logged in with following details
      | routing          | ASK |
      | mandatoryRouting | YES |

#TODO create bug when dev phase starts
@bug 
Scenario Outline: [777596] Journal document - the user can go to footnotes section and back to document
 	When the user opens document with <guid> guid 
	Then the document opens correctly 
    And the "Footnotes" section contains footnotes body with numbers
	When the user clicks on footnote link "<fn1>" in document
	Then the user is scrolled to footnote "<fn1>" 
	When the user clicks on footnote link "<fn2>" in the footnotes section
	Then the user is scrolled to footnote link "<fn2>" in document
  Examples:
    | guid		                       	| fn1 | fn2	|
    | I34E2F2309C0711E4ABBBADAAA4F7D653 | 10 	| 12 |
    | I36564230FDB811E4ABD6CBDDF2736E09 | 10 	| 12 |
    | I89CC49B0FA9711E49CDBA95B00781B0C | 10 	| 12 |

Scenario Outline: [777596] Journal document - the user can follow internal link in footnotes section
 	When the user opens document with <guid> guid 
	Then the document opens correctly 
    And the "Footnotes" section contains footnotes body with numbers
	When the user clicks on footnote link "<fn1>" in document
	And the user clicks on link in footnote "<fn1>" body in footnotes section
	Then the document opens correctly
	And document title is displayed as "<linkedDoc>"
  Examples:
    | guid		                       	| fn1 | linkedDoc |
    | I34E2F2309C0711E4ABBBADAAA4F7D653 | 54	|Hollinrake v Truswell|


#links to external resources are not marked correctly yet
@wip
Scenario Outline: [777596] Journal document - the user can follow external link in footnotes section
 	When the user opens document with <guid> guid 
	Then the document opens correctly 
    And the "Footnotes" section contains footnotes body with numbers
	When the user clicks on footnote link "<fn1>" in document
	And the user clicks on link in footnote "<fn1>" body in footnotes section
	Then the source document with guid "<guid>" remains open and new tab opens
	And the user is taken to "<link>" resource
  Examples:
    | guid		                       	| fn1 | link |
    | I34E2F2309C0711E4ABBBADAAA4F7D653 | 36	|http://www.smh.com.au/news/music/gregorian-chant-a-charttopper/2008/03/27/1206207264810.html|

Scenario Outline: [777596] Journal document - the user can follow internal link in lightbox
 	When the user opens document with <guid> guid 
	Then the document opens correctly 
    And the "Footnotes" section contains footnotes body with numbers
    When the mouse moves over "<fn1>" Journal footnote reference
    Then the "Footnote <fn1>" is displayed in the lightbox
    When the user selects a link in light box
	Then the document opens correctly
	And document title is displayed as "<linkedDoc>"
  Examples:
    | guid		                       	| fn1 | linkedDoc |
    | I34E2F2309C0711E4ABBBADAAA4F7D653 | 54	|Hollinrake v Truswell|

#links to external resources are not marked correctly yet
@wip
Scenario Outline: [777596] Journal document - the user can follow external link in lightbox
 	When the user opens document with <guid> guid 
	Then the document opens correctly 
    And the "Footnotes" section contains footnotes body with numbers
    When the mouse moves over "<fn1>" Journal footnote reference
    Then the "Footnote <fn1>" is displayed in the lightbox
    When the user selects a link in light box
	Then the source document with guid "<guid>" remains open and new tab opens
	And the user is taken to "<link>" resource
  Examples:
    | guid		                       	| fn1 | linkedDoc |
    | I34E2F2309C0711E4ABBBADAAA4F7D653 | 36	|http://www.smh.com.au/news/music/gregorian-chant-a-charttopper/2008/03/27/1206207264810.html|
