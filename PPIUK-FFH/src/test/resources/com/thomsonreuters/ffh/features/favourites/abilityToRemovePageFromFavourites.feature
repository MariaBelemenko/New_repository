@wip
Feature: [834827] As a PPI User I want to be able to remove a page from Favourites 

#@wip need be removed after release (9 may)
Scenario: 
	Given PL+ user is logged in 
	When API cleans all folders and history and user relogs in 
	
Scenario: Remove PA from favourites 
	Given PL+ user is logged in 
	When the user opens 'Commercial' link 
	Then the star icon is hollow 
	And the user adds page to favourites group 'pl1' 
	Then the star icon is filled 
	When the user removes page from favourites group 'pl1' from catagory page 
	Then the star icon is hollow 
	When the user clicks on 'Favourites' link on the header 
	Then the user checks that 'Commercial' link is not in favourites group 'pl1' on Favourites page 
	
Scenario: Remove Topic from favourites 
	Given PL+ user is logged in 
	When the user opens 'IP & IT' link 
	And the user opens 'Designs' link 
	Then the star icon is hollow 
	And the user adds page to favourites group 'pl1' 
	Then the star icon is filled 
	When the user removes page from favourites group 'pl1' from catagory page 
	Then the star icon is hollow 
	When the user clicks on 'Favourites' link on the header 
	Then the user checks that 'Design' link is not in favourites group 'pl1' on Favourites page 