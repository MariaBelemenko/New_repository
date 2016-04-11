Feature: Searching, adding and deleting a good from the cart
  Customer wants to check, that a good, he had chosen, was correctly added and then deleted from the cart

#   Scenario: Searching for a Good
#    Given The user sets language to English
#    And  he enters "iPhone s6" in the searching field
#    When he presses a button 'Search'
#    Then ensure "Luxury Aluminum Ultra-thin Mirror Metal Case Cover for iPhone 5/ 5s/ 6/ 6+ Plus" has been searched correctly


#  Scenario: Adding the Goods to the Cart
#    Given he presses on an image of the good
#    When he sets good's color to "Black"
#    And he sets good's model to "For Apple iPhone 6"
#    And he sets good's glass screen protector to "No"
#    And he presses a button 'Add to cart'
#    And he presses button 'Cart' to see it's content
#    Then ensure "Luxury Aluminum Ultra-thin Mirror Metal Case Cover for iPhone 5/ 5s/ 6/ 6+ Plus" is in the cart

#  Scenario: Deleting the Good from the Cart
#    Given he presses button 'Save for future'
#    When he edits "MariaBelemenko@gmail.com" into the field 'Login'
#    And he edits "maria311089" into the field 'Password'
#    And he submits his personal information
#    And ensure "Luxury Aluminum Ultra-thin Mirror Metal Case Cover for iPhone 5/ 5s/ 6/ 6+ Plus has been saved for later." has been successfully removed to 'Saved goods'
#    And he presses button 'Delete the good from the cart'
#    And he presses button 'Show the cart'
#    Then ensure "Your shopping cart is empty, but it doesn't have to be." his cart is empty

  Scenario Outline: Searching for a Good
    Given The user sets language to English
    And  he enters "<type>" in the searching field
    When he presses a button 'Search'
    Then ensure "<name>" has been searched correctly

    Examples:
    |     type      |                                     name                                            |
    | iPhone s6     | Luxury Aluminum Ultra-thin Mirror Metal Case Cover for iPhone 5/ 5s/ 6/ 6+ Plus     |

    Scenario Outline: Adding the Goods to the Cart
    Given he presses on an image of the good
    When he sets good's color to "<color>"
    And he sets good's model to "<model>"
    And he sets good's glass screen protector to "<Screen protector>"
    And he presses a button 'Add to cart'
    And he presses button 'Cart' to see it's content
    Then ensure "<name>" is in the cart

     Examples:
       | color  |       model         |   Screen protector      |                                       name                                      |
       | Black  | For Apple iPhone 6  |         No              | Luxury Aluminum Ultra-thin Mirror Metal Case Cover for iPhone 5/ 5s/ 6/ 6+ Plus |
       | Silver | For Apple iPhone 6s |         No              | Luxury Aluminum Ultra-thin Mirror Metal Case Cover for iPhone 5/ 5s/ 6/ 6+ Plus |

  Scenario Outline: Deleting the Good from the Cart
    Given he presses button 'Save for future'
    When he edits "<login>" into the field 'Login'
    And he edits "<password>" into the field 'Password'
    And he submits his personal information
    And ensure "<save for future>" has been successfully removed to 'Saved goods'
    And he presses button 'Delete the good from the cart'
    And he presses button 'Show the cart'
    Then ensure "<cart content>" his cart is empty

    Examples:
       |          login           |  password   |                                         save for future                                                   |cart content |
       | MariaBelemenko@gmail.com | maria311089 | Luxury Aluminum Ultra-thin Mirror Metal Case Cover for iPhone 5/ 5s/ 6/ 6+ Plus has been saved for later. |  US $7.99   |

  Scenario: Searching for a Good (negative scenario)
    Given The user sets language to English
    And  he enters "iPhone s6" in the searching field
    When he presses a button 'Search'
    Then ensure "Luxury Aluminum Ultra-thin Mirror Metal Case Cover for iPhone 5" has not been searched

  Scenario: Adding the Goods to the Cart (negative scenario)
    Given he presses on an image of the good
    When he sets good's color to "Black"
    And he sets good's model to "For Apple iPhone 6"
    And he sets good's glass screen protector to "No"
    And he presses a button 'Add to cart'
    And he presses button 'Cart' to see it's content
    Then ensure "Luxury Aluminum Ultra-thin Mirror Metal Case Cover for iPhone 5" is not in the cart

  Scenario: Deleting the Good from the Cart (negative scenario)
     Given he presses button 'Save for future'
     And ensure "Luxury Aluminum Ultra-thin Mirror Metal Case Cover for iPhone 5/ 5s/ 6/ 6+ Plus has been saved for later." has been successfully removed to 'Saved goods'
     And he presses button 'Delete the good from the cart'
     And he presses button 'Show the cart'
     Then ensure "Your cart is not empty" his cart doesn't consist anything