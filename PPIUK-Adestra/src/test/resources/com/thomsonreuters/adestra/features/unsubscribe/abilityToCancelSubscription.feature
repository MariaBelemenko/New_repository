Feature: As user i want to cancel subscription
  Adestra BCI Weekly and Monthly subscribtion
  Change incorrect names PL+ to PLC name
  Add new Canada Services

  @UsubscribeUserFromAllSubscriptionsAndRemoveUnsubscribeOption
  Scenario Outline: As user i want to cancel specified subscription
    Given PL+ user is logged in with following details
      | userName | adestra_user11 |
    Given a user is viewing the email preference page
    Given a user creates subscription to the "<region>" "<corporate>" email service with "<frequency>"
    Given a user "adestra_user11@mailinator.com" has already subscribed to the "<corporate>" "<frequency>" email service "<region>"
    When the user unchecks "<region>" the "<unsubscribe_frequency>" "<corporate>" email check box
    And the user clicks the 'Save preference' button
    Then the users "adestra_user11@mailinator.com" saved subscription preferences should be saved in Adestra
    And the user should be unsubscribed from the "<region>" email service "<corporate>" "<unsubscribe_frequency>"
  Examples:
    | region | corporate                                | frequency | unsubscribe_frequency |
    | UK     | Business Crime & Investigations          | W,M       | M                     |
    | UK     | Data Protection                          | W,M       | W,M                   |
    | UK     | Local government                         | W         | W                     |
    | UK     | Public Law                               | W         | W                     |
    | UK     | Corporate                                | D,W,M,A   | D,W                   |
    | US     | Antitrust                                | M         | M                     |
    | UK     | Commercial                               | W,M       | W                     |
    | UK     | Corporate                                | D,W,M,A   | M,A                   |
    | UK     | Private Client                           | A         | A                     |
    | EU     | Competition EU                           | D,W,M     | D,W,M                 |
    | EU     | EU                                       | W         | W                     |
    | EU     | EU regulatory and legislative procedures | A         | A                     |
    | Global | Arbitration/International Arbitration    | W,M       | M                     |
    | Global | Life Sciences                            | W         | W                     |
    | Canada | Capital Markets & Securities             | M         | M                     |
    | Canada | Commercial                               | M         | M                     |
    | Canada | Employment                               | M         | M                     |
    | Canada | Competition                              | M         | M                     |
    | Canada | Litigation: Personal Injury              | M         | M                     |
