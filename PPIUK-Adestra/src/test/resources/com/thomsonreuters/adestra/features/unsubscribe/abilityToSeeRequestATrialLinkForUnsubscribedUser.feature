Feature: As an unsubscribed user i want to use a 'Request a trial' link
  Adestra BCI Weekly and Monthly subscribtion
  Change incorrect names PL+ to PLC name
  Add new Canada Services

  Scenario Outline: As an user without subscription to Practice Area content i want to use a 'Request a trial' link.
    Given PL+ user is logged in with following details
      | userName | adestra_user44 |
    Given a user "adestra_user44@mailinator.com" does not have subscription to the "<service>" practice area "<region>" content
    When the user navigates to the email preference page
    Then the user should be presented with their "<service>" email "<region>" service
    And the "<service>" "<region>" services row will display the appropriate frequency check boxes
    And the "<service>" "<region>" check boxes will be uncheckable
    And the user should be presented with a 'Request a trial' link on the "<service>" row "<region>"
  Examples:
    | region | service                                                                                                                                                      |
    | US     | Antitrust,Arbitration: International,Commercial,Finance,Litigation                                                                                           |
    | UK     | Commercial, Competition UK, Financial Services 12pm alert,IP&IT,Media & Telecoms,Business Crime & Investigations,Data Protection,Local government,Public Law |
    | EU     | Competition EU, EU, EU aviation and airports                                                                                                                 |
    | Global | Arbitration/International Arbitration, Competition multi-jurisdictional,Life Sciences                                                                        |
    | Canada | Capital Markets & Securities, Corporate and M&A,Competition,Litigation: Personal Injury,Commercial,Employment                                                |