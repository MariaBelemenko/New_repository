Feature: The ability to use Email delivery option

  Scenario: Select to deliver my selected legal update(s), I want the document to be delivered to my email inbox.
    Given PL+ user is logged in with following details
      | userName | LU_AutoUser |
    Given a user is on a legal updates results page
    And a user has selected the email delivery option
    And the user has configured their options on the email delivery lightbox
    When the user selects the 'Email' button
    Then the user should receive the selected documents in their specified email inbox

  Scenario: Select to deliver my selected legal update(s), I want the document to be delivered to my email inbox.
    Given PL+ user is logged in with following details
      | userName | LU_AutoUser |
    Given a user navigate to a "Insurance" Topic page from a "Construction" Practice Area page
    When the user clicks on the 'View all' link of the LU widget
    And a user has selected the email delivery option
    And the user has configured their options on the email delivery lightbox
    When the user selects the 'Email' button
    Then the user should receive the selected documents in their specified email inbox
