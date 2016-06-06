Feature: As a user,I want to see the "Country Toggle Drop-down" links according to the design with respective links
[Bug 893363]Link to PL Australia is missing in regions dropdown.
#uncomment after QED deploy 15 June
  Scenario: User verifies the "Country Toggle Drop-down" links and styling
    Given PL+ user is logged in
    When user hovers over the country toggle dropdown
    Then user should be seeing the following countries with respective links
      | Country 	| Link                                                                                                                    |
      | UK      	| http://uk.practicallaw.demo.thomsonreuters.com/                                                                         |
      | US      	| https://uk.practicallaw.demo.thomsonreuters.com/PLCTransfer.html?domainKey=PLCUS                                        |
      | China		| http://uk.practicallaw.demo.thomsonreuters.com/Browse/Home/Global/China?transitionType=Default&contextData=(sc.Default) |
 #     | Australia  	| http://au.practicallaw.demo.thomsonreuters.com/     																	  |
      | Canada  	| http://ca.practicallaw.com/                                                                                             |
      | Global  	| http://uk.practicallaw.demo.thomsonreuters.com/Browse/Home/Global?transitionType=Default&contextData=(sc.Default)       |
 #   Then the order in the drop down should be:
 #     | UK      		|
 #     | US      		|
 #     | China			|
 #     | Australia  	|
 #     | Canada  		|
 #     | Global  		|