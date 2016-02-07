Feature: [742387] When a user clicks on a KH Document link, the URL in the browser displays the PLC Ref type URL (X-XXX-XXX)

  Scenario Outline: Correct PLC Reference is displayed in the browser
    Given PL+ user is logged in
    When the user opens <URL> url on plcuk website
    Then current url contain PLC Ref
    Then all links to KH Documents with PLC Ref on the page takes user to page with PLCRef
  Examples:
    | URL         |
    | /1-107-4909 |
    | /8-382-6136 |
    | /6-580-7706 |
