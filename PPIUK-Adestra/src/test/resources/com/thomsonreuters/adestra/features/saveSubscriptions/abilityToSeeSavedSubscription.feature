Feature: As user i want to see saved subscription
  Adestra BCI Weekly and Monthly subscribtion
  Change incorrect names PL+ to PLC name
  Add new Canada Services

  # do not remove this tag. this tag is to clean all users subcriptions.
  @UsubscribeUserFromAllSubscriptionsAndRemoveUnsubscribeOption
  Scenario Outline: As user i want to see saved subscription
    Given PL+ user is logged in with following details
      | userName | adestra_user33 |
    And a user is viewing the email preference page
    And a user creates subscription to the "<region>" "<corporate>" email service with "<frequency>"
    When a user "adestra_user33@mailinator.com" is has subscription to the "<region>" "<corporate>" email service with "<frequency>"
    And the user has opened the "<region>" Services tab
    Then the user should be presented with "<region>" "<corporate>" services row
    And the "<region>" "<corporate>" services row will display the appropriate "<frequency>" check boxes
    And the "<region>" "<corporate>" check boxes "<frequency>" should be selectable
  Examples:
    | region | corporate                                | frequency |
    | UK     | Business Crime & Investigations          | W,M       |
    | UK     | Data Protection                          | W,M       |
    | UK     | Local government                         | W         |
    | UK     | Public Law                               | W         |
    | US     | Antitrust                                | M         |
    | UK     | Commercial                               | W,M       |
    | UK     | Corporate                                | D,W,M,A   |
    | UK     | Private Client                           | A         |
    | EU     | Competition EU                           | D,W,M     |
    | EU     | EU                                       | W         |
    | EU     | EU regulatory and legislative procedures | A         |
    | Global | Arbitration/International Arbitration    | W,M       |
    | Global | Life Sciences                            | W         |
    | Canada | Capital Markets & Securities             | M         |
    | Canada | Commercial                               | M         |
    | Canada | Employment                               | M         |
    | Canada | Competition                              | M         |
    | Canada | Litigation: Personal Injury              | M         |
