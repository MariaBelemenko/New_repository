Feature: User clicks on a KH Document URL with a PLC Reference in a Document and it takes them to that document.

  Scenario Outline: Correct PLC Reference is displayed and user is taken to the correct document
    Given PL+ user is logged in
    When the user opens <URL> url on plcuk website
    Then current url contain PLC Ref
    Then all links to KH Documents with PLC Ref on the page takes user to correct page
  Examples:
    | URL         |
    | /1-107-4909 |
    | /8-382-6136 |
    | /6-580-7706 |