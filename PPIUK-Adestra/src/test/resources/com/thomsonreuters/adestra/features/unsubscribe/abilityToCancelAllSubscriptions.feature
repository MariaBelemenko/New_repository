Feature: As user i want to cancel subscription
  Adestra BCI Weekly and Monthly subscribtion
  Change incorrect names PL+ to PLC name
  Add new Canada Services

  @UsubscribeUserFromAllSubscriptionsAndRemoveUnsubscribeOption
  Scenario Outline: As user i want to cancel all subscription
    Given PL+ user is logged in with following details
      | userName | adestra_user11 |
    Given a user is viewing the email preference page
    Given a user creates subscription to the "<region>" "<corporate>" email service with "<frequency>"
    Given a user "adestra_user11@mailinator.com" has already subscribed to the "<corporate>" "<frequency>" email service "<region>"
    When the user checks the 'Yes' box in the Unsubscribe All section
    And the user clicks the 'Save preference' button
    Then the user "adestra_user11@mailinator.com" should be unsubscribed from all email services
    And all email service check boxes on the preference page should be unchecked
  Examples:
    | region | corporate                                | frequency |
    | UK     | Business Crime & Investigations          | W,M       |
    | UK     | Data Protection                          | W,M       |
    | UK     | Local government                         | W         |
    | UK     | Public Law                               | W         |
    | UK     | Corporate                                | D,W,M,A   |
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
