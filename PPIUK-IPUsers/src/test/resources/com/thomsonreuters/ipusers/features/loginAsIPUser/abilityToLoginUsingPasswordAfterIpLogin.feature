@ip
Feature: [752710]  LI016 - IP can log in as username and password

  #do not remove this tag. it is an after step to sign off from username\password user and became IP user again
  @signOffFromUsernameAndPasswordUserToBecameIPUser
  Scenario: [752710] As an IP user I want to have the option of log in as a username and password user so I can use personalisation and collaboration features.
    Given PL+ user is logged in with following details
      | loginRequired | NO |
    When the user clicks on Sign in with a Different Account link on the header
    And a PPI user enter its username and password
      | userName | IPAPuser |
    And clicks on Sign in
    Then the user is able to see default client id "PRACTICAL LAW UK"
