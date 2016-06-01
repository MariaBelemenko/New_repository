Feature: [888466] As a user I want to see purchase form for a full text article so that I can order an article in desired format. 

# TODO add guid to the last test after 895099 is resolved
# TODO update tests for Org field after 898200 is resolved
# TODO update tests after story about fields validation is resolved

Background: 
	Given PL+ user is logged in with following details 
		| userName	| mtaranchuk_rsr	| 
		#ATTENTION: values below depend on user selection 	

Scenario Outline: [888466] Purchase form - email delivery - checking default values 
	When the user opens document with guid "<guid>" 
	And the user clicks on button with text "Request a copy of the Full Text" within the document
	Then the user should see request form popup with title "Full Text Journal Article Request Form" 
	And the following lines should be present on the request form 
		| To order the full text of the selected article, please verify your details below indicating your chosen method of delivery |
		| Contact Us and Help | 
		| T:01422 888019 | 
		| F:01422 888001 | 
		| E:trluki.admincentral@thomsonreuters.com |
		| I agree that my order is subject to the Terms of Trading available on www.sweetandmaxwell.co.uk |
	And the following fields should have Required marks 
		| Document citation |
		| Name |
		| Organisation |
		| E-mail |
	And the following fields should be prepopulated with values 
		| Document citation	| <citation>	|
		| Name				| <name>		|
#		| Organisation		| <organisation>|
		| E-mail			| <email>		|
	And the following fields should be disabled 
		| Fax	|
		| DX	|
	And the following fields should not be visible 
		| Address 1 |
		| Address 2	|
		| Town/City	|
		| County/State	|
		| Country	|
		|	Postcode	|
	When the user fills in the following fields
		| Organisation	| <organisation> |
	When the user selects preferred delivery method "E-mail" 
	Then the button "Submit" is disabled
	When the user checks the agreement checkbox 
	And the user clicks on button "Submit" 
	Then the user accepts alert with message "Your request has been submitted successfully" 
	And the request form popup disappears 
	And the admins receive an email at "tr-journals-purchase-form@yandex.com" from "<email>" with subject "A new request for Article <title>" with all the proper information 
	Examples: 
		|guid	|title|	citation 	| name	|	organisation	|email	|
		|I4BCDFB300B1411E5A0D59089CFDFCEB1|Swedish IT.|  Tax. 2015, 175(4503), 22 |Mtaranchuk Research | EPAM |mtaranchuk.rsr@yandex.com|
		

Scenario Outline: [888466] Fax delivery - change values
	When the user opens document with guid "<guid>" 
	And the user clicks on button with text "Request a copy of the Full Text" within the document
	Then the user should see request form popup with title "Full Text Journal Article Request Form" 
	When the user selects preferred delivery method "Fax" 
	And the user fills in the following fields
		| Document citation | <citation> |
		| Name | <name> |
		| Organisation | <organisation> | 
		| Telephone | <phone> |
		| E-mail | <email> |
		| Fax | <fax> |
	When the user checks the agreement checkbox 
	And the user clicks on button "Submit" 
	Then the user accepts alert with message "Your request has been submitted successfully" 
	And the request form popup disappears 
	And the admins receive an email at "tr-journals-purchase-form@yandex.com" from "<email>" with subject "A new request for Article <title>" with all the proper information 
	Examples: 
		|guid								| title|	citation 	| name	|	organisation	|  phone	| email	| fax |
		|I1BFB0960A4EF11DF8258C23352F0181D| Bad reception. | Some Citation |Some Name | Some Organisation | 123 45 | some@email.com | Some Fax |

	
Scenario Outline: [888466] DX delivery
	When the user opens document with guid "<guid>" 
	And the user clicks on button with text "Request a copy of the Full Text" within the document
	Then the user should see request form popup with title "Full Text Journal Article Request Form" 
	When the user selects preferred delivery method "DX" 
	And the user fills in the following fields
		| Organisation | <organisation> | 
		| DX | <dx> |
	When the user checks the agreement checkbox 
	And the user clicks on button "Submit" 
	Then the user accepts alert with message "Your request has been submitted successfully" 
	And the request form popup disappears 
	And the admins receive an email at "tr-journals-purchase-form@yandex.com" from "<email>" with subject "A new request for Article <title>" with all the proper information 
	Examples: 
		|guid								|title |	organisation	| dx |email|
		|I1BFB0960A4EF11DF8258C23352F0181D| Bad reception. | Some Organisation | Some DX number |mtaranchuk.rsr@yandex.com|

	
Scenario Outline: [888466] Post delivery
	When the user opens document with guid "<guid>" 
	And the user clicks on button with text "Request a copy of the Full Text" within the document
	Then the user should see request form popup with title "Full Text Journal Article Request Form" 
	When the user selects preferred delivery method "Post" 
	And the user fills in the following fields
		| Organisation | <organisation> | 
		| Address 1 | <a1> |
		| Address 2 | <a2> |
		| Town/City | <town> |
		| County/State | <state> |
		| Country | <country> |
		| Postcode | <postcode> |
	When the user checks the agreement checkbox 
	And the user clicks on button "Submit" 
	Then the user accepts alert with message "Your request has been submitted successfully" 
	And the request form popup disappears 
	And the admins receive an email at "tr-journals-purchase-form@yandex.com" from "<email>" with subject "A new request for Article <title>" with all the proper information 
	Examples: 
		|guid							|	title |	organisation	| a1 |a2 | town | state |country | postcode |email|
		|I1BFB0960A4EF11DF8258C23352F0181D| Bad reception. |  Some Organisation | Some Addr1 |Some Addr2| Some Town |Some State |Some Country |Some Postcode| mtaranchuk.rsr@yandex.com|


Scenario Outline: [888466] Negative: some mandatory field is empty
	When the user opens document with guid "<guid>" 
	And the user clicks on button with text "Request a copy of the Full Text" within the document
	Then the user should see request form popup with title "Full Text Journal Article Request Form" 
	And the user fills in the following fields
		| Organisation | <organisation> | 
	And the user checks the agreement checkbox 
	When the user fills in the following fields
		| <field>	| |
	Then the button "Submit" is disabled
	Examples: 
		|guid								|	field	|
		|I1BFB0960A4EF11DF8258C23352F0181D		| Document citation |
		|I1BFB0960A4EF11DF8258C23352F0181D| Name |
		|I1BFB0960A4EF11DF8258C23352F0181D| Organisation |
		|I1BFB0960A4EF11DF8258C23352F0181D| E-mail |
		
	
Scenario Outline: [888466] Cancel button - yes
	When the user opens document with guid "<guid>" 
	And the user clicks on button with text "Request a copy of the Full Text" within the document
	Then the user should see request form popup with title "Full Text Journal Article Request Form" 
	And the user clicks on button "Cancel" 
	Then the user accepts alert with message "Are you sure you want to cancel this request?" 
	And the request form popup disappears 
	Examples: 
		|guid							|
		|I1BFB0960A4EF11DF8258C23352F0181D|

Scenario Outline: [888466] Close button - no
	When the user opens document with guid "<guid>" 
	And the user clicks on button with text "Request a copy of the Full Text" within the document
	Then the user should see request form popup with title "Full Text Journal Article Request Form" 
	And the user clicks on close button
	Then the user declines alert with message "Are you sure you want to cancel this request?" 
	Then the user should see request form popup with title "Full Text Journal Article Request Form" 
	Examples: 
		|guid							|
		|I1BFB0960A4EF11DF8258C23352F0181D|


Scenario Outline: [888466] Documents without purchase form
	When the user opens document with guid "<guid>" 
	Then the user should not see button with text "Request a copy of the Full Text" within the document
	Examples: 
		|guid							|
		|IAED4F9A0924511E59E5ED34C382BD9CE|
		|I34E2F2309C0711E4ABBBADAAA4F7D653 |
		#TODO add document without full text

