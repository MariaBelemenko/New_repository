Feature: As a PL+ User I want to view links to�Legislation.gov.uk on the primary source page

  Scenario Outline: The primary source documents contains links to�Legislation
    Given PL+ user is logged in with following details
      | userName | Asset_page_one |
    When the user opens document with <GUID> guid
    Then the user click on View Document button
    Then the document opens correctly
    Then the user see links to "Legislation.gov.uk" Legislation
    When the user click on "Legislation.gov.uk" Legislation link
    Then the user is taken to "legislation.gov.uk" resource
  Examples:
    | GUID                              |
    | I8127783d52a011e598dc8b09b4f043e0 |