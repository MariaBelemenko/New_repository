
Feature: [URLS001] User can see a KH Document in PL+ by entering PLC document in browser

  Scenario Outline:
    Given PL+ user is logged in
    When the user opens <URL> url on plcuk website
    Then the document opens correctly with PLC Ref
  Examples:
    | URL         |
    | /1-107-4909 |
    | /7-503-7052 |
    | /8-382-6136 |
    | /6-580-7706 |

  Scenario Outline:
    Given PL+ user is logged in
    When the user opens <URL> url on plcuk website
    Then the user is redirected to an error page
  Examples:
    | URL          |
    | /456456      |
    | /abracadabra |

  Scenario Outline:
    Given PL+ user is logged in
    When the user opens <newDocURL> url on plcuk website
    Then the user see title of opened document
    When the user opens <oldDocURL> on the old practical law website
    Then the user see title of opened document
    Then the user should see the same titles on new <newDocURL> and old <oldDocURL> pages
  Examples:
    | newDocURL   | oldDocURL   |
    | /1-107-4909 | /1-107-4909 |
    | /7-503-7052 | /7-503-7052 |
    | /8-382-6136 | /8-382-6136 |
    | /6-580-7706 | /6-580-7706 |
